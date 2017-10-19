package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Language;
import com.finalyearproject.kode.Entity.Level;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.LanguageRepository;
import com.finalyearproject.kode.Repository.LevelRepository;
import com.finalyearproject.kode.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.finalyearproject.kode.Entity.Student;
import com.finalyearproject.kode.Repository.StudentRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path="/demoStudents")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    private LevelRepository levelRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewStudent (@RequestParam String firstName,
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
        System.out.println(level1);

        studentRepository.save(student);
        return "Saved";
    }

    @GetMapping(path="/allStudents")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }


    }

