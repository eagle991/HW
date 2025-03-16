package com.example.test;

import com.example.controller.StudentController;
import com.example.model.Student;
import com.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void testAddStudent() throws Exception {
        Student student = new Student("Ron Weasley", 16);
        when(studentService.addStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Ron Weasley\",\"age\":16}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ron Weasley"))
                .andExpect(jsonPath("$.age").value(16));
    }

    @Test
    void testGetAllStudents() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testFindStudentById() throws Exception {
        Student student = new Student("Draco Malfoy", 17);
        student.setId(1L);
        when(studentService.findStudentById(1L)).thenReturn(java.util.Optional.of(student));

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Draco Malfoy"));
    }

    @Test
    void testUpdateStudent() throws Exception {
        Student updatedStudent = new Student("Neville Longbottom", 17);
        updatedStudent.setId(1L);
        when(studentService.updateStudent(eq(1L), any(Student.class))).thenReturn(updatedStudent);

        mockMvc.perform(put("/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Neville Longbottom\",\"age\":17}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Neville Longbottom"));
    }

    @Test
    void testDeleteStudent() throws Exception {
        doNothing().when(studentService).deleteStudent(1L);

        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isOk());
    }
}
