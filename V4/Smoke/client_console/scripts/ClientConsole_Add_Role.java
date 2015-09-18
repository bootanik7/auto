package V4.Smoke.client_console.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.client_console.applibs.ClientConsole_Admin_Page;
import V4.Smoke.client_console.applibs.Client_Console_View_Modify_Role_Page;
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
/**
 * @author enturua
 *
 */
public class ClientConsole_Add_Role {
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
		Log.gsScriptDescription ="Tests Making ACH Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		if(Test_login.i==0)
		{  
			Common_Class_clientConsole.set_test_data_path(); 
			Log.initialize();
			Log.logBanner("ClientConsole Add ,Search ,delete Roles in Admin Page ");
			Common_Class.loadDBproperties();
			conn=Common_Class.connectDB();
			Test_login.i=1;
			Common_Class_clientConsole.client_console_login(conn);
		}
	}
	/**
	 * @param sd
	 */
	public static void Create_Role_Admin(Map<String,String> sd){
		try{
		ClientConsole_Admin_Page.click_Admin_Link();
		ClientConsole_Admin_Page.click_CRG();
		ClientConsole_Admin_Page.set_ENter_New_Role_name(sd.get("Role_name"));
		ClientConsole_Admin_Page.click_COLLECTPAY_DEMO_DIV();
		System.out.println(SeleniumCore.driver.getTitle());
		ClientConsole_Admin_Page.click_Save_Create_team();
		}
		
		catch (Exception e) {
			Log.errorHandler("Error occurred During create role functionality in admin .",e);
			Common_Class_clientConsole.commonLink();
	}
	}


	public  void Search_role_Admin(Map<String,String> sd) {
		try {

			ClientConsole_Admin_Page.click_Admin_Link();
			System.out.println("Checking Valid NavigationPage:" +SeleniumCore.driver.getTitle());
			Client_Console_View_Modify_Role_Page.Search_ROle_Fun(sd);
			   sActual=SeleniumCore.driver.getTitle();
			
		}

		catch (Exception e) {
			Log.errorHandler("Error occurred Search Role functionality in admin .",e);
			Common_Class_clientConsole.commonLink();

		}

	}
	/**
	 * @param sd
	 */
	public  void Delete_Role(Map<String,String> sd){
		ClientConsole_Admin_Page.click_Admin_Link();
        ClientConsole_Admin_Page.enter_RoleName(sd.get("role"));
		Client_Console_View_Modify_Role_Page.click_ManageTransaction_Button_ModifyRole();
        ClientConsole_Admin_Page.click_Delete_Role();
		System.out.println(SeleniumCore.driver.getTitle());
		ClientConsole_Admin_Page.click_Delete_Role();
		System.out.println(SeleniumCore.driver.getTitle());
	}

	/**
	 * 
	 */
	@Test
	public  void Add_role_Test(){
		try{
			int i=1;
			Map<String,String> Role_details=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","create_new_role",Integer.toString(i));
			Create_Role_Admin(Role_details);

		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Search Role in Admin Page",e);
			Common_Class_clientConsole.commonLink();
		}


	}

	/**
	 * 
	 */
	@Test
	public  void D_Search_role_Test(){
		try{
			int i=1;
			Map<String,String> Searchdetails=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Search_Role_Admin",Integer.toString(i));
			Search_role_Admin(Searchdetails);
			 String sExpected="View/Modify Role";
			 
			  if(sActual!=sExpected){
				  Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
			  }
			  else{
				  Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
					
			  }
			  Common_Class_clientConsole.commonLink();  
		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Search Role in Admin Page",e);
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





