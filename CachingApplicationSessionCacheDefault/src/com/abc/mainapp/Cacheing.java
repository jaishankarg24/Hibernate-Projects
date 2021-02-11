package com.abc.mainapp;

import org.hibernate.Session;


import com.abc.factory.HibernateUtil;
import com.abc.pojo.Customer;

public class Cacheing {

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

drop table if exists CUSTOMER
Jan 18, 2021 3:15:59 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@4130955c] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 

create table CUSTOMER (
   CID integer not null,
    CADDRESS varchar(255),
    CAGE integer,
    CNAME varchar(255),
    primary key (CID)
) engine=InnoDB
Jan 18, 2021 3:15:59 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@65a9ea3c] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Jan 18, 2021 3:16:01 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]

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
null

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
null
*/

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
*/