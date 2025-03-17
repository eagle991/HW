package com.example.test;

import com.example.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddStudent() {
        Student student = new Student("Harry Potter", 17);
        ResponseEntity<Student> response = restTemplate.postForEntity("/students", student, Student.class);

        assertNotNull(response.getBody());
        assertEquals("Harry Potter", response.getBody().getName());
        assertEquals(17, response.getBody().getAge());
    }

    @Test
    void testGetAllStudents() {
        ResponseEntity<Student[]> response = restTemplate.getForEntity("/students", Student[].class);
        assertNotNull(response.getBody());
    }

    @Test
    void testFindStudentById() {
        ResponseEntity<Student> response = restTemplate.getForEntity("/students/1", Student.class);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testUpdateStudent() {
        Student updatedStudent = new Student("Hermione Granger", 18);
        restTemplate.put("/students/1", updatedStudent);

        ResponseEntity<Student> response = restTemplate.getForEntity("/students/1", Student.class);
        assertNotNull(response.getBody());
        assertEquals("Hermione Granger", response.getBody().getName());
    }

    @Test
    void testDeleteStudent() {
        restTemplate.delete("/students/1");
        ResponseEntity<Student> response = restTemplate.getForEntity("/students/1", Student.class);
        assertNull(response.getBody());
    }
}