package com.ethan.forum.service.impl;

import com.ethan.forum.model.Article;
import com.ethan.forum.service.IArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class ArticleServiceImplTest {

    @Resource
    private IArticleService articleService;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void create() {
        Article article = new Article();
        article.setUserId(3L); // 张三
        article.setBoardId(2L); // java版块
        article.setTitle("单元测试");
        article.setContent("测试内容");
        articleService.create(article);
        System.out.println("发贴成功");
    }

    @Test
    void selectAll() throws JsonProcessingException {
        //调用Service层
        List<Article> articles = articleService.selectAll();
        //转换成JSON字符串并打印
        System.out.println(objectMapper.writeValueAsString(articles));
    }

    @Test
    void selectAllByBoardId() throws JsonProcessingException {
        List<Article> articles = articleService.selectAllByBoardId(1l);
        System.out.println(objectMapper.writeValueAsString(articles));
    }

    @Test
    void selectDetailById() throws JsonProcessingException {
        Article article = articleService.selectDetailById(19l);
        System.out.println(objectMapper.writeValueAsString(article));
    }

    @Test
    @Transactional
    void modify() {
        articleService.modify(19l,"单元测试","测试内容");
        System.out.println("更新成功");
    }

    @Test
    @Transactional
    void thumbsUpById() {
        articleService.thumbsUpById(19l);
        System.out.println("点赞成功");
    }

    @Test
    @Transactional
    void deleteById() {
        articleService.deleteById(24l);
        System.out.println("删除成功");
    }

    @Test
    @Transactional
    void addOneReplyCountById() {
        articleService.addOneReplyCountById(27l);
        System.out.println("更新成功");
    }

    @Test
    void selectByUserId() throws JsonProcessingException {
        List<Article> articles = articleService.selectByUserId(2l);
        System.out.println(objectMapper.writeValueAsString(articles));
    }
}