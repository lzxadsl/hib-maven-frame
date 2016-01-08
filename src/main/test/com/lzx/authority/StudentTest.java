package com.lzx.authority;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzx.authority.entity.Student;


/**
 * 
 * @author LiZhiXian
 * @version 1.0
 * @date 2016-1-8 上午9:07:03
 */
public class StudentTest {

	/**
	 * 采用配置
	 * @author LiZhiXian
	 * @version 1.0
	 * @date 2016-1-8 上午10:32:46
	 */
	public void cfgTest(){
        Configuration cfg = new Configuration().configure("/config/hibernate.cfg.xml");  
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()  
                            .applySettings(cfg.getProperties()).build();  
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Student stu = new Student();
		stu.setName("李智贤");
		stu.setSex("男");
		try {
			session.save(stu);
			//throw new Exception("模拟出错");
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		System.out.println("------------------------");
		tran.commit();
		session.close();
		sessionFactory.close();
	}
	/**
	 * 整合Spring
	 * @author LiZhiXian
	 * @version 1.0
	 * @date 2016-1-8 上午10:33:28
	 */
	public void springCfgTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/spring/app-*.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Student stu = new Student();
		stu.setName("Spring");
		stu.setSex("男");
		try {
			session.save(stu);
			stu.setId(1);
			session.save(stu);
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		System.out.println("------------------------");
		tran.commit();
		session.close();
		sessionFactory.close();
	}
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/spring/app-*.xml");
		//SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		//StudentTest test = new StudentTest();
		//test.cfgTest();
		//test.springCfgTest();
		System.out.println("---");
	}
}
