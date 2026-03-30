package day9Test;

import java.util.List;

public interface UserService {
    void register(User user);
    void login(String username, String password);
    User findbyname(String username);
    List<User> findAllUsers();
    List<User> findAdultUsers();

}
