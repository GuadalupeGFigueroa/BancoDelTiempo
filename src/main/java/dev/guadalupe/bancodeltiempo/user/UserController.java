package dev.guadalupe.bancodeltiempo.user;

import dev.guadalupe.bancodeltiempo.user.User;
import dev.guadalupe.bancodeltiempo.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") // Base del recurso
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Registro de un usuario (acceso restringido para administradores)
    @PostMapping("/admin/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    // Actualizar un usuario (acceso restringido para administradores)
    @PutMapping("/admin/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        Optional<User> userOptional = userService.getUserById(userId);

        if (userOptional.isPresent()) {
            User updatedUser = userService.updateUser(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un usuario (acceso restringido para administradores)
    @DeleteMapping("/admin/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Optional<User> userOptional = userService.getUserById(userId);

        if (userOptional.isPresent()) {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
