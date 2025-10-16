package com.chiiiplow.butler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.butler.entity.Files;
import com.chiiiplow.butler.mapper.FileMapper;
import com.chiiiplow.butler.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 文件服务 impl
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements FileService {

    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final TransactionTemplate transactionTemplate;

    public FileServiceImpl(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public String test() {
        log.info("test");
        return "test";
    }
}
