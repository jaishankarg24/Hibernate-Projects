package com.abc.mainapp;


import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class CreateRecordApp {

	public static void main(String[] args) {

		try {

			Session session = HibernateUtil.getSession();
			int eid = 24;
			Employee employeeRecord = session.get(Employee.class, eid);
			if (employeeRecord == null) {
				Transaction transaction = session.beginTransaction();

				Employee employee = new Employee();
				employee.setEno(24);
				employee.setEname("ganguly");
				employee.setEage(49);
				employee.setEaddress("KKR");

				int pkId = (int) session.save(employee);

				transaction.commit();
				System.out.println("Employee record inserted with the id :" + pkId);

			} else {
				System.out.println("Employee record already avaialble with the id :" + eid);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}
/*
Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ename as ename4_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Hibernate: insert into EMPLOYEE (EADDRESS, EAGE, ename, ENO) values (?, ?, ?, ?)
Employee record inserted with the id :24
*/