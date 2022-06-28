package educationdashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyConnection {

		Connection con=null;
		public Connection conncetDb() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
			System.out.println("Connection successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}

