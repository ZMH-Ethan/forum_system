package com.ethan.forum.service.impl;

import com.ethan.forum.model.Board;
import com.ethan.forum.service.IBoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BoardServiceImplTest {

    @Resource
    private IBoardService boardService;
    @Resource
    private ObjectMapper objectMapper;

    @Test
    void selectByNum() {
        List<Board> boards = boardService.selectByNum(1);
        System.out.println(boards);
    }

    @Test
    @Transactional //测试完成后回滚数据库操作
    void addOneArticleCountById() {
        boardService.addOneArticleCountById(1L);
        System.out.println("更新成功");
    }

    @Test
    void selectById() throws JsonProcessingException {
        Board board = boardService.selectById(10L);
        System.out.println(objectMapper.writeValueAsString(board));
    }

    @Test
    @Transactional
    void subOneArticleCountById() {
        boardService.subOneArticleCountById(2l);
        System.out.println("更新成功");
    }
}