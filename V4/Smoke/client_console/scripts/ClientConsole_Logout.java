package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.client_console.applibs.clientConsole_logout_page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Browser;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

public class ClientConsole_Logout {
	static Map<String,Connection> conn=null;
	@BeforeClass
	public static void cc_Run() throws InterruptedException, ClassNotFoundException, SQLException{
		
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making Credit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		Common_Class_clientConsole.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Making Credit Card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
	   conn=Common_Class.connectDB();
		if(Test_login.i==0)

		{
			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
	}

	
	@Test
	public void LogOut_Run(){
		
			if(Common_Class.V4prop.get("MAM_ACH_Types").toString().contains("NA")){
				
				throw new SkipException("No MAM Details Present");
			}
			try {
				clientConsole_logout_page.CC_logout();
				System.out.println("*********************verify the logout page ************:" +SeleniumCore.driver.getTitle());
			        Browser.close();
				
			}catch(Exception e)
			{
				Log.errorHandler("Exception occured during logout functio .",e);
			}

		
		
	}
	
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Parvat Patil 
	 */
	public static void tearDown() throws Exception {
		Common_Class.closedbconnection(conn);

		Common_Class.terminate();

	}
}
