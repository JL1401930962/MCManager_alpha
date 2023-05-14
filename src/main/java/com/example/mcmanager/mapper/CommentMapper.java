package com.example.mcmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mcmanager.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    // 根据post_id查询所有评论信息
    List<Comment> getCommentByPostId(Integer post_id);

    // 添加评论
    boolean addComment(Comment comment);

    // 删除评论
    boolean deleteComment(Integer comment_id);

    List<Comment> getAllComment();
}
