package V4.Smoke.enrollment.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.Browser;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;


/**
 * @author raonag
 *
 */
public class Test_Erm_OneTime_Payment
{
	static Map<String,Connection> conn=null;
	static String URL;
	int size=0;

	/**
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass 
	public static void setUp() throws InterruptedException, ClassNotFoundException, SQLException
	{

		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Tests Making for  One time login from MAM";
		Log.gsScriptAuthor = "Nagabhushana Rao";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Baseclass_Erm.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for Make for One time login testcase for MAM");
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();

	}

	public static void Erm_OneTime_Payment_test(Map<String,String> Ed) throws InterruptedException
	{
		/*  Browser.start();
		   URL=Common_Class.V4prop.getProperty("Enrweburl")+Common_Class.V4prop.getProperty("Business_id");
		   Browser.loadURL(URL,Log.giAutomationShortTO);

		   Erm_Login_Page.OneTimeLogin_Details(Ed);
		   Erm_AccountSummary_Page.click_AccountSummary_FndingAcnt("New Bank");
		   Erm_PayYourBillNow_Card_Page.click_on_Continue();

		   Erm_PayYourBillNow_EPI_Page.click_Erm_Invoice1();
		   Erm_PayYourBillNow_EPI_Page.click_on_Continue();
		   Erm_PayYourBillNow_EPI_Page.btnYes();

		   Erm_PayYourBillNow_RPI_Page.click_on_termandcondt();
		   Erm_PayYourBillNow_EPI_Page.click_on_Continue();*/



	}
	/**
	 * @throws InterruptedException
	 */

	@Test
	public void MAMLoginOTP()
	{
		if(Common_Class.V4prop.get("MAM_ACH_Types").toString().contains("NA")){

			throw new SkipException("No MAM Details Present");
		}
		try {

			size=0;		

			String[] getmamdivdid = Common_Class.V4prop.get("MAM_ACH_Types").toString().trim().split(",");

			for(int i=0;i<=getmamdivdid.length-1;i++) 
			{

				try

				{
					String[] getid=getmamdivdid[i].toString().split("-");

					Log.startTestCase("Started Executing MAM Login for "+getid[0]+" division business id ");

					String ID=getid[0];

					Baseclass_Erm.ERM_Onetime_login(ID,getid.length,conn);

					//String Accountinfotext=OTP_FundingInfo_Page.accNumVisibleText();

					//	Common_Class.altVerify(Baseclass_otp.AccountNumber, Accountinfotext, true);


				} catch(Exception e)
				{

					Log.errorHandler("Error occurred during MAM LOGIN Testcase.",e);

					Browser.close();
				}

			}
			if(size<=getmamdivdid.length)
			{
				Browser.close();
			}

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during MAM LOGIN Testcase .",e);
		}

	}
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Nagabhushana Rao
	 */

	public static void tearDown() throws Exception 
	{
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();
	}

}












