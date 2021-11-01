package com.example.tddkata.controller;

import com.example.tddkata.dao.Library;
import com.example.tddkata.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/{name}")
    public Library getLibraryByName(@PathVariable String name){
        return libraryService.getLibraryByName(name);
    }
}
