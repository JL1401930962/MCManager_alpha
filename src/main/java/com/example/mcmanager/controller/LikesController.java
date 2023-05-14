package com.example.mcmanager.controller;

import com.example.mcmanager.entity.Likes;
import com.example.mcmanager.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/likes")
@CrossOrigin
public class LikesController {

    @Autowired
    private LikesService likesService;

    // 获取所有点赞信息
    @GetMapping("/getAllLikes")
    public List<Likes> getAllLikes(){
        return likesService.getAllLikes();
    }

    // 根据post_id获取点赞信息
    @GetMapping("/getLikesByPostId")
    public List<Likes> getLikesByPostId(Integer post_id){
        return likesService.getLikesByPostId(post_id);
    }

    // 根据post_id和user_id获取点赞状态
    @GetMapping("/getLikeStateByPostIdAndUserId")
    public boolean getLikeStateByPostIdAndUserId(Integer post_id, Integer user_id){
        return likesService.getLikeStateByPostIdAndUserId(post_id, user_id);
    }

    // 更新点赞状态
    @GetMapping("/updateLikeState")
    public boolean updateLikeState(Integer post_id, Integer user_id, boolean like_state){
        return likesService.updateLikeState(post_id, user_id, like_state);
    }

}
