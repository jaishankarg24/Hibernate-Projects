package com.abc.uni.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class DeleteRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			int id = 2;
			Employee employee = session.get(Employee.class, id);
			System.out.println("Employee Info is : " + employee);
			System.out.println("The Account Information is :" + employee.getAccount());

			if (employee != null) {
				transaction = session.beginTransaction();

				session.delete(employee);

			}
			transaction.commit();
			System.out.println("The object getting delted is :" + employee);
			System.out.println("The Account Information is :" + employee.getAccount());

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtil.close();
		}

	}

}
