package com.finalyearproject.kode.DAOs;

import com.finalyearproject.kode.Entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface StudentDAO
        extends CrudRepository<Student, Integer> {

public Student findByEmailAndPassword(String email, String password);

}
