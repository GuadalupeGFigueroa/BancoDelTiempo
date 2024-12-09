import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Email
    @Pattern(
        regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$",
        message = "Invalid email format"
    )
    private String email;

    @NotNull
    @Size(min = 8, max = 16)
    private String password;

    @NotNull
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Invalid phone number format")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
