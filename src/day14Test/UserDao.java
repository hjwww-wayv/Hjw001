package day14Test; // 放到你新建的dao包下




import java.util.List;

public interface UserDao {
    // 新增用户（注册用）
    void addUser(User user);
    // 根据用户名查询用户（登录用）
    User findByUsername(String username);
    // 查询所有用户（查询成年、分页用）
    List<User> findAll();
    // 根据id删除用户
    void deleteUser(Integer id);
    void setUser(User user);
    List<User> findAdultUsers();
    List<User> findbypage(Integer pageNum, Integer pageSize) ;
    }