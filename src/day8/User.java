package day8;


import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private int age;
    private int id;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
