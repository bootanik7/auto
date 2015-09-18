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
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class otp_DebitCardPayment implements CommonPayment  {
	int size=0;
	Otp_CreditCardPayement payment = null;
	static Map<String,Connection> conn=null;

	@BeforeClass
	/**
	 * Initializes the automation for testing.
	 * <P>
	 * @throws throws an Exception if an error occurs during the setup portion of the script
	 */
	public static void setUp() throws Exception {
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making Debit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Parvat Patil";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
		Baseclass_otp.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Making Debit Card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
	}

	@Test
	public void Create_DBPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{   
	  try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				if(!Common_Class.V4prop.get("MAM_CC_Types").toString().trim().contains("NA")) 
				
				Baseclass_otp.ExecutePayment("MAM_CC_Types", size, this, "Debit_Card_Payment", "CONFIRMATION",conn);
			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making MAM DC Payment.",e);
		}
	}

	@Test
	public void Create_DBPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{   
		payment = new Otp_CreditCardPayement();
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				if(!Common_Class.V4prop.get("NON_MAM_CC_Types").toString().trim().contains("NA")) 
				
				Baseclass_otp.ExecutePayment("NON_MAM_CC_Types", size, this, "Debit_Card_Payment", "CONFIRMATION",conn);
			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making Non MAM DC Payment.",e);
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

	@Override
	public void makePayment(Map<String, String> sd, String ACH_types)
			throws InterruptedException {
		payment.makePayment(sd, ACH_types);


	}


}
