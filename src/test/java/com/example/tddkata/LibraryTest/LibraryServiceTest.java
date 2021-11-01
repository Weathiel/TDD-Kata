package com.example.tddkata.LibraryTest;

import com.example.tddkata.dao.Library;
import com.example.tddkata.service.LibraryService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    private LibraryService libraryService;

    @Before
    public void setUp() throws Exception{
        libraryService = new LibraryService();
    }

    @Test
    public void whenGetLibraryByName_ReturnLibrary(){
        Library library = libraryService.getLibraryByName("libok");

        Assertions.assertThat(library.getName()).isEqualTo("libok");
    }

}
