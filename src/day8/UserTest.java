package day8;

public class UserTest {
    // 错误的测试方式：
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.register(new User("zhangsan", "18552456", 20));
    }
}
