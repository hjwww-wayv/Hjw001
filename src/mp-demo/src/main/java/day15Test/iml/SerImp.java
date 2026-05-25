package day15Test.iml;


import day15Test.mapper.MyBatisUtil;
import day15Test.service.Userservice;
import day15Test.entity.User;
import day15Test.UserException;
import day15Test.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class SerImp implements Userservice {
    public void register(User user) {
        // 基础校验
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new UserException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new UserException("密码不能为空");
        }
        if (user.getPassword().length() < 6) {
            throw new UserException("密码长度不能小于6位");
        }

        // MyBatis会话
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            // 查用户名是否存在
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUsername, user.getUsername());
            Long count = mapper.selectCount(wrapper);
            if (count > 0) {
                throw new UserException("用户已被注册");
            }

}}
    public User login(String username, String password) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            // 1. 只根据【用户名】查询（不查密码）
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUsername, username); // 只查用户名
            User user = mapper.selectOne(wrapper);

            // ====== 第一次判断：用户是否存在 ======
            if (user == null) {
                throw new UserException("用户名不存在！"); // 这里单独抛
            }

            // ====== 第二次判断：密码对不对 ======
            if (!user.getPassword().equals(password)) {
                throw new UserException("密码错误！");
            }

            // 都正确 → 登录成功
            return user;
        }
    }

    public List<User> findAllUsers() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.selectList(null);
        }
    }

    public List<User> findAdultUsers() {
        return findAllUsers().stream()
                .filter(user -> user.getAge()>=18)
                .collect(Collectors.toList());
    }
    public List<User> findbypage(int pageNum, int pageSize){
        if(pageNum<1){
            pageNum = 1;
        }
        int skip = (pageNum - 1) * pageSize;
        return findAllUsers().stream()
                .skip(skip)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
    @Override
    public User findbyname(String username) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            // 条件：用户名 = 传入的用户名
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUsername, username);
            // 查询一个用户
            return mapper.selectOne(wrapper);
        }
    }
    @Override
    public List<User> sortUsersByAge(boolean isAsc) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

            // true = 升序从小到大  false = 降序从大到小
            if (isAsc) {
                wrapper.orderByAsc(User::getAge);
            } else {
                wrapper.orderByDesc(User::getAge);
            }

            return mapper.selectList(wrapper);
        }
    }
    @Override
    public void deleteUser(Integer id) {
        if (id == null || id <= 0) {
            throw new UserException("用户ID不合法");
        }

        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            // 根据ID删除
            int rows = mapper.deleteById(id);

            if (rows == 0) {
                throw new UserException("用户不存在，删除失败");
            }
        }
    }
}
