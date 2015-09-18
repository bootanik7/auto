package V4.Smoke.otp.scripts;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.SkipException;

import V4.Smoke.otp.applibs.Baseclass_otp;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.OTP_FundingInfo_Page;
import core.libs.Browser;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * The OTP_Login script executes Login function and verifies the username in OTP Homepage
 * <P>
 */
public class Login_OTP_script{
	int size=0;
	static Map<String,Connection>connection=null;

	@BeforeClass
	/**
	 * Initializes the automation for testing.
	 * <P>
	 * @throws throws an Exception if an error occurs during the setup portion of the script
	 */
	public static void setUp() throws Exception 
	{
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Login to OTP Applciation and verify the Homepage";
		Log.gsScriptAuthor = "Parvat Patil";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
		Baseclass_otp.set_test_data_path();
		Log.initialize();
		Log.logBanner("Setup for OTP Login Testcases");
		Common_Class.loadDBproperties();
		connection=Common_Class.connectDB();
	}

	/**
	 * These testcases execute Login Functionality for MAM  accounts
	 * <p>
	 * 
	 */
	@Test
	public void MAMLoginOTP()
	{
		if(!Common_Class.V4prop.get("MAM_ACH_Types").toString().contains("NA")){

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

					Baseclass_otp.otplogin(ID,getid.length,connection);

					String Accountinfotext=OTP_FundingInfo_Page.accNumVisibleText();

					Common_Class.altVerify(Baseclass_otp.AccountNumber, Accountinfotext, true);


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

	}


	/**
	 * These testcases execute Login Functionality for Non MAM  accounts
	 * <p>
	 * 
	 */
	@Test
	public void NoN_MaMLoginOTP()
	{
		if(!Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().contains("NA")){

			
		try {

			List<String> list;

			size=0;

			Map<String, String>accountinfo=null;

			String[] getmamdivdid = Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().split(",");

			accountinfo=Common_Class.getaccinfo(connection);


			for(int i=0;i<=getmamdivdid.length-1;i++)
			{
				try
				{

					String[] getid=getmamdivdid[i].toString().split("-");

					Log.startTestCase("Started Executing Non MAM Login for "+getid[0]+" division business id ");

					String ID=getid[0];
					list=Common_Class.gen_num_acc_num(ID,connection);

					Baseclass_otp.getNonMamaccount(ID,list.get(i),accountinfo,connection);

					String Accountinfotext=OTP_FundingInfo_Page.accNumVisibleText();

					Common_Class.altVerify(list.get(i), Accountinfotext, true);

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
			Log.errorHandler("Error occurred during MAM LOGIN Testcase.",e);
		}
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

		Common_Class.closedbconnection(connection);

		Common_Class.terminate();

	}

}







