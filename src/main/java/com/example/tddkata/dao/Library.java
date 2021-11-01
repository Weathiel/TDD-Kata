package com.example.tddkata.dao;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Library {

    @Id
    @GeneratedValue
    public Long id;

    private String name;
    private boolean isPrivate = false;

    public Library(String name, boolean isPrivate){
        this.name = name;
        this.isPrivate = isPrivate;
    }

    public Library() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
