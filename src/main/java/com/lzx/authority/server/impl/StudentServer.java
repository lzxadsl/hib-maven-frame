package com.lzx.authority.server.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzx.authority.entity.Student;
import com.lzx.authority.server.IStudentServer;

/**
 * 
 * @author LiZhiXian
 * @version 1.0
 * @date 2016-1-8 下午1:51:15
 */
@Service
public class StudentServer implements IStudentServer {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @author LiZhiXian
	 * @version 1.0
	 * @date 2016-1-8 下午1:51:15
	 */
	@Override
	@Transactional
	public void add() {
		Student stu = new Student();
		stu.setName("李智贤");
		stu.setSex("男");
		getSession().save(stu);
	}

}
