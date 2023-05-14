package com.example.mcmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mcmanager.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public interface PostMapper extends BaseMapper<Post> {
    //查询所有帖子信息
    List<Post> getAllPost();

    //根据userid查询所有帖子信息
    List<Post> getAllPostById(Integer userid);

    // 添加帖子

    Integer getSongIdByPostId(Integer post_id);

    boolean deletePostById(Integer post_id);

    boolean addPost(Post post);
}
