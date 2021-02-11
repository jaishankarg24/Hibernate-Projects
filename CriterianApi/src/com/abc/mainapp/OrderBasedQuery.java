package com.abc.mainapp;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class OrderBasedQuery {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {

			Criteria criteria = session.createCriteria(Employee.class);

			Order order = Order.desc("esalary");

			criteria.addOrder(order);

			List<Employee> employees = criteria.list();
			employees.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
Hibernate: 
select
    this_.ENO as eno1_0_0_,
    this_.EADDRESS as eaddress2_0_0_,
    this_.EAGE as eage3_0_0_,
    this_.ename as ename4_0_0_,
    this_.ESALARY as esalary5_0_0_ 
from
    EMPLOYEE this_ 
order by
    this_.ESALARY desc
[eno=7, ename=dhoni, eage=39, eaddress=ranchi, esalary=55000]
[eno=10, ename=sachin, eage=48, eaddress=mumbai, esalary=50000]
*/