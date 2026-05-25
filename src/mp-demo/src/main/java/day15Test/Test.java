package day15Test;

import day15Test.entity.User;
import day15Test.service.Userservice;
import day15Test.iml.SerImp;
import java.time.LocalDate;
public class Test {
        public static void main(String[] args) {
            Userservice service = new SerImp();

            User user = new User();
            user.setUsername("day15test");
            user.setPassword("123456");
            user.setBirthday(LocalDate.of(2000, 1, 1));

            service.register(user);
            System.out.println("注册成功");

            User login = service.login("day15test", "123456");
            System.out.println("登录成功：" + login.getUsername());
        }
    }

