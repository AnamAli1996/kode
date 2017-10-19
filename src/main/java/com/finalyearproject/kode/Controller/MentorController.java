package com.finalyearproject.kode.Controller;

import com.finalyearproject.kode.Entity.Mentor;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.MentorRepository;
import com.finalyearproject.kode.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(path="/demoMentors")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewMentor(@RequestParam String name,
                        @RequestParam int age,
                        @RequestParam int yearsExperience) {
        Date d = new Date();
        Mentor mentor = new Mentor();
        mentor.setName(name);
        mentor.setAge(age);
        mentor.setDateJoined(d);
        mentor.setYearsExperience(yearsExperience);

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


