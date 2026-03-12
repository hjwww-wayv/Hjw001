package day4Test;

import java.util.HashMap;
import java.util.Map;

public class LoginApp {
    public static void main(String[] args)
    {
        UserService userService = new UserService();
        try {
            userService.login("a1", "123");
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

    }
}
