package day10Test;

import day10.learnsplit.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private static final Map<String, User> map = new HashMap<>();
    private static int idconter = 1;

    public void register(User user) {
        if (user.getUsername() == null || user.getUsername().equals("")) {
            throw new UserException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new UserException("密码不能为空");
        }
        if (map.containsKey(user.getUsername())) {
            throw new UserException("用户名已存在");
        }
        if (user.getPassword().length() < 6) {
            throw new UserException("密码长度不能小于6位");
        }
        user.setId(idconter++);
        map.put(user.getUsername(), user);
        LocalDateTime nowDate = LocalDateTime.now();
        user.setCreateTime(nowDate);
        System.out.println("注册成功" + user.getUsername()+"年龄是"+user.getAge());
    }

    public void login(String username, String password) {
        if (username == null || username.equals("")) {
            throw new UserException("用户名不能为空");
        }
        if (password == null || password.equals("")) {
            throw new UserException("密码不能为空");
        }
        if (!map.containsKey(username)) {
            throw new UserException("用户名不存在");
        }
        if (!map.get(username).getPassword().equals(password)) {
            throw new UserException("密码错误");
        }
        System.out.println("登录成功");
    }

    public User findbyname(String username) {
        return map.get(username);
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(map.values());
    }

    public List<User> findAdultUsers() {
        List<User> adults = new ArrayList<>();
        for (User user : map.values()) {
            if (user.getAge() >= 18)
                adults.add(user);
        }
        return adults;
    }
    public void saveUsersToFile(String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for(User user:map.values()){
            String line=user.getUsername()+","+user.getPassword()+","+user.getBirthday();
            bw.write(line);
            bw.newLine();
        }
        System.out.println("用户信息已保存到文件");
    } // 把用户写入文件
    public void loadUsersFromFile(String filePath) throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int lineNumber = 0;
        boolean isfirstline=true;
        while ((line = br.readLine()) != null) {
            if (isfirstline) {
                isfirstline = false;
                continue;
            }
            String[] userStrs = line.split(",");
            lineNumber++;
            String username = userStrs[0];
            String password = userStrs[1];
            if(password.length()<6){
                throw new UserException("加载的密码长度不能小于6");
            }
            LocalDate birthday = LocalDate.parse(userStrs[2]);
            User user = new User(username, password, birthday);
            user.setId(idconter++);
            map.put(username, user);

            }
        System.out.println("用户信息已从文件加载");
        }
    }//从文件读取用户


