package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;
import com.abc.model.Employee;

public class NonSelectOperation {

	public static void main(String[] args) {
		Session session = null;
		try {
			session= HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query query=session.createQuery("delete from Employee where eno=18");
			int rowCount = query.executeUpdate();
			
			if(rowCount == 1) {
				System.out.println("No of records deleted is :"+rowCount);
			}else {
				System.out.println("Record not found for Deletion");
			}
			
			System.out.println();

			
			//Updating  a Record
			String HqlUpdateQuery = "update Employee as e set e.ename='sachinTendulkar',e.eage=48,e.eaddress='MUMBAIINDIANS' where e.eno=10";
			
			Query updateQuery = session.createQuery(HqlUpdateQuery);
			
			int updatedCount = updateQuery.executeUpdate();
			System.out.println("No of records Updated is :" + updatedCount);
			
			transaction.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				HibernateUtil.close();
			}
		}

	}

}

/*
 Hibernate: delete from EMPLOYEE where ENO=18
Record not found for Deletion

Hibernate: update EMPLOYEE set ename='sachinTendulkar', EAGE=48, EADDRESS='MUMBAIINDIANS' where ENO=100
No of records Updated is :0
--------------------------------------

Hibernate: delete from EMPLOYEE where ENO=18
No of records deleted is :1

Hibernate: update EMPLOYEE set ename='sachinTendulkar', EAGE=48, EADDRESS='MUMBAIINDIANS' where ENO=10
No of records Updated is :1

*/
