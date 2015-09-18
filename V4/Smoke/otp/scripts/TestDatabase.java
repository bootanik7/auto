package V4.Smoke.otp.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import V4.Smoke.otp.applibs.Common_Class;

public class TestDatabase {
	
@Test
public void testdatabase() throws ClassNotFoundException, SQLException {
	Common_Class.loadDBproperties();
	Map<String,Connection>connection=Common_Class.connectDB();
	
	Map<String,String>newmap= new HashMap<String, String>();
	 List<String> map= Common_Class.getMAMaccountnumbers("504478", 2,connection);
	
	 System.out.println("new map is====="+map);
	// newmap=Common_Class.getaccinfo(connection);
	 
	 
	
	
}

}
