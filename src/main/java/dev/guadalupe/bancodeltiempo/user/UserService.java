package dev.guadalupe.bancodeltiempo.user;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) throws UserController.UserNotFoundException {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setLastname(updatedUser.getLastname());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
                    existingUser.setPassword(updatedUser.getPassword());
                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new UserController.UserNotFoundException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
