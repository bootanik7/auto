package V4.Regression.client_console.scripts;

import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.testng.SkipException;

import V4.Regression.client_console.applibs.V4_CC_Payment;
import V4.Regression.client_console.applibs.helpers.HTMLHelper;
import V4.Regression.client_console.applibs.helpers.RuleHelper;
import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;
import core.webwidgets.StaticText;

/**
 * @author tatyana
 *
 */
public class Regress_V4_CC_ACH_PaymentAccountAddressesTestCase {
	static Map<String, Connection> conn = null;
	static Map<String, String> testData = null;
	// fieldName must exist in V4_CC_Payment.mapRecord
	static String fieldName = "bankAccount.accountAddress1";
	
	// use ruleName and checkType when you are checking message text for Payment Entry Page
		//(all rule names are in  validate_paymententry.xml)
		static String ruleName = null;
		static String checkType = null;
		static String testDataExcellSheet = "ACH_Payment_Data";
	int size = 0;

	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
	@BeforeClass

	public static void setUp() throws InterruptedException, Exception, SQLException {
		try {
			Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();
			Log.gsScriptDescription = "Test Verifies payment can not be happened without mandatory valid field values.";
			Log.gsScriptAuthor = "Tatyana Zhirnova";
			Log.gsScriptTestArea = FileIO.getParentPath(
					Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".", Platform.getFileSeparator())); 

			Log.initialize();
			Log.logBanner("Negotive scenarious for creating Payment testcase for MAM/NonMAM");

			
			
			Common_Class_clientConsole.set_test_data_path();
			
			Common_Class.loadDBproperties();
			Regress_V4_CC_ACH_Payment.loadProperties();
		
			conn = Common_Class.connectDB();
		
			
			
			if (Test_login.i == 0)

			{
				Log.logScriptInfo("Login to the system");
				Common_Class_clientConsole.client_console_login(conn);
				Test_login.i = 1;
			}
			
			

		} catch (Exception e) {
			// Standard error handling routine
			Log.errorHandler("Error occurred during Test and verify Google About page Testcase.", e);
		}
	}

	/**
	 * @throws InterruptedException
	 * @throws SQLException
	 */



	 /*Routing number verification
	
	//No MAM
	
	
	/*  @Test
	  public void createPaymentWithNoRoutingNumber_NoMAM() throws
	  ClassNotFoundException, SQLException, InterruptedException {
	  
			// Check rule value in DB "message.routing_number_pattern.invalid" and Warning message on the Page "Routing number is Invalid"
			
			Log.startTestCase(
					"Verify payment can not be happened with empty mandatory Routing Number field value for NON MAM biller  ");
			Regress_V4_CC_ACH_Payment.createACHPaymentWithNonValidField("NON_MAM_ACH_Types", "routing_number", "invalid", "", size, "ACH_Payment_Data",
					"Na", conn);
	  
	  }
	  
	 */
	
	// MAM 
	
	/*
	@Test
	public void createPaymentWithoutAccountAddress1_MAM()
			throws ClassNotFoundException, SQLException, InterruptedException {
		checkType = "validwhen"; // empty address1
		Log.logScriptInfo("Load test data for negative scenario for Create Payment : fieldName = "+fieldName+" , checkType= "+checkType);
		testData = Regress_V4_CC_ACH_Payment.loadTestData(fieldName, checkType);
		
		Log.logScriptInfo("Get rule name from "+ Regress_V4_CC_ACH_Payment.ValidationXMLFile+" for checking Error Message text on the Payment Entry Page");
		ruleName = Regress_V4_CC_ACH_Payment.getRuleNameByValidatePaymentEntryXML(fieldName, checkType);
				
		
		
		Log.startTestCase(
				"Verify payment can not be happened without inserting mandatory Bank Account Address 1 field value. ( '"+checkType+"' )");
		
		Regress_V4_CC_ACH_Payment.createACHPaymentWithNonValidField("MAM_ACH_Types", fieldName, checkType, testData.get("Data"), ruleName, size, testDataExcellSheet,
				"Na", conn);
		
	
		
	}

	*/
	
	@Test
	public void createPaymentWithNonValidAccountAddress1_MAM()
			throws ClassNotFoundException, SQLException, InterruptedException {
		checkType = "mask"; 
		// empty address1
		Log.logScriptInfo("Load test data for negative scenario for Create Payment: fieldName = "+fieldName+" , checkType= "+checkType );
		testData = Regress_V4_CC_ACH_Payment.loadTestData(fieldName, checkType);
		
		Log.logScriptInfo("Get rule name from "+ Regress_V4_CC_ACH_Payment.ValidationXMLFile+" for checking Error Message text on the Payment Entry Page ");
		ruleName = Regress_V4_CC_ACH_Payment.getRuleNameByValidatePaymentEntryXML(fieldName, checkType);
					
		
		Log.startTestCase(
				"Verify payment can not be happened with invalid Bank Account Address 1 field value. ( '"+checkType+"' )");
		
		Regress_V4_CC_ACH_Payment.createACHPaymentWithNonValidField("MAM_ACH_Types", fieldName, checkType, testData.get("Data"), ruleName, size, testDataExcellSheet,
				"Na", conn);
		
	
		
	}


	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and
	 * terminates the automation
	 * <p>
	 * 
	 * @author Tatyana Zhirnova
	 */
	public static void tearDown() throws Exception {
		Common_Class.closedbconnection(conn);
		Common_Class.terminate();
		Log.terminate();

	}
}
