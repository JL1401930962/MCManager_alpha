package com.example.mcmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mcmanager.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    //查询所有用户
    List<User> getAllUser();

    //根据id查询用户
    User getUserById(Integer userid);

    //根据id删除用户
    boolean deleteUserById(Integer userid);

    //添加用户
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean updateUserById(User user);

    String getUserHead(Integer userid);

    User login(String userid, String password);
}