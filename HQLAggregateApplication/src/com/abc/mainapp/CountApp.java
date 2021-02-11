package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class CountApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select count(e.ename) from Employee as e";
			List<Long> employees = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("The count of employees is :" + employees.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
/*
Hibernate: select count(employee0_.ename) as col_0_0_ from EMPLOYEE employee0_
The count of employees is :2
*/