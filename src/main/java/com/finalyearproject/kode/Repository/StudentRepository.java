package com.finalyearproject.kode.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.finalyearproject.kode.Entity.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    Student findById(int id);


    public  Student findByEmailAndPassword(String email, String password);


}
