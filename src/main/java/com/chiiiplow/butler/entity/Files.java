package com.chiiiplow.butler.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@TableName("files")
@Data
@Accessors(chain = true)
public class Files {

    private Long id;

    private Long userId;

    private String fileName;

}
