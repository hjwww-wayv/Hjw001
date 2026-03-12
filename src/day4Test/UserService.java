package day4Test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.HashMap;

@Data
public class UserService {
    Map<String,String> map=new HashMap<>();
    public UserService() {
        map.put("a1", "123");
        map.put("a2", "456");
        map.put("a3", "789");

    }
    public void login(String username,String password){
        if(username==null||username.equals("")){
            throw new BusinessException("用户名不能为空");
        }
        if(password==null||password.equals("")){
            throw new BusinessException("密码不能为空");
        }
        if(!map.containsKey(username))
        {
            throw new BusinessException("用户名不存在");
        }
        if(!map.get(username).equals(password)){//判断用户名和密码是否正确
            throw new BusinessException("密码错误");
        }
        System.out.println("校验成功");
    }
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        try {
//            userService.login("a2","123");
//        } catch (BusinessException e) {
//            System.out.println(e.getMessage());
//        }
//        userService.login("a1","1234");
//        userService.login("a4","1234");
}
    }
