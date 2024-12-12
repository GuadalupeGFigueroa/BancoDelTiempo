package dev.guadalupe.bancodeltiempo.user;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // --- Tests para el atributo email ---
    @Test
    public void testValidEmail() {
        User user = createValidUser();
        user.setEmail("example@example.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidEmail_EmptyDomain() {
        User user = createValidUser();
        user.setEmail("example@.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("Invalid email format", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidEmail_NoAtSymbol() {
        User user = createValidUser();
        user.setEmail("example.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("Invalid email format", violations.iterator().next().getMessage());
    }

    @Test
    public void testNullEmail() {
        User user = createValidUser();
        user.setEmail(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    // --- Tests para el atributo name ---
    @Test
    public void testValidName() {
        User user = createValidUser();
        user.setName("John");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidName_TooShort() {
        User user = createValidUser();
        user.setName("A");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("size must be between 2 and 50", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidName_Null() {
        User user = createValidUser();
        user.setName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    // --- Tests para el atributo lastname ---
    @Test
    public void testValidLastname() {
        User user = createValidUser();
        user.setLastname("Doe");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidLastname_TooShort() {
        User user = createValidUser();
        user.setLastname("D");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("size must be between 2 and 50", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidLastname_Null() {
        User user = createValidUser();
        user.setLastname(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    // --- Tests para el atributo password ---
    @Test
    public void testValidPassword() {
        User user = createValidUser();
        user.setPassword("SecurePass123");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidPassword_TooShort() {
        User user = createValidUser();
        user.setPassword("123");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("size must be between 8 and 16", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidPassword_Null() {
        User user = createValidUser();
        user.setPassword(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    // --- Tests para el atributo phoneNumber ---
    @Test
    public void testValidPhoneNumber() {
        User user = createValidUser();
        user.setPhoneNumber("+12345678901");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidPhoneNumber_BadFormat() {
        User user = createValidUser();
        user.setPhoneNumber("123-abc");
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("Invalid phone number format", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidPhoneNumber_Null() {
        User user = createValidUser();
        user.setPhoneNumber(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    // --- Método auxiliar para crear un usuario válido ---
    private User createValidUser() {
        User user = new User();
        user.setName("John");
        user.setLastname("Doe");
        user.setEmail("example@example.com");
        user.setPassword("SecurePass123");
        user.setPhoneNumber("+12345678901");
        user.setBalance(100);
        return user;
    }
}
