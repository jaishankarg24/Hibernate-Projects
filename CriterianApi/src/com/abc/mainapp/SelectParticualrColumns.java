package com.abc.mainapp;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.abc.factory.HibernateUtil;
import com.abc.pojo.Employee;

public class SelectParticualrColumns {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {

			Criteria criteria = session.createCriteria(Employee.class);// from Employee

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("eno"));
			projectionList.add(Projections.property("ename"));
			projectionList.add(Projections.property("eage"));

			criteria.setProjection(projectionList);// select eno,ename,eage from Employee;

			List<Object[]> employees = criteria.list();
			System.out.println("ENO\tENAME\tEAGE");
			for (Object[] employee : employees) {
				System.out.println(employee[0] + "\t" + employee[1] + "\t" + employee[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
Hibernate: 
select
    this_.ENO as y0_,
    this_.ename as y1_,
    this_.EAGE as y2_ 
from
    EMPLOYEE this_
ENO	ENAME	EAGE
10	sachin	48
*/