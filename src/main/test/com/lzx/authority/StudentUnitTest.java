package com.lzx.authority;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lzx.authority.server.IStudentServer;
import com.lzx.authority.server.IUserServer;
import com.lzx.basic.server.impl.BaseServer;


/**
 * 
 * @author LiZhiXian
 * @version 1.0
 * @date 2016-1-8 下午1:28:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/app-*.xml")
public class StudentUnitTest {

	@Autowired
	private IStudentServer studentServer;
	@Autowired
	private IUserServer userServer;
	@Autowired
	private BaseServer baseServer;
	@Test
	public void test(){
		studentServer.add();
		userServer.add();
		System.out.println(baseServer.getUsername());
	}
}
