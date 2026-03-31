package day10Test;

import java.io.*;
import java.time.LocalDate;

public class UserTest {
    public static void main(String[] args) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.loadUsersFromFile("src/day10Test/users.csv");
        userService.register(new User("a","123456", LocalDate.of(1998,05,12)));
        userService.saveUsersToFile("src/day10Test/user.txt");
        userService.findAllUsers().forEach(System.out::println);

    }

}