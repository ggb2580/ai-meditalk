package com.hrbu.meditalk.dto;

import lombok.Data;

@Data
public class ChatForm {
    //对话ID
    private Long memoryId;
    //用户问题
    private String message;
}
