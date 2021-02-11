package com.abc.mainapp;

import org.hibernate.Session;


import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class DeleteRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			int id = 3;
			Employee employee = session.get(Employee.class, id);
			System.out.println("Employee Info is : " + employee);
			System.out.println("The Account Information is :" + employee.getAccount());

			if (employee != null) {
				transaction = session.beginTransaction();

				session.delete(employee);

			}
			transaction.commit();
			System.out.println("The object getting delted is :" + employee);
			System.out.println("The Account Information is :" + employee.getAccount());

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
        employee0_.ID as id1_1_0_,
        employee0_.account_ID as account_4_1_0_,
        employee0_.ADDRESS as address2_1_0_,
        employee0_.NAME as name3_1_0_,
        account1_.ID as id1_0_1_,
        account1_.ACCNAME as accname2_0_1_,
        account1_.ACCTYPE as acctype3_0_1_ 
    from
        EMPLOYEE employee0_ 
    left outer join
        ACCOUNT account1_ 
            on employee0_.account_ID=account1_.ID 
    where
        employee0_.ID=?
Employee Info is : Employee [id=3, name=dravid, address=bengaluru]
The Account Information is :Account [accNo=3, accName=dravid, accType=current]
Hibernate: 
    delete 
    from
        EMPLOYEE 
    where
        ID=?
Hibernate: 
    delete 
    from
        ACCOUNT 
    where
        ID=?
The object getting delted is :Employee [id=3, name=dravid, address=bengaluru]
The Account Information is :Account [accNo=3, accName=dravid, accType=current]
*/
