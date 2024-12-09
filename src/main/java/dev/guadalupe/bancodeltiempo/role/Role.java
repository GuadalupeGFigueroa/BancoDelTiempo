package dev.guadalupe.bancodeltiempo.role;

public class Role {
    private long id;
    private String name; //e.g. "admin" or "user"
    
    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
