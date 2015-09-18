package D2.Regression.client_console.applibs;

import java.sql.SQLException;

import core.libs.Database;

public class Databaseexe {
	 static String driver = "oracle.jdbc.driver.OracleDriver";
	 static String username="ParvatP";
	 static String Password="ParvatP!2345";
	
	public static void connectD2QA() throws  SQLException, ClassNotFoundException {
		String dbname="D2qa";
		String url = "jdbc:oracle:thin:@"+dbname+":1621:"+dbname+"";
		Database.connectToDatabase(driver, url, username, Password);
	}
}
