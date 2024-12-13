package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void getAllUsers_ReturnsUserList() throws Exception {
        // Mockear datos
        User user1 = new User(
            1L, "User1", 
            "coder1", 
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60);

        User user2 = new User(
            2L, "User2", 
            "coder2", 
            "coder2@example.com", 
            "password123", 
            "1234567890", 
            120);

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // Ejecutar la prueba
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("User1"))
                .andExpect(jsonPath("$[1].name").value("User2"));

        verify(userService, times(1)).getAllUsers();
    }
}
