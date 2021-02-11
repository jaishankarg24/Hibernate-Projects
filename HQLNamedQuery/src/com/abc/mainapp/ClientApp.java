package com.abc.mainapp;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class ClientApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		Transaction transaction=null;
		
		try {
			session=HibernateUtil.getSession();
			/*
			Query query=session.getNamedQuery("getEmployee");
			List<Employee> employees=query.getResultList();
			*/
			
			/*
			@SuppressWarnings("unchecked")
			List<Employee> employees= session.getNamedQuery("getEmployee").getResultList();
					
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			*/
			
			
			@SuppressWarnings("unchecked")
			List<Employee> employees= session.getNamedQuery("getEmployees").getResultList();
			
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			
			System.out.println();
			
			transaction=session.beginTransaction();
			
			int rowCount=session.getNamedQuery("deleteEmployee").executeUpdate();
			System.out.println(rowCount+"record got deleted");
			
			transaction.commit();
			//*/
			
			
			displayRecord(session);
			/*
			transaction = session.beginTransaction();

			int rowCount = session.getNamedQuery("deleteEmployee").executeUpdate();
			System.out.println(rowCount + " record got deleted");

			transaction.commit();

			displayRecord(session);
			*/
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				HibernateUtil.close();
			}
		}

	}
	@SuppressWarnings("unchecked")
	private static void displayRecord(Session session) {
		List<Employee> employees = session.getNamedQuery("getEmployees").getResultList();
		System.out.println();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println();
	}
	

}

/*

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachinTendulkar, eage=48, eaddress=MUMBAIINDIANS]

----------------------------------------------------------------------------------
Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachinTendulkar, eage=48, eaddress=MUMBAIINDIANS]

Hibernate: delete from EMPLOYEE where ENO=45
0record got deleted
Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_

Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachinTendulkar, eage=48, eaddress=MUMBAIINDIANS]
---------------------------------------------------------------------------------------

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachinTendulkar, eage=48, eaddress=MUMBAIINDIANS]

Hibernate: delete from EMPLOYEE where ENO=10
1record got deleted
Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_

Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
*/