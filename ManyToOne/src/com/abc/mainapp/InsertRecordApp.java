package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Branch;
import com.abc.pojo.Student;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Branch branch = new Branch();// BID=====>1
			branch.setBname("CSE");

			Student s1 = new Student();// SID====>1
			s1.setSaddress("VIJ");
			s1.setSname("sachin");
			s1.setBranch(branch);

			Student s2 = new Student();// SID====>2
			s2.setSaddress("VIJ");
			s2.setSname("dhoni");
			s2.setBranch(branch);

			Student s3 = new Student();// SID====>3
			s3.setSaddress("VIJ");
			s3.setSname("sachin");
			s3.setBranch(branch);

			session.save(s1);
			session.save(s2);
			session.save(s3);//M:1          Student==3==========1===>Branch

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

create table BRANCH (
   BID integer not null auto_increment,
    BNAME varchar(255),
    primary key (BID)
) engine=InnoDB
Hibernate: 

create table STUDENT (
   SID integer not null auto_increment,
    SADDRESS varchar(255),
    SNAME varchar(255),
    BIDFK integer,
    primary key (SID)
) engine=InnoDB
Hibernate: 

alter table STUDENT 
   add constraint FKdgd2j8fq4mulwil95kheiqlvd 
   foreign key (BIDFK) 
   references BRANCH (BID)
Jan 18, 2021 8:10:27 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
insert 
into
    BRANCH
    (BNAME) 
values
    (?)
Hibernate: 
insert 
into
    STUDENT
    (BIDFK, SADDRESS, SNAME) 
values
    (?, ?, ?)
Hibernate: 
insert 
into
    STUDENT
    (BIDFK, SADDRESS, SNAME) 
values
    (?, ?, ?)
Hibernate: 
insert 
into
    STUDENT
    (BIDFK, SADDRESS, SNAME) 
values
    (?, ?, ?)
*/