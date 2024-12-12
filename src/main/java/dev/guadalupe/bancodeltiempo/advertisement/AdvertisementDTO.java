package dev.guadalupe.bancodeltiempo.advertisement;

public class AdvertisementDto {
    private Long id;
    private String description;
    private LocalDate publicationDate;
    private LocalDate taskDate;
    private Long publicatedById;
    private Long assignedToId;
    private AdvertisementState state;

    public AdvertisementDto() {}

    public AdvertisementDto(Advertisement advertisement) {
        this.id = advertisement.getId();
        this.description = advertisement.getDescription();
        this.publicationDate = advertisement.getPublicationDate();
        this.taskDate = advertisement.getTaskDate();
        this.publicatedById = advertisement.getPublicatedBy().getId();
        this.assignedToId = advertisement.getAssignedTo() != null ? advertisement.getAssignedTo().getId() : null;
        this.state = advertisement.getState();
    }

    // Getters and setters...
}
