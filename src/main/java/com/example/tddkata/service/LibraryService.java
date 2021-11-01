package com.example.tddkata.service;

import com.example.tddkata.dao.Library;
import com.example.tddkata.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library getLibraryByName(String name) {
        return libraryRepository.findByName(name);
    }
}
