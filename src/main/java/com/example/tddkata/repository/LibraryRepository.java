package com.example.tddkata.repository;

import com.example.tddkata.dao.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {

    public Library findByName(String name) {
        return null;
    }
}
