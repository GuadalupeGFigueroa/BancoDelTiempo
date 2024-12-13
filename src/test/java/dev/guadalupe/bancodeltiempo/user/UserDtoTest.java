package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserDtoTest {

    @Test
    public void testConstructorWithUser() {
        // Create a User object
        User user = new User(1L, "John", "Doe", "john.doe@example.com", "password123", "123-456-7890", 100);

        // Create a UserDto object from the User object
        UserDto userDto = new UserDto(user);

        // Verify that the UserDto object has the correct attributes
        assertEquals(1L, userDto.getId().longValue());
        assertEquals("John", userDto.getName());
        assertEquals("Doe", userDto.getLastname());
        assertEquals("john.doe@example.com", userDto.getEmail());
        assertEquals("123-456-7890", userDto.getPhoneNumber());
        assertEquals(100, userDto.getBalance());
    }

    @Test
    public void testEmptyConstructor() {
        // Create a UserDto object using the empty constructor
        UserDto userDto = new UserDto();

        // Verify that the UserDto object has default attributes
        assertNull(userDto.getId());
        assertNull(userDto.getName());
        assertNull(userDto.getLastname());
        assertNull(userDto.getEmail());
        assertNull(userDto.getPhoneNumber());
        assertEquals(0, userDto.getBalance());
    }

    @Test
    public void testGettersAndSetters() {
        // Create a UserDto object
        UserDto userDto = new UserDto();

        // Set attributes using setters
        userDto.setId(1L);
        userDto.setName("Jane");
        userDto.setLastname("Doe");
        userDto.setEmail("jane.doe@example.com");
        userDto.setPhoneNumber("987-654-3210");
        userDto.setBalance(200);

        // Verify that getters return the correct values
        assertEquals(1L, userDto.getId().longValue());
        assertEquals("Jane", userDto.getName());
        assertEquals("Doe", userDto.getLastname());
        assertEquals("jane.doe@example.com", userDto.getEmail());
        assertEquals("987-654-3210", userDto.getPhoneNumber());
        assertEquals(200, userDto.getBalance());
    }
}
