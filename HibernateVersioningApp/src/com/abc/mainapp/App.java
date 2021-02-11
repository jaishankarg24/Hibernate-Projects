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
			session = HibernateUtil.getSession();
			Employee employee = session.get(Employee.class, 10);

			if (session != null) {
				
				/*
				Employee employee1 = new Employee();
				employee1.setEno(10);
				employee1.setEname("sachin");
				employee1.setEage(49);
				employee1.setEaddress("mi");
				
				transaction = session.beginTransaction();
				
				int pkId = (int) session.save(employee1);
				
				transaction.commit();
				
				System.out.println("Employee object got saved to the DB with the id:"+pkId);
			
				
				**/
				transaction = session.beginTransaction();

				employee.setEname("sachinrameshTendulkar");
				employee.setEage(49);

				session.update(employee);

				transaction.commit();
				System.out.println("Object modified : " + employee.getVersion() +" times!!!");
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
Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ename as ename4_0_0_, employee0_.VERSION as version5_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Hibernate: insert into EMPLOYEE (EADDRESS, EAGE, ename, VERSION, ENO) values (?, ?, ?, ?, ?)
Employee object got saved to the DB with the id:10


Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ename as ename4_0_0_, employee0_.VERSION as version5_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Hibernate: update EMPLOYEE set EADDRESS=?, EAGE=?, ename=?, VERSION=? where ENO=? and VERSION=?
Object modified : 1 times!!!
*/