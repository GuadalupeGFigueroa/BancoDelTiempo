package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;
import dev.guadalupe.bancodeltiempo.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @Mock
    private AdvertisementRepository advertisementRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AdvertisementService advertisementService;

    @Test
    public void testGetAllAdvertisements_EmptyList() {
        when(advertisementRepository.findAll()).thenReturn(Collections.emptyList());
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        assertThat(advertisements).isEmpty();
    }

    @Test
    public void testGetAllAdvertisements_ListOfAdvertisements() {
        List<Advertisement> advertisements = Arrays.asList(new Advertisement(), new Advertisement());
        when(advertisementRepository.findAll()).thenReturn(advertisements);
        List<Advertisement> result = advertisementService.getAllAdvertisements();
        assertThat(result).hasSize(2);
    }

    @Test
    public void testGetAdvertisementById_Found() {
        Advertisement advertisement = new Advertisement();
        when(advertisementRepository.findById(1L)).thenReturn(Optional.of(advertisement));
        Optional<Advertisement> result = advertisementService.getAdvertisementById(1L);
        assertThat(result).isPresent().contains(advertisement);
    }

    @Test
    public void testGetAdvertisementById_NotFound() {
        when(advertisementRepository.findById(1L)).thenReturn(Optional.empty());
        Optional<Advertisement> result = advertisementService.getAdvertisementById(1L);
        assertThat(result).isEmpty();
    }

    @Test
    public void testCreateAdvertisement() {
        Advertisement advertisement = new Advertisement();
        when(advertisementRepository.save(advertisement)).thenReturn(advertisement);
        Advertisement result = advertisementService.createAdvertisement(advertisement);
        assertThat(result).isEqualTo(advertisement);
    }

    @Test
    public void testUpdateAdvertisement_Found() {
        Advertisement existingAdvertisement = new Advertisement();
        Advertisement updatedAdvertisement = new Advertisement();
        updatedAdvertisement.setTitle("Updated Title");

        when(advertisementRepository.findById(1L)).thenReturn(Optional.of(existingAdvertisement));
        when(advertisementRepository.save(existingAdvertisement)).thenReturn(existingAdvertisement);

        Advertisement result = advertisementService.updateAdvertisement(1L, updatedAdvertisement);

        assertThat(result.getTitle()).isEqualTo("Updated Title");
        verify(advertisementRepository).save(existingAdvertisement);
    }

    @Test
    public void testUpdateAdvertisement_NotFound() {
        when(advertisementRepository.findById(1L)).thenReturn(Optional.empty());
        Advertisement updatedAdvertisement = new Advertisement();
        assertThatThrownBy(() -> advertisementService.updateAdvertisement(1L, updatedAdvertisement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Advertisement not found");
    }

    @Test
    public void testDeleteAdvertisement() {
        doNothing().when(advertisementRepository).deleteById(1L);
        advertisementService.deleteAdvertisement(1L);
        verify(advertisementRepository).deleteById(1L);
    }

    @Test
    public void testAssignTask_Success() {
        Advertisement advertisement = new Advertisement();
        User user = new User();
        when(advertisementRepository.findById(1L)).thenReturn(Optional.of(advertisement));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        advertisementService.assignTask(1L, 2L);
        assertThat(advertisement.getAssignedTo()).isEqualTo(user);
        verify(advertisementRepository).save(advertisement);
    }

    @Test
    public void testAssignTask_AdvertisementNotFound() {
        when(advertisementRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> advertisementService.assignTask(1L, 2L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Advertisement not found");
    }

    @Test
    public void testAssignTask_UserNotFound() {
        Advertisement advertisement = new Advertisement();
        when(advertisementRepository.findById(1L)).thenReturn(Optional.of(advertisement));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> advertisementService.assignTask(1L, 2L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not found");
    }
}
