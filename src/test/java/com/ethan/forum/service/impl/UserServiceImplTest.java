package com.ethan.forum.service.impl;

import com.ethan.forum.model.User;
import com.ethan.forum.service.IUserService;
import com.ethan.forum.utils.MD5Util;
import com.ethan.forum.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private IUserService userService;


    @Test
    @Transactional
    void createNormalUser() {
        User user = new User();
        user.setUsername("张三");
        user.setNickname("张三");

        // 定义一个原始的密码
        String password = "123456";
        // 生成盐
        String salt = UUIDUtil.UUID_32();
        // 生成密码的密文
        String ciphertext = MD5Util.md5Salt(password, salt);
        // 设置加密后的密码
        user.setPassword(ciphertext);
        // 设置盐
        user.setSalt(salt);
        // 调用Service层的方法
        userService.createNormalUser(user);
        // 打印结果
        System.out.println(user);
    }

    @Test
    void selectByUserName() {
        User user = userService.selectByUserName("bitboy");
        System.out.println(user);
    }

    @Test
    void login() {
        User user = userService.login("张三", "123456");
        System.out.println(user);

    }

    @Test
    void selectById() {
        User user = userService.selectById(1l);
        System.out.println(user);
    }

    @Test
    @Transactional
    void addOneArticleCountById() {
        userService.addOneArticleCountById(2L);
        System.out.println("更新成功");
    }

    @Test
    @Transactional
    void subOneArticleCountById() {
        userService.subOneArticleCountById(2l);
        System.out.println("更新成功");
    }

    @Test
    @Transactional
    void modifyInfo() {
        User user = new User();
        user.setId(3l); // 用户Id
        user.setUsername("李四"); // 登录名
        user.setNickname("李四"); // 昵称
        user.setGender(null); // 性别
        user.setEmail("qqq@qq.com");// 邮箱
        user.setPhoneNum("15366668888"); // 电话
        user.setRemark("测试"); // 个人简介
        // 调用Service
        userService.modifyInfo(user);
    }

    @Test
    @Transactional
    void modifyPassword() {
        userService.modifyPassword(2l,"123456","123456");
        System.out.println("更新成功");
    }
}