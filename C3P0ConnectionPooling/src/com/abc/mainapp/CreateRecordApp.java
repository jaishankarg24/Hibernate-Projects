package com.abc.mainapp;

import java.io.Serializable;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Student;

public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Transaction transaction = session.getTransaction();
			transaction.begin();

			Serializable pkId = session.save(new Student("rahul", 27, "pb", "52000"));
			transaction.commit();
			System.out.println("Object saved with the id :" + pkId);
			HibernateUtil.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
Hibernate: 

drop table if exists STUDENT

Hibernate: 

create table STUDENT (
   ENO integer not null auto_increment,
    EADDRESS varchar(255),
    EAGE integer,
    ename varchar(255),
    ESALARY varchar(255),
    primary key (ENO)
) engine=InnoDB

Hibernate: 
insert 
into
    STUDENT
    (EADDRESS, EAGE, ename, ESALARY) 
values
    (?, ?, ?, ?)
Object saved with the id :1
*/