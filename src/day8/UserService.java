package day8;

public interface UserService {
    void register(User user);
    void login(String username, String password);
    User findbyname(String username);
}
