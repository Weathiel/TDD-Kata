package com.example.tddkata.LibraryTest;

import com.example.tddkata.dao.Library;
import com.example.tddkata.repository.LibraryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void whenFindByName_ReturnsLibrary(){
        Library flushLibrary = testEntityManager.persistFlushFind(new Library("libok", false));
        Library library = libraryRepository.findByName("libok");

        Assertions.assertThat(library.getName()).isEqualTo(flushLibrary.getName());
        Assertions.assertThat(library.isPrivate()).isEqualTo(flushLibrary.isPrivate());
    }

    @Test
    public void whenFindByName2_ReturnsLibrary(){
        Library flushLibrary = testEntityManager.persistFlushFind(new Library("bookstore", true));
        Library library = libraryRepository.findByName("bookstore");

        Assertions.assertThat(library.getName()).isEqualTo(flushLibrary.getName());
        Assertions.assertThat(library.isPrivate()).isEqualTo(flushLibrary.isPrivate());
    }
}
