package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Language;
import com.finalyearproject.kode.Entity.Level;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.LanguageRepository;
import com.finalyearproject.kode.Repository.LevelRepository;
import com.finalyearproject.kode.Repository.ParentRepository;
import com.finalyearproject.kode.Service.StudentService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.finalyearproject.kode.Entity.Student;
import com.finalyearproject.kode.Repository.StudentRepository;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/demoStudents")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private StudentService studentService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public @ResponseBody
    String addNewStudent(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String level) {

        Student student = new Student();
        Date date = new Date();
        student.setFirstName(firstName);
        student.setDateOfBirth(date);
        student.setEmail(email);
        student.setLastName(lastName);
        student.setPassword(password);
        student.setDateOfBirth(date);
        Level level1 = levelRepository.findByLevelDescription(level);
        student.setLevel(level1);

        studentRepository.save(student);
        return "Saved";
    }


    @GetMapping(path = "/allStudents")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{studentName}")
    public @ResponseBody
    Student getStudent(@PathVariable("studentName") String firstName) {
        return studentRepository.findByFirstName(firstName);
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "login")
    public @ResponseBody HashMap<String, Object> getStudent(@RequestParam String email,
                                            @RequestParam String password) {
      Student student = studentRepository.findByEmailAndPassword(email, password);
        String jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        HashMap<String, String> students = new HashMap<String, String>();
        students.put("email", student.getEmail());
        students.put("id", String.valueOf(student.getId()));
        students.put("firstName", student.getFirstName());
        students.put("lastName", student.getLastName());
        students.put("password", student.getPassword());
        students.put("webToken", jwtToken);
        HashMap<String, Object> loggedinStudent = new HashMap<String, Object>();
        loggedinStudent.put("user", students);
        return loggedinStudent;







    }

}

