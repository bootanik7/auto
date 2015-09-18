package V4.Smoke.enrollment.applibs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import V4.Smoke.enrollment.scripts.Erm_Common_Payment;
import V4.Smoke.otp.applibs.Baseclass_otp;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

/**
 * @author raonag
 *
 */
public class Baseclass_Erm 
{
	public static String AccountNumber,Accountinfo1,Division,ZipCode,Accountinfo2;
	public static Map<String,String>getenrolcredentials=null;
	static String URL;
	static String getConfirmation;
	static Map<String, String>getdata;
	static List< Map<String, String>> billerRecords;
	static Map<String, Integer> accountIndex = new HashMap<String, Integer>();

	/**This method executes the login for enrolled customer
	 * @param getconn
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	public static void Erm_login(Map<String,Connection>getconn) throws InterruptedException, SQLException
	{
		Browser.start();
		URL=Common_Class.V4prop.getProperty("Enrweburl")+Common_Class.V4prop.getProperty("Business_id");
		Browser.loadURL(URL,Log.giAutomationShortTO);

		String Update="update sp_identity set PASSWORD_EXPIRY_DT='31-DEC-2020' where business_id='"+Common_Class.V4prop.getProperty("Business_id")+"' and product_id='1318'and TO_date(UPDATE_DTM) =(select TO_date(max(UPDATE_DTM)) from sp_identity where business_id='"+Common_Class.V4prop.getProperty("Business_id")+"' and product_id='1318')";
		Database_query_Manager.updateDB(Update,getconn.get("D2connection"));

		String query="select Login,Password From sp_identity_en where business_id='"+Common_Class.V4prop.getProperty("Business_id")+"' and product_id='1318' and TO_date(UPDATE_DTM) =(select TO_date(max(UPDATE_DTM)) from sp_identity_en where business_id='"+Common_Class.V4prop.getProperty("Business_id")+"'and product_id='1318' and Login in(select username from cp_consumer_profile where CONSUMER_PROFILE_STATUS_ID=1))";
		getenrolcredentials=Database_query_Manager.getenrollcedentials(query, getconn.get("D2connection"));
		Erm_Login_Page.Login(getenrolcredentials.get("LOGIN"),getenrolcredentials.get("PASSWORD"));	
	}

	/**This Method executes the login functionality for one time login for mam
	 * @param Division_business_id
	 * @param rowcount
	 * @param connection
	 * @throws SQLException
	 */
	public static void ERM_Onetime_login(String Division_business_id,int rowcount,Map<String,Connection>connection ) throws SQLException 
	{
		URL=Common_Class.V4prop.getProperty("Enrweburl").toString()+Common_Class.V4prop.getProperty("Business_id");
		Browser.start();
		Browser.loadURL(URL,Log.giAutomationWaitTO);
		Baseclass_otp.onetimepaylogin(Division_business_id, rowcount, connection);
	}

	/**This Functionality executesthe login functionality of one time login for non mam
	 * @param Division_business_id
	 * @param Account_num
	 * @param accountinfo
	 * @param connection
	 * @throws SQLException
	 */
	public static void ERM_onetime_Nonmam_login(String Division_business_id,String Account_num,Map<String, String>accountinfo,Map<String,Connection>connection) throws SQLException 
	{
		URL=Common_Class.V4prop.getProperty("Enrweburl").toString()+Common_Class.V4prop.getProperty("Business_id");
		Browser.start();
		Browser.loadURL(URL,Log.giAutomationWaitTO);
		Baseclass_otp.nonmamdata(Division_business_id, Account_num, accountinfo, connection);
	}


	/**This function clicks on the Account summary link all the time for a common point 
	 * 
	 */
	public static void Common_Link() 
	{
		Erm_AccountSummary_Page.clilk_on_AcntSumry();
	}
	/**This Method executes the logout functionality of the Enrollment
	 * 
	 */
	public static void Common_logout()
	{
		Erm_AccountSummary_Page.click_on_logout();
	}

	/**This Method sets the test datapath
	 * 
	 */
	public static  void set_test_data_path()
	{
		String FilePath=""+Platform.getUserHome() + Platform.getFileSeparator()+"//automation.properties";

		String Testdata=""+ Platform.getCurrentProjectPath().replace("\\","//")+"//V4//Smoke//enrollment//testdata//";

		FileIO.updatePropertyFile(FilePath, "gsAutomationAutoSupportDocs", Testdata);
	}

	/**This Method executes the payment for ACH/CC/DC 
	 * @param MAMTYPE
	 * @param size
	 * @param Payment
	 * @param sheetname
	 * @param testCases
	 * @param connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void ExecutePayment(String MAMTYPE, int size, Erm_Common_Payment Payment,String sheetname, String testCases,Map<String,Connection> connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
		try 
		{
			String Accnum;
			String Type = null;
			Boolean cancelModiCase = Boolean.FALSE;
			List<String> accountNumbers = null;
			String[]ACH_types= Common_Class.V4prop.get(MAMTYPE).toString().trim().split(",");//get the MAMtype

			for(int P=0;P<=ACH_types.length-1;P++)// iterate the business ids to get business id
			{
				int index=0;
				String[] splittpye=ACH_types[P].split("-");

				if(splittpye.length==1)
				{    
					if(MAMTYPE.contains("NON_MAM_ACH_Types")||MAMTYPE.contains("MAM_ACH_Types"))
					{
						Type=Common_Class.V4prop.getProperty("ACH_APP_Level").toString().trim();
					}
					else 
					{
						Type=Common_Class.V4prop.getProperty("CC_APP_Level").toString().trim();
					}
				}

				else 
				{
					Type=splittpye[1];

				}

				String[] getach=Common_Class.V4prop.get(Type).toString().trim().split(",");

				String ID=splittpye[0];

				if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types")){

					accountNumbers=Common_Class.gen_num_acc_num(ID,connection);

				}
				else {

					accountNumbers=Common_Class.getMAMaccountnumbers(ID, getach.length, connection);
				}

				for(int i=0;i<=getach.length-1;i++) 
				{

					Log.startTestCase("Execute "+MAMTYPE+" Testcase for Making a payment for "+splittpye[0]+" with "+getach[i].trim()+"  ");	

					Map<String,String> Bankdetails = Excel.getXlsRowDataAsMap("Erm_testdata.xls", ""+sheetname+"", getach[i]);

					try 
					{
						if(index>=accountNumbers.size()){

							int k=i-1;

							Accnum=accountNumbers.get(k);
						}
						else {
							Accnum=accountNumbers.get(i);
						}
						update_account_number(ID, getenrolcredentials.get("LOGIN"), connection, Accnum);
						getConfirmation= Payment.makePayment(Bankdetails,getach[i]);
						if(testCases.equalsIgnoreCase("CONFIRMATION"))
						{
							testConfirmation(getConfirmation,connection);
						}
						else
						{
							cancelModiCase = Boolean.TRUE;
							break;
						}
						index++;
					}catch(Exception e) 
					{
						Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);
						Common_Link();
					}
				} 
				if(cancelModiCase)
				{
					break;
				}
			}
		}catch(Exception e){
			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);
		}
	}
	/**This method compares the test results
	 * @param map
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void testConfirmation(String getConfirmation,Map<String,Connection>connection) throws ClassNotFoundException, SQLException
	{
		Map<String,String>map=null;
		if(getConfirmation!=null)
		{
			String confirmation="select * from cp_payment where CONFIRMATION_NUMBER ="+getConfirmation+"";

			map=Database_query_Manager.get_cp_payment(confirmation,connection.get("D2connection"));

			if(confirmation!=null)
			{
				Common_Class.altVerify(map.get("CONFIRMATION_NUMBER"), getConfirmation, true);

				String Updatequery="update cp_payment set payment_status_id = 8 where confirmation_number ="+map.get("CONFIRMATION_NUMBER")+"";

				Database_query_Manager.updateDB(Updatequery, connection.get("D2connection"));
			}
		}
	}

	/**This method returns the confirmation number
	 * @return
	 */
	public static String confirmation_number() 
	{
		String text = null;
		List<WebElement> list= SeleniumCore.driver.findElements(By.tagName("tr"));
		for(WebElement test:list)
		{
			if(test.getText().contains("Confirmation Number"))
			{
				text=test.getText();
			}
		}

		return text;
	}


	/**This Method executes the database statements to update the Cp_billing account table
	 * @param Division_business_id
	 * @param username
	 * @param connection
	 * @param Account_number
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update_account_number(String Division_business_id,String username,Map<String,Connection>connection,String Account_number) throws ClassNotFoundException, SQLException {

		Map<String, String>getdata;
		String getprofileid="select * from cp_consumer_profile where business_id ='"+Common_Class.V4prop.getProperty("Business_id")+"' and USERNAME like '%"+username+"%'";
		getdata= Database_query_Manager.getprofileid(getprofileid,connection.get("D2connection"));


		String updatebilling_acct_status="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =2,BILLING_ACCOUNT_NUMBER= '"+Account_number+"' where CONSUMER_PROFILE_ID = "+getdata.get("CONSUMER_PROFILE_ID")+"";
		Database_query_Manager.updateDB(updatebilling_acct_status,connection.get("D2connection"));

		String updateAccountnumber="update CP_Billing_Account set BILLING_ACCOUNT_STATUS_ID =1,DIVISION_BUSINESS_ID = "+Division_business_id+" where CONSUMER_PROFILE_ID =  "+getdata.get("CONSUMER_PROFILE_ID")+" and Rownum=1";
		Database_query_Manager.updateDB(updateAccountnumber,connection.get("D2connection"));
	}



	/** This Method executes the one_time_payment test cases{On Demand Payments}
	 * @param MAMTYPE
	 * @param size
	 * @param payment
	 * @param sheetname
	 * @param testCases
	 * @param connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void one_time_ExecutePayment(String MAMTYPE, int size, Erm_Common_Payment payment,  String sheetname, String testCases,Map<String,Connection> connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
		try 
		{  
			String Type = null;
			Boolean cancelModiCase = Boolean.FALSE;
			List<String> accountNumbers = null;
			Map<String, String>accountinfo=null;
			String[]ACH_types= Common_Class.V4prop.get(MAMTYPE).toString().trim().split(",");//get the MAMtype

			for(int P=0;P<=ACH_types.length-1;P++)// iterate the business ids to get business id
			{

				String[] splittpye=ACH_types[P].split("-");

				if(splittpye.length==1)
				{    
					if(MAMTYPE.contains("NON_MAM_ACH_Types")||MAMTYPE.contains("MAM_ACH_Types")){

						Type=Common_Class.V4prop.getProperty("ACH_APP_Level").toString().trim();
					}
					else {
						Type=Common_Class.V4prop.getProperty("CC_APP_Level").toString().trim();
					}
				}
				else {
					Type=splittpye[1];
				}

				String[] getach=Common_Class.V4prop.get(Type).toString().trim().split(",");

				String ID=splittpye[0];

				if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types")){

					Common_Class.getaccinfo(connection);

					accountNumbers=Common_Class.gen_num_acc_num(ID,connection);
				}

				for(int i=0;i<=getach.length-1;i++) 
				{
					Log.startTestCase("Execute "+MAMTYPE+" Testcase for Making a payment for "+splittpye[0]+" with "+getach[i].trim()+"  ");	

					Map<String,String> Bankdetails = Excel.getXlsRowDataAsMap("Erm_testdata.xls", ""+sheetname+"", getach[i]);
					try 
					{

						if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types"))
						{
							accountinfo=Common_Class.getaccinfo(connection);

							ERM_onetime_Nonmam_login(ID,accountNumbers.get(i),accountinfo,connection);

						} else 
						{
							ERM_Onetime_login(ID,getach.length,connection);
						}

						getConfirmation=payment.oneTimePayment(Bankdetails,getach[i]);

						if(testCases.equalsIgnoreCase("CONFIRMATION"))
						{
							testConfirmation(getConfirmation,connection);
						}
						else
						{
							cancelModiCase = Boolean.TRUE;
							break;

						}

						if(size<=getach.length)
						{
							Browser.close();
						}
					}catch(Exception e) 
					{
						Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);

						Browser.close();
					}

				} 
				if(cancelModiCase)
				{
					break;
				}

			}
		}catch(Exception e){
			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);

		}

	}




}