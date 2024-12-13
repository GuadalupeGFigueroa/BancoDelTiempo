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
        // given
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

        // when
        List<Advertisement> advertisements = advertisementRepository.findAll();

        // then
        assertEquals(2, advertisements.size());
        assertTrue(advertisements.contains(advertisement1));
        assertTrue(advertisements.contains(advertisement2));
    }

    @Test
    public void testFindById() {
        // given
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

        // when
        Advertisement foundAdvertisement = advertisementRepository.findById(advertisement1.getId()).orElse(null);

        // then
        assertNotNull(foundAdvertisement);
        assertEquals(advertisement1, foundAdvertisement);
    }

    @Test
    public void testSave() {
        // given
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

        // when
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement1);

        // then
        assertNotNull(savedAdvertisement);
        assertEquals(advertisement1, savedAdvertisement);
    }

    @Test
    public void testDeleteById() {
        // given
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

        // when
        advertisementRepository.deleteById(advertisement1.getId());

        // then
        assertFalse(advertisementRepository.existsById(advertisement1.getId()));
    }

    @Test
    public void testDelete() {
        // given
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

        // when
        advertisementRepository.delete(advertisement1);

        // then
        assertFalse(advertisementRepository.existsById(advertisement1.getId()));
    }

    @Test
    public void testCount() {
        // given
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

        // when
        long count = advertisementRepository.count();

        // then
        assertEquals(2, count);
    }

    @Test
    public void testExistsById() {
        // given
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

        // when
        boolean exists = advertisementRepository.existsById(advertisement1.getId());

        // then
        assertTrue(exists);
    }
}

