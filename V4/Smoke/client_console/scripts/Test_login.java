package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;



public class Test_login {

	
		public static int i=0;
		static Map<String,Connection> conn=null;
		public void test() throws InterruptedException, SQLException{
		if(i==0)
		{
			Common_Class_clientConsole.client_console_login(conn);
			i=1;
		}
		
		
	} 
	
	
}
