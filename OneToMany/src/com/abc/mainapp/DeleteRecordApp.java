package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class DeleteRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			int eid = 1;
			Employee employee = session.get(Employee.class, eid);// 1:M Department=========>Employee
			System.out.println(employee);

			if (employee != null) {
				transaction = session.beginTransaction();

				session.delete(employee);

				transaction.commit();

				System.out.println("Employee Object with the id removed from db: " + eid);
			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtil.close();
		}

	}

}

/*
 * Hibernate: 
    select
        employee0_.EID as eid1_1_0_,
        employee0_.EADDRESS as eaddress2_1_0_,
        employee0_.ENAME as ename3_1_0_ 
    from
        EMPLOYEE employee0_ 
    where
        employee0_.EID=?
Employee [eid=1, ename=saurav, eaddress=KKR]
Hibernate: 
    delete 
    from
        EMPLOYEE 
    where
        EID=?
Employee Object with the id removed from db: 1
*/
