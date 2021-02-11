package com.abc.mainapp;

import org.hibernate.Session;


import com.abc.factory.HibernateUtil;
import com.abc.pojo.Customer;

public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Customer customer1 = (Customer) session.createQuery("from  Customer where eno=:eno").setParameter("eno", 10)
					.setCacheable(true).setCacheRegion("employeeData").uniqueResult();
			System.out.println(customer1);
			
			
			Session session2 = HibernateUtil.getSession();
			Customer customer2 = (Customer) session2.createQuery("from  Customer where eno=:eno").setParameter("eno", 10)
					.setCacheable(true).setCacheRegion("employeeData").uniqueResult();
			System.out.println(customer2);
			
			

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
    customer0_.CID as cid1_0_,
    customer0_.CADDRESS as caddress2_0_,
    customer0_.CAGE as cage3_0_,
    customer0_.CNAME as cname4_0_ 
from
    CUSTOMER customer0_ 
where
    customer0_.CID=?
Customer [eno=10, ename=sachin, eage=45, eaddress=mi]
Customer [eno=10, ename=sachin, eage=45, eaddress=mi]
*/