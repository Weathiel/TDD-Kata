package com.example.tddkata.controller;

import com.example.tddkata.dao.Library;
import com.example.tddkata.exception.LibraryNotFoundException;
import com.example.tddkata.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void libraryNotFoundHandler(LibraryNotFoundException ex){
    }
}
