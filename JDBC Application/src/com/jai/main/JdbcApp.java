package com.jai.main;

import java.sql.Connection;


import java.sql.SQLException;

import com.jai.Factory.ConnectionFactory;
import com.mysql.cj.jdbc.MysqlDataSource;

public class JdbcApp {

	public static void main(String[] args) {
		try {
			MysqlDataSource dataSource=ConnectionFactory.getConnectionObj();
			
			Connection connection = dataSource.getConnection();
			
			System.out.println("Connection object is:"+connection.getClass().getName());
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}

/*-------- output-----------

Connection object is:com.mysql.cj.jdbc.ConnectionImpl
*/