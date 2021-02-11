package com.abc.factory;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.model.Employee;

public class HibernateUtil {
	private static Session session;
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

	}

	public static Session getSessionObject() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
