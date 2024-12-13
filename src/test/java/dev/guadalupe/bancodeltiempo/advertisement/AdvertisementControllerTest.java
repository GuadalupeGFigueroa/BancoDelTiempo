package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AdvertisementControllerTest {

    private static final String BASE_URL = "/advertisements";

    @Mock
    private AdvertisementService advertisementService;

    @InjectMocks
    private AdvertisementController advertisementController;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(advertisementController).build();
    }

    @Test
    public void testGetAllAdvertisements() throws Exception {
        
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

       
        
        List<Advertisement> advertisements = Arrays.asList(advertisement1, advertisement2);

        when(advertisementService.getAllAdvertisements()).thenReturn(advertisements);

  
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].description").value("Ad 1"))
                .andExpect(jsonPath("$[1].description").value("Ad 2"));
    }

    @Test
    public void testGetAdvertisementById() throws Exception {
      

        Long id = 1L;
    User user1 = new User(
        1L, "User1", 
        "Coder1", 
        "user1@example.com", 
        "password123", 
        "1234567890", 
        180); 

    Advertisement advertisement1 = new Advertisement(
        1L, 
        "House move", 
        "Please, I need help loading some boxes into my van.",
        LocalDate.of(2024, 12, 10), 
        LocalDate.of(2025, 1, 10), 
        user1,
        90,
        AdvertisementState.PENDING);

    
        when(advertisementService.getAdvertisementById(id)).thenReturn(Optional.of(advertisement1));

        mockMvc.perform(get(BASE_URL + "/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.description").value("House move"));
    }

    @Test
    public void testGetAdvertisementByIdNotFound() throws Exception {
      
        Long id = 1L;
        when(advertisementService.getAdvertisementById(id)).thenReturn(Optional.empty());

       
        mockMvc.perform(get(BASE_URL + "/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateAdvertisement() throws Exception {
       
        User user3 = new User(
            3L, "User3", 
            "Coder3", 
            "user3@example.com", 
            "password123", 
            "1234567890", 
            180
            ); 
            
        Advertisement advertisement3 = new Advertisement(
            3L, 
            "Work tools", 
            "I need to learn how to use a drill and a saw. Please, someone could help me?",
            LocalDate.of(2024, 12, 4), 
            LocalDate.of(2024, 12, 21),
            user3,
            30,
            AdvertisementState.PENDING
        );
        Advertisement savedAdvertisement = new Advertisement(
            3L, 
            "Work tools", 
            "I need to learn how to use a drill and a saw. Please, someone could help me?",
            LocalDate.of(2024, 12, 4), 
            LocalDate.of(2024, 12, 21),
            user3,
            30,
            AdvertisementState.PENDING
        );
        when(advertisementService.createAdvertisement(advertisement3)).thenReturn(savedAdvertisement);

     
        mockMvc.perform(post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(advertisement3)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description").value("New Ad"));
    }

    @Test
    public void testDeleteAdvertisement() throws Exception {
        
        Long id = 1L;

        
        mockMvc.perform(delete(BASE_URL + "/{id}", id))
                .andExpect(status().isNoContent());
    }
}
