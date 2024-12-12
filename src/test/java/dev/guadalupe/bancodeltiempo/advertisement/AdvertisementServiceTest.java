package dev.guadalupe.bancodeltiempo.advertisement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @Mock
    private AdvertisementRepository advertisementRepository;

    @InjectMocks
    private AdvertisementService advertisementService;

    @Test
    public void testGetAllAdvertisements_EmptyList() {
        // Given
        when(advertisementRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();

        // Then
        assertThat(advertisements).isEmpty();
    }

    @Test
    public void testGetAllAdvertisements_ListOfAdvertisements() {
        // Given
        List<Advertisement> advertisements = Arrays.asList(new Advertisement(), new Advertisement());
        when(advertisementRepository.findAll()).thenReturn(advertisements);

        // When
        List<Advertisement> result = advertisementService.getAllAdvertisements();

        // Then
        assertThat(result).hasSize(2);
    }
}