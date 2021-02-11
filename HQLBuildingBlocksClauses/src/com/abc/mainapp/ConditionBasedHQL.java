package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;

public class ConditionBasedHQL {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			//where
			Query query = session.createQuery(
					"select e.eno,e.ename,e.esalary from Employee e where e.esalary<=50000 and e.esalary>=45000 order by e.ename");
			List<Object[]> employeeList = query.list();

			if (employeeList.isEmpty()) {
				System.out.println("No records found");
			} else {
				System.out.println("ENO\tENAME\tESALARY");

				// retrieving the records on the basis of selection
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}

			}

			System.out.println();
			
			//order by
			List<Long> resultList = session.createQuery("select sum(e.esalary) from Employee as e group by e.ename")
					.list();
			System.out.println("The total salary is :" + resultList.get(0));

			System.out.println();
			
			//having
			List<Long> results = session
					.createQuery("select count(e.esalary)from Employee  as e group by e.esalary having e.esalary>=5000")
					.list();
			System.out.println("The count is :" + results.get(0));

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

Hibernate: select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.ESALARY as col_2_0_ from EMPLOYEE employee0_ where employee0_.ESALARY<=50000 and employee0_.ESALARY>=45000 order by employee0_.ename
ENO	ENAME	ESALARY
7	dhoni	49000	
10	sachin	50000	

Hibernate: select sum(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_ group by employee0_.ename
The total salary is :49000

Hibernate: select count(employee0_.ESALARY) as col_0_0_ from EMPLOYEE employee0_ group by employee0_.ESALARY having employee0_.ESALARY>=5000
The count is :1
*/