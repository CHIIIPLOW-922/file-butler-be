package com.chiiiplow.butler.config;

import com.chiiiplow.butler.components.CustomMinioAsyncClient;
import io.minio.MinioAsyncClient;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * minio 配置
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@Configuration
@Order(1)
public class MinioConfig {

    @Value("${minio.host}")
    private String host;

    @Value("${minio.url}")
    private String url;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;


    @Bean
    public MinioClient minioClient() {
        try {
            return new MinioClient.Builder()
                    .endpoint(host)
                    .credentials(accessKey, secretKey)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("MinIO服务初始化失败", e);
        }
    }

    @Bean
    public CustomMinioAsyncClient customMinioAsyncClient() {
        try {
            MinioAsyncClient minioAsyncClient = new MinioAsyncClient.Builder()
                    .endpoint(host)
                    .credentials(accessKey, secretKey)
                    .build();
            return new CustomMinioAsyncClient(minioAsyncClient);
        } catch (Exception e) {
            throw new RuntimeException("异步MinIO服务初始化失败", e);
        }
    }
}
