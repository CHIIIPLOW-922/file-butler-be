package com.chiiiplow.butler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.chiiiplow.butler.mapper.FileMapper;
import com.chiiiplow.butler.service.FileService;
import jakarta.annotation.Resource;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class FileButlerApplicationTests {


    @Resource
    private ChatClient customChatClient;

    @Resource
    private FileService fileService;

    @Resource
    private FileMapper fileMapper;


    @Test
    void contextLoads() {
        List<String> list;
        Flux<String> s = customChatClient.prompt().user("测试一下").stream().content();
        s.toStream(1).forEach(c -> System.out.print(c));
    }

    @Test
    void test2() {
        fileService.test();
    }

    @Test
    void test1() throws TikaException, IOException {
        Tika tika = new Tika();
        File file = new File("/Users/jojireal/Documents/立高-用友BIP项目资料/cost_price.json");
        String s = tika.parseToString(file);
        String s1 = s.replaceAll("[\\s ]+", "");
        System.out.println(s1.length());
        System.out.println(s1);
        Flux<String> content = customChatClient.prompt(s1).user("找出南澳的金额并分析").stream().content();
        content.toStream().forEach(c -> System.out.print(c));
    }
}
