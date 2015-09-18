package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author enturua
 *
 */
public class ClientConsole_ACH_Payment implements CommonPayment_clientconsole  {
	static Map<String,Connection> conn=null;
//	staticString  getconfirmation;

	int size=0;

	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
	@BeforeClass

	public static void setUp() throws InterruptedException, Exception, SQLException
	{
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
		//String Updatequery="update cp_payment set payment_status_id = 8  where Business_id ="+Common_Class.V4prop.getProperty("Business_id")+" and TO_DATE(CREATE_DTM) = (select TO_DATE(max(CREATE_DTM)) from cp_payment WHERE BUSINESS_ID in ("+Common_Class.V4prop.getProperty("Business_id")+"))";

		String Updatequery="update cp_payment set payment_status_id = 8  where APPLICATION_BUSINESS_ID ="+Common_Class.V4prop.getProperty("Business_id")+" and  TO_DATE(CREATE_DTM) = (select TO_DATE(max(CREATE_DTM)) from cp_payment WHERE APPLICATION_BUSINESS_ID in ("+Common_Class.V4prop.getProperty("Business_id")+"))"; 
		Database_query_Manager.updateDB(Updatequery,conn.get("D2connection"));


		if(Test_login.i==0)

		{
			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
	}


	public String makePayment(Map<String, String> sd, String ACH_types,Map<String, String> accountdetails)  {
		 String getconfirmation = null;
		try {
			size = 0;
           
			Common_Class_clientConsole.Paymnet_Entry(accountdetails);
			ClientConsole_ACHPayementEntry_Page.ACH_Payment_Entry_details(sd,ACH_types);
			String Payment_confNum = ClientConsole_login.confirmation_number();
			getconfirmation = Payment_confNum.replaceAll("\\D", "");
			Common_Class_clientConsole.commonLink();

		} catch (InterruptedException e) {
			Common_Class_clientConsole.commonLink();	
		}

		return getconfirmation;

	}

	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	/*@Test
	public void createACHPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{

			Common_Class_clientConsole.ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);
		}
	}
*/
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */

	/*@Test
	public void createACHPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException 
	{

		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA"))
		{
			throw new SkipException("No Non Mam Details Present");
		}
		try{

			Common_Class_clientConsole.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data","CONFIRMATION",conn);
			Common_Class_clientConsole.Verify_Cancel_ACHPayment_MAM( "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);
			
		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making  non MAM ACH Payment.",e);
		}
	}*/

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void ClientConsole_ModifyACHPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{  
		 Map<String, String> map =null;

		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment_Data", "Na",conn);
			int i=1;
			Map<String,String> Bankdetails=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Modify_Payment",Integer.toString(i));
			Common_Class_clientConsole.ModifyPayment(Bankdetails, "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);
			String confirmation="select * from cp_payment where CONFIRMATION_NUMBER ="+Common_Class_clientConsole.getconfirmation+"";
			 map= Database_query_Manager.get_cp_payment(confirmation, conn.get("D2connection"));
	         Common_Class.altVerify(map.get("PAYMENT_AMOUNT"),Bankdetails.get("Amount Due"), true);
		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Modifying  MAM ACH Payment.",e);
		}

	}
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */

	/*@Test
	public void ClientConsole_ModifyACHPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{
		 Map<String, String> map =null;

		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);
			int i=0;
			Map<String,String> Bankdetails=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls","Modify_Payment",Integer.toString(i));
			Common_Class_clientConsole.ModifyPayment(Bankdetails, "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);
			String confirmation="select * from cp_payment where CONFIRMATION_NUMBER ="+Common_Class_clientConsole.getconfirmation+"";
			 map= Database_query_Manager.get_cp_payment(confirmation, conn.get("D2connection"));
	         Common_Class.altVerify(map.get("PAYMENT_AMOUNT"),Bankdetails.get("Amount Due"), true);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Modifying NON-MAM ACH Payment.",e);
		}


	}*/
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */

	@Test
	public void ClientConsole_SearchPaymnet_ConfNum() throws ClassNotFoundException, SQLException, InterruptedException
	{

		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment_Data", "NA",conn);
			Common_Class_clientConsole.Search_Paymnet_ConfNum( "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Searching MAM ACH Payment.",e);
		}

	}

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void ClientConsole_SearchPaymnet_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{

	if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data", "NA",conn);
			Common_Class_clientConsole.Search_Paymnet_ConfNum( "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during searching NON_MAM ACH Payment.",e);
		}


	}
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	/*@Test
	public void ClientConsole_CancelPayment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{


		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);
			Common_Class_clientConsole.Verify_Cancel_ACHPayment_MAM( "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);
   
		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Canceling MAM ACH Payment.",e);
		}

	}*/
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	/*@Test
	public void ClientConsole_CancelPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{

		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		try{
			Common_Class_clientConsole.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data", "CONFIRMATION",conn);
			Common_Class_clientConsole.Verify_Cancel_ACHPayment_MAM( "MAM_ACH_Types",Common_Class_clientConsole.getconfirmation);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Canceling MAM ACH Payment.",e);
		}
	}*/

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











































