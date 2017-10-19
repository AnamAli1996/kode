package com.finalyearproject.kode.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Parent {

    //every entity requires an id, and we can make it auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String parentOne;
    private String parentTwo;
    private String familyName;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Student> students;


    public Parent() {

    }


    public Parent(String parentOne, String parentTwo, String familyName) {
        super();
        this.parentOne = parentOne;
        this.parentTwo = parentTwo;
        this.familyName = familyName;
    }

    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    public String getParentOne() { return parentOne; }


    public void setParentOne(String p1) {
        this.parentOne = p1;
    }

    public String getParentTwo() { return parentTwo; }


    public void setParentTwo(String p2) {
        this.parentTwo = p2;
    }

    public String getFamilyName() { return familyName; }

    public void setFamilyName(String fn) {
        this.familyName = fn;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}