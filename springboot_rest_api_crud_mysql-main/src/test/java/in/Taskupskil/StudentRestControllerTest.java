package in.Taskupskil;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.Taskupskil.binding.Student;
import in.Taskupskil.rest.StudentRestController;
import in.Taskupskil.service.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StudentRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentRestController studentRestController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentRestController).build();
    }

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(25);
        student.setSalary(50000.0);

        when(studentService.upsert(any(Student.class))).thenReturn("Created");

        MvcResult result = mockMvc.perform(post("/student")
                .content(asJsonString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("Created", content);

        verify(studentService, times(1)).upsert(any(Student.class));
        verifyNoMoreInteractions(studentService);
    }

    @Test
    public void testGetStudent() throws Exception {
        Student student = new Student();
        student.setCid(1);
        student.setName("John Doe");
        student.setAge(25);
        student.setSalary(50000.0);

        when(studentService.getById(1)).thenReturn(student);

        mockMvc.perform(get("/student/{cid}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cid").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.age").value(25))
                .andExpect(jsonPath("$.salary").value(50000.0));

        verify(studentService, times(1)).getById(1);
        verifyNoMoreInteractions(studentService);
    }
    
    
    
    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setCid(1);
        student.setName("Updated John Doe");
        student.setAge(30);
        student.setSalary(60000.0);

        when(studentService.upsert(any(Student.class))).thenReturn("Updated");

        MvcResult result = mockMvc.perform(put("/student")
                .content(asJsonString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("Updated", content);

        verify(studentService, times(1)).upsert(any(Student.class));
        verifyNoMoreInteractions(studentService);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        when(studentService.deleteById(1)).thenReturn("Deleted");

        mockMvc.perform(delete("/student/{cid}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));

        verify(studentService, times(1)).deleteById(1);
        verifyNoMoreInteractions(studentService);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}