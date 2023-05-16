package com.example.mcmanager.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mcmanager.entity.Comment;
import com.example.mcmanager.entity.Post;
import com.example.mcmanager.service.CommentService;
import com.example.mcmanager.service.PostService;
import com.example.mcmanager.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;


    /**
     * 接口：获取信息
     * @return
     */
    @PostMapping("list1")
    public List<Comment> list(){
        return commentService.list();
    }

    /**
     * 后台管理接口：获取后台管理的帖子列表、可以分页、可以根据关键词搜索
     * @param pageIndex
     * @param pageSize
     * @param userid
     * @param post_id
     * @return
     */
    @GetMapping("list")
    public Page<Comment> listByPagination(int pageIndex, int pageSize, String userid, String post_id){
        Page<Comment> pageInfo = new Page<>(pageIndex,pageSize);
        LambdaQueryWrapper<Comment> qw = new LambdaQueryWrapper<>();
        qw.like(StringUtils.isNotEmpty(userid),Comment::getUserid,userid);
        qw.like(StringUtils.isNotEmpty(post_id),Comment::getPost_id,post_id);
        commentService.page(pageInfo,qw);
        return pageInfo;
    }

    @PostMapping("commentInfo")
    public Map postInfo(@RequestBody Map<String,String> map) throws SQLException {
        //TOdo
        Integer userId = 5;
        System.out.println(map);
        String post_id = map.get("post_id");
        String comment_id = map.get("comment_id");
        Comment comment = commentService.getById(comment_id);
        QueryWrapper<Comment> qw = new QueryWrapper<>();
        qw.eq("post_id",post_id).eq("user_id",userId);
        List<Comment> list = commentService.list(qw);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("commentMenu",list);
        map1.put("comment_id",comment.getComment_id());
        map1.put("post_id",comment.getPost_id());
        map1.put("userid",comment.getUserid());
        map1.put("username",comment.getUsername());
        map1.put("content",comment.getContent());

        return map1;
    }

    // 根据post_id获取评论列表
    @GetMapping("getCommentByPostId")
    public List<Comment> getCommentByPostId(@Param("post_id") Integer post_id){
        return commentService.getCommentByPostId(post_id);
    }

    /**
     * 后台管理接口：添加评论
     * @param comment
     * @return
     */
    @PostMapping("addComment")
    public boolean addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    /**
     * 后台管理接口：删除评论
     * @param comment_id
     * @return
     */
    @GetMapping("delete")
    public boolean deleteComment(Integer comment_id){
        return commentService.deleteComment(comment_id);
    }

    // 获取所有评论
    @GetMapping("/getAllComment")
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

}
