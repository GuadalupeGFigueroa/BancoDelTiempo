package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers_ReturnsListOfUsers() {
        // Mockear datos
        User user1 = new User(1L, "User1", "user1@example.com", "password123", "1234567890");
        User user2 = new User(2L, "User2", "user2@example.com", "password123", "1234567890");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Ejecutar el método del servicio
        var users = userService.listUsers();

        // Verificar resultados
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserById_ReturnsUser_WhenUserExists() {
        // Mockear datos
        User user = new User(1L, "John Doe", "john@example.com", "password123", "1234567890");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Ejecutar el método
        var foundUser = userService.getUserById(1L);

        // Verificar resultados
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void createUser_SavesUserCorrectly() {
        // Mockear datos
        User user = new User(null, "John Doe", "john@example.com", "password123", "1234567890");
        User savedUser = new User(1L, "John Doe", "john@example.com", "password123", "1234567890");

        when(userRepository.save(user)).thenReturn(savedUser);

        // Ejecutar el método
        var result = userService.createUser(user);

        // Verificar resultados
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).save(user);
    }
}


