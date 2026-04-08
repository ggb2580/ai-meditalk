package com.hrbu.meditalk.curd;

import com.hrbu.meditalk.assistant.MemoryChatAssistant;
import com.hrbu.meditalk.entity.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest

public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    /*
    * 根据id删除数据
    * */
    @Test
    public void demo7(){
        Criteria criteria = Criteria.where("_id").is(5);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class,"chat_messages");

    }

    @Test
    public void demo6(){
        Criteria criteria = Criteria.where("_id").is(1);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content","GGB 嘿嘿嘿 🙂");
        update.set("memoryId",1);
        mongoTemplate.upsert(query,update, ChatMessages.class);
    }

    /*
    * 新增数据
    * */
    @Test
    public void demo5(){
        Criteria criteria = Criteria.where("_id").is(5);
        Query query = new Query(criteria);
        Update update = new Update();
        Integer memoryId = 1;
        String chat = memoryChatAssistant.chat(memoryId, "帮我出一道HR面试题");
        update.set("content",chat);
        update.set("memoryId",memoryId);
        mongoTemplate.upsert(query,update, ChatMessages.class);
    }

    /*
    * 修改文档
    * */
    @Test
    public void demo4(){
        Criteria criteria = Criteria.where("_id").is(1);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content","全力以赴，相信自己，取得成功!");
        mongoTemplate.updateFirst(query,update, ChatMessages.class);

    }

    /*
     * 根据id查询
     * */
    @Test
    public void demo3(){
        ChatMessages chatMessages = mongoTemplate.findById(1, ChatMessages.class);
        assert chatMessages != null;
        System.out.println(chatMessages.getContent());
    }
    @Test
    public void demo1(){
        ChatMessages chatMessages = new ChatMessages(1,2,"hello MongoDB");
        mongoTemplate.insert(chatMessages);
    }
    @Test
    public void demo2(){
        String chat = memoryChatAssistant.chat(1, "帮我罗列出10道医疗实施岗HR面试题");
        System.out.println(chat);
        mongoTemplate.insert(new ChatMessages(2,2,chat));
    }


}
