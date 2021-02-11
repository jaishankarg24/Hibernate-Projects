package com.jai.jdbc1;

import java.sql.Connection;


import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MainApp {

	public static void main(String[] args) {
	
		try {
			MysqlDataSource dataSource = new MysqlDataSource();

			String url = "jdbc:mysql://localhost:3306/janbatch";
			String user = "root";
			String password = "root123";

			dataSource.setURL(url);
			dataSource.setUser(user);
			dataSource.setPassword(password);

			Connection connection = dataSource.getConnection();
			System.out.println("Got the connection to:" + connection);
			System.out.println("Got the connection to:" + url);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

/*---------
Got the connection Object:com.mysql.cj.jdbc.ConnectionImpl@1da2cb77
Got the connection to Url :jdbc:mysql://localhost:3306/janbatch
*/
