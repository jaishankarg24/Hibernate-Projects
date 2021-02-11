package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class SumAvgApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select sum(e.esalary) from Employee as e";
			List<Long> employeeTotalSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("Total Salary of employee is :" + employeeTotalSalary.get(0));

			System.out.println();

			hqlSelectQuery = "select avg(e.esalary) from Employee as e";
			employeeTotalSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("Avergage Salary of employee is :" + employeeTotalSalary.get(0));
			

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
Hibernate: select sum(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_
Total Salary of employee is :99000

Hibernate: select avg(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_
Avergage Salary of employee is :49500.0
*/