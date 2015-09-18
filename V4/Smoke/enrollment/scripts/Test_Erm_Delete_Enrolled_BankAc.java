package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePaymentMethod_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_Card_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author raonag
 *
 */
public class Test_Erm_Delete_Enrolled_BankAc
{   

	static Map<String,Connection> conn=null;
	 /**
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass 
	 public static void setUp() throws InterruptedException, ClassNotFoundException, SQLException
		{
			Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
			Log.gsScriptDescription = "Tests Making Deleting Billing Ac from MAM";
			Log.gsScriptAuthor = "Nagabhushana Rao";
			Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
			Baseclass_Erm.set_test_data_path();
			Log.initialize();
			Log.logBanner("Setup for Make Deleting Billing Ac testcase for MAM");
			
			Common_Class.loadDBproperties();
			
			conn = Common_Class.connectDB();
			 
			if(Test_Login.i==0)
			{
				Baseclass_Erm.Erm_login(conn);
				Test_Login.i=1;
			}
		}
	/**
	 * This Test case executes  delete a Enrolled A/c for  MAM Account with valid details
	 * @throws InterruptedException
	 */
	@Test()
	public  void Erm_Delete_Enrolled_Test() throws InterruptedException
	{    	
		try
		{
		Erm_AccountSummary_Page.click_on_MngPmtAcnt();
		Erm_ManagePaymentMethod_Page.click_on_Delete();
		Erm_PayYourBillNow_Card_Page.click_on_Continue();
		Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();
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
