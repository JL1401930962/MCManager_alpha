package com.example.mcmanager.controller;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mcmanager.entity.Comment;
import com.example.mcmanager.entity.Post;
import com.example.mcmanager.entity.Song;
import com.example.mcmanager.service.*;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {
//    @author JL
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @Autowired
    private SongService songService;

    @Autowired
    private LikesService likesService;
    @Autowired
    private UserService userService;

    //物理路径
    @Value("${file.upload.path}")
    private String filePath;

    /**显示虚拟地址*/
    @Value("${file.upload.relative}")
    private String fileRelativePath;

//    /**
//     * 后台管理接口：获取后台管理的帖子列表、可以分页、可以根据关键词搜索
//     * @param pageIndex
//     * @param pageSize
//     * @param post_id
//     * @return
//     */
//    @GetMapping("/list")
//    public Page<Post> listByPagination(Integer pageIndex, Integer pageSize, String username, String post_id){
//        Page<Post> pageInfo = new Page<>(pageIndex,pageSize);
//        LambdaQueryWrapper<Post> qw = new LambdaQueryWrapper<>();
////        qw.like(StringUtils.isNotEmpty(username),Post::getUsername,username);
//        qw.like(StringUtils.isNotEmpty(post_id),Post::getPost_id,post_id);
//        postService.page(pageInfo,qw);
//        return pageInfo;
//    }

//    @PostMapping("/postInfo")
//    public Map postInfo(@RequestBody Map<String,String> map) throws SQLException {
//        //TOdo
//        Integer userId = 5;
//        System.out.println(map);
//        String post_id = map.get("post_id");
//        Post post = postService.getById(post_id);
//        QueryWrapper<Post> qw = new QueryWrapper<>();
//        qw.eq("post_id",post_id).eq("user_id",userId);
//        List<Post> list = postService.list(qw);
//        HashMap<String, Object> map1 = new HashMap<>();
//        map1.put("postMenu",list);
//        map1.put("post_id",post.getPost_id());
//        map1.put("userid",post.getUserid());
//        map1.put("username",post.getUsername());
//        map1.put("head",post.getHead());
//        map1.put("post_time",post.getPost_time());
//        map1.put("content",post.getContent());
//        map1.put("picture",post.getPicture());
//        map1.put("songid",post.getSongid());
//        map1.put("comment_num",post.getComment_num());
//        map1.put("like_num",post.getLike_num());
//
//        return map1;
//    }

    /**
     * 后台管理接口：新增帖子(只有"add")
     * @param post
     * @return
     */
    @PostMapping
    public Boolean add(Post post){
        boolean success = postService.save(post);
        return BooleanUtil.isTrue(success);
    }

    // 添加帖子
    @PostMapping("/addPost")
    public boolean addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    /**
     * 后台管理接口：删除帖子
     * @param post
     * @return
     */
    @GetMapping("/delete")
    public String deleteCourse(Post post){
        postService.removeById(post.getPost_id());
        return "success";
    }

    /**
     * 小程序接口 ：获取评论
     * @param map
     * @return
     */
    @PostMapping("comment")
    public List<Comment> comment(@RequestBody Map<String,String> map){
        String userId = "5";
        QueryWrapper<Comment> cqw = new QueryWrapper<>();
        cqw.eq("post_id",map.get("post_id"));
        cqw.eq("userid",userId);
        cqw.orderByAsc("date");
        List<Comment> list = commentService.list(cqw);
        System.out.println("=========================================="+list);
        return list;
    }

    /**
     * 上传图片
     * @param picImg
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String upload(MultipartFile picImg) throws IOException {

        //获取文件原名
        String fileName = picImg.getOriginalFilename();
        //创建要上传的文件对象
        File newFile = new File(filePath,fileName);
        //将文件copy到目标地址
        picImg.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;

        return filePath;
    }

    //查询所有帖子信息
    @GetMapping("/getAllPost")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    //根据userid查询所有帖子信息
    @ResponseBody
    @GetMapping("getAllPostById")
    public List<Post> getAllPostById(@Param("userid") Integer userid){
        return postService.getAllPostById(userid);
    }

//    // 添加帖子
//    @PostMapping("/addPost")
//    public String addPost(@RequestBody Map<String,String> map){
//        Post post = new Post();
//        post.setUserid(map.get("userid"));
//        post.setUsername(map.get("username"));
//        post.setHead(map.get("head"));
//        post.setContent(map.get("content"));
//        if (map.get("picture") == null){
//            post.setPicture("");
//        }else {
//            post.setPicture(map.get("picture"));
//        }
////        if (map.get("songid") != null){
////            post.setSongid(Integer.parseInt(map.get("songid")));
////        }
//
//        postService.addPost(post);
//        postService.save(post);
//        return "success";
//    }

    @PostMapping("/list1")
    @ResponseBody
    public List<Post> list(){
        return postService.list();
    }

    // 根据post_id获取songid
    @GetMapping("/getSongIdByPostId")
    public Integer getSongIdByPostId(@Param("post_id") Integer post_id){
        return postService.getSongIdByPostId(post_id);
    }

    // 根据post_id删除帖子
    @PostMapping("/deletePostById")
    public boolean deletePostById(@Param("post_id") Integer post_id){
        return postService.deletePostById(post_id);
    }



}
