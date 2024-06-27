package com.ethan.forum.controller;

import com.ethan.forum.commmon.AppResult;
import com.ethan.forum.commmon.ResultCode;
import com.ethan.forum.exception.ApplicationException;
import com.ethan.forum.model.Board;
import com.ethan.forum.service.IBoardService;
import io.micrometer.core.lang.NonNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "版块接口")
@RestController
@RequestMapping("/board")
public class BoardController {

    // 从配置文件中读取值 ，如果没有配置，默认值为9
    @Value("${bit-forum.index.board-num:9}")
    private Integer indexBoardNum;

    @Resource
    private IBoardService boardService;

    /**
     * 查询首版本列表
     * @return
     */
    @ApiOperation("获取首页版块列表")
    @GetMapping("/topList")
    public AppResult<List<Board>> topList () {
        log.info("首页版块个数为：" + indexBoardNum);
        // 调用Service查询结果
        List<Board> boards = boardService.selectByNum(indexBoardNum);
        // 判断是否为空
        if (boards == null) {
            boards = new ArrayList<>();
        }
        // 返回结果
        return AppResult.success(boards);
    }

    @ApiOperation("获取版块信息")
    @GetMapping("getById")
    public AppResult<Board> getById (@ApiParam("版块Id") @RequestParam("id") @NonNull Long id) {
        // 调用Service
        Board board = boardService.selectById(id);
        // 对查询结果进行校验
        if (board == null || board.getDeleteState() == 1) {
            // 打印日志
            log.warn(ResultCode.FAILED_BOARD_NOT_EXISTS.toString());
            // 抛出异常
            throw new ApplicationException(AppResult.failed(ResultCode.FAILED_BOARD_NOT_EXISTS));
        }
        // 返回结果
        return AppResult.success(board);
    }
}