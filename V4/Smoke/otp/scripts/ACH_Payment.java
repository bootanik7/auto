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
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;


/**
 * The ACH  Bank Payment  script executes Creating a Payment for MAM and Non MAM Account
 * <P>
 */
public class ACH_Payment implements CommonPayment{
	static Map<String,Connection> conn=null;
	static int size=0;

	@BeforeClass
	/**
	 * Initializes the automation for testing.
	 * <P>
	 * @throws throws an Exception if an error occurs during the setup portion of the script
	 */
	public static void setUp() throws Exception 
	{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription ="Tests Making ACH Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Parvat Patil";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
		Baseclass_otp.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Make ACH Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();

	}	

	/**
	 * This Methods performs an action on the Payment info and Payment entry page
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */

	public void makePayment(Map<String,String> sd,String ACH_types) throws InterruptedException
	{
		size=0;
		
		OTP_FundingInfo_Page.selectBankPayment();

		Otp_payment_info_page.proceedpayment(sd, ACH_types);

		Verify_payment_info_page.continueverifyinfopage();
	}

	/**
	 * This Test case executes the Making a payment for  MAM Account with valid details
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	@Test
	public void createACHPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(!Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		
		try{

			Baseclass_otp.ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);
		}
	}

	/**
	 * This Test case executes the Making a payment for  Non MAM Account with valid details
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	@Test
	public void createACHPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException 
	{
		if(!Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA"))
		
		try{

			Baseclass_otp.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);
		}
	}



	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Parvat Patil 
	 */
	public static void tearDown() throws Exception 
	{
		 Common_Class.closedbconnection(conn);

		 Common_Class.terminate();

	}

}







