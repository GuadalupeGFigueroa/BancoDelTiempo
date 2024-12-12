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
        User user1 = new User("John", "Doe", "john@example.com", "password123", "+1234567890", 100);
        User user2 = new User("Jane", "Doe", "jane@example.com", "password456", "+9876543210", 200);

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // Ejecutar la prueba
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jane"));

        verify(userService, times(1)).getAllUsers();
    }
}
