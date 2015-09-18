package V4.Smoke.client_console.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.client_console.applibs.clientConsole_PaymentEntry_CCpage;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
/**
 * @author enturua
 *
 */
public class CilentConsole_CreditCard_payment implements CommonPayment_clientconsole  {
	String getconfirmation;
	static Map<String,Connection> conn=null;
	int size=0;

	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */

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



	/* (non-Javadoc)
	 * @see V4.Smoke.client_console.scripts.CommonPayment_clientconsole#makePayment(java.util.Map, java.lang.String, java.util.Map)
	 */
	public  String makePayment(Map<String,String> sd,String CC_Type,Map<String, String>accountdetails){
		
		try {
			
			Common_Class_clientConsole.Paymnet_Entry(accountdetails);
			clientConsole_PaymentEntry_CCpage.ClientConsole_CC_PaymnetDetails(sd,CC_Type );
			String Payment_confNum = ClientConsole_login.confirmation_number();
			 getconfirmation = Payment_confNum.replaceAll("\\D", "");

		} 
		catch (Exception e) 
		{
			Log.errorHandler("Error occurred while making CC/DC card Paymnent.",e);
			//Common_Class_clientConsole.commonLink();

		}
		return getconfirmation;

	}


	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void createCreditCard_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(Common_Class.V4prop.get("MAM_CC_Types").toString().trim().contains("NA")) 
		{

			throw new SkipException("No Mam Details Present");
		}
		try{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				Common_Class_clientConsole.ExecutePayment("MAM_CC_Types", size, this, "CreditCard_Payment","CONFIRMATION",conn);

			}
		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Making MAM CC Payment.",e);
		}
	}


	@Test
	public void createPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(Common_Class.V4prop.get("NON_MAM_CC_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Non Mam Details Present");
		}
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Credit")){

				Common_Class_clientConsole.ExecutePayment("NON_MAM_CC_Types", size, this, "CreditCard_Payment", "CONFIRMATION",conn);

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


