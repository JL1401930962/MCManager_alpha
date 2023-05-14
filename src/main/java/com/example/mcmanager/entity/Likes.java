package com.example.mcmanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "likes")
@Data
public class Likes {
    private Integer userid;
    private Integer post_id;
    private Boolean like_state = false;
    @TableId(type = IdType.AUTO)
    private Integer id;     //序号

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Boolean getLike_state() {
        return like_state;
    }

    public void setLike_state(Boolean like_state) {
        this.like_state = like_state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
