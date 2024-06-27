package com.ethan.forum.service.impl;

import com.ethan.forum.model.Message;
import com.ethan.forum.service.IMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MessageServiceImplTest {

    @Resource
    private IMessageService messageService;
    @Resource
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void create() {
        Message message = new Message();
        message.setPostUserId(2l);
        message.setReceiveUserId(3l);
        message.setContent("单元测试");
        messageService.create(message);
        System.out.println("发送成功");

    }

    @Test
    void selectUnreadCount() {
        Integer count = messageService.selectUnreadCount(2l);
        System.out.println("未读数量为： " + count);
        count = messageService.selectUnreadCount(2l);
        System.out.println("未读数量为： " + count);
        count = messageService.selectUnreadCount(3l);
        System.out.println("未读数量为： " + count);
    }

    @Test
    void selectByReceiveUserId() throws JsonProcessingException {
        List<Message> messages = messageService.selectByReceiveUserId(2l);
        System.out.println(objectMapper.writeValueAsString(messages));

        messages = messageService.selectByReceiveUserId(4l);
        System.out.println(objectMapper.writeValueAsString(messages));

        messages = messageService.selectByReceiveUserId(3l);
        System.out.println(objectMapper.writeValueAsString(messages));
    }

    @Test
    @Transactional
    void updateStateById() {
        messageService.updateStateById(2l, (byte) 1);
        System.out.println("更新成功");
    }

    @Test
    void selectById() throws JsonProcessingException {
        Message message = messageService.selectById(1l);
        System.out.println(objectMapper.writeValueAsString(message));
    }

    @Test
    void reply() {
        // 构建对象
        Message message = new Message();
        message.setPostUserId(2l);
        message.setReceiveUserId(3l);
        message.setContent("单元测试回复");
        // 调用service
        messageService.reply(2l, message);
        System.out.println("回复成功");
    }
}