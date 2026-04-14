package day13Test;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    // 直接复制替换你原来的URL、用户名密码就行
    // 把你的实例名写上，JDBC用双\\转义，所以是localhost\\dell
    // 不用写实例名，直接写localhost:1433固定端口，百分百能连上
    // 端口填你最后拿到的动态端口，如果还是没有，直接写实例名
    // 你是实例名dell，这么写就可以，Browser已经启动了，会自动解析端口
    // 端口就是55578，直接写死，不用解析
    private static final String URL = "jdbc:sqlserver://localhost:55578;databaseName=user_db;encrypt=false";
    // 用我们之前开的sa账号，密码换成你自己给sa设的密码！
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";

    // 静态块，加载驱动
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 1. 新增用户：对应注册
    public void addUser(User user) {
        String sql = "INSERT INTO [user](username, password, birthday) VALUES(?,?,?)";
        // try-with-resources自动关连接
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 给占位符赋值
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setDate(3, Date.valueOf(user.getBirthday())); // LocalDate转Sql的Date

            pstmt.executeUpdate(); // 执行插入
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 2. 根据用户名查用户：对应登录、注册判断用户名重复
    public User findByUsername(String username) {
        String sql = "SELECT * FROM [user] WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            // 执行查询，得到结果集ResultSet（就是数据库返回的查询结果）
            ResultSet rs = pstmt.executeQuery();

            // 把结果集转成User对象
            if (rs.next()) { // rs.next()：有没有下一行数据，有就返回true
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday").toLocalDate());
                user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                return user;
            }
            return null; // 没查到返回null
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 3. 查询所有用户：给service过滤、分页用
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM [user] ORDER BY id";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // 遍历结果集，转成List<User>
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday").toLocalDate());
                user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. 根据id删除用户
    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM [user] WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 放在UserDaoSqlServerImpl类里，其他代码都不变，只加这个方法
    public void setUser(User user) {
        // SQL：根据id修改用户名、密码、生日，id是主键，用来定位用户
        String sql = "UPDATE [user] SET username=?, password=?, birthday=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 给占位符赋值
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setDate(3, Date.valueOf(user.getBirthday()));
            pstmt.setInt(4, user.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
