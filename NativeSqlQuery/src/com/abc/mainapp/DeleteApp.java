package com.abc.mainapp;

import org.hibernate.Session;


import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Transaction transaction = session.beginTransaction();

			try {
				int rowCount = session.createSQLQuery("delete from EMPLOYEE where `ENO`=:eno").setParameter("eno", "7")
						.executeUpdate();
				transaction.commit();

				if (rowCount == 1) {
					System.out.println("Record got deleted");
				} else {
					System.out.println("Failed to delete the record");
				}
				
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
/*
Hibernate: delete from EMPLOYEE where `ENO`=?
Record got deleted
*/