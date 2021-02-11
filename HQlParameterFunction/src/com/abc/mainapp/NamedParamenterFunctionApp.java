package com.abc.mainapp;

import java.util.List;


import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class NamedParamenterFunctionApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		Scanner scanner = null;
		try {

			session = HibernateUtil.getSession();

			scanner = new Scanner(System.in);
			System.out.print("Enter the value of sid: ");

			int eno = scanner.nextInt();

			Query query = session.createQuery("select e.eno,e.ename,e.esalary from Employee as e where e.eno=:eno");
			query.setParameter("eno", eno);

			List<Object[]> employeeList = query.list();

			if (!employeeList.isEmpty()) {
				System.out.println("ENO\tENAME\tESALARY");
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}
			} else {
				System.out.println("No record found for : " + eno);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {

				HibernateUtil.close();
				scanner.close();
			}
		}

	}

}
/*
Enter the value of sid: 7
Hibernate: select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.ESALARY as col_2_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
ENO	ENAME	ESALARY
7	dhoni	49000	
*/