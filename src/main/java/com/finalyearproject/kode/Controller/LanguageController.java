package com.finalyearproject.kode.Controller;

import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Entity.Language;
import com.finalyearproject.kode.Entity.Level;
import com.finalyearproject.kode.Repository.CourseRepository;
import com.finalyearproject.kode.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
    @RequestMapping(path="/demoLanguages")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewLanguage(@RequestParam String description) {
        Language language = new Language();
        language.setLanguageDescription(description);
        languageRepository.save(language);
        return "Saved";
    }

    @GetMapping(path = "/allLanguages")
    public @ResponseBody
    Iterable<Language> getAllLanguages() {
        // This returns a JSON or XML with the users
        return languageRepository.findAll();
    }





}
