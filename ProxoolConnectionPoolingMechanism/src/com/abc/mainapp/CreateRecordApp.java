package com.abc.mainapp;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Student;

public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Transaction transaction = session.getTransaction();
			transaction.begin();

			Serializable pkId = session.save(new Student("dhoni", 39, "CSK", "50000"));
			transaction.commit();
			System.out.println("Object saved with the id :" + pkId);
			HibernateUtil.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
Hibernate: 
// insert com.abc.pojo.Student
    // insert 
    into
        STUDENT
        (EADDRESS, EAGE, ename, ESALARY) 
    values
        (?, ?, ?, ?)
Object saved with the id :2
*/