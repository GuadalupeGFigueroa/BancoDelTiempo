package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AdvertisementTest {
   @Test
public void testAssignTask() {
    // Create a new task and a user
    User user = new User("User1", "Coder1", "user1@example.com", "password123", "1234567890", 60);
    Advertisement advertisement = new Advertisement(
        "title1", 
        "description1", 
        LocalDate.of(2024,12,30), 
        LocalDate.of(2024,12,31), 
        user, AdvertisementState.PENDING);
    // Assign the task to the user
    advertisement.assignTask(user);

    // Verify that the task is assigned to the user
    assertEquals(user, advertisement.getAssignedTo());
}
}
