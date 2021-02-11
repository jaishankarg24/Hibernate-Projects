package com.abc.factory;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.pojo.Branch;
import com.abc.pojo.Student;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Branch.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();

		} else {
			session = null;
		}
		return session;
	}

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}

	}

}
