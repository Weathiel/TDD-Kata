package com.example.tddkata.LibraryTest;

import com.example.tddkata.controller.LibraryController;
import com.example.tddkata.dao.Library;
import com.example.tddkata.exception.LibraryNotFoundException;
import com.example.tddkata.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LibraryService libraryService;

    @Test
    public void whenGetLibraryByName_ReturnLibrary() throws Exception {
        given(libraryService.getLibraryByName(anyString())).willReturn(new Library("libok", false));

        mvc.perform(MockMvcRequestBuilders.get("/library/libok"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("libok"))
                .andExpect(jsonPath("isPrivate").value(false));
    }

    @Test
    public void whenGetLibraryByName2_ReturnLibrary() throws Exception {
        given(libraryService.getLibraryByName(anyString())).willReturn(new Library("bookstore", true));

        mvc.perform(MockMvcRequestBuilders.get("/library/bookstore"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("bookstore"))
                .andExpect(jsonPath("isPrivate").value(true));
    }

    @Test
    public void whenGetLibraryByName_ReturnNotFoundException() throws Exception{
        given(libraryService.getLibraryByName(anyString())).willThrow(new LibraryNotFoundException());

        mvc.perform(MockMvcRequestBuilders.get("/library/notfound"))
                .andExpect(status().isNotFound());
    }
}
