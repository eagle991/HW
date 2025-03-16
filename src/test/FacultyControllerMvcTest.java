package com.example.test;

import com.example.controller.FacultyController;
import com.example.model.Faculty;
import com.example.service.FacultyService;
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

@WebMvcTest(FacultyController.class)
public class FacultyControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @Test
    void testAddFaculty() throws Exception {
        Faculty faculty = new Faculty("Ravenclaw", "Blue");
        when(facultyService.addFaculty(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(post("/faculties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Ravenclaw\",\"color\":\"Blue\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ravenclaw"))
                .andExpect(jsonPath("$.color").value("Blue"));
    }

    @Test
    void testGetAllFaculties() throws Exception {
        when(facultyService.getAllFaculties()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/faculties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testFindFacultyById() throws Exception {
        Faculty faculty = new Faculty("Hufflepuff", "Yellow");
        faculty.setId(1L);
        when(facultyService.findFacultyById(1L)).thenReturn(java.util.Optional.of(faculty));

        mockMvc.perform(get("/faculties/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Hufflepuff"));
    }

    @Test
    void testUpdateFaculty() throws Exception {
        Faculty updatedFaculty = new Faculty("Slytherin", "Green");
        updatedFaculty.setId(1L);
        when(facultyService.updateFaculty(eq(1L), any(Faculty.class))).thenReturn(updatedFaculty);

        mockMvc.perform(put("/faculties/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Slytherin\",\"color\":\"Green\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Slytherin"));
    }

    @Test
    void testDeleteFaculty() throws Exception {
        doNothing().when(facultyService).deleteFaculty(1L);

        mockMvc.perform(delete("/faculties/1"))
                .andExpect(status().isOk());
    }
}