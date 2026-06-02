package day16Test.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import day16Test.UserException;
import day16Test.entity.User;
import day16Test.Mapper.MyBatisUtil;
import day16Test.Mapper.UserMapper;
import day16Test.Service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SerImp implements UserService {
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
            mapper.insert(user);

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
    public User selectone(String exactname){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, exactname);
        return mapper.selectOne(wrapper);
    }
    public List<User> selectpart(String partname){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUsername, partname);
        return mapper.selectList(wrapper);
    }
    public List<User> selectbybirthday(LocalDate begin, LocalDate end){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(User::getBirthday, begin, end);
        return mapper.selectList(wrapper);
    }
    public List<User> selectgroup(String partname,LocalDate begin, LocalDate end){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUsername, partname);
        wrapper.between(User::getBirthday, begin, end);
        return mapper.selectList(wrapper);
    }
    public IPage<User> findAllUsers(long pageNum, long pageSize){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        Page<User> page = new Page<>(pageNum, pageSize);
        return mapper.selectPage(page, null);
    }
    public IPage<User> findby(long pageNum, long pageSize,String partname){
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        Page<User> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUsername, partname);
        return mapper.selectPage(page, wrapper);
    }


}
