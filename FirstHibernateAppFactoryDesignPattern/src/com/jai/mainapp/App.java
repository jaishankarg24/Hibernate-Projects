package com.jai.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.jai.factory.HibernateUtil;
import com.jai.pojo.Employee;

public class App {

	public static void main(String[] args) {
		
		//insert record
		
		try {
			// Get the session object
			Session session = HibernateUtil.getSession();

			// Get the transaction object(insert,update,delete)
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			int id=7;
			Employee empRecord=session.get(Employee.class, id);
			if(empRecord==null) {
				Employee employee = new Employee();

				employee.setEno(7);
				employee.setEname("dhoni");
				employee.setEage(39);
				employee.setEaddress("csk");
				
				int empId=(int)session.save(employee);
				System.out.println("Employee record got saved with the id :"+empId);
			}
			else {
				System.out.println("Employee record already existed within the id:"+id);
			}
			
			/*
			// Perform PERSISTANCE Operation(CRUD)
			Employee employee = new Employee();

			employee.setEno(18);
			employee.setEname("kohli");
			employee.setEage(33);
			employee.setEaddress("rcb");

			session.persist(employee);// Generates insert query by HBN software

			transaction.commit();// It will make the changes to the database as per the Query

			System.out.println("Employee record got saved with the id :" + employee.getEno());
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.close();
		}
	}

}
