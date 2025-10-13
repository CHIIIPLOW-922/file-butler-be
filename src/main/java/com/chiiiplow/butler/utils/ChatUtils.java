package com.chiiiplow.butler.utils;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * 聊天实用程序
 *
 * @author yangzhixiong
 * @date 2025/10/11
 */
@Component
public class ChatUtils {

    private final ChatClient customChatClient;

    public ChatUtils(ChatClient customChatClient) {
        this.customChatClient = customChatClient;
    }

    public String ask(String message) {
        return customChatClient.prompt().user(message).call().content();
    }

    public String askWithPrompt(String prompt, String message) {
        return customChatClient.prompt(prompt).user(message).call().content();
    }

    public Flux<String> askStream(String message) {
        return customChatClient.prompt().user(message).stream().content();
    }

    public Flux<String> askStreamWithPrompt(String prompt, String message) {
        return customChatClient.prompt(prompt).user(message).stream().content();
    }

}
