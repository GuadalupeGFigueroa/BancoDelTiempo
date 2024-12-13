package dev.guadalupe.bancodeltiempo.advertisement;
import dev.guadalupe.bancodeltiempo.user.User;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertisementDtoTest {

    @Test
    public void testAdvertisementDtoConstructor() {
        
        Long advertisementId = 1L;
        String title = "Test Title";
        String description = "Test Description";
        LocalDate publicationDate = LocalDate.now();
        LocalDate taskDate = LocalDate.now().plusDays(7);
        Long publicatedById = 2L;
        Long assignedToId = 3L;
        int payment = 100;
        AdvertisementState state = AdvertisementState.PENDING;

        User publicatedBy = new User();
        publicatedBy.setId(publicatedById);

        User assignedTo = new User();
        assignedTo.setId(assignedToId);

        Advertisement advertisement = new Advertisement(
            advertisementId,
            title,
            description,
            publicationDate,
            taskDate,
            publicatedBy,
            payment,
            state
        );
        advertisement.setAssignedTo(assignedTo);

        
        AdvertisementDto advertisementDto = new AdvertisementDto(advertisement);

        
        assertEquals(advertisementId, advertisementDto.getId());
        assertEquals(title, advertisementDto.getTitle());
        assertEquals(description, advertisementDto.getDescription());
        assertEquals(publicationDate, advertisementDto.getPublicationDate());
        assertEquals(taskDate, advertisementDto.getTaskDate());
        assertEquals(publicatedById, advertisementDto.getPublicatedById());
        assertEquals(assignedToId, advertisementDto.getAssignedToId());
        assertEquals(payment, advertisementDto.getPayment());
        assertEquals(state, advertisementDto.getState());
    }

    @Test
    public void testAdvertisementDtoConstructorWithNullAssignedTo() {
        
        Long advertisementId = 1L;
        String title = "Test Title";
        String description = "Test Description";
        LocalDate publicationDate = LocalDate.now();
        LocalDate taskDate = LocalDate.now().plusDays(7);
        Long publicatedById = 2L;
        int payment = 100;
        AdvertisementState state = AdvertisementState.PENDING;

        User publicatedBy = new User();
        publicatedBy.setId(publicatedById);

        Advertisement advertisement = new Advertisement(
            advertisementId,
            title,
            description,
            publicationDate,
            taskDate,
            publicatedBy,
            payment,
            state
        );

       
        AdvertisementDto advertisementDto = new AdvertisementDto(advertisement);

        
        assertEquals(advertisementId, advertisementDto.getId());
        assertEquals(title, advertisementDto.getTitle());
        assertEquals(description, advertisementDto.getDescription());
        assertEquals(publicationDate, advertisementDto.getPublicationDate());
        assertEquals(taskDate, advertisementDto.getTaskDate());
        assertEquals(publicatedById, advertisementDto.getPublicatedById());
        assertNull(advertisementDto.getAssignedToId()); 

    }

}
