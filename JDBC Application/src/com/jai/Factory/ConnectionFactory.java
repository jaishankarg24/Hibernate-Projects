package com.jai.Factory;

import com.mysql.cj.jdbc.MysqlDataSource;


public class ConnectionFactory {
	
	private static MysqlDataSource dataSource;
	
	static {
		dataSource=new MysqlDataSource();
		
		String url="jdbc:mysql://localhost:3306/janbatch";
		String user="root";
		String password="root123";
		
		dataSource.setURL(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		
	}
	
	public static MysqlDataSource  getConnectionObj() {
		return dataSource;
	}

}
