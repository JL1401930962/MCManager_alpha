package com.example.mcmanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mcmanager.entity.Comment;
import com.example.mcmanager.mapper.CommentMapper;
import com.example.mcmanager.service.CommentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    // 根据post_id查询所有评论信息
    @Override
    public List<Comment> getCommentByPostId(Integer post_id) {
        return commentMapper.getCommentByPostId(post_id);
    }

    // 添加评论
    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    // 删除评论
    @Override
    public boolean deleteComment(Integer comment_id) {
        return commentMapper.deleteComment(comment_id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

}
