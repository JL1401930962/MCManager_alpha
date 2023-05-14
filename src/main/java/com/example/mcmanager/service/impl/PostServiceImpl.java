package com.example.mcmanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mcmanager.entity.Post;
import com.example.mcmanager.entity.User;
import com.example.mcmanager.mapper.PostMapper;
import com.example.mcmanager.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService {

    @Autowired
    PostMapper postMapper;

    //查询所有帖子信息
    @Override
    public List<Post> getAllPost() {
        return postMapper.getAllPost();
    }
    //根据userid查询所有帖子信息
    @Override
    public List<Post> getAllPostById(Integer userid) {
        System.out.println(userid);
        return postMapper.getAllPostById(userid);
    }


    @Override
    public Integer getSongIdByPostId(Integer post_id) {
        return postMapper.getSongIdByPostId(post_id);
    }

    @Override
    public boolean deletePostById(Integer post_id) {
        return postMapper.deletePostById(post_id);
    }

    @Override
    public boolean addPost(Post post) {
        return postMapper.addPost(post);
    }

}
