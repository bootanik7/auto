package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_CNF_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_Card_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_Debit_Card_EPI_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_RPI_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;


/**
 * @author raonag
 *
 */
public class Test_Erm_DC_Payment implements Erm_Common_Payment
{
	static Map<String,Connection> conn=null;
	String getConfirmation;
	int size=0;
	/**
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setup() throws InterruptedException, ClassNotFoundException, SQLException
	{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();
		Log.gsScriptDescription = "Tests Making Debit Card Payments from MAM/Non MAM";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Baseclass_Erm.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Making  Debit Card Payment testcase for MAM/NonMAM");

		Common_Class.loadDBproperties();

		conn=Common_Class.connectDB();
		if(Test_Login.i==0)
		{
			Baseclass_Erm.Erm_login(conn);
			Test_Login.i=1;
		}

	}


	/** This method Enter payment details for DebitCard
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public String  makePayment(Map<String,String> Ed,String DC_Types) throws InterruptedException
	{
		try
		{
			Erm_AccountSummary_Page.collectlistitems();
			Erm_AccountSummary_Page.proceed_paymybill("Card");
			Erm_PayYourBillNow_Card_Page.Provide_CardNum(Ed);
			Erm_PayYourBillNow_Debit_Card_EPI_Page.Enter_DC_payment_details(Ed);
			Erm_PayYourBillNow_RPI_Page.reviewpayemntinfo();
			String Payment_confNum = Baseclass_Erm.confirmation_number();
			getConfirmation = Payment_confNum.replaceAll("\\D", "");
			Baseclass_Erm.Common_Link();
		}
		catch(Exception e)
		{
			Baseclass_Erm.Common_Link();
		}
		return getConfirmation;
	}
	/**
	 * This Test case executes the Making a DebitCard payment for  MAM Account with valid details
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */

	@Test
	public void create_DC_Payment_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{

		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Debit"))
			{

				if(Common_Class.V4prop.get("MAM_CC_Types").toString().trim().contains("NA")) 
				{

					throw new SkipException("No Mam Details Present");
				}
				Baseclass_Erm.ExecutePayment("MAM_CC_Types", size, this, "DebitCard_Payment", "CONFIRMATION",conn);
			}

		}catch(Exception e) 
		{
			Log.errorHandler("Error occurred during Making MAM DC Payment.",e);
		}
	}

	/**
	 * This Test case executes the Making a DebitCard payment for Non MAM Account with valid details
	 * <p>
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */

	@Test
	public void Create_DBPayment_Non_MAM() throws ClassNotFoundException, SQLException, InterruptedException
	{   
		try
		{
			if(Common_Class.V4prop.get("Funding_Type").toString().contains("Debit")){

				if(Common_Class.V4prop.get("NON_MAM_CC_Types").toString().trim().contains("NA")) 
				{
					throw new SkipException("No Mam Details Present");
				}
				Baseclass_Erm.ExecutePayment("NON_MAM_CC_Types", size, this, "DebitCard_Payment", "CONFIRMATION",conn);
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
	 * @author  Nagabhushana Rao 
	 */
	public static void tearDown() throws Exception 
	{
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();

	}

	@Override
	public String oneTimePayment(Map<String, String> sd, String ACH_types)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
