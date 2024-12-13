package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Arrange
        User user1= new User(
            1L, 
            "User1",
            "Coder1",
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60);
        when(userRepository.findByEmail("user1@example.com")).thenReturn(Optional.of(user1));

        // Act
        Optional<User> result = userRepository.findByEmail("user1@example.com");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(user1, result.get());
    }

    @Test
    public void testFindByEmailNotFound() {
        // Arrange
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        // Act
        Optional<User> result = userRepository.findByEmail("nonexistent@example.com");

        // Assert
        assertFalse(result.isPresent());
    }

    

}