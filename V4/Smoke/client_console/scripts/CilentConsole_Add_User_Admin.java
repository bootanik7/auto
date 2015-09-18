package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.client_console.applibs.ClientConsole_Admin_Page;
import V4.Smoke.client_console.applibs.ClientConsole_admin_userDelete_page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;
/**
 * @author enturua
 *
 */
public class CilentConsole_Add_User_Admin {
	static Map<String,Connection> conn=null;
	String  sActual;
	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
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
			Log.logBanner("Setup for Add,Search,delete Funstionality in client console ");
			Common_Class.loadDBproperties();
			conn=Common_Class.connectDB();
			Test_login.i=1;
			Common_Class_clientConsole.client_console_login(conn);
		}
	}

	
	public static void Create_User_admin(Map<String,String> sd){
		try{
			
		ClientConsole_Admin_Page.click_Admin_Link();
		ClientConsole_Admin_Page.click_Create_user_Go();
		ClientConsole_Admin_Page.enter_New_userID(sd.get("Login_Id"));
		ClientConsole_Admin_Page.enter_User_New_Name(sd.get("User_Name"));
		ClientConsole_Admin_Page.enter_new_last_name(sd.get("Last_Name"));
		ClientConsole_Admin_Page.enter_New_Email(sd.get("Email"));
		ClientConsole_Admin_Page.Select_Team_name(sd.get("Team_Name"));
		ClientConsole_Admin_Page.click_Role_checkBox();
		ClientConsole_Admin_Page.click_Create_user_Create();
		Common_Class_clientConsole.commonLink();
		
		
		
		}catch(Exception e){
			Log.errorHandler("error occured during the create user in admin"+e);
			Common_Class_clientConsole.commonLink();
		}
	}
	
	public void Search_User(Map<String,String> sd) 
	{

		try {


			ClientConsole_Admin_Page.click_Admin_Link();
			System.out.println("Actuall Page Name :" +SeleniumCore.driver.getTitle());
			ClientConsole_Admin_Page.Search_User_Fun(sd);
			 sActual=SeleniumCore.driver.getTitle();
			 
		} 	
		catch (Exception e)
		{
			Log.errorHandler("Error occurred during Search user functionality .",e);
			Common_Class_clientConsole.commonLink();
		}
	}
	public void  Delete_user(Map<String,String> sd){
	try{
		ClientConsole_Admin_Page.click_Admin_Link();
		ClientConsole_Admin_Page.Search_User_Fun(sd);
		System.out.println("Actuall Page Name :" +SeleniumCore.driver.getTitle());
		ClientConsole_Admin_Page.click_Delete_User();
		ClientConsole_admin_userDelete_page.click_btnDeleteUser();
		Common_Class_clientConsole.commonLink();
		
		
		}
		catch (Exception e)
		{
			Log.errorHandler("Error occurred during Delete user functionality .",e);
			Common_Class_clientConsole.commonLink();
		}
	}
	
	/**
	 * @param sd
	 * 
	 */
	@Test
	public  void Create_User_Test(){
		try{
			int i=1;
			Map<String,String> User_details=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Create_New_User",Integer.toString(i));
			Create_User_admin(User_details);

		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Create Role in Admin Page",e);
		}


	}
	
	
	/**
	 * 
	 */
	@Test
	public  void SearchUser_Test()
	{
		try {
			int i=1;
			Map<String,String> Search_Users_details=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Search_User",Integer.toString(i));
			Search_User(Search_Users_details);
			String sExpected="View/Modify User";
			   if(sActual!=sExpected){
				  Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
			  }
			  else{
				  Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
					
			  }
			Common_Class_clientConsole.commonLink();
			
			}
		catch(Exception e){
			Log.errorHandler("Error occurred during Search user functionality .",e);
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
		
		Common_Class.terminate();
		

	}
}
	

