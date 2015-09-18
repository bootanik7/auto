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
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author raonag
 *
 */


public class Test_Erm_Modify_BankAC_NickName
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
			Log.gsScriptDescription = "Tests Making Add Bank Account from MAM";
			Log.gsScriptAuthor = "Nagabhushana Rao";
			Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
			Baseclass_Erm.set_test_data_path();
			Log.initialize();
			Log.logBanner("Setup for Make Add Bank Account testcase for MAM");
			
			Common_Class.loadDBproperties();
			 conn = Common_Class.connectDB();
			
			if(Test_Login.i==0)
			{
				Baseclass_Erm.Erm_login(conn);
				Test_Login.i=1;
			}

		}
	/**
	 * @param Ed
	 * @throws InterruptedException
	 * @throws SQLException 
	 */

	public static void Erm_Modify_BankAc_NikeName_Test(Map<String,String> Ed) throws InterruptedException, SQLException
	{    
	
		Erm_AccountSummary_Page.click_on_MngPmtAcnt();
		Erm_ManagePaymentMethod_Page.Modify_NickName(Ed);
		String actul=Erm_ManagePaymentMethod_Page.get_CNF1_text();
		System.out.println(actul);
		String Excep=actul;
		if(actul!=null)
		{
			Common_Class.altVerify(Excep, actul, true);
		}
    }
	@Test()
	public  void modify_Billing_Ac() throws InterruptedException, SQLException
	{
	int i=1;
	Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","NickName",Integer.toString(i));
	Erm_Modify_BankAc_NikeName_Test(getdetails);
    
		
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