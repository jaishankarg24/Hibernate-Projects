package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class RetrieveALLRecords {

	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			List<Employee> employees = session.createQuery("FROM Employee e", Employee.class).list();
			System.out.println("ENO\tENAME\tEAGE\tESALARY");
			for (Employee employee : employees) {
				System.out.println(employee.getEno() + "\t" + employee.getEname() + "\t" + employee.getEage() + "\t"
						+ employee.getEsalary());
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
Hibernate: select employee0_.ENO as eno1_0_, employee0_.EAGE as eage2_0_, employee0_.ename as ename3_0_, employee0_.ESALARY as esalary4_0_ from EMPLOYEE employee0_
Employee Object created by HBN software!!!
Employee Object created by HBN software!!!
ENO	ENAME	EAGE	ESALARY
7	dhoni	39	49000
10	sachin	48	50000

*/