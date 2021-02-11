package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class PositionalParameterFunctionApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			List<Object[]> employeeList = session
					.createQuery("select e.eno,e.ename,e.eage,e.esalary from Employee as e where e.eno=?")
					.setParameter(0, 10).list();
			
			if (!employeeList.isEmpty()) {
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}
			} else {
				System.out.println("No record found");
			}

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

Hibernate: select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.EAGE as col_2_0_, employee0_.ESALARY as col_3_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
10	sachin	48	50000

*/