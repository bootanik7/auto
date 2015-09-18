package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class Test_Erm_Verify_Logout 
{


	/**
	 * raonag
	 */
	static Map<String,Connection> conn=null;
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass

	public static void step() throws ClassNotFoundException, SQLException{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Test and verify Enrollment Login Page";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Log.initialize();
		Log.logBanner("Setup for Enrollment Testcases");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
	}

	/** verify the login 
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	@Test()
	public  void Erm_login_test() throws InterruptedException, SQLException
	{
		try{
			Log.startTestCase("started testcase for Logout from the enrollment page");
			Baseclass_Erm.Erm_login(conn);
			Baseclass_Erm.Common_Link();
			Erm_AccountSummary_Page.click_on_logout();
		}catch(Exception e) {
			Log.errorHandler("Error occurred while Logout from the enrollment page.",e);			
		}
	}
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Nagabhushana Rao
	 */

	public static void tearDown() throws Exception 
	{
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();
	}


}
