package com.hrbu.meditalk;

import com.hrbu.meditalk.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FunCallingTest {
    @Autowired
    private SeparateChatAssistant assistant;
    @Test
    public void test(){
        String chat = assistant.chat(11, "ios 26.4 升级点");
        System.out.println(chat);
        String chat1 = assistant.chat(10, "3的2次方是多少");
        System.out.println(chat1);

    }

}
