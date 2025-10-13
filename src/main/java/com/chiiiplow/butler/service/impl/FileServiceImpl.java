package com.chiiiplow.butler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.butler.entity.Files;
import com.chiiiplow.butler.mapper.FileMapper;
import com.chiiiplow.butler.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件服务 impl
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements FileService {




    @Override
    @Transactional(rollbackFor = Exception.class)
    public String test() {
        Files file = new Files();
        file.setFileName("123");
        file.setId(1L);
        file.setUserId(2L);
        this.baseMapper.insert(file);
        return "test";
    }
}
