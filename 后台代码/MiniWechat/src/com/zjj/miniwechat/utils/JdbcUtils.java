package com.zjj.miniwechat.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;


public class JdbcUtils {
	
	private static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRunner(){
		QueryRunner qr = new QueryRunner(dataSource);
		return qr;
		
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = (Connection) dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
