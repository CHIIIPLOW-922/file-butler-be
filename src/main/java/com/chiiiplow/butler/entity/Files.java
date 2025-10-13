package com.chiiiplow.butler.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 文件
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@TableName("files")
public class Files {

    private Long id;

    private Long userId;

    private String fileName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
