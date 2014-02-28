package com.amos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.amos.model.Person;

/** 
* @ClassName: PersonDao 
* @Description: 用户dao
* @author: amosli
* @email:amosli@infomorrow.com
* @date 2014年2月28日 下午6:01:19  
*/
public class PersonDao {
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
	// SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		createSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person person = new Person();
		person.setAge(18);
		person.setName("amosli");
		session.save(person);
		session.getTransaction().commit();
		session.close();
		System.exit(0);
	}

	public static SessionFactory createSessionFactory() {
		Configuration cfg = new Configuration().configure();
		System.out.println("cfg.getProperties():" + cfg.getProperties());
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(build);
		return sessionFactory;
	}

}
