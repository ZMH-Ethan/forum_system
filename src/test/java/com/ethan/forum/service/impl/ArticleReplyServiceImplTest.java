package com.ethan.forum.service.impl;

import com.ethan.forum.model.ArticleReply;
import com.ethan.forum.service.IArticleReplyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleReplyServiceImplTest {

    @Resource
    private IArticleReplyService articleReplyService;
    @Resource
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void create() {
        ArticleReply articleReply = new ArticleReply();
        articleReply.setArticleId(19l);
        articleReply.setPostUserId(2l);
        articleReply.setContent("单元测试回复");
        articleReplyService.create(articleReply);
        System.out.println("回复成功");
    }

    @Test
    void selectByArticleId() throws JsonProcessingException {
        List<ArticleReply> articleReplies = articleReplyService.selectByArticleId(19l);
        System.out.println(objectMapper.writeValueAsString(articleReplies));
    }
}