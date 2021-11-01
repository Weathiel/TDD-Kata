package com.example.tddkata.service;

import com.example.tddkata.dao.Library;
import com.example.tddkata.exception.LibraryNotFoundException;
import com.example.tddkata.repository.LibraryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Cacheable("libraries")
    public Library getLibraryByName(String name) {
        Library library = libraryRepository.findByName(name);
        if(library == null){
            throw new LibraryNotFoundException();
        }
        return library;
    }
}
