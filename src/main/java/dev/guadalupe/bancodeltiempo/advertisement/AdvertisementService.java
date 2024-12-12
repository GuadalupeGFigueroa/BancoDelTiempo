package dev.guadalupe.bancodeltiempo.advertisement;
import dev.guadalupe.bancodeltiempo.advertisement.AdvertisementRepository;

import dev.guadalupe.bancodeltiempo.user.User;
import dev.guadalupe.bancodeltiempo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserRepository userRepository;

   
    public AdvertisementService(AdvertisementRepository advertisementRepository, UserRepository userRepository) {
        this.advertisementRepository = advertisementRepository;
        this.userRepository = userRepository;
    }

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getAdvertisementById(Long id) {
        return advertisementRepository.findById(id);
    }

    public Advertisement createAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public Advertisement updateAdvertisement(Long id, Advertisement updatedAdvertisement) {
        return advertisementRepository.findById(id)
                .map(existingAdvertisement -> {
                    existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
                    existingAdvertisement.setPublicationDate(updatedAdvertisement.getPublicationDate());
                    existingAdvertisement.setTaskDate(updatedAdvertisement.getTaskDate());
                    existingAdvertisement.setState(updatedAdvertisement.getState());
                    return advertisementRepository.save(existingAdvertisement);
                }).orElseThrow(() -> new IllegalArgumentException("Advertisement not found"));
    }

    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }

    public void assignTask(Long advertisementId, Long userId) {
        Advertisement advertisement = advertisementRepository.findById(advertisementId)
                .orElseThrow(() -> new IllegalArgumentException("Advertisement not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        advertisement.assignTask(user);
        advertisementRepository.save(advertisement);
    }
}
