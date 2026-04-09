package com.hrbu.meditalk;

import com.hrbu.meditalk.assistant.MediTalkChatAssitant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private MediTalkChatAssitant mediTalkChatAssitant;

    @Test
    public void test(){
        String chat = mediTalkChatAssitant.chat(13L, "帮我查一下我的预约记录");
        System.out.println(chat);

        //模拟用户预约挂号
        String name = "张三";
        String department = "内科";
        String date = "2026-04-10";
        String time = "上午";

        String info = "姓名："+name +"预约科室："+department+"预约日期："+date+"预约时间："+time;
        String chat1 = mediTalkChatAssitant.chat(13L, info);
        System.out.println(chat1);
    }

    @Test
    public void test02(){
        String chat = mediTalkChatAssitant.chat(13L, "帮我删除我的预约信息");
        System.out.println(chat);
        String chat1 = mediTalkChatAssitant.chat(13L, "身份证：34123243421213211X,日期：2026-04-20");
        System.out.println(chat1);

    }

    /*
    * 文档加载器
    * */
    @Test
    public void test03(){
        Document document = FileSystemDocumentLoader.loadDocument(
                "E:\\ocdata\\Desktop\\java-ai-langchain4j-medical\\rag文档\\科室信息.pdf",
                new ApachePdfBoxDocumentParser());
        System.out.println(document.text());
    }
}
