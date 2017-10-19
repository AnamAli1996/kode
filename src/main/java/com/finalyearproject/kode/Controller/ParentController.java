package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Parent;
import com.finalyearproject.kode.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demoParents")
public class ParentController {
    @Autowired
    private ParentRepository parentRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewParent(@RequestParam String parentOne,
                        @RequestParam String parentTwo,
                        @RequestParam String familyName) {
        Parent parent = new Parent();
        parent.setParentOne(parentOne);
        parent.setParentTwo(parentTwo);
        parent.setFamilyName(familyName);
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
