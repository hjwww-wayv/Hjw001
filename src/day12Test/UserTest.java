package day12Test;

import day12Test.service.UserService;
import day12Test.entity.User;
import day12Test.service_impl.UserServiceImpl;
import day12Test.service_impl.UserServiceImpl2;
import day12Test.UserFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        UserService userService = UserFactory.getUserService("2");
        userService.register(new User("a","123456", LocalDate.of(1998,05,12)));
        userService.register(new User("b","123456", LocalDate.of(1999,05,12)));
        userService.register(new User("c","123456", LocalDate.of(1989,05,12)));
        userService.register(new User("d","123456", LocalDate.of(2000,05,12)));
        userService.register(new User("e","123456", LocalDate.of(1959,05,12)));
        userService.register(new User("f","123456", LocalDate.of(1998,05,12)));
        List<User> pageResult = userService.findByPage(2, 3);
        System.out.println("\n分页查询结果：");
        // 传统for循环遍历打印
        for (User user : pageResult) {
            System.out.println(user);
        }
        System.out.println("按年龄降序");
        System.out.println(userService.sortUsersByAge(true));
    }
    }

