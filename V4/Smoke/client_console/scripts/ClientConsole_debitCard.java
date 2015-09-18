package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class ClientConsole_debitCard implements CommonPayment_clientconsole {
	CilentConsole_CreditCard_payment payment = null;
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
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		Log.initialize();
		Log.logBanner("Setup for Making Debit card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		Common_Class_clientConsole.set_test_data_path();
		conn=Common_Class.connectDB();

		if(Test_login.i==0)

		{

			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
	}


	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void Create_DBPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{   
		payment = new CilentConsole_CreditCard_payment();
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Debit")){

				if(Common_Class.V4prop.get("MAM_CC_Types").toString().trim().contains("NA")) 
				{
					throw new SkipException("No Mam Details Present");
				}
				Common_Class_clientConsole.ExecutePayment("MAM_CC_Types",size, this, "Debit_Card_Payment" ,"CONFIRMATION", conn);
			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making MAM DC Payment.",e);
		}
	}

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void Create_DBPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{   
		payment = new CilentConsole_CreditCard_payment();
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Debit")){

				if(Common_Class.V4prop.get("NON_MAM_CC_Types").toString().trim().contains("NA")) 
				{
					throw new SkipException("No Mam Details Present");
				}
				Common_Class_clientConsole.ExecutePayment("MAM_CC_Types",size, this, "Debit_Card_Payment" ,"CONFIRMATION", conn);
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

	/* (non-Javadoc)
	 * @see V4.Smoke.client_console.scripts.CommonPayment_clientconsole#makePayment(java.util.Map, java.lang.String, java.util.Map)
	 */
	@Override
	public String makePayment(Map<String, String> sd, String ACH_types,Map<String, String>accountdetails)
			throws InterruptedException {
		payment.makePayment(sd, ACH_types,accountdetails);
		return null;

	}
}



























