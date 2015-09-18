package V4.Smoke.client_console.scripts;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import V4.Smoke.otp.applibs.Baseclass_otp;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.OTP_FundingInfo_Page;
import core.libs.Browser;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

public class ClientConsole_login {
	static Map<String,Connection> conn=null;
	int size=0;
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	@BeforeClass
	public static void cc_Run() throws ClassNotFoundException, SQLException{


		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Test and verify Clientconsole Login Page";
		Log.gsScriptAuthor = "archana enturu";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
		Common_Class_clientConsole.set_test_data_path();
		Log.initialize();
		Common_Class.loadDBproperties();
		conn=Common_Class.connectDB();
		Log.logBanner("Setup for Login For ClientConsole page");
		
	}
/**
 * 
 */
@Test
public void MAMLoginCC()
{
	if(Common_Class.V4prop.get("MAM_ACH_Types").toString().contains("NA")){
		
		throw new SkipException("No MAM Details Present");
	}
	try {
		    Common_Class_clientConsole.client_console_login(conn);
	        Browser.close();
		
	}catch(Exception e)
	{
		Log.errorHandler("Error occurred during MAM LOGIN Testcase .",e);
	}

}

/**
 * 
 */
@Test
public void NoN_MaMLoginCC()
{
	if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().contains("NA")){
		
		throw new SkipException("No Non MAM Details Present");
	}
	try {
		
	   List<String> list;
		size=0;
		Map<String, String>accountinfo=null;
	
		String[] getmamdivdid = Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().split(",");
		
		
		accountinfo=Common_Class.getaccinfo(conn);
				

		for(int i=0;i<=getmamdivdid.length-1;i++)
		{
			try
			{

				String[] getid=getmamdivdid[i].toString().split("-");

				Log.startTestCase("Started Executing Non MAM Login for "+getid[0]+" division business id ");

				String ID=getid[0];
				list=Common_Class.gen_num_acc_num(ID,conn);
				
				Baseclass_otp.getNonMamaccount(ID,list.get(i),accountinfo,conn);

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


public static String confirmation_number() {
	String text = null;

	
	List<WebElement> list= SeleniumCore.driver.findElements(By.tagName("tr"));
	for(WebElement test:list){
		if(test.getText().contains("Confirmation Number:")){
			System.out.println("print the value....."+test.getText());
			text=test.getText();
			
        }

	}

	return text;
}
}







