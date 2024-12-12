package dev.guadalupe.bancodeltiempo.user;

import dev.guadalupe.bancodeltiempo.advertisement.Advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastname;

    @NotNull
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",message = "Invalid email format")
    private String email;    
    
    @NotNull
    @Size(min = 8, max = 16)
    private String password;

    @NotNull
    @Pattern(regexp = "^\\+?\\d{10,15}$",message = "Invalid phone number format")
    private String phoneNumber;

    @NotNull
    private int balance;

    public User() {
    }

    public User(String name, String lastname, String email, String password, String phoneNumber, int balance) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void login() {
        System.out.println("User " + email + " logged in.");
    }

    public User changePassword(String newPassword) {
        this.password = newPassword;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @OneToMany(mappedBy = "publicatedBy")
    private List<Advertisement> publishedAdvertisements;

    @OneToMany(mappedBy = "assignedTo")
    private List<Advertisement> assignedAdvertisements;

}
