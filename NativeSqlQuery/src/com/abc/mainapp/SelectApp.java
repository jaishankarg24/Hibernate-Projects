package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class SelectApp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			// 1.create the query
			NativeQuery query = session.createSQLQuery("select * from `EMPLOYEE`");
			query.addEntity(Employee.class);

			// 2.Execute the query
			List<Employee> employees = query.getResultList();

			// 3.Display the result
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
Hibernate: select * from `EMPLOYEE`
[eno=7, ename=dhoni, eage=39, eaddress=ranchi, esalary=49000]
[eno=10, ename=sachin, eage=48, eaddress=mumbai, esalary=50000]

*/