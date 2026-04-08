package com.hrbu.meditalk.assistant;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "openAiChatModel")
public interface Assistant {
    String chat(String message);
    String chat(@MemoryId String methodId, @UserMessage String userMessage);
}
