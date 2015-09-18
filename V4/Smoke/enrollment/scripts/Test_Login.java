package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;

public class Test_Login 
{

	public static int i=0;
	static Map<String,Connection> conn=null;
	public void test() throws InterruptedException, SQLException{
	if(i==0)
	{
		Baseclass_Erm.Erm_login(conn);
		i=1;
	}
	
	
} 
}
