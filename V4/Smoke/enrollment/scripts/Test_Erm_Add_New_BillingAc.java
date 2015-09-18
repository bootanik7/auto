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
import org.testng.SkipException;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_MBAccountSummury_Adding_Page;
import V4.Smoke.enrollment.applibs.Erm_ManageBillingAccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_Card_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Erm_Add_New_BillingAc
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
		Log.gsScriptDescription = "Tests Making Add Billing Account from MAM Web Enrollment";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Baseclass_Erm.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for ADD/MODIFY/DELETE Billing Account testcase for MAM Web Enrollment");
		Common_Class.loadDBproperties();
		conn = Common_Class.connectDB();

		if(Test_Login.i==0)
		{
			Baseclass_Erm.Erm_login(conn);
			Test_Login.i=1;
		}

	}

	/** This Method accepts below required parameters and executes Enter_Billing_Ac_details for adding new billing account
	 * @param Division_business_id
	 * @param getaccountdata
	 * @throws InterruptedException
	 */
	public  void Erm_Add_New_BillingAc_test(String Division_business_id,Map<String,String>getaccountdata) throws InterruptedException
	{
		Map<String,String>getdata=null;
		try {
			getdata=getaccountdata;
			String getprofileId="select cp.Consumer_Profile_ID from CP_Billing_Account_en cb, Cp_consumer_profile cp where cp.Consumer_Profile_ID = cb.Consumer_Profile_ID and  cb.Billing_account_status_id =1 and  cp.Consumer_profile_status_id =1 and  cb.billing_account_number ='"+getdata.get("ACCOUNT_NUMBER")+"' and cb.division_business_id ="+Division_business_id+""; 
			List<String>getid=Database_query_Manager.getprofileids(getprofileId, conn.get("D2connection"));
			if(!getid.isEmpty()){
				String updatebilling_acct_status="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =2 where Consumer_Profile_ID in ("+getid.toString().substring(1, getid.toString().length() - 1)+")";
				Database_query_Manager.updateDB(updatebilling_acct_status,conn.get("D2connection"));
			}
			String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and TO_DATE(PROMOTED_DTM) = (select TO_DATE(max(PROMOTED_DTM)) from IA_LIVE_Business WHERE BUSINESS_ID in ("+Division_business_id+"))";
			getdata.putAll((Database_query_Manager.get_IA_LIVE_Business(query1,conn.get("IAconconnection"))));
			String Division=getdata.get("PRIMARY_NAME");
			getdata.put("PRIMARY_NAME", Division);
			Erm_AccountSummary_Page.click_on_MngBilingAcnt();
			Erm_ManageBillingAccountSummary_Page.click_Here();
			Erm_MBAccountSummury_Adding_Page.Enter_Billing_Ac_details(getdata);
			Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();	
		}
	}

	/** This testcase executes the functionality of adding a new billing account
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	@Test
	public void Add_New_Billing_Ac() throws InterruptedException, SQLException
	{
		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA"))
		{
			throw new SkipException("No Mam Details Present");
		}
		try {
			Log.startTestCase("Started executing Adding a new billing account");
			Map<String,String>getmamdata=null;
			List<String>getdiv_ids=Common_Class.collectdivision_ids();
			String query="select * from RTDS_MAM_"+Common_Class.V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+getdiv_ids.get(0)+" and ROWNUM <=8";
			List< Map<String, String>> billerRecords= Database_query_Manager.getRTDSinfo(query, conn.get("RTDSconconconnection"));
			getmamdata=billerRecords.get(0);
			Erm_Add_New_BillingAc_test(getdiv_ids.get(0),getmamdata);	
		}catch(Exception e){
			Log.errorHandler("Error occurred while verifying billing account.",e);			

		}
	}



	/** This testcase executes the functionality of modifying the added billing account
	 * @throws InterruptedException
	 */
	@Test
	public  void modify_Billing_Ac() throws InterruptedException
	{
		int i=1;
		Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","BillNickName",Integer.toString(i));
		Test_Erm_ModifyBillngAc_NickName.Erm_ModifyBillingAc_NickName_test(getdetails);
	}


	/**This testcase executes the functionality of deleting the added billing account
	 * @throws InterruptedException
	 */
	@Test
	public void Erm_Delete_BillingAc_test() throws InterruptedException
	{
		try{
			Erm_AccountSummary_Page.click_on_MngBilingAcnt();
			Erm_ManageBillingAccountSummary_Page.click_Delete();
			Erm_PayYourBillNow_Card_Page.click_on_Continue();
			//	Baseclass_Erm.Common_Link();
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

