package com.hrbu.meditalk.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;


@AiService(wiringMode = EXPLICIT,chatModel = "openAiChatModel",chatMemory = "chatMemory", chatMemoryProvider = "chatMemoryProvider")
public interface MemoryChatAssistant {
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId Integer id, @UserMessage  String message);
}
