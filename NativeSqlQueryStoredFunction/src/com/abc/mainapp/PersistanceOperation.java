package com.abc.mainapp;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.abc.factory.HibernateUtil;

public class PersistanceOperation {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {
			
			Integer noOfRecords=session.doReturningWork(new ReturningWork<Integer>() {
				
				@Override
				public Integer execute(Connection connection) throws SQLException{
					/*
					connection.prepareCall("{?=call countOfEmployees()}").registerOutParameter(1, Types.INTEGER);
					connection.prepareCall("{?=call countOfEmployees()}").execute();
					return connection.prepareCall("{?=call countOfEmployees()}").getInt(1);
					*/
					
					CallableStatement function = connection.prepareCall("{? = call countOfEmployees()}");
					function.registerOutParameter(1, Types.INTEGER);
					function.execute();

					return function.getInt(1);
					
				}
			});
			System.out.println("No of records is : " + noOfRecords);
			/* 3
			Integer noOfRecords = session.doReturningWork(connection -> {

				CallableStatement function = connection.prepareCall("{? = call countOfEmployees()}");
				function.registerOutParameter(1, Types.INTEGER);
				function.execute();

				return function.getInt(1);

			});
			System.out.println("No of records is : " + noOfRecords);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
No of records is : 1
*/