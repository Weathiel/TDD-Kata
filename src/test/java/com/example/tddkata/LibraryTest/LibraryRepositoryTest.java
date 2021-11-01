package com.example.tddkata.LibraryTest;

import com.example.tddkata.dao.Library;
import com.example.tddkata.repository.LibraryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void whenFindByName_ReturnsLibrary(){

        Library library = libraryRepository.findByName("libok");

        Assertions.assertThat(library.getName()).isEqualTo("libok");
        Assertions.assertThat(library.isPrivate()).isEqualTo(false);
    }
}
