package com.finalyearproject.kode.Entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Language {

    //every entity requires an id, and we can make it auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String languageDescription;

    @ManyToMany
    private List<Mentor> mentors;

    public Language() {

    }


    public Language(String languageDescription) {
        super();
        this.languageDescription = languageDescription;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }

    public int getLanguagesID() {return id;}
    public void setLanguagesID(int id) { this.id = id;}

    public String getLanguageDescription() { return languageDescription; }


    public void setLanguageDescription(String ld) {
        this.languageDescription= ld;
    }

}