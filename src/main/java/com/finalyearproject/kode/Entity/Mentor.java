package com.finalyearproject.kode.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Mentor {

    //every entity requires an id, and we can make it auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;

    @ManyToMany
    List<Student> studentList;

    @ManyToMany
    List<Parent> parentList;

    @ManyToMany
    List<Language> languageList;

    public Mentor(){

    }


    public Mentor(String firstName,String lastName, String email, String password,int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;

    }



    public int getMentorID() {return id;}
    public void setMentorID(int id) { this.id = id;}


    public List<Language> getLanguage() {
        return languageList;
    }

    public void setLanguage(List<Language> languages) {
        this.languageList = languages;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}

