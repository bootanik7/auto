package V4.Smoke.enrollment.scripts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import V4.Smoke.enrollment.applibs.Baseclass_Erm;
import V4.Smoke.enrollment.applibs.Erm_AccountSummary_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePersonal_IP_Email_CNF_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePersonal_IP_Email_Page;
import V4.Smoke.enrollment.applibs.Erm_ManagePersonal_IP_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

/**
 * @author raonag
 *
 */
public class Test_Erm_ModifyEmail
{

	static Map<String,Connection> conn=null;

	 /**
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass 
	 public static void setUp() throws InterruptedException, ClassNotFoundException, SQLException
		{
			Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
			Log.gsScriptDescription = "Tests Making Add Bank Account from MAM";
			Log.gsScriptAuthor = "Nagabhushana Rao";
			Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator()));
			Baseclass_Erm.set_test_data_path();
			Log.initialize();
			Log.logBanner("Setup for Make Add Bank Account testcase for MAM");
			
			Common_Class.loadDBproperties();
			
			 conn = Common_Class.connectDB();
			
			if(Test_Login.i==0)
			{
				Baseclass_Erm.Erm_login(conn);
				Test_Login.i=1;
			}

		}


	 /**
	 * @param Ed
	 * @throws InterruptedException
	 */
	    public void Erm_ModifyEmail_Test(Map<String,String> Ed) throws InterruptedException
	    {
		    try
		    {
			Erm_AccountSummary_Page.click_on_MngPersonalInfo();
			Erm_ManagePersonal_IP_Page.click_on_EmailAddress();
			Erm_ManagePersonal_IP_Email_Page.modify_email(Ed);
			System.out.println(Erm_ManagePersonal_IP_Email_CNF_Page.get_Erm_Welcome_text());
			Baseclass_Erm.Common_Link();
		    }
		    catch(Exception e)
		    {
		     Baseclass_Erm.Common_Link();
		    }
	    }
	   /**
	 * @throws InterruptedException
	 */
	@Test()
	   public void modify_email_details() throws InterruptedException
	   {
		   int i=1;
			Map<String,String> getdetails=Excel.getXlsRowDataAsMap("Erm_testdata.xls","Modify_Mail",Integer.toString(i));
		    Erm_ModifyEmail_Test(getdetails);
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
