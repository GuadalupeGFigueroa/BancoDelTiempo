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
      
        User user1= new User(
            1L, 
            "User1",
            "Coder1",
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60);
        when(userRepository.findByEmail("user1@example.com")).thenReturn(Optional.of(user1));

       
        Optional<User> result = userRepository.findByEmail("user1@example.com");

       
        assertTrue(result.isPresent());
        assertEquals(user1, result.get());
    }

    @Test
    public void testFindByEmailNotFound() {
       
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

       
        Optional<User> result = userRepository.findByEmail("nonexistent@example.com");

       
        assertFalse(result.isPresent());
    }

    

}