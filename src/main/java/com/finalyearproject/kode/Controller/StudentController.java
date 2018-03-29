package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.*;
import com.finalyearproject.kode.Repository.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/Student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    static int studentId;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public @ResponseBody
    ResponseEntity addNewStudent(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam int age) {

        Student student = new Student();
        student.setFirstName(firstName);
        student.setAge(age);
        student.setEmail(email);
        student.setLastName(lastName);
        student.setPassword(password);

        HashMap<String, String> errorLogin = new HashMap<>();
        errorLogin.put("global", "This email already exist!");

        HashMap<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("errors", errorLogin);

        String userEmail = student.getEmail();
        Student existingUser = studentRepository.findByEmail(userEmail);

        if (existingUser != null) {
            return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else {
            studentRepository.save(student);
            return new ResponseEntity<Object>("saved", HttpStatus.ACCEPTED);
        }
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

    @RequestMapping(method = RequestMethod.GET, value = "/enrollCourse/{id}")
    public @ResponseBody Student enrollStudent(@PathVariable("id") int courseId){
        Course course = courseRepository.findCoursesById(courseId);
        Student student = studentRepository.findById(studentId);
        student.setCourse(course);
        studentRepository.save(student);
        return student;

    }


}

