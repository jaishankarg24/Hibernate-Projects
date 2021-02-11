package com.abc.mainapp;

import org.hibernate.Session;



import com.abc.factory.HibernateUtil;
import com.abc.pojo.Customer;

public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			System.out.println();
			
			Customer customer = session.get(Customer.class, 10);
			System.out.println(customer);
			
			System.out.println();
			
			Session session2 = HibernateUtil.getSession();
			Customer tempCustomer = session2.get(Customer.class, 10);
			System.out.println(tempCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}

/*
Hibernate: 
select
    customer0_.CID as cid1_0_0_,
    customer0_.CADDRESS as caddress2_0_0_,
    customer0_.CAGE as cage3_0_0_,
    customer0_.CNAME as cname4_0_0_ 
from
    CUSTOMER customer0_ 
where
    customer0_.CID=?
Customer [eno=10, ename=sachin, eage=45, eaddress=mi]

Customer [eno=10, ename=sachin, eage=45, eaddress=mi]
*/