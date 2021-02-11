package com.abc.mainapp;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Course;
import com.abc.pojo.Student;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			transaction = session.beginTransaction();

			Course c1 = new Course();// CID:1
			c1.setCname("JAVA");
			c1.setCost(2000);

			Course c2 = new Course();// CID:2
			c2.setCname("J2EE");
			c2.setCost(1000);

			Course c3 = new Course();// CID:3
			c3.setCname("HIBERNATE");
			c3.setCost(500);

			Set<Course> courses = new HashSet<>();
			courses.add(c1);
			courses.add(c2);
			courses.add(c3);

			Student s1 = new Student();// SID:1
			s1.setSname("sachin");
			s1.setSaddress("mumbai");
			s1.setCourses(courses);

			Student s2 = new Student();// SID:2
			s2.setSname("saurav");
			s2.setSaddress("kolkata");
			s2.setCourses(courses);

			Student s3 = new Student();// SID:3
			s3.setSname("dravid");
			s3.setSaddress("bengalru");
			s3.setCourses(courses);

			Student s4 = new Student();// SID:4
			s4.setSname("dhoni");
			s4.setSaddress("jharkand");
			s4.setCourses(courses);

			session.save(s1);
			session.save(s2);// Student(s1,s2,s3,s4)==(*)========(*)=>Course(c1,c2,c3)
			session.save(s3);
			session.save(s4);

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

create table COURSE (
   CID integer not null auto_increment,
    CNAME varchar(255),
    COST integer,
    primary key (CID)
) engine=InnoDB
Hibernate: 

create table STUDENT (
   SID integer not null auto_increment,
    SADDRESS varchar(255),
    SNAME varchar(255),
    primary key (SID)
) engine=InnoDB
Hibernate: 

create table student_course (
   SIDFK integer not null,
    CIDFK integer not null,
    primary key (SIDFK, CIDFK)
) engine=InnoDB
Hibernate: 

alter table student_course 
   add constraint FKq6wah31jxbvpty05tub4ig9en 
   foreign key (CIDFK) 
   references COURSE (CID)
Hibernate: 

alter table student_course 
   add constraint FKmckjrn87dw3yg6nbwqdhtafdd 
   foreign key (SIDFK) 
   references STUDENT (SID)
Jan 18, 2021 8:22:08 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
insert 
into
    STUDENT
    (SADDRESS, SNAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    COURSE
    (CNAME, COST) 
values
    (?, ?)
Hibernate: 
insert 
into
    COURSE
    (CNAME, COST) 
values
    (?, ?)
Hibernate: 
insert 
into
    COURSE
    (CNAME, COST) 
values
    (?, ?)
Hibernate: 
insert 
into
    STUDENT
    (SADDRESS, SNAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    STUDENT
    (SADDRESS, SNAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    STUDENT
    (SADDRESS, SNAME) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
Hibernate: 
insert 
into
    student_course
    (SIDFK, CIDFK) 
values
    (?, ?)
*/