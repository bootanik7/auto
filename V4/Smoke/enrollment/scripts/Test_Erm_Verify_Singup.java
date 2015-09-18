package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_Login_Page;
import V4.Smoke.enrollment.applibs.Erm_SingUp_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;


/**
 * @author raonag
 *
 */
public class Test_Erm_Verify_Singup
{

	static Map<String,Connection> conn=null;
	static String URL;
	/**
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass 
	public static void setUp() throws InterruptedException, ClassNotFoundException, SQLException
	{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making for signin from MAM";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Baseclass_Erm.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Make for signin testcase for MAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
	}

	/**
	 * @param Ed
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	public void Erm_SignUp_test(Map<String,String> Ed) throws InterruptedException, SQLException
	{
		Browser.start();
		URL=Common_Class.V4prop.getProperty("Enrweburl")+Common_Class.V4prop.getProperty("Business_id");
		Browser.loadURL(URL,Log.giAutomationShortTO);
		String verify_consumer="select * from cp_consumer_profile where business_id="+Common_Class.V4prop.getProperty("Business_id")+" and USERNAME ='"+Ed.get("UserName")+"'";
		Map<String,String>username=Database_query_Manager.getprofileid(verify_consumer,conn.get("D2connection"));
		String update_status="update cp_consumer_profile set CONSUMER_PROFILE_STATUS_ID =2 where business_id="+Common_Class.V4prop.getProperty("Business_id")+" and USERNAME ='"+Ed.get("UserName")+"'";
		if(username.containsKey("CONSUMER_PROFILE_ID")){
			Database_query_Manager.updateDB(update_status, conn.get("D2connection"));
		}
		Erm_Login_Page.Click_signUp();
		Erm_SingUp_Page.Enter_SingUp_details(Ed);
		Erm_AccountSummary_Page.clickgoToAcctpage();
		//Database_query_Manager.updateDB(update_status, conn.get("D2connection"));
	}
	/**
	 * @throws InterruptedException
	 */
	@Test()
	public void ERM_MAM_Singup() throws InterruptedException
	{
		try {
			List< Map<String, String>>billerRecords=null;
			Map<String,String>IAdata=null;
			Log.startTestCase("Started executing Enrolling new user");
			int i=1;
			List<String>getdivids=Common_Class.collectdivision_ids();
			Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","SignUp",Integer.toString(i));
			billerRecords=Common_Class.getmamdetails(getdivids.get(0), 6, conn);
			getdetails.putAll(billerRecords.get(0));
			String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+getdivids.get(0)+") and TO_DATE(PROMOTED_DTM) = (select TO_DATE(max(PROMOTED_DTM)) from IA_LIVE_Business WHERE BUSINESS_ID in ("+getdivids.get(0)+"))";
			IAdata=Database_query_Manager.get_IA_LIVE_Business(query1, conn.get("IAconconnection"));
			getdetails.putAll(IAdata);
			Erm_SignUp_test(getdetails);
		}catch(Exception e){
			Log.errorHandler("Error occurred while Enrolling new user.",e);			
		}
	}
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Nagabhushana Rao
	 */
	@AfterClass

	public static void tearDown() throws Exception 
	{
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();
	}

}
