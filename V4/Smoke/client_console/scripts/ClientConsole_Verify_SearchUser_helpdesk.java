package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.client_console.applibs.ClientConsole_Admin_Page;
import V4.Smoke.client_console.applibs.HelpDesk_page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;
public class ClientConsole_Verify_SearchUser_helpdesk {
	static Map<String,Connection> conn=null;
	String sActual;
	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
	@BeforeClass

	public static void verify() throws InterruptedException, Exception, SQLException {
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription ="Set Up for Search_User  through helpdesk functionality";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		if(Test_login.i==0)
		{  
			Common_Class_clientConsole.set_test_data_path(); 
			Log.initialize();
			Log.logBanner("Search User ");
			Common_Class.loadDBproperties();
			conn=Common_Class.connectDB();
			Test_login.i=1;
			Common_Class_clientConsole.client_console_login(conn);
		}
	}

     /**
	 * @param sd
	 */
	public void Search_user_Fun_Run(Map<String,String> sd){
		try {

			HelpDesk_page.click_HomePage_Link_HelpDesktab();
			System.out.println("Conformation page Visible Text:" +SeleniumCore.driver.getTitle());
			ClientConsole_Admin_Page.Search_User_HelpDesk(sd);
			sActual=SeleniumCore.driver.getTitle();
			
        }
		catch (Exception e) {
			Log.errorHandler("Error occurred during Verify SearchUser in help Desk.",e);
			Common_Class_clientConsole.commonLink();
		}
	}


	/**
	 * 
	 */
	@Test
	public  void SearchUser_helpDesk_test(){
		try{
		int i=1;
		Map<String,String> Search_Users=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Search_User_HelpDesk",Integer.toString(i));
		Search_user_Fun_Run(Search_Users);
		  
		  String sExpected="Search Users";
		  if(sActual!=sExpected){
			  Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
		  }
		  else{
			  Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
				
		  }
		System.out.println("Conformation page Visible Text:" +SeleniumCore.driver.getTitle());
		
		}
		catch(Exception e){
			Log.errorHandler("Error occurred during Verify SearchUser in help Desk.",e);
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





