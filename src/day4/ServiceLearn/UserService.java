package day4.ServiceLearn;

import day4.AgeException;
import day4.AgeRunException;

public class UserService {
    public void register(User u) throws AgeException{
        if(u.getAge()<18){
            throw new AgeException("年龄不能小于18");
        }
        else {
            System.out.println(u.getName() + "注册成功,age:" + u.getAge());
        }
    }
}
