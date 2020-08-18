package ilazar.postit.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {

		String jdbcUrl =
				"jdbc:mysql://localhost:3306/postit?useSSL=false&serverTimezone=UTC";
		String user = "ilazardemo";
		String pass = "ilazardemo";
		
		try {
			System.out.println("Connection to URL: " + jdbcUrl);
		
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Success!! :D");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
