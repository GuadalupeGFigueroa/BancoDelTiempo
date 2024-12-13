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
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );

        Advertisement advertisement2 = new Advertisement(
            "title2",
            "description2", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user2,
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
        Advertisement advertisement =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );
        advertisementRepository.save(advertisement);

        // when
        Advertisement foundAdvertisement = advertisementRepository.findById(advertisement.getId()).orElse(null);

        // then
        assertNotNull(foundAdvertisement);
        assertEquals(advertisement, foundAdvertisement);
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
        Advertisement advertisement =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );

        // when
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);

        // then
        assertNotNull(savedAdvertisement);
        assertEquals(advertisement, savedAdvertisement);
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
        Advertisement advertisement =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );
        advertisementRepository.save(advertisement);

        // when
        advertisementRepository.deleteById(advertisement.getId());

        // then
        assertFalse(advertisementRepository.existsById(advertisement.getId()));
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
        Advertisement advertisement =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );
        advertisementRepository.save(advertisement);

        // when
        advertisementRepository.delete(advertisement);

        // then
        assertFalse(advertisementRepository.existsById(advertisement.getId()));
    }

    @Test
    public void testCount() {
        // given
        User user1= new User(
            1L, 
            "User1",
            "Coder1",
            "user1@example.com", 
            "password123", 
            "1234567890", 
            60);
        Advertisement advertisement1 =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
            AdvertisementState.PENDING
        );
        Advertisement advertisement2 =  new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user1,
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
        Advertisement advertisement =  new Advertisement(
                "title1", 
                "description1", 
                LocalDate.of(2024,12,30), 
                LocalDate.of(2024,12,31),
                user1,
                AdvertisementState.PENDING
            );
        advertisementRepository.save(advertisement);

        // when
        boolean exists = advertisementRepository.existsById(advertisement.getId());

        // then
        assertTrue(exists);
    }
}

