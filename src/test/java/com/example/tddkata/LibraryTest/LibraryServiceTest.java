package com.example.tddkata.LibraryTest;

import com.example.tddkata.dao.Library;
import com.example.tddkata.repository.LibraryRepository;
import com.example.tddkata.service.LibraryService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    private LibraryService libraryService;

    @Before
    public void setUp() throws Exception{
        libraryService = new LibraryService(libraryRepository);
    }

    @Test
    public void whenGetLibraryByName_ReturnLibrary(){
        given(libraryRepository.findByName(anyString())).willReturn(new Library("libok", false));

        Library library = libraryService.getLibraryByName("libok");

        Assertions.assertThat(library.getName()).isEqualTo("libok");
        Assertions.assertThat(library.isPrivate()).isEqualTo(false);
    }

    @Test
    public void whenGetLibraryByName2_ReturnLibrary(){
        given(libraryRepository.findByName(anyString())).willReturn(new Library("bookstore", true));

        Library library = libraryService.getLibraryByName("bookstore");

        Assertions.assertThat(library.getName()).isEqualTo("bookstore");
        Assertions.assertThat(library.isPrivate()).isEqualTo(true);
    }

}
