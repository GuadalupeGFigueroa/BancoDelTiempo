package dev.guadalupe.bancodeltiempo.role;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Buscar un rol por nombre
    Optional<Role> findByName(String name);
}
