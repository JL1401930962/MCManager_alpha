package com.example.mcmanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mcmanager.entity.User;
import com.example.mcmanager.mapper.UserMapper;
import com.example.mcmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {


    @Autowired
    UserMapper userMapper;

    //查询所有用户
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    //根据id查询用户
    @Override
    public User getUserById(Integer userid) {
        System.out.println(userid);
        return userMapper.getUserById(userid);
    }

    //根据id删除用户
    @Override
    public boolean deleteUserById(Integer userid) {
        return userMapper.deleteUserById(userid);
    }

    //添加用户
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    //修改用户
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public String getUserHead(Integer userid) {
        return userMapper.getUserHead(userid);
    }

    @Override
    public User login(String userid, String password) {
        return userMapper.login(userid, password);
    }
}