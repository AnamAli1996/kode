package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Entity.Language;
import com.finalyearproject.kode.Entity.Level;
import com.finalyearproject.kode.Repository.CourseRepository;
import com.finalyearproject.kode.Repository.LanguageRepository;
import com.finalyearproject.kode.Repository.LevelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.server.PathParam;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewCourse(@RequestParam String name,
                        @RequestParam String description,
                        @RequestParam float price,
                        @RequestParam String level,
                        @RequestParam String language) {
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setPrice(price);
        Level level1 = levelRepository.findByLevelDescription(level);
        course.setLevel(level1);
        Language language1 = languageRepository.findByLanguageDescription(language);
        course.setLanguage(language1);
        courseRepository.save(course);


        return "Saved";
    }

    @GetMapping(path = "/allCourse")
    public @ResponseBody
    Iterable<Course> getAllCourses() {
        // This returns a JSON or XML with the users
        return courseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{name}")
    public @ResponseBody int getCourseByName(@PathVariable("name") String name) {
       Course course = courseRepository.findCoursesByName(name);
       return course.getId();
    }

    @CrossOrigin(origins = "http://localhost:3001")
    @RequestMapping(method = RequestMethod.GET, value = "showCourse/{id}")
    public @ResponseBody Course getCourseById(@PathVariable("id") int id) {
        Course course = courseRepository.findCoursesById(id);
        return course;
    }







}
