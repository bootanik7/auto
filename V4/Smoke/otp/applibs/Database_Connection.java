package V4.Smoke.otp.applibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Connection {
	
	/**
	 * JDBC connection
	 */
	private static Connection connection;

	/**
	 * Connect to a JDBC database
	 * @param sDriver
	 * @param sConnectionUrl
	 * @param sUser
	 * @param sPassword
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection connectToDatabase(String sDriver, String sConnectionUrl, String sUser, String sPassword) throws ClassNotFoundException, SQLException {
	Class.forName(sDriver);
	return connection = DriverManager.getConnection(sConnectionUrl, sUser, sPassword);
	}

	/**
	 * Execute a JDBC update
	 * @param sQuery
	 * @return connection id
	 * @throws SQLException
	 */
	public static int executeDatabaseUpdate(String sQuery,Connection conn) throws SQLException {
	Statement statement = conn.createStatement();
	return statement.executeUpdate(sQuery);
	}
	
	/**
	 * Execute a JDBC query
	 * @param sQuery
	 * @return result set
	 * @throws SQLException
	 */
	public static ResultSet executeDatabaseQuery(String sQuery,Connection conn) throws SQLException {
	Statement statement = conn.createStatement();
	return statement.executeQuery(sQuery);
	}
	
	

}
