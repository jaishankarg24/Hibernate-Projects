package com.abc.mainapp;

import java.util.List;


import org.hibernate.query.Query;

import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class LogicalExpressionApp {

	public static void main(String[] args) {
		
		Session session = null;
		try {
			
			session = HibernateUtil.getSession();
			
			speicalOperatorApp(session);
			System.out.println();
			
			scalarOperations(session);
			System.out.println();
			
			LogicalOperations(session);
			
			
			/*
			String hqlSelectQuery ="select e.eno, e.ename, e.esalary from Employee e where e.esalary>35000 AND e.esalary<45000";
			Query query= session.createQuery(hqlSelectQuery);
			List<Object[]> employees = query.getResultList();
			
			if(employees.isEmpty()) {
				System.out.println("No Records");
			}
			else {
				System.out.println("ENO\tENAME\tESALARY");
				
				for(Object[] employee : employees) {
					for(Object empRecord:employee) {
						System.out.print(empRecord+"\t");
					}
					System.out.println();
				}
			}
			*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				HibernateUtil.close();
			}
		}

	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void speicalOperatorApp(Session session) {
		String hqlSelectQuery = "select e.ename,e.eage,e.esalary from Employee e where e.esalary BETWEEN 35000 AND 46000";
		Query query = session.createQuery(hqlSelectQuery);
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENAME\tEAGE\tESALARY");

			for (Object[] employee : employees) {
				for (Object emp : employee) {
					System.out.print(emp + "\t");
				}
				System.out.println();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static void scalarOperations(Session session) {
		Query query = session.createQuery("select lower(e.ename),e.eage,upper(e.eaddress) from Employee e");
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENAME\tEAGE\tEADDRESS");

			for (Object[] employee : employees) {
				for (Object emp : employee) {
					System.out.print(emp + "\t");
				}
				System.out.println();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static void LogicalOperations(Session session) {
		String hqlSelectQuery = "select e.eno,e.ename,e.esalary from Employee e where e.esalary>35000 AND e.esalary<=45000";
		Query query = session.createQuery(hqlSelectQuery);
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENO\tENAME\tESALARY");

			for (Object[] employee : employees) {
				for (Object empRecord : employee) {
					System.out.print(empRecord + "\t");
				}
				System.out.println();
			}
		}
	}

}


/*
 Hibernate: select employee0_.ename as col_0_0_, employee0_.EAGE as col_1_0_, employee0_.ESALARY as col_2_0_ from EMPLOYEE employee0_ where employee0_.ESALARY between 35000 and 46000
No Records

Hibernate: select lower(employee0_.ename) as col_0_0_, employee0_.EAGE as col_1_0_, upper(employee0_.EADDRESS) as col_2_0_ from EMPLOYEE employee0_
ENAME	EAGE	EADDRESS
dhoni	39	RANCHI	
sachin	48	MUMBAI	

Hibernate: select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.ESALARY as col_2_0_ from EMPLOYEE employee0_ where employee0_.ESALARY>35000 and employee0_.ESALARY<=45000
No Records

*/
