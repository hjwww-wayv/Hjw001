package day9Test;

import java.time.LocalDate;

public class UserTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User("zhangsan", "123456", LocalDate.of(1990, 1, 1));
        userService.register(user);
    }
}