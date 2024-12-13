package dev.guadalupe.bancodeltiempo.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserDtoTest {

    @Test
    public void testConstructorWithUser() {
        
        User user = new User(1L, "John", "Doe", "john.doe@example.com", "password123", "123-456-7890", 100);

      
        UserDto userDto = new UserDto(user);

      
        assertEquals(1L, userDto.getId().longValue());
        assertEquals("John", userDto.getName());
        assertEquals("Doe", userDto.getLastname());
        assertEquals("john.doe@example.com", userDto.getEmail());
        assertEquals("123-456-7890", userDto.getPhoneNumber());
        assertEquals(100, userDto.getBalance());
    }

    @Test
    public void testEmptyConstructor() {
        
        UserDto userDto = new UserDto();

     
        assertNull(userDto.getId());
        assertNull(userDto.getName());
        assertNull(userDto.getLastname());
        assertNull(userDto.getEmail());
        assertNull(userDto.getPhoneNumber());
        assertEquals(0, userDto.getBalance());
    }

    @Test
    public void testGettersAndSetters() {
       
        UserDto userDto = new UserDto();


        userDto.setId(1L);
        userDto.setName("Jane");
        userDto.setLastname("Doe");
        userDto.setEmail("jane.doe@example.com");
        userDto.setPhoneNumber("987-654-3210");
        userDto.setBalance(200);

       
        assertEquals(1L, userDto.getId().longValue());
        assertEquals("Jane", userDto.getName());
        assertEquals("Doe", userDto.getLastname());
        assertEquals("jane.doe@example.com", userDto.getEmail());
        assertEquals("987-654-3210", userDto.getPhoneNumber());
        assertEquals(200, userDto.getBalance());
    }
}
