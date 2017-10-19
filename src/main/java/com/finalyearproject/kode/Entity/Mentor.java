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
    private String Name;
    private int Age;
    private Date dateJoined;
    private int yearsExperience;

    @ManyToMany
    List<Student> studentList;

    @ManyToMany
    List<Parent> parentList;

    @ManyToMany
    List<Language> languageList;

    public Mentor(){

    }


    public Mentor(String Name, int Age, Date dateJoined, int yearsExperience) {
        super();
        this.Name = Name;
        this.Age = Age;
        this.dateJoined = dateJoined;
        this.yearsExperience = yearsExperience;

    }



    public int getMentorID() {return id;}
    public void setMentorID(int id) { this.id = id;}


    public List<Language> getLanguage() {
        return languageList;
    }

    public void setLanguage(List<Language> languages) {
        this.languageList = languages;
    }

    public String getName()
    {
        return Name; }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge()
    { return Age; }

    public void setAge(int age) {
        this.Age = age;
    }

    public Date getDateJoined()
    { return dateJoined;
        }

    public void setDateJoined(Date date) {
        this.dateJoined = date;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience){
        this.yearsExperience = yearsExperience;
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

