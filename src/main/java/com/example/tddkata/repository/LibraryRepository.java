package com.example.tddkata.repository;

import com.example.tddkata.dao.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
    Library findByName(String name);

}
