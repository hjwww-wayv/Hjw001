package day10Test;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void register(User user);
    void login(String username, String password);
    User findbyname(String username);
    List<User> findAllUsers();
    List<User> findAdultUsers();
    void saveUsersToFile(String filePath) throws IOException; // 把用户写入文件
    void loadUsersFromFile(String filePath) throws IOException;//从文件读取用户

}
