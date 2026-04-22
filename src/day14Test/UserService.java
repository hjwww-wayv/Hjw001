package day14Test;


import java.util.List;

public interface UserService {
    void register(User user);
    void login(String username, String password);
    User findbyname(String username);
    List<User> findAllUsers();
    List<User> findAdultUsers();
    List<User> sortUsersByAge(boolean isAsc);
    List<User> findbypage(int pageNum, int pageSize);
    void deleteUser(Integer id);
}
