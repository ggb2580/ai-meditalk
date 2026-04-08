package com.hrbu.meditalk.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "openAiChatModel",chatMemory = "chatMemory",chatMemoryProvider = "chatMemoryProvider")
public interface MediTalkChatAssitant {
    @SystemMessage(fromResource = "mediTalk-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
