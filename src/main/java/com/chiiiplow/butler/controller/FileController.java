package com.chiiiplow.butler.controller;

import com.chiiiplow.butler.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件控制器
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/test")
    public String test() {
        fileService.test();
        return "test";
    }

}
