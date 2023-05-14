package com.example.mcmanager.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "comment")
@Data
public class Comment implements Serializable {
    //主键id
    @TableId(type = IdType.AUTO)
    private Integer comment_id;

    private Integer post_id;
    private Integer userid;
    private String username;
    private String comment_date;
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
