package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Student;

public class DeleteRecordapp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			int theSid = 2;
			Student student = session.get(Student.class, theSid);
			System.out.println(student);

			if (student != null) {
				transaction = session.beginTransaction();

				student.setCourses(null);

				session.delete(student);
				transaction.commit();

			}

		} catch (Exception e) {
			transaction.rollback();
			System.out.println("The cause of the exception is :" + e.getMessage());
		} finally {
			HibernateUtil.close();
		}

	}

}

/*
Hibernate: 
select
    student0_.SID as sid1_1_0_,
    student0_.SADDRESS as saddress2_1_0_,
    student0_.SNAME as sname3_1_0_ 
from
    STUDENT student0_ 
where
    student0_.SID=?
Hibernate: 
select
    courses0_.SIDFK as sidfk1_2_0_,
    courses0_.CIDFK as cidfk2_2_0_,
    course1_.CID as cid1_0_1_,
    course1_.CNAME as cname2_0_1_,
    course1_.COST as cost3_0_1_ 
from
    student_course courses0_ 
inner join
    COURSE course1_ 
        on courses0_.CIDFK=course1_.CID 
where
    courses0_.SIDFK=?
Student [sid=2, sname=saurav, saddress=kolkata, courses=[Course [cid=2, cname=JAVA, cost=2000], Course [cid=3, cname=J2EE, cost=1000], Course [cid=1, cname=HIBERNATE, cost=500]]]
Hibernate: 
delete 
from
    student_course 
where
    SIDFK=?
Hibernate: 
delete 
from
    STUDENT 
where
    SID=?
*/