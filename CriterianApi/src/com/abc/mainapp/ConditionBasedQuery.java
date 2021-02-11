package com.abc.mainapp;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class ConditionBasedQuery {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {

			Criteria criteria = session.createCriteria(Employee.class);

			Criterion c1 = Restrictions.gt("eage", 35);
			Criterion c2 = Restrictions.lt("esalary", "50000");
			Criterion c3 = Restrictions.and(c1, c2);

			criteria.add(c3);

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
where
    (
        this_.EAGE>? 
        and this_.ESALARY<?
    )
[eno=18, ename=kohli, eage=36, eaddress=delhi, esalary=49000]
*/