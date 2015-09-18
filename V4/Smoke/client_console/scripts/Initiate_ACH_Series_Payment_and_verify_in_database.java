package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class Initiate_ACH_Series_Payment_and_verify_in_database implements  CommonPayment_clientconsole {

	static Map<String,Connection> conn=null;
	int size=0;
	@BeforeClass
	public static void setUp() throws InterruptedException, Exception, SQLException
	{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making Credit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Archana Enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 
		Log.initialize();
		Log.logBanner("Setup for Making Credit Card Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		Common_Class_clientConsole.set_test_data_path();
		conn=Common_Class.connectDB();
		if(Test_login.i==0)

		{
			Common_Class_clientConsole.client_console_login(conn);
			Test_login.i=1;
		}
	}




	public String makePayment(Map<String,String> sd,String ACH_types,Map<String, String>accountdetails){

		try {


			Common_Class_clientConsole.Paymnet_Entry(accountdetails);
			ClientConsole_ACHPayementEntry_Page.clear_emailTextField();


			ClientConsole_ACHPayementEntry_Page.clear_emailTextField();

			if(ClientConsole_ACHPayementEntry_Page.isEmailCheck_Present()){

				ClientConsole_ACHPayementEntry_Page.click_CC_email();
			}

			ClientConsole_ACHPayementEntry_Page.click_PaymentEntry_Button_SeriesPymt();

			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent()){

				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice();

			}

			ClientConsole_ACHPayementEntry_Page.Payment_DATE(Common_Class.getsystemdate());

			Thread.sleep(2000);
			if(ClientConsole_ACHPayementEntry_Page .isInvoicePresent1())
			{
				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice1();
			}

			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent2()){

				ClientConsole_ACHPayementEntry_Page.Payment_DATE1(Common_Class.getsystemdate());
			}

			Thread.sleep(2000);
			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent3()){
				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice2();

				ClientConsole_ACHPayementEntry_Page.Payment_DATE2(Common_Class.getsystemdate());}

			Thread.sleep(2000);
			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent4()){
				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice3();

				ClientConsole_ACHPayementEntry_Page.Payment_DATE3(Common_Class.getsystemdate());}

			Thread.sleep(2000);
			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent4()){
				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice4();

				ClientConsole_ACHPayementEntry_Page.Payment_DATE4(Common_Class.getsystemdate());}

			Thread.sleep(2000);
			if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent5()){
				ClientConsole_ACHPayementEntry_Page.click_CC_Invoice5();

				ClientConsole_ACHPayementEntry_Page.Payment_DATE5(Common_Class.getsystemdate());}
			ClientConsole_ACHPayementEntry_Page.click_new_account();

			if(ACH_types.contains("Business Savings"))
			{

				ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Business Savings");

			}
			else if(ACH_types.contains("Business Checking")) 
			{

				ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Business Checking");

			}
			else if(ACH_types.contains("Personal Savings"))
			{

				ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Personal Savings");

			}
			else if(ACH_types.contains("Personal Checking")) 
			{

				ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Personal Checking");
			}



			Thread.sleep(2000);
			ClientConsole_ACHPayementEntry_Page.click_new_account();

			ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Business Checking");
			ClientConsole_ACHPayementEntry_Page.Enter_Routing_Num(sd.get("Routing Number"));
			ClientConsole_ACHPayementEntry_Page.enter_new_account_num(sd.get("Bank Account Number"));
			ClientConsole_ACHPayementEntry_Page.Payment_AccountName(sd.get("Account_name"));
			Thread.sleep(500);
			ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESS(sd.get("address1"));
			ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESSLN2(sd.get("address2"));
			ClientConsole_ACHPayementEntry_Page.ADDRESS_city(sd.get("city"));
			ClientConsole_ACHPayementEntry_Page.ADDRESS_State(sd.get("State"));
			ClientConsole_ACHPayementEntry_Page.ADDRESS_Zip(sd.get("Postal Code"));
			ClientConsole_ACHPayementEntry_Page.click_Process_Payments();
			String Nach_conf=ClientConsole_ACHPayementEntry_Page.get_NachaconfMsg();
			System.out.println(Nach_conf);
			ClientConsole_ACHPayementEntry_Page.btnYes();

			String Payment_confNum=ClientConsole_login.confirmation_number();
			System.out.println( Payment_confNum);
			String getconfirmation =Payment_confNum.replaceAll("\\D","");
			return getconfirmation;

		} catch (InterruptedException e) {
			Log.errorHandler("Error occurred during initiate ACH payment series payment.",e);
			Common_Class_clientConsole.commonLink();
		}
		return ACH_types;


	}

	@Test
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



	@Test
	public void createACHPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException 
	{
		System.out.println("******************NOn mam Modify paymnet***************************");
		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA"))
		{
			throw new SkipException("No Non Mam Details Present");
		}
		try{

			Common_Class_clientConsole.ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment_Data","CONFIRMATION",conn);
		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making  non MAM ACH Payment.",e);
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

