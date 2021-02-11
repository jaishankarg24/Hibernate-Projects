package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class MinMaxApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select min(e.esalary) from Employee as e";
			List<Long> employeeminSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("The minium salary is :" + employeeminSalary.get(0));

			System.out.println();

			hqlSelectQuery = "select max(e.esalary) from Employee as e";
			List<Long> employeemaxSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("The maximum salary is :" + employeemaxSalary.get(0));

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
Hibernate: select min(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_
The minium salary is :49000

Hibernate: select max(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_
The maximum salary is :50000
*/