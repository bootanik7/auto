package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_EPI_Page;
import V4.Smoke.enrollment.applibs.Erm_PayYourBillNow_RPI_Page;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class ERM_one_time_pay_ACH implements Erm_Common_Payment
{
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
		Baseclass_Erm.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Make ACH Payment testcase for MAM/NonMAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
	}	
    /*This method accepts testdata and executes one time payment and returns confirmation number
	/* (non-Javadoc)
	 * @see V4.Smoke.enrollment.scripts.Erm_Common_Payment#oneTimePayment(java.util.Map, java.lang.String)
	 */
	public String oneTimePayment(Map<String,String> Ed,String ACH_types) throws InterruptedException 
	{
		String getConfirmation = null;
		Erm_AccountSummary_Page.wait_drop_down();
		Erm_AccountSummary_Page.proceed_paymybill("Bank");
		Erm_PayYourBillNow_EPI_Page.Enter_payment_details(Ed, ACH_types);
		Erm_PayYourBillNow_RPI_Page.reviewpayemntinfo();
		String Payment_confNum = Baseclass_Erm.confirmation_number();
		getConfirmation = Payment_confNum.replaceAll("\\D", "");
		return getConfirmation;
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
	public void ACH_Payment_Mam() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Non Mam Details Present");
		}
		try{

			Baseclass_Erm.one_time_ExecutePayment("MAM_ACH_Types", size, this, "ACH_Payment", "CONFIRMATION",conn);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Making  MAM ACH one time Payment.",e);
		}
	}
	
	@Test
	public void ACH_Payment_Non_Mam() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().trim().contains("NA")) 
		{
			throw new SkipException("No Non Mam Details Present");
		}
		try{

			Baseclass_Erm.one_time_ExecutePayment("NON_MAM_ACH_Types", size, this, "ACH_Payment", "CONFIRMATION",conn);

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during Making Non MAM ACH one time Payment.",e);
		}
	}

	@Override
	public String makePayment(Map<String, String> sd, String ACH_types)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}




}
