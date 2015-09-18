package V4.Smoke.client_console.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import V4.Smoke.client_console.applibs.ClientConsole_Admin_Page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

public class ClientConsole_Add_Team_Admin {
	   
	   static Map<String,Connection> conn=null;
	   String sActual;
	@BeforeClass
	
	
	public static void verify() throws InterruptedException, Exception, SQLException {
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription =" Search Team funtionality";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		if(Test_login.i==0)
		{  
			Common_Class_clientConsole.set_test_data_path(); 
			Log.initialize();
			Log.logBanner("Setup for Create Team,Delete,search team  Functionality in ClientConsole ");
			Common_Class.loadDBproperties();
			conn=Common_Class.connectDB();
			Test_login.i=1;
			Common_Class_clientConsole.client_console_login(conn);
		}
	}

	public static void Create_Team(Map<String,String> sd){
		ClientConsole_Admin_Page.click_Admin_Link();
		System.out.println("clicked");
		ClientConsole_Admin_Page.click_BtnTeam();
		ClientConsole_Admin_Page.enter_NEW_Team_Name(sd.get("TEAM"));
		ClientConsole_Admin_Page.click_Save_Create_team();
		
		
	}
	
	public   void Search_Team(Map<String,String> sd) {
		try {
			
			ClientConsole_Admin_Page.click_Admin_Link();
			ClientConsole_Admin_Page.Search_Team_Fun(sd);
			 sActual=SeleniumCore.driver.getTitle();
		    }

		catch (Exception e) {
			Log.errorHandler("Error occurred during Search Team in admin module.",e);
			Common_Class_clientConsole.commonLink();
			
		}
	}
	
	public static void Delete_Team(Map<String,String> sd){
		try {
		ClientConsole_Admin_Page.click_Admin_Link();

		ClientConsole_Admin_Page.Search_Team_Fun(sd);
		ClientConsole_Admin_Page.click_Delete_Team();
		System.out.println(SeleniumCore.driver.getTitle());
		ClientConsole_Admin_Page.click_Delete_Team();
		}
		catch (Exception e) {
			Log.errorHandler("Error occurred during Delete Team in admin module.",e);
			Common_Class_clientConsole.commonLink();
			
		}
	}	
		
	
	
@Test
	public void ADD_Team_test(){
		try{
			int i=1;
			Map<String,String> Team_Details=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Create_New_team",Integer.toString(i));
			Create_Team(Team_Details);
			
	}
	
	catch(Exception e){
		Log.errorHandler("Error occurred during created new user in administration .",e);
	}
}
	
		@Test
		public  void Search_Team_Test(){
			try{
			int i=1;
			Map<String,String> Search_Team_details=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Create_New_team",Integer.toString(i));
			Search_Team(Search_Team_details);
			String sExpected="View Team";
			  if(sActual!=sExpected){
				  Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
			  }
			  else{
				  Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
					
			  }
			  
			  Common_Class_clientConsole.commonLink();
			}
			catch(Exception e){
				Log.errorHandler("Error occurred during Search Team in administration .",e);
				Common_Class_clientConsole.commonLink();
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






		
		
		
		

