package day13Test;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        UserService userService = new UserServiceImpl();

        // 测试注册
        try {
            userService.register(new User("zhangsan", "123456", LocalDate.of(1998,5,12)));
            userService.register(new User("lisi", "123456", LocalDate.of(2015,5,12)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试登录
        try {
            userService.login("zhangsan", "123456");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试查询成年用户
        List<User> adults = userService.findAdultUsers();
        System.out.println("\n成年用户：");
        adults.forEach(System.out::println);

        // 测试分页
//        List<User> pageResult = userService.findByPage(1, 2);
//        System.out.println("\n分页结果（第1页，每页2条）：");
//        pageResult.forEach(System.out::println);
    }
}