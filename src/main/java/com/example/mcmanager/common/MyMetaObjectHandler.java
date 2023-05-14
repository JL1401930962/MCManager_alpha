package com.example.mcmanager.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
      metaObject.setValue("createTime", LocalDateTime.now());
    }

    /**
     * 更新自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

    }

}
