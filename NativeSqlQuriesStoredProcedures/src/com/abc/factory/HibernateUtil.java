package com.abc.factory;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.pojo.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();

		} else {
			session = null;
		}
		return session;
	}

}
