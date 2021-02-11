package com.abc.mainapp;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Transaction transaction = session.getTransaction();
			transaction.begin();

			
			Serializable pkId = session.save(new Employee(12, "shewag", 45, "dd", "40000"));
			//Serializable pkId = session.save(new Employee("dhoni",35,"csk","55555"));
			//Serializable pkId = session.save(new Employee("sachin",45,"mi","50000"));
			
			
			transaction.commit();
			System.out.println("Object saved with the id :" + pkId);
			HibernateUtil.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
