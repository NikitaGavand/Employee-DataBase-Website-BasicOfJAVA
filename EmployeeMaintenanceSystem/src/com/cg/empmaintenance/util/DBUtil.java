package com.cg.empmaintenance.util;


import java.sql.Connection;
import java.sql.SQLException;



import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.cg.empmaintenance.logger.MyLogger;

public class DBUtil {
	static InitialContext context;
	static DataSource dataSource;
	static Connection connection;
	Logger logger = MyLogger.getLoggerInstance();
	static
	{
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/testds");
			
		} catch (NamingException e) {
		
		e.getMessage();
		}
		
	}
	public static Connection getConnect()
	{
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.getMessage();
	
		}
		return connection;
	}
}
