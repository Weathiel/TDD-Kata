package com.example.tddkata.LibraryTest;

import com.example.tddkata.dao.Library;
import com.example.tddkata.repository.LibraryRepository;
import com.example.tddkata.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibraryCachingTest {

    @Autowired
    private LibraryService libraryService;

    @MockBean
    private LibraryRepository libraryRepository;

    @Test
    public void whenGetCarByName_FindByNameCalled1Time() throws Exception{
        given(libraryRepository.findByName(anyString())).willReturn(new Library());

        libraryService.getLibraryByName("libok");
        libraryService.getLibraryByName("libok");

        verify(libraryRepository, times(1)).findByName("libok");
    }
}
