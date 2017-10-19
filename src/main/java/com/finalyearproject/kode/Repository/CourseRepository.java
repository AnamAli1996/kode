package com.finalyearproject.kode.Repository;

import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Entity.Parent;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
