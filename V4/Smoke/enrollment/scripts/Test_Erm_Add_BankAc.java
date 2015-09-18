package V4.Smoke.enrollment.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePaymentMethod_Add_A_BankAc;
import V4.Smoke.enrollment.applibs.Erm_ManagePaymentMethod_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_Card_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author raonag
 *
 */
/**
 * @author patilpa
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Erm_Add_BankAc 
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


	/**This method accepts testdata and executes click_on_AddBackAcc for adding a bank payment method
	 * @param Ed
	 * @param ACH_types
	 * @param Account_number
	 * @throws InterruptedException
	 */
	public  void Erm_Add_BankAc_test(Map<String,String> Ed,String ACH_types,String Account_number) throws InterruptedException
	{
		try
		{
			String username=Baseclass_Erm.getenrolcredentials.get("LOGIN");
			Map<String, String>getdata;
			String getprofileid="select * from cp_consumer_profile where business_id ='"+Common_Class.V4prop.getProperty("Business_id")+"' and USERNAME like '%"+username+"%'";
			getdata= Database_query_Manager.getprofileid(getprofileid,conn.get("D2connection"));
			String updatebilling_acct_status="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =2 where CONSUMER_PROFILE_ID = "+getdata.get("CONSUMER_PROFILE_ID")+" ";
			Database_query_Manager.updateDB(updatebilling_acct_status,conn.get("D2connection"));
			String updateAccountnumber="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =1 where CONSUMER_PROFILE_ID =  "+getdata.get("CONSUMER_PROFILE_ID")+" and Rownum=1";
			Database_query_Manager.updateDB(updateAccountnumber,conn.get("D2connection"));
			String updatefundingaccount="update cp_funding_account set FUNDING_ACCOUNT_STATUS_ID=2 where CONSUMER_PROFILE_ID =  "+getdata.get("CONSUMER_PROFILE_ID")+" and Rownum=1";
			Database_query_Manager.updateDB(updatefundingaccount,conn.get("D2connection"));
			Erm_AccountSummary_Page.click_on_MngPmtAcnt();
			Erm_ManagePaymentMethod_Page.click_on_AddBackAcc();
			Erm_ManagePaymentMethod_Add_A_BankAc.Add_a_BankAc_details(Ed,ACH_types);
			String Actul=Erm_ManagePaymentMethod_Page.Add_Bank_CNF_text();
			String Exep="Funding account has been enrolled successfully";
			if(Actul!=null)
			{
				Common_Class.altVerify(Exep, Actul, true);
			}

			Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();
		}
	}

    
	/** This testcase executes adding the bank payment method
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	@Test
	public void Add_Bank_Ac() throws InterruptedException, SQLException
	{ 
		try{
			Log.startTestCase("Started executing Adding a bank account");
			Map<String,String>getmamdata=null;
			String[] type = Common_Class.getACHTypes();
			int i=1;
			List<String>getdiv_ids=Common_Class.collectdivision_ids();
			Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","Add_Bank_Ac",Integer.toString(i));
			String query="select * from RTDS_MAM_"+Common_Class.V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+getdiv_ids.get(0)+" and ROWNUM <=8";
			List< Map<String, String>> billerRecords= Database_query_Manager.getRTDSinfo(query, conn.get("RTDSconconconnection"));
			getmamdata=billerRecords.get(0);
			Erm_Add_BankAc_test(getdetails,type[0],getmamdata.get("ACCOUNT_NUMBER"));
		}catch(Exception e) {
			Log.errorHandler("Error occurred while verifying bank account.",e);			
		}
	}

	/** This testcase executes modifying nickname of bank account
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	/*@Test
	public  void Modify_Nickname_bank() throws InterruptedException, SQLException
	{
		try{
			Log.startTestCase("Started executing Modifying nickname for a bank account");
			int i=1;
			Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","NickName",Integer.toString(i));
			Erm_AccountSummary_Page.click_on_MngPmtAcnt();
			Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Ac_Nick_Name(getdetails.get("NickName"));
			Erm_ManagePaymentMethod_Page.click_on_Update();
			//verification has to be done

		}catch(Exception e) {
			Baseclass_Erm.Common_Link();
			Log.errorHandler("Error occurred while Modifying nickname for a bank account.",e);		
		}
	}*/

	/** This testcase executes deleting the enrolled bank account
	 * @throws InterruptedException
	 */
	@Test
	public void Erm_Delete_Enrolled_Test() throws InterruptedException
	{    	
		try
		{
			Log.startTestCase("Started executing Deleting a bank account");
			Erm_AccountSummary_Page.click_on_MngPmtAcnt();
			Erm_ManagePaymentMethod_Page.click_on_Delete();
			Erm_PayYourBillNow_Card_Page.click_on_Continue();
			//verification has to be done
			Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();
			Log.errorHandler("Error occurred while Deleting bank account.",e);			

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
