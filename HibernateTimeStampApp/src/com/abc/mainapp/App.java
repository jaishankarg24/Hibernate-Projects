package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.model.Employee;

public class App {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionObject();
			Employee employee = session.get(Employee.class, 10);

			if (session != null) {
				/*
				transaction = session.beginTransaction();
				Employee employee1 = new Employee(10, "sachin", 48, "mumbai");
				
				int pkId = (int) session.save(employee1);
				transaction.commit();
				
				System.out.println("Employee object saved with the Id :"+pkId);
				System.out.println("The Employee records are:" +employee1);
				System.out.println("Account got created at:"+employee1.getTimeStamp());
			
				*/   //*
				
				transaction = session.beginTransaction();
				employee.setEname("sachinrameshtendulkar");
				session.save(employee);

				transaction.commit();
				System.out.println("Object modified at :" + employee.getTimeStamp()); 
				//*/
			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}

/*
 * Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ENAME as ename4_0_0_, employee0_.TIMESTAMP as timestam5_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Hibernate: insert into EMPLOYEE (EADDRESS, EAGE, ENAME, TIMESTAMP, ENO) values (?, ?, ?, ?, ?)
Employee object saved with the Id :10
The Employee records are:Employee [eno=10, ename=sachin, eage=48, eaddress=mumbai]
Account got created at:Fri Jan 15 16:26:08 IST 2021

Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ENAME as ename4_0_0_, employee0_.TIMESTAMP as timestam5_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Employee object created by HBN software!!!!
Setting ENAME
Hibernate: update EMPLOYEE set EADDRESS=?, EAGE=?, ENAME=?, TIMESTAMP=? where ENO=?
Object modified at :Fri Jan 15 16:27:49 IST 2021
*/
