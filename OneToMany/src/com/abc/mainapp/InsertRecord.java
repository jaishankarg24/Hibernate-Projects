package com.abc.mainapp;

import java.util.HashSet;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Department;
import com.abc.pojo.Employee;

public class InsertRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Employee e1 = new Employee();// EID:1
			e1.setEname("sachin");
			e1.setEaddress("MI");

			Employee e2 = new Employee();// EID:2
			e2.setEname("saurav");
			e2.setEaddress("KKR");

			Employee e3 = new Employee();// EID:3
			e3.setEname("dravid");
			e3.setEaddress("RCB");

			Set<Employee> employees = new HashSet<>();
			employees.add(e1);
			employees.add(e2);
			employees.add(e3);

			Department department = new Department();// DID:1
			department.setDname("ADMIN");
			department.setEmployees(employees);

			session.save(department);// 1 : M DEPARTMENT-------------->EMPLOYEE

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtil.close();
		}

	}

}

/*
Hibernate: 

create table DEPARTMENT (
   DID integer not null auto_increment,
    DNAME varchar(255),
    primary key (DID)
) engine=InnoDB
Hibernate: 

create table EMPLOYEE (
   EID integer not null auto_increment,
    EADDRESS varchar(255),
    ENAME varchar(255),
    DIDFK integer,
    primary key (EID)
) engine=InnoDB
Hibernate: 

alter table EMPLOYEE 
   add constraint FKe3gawshqgcan5niydvgqk1tpj 
   foreign key (DIDFK) 
   references DEPARTMENT (DID)
Jan 18, 2021 7:50:22 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
insert 
into
    DEPARTMENT
    (DNAME) 
values
    (?)
Hibernate: 
insert 
into
    EMPLOYEE
    (EADDRESS, ENAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    EMPLOYEE
    (EADDRESS, ENAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    EMPLOYEE
    (EADDRESS, ENAME) 
values
    (?, ?)
Hibernate: 
update
    EMPLOYEE 
set
    DIDFK=? 
where
    EID=?
Hibernate: 
update
    EMPLOYEE 
set
    DIDFK=? 
where
    EID=?
Hibernate: 
update
    EMPLOYEE 
set
    DIDFK=? 
where
    EID=?
*/