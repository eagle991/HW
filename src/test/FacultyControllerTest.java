package com.example.test;

import com.example.model.Faculty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddFaculty() {
        Faculty faculty = new Faculty("Gryffindor", "Red");
        ResponseEntity<Faculty> response = restTemplate.postForEntity("/faculties", faculty, Faculty.class);

        assertNotNull(response.getBody());
        assertEquals("Gryffindor", response.getBody().getName());
        assertEquals("Red", response.getBody().getColor());
    }

    @Test
    void testGetAllFaculties() {
        ResponseEntity<Faculty[]> response = restTemplate.getForEntity("/faculties", Faculty[].class);
        assertNotNull(response.getBody());
    }

    @Test
    void testFindFacultyById() {
        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculties/1", Faculty.class);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testUpdateFaculty() {
        Faculty updatedFaculty = new Faculty("Slytherin", "Green");
        restTemplate.put("/faculties/1", updatedFaculty);

        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculties/1", Faculty.class);
        assertNotNull(response.getBody());
        assertEquals("Slytherin", response.getBody().getName());
    }

    @Test
    void testDeleteFaculty() {
        restTemplate.delete("/faculties/1");
        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculties/1", Faculty.class);
        assertNull(response.getBody());
    }
}
