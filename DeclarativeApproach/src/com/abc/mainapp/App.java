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

			if (session != null) {
				int eid = 7;
				Employee employeeRecord = session.get(Employee.class, eid);
				if (employeeRecord == null) {
					transaction = session.beginTransaction();

					Employee employee = new Employee();
					employee.setEno(7);
					employee.setEname("Dhoni");
					employee.setEage(39);
					employee.setEaddress("csk");

					int pkId = (int) session.save(employee);

					transaction.commit();
					System.out.println("Employee record inserted with the id :" + pkId);

				} else {
					System.out.println("Employee record already avaialble with the id :" + eid);

				}
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}

/*
Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ENAME as ename4_0_0_ from EMPLOYEE employee0_ where employee0_.ENO=?
Hibernate: insert into EMPLOYEE (EADDRESS, EAGE, ENAME, ENO) values (?, ?, ?, ?)
Employee record inserted with the id :7
*/