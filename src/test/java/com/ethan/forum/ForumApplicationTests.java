package com.ethan.forum;

import com.ethan.forum.dao.UserMapper;
import com.ethan.forum.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class ForumApplicationTests {

	@Resource
	private DataSource dataSource;

	// 用户的Mapper
	@Resource
	private UserMapper userMapper;

	@Test
	void testConnection() throws SQLException {
		System.out.println("dataSource=" + dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println("connection=" + connection);
		connection.close();
	}

	@Test
	void testMybatis() {
		User user = userMapper.selectByPrimaryKey(1l);
		System.out.println(user);
		System.out.println(user.getUsername());
	}

	@Test
	void contextLoads() {
		System.out.println("基于Spring的前后端分离的论坛系统");
	}

	@Test
	void testUUID() {
		System.out.println(UUID.randomUUID().toString());
	}

}