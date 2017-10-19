package com.finalyearproject.kode;

import com.finalyearproject.kode.Entity.Student;
import com.finalyearproject.kode.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final StudentRepository repository;

    @Autowired
    public DatabaseLoader(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Date date = new Date();
        this.repository.save(new Student("firstName","lastName", "email", "password", date));
    }
}