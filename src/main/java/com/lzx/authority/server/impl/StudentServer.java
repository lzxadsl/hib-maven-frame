package com.lzx.authority.server.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		//使用getCurrentSession时，必须开启事物，否则会报错
		return sessionFactory.getCurrentSession();
	}
	
	private Session getNewSession(){
		return sessionFactory.openSession();
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
		stu.setName("李智贤2");
		stu.setSex("男");
		getSession().save(stu);
		stu.setName("李智贤1");
		getSession().update(stu);
		/*Student stu1 = new Student();
		stu1.setName("李智贤");
		stu1.setSex("男");
		getSession().save(stu1);*/
		//throw new RuntimeException("出错啦，事物要回滚...");
	}

	/**
	 * 
	 * @author LiZhiXian
	 * @version 1.0
	 * @date 2016-1-11 上午10:41:39
	 */
	@Override
	@Transactional
	public void query() {
		Student stu1 = (Student) getSession().get(Student.class,16);
		System.out.println("------------1--------------"+stu1.getName());
		Student stu2 = (Student) getSession().get(Student.class,16);
		System.out.println("------------2--------------"+stu2.getName());
	}

	public void find(){
		Session session1 = getNewSession();
		Transaction tran1 = session1.beginTransaction();
		Student stu1 = (Student) session1.get(Student.class,100);
		System.out.println("------------1--------------"+(stu1==null));
		tran1.commit();
		session1.close();
		
		Session session2 = getNewSession();
		Transaction tran2 = session2.beginTransaction();
		Student stu2 = (Student) session2.load(Student.class,16);
		System.out.println("------------2--------------"+(stu2));
		//stu2.getName();
		tran2.commit();
		session2.close();
	}
}
