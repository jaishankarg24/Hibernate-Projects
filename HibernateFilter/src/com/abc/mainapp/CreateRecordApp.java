package com.abc.mainapp;

import java.util.List;


import org.hibernate.Filter;
import org.hibernate.Session;



import com.abc.factory.HibernateUtil;
import com.abc.pojo.Customer;


public class CreateRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {
			
			Filter filter = session.enableFilter("CUSTOMER_DETAILS");
			filter.setParameter("type", "PERM");
			filter.setParameter("customerage", 40);

			List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();
			customers.forEach(customer->System.out.println(customer));
			
			session.disableFilter("CUSTOMER_DETAILS");
			
			System.out.println();
			List<Customer> customersData = session.createQuery("from Customer", Customer.class).getResultList();
			customersData.forEach(customer->System.out.println(customer));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}
