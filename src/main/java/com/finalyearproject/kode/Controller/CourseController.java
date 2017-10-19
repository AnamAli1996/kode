package com.finalyearproject.kode.Controller;
import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demoCourse")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewCourse(@RequestParam String name,
                        @RequestParam String description,
                        @RequestParam float price) {
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setPrice(price);
        courseRepository.save(course);


        return "Saved";
    }

    @GetMapping(path = "/allCourse")
    public @ResponseBody
    Iterable<Course> getAllCourses() {
        // This returns a JSON or XML with the users
        return courseRepository.findAll();
    }


}
