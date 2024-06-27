package com.ethan.forum.controller;

import com.ethan.forum.commmon.AppResult;
import com.ethan.forum.exception.ApplicationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试类的相关接口")
@RestController
@RequestMapping("/test")
public class TsetController {

    @ApiOperation("测试接口1，显示你好Spring boot")
    @GetMapping("/hello")
    public String Hello() {
        return "Hello,Spring Boot";
    }

    @ApiOperation("测试接口4，按传入的姓名显示你好信息")
    @PostMapping("/helloByName")
    public AppResult helloByName (@ApiParam(value = "姓名") @RequestParam("name") String name) {
        return AppResult.success("hello : " + name);
    }

    @ApiOperation("测试接口2，显示抛出的异常信息")
    @GetMapping("/exception")
    public AppResult testException () throws Exception {
        throw new Exception("这是一个exception...");
    }
    @ApiOperation("测试接口3，显示抛出的自定义的异常信息")
    @GetMapping("/appException")
    public AppResult testApplicationException () {
        throw new ApplicationException("这是一个ApplicationException...");
    }
}
