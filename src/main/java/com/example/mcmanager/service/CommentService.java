package com.example.mcmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mcmanager.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    // 根据post_id查询所有评论信息
     List<Comment> getCommentByPostId(Integer post_id);

    // 添加评论
     boolean addComment(Comment comment);

    // 删除评论
    boolean deleteComment(Integer comment_id);

    List<Comment> getAllComment();
}
