package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.config.Task;

public class AdvertisementTest {
   @Test
public void testAssignTask() {
    // Create a new task and a user
    Task task = new Task();
    User user = new User("John Doe");

    // Assign the task to the user
    task.assignTask(user);

    // Verify that the task is assigned to the user
    assertEquals(user, task.getAssignedTo());
}
}
