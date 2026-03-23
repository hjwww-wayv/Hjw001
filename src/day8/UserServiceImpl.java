package day8;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private static final Map<String, User> map = new HashMap<>();
    private static int idconter=1;
    public void register(User user){
        if(user.getUsername() == null || user.getUsername().equals("")){
            throw new UserException("用户名不能为空");
        }
        if(user.getPassword() == null || user.getPassword().equals("")){
            throw new UserException("密码不能为空");
        }
        if(map.containsKey(user.getUsername()))
        {
            throw new UserException("用户名已存在");
        }
        if(user.getPassword().length()<6)
        {
            throw new UserException("密码长度不能小于6位");
        }
        user.setId(idconter++);
        map.put(user.getUsername(),user);
        System.out.println("注册成功"+user.getUsername());
    }

    public void login(String username,String password)  {
        if(username == null || username.equals("")){
            throw new UserException("用户名不能为空");
        }
        if(password == null || password.equals("")){
            throw new UserException("密码不能为空");
        }
        if(!map.containsKey(username)){
            throw new UserException("用户名不存在");
        }
        if (!map.get(username).getPassword().equals(password)) {
            throw new UserException("密码错误");
        }
        System.out.println("登录成功");
    }

    public User findbyname(String username){
        return map.get(username);
        }
    }

