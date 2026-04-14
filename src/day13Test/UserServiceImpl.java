package day13Test;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println("登录成功");
    }

    public User findbyname(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public List<User> findAdultUsers() {
        return userDao.findAll().stream()
                .filter(user -> user.getAge() >= 18)
                .collect(Collectors.toList());
    }
//    public void saveUsersToFile(String filePath) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//        for(User user:map.values()){
//            String line=user.getUsername()+","+user.getPassword()+","+user.getBirthday();
//            bw.write(line);
//            bw.newLine();
//        }
//        System.out.println("用户信息已保存到文件");
//    } // 把用户写入文件
//    public void loadUsersFromFile(String filePath) throws IOException {
//        List<User> users = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        String line;
//        int lineNumber = 0;
//        boolean isfirstline=true;
//        while ((line = br.readLine()) != null) {
//            if (isfirstline) {
//                isfirstline = false;
//                continue;
//            }
//            String[] userStrs = line.split(",");
//            lineNumber++;
//            String username = userStrs[0];
//            String password = userStrs[1];
//            if(password.length()<6){
//                throw new UserException("加载的密码长度不能小于6");
//            }
//            LocalDate birthday = LocalDate.parse(userStrs[2]);
//            User user = new User(username, password, birthday);
//            user.setId(idconter++);
//            map.put(username, user);
//
//            }
//        System.out.println("用户信息已从文件加载");
//        }
    public List<User> findByPage(int pageNum, int pageSize){
        return userDao.findAll().stream()
                .skip((pageNum-1)*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

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

    }



