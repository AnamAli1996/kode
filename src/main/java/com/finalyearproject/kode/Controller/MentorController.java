package com.finalyearproject.kode.Controller;

import com.finalyearproject.kode.Entity.Mentor;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.MentorRepository;
import com.finalyearproject.kode.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path="/Mentor")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public @ResponseBody
    String addNewMentor(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String password,
                        @RequestParam int age) {
        Date d = new Date();
        Mentor mentor = new Mentor();
        mentor.setFirstName(firstName);
        mentor.setAge(age);
        mentor.setEmail(email);
        mentor.setLastName(lastName);
        mentor.setPassword(password);

        mentorRepository.save(mentor);
        return "Saved";
    }

    @GetMapping(path = "/allMentors")
    public @ResponseBody
    Iterable<Mentor> getAllMentors() {
        // This returns a JSON or XML with the users
        return mentorRepository.findAll();
    }
}


