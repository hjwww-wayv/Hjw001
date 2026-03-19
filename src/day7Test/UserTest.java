package day7Test;

public class UserTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // 先注册admin1，同一个对象
        try {
            userService.register("admin1", "123456");
        } catch (UerRunException e) {
            System.out.println("注册失败：" + e.getMessage());
        }

        // 再登录admin1，还是同一个对象，map里已经有了
        try {
            userService.login("admin1", "123456");
        } catch (UerRunException e) {
            System.out.println("登录失败：" + e.getMessage());
        }
    }

}
