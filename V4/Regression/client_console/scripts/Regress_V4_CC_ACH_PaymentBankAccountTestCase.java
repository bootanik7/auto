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
public class Regress_V4_CC_ACH_PaymentBankAccountTestCase {
	static Map<String, Connection> conn = null;
	// fieldName must exist in V4_CC_Payment.mapRecord
	static String fieldName = "bankAccount.bankAccountNumber";
	
	// use ruleName and checkType when you are checking message text for Payment Entry Page
	//(all rule names are in  validate_paymententry.xml)
	static String ruleName = null;
	static String checkType = null;
	
	static String testDataExcellSheet = "ACH_Payment_Data";
	static Map<String,String> testData = null; 
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
			conn = Common_Class.connectDB();

			//String date = Common_Class.getsystemdate();

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



	
	/*Bank account number verification*/
	
	/*MAM*/
	@Test
	public void createPaymentWithoutBankAccountNumber_MAM()
			throws ClassNotFoundException, SQLException, InterruptedException {

		checkType = "required";
		
		Log.logScriptInfo("Load test data for negative scenario for Create Payment");
		testData = Regress_V4_CC_ACH_Payment.loadTestData(fieldName, checkType);
		
		
		Log.logScriptInfo("Get rule name from "+ Regress_V4_CC_ACH_Payment.ValidationXMLFile+" for checking Error Message text on the Payment Entry Page");
		ruleName = Regress_V4_CC_ACH_Payment.getRuleNameByValidatePaymentEntryXML(fieldName, checkType);
		
		
		Log.startTestCase(
				"Verify payment can not be happened without inserting mandatory bank_account_number  field value ('' string , requared checking) for MAM biller requared NULL");
		
		Regress_V4_CC_ACH_Payment.createACHPaymentWithNonValidField("MAM_ACH_Types", fieldName, checkType, testData.get("Data"), ruleName, size, testDataExcellSheet,
				"Na", conn);
		
		
		
	
		
	}
	
	@Test
	public void createPaymentWithNonValidBankAccountNumber_MAM()
			throws ClassNotFoundException, SQLException, InterruptedException {

		
		
		
		
		Log.logScriptInfo("Load test data for negative scenario for Create Payment: fieldName = "+fieldName+" , checkType= "+checkType );
		testData = Regress_V4_CC_ACH_Payment.loadTestData(fieldName, "bankaccountpattern");
		
		/*
		Log.logScriptInfo("Get rule name from "+ Regress_V4_CC_ACH_Payment.ValidationXMLFile+" for checking Error Message text on the Payment Entry Page");
		ruleName = Regress_V4_CC_ACH_Payment.getRuleNameByValidatePaymentEntryXML(fieldName, "mask");
		*/
		// don't know why there is another handle rule for mask verification "message.bank_account_number_pattern.invalid" instead of errors.bank_account_number.mask
				// Check rule value in DB "message.bank_account_number_pattern.invalid"  and Error message on the Page "DDA contains invalid characters."	
		ruleName = "message.bank_account_number_pattern.invalid";		
		
		Log.startTestCase(
				"Verify payment can not be happened without inserting valid bank_account_number field value for MAM biller mask 'ghg' ");
		
		Regress_V4_CC_ACH_Payment.createACHPaymentWithNonValidField("MAM_ACH_Types", fieldName, "bankaccountpattern", testData.get("Data"), ruleName, size, testDataExcellSheet,
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
