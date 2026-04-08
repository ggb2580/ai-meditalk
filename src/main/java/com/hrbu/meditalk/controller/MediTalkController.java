package com.hrbu.meditalk.controller;

import com.hrbu.meditalk.assistant.MediTalkChatAssitant;
import com.hrbu.meditalk.dto.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/xiaozhi")
public class MediTalkController {
    @Autowired
    private MediTalkChatAssitant mediTalkChatAssitant;
    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm){
        return mediTalkChatAssitant.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }
}
