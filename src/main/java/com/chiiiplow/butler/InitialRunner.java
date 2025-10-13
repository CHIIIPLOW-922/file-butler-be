package com.chiiiplow.butler;

import groovy.util.logging.Slf4j;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * 初始运行器
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@Component
public class InitialRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(InitialRunner.class);

    @Value("${minio.bucketName}")
    private String bucketName;

    private final MinioClient minioClient;

    public InitialRunner(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
        log.info("bucket initial finished");
    }
}
