package www.intumit.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import www.intumit.entity.KMSException;

public class KDBConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/kms?serverTimezone=UTC";
	private static final String userid = "root";
	private static final String pwd = "1234";
	
	public static Connection getConnection() throws KMSException{
		try {
			Class.forName(driver);

			try {
				Connection connection = DriverManager.getConnection(
						url, userid, pwd);				
				return connection;
			} catch (SQLException e) {
				throw new KMSException("載入資料庫連線失敗", e);
			}

		} catch (ClassNotFoundException e) {	
			throw new KMSException("載入JDBC Driver失敗", e);
		}				
	}
}
