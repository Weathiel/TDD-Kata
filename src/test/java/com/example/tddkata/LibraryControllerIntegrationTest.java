package com.example.tddkata;

import com.example.tddkata.dao.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenGetLibraryByNameReturnOK() throws Exception {

        ResponseEntity<Library> responseEntity = restTemplate.getForEntity("/library/numbus", Library.class);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
