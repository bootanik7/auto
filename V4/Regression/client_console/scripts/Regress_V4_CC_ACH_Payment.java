package V4.Regression.client_console.scripts;


import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import org.testng.SkipException;

import V4.Regression.client_console.applibs.V4_CC_Payment;
import V4.Regression.client_console.applibs.helpers.RuleHelper;
import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;
import core.webwidgets.StaticText;


/**
 * @author tatyana
 *
 */
public class  Regress_V4_CC_ACH_Payment {
	static Map<String,Connection> conn=null;


	int size=0;

	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
	@BeforeClass

	public static void setUp() throws InterruptedException, Exception, SQLException
	{
		try{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName(); 
		Log.gsScriptDescription = "Test Verifies payment can not be happened without inserting mandatory Routing Number field value.";
		Log.gsScriptAuthor = "Tatyana Zhirnova";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		
		
		Log.initialize();
		Log.logBanner("Negotive scenarious for creating Payment testcase for MAM/NonMAM");
		
		Common_Class_clientConsole.set_test_data_path();
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
		
		
		String date= Common_Class.getsystemdate();
		

		if(Test_login.i==0)

		{
			Log.logScriptInfo("Login to the system");
			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
		
		}
		catch(Exception e){
			//Standard error handling routine
			Log.errorHandler("Error occurred during Test and verify Google About page Testcase.",e);
		}
	}

	
	/**
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	

	

	
	@Test
	public void createPaymentWithNoRoutingNumber_MAM() throws ClassNotFoundException, SQLException, InterruptedException  {
	
		
		Log.startTestCase("Verify payment can not be happened without inserting mandatory Routing Number field value for MAM biller");
		
	
		createACHPaymentWithNoRoutingNumber("MAM_ACH_Types", size,  "ACH_Payment_Data", "Na",conn);
		
		
	}
	
	/*
	@Test
	public void createPaymentWithNoRoutingNumber_NoMAM() throws ClassNotFoundException, SQLException, InterruptedException  {
	
		Log.startTestCase("Verify payment can not be happened without inserting mandatory Routing Number field value for NO MAM biller");
		createPaymentWithNoRoutingNumber("NON_MAM_ACH_Types", size,  "ACH_Payment_Data", "Na",conn);
		
	}

	*/
	
	
	public void createACHPaymentWithNoRoutingNumber(String MAMTYPE, int size, String sheetname, String testCases, Map<String,Connection>connection) throws ClassNotFoundException, SQLException, InterruptedException  {
		try{
			Log.logScriptInfo("Load test data to PaymentDetail object for " +MAMTYPE + " biller");
			V4_CC_Payment paymentDetail = new V4_CC_Payment(MAMTYPE, size,sheetname, testCases, connection);
			
			
			Log.logScriptInfo("Clear Routing Number in PaymentDetail object");
			paymentDetail.Bankdetails.remove("Routing Number");
			paymentDetail.Bankdetails.put("Routing Number", "");
			
			Log.logScriptInfo("Navigate to Payment Entry Page");
			Common_Class_clientConsole.Paymnet_Entry(paymentDetail.accounts);
			
			Log.logScriptInfo("Trying to create Payment ");
			ClientConsole_ACHPayementEntry_Page.ACH_Payment_Entry_details(paymentDetail.Bankdetails, paymentDetail.ACH_types);
			
			Log.logScriptInfo("Check error message");
			this.verifyPaymentCanNotHappened("errors.routing_number.required");
			
		
		
		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during creating " + MAMTYPE +"  payment ",e);
		}
		
	}


	public void verifyPaymentCanNotHappened(String RuleName){
		
		if (this.verifyPageDispalyed("paymententry/submitBankPaymentEntry")){
			if (!this.isErrorMessagePresented(RuleName, Map<String,Connection>connection))
				Log.errorHandler("Message for rule name "+ RuleName +"  doesn't presented on the page");
		}
		else
			Log.errorHandler("Payment Entry Page doesn't dispalay");
	}
	

	
	public boolean verifyPageDispalyed(String sResultLink){

		if (Browser.getURL().contains(sResultLink)){
			
				Log.logScriptInfo("Verified URL: " + "\"" +  sResultLink   + "\"" +  " is present");
				return true;
				
			}
		else
			{
			Log.errorHandler(sResultLink + " doesn't display");
			return false;

			}
		}
	
	
	public boolean isErrorMessagePresented(String RuleName, Map<String,Connection>connection){

		String errorRuleText= RuleHelper.GetRuleValueByRuleName(BusinessID, RuleName, false, connection)
		String errorPageText = new StaticText("//p[@class='body-validation-error']").getText();
		
		return errorText.contains(RuleName) ? true : false;
	}
	
	

	
	
	

	

	
	
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Tatyana Zhirnova
	 */
	public static void tearDown() throws Exception {
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();
		Log.terminate();
		

	}
}











































