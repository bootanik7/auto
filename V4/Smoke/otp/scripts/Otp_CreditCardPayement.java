package V4.Smoke.otp.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.otp.applibs.Baseclass_otp;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.OTP_FundingInfo_Page;
import V4.Smoke.otp.applibs.Otp_CreditCardPayementPage;
import V4.Smoke.otp.applibs.Otp_payment_info_page;
import V4.Smoke.otp.applibs.Verify_payment_info_page;
import V4.Smoke.otp.applibs.otp_CreditCardEntryPAge;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;



/**
 * The Credit card Payment script executes Making Payments from MAM and Non MAM account 
 * <P>
 */
/**
 * @author patilpa
 *
 */
public class Otp_CreditCardPayement implements CommonPayment {
	static Map<String,Connection> conn=null;
	int size=0;

	@BeforeClass
	/**
	 * Initializes the automation for testing.
	 * <P>
	 * @throws throws an Exception if an error occurs during the setup portion of the script
	 */
	public static void setUp() throws Exception {
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making Credit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Parvat Patil";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
		Baseclass_otp.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Making Credit Card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
	}

	/**
	 * These testcases execute a Making a Payment from Credit card Payment and verify the confirmation number
	 * @param i the row to execute
	 * <p>
	 * 
	 */
	public  void makePayment(Map<String,String> sd,String CC_Types)throws InterruptedException
	{

		try
		{
            OTP_FundingInfo_Page.selectcardpayment();
			Thread.sleep(5000);
			Otp_CreditCardPayementPage.Entercard_details(sd, CC_Types);
			Verify_payment_info_page.continueverifyinfopage();
						
		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred while making CC/DC card Paymnent.",e);
		}


	}


	/**
	 * This Test case executes the Making a payment for MAM Account with valid details
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */

	@Test
	public void createPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(!Common_Class.V4prop.get("MAM_CC_Types").toString().trim().contains("NA")) 
		
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				Baseclass_otp.ExecutePayment("MAM_CC_Types", size, this, "CreditCard_Payment", "CONFIRMATION",conn);

			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making MAM CC/DC Payment.",e);
		}
	}

	/**
	 * This Test case executes the Making a payment for Non MAM Account with valid details
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */

	@Test
	public void createPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(!Common_Class.V4prop.get("NON_MAM_CC_Types").toString().trim().contains("NA")) 
		
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				Baseclass_otp.ExecutePayment("NON_MAM_CC_Types", size, this, "CreditCard_Payment", "CONFIRMATION",conn);

			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making Non MAM CC/DC Payment.",e);
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


