package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class Delete_Admin_Page {
	static Map<String,Connection> conn=null;
	static HashMap<String, String> map;
	String sActual;

	@BeforeClass


	public static void verify() throws InterruptedException, Exception, SQLException {
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription ="";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		if(Test_login.i==0)
		{  
			Common_Class_clientConsole.set_test_data_path(); 
			Log.initialize();
			Log.logBanner("Delete Admin page ");
			Common_Class.loadDBproperties();
			conn=Common_Class.connectDB();
			Test_login.i=1;
			Common_Class_clientConsole.client_console_login(conn);
		}
	}
	@Test
	public  void Delete_role_Test(){
		try{
			ClientConsole_Add_Role deleterole = new ClientConsole_Add_Role();
			int i=1;
			Map<String,String> DeleteDeatils=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Search_Role_Admin",Integer.toString(i));
			deleterole.Delete_Role(DeleteDeatils);

		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Delete Role in Admin Page",e);
		}


	}

	@Test
	public  void Delete_Team_Test(){
		try{
			ClientConsole_Add_Team_Admin deleteTeam=new ClientConsole_Add_Team_Admin();
			int i=1;
			Map<String,String> Delete_Team_Deatils=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Create_New_team",Integer.toString(i));
			deleteTeam.Delete_Team(Delete_Team_Deatils);

		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Delete Team in Admin Page",e);
		}


	}
	@Test
	public  void Delete_User_Test(){
		try{
			CilentConsole_Add_User_Admin delete_User=new CilentConsole_Add_User_Admin();
			int i=1;
			Map<String,String> DeleteDeatils=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Search_User",Integer.toString(i));
			delete_User.Delete_user(DeleteDeatils);

		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during DeleteUser in Admin Page",e);
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
