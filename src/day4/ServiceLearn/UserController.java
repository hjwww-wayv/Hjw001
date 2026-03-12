package day4.ServiceLearn;

import day4.AgeException;

public class UserController {
    public static void main(String[] args){
        User a=new User("a",17,1);
        UserService us=new UserService();
        try {
            us.register(a);
            System.out.println("注册成功");
        } catch (AgeException e) {
            System.out.println("注册失败：" + e.getMessage());
                e.printStackTrace();
        }
    }}
