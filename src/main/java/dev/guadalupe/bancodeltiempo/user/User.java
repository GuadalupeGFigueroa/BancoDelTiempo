package dev.guadalupe.bancodeltiempo.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    // Atributos con anotaciones de JPA y validación
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(min = 2, max = 50) // Validación para el nombre
    private String name;

    @NotNull
    @Email // Validación de formato de correo electrónico
    private String email;

    @NotNull
    @Size(min = 8, max = 16) // Validación para la longitud de la contraseña
    private String password;

    @NotNull
    @Pattern(regexp = "\\+?[0-9]{10,15}") // Validación de formato de número telefónico
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER) // Relación con Role (Muchos usuarios pueden tener el mismo rol)
    @JoinColumn(name = "role_id", nullable = false) // Columna que mapea la relación en la base de datos
    private Role role;
}
