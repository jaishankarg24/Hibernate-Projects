package com.abc.mainapp;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Student;

public class DeleteRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			int sid = 3;
			Student student = session.get(Student.class, sid);// M:1======>Student--------->Branch
			System.out.println(student);

			if (student != null) {

				transaction = session.beginTransaction();

				student.setBranch(null);
				session.remove(student);

				transaction.commit();
				System.out.println("Object delted with the sid :" + sid);
			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtil.close();
		}

	}

}
/*
Hibernate: 
select
    student0_.SID as sid1_1_0_,
    student0_.BIDFK as bidfk4_1_0_,
    student0_.SADDRESS as saddress2_1_0_,
    student0_.SNAME as sname3_1_0_,
    branch1_.BID as bid1_0_1_,
    branch1_.BNAME as bname2_0_1_ 
from
    STUDENT student0_ 
left outer join
    BRANCH branch1_ 
        on student0_.BIDFK=branch1_.BID 
where
    student0_.SID=?
Student [sid=3, sname=sachin, saddress=VIJ, branch=Branch [bid=1, bname=CSE]]
Hibernate: 
delete 
from
    STUDENT 
where
    SID=?
Object delted with the sid :3
*/