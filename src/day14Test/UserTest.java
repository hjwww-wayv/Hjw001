package day14Test;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        UserService service = new UserServiceImpl();
        try {
////             1. 注册测试
//            service.register(new User("test1", "123456", LocalDate.of(2000, 1, 1)));
//            service.register(new User("test2", "123456", LocalDate.of(2008, 5, 20)));
////            service.register(new User("test3", "123456", LocalDate.of(1995, 12, 12)));
//            service.register(new User("a","456789",LocalDate.of(1999,7,8)));
//            service.register(new User("b","456789",LocalDate.of(1999,7,8)));

//
//            service.login("test1", "123456");
//
            // 3. 分页
//            System.out.println("\n--- 第1页，每页2条 ---");
//            List<User> page1 = service.findbypage(1, 2);
//            page1.forEach(System.out::println);
//
//
//            // 5. 成年用户
//            System.out.println("\n--- 成年用户 ---");
//            List<User> adult = service.findAdultUsers();
//            adult.forEach(System.out::println);

                        service.deleteUser(1);

            List<User> all = service.findAllUsers();
             all.forEach(System.out::println);
//
//             service.deleteUser(1);

        } catch (UserException e) {
            System.out.println("业务异常：" + e.getMessage());
        }
    }

}