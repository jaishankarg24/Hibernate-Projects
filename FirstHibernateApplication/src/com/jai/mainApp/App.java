package com.jai.mainApp;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jai.pojo.Employee;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		//Transaction transaction = session.beginTransaction();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		
		Employee employee=new Employee();
		employee.setEno(01);
		employee.setEname("rahul");
		employee.setEage(26);
		employee.setEaddress("pun");
		
		//session.save(employee);
		
		//int pkId = (int) session.save(employee);
		
		session.persist(employee);
		transaction.commit();
		
		//System.out.println("Employee record got saved to DATABASE with the id:"+pkId);
		System.out.println("Employee record got saved to DATABASE with the id:"+employee.getEno());
		
		sessionFactory.close();

	}

}

/*
 Hibernate: insert into Employee (ename, eage, eaddress, eno) values (?, ?, ?, ?)   <--- client dialect information(automatically seleted by Hibernate software, Query)
Employee record got saved to DATABASE with the id:1

*/
