package dev.guadalupe.bancodeltiempo.advertisement;

import dev.guadalupe.bancodeltiempo.user.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private LocalDate publicationDate;

    @NotNull
    private LocalDate taskDate;

    @ManyToOne
    @JoinColumn(name = "publicated_by_id")
    private User publicatedBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    @Enumerated(EnumType.STRING)
    private AdvertisementState state;

    public Advertisement() {}

    public Advertisement(String description, LocalDate publicationDate, LocalDate taskDate, User publicatedBy, AdvertisementState state) {
        this.description = description;
        this.publicationDate = publicationDate;
        this.taskDate = taskDate;
        this.publicatedBy = publicatedBy;
        this.state = state;
    }

    // Getters and setters...

    public void changeState(AdvertisementState newState) {
        this.state = newState;
    }

    public void assignTask(User user) {
        this.assignedTo = user;
    }
}
