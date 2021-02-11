package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.pojo.Employee;
import com.abc.factory.HibernateUtil;

public class PersistanceOperation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	/*	
		ReadOperation();
	}
	*/	
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			
			
		
			List<Employee> employees=session.getNamedQuery("getAllEmployees").getResultList();
			if(employees.isEmpty()) {
				System.out.println("No Record Found");
			}else {
				for(Employee employee:employees) {
					System.out.println(employee);
				}
			}
			//*/
			
			
			transaction = session.beginTransaction();

			int rowCount = session.getNamedQuery("deleteEmployee").setParameter("eno", "48").executeUpdate();

			transaction.commit();
			
			System.out.println("No of records deleted is :" + rowCount);
			
		
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	private static void ReadOperation() {
		try (Session session = HibernateUtil.getSession()) {

			List<Employee> employees = session.getNamedQuery("getAllEmployees").getResultList();
			if (employees.isEmpty()) {
				System.out.println("No records found");
			} else {
				for (Employee employee : employees) {
					System.out.println(employee);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

}

/*
Hibernate: select * from `EMPLOYEE`
[eno=10, ename=sachin, eage=48, eaddress=mumbai, esalary=50000]
Hibernate: delete from `EMPLOYEE` where `ENO`=?
No of records deleted is :0
*/