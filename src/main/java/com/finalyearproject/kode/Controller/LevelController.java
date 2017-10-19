package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Entity.Level;
import com.finalyearproject.kode.Repository.CourseRepository;
import com.finalyearproject.kode.Repository.LevelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.annotation.XmlType;

@Controller
@RequestMapping(path="/demoLevel")
public class LevelController {
    @Autowired
    private LevelRepository levelRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewLevel(@RequestParam String description) {
        Level level = new Level();
        level.setLevelDescription(description);
        levelRepository.save(level);


        return "Saved";
    }

        @GetMapping(path = "/allLevels")
    public @ResponseBody
    Iterable<Level> getAllLevels() {
        // This returns a JSON or XML with the users
        return levelRepository.findAll();
    }



}


