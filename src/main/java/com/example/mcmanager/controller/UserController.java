package com.example.mcmanager.controller;

import com.example.mcmanager.entity.Post;
import com.example.mcmanager.entity.Song;
import com.example.mcmanager.entity.User;
import com.example.mcmanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${file.upload.path}")
    private String filePath;

    /**显示虚拟地址*/
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    /**
     * 接口：获取信息
     * @return
     */
    @PostMapping("list")
    public List<User> list(){
        return userService.list();
    }

    //查询所有用户
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //根据id查询用户
    @GetMapping("/getUserById")
    public User getUserById(@Param("userid") Integer userid){
        return userService.getUserById(userid);
    }

    //根据id删除用户
    @PostMapping("/deleteUserById")
    public boolean deleteUserById(@Param("userid") Integer userid){
        return userService.deleteUserById(userid);
    }

    //添加用户
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //修改用户
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/test")
    public String test(){
        return "你好";
    }

    // 根据userid修改用户
    @PostMapping("/updateUserById")
    public boolean updateUserById(@RequestBody User user){
        return userService.updateUserById(user);
    }

    // 根据userid获取头像
    @GetMapping("/getUserHead")
    public String getUserHead(@Param("userid") Integer userid){
        return userService.getUserHead(userid);
    }

    // 用户登录
    @GetMapping("/login")
    public User login(@Param("userid") String userid, @Param("password") String password){
        return userService.login(userid, password);
    }
}
