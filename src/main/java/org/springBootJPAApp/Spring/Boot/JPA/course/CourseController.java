package org.springBootJPAApp.Spring.Boot.JPA.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/cou")
    public String cou() {
        return "course";
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/courses/{id}")
    public Course updateCourse(@RequestBody Course course,@PathVariable String id){
        return courseService.updateCourse(course,id);
    }
}
