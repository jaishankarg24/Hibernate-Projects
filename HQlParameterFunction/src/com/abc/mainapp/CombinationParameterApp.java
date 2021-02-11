package com.abc.mainapp;

import java.util.List;


import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class CombinationParameterApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		Scanner scanner = null;
		try {

			session = HibernateUtil.getSession();

			scanner = new Scanner(System.in);
			System.out.print("Enter the value of eid: ");

			int eno = scanner.nextInt();

			System.out.print("Enter the value of eage: ");

			int eage = scanner.nextInt();

			String hqlSelectQuery = "select e.eno,e.ename,e.eage from Employee as e where e.eno=? and e.eage=:eage";
			Query query = session.createQuery(hqlSelectQuery);
			query.setParameter(0, eno);
			query.setParameter("eage", eage);

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

Enter the value of eid: 7
Enter the value of eage: 39
Jan 16, 2021 1:13:49 PM org.hibernate.hql.internal.ast.HqlSqlWalker generatePositionalParameter
WARN: [DEPRECATION] Encountered positional parameter near line 1, column 73 in HQL: [select e.eno,e.ename,e.eage from com.abc.pojo.Employee as e where e.eno=? and e.eage=:eage].  Positional parameter are considered deprecated; use named parameters or JPA-style positional parameters instead.
Hibernate: select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.EAGE as col_2_0_ from EMPLOYEE employee0_ where employee0_.ENO=? and employee0_.EAGE=?
ENO	ENAME	ESALARY
7	dhoni	39	

*/