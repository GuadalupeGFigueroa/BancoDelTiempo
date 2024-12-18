package dev.guadalupe.bancodeltiempo.advertisement;

import java.time.LocalDate;

public class AdvertisementDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate taskDate;
    private Long publicatedById;
    private Long assignedToId;
    private int payment;
    private AdvertisementState state;

    public AdvertisementDto() {}

    public AdvertisementDto(Advertisement advertisement) {
        this.id = advertisement.getId();
        this.title = advertisement.getTitle();
        this.description = advertisement.getDescription();
        this.publicationDate = advertisement.getPublicationDate();
        this.taskDate = advertisement.getTaskDate();
        this.publicatedById = advertisement.getPublicatedBy() != null ? advertisement.getPublicatedBy().getId() : null;
        this.assignedToId = advertisement.getAssignedTo() != null ? advertisement.getAssignedTo().getId() : null;
        this.payment = advertisement.getPayment();
        this.state = advertisement.getState();
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

    public Long getPublicatedById() {
        return publicatedById;
    }

    public void setPublicatedById(Long publicatedById) {
        this.publicatedById = publicatedById;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public AdvertisementState getState() {
        return state;
    }

    public void setState(AdvertisementState state) {
        this.state = state;
    }
}
