package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;

public class ArthimeticExpressionApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			String hqlSelectQuery = "select (e.esalary-500) from Employee as e";
			
			Query query=session.createQuery(hqlSelectQuery);
			List<Integer> employees = query.getResultList();
			
			for(Integer salary : employees) {
				System.out.println(salary);
			}
		}
		catch(Exception e) {
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
 Hibernate: select employee0_.ESALARY-500 as col_0_0_ from EMPLOYEE employee0_
48500
49500
*/
