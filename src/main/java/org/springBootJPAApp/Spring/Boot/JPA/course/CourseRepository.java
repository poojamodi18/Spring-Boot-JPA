package org.springBootJPAApp.Spring.Boot.JPA.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

}
