package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Mentor;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path="/Parent")
public class ParentController {
    @Autowired
    private ParentRepository parentRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public @ResponseBody
    String addNewParent(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String password,
                        @RequestParam int age) {
        Date d = new Date();
        Parent parent = new Parent();
        parent.setFirstName(firstName);
        parent.setAge(age);
        parent.setEmail(email);
        parent.setLastName(lastName);
        parent.setPassword(password);

        parentRepository.save(parent);
        return "Saved";
    }

    @GetMapping(path = "/allParents")
    public @ResponseBody
    Iterable<Parent> getAllParents() {
        // This returns a JSON or XML with the users
        return parentRepository.findAll();
    }
}
