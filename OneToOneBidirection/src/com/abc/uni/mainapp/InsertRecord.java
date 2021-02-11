package com.abc.uni.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Account;
import com.abc.pojo.Employee;

public class InsertRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Account account = new Account();
			account.setAccName("kohli");
			account.setAccType("current");

			Employee employee = new Employee();
			employee.setName("kohli");
			employee.setAddress("RCB");

			employee.setAccount(account);// Injecting the contained object into Container

			session.save(employee);

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			//HibernateUtil.close();
		}

	}

}
