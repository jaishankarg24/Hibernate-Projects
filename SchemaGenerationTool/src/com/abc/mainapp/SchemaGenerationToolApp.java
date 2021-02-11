package com.abc.mainapp;

import java.io.Serializable;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
//import com.abc.pojo.Cricketer;
import com.abc.pojo.Hockey;

public class SchemaGenerationToolApp {

	public static void main(String[] args) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSession();) {

			transaction = session.beginTransaction();
			
			//Serializable pkId = session.save(new Cricketer(10, "sachin", 49, "50000"));
			//Serializable pkId = session.save(new Cricketer("dhoni", 39));
			
			//Serializable pkId = session.save(new Cricketer("lara", 55, "barbodas", "lara@gmail.com"));
			Serializable pkId = session.save(new Hockey("dhyanchand", 45, "westbengal", "chand@gmail.com"));

			transaction.commit();

			System.out.println("Object got saved into the database with the id:" + pkId);

			HibernateUtil.close();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

}

/*
Employee Object created by HBN software!!!
Hibernate: 
    
    drop table if exists HOCKEY



Hibernate: 
    
    create table HOCKEY (
       ENO integer not null auto_increment,
        EADDRESS varchar(255),
        EAGE integer,
        EMAIL varchar(255),
        ENAME varchar(255),
        primary key (ENO)
    ) engine=InnoDB



Hibernate: 
    insert 
    into
        HOCKEY
        (EADDRESS, EAGE, EMAIL, ENAME) 
    values
        (?, ?, ?, ?)


Hibernate: 
    
    drop table if exists HOCKEY
*/

/*  create

Employee Object created by HBN software!!!
Hibernate: 
    
    drop table if exists HOCKEY

Hibernate: 
    
    create table HOCKEY (
       ENO integer not null auto_increment,
        EADDRESS varchar(255),
        EAGE integer,
        EMAIL varchar(255),
        ENAME varchar(255),
        primary key (ENO)
    ) engine=InnoDB

Hibernate: 
    insert 
    into
        HOCKEY
        (EADDRESS, EAGE, EMAIL, ENAME) 
    values
        (?, ?, ?, ?)
Object got saved into the database with the id:1
*/