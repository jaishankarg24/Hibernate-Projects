package com.abc.mainapp;
import javax.persistence.Query;



import org.hibernate.Session;

import java.util.List;

import com.abc.factory.HibernateUtil;
import com.abc.model.Employee;

public class SelectRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		try {
			session= HibernateUtil.getSession();
			
			
			String hqlSelectQuery="from Employee";
			//Query query=session.createQuery(hqlSelectQuery);
			
			//Query query= session.createQuery(hqlSelectQuery, Employee.class);
			
			
			List<Employee>employees=session.createQuery(hqlSelectQuery, Employee.class).getResultList();
			for (Employee employee:employees) {
			System.out.println(employee);
			}
			
			System.out.println();
			
			List<Employee> tempEmployees=session.createQuery(hqlSelectQuery, Employee.class).list();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			
			System.out.println();
			
			String SqlUniqueRecord = "from Employee where eno=7";
			Employee employee=session.createQuery(SqlUniqueRecord, Employee.class).uniqueResult();
			if(employee==null) {
				System.out.println("Employee Record doesnot exists");
			}else {
			System.out.println(employee);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				HibernateUtil.close();
			}
		}

	}

}

/*
 *Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
[Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
[Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_ where employee0_.ENO=70
Employee Record doesnot exists
-----------------------------------------------

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
[Employee [eno=7, ename=dhoni, eage=39, eaddress=csk], Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]
[Employee [eno=7, ename=dhoni, eage=39, eaddress=csk], Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
[Employee [eno=7, ename=dhoni, eage=39, eaddress=csk], Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]
[Employee [eno=7, ename=dhoni, eage=39, eaddress=csk], Employee [eno=10, ename=sachin, eage=48, eaddress=DC]]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_ where employee0_.ENO=7
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]

-----------------------------------------------
Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachin, eage=48, eaddress=DC]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
Employee [eno=10, ename=sachin, eage=48, eaddress=DC]

Hibernate: select employee0_.ENO as eno1_0_, employee0_.EADDRESS as eaddress2_0_, employee0_.EAGE as eage3_0_, employee0_.ename as ename4_0_ from EMPLOYEE employee0_ where employee0_.ENO=7
Employee [eno=7, ename=dhoni, eage=39, eaddress=csk]
*/
