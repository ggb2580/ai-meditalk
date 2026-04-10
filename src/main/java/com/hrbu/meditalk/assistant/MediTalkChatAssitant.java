package com.hrbu.meditalk.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,
        streamingChatModel = "qwenStreamingChatModel",
//        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverMediTalkPinecone" //配置向量存储
        )
public interface MediTalkChatAssitant {
    @SystemMessage(fromResource = "mediTalk-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
