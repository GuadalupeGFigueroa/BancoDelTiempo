package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;    
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Arrange
        User user = new User("john.doe@example.com", "johndoe");
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = userRepository.findByEmail("john.doe@example.com");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
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