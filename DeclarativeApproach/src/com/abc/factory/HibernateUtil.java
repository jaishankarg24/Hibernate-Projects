package com.abc.factory;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static  Session session;
	
	static {
		Configuration configuration=new Configuration();
		
		try {
				String path="E:\\NewJava\\Hibernate projects\\DeclarativeApproach\\src\\jdbc.properties";
				FileInputStream fileInputStream = new FileInputStream(path);
				Properties properties = new Properties();
				properties.load(fileInputStream);
				
				configuration.addProperties(properties);
				
				configuration.addAnnotatedClass(Employee.class);
				
				sessionFactory = configuration.buildSessionFactory();
						
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
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
