package dev.guadalupe.bancodeltiempo.role;

import jakarta.persistence.*;

@Entity
@Table(name = "roles") // Nombre de la tabla en la base de datos
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerado
    private Long id;

    @Column(unique = true, nullable = false) // El nombre del rol debe ser único
    private String name;

    // Constructor vacío requerido por JPA
    public Role() {
    }

    // Constructor con parámetros
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
