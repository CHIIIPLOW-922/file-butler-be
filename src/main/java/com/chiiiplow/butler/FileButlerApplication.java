package com.chiiiplow.butler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 文件管家应用程序
 *
 * @author yangzhixiong
 * @date 2025/10/11
 */
@MapperScan(basePackages = "com.chiiiplow.butler.mapper.**")
@SpringBootApplication(scanBasePackages = "com.chiiiplow.butler")
public class FileButlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileButlerApplication.class, args);
    }

}
