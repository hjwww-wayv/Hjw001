package day15Test.service;

import java.util.List;
import day15Test.entity.User;

public interface Userservice {
        void register(User user);
        User login(String username, String password);
        User findbyname(String username);
        List<User> findAllUsers();
        List<User> findAdultUsers();
        List<User> sortUsersByAge(boolean isAsc);
        List<User> findbypage(int pageNum, int pageSize);
        void deleteUser(Integer id);
    }


