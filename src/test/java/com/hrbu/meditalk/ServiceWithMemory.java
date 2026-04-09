package com.hrbu.meditalk;

import com.hrbu.meditalk.assistant.Assistant;
import com.hrbu.meditalk.assistant.MemoryChatAssistant;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceWithMemory {
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void demo1(){
        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .modelName("gpt-4o-mini")
                .apiKey("demo")
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .build();
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(chatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();

        //用户1
        String message1 = "我叫GGB,你记住!!!";
        String chat = assistant.chat("1", message1);
        System.out.println(chat);
        chat = assistant.chat("1", "我叫什么名字");
        System.out.println(chat);

        //用户2
        String message2 = "帮我推荐一下今天吃什么?";
        String chat2 = assistant.chat("2", message2);
        System.out.println(chat2);
        chat2 = assistant.chat("2", "从上面方案中，你帮我选一种");
        System.out.println(chat2);

    }

    @Test
    public void demo2() {

//        String chat = memoryChatAssistant.chat(1,"我叫李华");
//        System.out.println(chat);
//        String chat1 = memoryChatAssistant.chat(1,"考考你，我叫什么名字!");
//        System.out.println(chat1);

        String chat2 = memoryChatAssistant.chat(3,"讲个笑话");
        System.out.println(chat2);
        String chat3 = memoryChatAssistant.chat(4,"考考你，我叫什么名字!");
        System.out.println(chat3);
        String chat4 = memoryChatAssistant.chat(5,"你知道现在的热梗有哪些吗？");
        System.out.println(chat4);
    }
    @Test
    public void test03(){
        String chat2 = memoryChatAssistant.chat(6,"你是妈妈生的还是爸爸生的");
        System.out.println(chat2);
    }

    @Test
    public void test04(){
        System.out.println(876532*64653);
    }
}
