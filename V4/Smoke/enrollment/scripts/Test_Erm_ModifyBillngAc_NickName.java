package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePaymentMethod_Add_A_BankAc;
import V4.Smoke.enrollment.applibs.Erm_ManagePaymentMethod_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class Test_Erm_ModifyBillngAc_NickName 
{
	static Map<String,String> Bankdetails;
	static Map<String,Connection> conn=null;

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
	
	public static void Erm_ModifyBillingAc_NickName_test(Map<String,String> Ed)throws InterruptedException
	{

		Erm_AccountSummary_Page.click_on_MngPmtAcnt();
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Ac_Nick_Name(Ed.get("NickName"));
		Erm_ManagePaymentMethod_Page.click_on_Update();
		System.out.println(Erm_ManagePaymentMethod_Page.get_CNF1_text());
	}
	@Test
	public  void Add_New_Billing_Ac() throws InterruptedException
	{
	int i=1;
	Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","BillNickName",Integer.toString(i));
    Erm_ModifyBillingAc_NickName_test(getdetails);
		
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
