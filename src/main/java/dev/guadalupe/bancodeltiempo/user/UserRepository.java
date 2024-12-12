package dev.guadalupe.bancodeltiempo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Encuentra un usuario por email
    Optional<User> findByEmail(String email);

    // Encuentra un usuario por username (si decides agregarlo al modelo)
    // Optional<User> findByUsername(String username);
}

