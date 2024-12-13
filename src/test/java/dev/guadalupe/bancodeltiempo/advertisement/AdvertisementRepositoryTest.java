package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;




@DataJpaTest
public class AdvertisementRepositoryTest {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Test
    public void testFindAll() {
        
        User user1= new User(
            1L, 
            "User1",
            "Coder1",
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60);

        User user2= new User(
            2L,  
            "User2",
            "Coder2",
            "coder2@example.com", 
            "password123", 
            "1234567899",
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

        Advertisement advertisement2 = new Advertisement(
            2L, 
            "Fix a car", 
            "Please, someone could help me to change the oil in my car?",
            LocalDate.of(2024, 12, 4), 
            LocalDate.of(2024, 12, 21),
            user2,
            60,
            AdvertisementState.PENDING
        );
    
        advertisementRepository.save(advertisement1);
        advertisementRepository.save(advertisement2);

        
        List<Advertisement> advertisements = advertisementRepository.findAll();

        
        assertEquals(2, advertisements.size());
        assertTrue(advertisements.contains(advertisement1));
        assertTrue(advertisements.contains(advertisement2));
    }

    @Test
    public void testFindById() {
        
        User user1= new User(
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
        advertisementRepository.save(advertisement1);

       
        Advertisement foundAdvertisement = advertisementRepository.findById(advertisement1.getId()).orElse(null);

       
        assertNotNull(foundAdvertisement);
        assertEquals(advertisement1, foundAdvertisement);
    }

    @Test
    public void testSave() {
        
        User user1= new User(
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

       
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement1);

        
        assertNotNull(savedAdvertisement);
        assertEquals(advertisement1, savedAdvertisement);
    }

    @Test
    public void testDeleteById() {
        
        User user1= new User(
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
        advertisementRepository.save(advertisement1);

      
        advertisementRepository.deleteById(advertisement1.getId());

      
        assertFalse(advertisementRepository.existsById(advertisement1.getId()));
    }

    @Test
    public void testDelete() {
        
        User user1= new User(
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
        advertisementRepository.save(advertisement1);

        
        advertisementRepository.delete(advertisement1);

        
        assertFalse(advertisementRepository.existsById(advertisement1.getId()));
    }

    @Test
    public void testCount() {
        
        User user1 = new User(
            1L, "User1", 
            "Coder1", 
            "user1@example.com", 
            "password123", 
            "1234567890", 
            180); 
    
        User user2 = new User(
            1L, "User2", 
            "Coder2", 
            "user1@example.com", 
            "password123", 
            "1234567890", 
            40); 
    
        Advertisement advertisement1 = new Advertisement(
            1L, 
            "House move", 
            "Please, I need help loading some boxes into my van.",
            LocalDate.of(2024, 12, 10), 
            LocalDate.of(2025, 1, 10), 
            user1,
            90,
            AdvertisementState.PENDING);

        Advertisement advertisement2 = new Advertisement(
            2L, 
            "Fix a car", 
            "Please, someone could help me to change the oil in my car?",
            LocalDate.of(2024, 12, 4), 
            LocalDate.of(2024, 12, 21),
            user2,
            60,
            AdvertisementState.PENDING
        );
    
        advertisementRepository.save(advertisement1);
        advertisementRepository.save(advertisement2);

       
        long count = advertisementRepository.count();

        
        assertEquals(2, count);
    }

    @Test
    public void testExistsById() {
        
        User user1= new User(
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
        advertisementRepository.save(advertisement1);

       
        boolean exists = advertisementRepository.existsById(advertisement1.getId());

        
        assertTrue(exists);
    }
}

