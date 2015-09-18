package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_Login_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePersonal_IP_BSU_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_RPI_Page;
import V4.Smoke.enrollment.applibs.Erm_SetUpAutoPay_EPI_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author raonag
 *
 */
public class Test_Erm_Autopayment 
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
		Log.gsScriptDescription = "Tests Making AutoPayment from MAM";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Log.initialize();
		Log.logBanner("Setup for Make AutoPayment testcase for MAM");
		Common_Class.loadDBproperties();
		Baseclass_Erm.set_test_data_path();
		conn = Common_Class.connectDB();
		if(Test_Login.i==0)
		{
			Baseclass_Erm.Erm_login(conn);
			Test_Login.i=1;
		}

	}

	public  void Auto_Pament_Test(String Division_business_id) throws InterruptedException
	{    Map<String,String>getfundids=new HashMap<String, String>();
	     Map<String, String>getdata=null;
	     String profile_id;
		try
		{
			
			String username=Baseclass_Erm.getenrolcredentials.get("LOGIN");
			String getprofileid="select * from cp_consumer_profile where business_id ='"+Common_Class.V4prop.getProperty("Business_id")+"' and USERNAME like '%"+username+"%'";
			getdata= Database_query_Manager.getprofileid(getprofileid,conn.get("D2connection"));
			profile_id=getdata.get("CONSUMER_PROFILE_ID");
			String updatebilling_acct_status="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =2 where CONSUMER_PROFILE_ID = "+getdata.get("CONSUMER_PROFILE_ID")+" ";
			Database_query_Manager.updateDB(updatebilling_acct_status,conn.get("D2connection"));
			String updateAccountnumber="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =1 where CONSUMER_PROFILE_ID =  "+getdata.get("CONSUMER_PROFILE_ID")+" and Rownum=1";
			Database_query_Manager.updateDB(updateAccountnumber,conn.get("D2connection"));
			String verifyfun_id="select * from cp_funding_account where CONSUMER_PROFILE_ID="+getdata.get("CONSUMER_PROFILE_ID")+"";
			getdata=Database_query_Manager.funding_account(verifyfun_id, conn.get("D2connection"));
			if(getdata.get("FUNDING_ACCOUNT_ID").isEmpty()){
				//String verifyfun_id="select * from cp_funding_account where CONSUMER_PROFILE_ID="+getdata.get("CONSUMER_PROFILE_ID")+"";
              getfundids=getfundids();
              if(!getfundids.get("Bank_fund_id").isEmpty()){
            	  String update_cp_fund="update cp_funding_account set CONSUMER_PROFILE_ID="+getdata.get("CONSUMER_PROFILE_ID")+" where FUNDING_ACCOUNT_ID="+getfundids.get("Bank_fund_id")+"";
      			  Database_query_Manager.updateDB(update_cp_fund,conn.get("D2connection"));

              }
              else if(!getfundids.get("Credit_fun_id").isEmpty()) {
            	  String update_cp_fund="update cp_funding_account set CONSUMER_PROFILE_ID="+getdata.get("CONSUMER_PROFILE_ID")+" where FUNDING_ACCOUNT_ID="+getfundids.get("Credit_fun_id")+"";
      			  Database_query_Manager.updateDB(update_cp_fund,conn.get("D2connection"));
              }
              else if(!getfundids.get("Debit_fun_id").isEmpty()){
            	  String update_cp_fund="update cp_funding_account set CONSUMER_PROFILE_ID="+getdata.get("CONSUMER_PROFILE_ID")+" where FUNDING_ACCOUNT_ID="+getfundids.get("Debit_fun_id")+"";
      			  Database_query_Manager.updateDB(update_cp_fund,conn.get("D2connection"));
              }
			}
			else {
				String update_cp_fund="update cp_funding_account set FUNDING_ACCOUNT_STATUS_ID=1 where CONSUMER_PROFILE_ID="+profile_id+"";
    			  Database_query_Manager.updateDB(update_cp_fund,conn.get("D2connection"));

			}
			//Test_Erm_Add_BankAc addbank = new Test_Erm_Add_BankAc();
			//addbank.Add_Bank_Ac();
			
			Thread.sleep(3000);
			Erm_AccountSummary_Page.click_on_SetupAutoPay();
			Erm_SetUpAutoPay_EPI_Page.click_Weekly();
			Erm_SetUpAutoPay_EPI_Page.select_FixedWeek("Wednesday");
			Erm_SetUpAutoPay_EPI_Page.click_AmtDue();
			Erm_SetUpAutoPay_EPI_Page.Enter_AutoDebit(Common_Class.getsystemdate());
			Erm_SetUpAutoPay_EPI_Page.click_UntilCancelled();
			List<String>list= Erm_AccountSummary_Page.collectlistitems();
			//System.out.println("it is in main "+list);
			
			Erm_AccountSummary_Page.clickondropdown(list.get(1));
			Erm_Login_Page.Submit();
			Thread.sleep(3000);
			Erm_PayYourBillNow_RPI_Page.click_on_termandcondt();
			Erm_ManagePersonal_IP_BSU_Page.click_on_Submit();
			Thread.sleep(3000);

			Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();
		}
	}
	public  Map<String,String>getfundids() throws SQLException{
		Map<String,String>map=null;
		if(Common_Class.V4prop.get("Funding_Type").toString().contains("ACH")){
			String bank_fundid="select * from cp_bank_account where ROWNUM =1 order by UPDATE_DTM desc";
			map= Database_query_Manager.funding_account(bank_fundid, conn.get("D2connection"));
			
		}
		else if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){
			String card_fundid="select * from cp_credit_card_account where ROWNUM =1 order by UPDATE_DTM desc";
			map= Database_query_Manager.funding_account(card_fundid, conn.get("D2connection"));
		}
		else if(Common_Class.V4prop.get("Funding_Type").toString().contains("Debit")){
			String Debit_fundid="select * from cp_debit_card_account where ROWNUM =1 order by UPDATE_DTM desc";
			map= Database_query_Manager.funding_account(Debit_fundid, conn.get("D2connection"));
		}

		return map;

	}


	@Test
	public void Erm_Auto_Pament_Test() throws InterruptedException {
		List<String>getdiv_ids=Common_Class.collectdivision_ids();
		Auto_Pament_Test(getdiv_ids.get(0));	

	}
}


