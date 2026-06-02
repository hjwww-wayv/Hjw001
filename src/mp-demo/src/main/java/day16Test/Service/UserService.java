package day16Test.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import day16Test.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    void register(User user);
    User login(String username, String password);
    User findbyname(String username);
    List<User> findAllUsers();
    List<User> findAdultUsers();
    List<User> sortUsersByAge(boolean isAsc);
    List<User> findbypage(int pageNum, int pageSize);
    void deleteUser(Integer id);
    User selectone(String exactname);
    List<User> selectpart(String partname);
    List<User> selectbybirthday(LocalDate begin, LocalDate end);
    List<User> selectgroup(String partname,LocalDate begin, LocalDate end);
    IPage<User> findAllUsers(long pageNum, long pageSize);
    IPage<User> findby(long pageNum, long pageSize,String partname);


}
