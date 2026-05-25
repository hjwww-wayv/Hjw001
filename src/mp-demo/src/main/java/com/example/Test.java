package com.example;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.MpUtils;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 获取Mapper
        UserMapper userMapper = MpUtils.getMapper(UserMapper.class);
        // 查询所有用户
        List<User> users = userMapper.selectList(null);
        // 输出结果
        for (User user : users) {
            System.out.println("用户信息：" + user);
        }
    }
}