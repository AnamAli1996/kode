package com.finalyearproject.kode.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Level {

    //every entity requires an id, and we can make it auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String levelDescription;

    @ManyToMany
    List<Course> courseList;

    public Level() {

    }


    public Level(String levelDescription) {
        super();
        this.levelDescription = levelDescription;}


    public int getId()
    {return id;
    }
    public void setId(int id)

    { this.id = id;}

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}