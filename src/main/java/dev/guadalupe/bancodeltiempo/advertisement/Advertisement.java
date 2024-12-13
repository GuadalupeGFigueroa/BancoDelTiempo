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
    private String title;

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

    public Advertisement(Long id,String title, String description, LocalDate publicationDate, LocalDate taskDate, User publicatedBy, AdvertisementState state) {
        this.id = id;
        this.title = title;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }    

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public User getPublicatedBy() {
        return publicatedBy;
    }

    public void setPublicatedBy(User publicatedBy) {
        this.publicatedBy = publicatedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public AdvertisementState getState() {
        return state;
    }

    public void setState(AdvertisementState state) {
        this.state = state;
    }
}
