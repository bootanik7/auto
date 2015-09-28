package V4.Regression.client_console.scripts;

import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;
import V4.Smoke.enrollment.applibs.Erm_Login_Page;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.testng.SkipException;

import V4.Regression.client_console.applibs.V4_CC_Payment;
import V4.Regression.client_console.applibs.helpers.HTMLHelper;
import V4.Regression.client_console.applibs.helpers.RuleHelper;
import V4.Regression.client_console.applibs.helpers.XMLHelper;
import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.otp.applibs.Baseclass_otp;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import V4.Smoke.otp.applibs.OTP_FundingInfo_Page;
import V4.Smoke.otp.applibs.OTP_Login_Page;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;
import core.libs.XML;
import core.webwidgets.StaticText;
import  org.w3c.dom.Document;
/**
 * @author tatyana
 *
 */
public class Regress_V4_CC_ACH_Payment {
	static Map<String, Connection> conn = null;
	public static Properties RuleProp;
	public static Properties PaymentProp;
	
	public static String  RulePropFile = Platform.getCurrentProjectPath() + "V4" +Platform.getFileSeparator() + "Rules.properties";
	public static String  PaymentPropFile = Platform.getCurrentProjectPath() + "V4" +Platform.getFileSeparator() + "Payment.properties";
	public static String PaymentTestDataFile = "Payment_testdata.xlsx";
	public static String ValidationXMLFile = "validation-paymententry.xml";
	int size = 0;

	/**
	 * @throws InterruptedException
	 * @throws Exception
	 * @throws SQLException
	 */
	@BeforeClass

	public   static void setUp() throws InterruptedException, Exception, SQLException {
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

			/*if (Test_login.i == 0)

			{
				Log.logScriptInfo("Login to the system");
				Common_Class_clientConsole.client_console_login(conn);
				Test_login.i = 1;
			}*/

		} catch (Exception e) {
			// Standard error handling routine
			Log.errorHandler("Error occurred during Test and verify Google About page Testcase.", e);
		}
	}

	/**
	 * @throws InterruptedException
	 * @throws SQLException
	 */

public static void loadProperties(){
	RuleProp = Log.loadFromFile(RulePropFile);
	PaymentProp= Log.loadFromFile(PaymentPropFile); 
}

	
	public static Map<String,String> loadTestData(String fieldName,String CheckType){
	
		String path = null;
		Map<String,String> test_data = null; 
		try{
			path = PaymentProp.getProperty("gsAutomationTestDataPath")+PaymentTestDataFile;
			test_data = Excel.getXlsRowDataAsMap(path,fieldName,CheckType);
			
		
		}
		catch (Exception e) {
			// Standard error handling routine
			Log.errorHandler("Error occurred during Test and verify Google About page Testcase.", e);
		}
		return test_data;
		
	}
	

	public static String getRuleNameByValidatePaymentEntryXML(String fieldName,String checkType){
		
		String xmlPath = null;
		String ruleName = null;
		try{
			xmlPath = PaymentProp.getProperty("gsAutomationValidationXMLPath")+ValidationXMLFile;
			ruleName = XMLHelper.getPaymentEntryRuleNameFromXML(xmlPath, fieldName, checkType);

		
		}
		catch (Exception e) {
			// Standard error handling routine
			Log.errorHandler("Error occurred during finding ruleName for field "+fieldName + " in XML file "+xmlPath, e);

		}
		return ruleName;
		
	}
	


	public static void createACHPaymentWithNonValidField(String MAMTYPE, String fieldName, String checkType,
			String invalidValue, String ruleName, int size, String sheetname, String testCases,
			Map<String, Connection> connection) throws ClassNotFoundException, SQLException, InterruptedException {
		
		try {
			Log.logScriptInfo("Load test data to PaymentDetail object for " + MAMTYPE + " biller");
			V4_CC_Payment paymentDetail = new V4_CC_Payment(MAMTYPE, size, sheetname, testCases, connection);

			
			Log.logScriptInfo("Clear previous field value for " + V4_CC_Payment.mappedBankDetails.get(fieldName));
			paymentDetail.Bankdetails.remove(V4_CC_Payment.mappedBankDetails.get(fieldName));
			
			Log.logScriptInfo("Enter new field value "+ invalidValue +" in the field " + V4_CC_Payment.mappedBankDetails.get(fieldName)); 
			paymentDetail.Bankdetails.put(V4_CC_Payment.mappedBankDetails.get(fieldName), invalidValue);
			
			
			Log.logScriptInfo("Navigate to Payment Entry Page");
			Common_Class_clientConsole.Paymnet_Entry(paymentDetail.accounts);

			Log.logScriptInfo("Trying to create Payment ");
			ClientConsole_ACHPayementEntry_Page.ACH_Payment_Entry_details(paymentDetail.Bankdetails,
					paymentDetail.ACH_types);

			Log.logScriptInfo("Check error message");
			Regress_V4_CC_ACH_Payment.verifyPaymentCanNotHappened(ruleName, paymentDetail, connection);

		} catch (Exception e) {
			Log.errorHandler("Error occurred during creating " + MAMTYPE + "  payment ", e);
		}

	}

	public static void verifyPaymentCanNotHappened(String RuleName, V4_CC_Payment paymentDetail,
			Map<String, Connection> connection) {

		if (Regress_V4_CC_ACH_Payment.verifyPageDispalyed("paymententry/submitBankPaymentEntry")) {
			if (Regress_V4_CC_ACH_Payment.isErrorMessagePresented(RuleName, paymentDetail, connection)){
				
				Log.logScriptInfo("Payment wasn't created! ");
			}
		} else
			Log.errorHandler("Payment Entry Page doesn't dispalay");
	}

	public static boolean verifyPageDispalyed(String sResultLink) {

		if (Browser.getURL().contains(sResultLink)) {

			Log.logScriptInfo("Verified URL: " + "\"" + sResultLink + "\"" + " is present in URL");
			return true;

		} else {
			Log.errorHandler(sResultLink + " doesn't display");
			return false;

		}
	}

	public static boolean isErrorMessagePresented(String RuleName, V4_CC_Payment paymentDetail,
			Map<String, Connection> connection) {
		Connection IAconnection = connection.get("IAconconnection");
		Boolean result = false;
		String pText = null;
	

		// Check warning <p> text
		String pTextError = HTMLHelper.getPtextByClassName("body-validation-error");

		if (pTextError == null) {

			// Check error <p> text
			String pTextHeader = HTMLHelper.getPtextByClassName("body-page-subheader");

			if (pTextHeader == null) {
				Log.errorHandler("No HTML elements with error text is presented!");
			} else {
				
				pText = pTextHeader;
			}

		} else {
			pText = pTextError;
		}

		
		
		
		
		if (pText != null) {
			Log.logScriptInfo("Page Message verification successful: '"+ pText  +"' error is presented on the Page ");

			Log.logScriptInfo("Select Rule Message text  for Business_id = " + paymentDetail.businessID + " for ruleName = "
					+ RuleName + " in IA DB  ");
			HashMap<String, String> errorRuleText = RuleHelper.GetRuleValueExactlyByRuleName(paymentDetail.businessID,
					RuleName, IAconnection);
			// if there are no rules for biller_id, let's check for Default biller_id
			if (errorRuleText == null) {
				Log.logScriptInfo("There are no rule values for biller_id, let's select  for Default biller_id = " + paymentDetail.DefaultBusinessID
						+ " for ruleName = " + RuleName + " in IA DB  ");
				errorRuleText = RuleHelper.GetRuleValueExactlyByRuleName(paymentDetail.DefaultBusinessID, RuleName,
						IAconnection);
				
			}

			if (errorRuleText == null) {

				Log.errorHandler(
						"No rule values for ruleName " + RuleName + " for in DB for " + paymentDetail.businessID
								+ " and for default business_id = " + paymentDetail.DefaultBusinessID);
			} else {
				Log.logScriptInfo("Rule message verification successful :  ruleName = "+ RuleName +" has value = "+errorRuleText);
				if (pText.contains(errorRuleText.get("ruleValue"))){
					Log.logScriptInfo("Page message '"+ pText +"' contains error text from rules in db "+errorRuleText.get("ruleValue"));
					result = true;
				}
				else{
					Log.errorHandler(
							"Page message '" +pText + "' doesn't contain the Message "+ errorRuleText.get("ruleValue"));
				}
				 
			}
		}

		return result;
	}
	
	public static void NoN_MaMLoginCC()
	{
		if(Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().contains("NA")){
			
			throw new SkipException("No Non MAM Details Present");
		}
		try {
			
		   List<String> list;
			
			Map<String, String>accountinfo=null;
			String URL = ";"
			String[] getmamdivdid = Common_Class.V4prop.get("NON_MAM_ACH_Types").toString().split(",");
			
			int first = 0;
			accountinfo=Common_Class.getaccinfo(conn);
			

			
				try
				{

					String[] getid=getmamdivdid[first].toString().split("-");

					Log.startTestCase("Started Executing Non MAM Login for "+getid[first]+" division business id ");

					String ID=getid[first];
					list=Common_Class.gen_num_acc_num(ID,conn);
					
					URL= Common_Class.V4prop.getProperty("clientConsolURL")+Common_Class.V4prop.getProperty("Business_id");
					Browser.start();
					Browser.loadURL(URL,Log.giAutomationShortTO);
					
					NonMAMDataEntry(ID, list.get(first), accountinfo, conn.get("IAconconnection"));
					
					
				
					

				} catch(Exception e)
				{
					Log.errorHandler("Error occurred during MAM LOGIN Testcase.",e);

					Browser.close();
				}
		
			
			
		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during MAM LOGIN Testcase.",e);
		}
	}
	

	public static void NonMAMDataEntry(String Division_business_id,String Account_num,Map<String, String>accountinfo,Connection connection) throws SQLException {
		String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and ROWNUM =1 order by ACTIVE_STATUS_DTM desc";
		
		getdata=Database_query_Manager.get_IA_LIVE_Business(query1,connection);

		String Division=getdata.get("PRIMARY_NAME");

		OTP_Login_Page.EnterAccountText(Account_num);

		if(Common_Class.V4prop.get("ZipCode").toString().contains("yes")) 
		{

			OTP_Login_Page.EnterAccountinfoText(accountinfo.get("BILLING_POSTAL_CODE"));

		} else if(Common_Class.V4prop.get("Division").toString().contains("yes"))

		{
			OTP_Login_Page.EnterAccountinfoText(Division_business_id);
		}
		else if(Common_Class.V4prop.get("Accountinfo").toString().contains("yes"))
		{
			OTP_Login_Page.EnterAccountinfoText(accountinfo.get("ACCOUNT_INFO_01"));
		}

		if(OTP_Login_Page.isAccountonf2present()){
			OTP_Login_Page.EnterAccountinfo2Text(accountinfo.get("ACCOUNT_INFO_02"));
		}
		 if(OTP_Login_Page.isdivisionpresent())
		{
			OTP_Login_Page.selectdivision(Division);
		}
		 if(Erm_Login_Page.iscontinepresent()){
				
			 Erm_Login_Page.click_on_contine();
		}
		else {
	    OTP_Login_Page.clickbutton();
		}
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
