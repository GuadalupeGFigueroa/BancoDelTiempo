package dev.guadalupe.bancodeltiempo.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void listUsers_ReturnsUserList() throws Exception {
        // Mockear datos
        User user1 = new User(1L, "John Doe", "john@example.com", "password123", "1234567890");
        User user2 = new User(2L, "Jane Doe", "jane@example.com", "password456", "9876543210");

        when(userService.listUsers()).thenReturn(Arrays.asList(user1, user2));

        // Ejecutar la prueba
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].role").value("ADMIN"));

        verify(userService, times(1)).listUsers();
    }
}
