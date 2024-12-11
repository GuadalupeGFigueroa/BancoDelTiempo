package dev.guadalupe.bancodeltiempo.project.service;

import dev.guadalupe.bancodeltiempo.project.dto.UserDTO;
import dev.guadalupe.bancodeltiempo.project.model.User;
import dev.guadalupe.bancodeltiempo.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 1. Listar todos los usuarios
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 2. Obtener usuario por ID
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO)
                   .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // 3. Crear usuario
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    // 4. Actualizar usuario
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(userDTO.getName());
            userToUpdate.setEmail(userDTO.getEmail());
            userToUpdate.setPhoneNumber(userDTO.getPhoneNumber());
            userToUpdate.setRole(userDTO.getRole());
            User updatedUser = userRepository.save(userToUpdate);
            return convertToDTO(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // 5. Eliminar usuario
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // Conversión de Entity a DTO
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getRole());
    }

    // Conversión de DTO a Entity
    private User convertToEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber(), userDTO.getRole());
    }
}
