package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.client_console.applibs.Reports_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

public class ClientConsole_Verify_Reports {

	static Map<String,Connection> conn=null;

	@BeforeClass

	public static void setUp() throws InterruptedException, Exception, SQLException {

		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making Credit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		Common_Class_clientConsole.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Making Credit Card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
		String date= Common_Class.getsystemdate();
		String Updatequery="update cp_payment set payment_status_id = 8  where APPLICATION_BUSINESS_ID ="+Common_Class.V4prop.getProperty("Business_id")+" and  TO_DATE(CREATE_DTM) = (select TO_DATE(max(CREATE_DTM)) from cp_payment WHERE APPLICATION_BUSINESS_ID in ("+Common_Class.V4prop.getProperty("Business_id")+"))";
		Database_query_Manager.updateDB(Updatequery,conn.get("D2connection"));

		if(Test_login.i==0)

		{

			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
	}


	@Test

	public 
	void verify_Reports_Test(){


		Reports_Page.click_HomePage_Link_ReportTab();
		System.out.println("reports page:"+ SeleniumCore.driver.getTitle());


		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_click_Report_Link_TransReport())
		{
			Reports_Page.click_Report_Link_TransReport();
			System.out.println("verify TRANSCTION REPORTS PAGE:  "+SeleniumCore.driver.getTitle());
		}




		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_click_Report_Link_SettleReport_present()){
			Reports_Page.click_Report_Link_SettleReport();
			System.out.println("verify SettleReport PAGE:  "+SeleniumCore.driver.getTitle());
		}


		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_Report_Link_HourReport_present()){

			Reports_Page.click_Report_Link_HourReport();
			System.out.println("verify HourReport PAGE:  "+SeleniumCore.driver.getTitle());

		}



		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_click_Report_Link_NotificationReport_present()){
			Reports_Page.click_Report_Link_NotificationReport();
			System.out.println("verify NotificationReport PAGE:  "+SeleniumCore.driver.getTitle());
		}



		Reports_Page.click_HomePage_Link_ReportTab();
		Reports_Page.click_Report_Link_EnrReport();
		System.out.println("verify TRANSCTION REPORTS PAGE:  "+SeleniumCore.driver.getTitle());



		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page. is_Report_Link_EnrReport_present()){
			Reports_Page.click_Report_Link_EnrReport();
			System.out.println("verify Enrollment PAGE:  "+SeleniumCore.driver.getTitle());}



		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_Report_Link_RejectReport_present()){
			Reports_Page.click_Report_Link_RejectReport();
			System.out.println("verify RejectReport PAGE:  "+SeleniumCore.driver.getTitle());}



		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_Report_Link_Link_IVRReport_present()){
			Reports_Page.click_Report_Link_IVRReport();
			System.out.println("verify IVR Report PAGE :  "+SeleniumCore.driver.getTitle());
		}



		Reports_Page.click_HomePage_Link_ReportTab();
		if(Reports_Page.is_Report_Link_CCActivityReport_present()){
			Reports_Page.click_Report_Link_CCActivityReport();
			System.out.println("verify Client console reports PAGE:  "+SeleniumCore.driver.getTitle());}

		Common_Class_clientConsole.commonLink();

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
