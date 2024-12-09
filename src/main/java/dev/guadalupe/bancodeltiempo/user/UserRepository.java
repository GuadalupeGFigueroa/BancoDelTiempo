package dev.guadalupe.bancodeltiempo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Encuentra un usuario por email
    Optional<User> findByEmail(String email);

    // Encuentra un usuario por username (si existe en tu modelo)
    Optional<User> findByUsername(String username);
}
