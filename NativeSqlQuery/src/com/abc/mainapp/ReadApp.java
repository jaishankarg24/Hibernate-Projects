package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.factory.HibernateUtil;

public class ReadApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			List<Object[]> employee = session
					.createSQLQuery("select `ENO`,`ENAME`,`EAGE` from `EMPLOYEE` where `ENO`=7")
					.getResultList();

			System.out.println("ENO\tENAME\tEAGE");

			for (Object[] emp : employee) {
				System.out.println(emp[0] + "\t" + emp[1] + "\t" + emp[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}

/*

Hibernate: select `ENO`,`ENAME`,`EAGE` from `EMPLOYEE` where `ENO`=7
ENO	ENAME	EAGE
7	dhoni	39

*/