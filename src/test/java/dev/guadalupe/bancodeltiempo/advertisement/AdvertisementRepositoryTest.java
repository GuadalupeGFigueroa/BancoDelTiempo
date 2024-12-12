package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.advertisement.Advertisement;
import dev.guadalupe.bancodeltiempo.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AdvertisementRepositoryTest {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Test
    public void testFindAll() {
        // given
        User user = new User(
            1L, 
            "Arancha",
            "Doe", 
            "john@example.com", 
            "password123", 
            "1234567890", 
            60);

        User user2= new User(
            2L,  
            "Anaís",
            "Doe", 
            "john@example.com", 
            "password123", 
            "1234567890", 
            60);

        Advertisement advertisement1 = new Advertisement(
            "title1", 
            "description1", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user,
            AdvertisementState.PENDING
        );

        Advertisement advertisement2 = new Advertisement(
            "title2",
            "description2", 
            LocalDate.of(2024,12,30), 
            LocalDate.of(2024,12,31),
            user,
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
        Advertisement advertisement = new Advertisement("title", "description");
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
        Advertisement advertisement = new Advertisement("title", "description");

        // when
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);

        // then
        assertNotNull(savedAdvertisement);
        assertEquals(advertisement, savedAdvertisement);
    }

    @Test
    public void testDeleteById() {
        // given
        Advertisement advertisement = new Advertisement("title", "description");
        advertisementRepository.save(advertisement);

        // when
        advertisementRepository.deleteById(advertisement.getId());

        // then
        assertFalse(advertisementRepository.existsById(advertisement.getId()));
    }

    @Test
    public void testDelete() {
        // given
        Advertisement advertisement = new Advertisement("title", "description");
        advertisementRepository.save(advertisement);

        // when
        advertisementRepository.delete(advertisement);

        // then
        assertFalse(advertisementRepository.existsById(advertisement.getId()));
    }

    @Test
    public void testCount() {
        // given
        Advertisement advertisement1 = new Advertisement("title1", "description1");
        Advertisement advertisement2 = new Advertisement("title2", "description2");
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
        Advertisement advertisement = new Advertisement("title", "description");
        advertisementRepository.save(advertisement);

        // when
        boolean exists = advertisementRepository.existsById(advertisement.getId());

        // then
        assertTrue(exists);
    }
}

