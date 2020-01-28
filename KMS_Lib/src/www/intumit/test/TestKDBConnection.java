package www.intumit.test;

import java.sql.Connection;
import java.sql.SQLException;

import www.intumit.entity.KMSException;
import www.intumit.service.KDBConnection;

public class TestKDBConnection {

	public static void main(String[] args) {
		try(Connection connection =KDBConnection.getConnection()
			){
			System.out.println(connection.getCatalog());
		} catch (SQLException | KMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
