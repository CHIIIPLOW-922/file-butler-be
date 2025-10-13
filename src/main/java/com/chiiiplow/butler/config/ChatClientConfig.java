package com.chiiiplow.butler.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ChatAI客户端配置
 *
 * @author yangzhixiong
 * @date 2025/10/11
 */
@Configuration
public class ChatClientConfig {

    @Value("${spring.ai.model-default}")
    private String defaultSystem;

    private final ChatClient.Builder builder;

    public ChatClientConfig(ChatClient.Builder builder) {
        this.builder = builder;
    }

    @Bean
    public ChatClient customChatClient() {
        return builder.defaultSystem(defaultSystem).build();
    }


}
