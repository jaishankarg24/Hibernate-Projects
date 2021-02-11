package com.abc.mainapp;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class AggregateFunctions {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {

			Criteria criteria = session.createCriteria(Employee.class);

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.rowCount());
			projectionList.add(Projections.min("esalary"));
			projectionList.add(Projections.max("esalary"));

			criteria.setProjection(projectionList);

			List<Object[]> employeeInfo = criteria.list();
			for (Object[] employee : employeeInfo) {
				System.out.println("\nCount of Employee Records are :" + employee[0]);
				System.out.println("The Min salary of employee is :" + employee[1]);
				System.out.println("The Max salary of employee is :" + employee[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
Hibernate: 
select
    count(*) as y0_,
    min(this_.ESALARY) as y1_,
    max(this_.ESALARY) as y2_ 
from
    EMPLOYEE this_

Count of Employee Records are :3
The Min salary of employee is :49000
The Max salary of employee is :55000
*/