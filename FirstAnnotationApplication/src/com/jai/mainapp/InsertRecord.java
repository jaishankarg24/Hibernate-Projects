package com.jai.mainapp;
import com.jai.factory.HibernateUtil;



import com.jai.pojo.Employee;

import org.hibernate.Transaction;



import org.hibernate.Session;


public class InsertRecord {

	public static void main(String[] args) {
		
		try {
				Session session=HibernateUtil.getSession();
				
				int eid=10;
				Employee employeeRecord=session.get(Employee.class, eid);
				
				if(employeeRecord==null) {
					
				Transaction transaction=session.beginTransaction();
				
				Employee employee=new Employee();
				employee.setEno(10);
				employee.setEname("sachin");
				employee.setEage(49);
				employee.setEaddress("Mi");
				
				int pkId=(int)session.save(employee);
	
				transaction.commit();
				
				System.out.println("Employee record inserted with the id "+pkId);
			}
			else {
				System.out.println("Employee record already available with the id:"+eid);
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.close();
		}
	}

}

/*
Hibernate: select employee0_.ENO as eno1_0_0_, employee0_.EADDRESS as eaddress2_0_0_, employee0_.EAGE as eage3_0_0_, employee0_.ENAME as ename4_0_0_ from Employee employee0_ where employee0_.ENO=?
Hibernate: insert into Employee (EADDRESS, EAGE, ENAME, ENO) values (?, ?, ?, ?)
Employee record inserted with the id 10
 */
