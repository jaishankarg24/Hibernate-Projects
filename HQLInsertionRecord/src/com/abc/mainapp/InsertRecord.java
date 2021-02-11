package com.abc.mainapp;


import org.hibernate.Session;


import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;

public class InsertRecord {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session= HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			/*
			Query query=session.createQuery("insert into Cricketer(eno, ename, eage, eaddress) select e.eno, e.ename, e.eage, e.eaddress from Employee as e");
			int rowCount = query.executeUpdate();
			if(rowCount==1) {
				System.out.println(rowCount+"record inserted to Cricketer Table");
			}else {
				System.out.println("Insertion opertation failed");
			}
			transaction.commit();
			*/
			
		
			Query query=session.createQuery("insert into Cricketer(eno, ename, eage, eaddress) select e.eno, e.ename, e.eage, e.eaddress from Employee as e where eno=10");
			
			int rowCount = query.executeUpdate();
			System.out.println(rowCount);
			if(rowCount==1) {
				System.out.println(rowCount+"record inserted to Cricketer Table");
			}else {
				System.out.println("Insertion opertation failed");
			}
			transaction.commit();
			//*/
			
			/*
			Query query=session.createQuery("insert into Cricketer(eno, ename, eage, eaddress) select e.eno, e.ename, e.eage, e.eaddress from Employee as e where eno=100");
			
			int rowCount = query.executeUpdate();
			System.out.println(rowCount);
			
			if(rowCount==1) {
				System.out.println(rowCount+"record inserted to Cricketer Table");
			}else {
				System.out.println(rowCount+"record inserted to Cricketer Table");
			} 
			transaction.commit();
			*/
			
			/*
			Query query=session.createQuery("insert into Cricketer(eno, ename, eage, eaddress) select e.eno, e.ename, e.eage, e.eaddress from Employee as e");
			
			int rowCount = query.executeUpdate();
			System.out.println(rowCount);
			System.out.println(rowCount+" record inserted to Cricketer Table");
			*/
			
		}
		catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				HibernateUtil.close();
			}
		}

	}

}

/*

Hibernate: insert into CRICKETER ( ENO, ename, EAGE, EADDRESS ) select employee0_.ENO as col_0_0_, employee0_.ename as col_1_0_, employee0_.EAGE as col_2_0_, employee0_.EADDRESS as col_3_0_ from EMPLOYEE employee0_ where employee0_.ENO=10
1
1record inserted to Cricketer Table

*/