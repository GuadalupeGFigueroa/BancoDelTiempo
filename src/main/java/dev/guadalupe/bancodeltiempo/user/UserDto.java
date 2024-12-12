package dev.guadalupe.bancodeltiempo.user;

import dev.guadalupe.bancodeltiempo.user.User;

@SuppressWarnings("unused")
public class UserDto {
    private Long id;
    private String name;
    private String lastname;  // Incluyendo apellido para consistencia
    private String email;
    private String phoneNumber;
    private int balance;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastname = user.getLastname();  // Incluyendo apellido
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.balance = user.getBalance();
    }

    public UserDto() {
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
}
