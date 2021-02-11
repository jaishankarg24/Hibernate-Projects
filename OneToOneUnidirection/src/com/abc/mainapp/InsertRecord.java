package com.abc.mainapp;

import org.hibernate.Session;


import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Account;
import com.abc.pojo.Employee;

public class InsertRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Account account = new Account();
			account.setAccName("dravid");
			account.setAccType("current");

			Employee employee = new Employee();
			employee.setName("dravid");
			employee.setAddress("bengaluru");

			employee.setAccount(account);// Injecting the contained object into Container

			session.save(employee);

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtil.close();
		}

	}

}

/*--------------------
 * Hibernate: 
    
    create table ACCOUNT (
       ID integer not null auto_increment,
        ACCNAME varchar(15),
        ACCTYPE varchar(15),
        primary key (ID)
    ) engine=InnoDB
Hibernate: 
    
    create table EMPLOYEE (
       ID integer not null auto_increment,
        ADDRESS varchar(15),
        NAME varchar(10),
        account_ID integer,
        primary key (ID)
    ) engine=InnoDB
Hibernate: 
    
    alter table EMPLOYEE 
       add constraint FKguifuufcc8ciknwm1o3d5hicy 
       foreign key (account_ID) 
       references ACCOUNT (ID)
Jan 18, 2021 6:55:31 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
    insert 
    into
        ACCOUNT
        (ACCNAME, ACCTYPE) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        EMPLOYEE
        (account_ID, ADDRESS, NAME) 
    values
        (?, ?, ?)
 */
/*
Hibernate: 

create table ACCOUNT (
   ID integer not null auto_increment,
    ACCNAME varchar(15),
    ACCTYPE varchar(15),
    primary key (ID)
) engine=InnoDB
Hibernate: 

alter table EMPLOYEE 
   add column ID integer not null
Hibernate: 

alter table EMPLOYEE 
   add column ADDRESS varchar(15)
Hibernate: 

alter table EMPLOYEE 
   add column NAME varchar(10)
Hibernate: 

alter table EMPLOYEE 
   add column account_ID integer
Hibernate: 

alter table EMPLOYEE 
   add constraint FKguifuufcc8ciknwm1o3d5hicy 
   foreign key (account_ID) 
   references ACCOUNT (ID)
Jan 18, 2021 6:46:04 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
insert 
into
    ACCOUNT
    (ACCNAME, ACCTYPE) 
values
    (?, ?)
Hibernate: 
insert 
into
    EMPLOYEE
    (account_ID, ADDRESS, NAME) 
values
    (?, ?, ?)
*/