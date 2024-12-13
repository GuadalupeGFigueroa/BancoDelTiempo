package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvertisementTest {
   @Test
public void testAssignTask() {
    
    User user1 = new User(
        1L, 
        "User1",
        "Coder1",
        "user1@example.com", 
        "password123", 
        "1234567890", 
        60);

    Advertisement advertisement1 = new Advertisement(
        1L, 
        "House move", 
        "Please, I need help loading some boxes into my van.",
        LocalDate.of(2024, 12, 10), 
        LocalDate.of(2025, 1, 10), 
        user1,
        90,
        AdvertisementState.PENDING);
   
    advertisement1.assignTask(user1);


    assertEquals(user1, advertisement1.getAssignedTo());
}
@Test 
public void testChangeState() {
      
    User user1 = new User(
        1L, "User1", 
        "Coder1", 
        "user1@example.com", 
        "password123", 
        "1234567890", 
        60); 

    Advertisement advertisement1 = new Advertisement(
        1L, 
        "House move", 
        "Please, I need help loading some boxes into my van.",
        LocalDate.of(2024, 12, 10), 
        LocalDate.of(2025, 1, 10), 
        user1,
        90,
        AdvertisementState.PENDING);
        
         
    assertEquals(AdvertisementState.ASSIGNED, advertisement1.getState()); 
} 

@Test public void testConstructor() { 
        
        User user1 = new User(
            1L, 
            "User1", 
            "Coder1", 
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60); 
        
         
        Advertisement advertisement1 = new Advertisement(
            1L, 
            "House move", 
            "Please, I need help loading some boxes into my van.",
            LocalDate.of(2024, 12, 10), 
            LocalDate.of(2025, 1, 10), 
            user1,
            90,
            AdvertisementState.PENDING);

        
        assertEquals("title1", advertisement1.getTitle()); 
        assertEquals("description1", advertisement1.getDescription()); 
        assertEquals(LocalDate.of(2024, 12, 30), advertisement1.getPublicationDate()); 
        assertEquals(LocalDate.of(2024, 12, 31), advertisement1.getTaskDate()); 
        assertEquals(user1, advertisement1.getPublicatedBy()); assertEquals(AdvertisementState.PENDING, advertisement1.getState()); 
    } 
        
@Test 
public void testGettersAndSetters() { 
     
    User user = new User(
        1L, "User1", 
        "Coder1", 
        "user1@example.com", 
        "password123", 
        "1234567890", 
        60); 


    Advertisement advertisement = new Advertisement(); 
    advertisement.setTitle("title1"); 
    advertisement.setDescription("description1"); 
    advertisement.setPublicationDate(LocalDate.of(2024, 12, 30)); 
    advertisement.setTaskDate(LocalDate.of(2024, 12, 31)); 
    advertisement.setPublicatedBy(user); 
    advertisement.setState(AdvertisementState.PENDING); 

    
    assertEquals("title1", advertisement.getTitle()); 
    assertEquals("description1", advertisement.getDescription()); assertEquals(LocalDate.of(2024, 12, 30), 
    advertisement.getPublicationDate()); assertEquals(LocalDate.of(2024, 12, 31), 
    advertisement.getTaskDate()); assertEquals(user, advertisement.getPublicatedBy()); assertEquals(AdvertisementState.PENDING, advertisement.getState()); } 
    
@Test public void testSettersAndChangeState() { 
     
    User user1 = new User(
        1L, "User1", 
        "Coder1", 
        "user1@example.com",
        "password123", 
        "1234567890", 
        60); 
    User user2 = new User(
        2L, "User2", 
        "Coder2", 
        "user2@example.com", 
        "password456", 
        "0987654321", 
        120); 

    
    Advertisement advertisement = new Advertisement(); 
    advertisement.setId(1L); advertisement.setTitle("title1"); 
    advertisement.setDescription("description1"); 
    advertisement.setPublicationDate(LocalDate.of(2024, 12, 30)); 
    advertisement.setTaskDate(LocalDate.of(2024, 12, 31)); 
    advertisement.setPublicatedBy(user1); advertisement.setAssignedTo(user2); 
    advertisement.setState(AdvertisementState.ASSIGNED); 

    
    assertEquals(1L, advertisement.getId()); 
    assertEquals("title1", advertisement.getTitle()); 
    assertEquals("description1", advertisement.getDescription()); 
    assertEquals(LocalDate.of(2024, 12, 30), advertisement.getPublicationDate()); 
    assertEquals(LocalDate.of(2024, 12, 31), advertisement.getTaskDate()); 
    assertEquals(user1, advertisement.getPublicatedBy()); 
    assertEquals(user2, advertisement.getAssignedTo()); 
    assertEquals(AdvertisementState.ASSIGNED, advertisement.getState()); 
    
    
    advertisement.changeState(AdvertisementState.COMPLETED); 
    assertEquals(AdvertisementState.COMPLETED, advertisement.getState()); 
    } 
}