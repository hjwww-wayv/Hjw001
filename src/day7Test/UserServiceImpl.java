package day7Test;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService{
    Map<String, String> map = new HashMap<>();
    public UserServiceImpl()
    {
        map.put("admin", "admin");
        map.put("user", "user");
        map.put("guest", "guest");
    }
    public void register(String username, String password){
        if(username == null || password == null|| username.equals("") || password.equals("")){
            throw new UerRunException("用户名或密码不能为空");
        }
        if(map.containsKey(username))
        {
            throw new UerRunException("用户名已存在");
        }
        if(password.length()<6) {
            throw new UerRunException("密码长度不能小于6位");
        }
        map.put(username, password);
        System.out.println("注册成功");
    };

    public void login(String username, String password){
        if(username == null || password == null){
            throw new UerRunException("用户名或密码不能为空");
        }
        // 先判断用户存不存在
        if (!map.containsKey(username)) {
            throw new UerRunException("用户名不存在，登录失败");
        }
        // 存在了再拿密码比较
        String rightPwd = map.get(username);
        if(rightPwd.equals(password)){
            System.out.println("登录成功");
        }else{
            throw new UerRunException("用户名或密码错误，登录失败");
        }
    };
}
