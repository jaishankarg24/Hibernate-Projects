package com.abc.bi.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Account;

public class DeleteOnlyAccount {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				int theId = 2;
				Account account = session.get(Account.class, theId);
				System.out.println("Account information is :" + account);
				System.out.println("Employee information is :" + account.getEmployee());

				if (account != null) {

					transaction = session.beginTransaction();

					account.getEmployee().setAccount(null);// Break the link for Particular Employee

					session.delete(account);
					transaction.commit();

				}
				System.out.println("Account information is :" + account);
				System.out.println("Employee information is :" + account.getEmployee());
			} else {
				System.out.println("Failed to create a session!!!");
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}

/*
Hibernate: 
select
    account0_.ID as id1_0_0_,
    account0_.ACCNAME as accname2_0_0_,
    account0_.ACCTYPE as acctype3_0_0_,
    employee1_.ID as id1_1_1_,
    employee1_.account_ID as account_4_1_1_,
    employee1_.ADDRESS as address2_1_1_,
    employee1_.NAME as name3_1_1_ 
from
    ACCOUNT account0_ 
left outer join
    EMPLOYEE employee1_ 
        on account0_.ID=employee1_.account_ID 
where
    account0_.ID=?
Account information is :Account [accNo=2, accName=sachin, accType=savings]
Employee information is :Employee [id=2, name=sachin, address=mumbai]
Hibernate: 
update
    EMPLOYEE 
set
    account_ID=?,
    ADDRESS=?,
    NAME=? 
where
    ID=?
Hibernate: 
delete 
from
    ACCOUNT 
where
    ID=?
Account information is :Account [accNo=2, accName=sachin, accType=savings]
Employee information is :Employee [id=2, name=sachin, address=mumbai]
*/