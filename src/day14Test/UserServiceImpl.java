package day14Test;


import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    private static int idconter = 1;

    public void register(User user) {
        if (user.getUsername() == null || user.getUsername().equals("")) {
            throw new UserException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new UserException("密码不能为空");
        }
        User existUser = userDao.findByUsername(user.getUsername());
        if (existUser != null) {
            throw new UserException("用户已被注册");
        }
        if (user.getPassword().length() < 6) {
            throw new UserException("密码长度不能小于6位");
        }
        user.setId(idconter++);
        userDao.addUser(user);
        System.out.println("注册成功" + user.getUsername()+"年龄是"+user.getAge());
    }

    public void login(String username, String password) {
        if (username == null || username.equals("")) {
            throw new UserException("用户名不能为空");
        }
        if (password == null || password.equals("")) {
            throw new UserException("密码不能为空");
        }
        User user = userDao.findByUsername(username);
        if(user==null){
            throw new UserException("用户名不存在");
        }
        if(!user.getPassword().equals(password)){
            throw new UserException("密码错误");
        }
        System.out.println("登录成功,欢迎用户"+user.getUsername());
    }

    public User findbyname(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public List<User> findAdultUsers() {
        return userDao.findAdultUsers();
    }
    public List<User> findbypage(int pageNum, int pageSize){
        return userDao.findbypage(pageNum,pageSize);

    }
    public List<User> sortUsersByAge(boolean isAsc){ //默认升序
        if (isAsc) {
            return userDao.findAll().stream()
                    .sorted((u1,u2)->u2.getAge()-u1.getAge())
                    .collect(Collectors.toList());
        }
        else {
            return userDao.findAll().stream()
                    .sorted((u1,u2)->u1.getAge()-u2.getAge())
                    .collect(Collectors.toList());
        }
        }
        public void deleteUser(Integer id){
           userDao.deleteUser(id);
        }
    }



