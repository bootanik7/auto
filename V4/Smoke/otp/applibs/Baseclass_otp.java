package V4.Smoke.otp.applibs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import V4.Smoke.enrollment.applibs.Erm_Login_Page;
import V4.Smoke.otp.scripts.CommonPayment;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;

public class Baseclass_otp {
	
	public static String AccountNumber,Accountinfo1,Division,ZipCode,Accountinfo2;
	static Map<String, String>getdata;
	static Map<String, Integer> accountIndex = new HashMap<String, Integer>();
	static List< Map<String, String>> billerRecords=null;
	static String URL;

	/** This Method Executes login functionality of OTP full host for MAM Account. Takes the below parameters
	 * @param Division_business_id
	 * @param rowcount
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	/*public static void otplogin(String Division_business_id,int rowcount,Map<String,Connection>connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
	  try {
			
			URL=Common_Class.V4prop.getProperty("OTP_Fullhost").toString()+Common_Class.V4prop.getProperty("Business_id");

			String query="select * from RTDS_MAM_"+Common_Class.V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+Division_business_id+" and ALLOW_COLLECTPAY_PAYMENTS_FLAG ='Y' and ROWNUM <="+rowcount+"";

			if(accountIndex.get(Division_business_id) == null)
			{
				billerRecords=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));
				accountIndex.put(billerRecords.get(0).get("DIVISION_BUSINESS_ID"), 0);
				getdata = billerRecords.get(0);
			}
			else
			{
				Integer recIndex = accountIndex.get(Division_business_id);
				recIndex = recIndex + 1;
				if(recIndex >= billerRecords.size())
				{
					recIndex = 0;
				}
				getdata = billerRecords.get(recIndex);
				accountIndex.put(Division_business_id, recIndex);
			}

			AccountNumber=getdata.get("ACCOUNT_NUMBER");

			Accountinfo1=getdata.get("ACCOUNT_INFO_01");

			Accountinfo2=getdata.get("ACCOUNT_INFO_02");

			ZipCode=getdata.get("BILLING_POSTAL_CODE");

			String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and TO_DATE(PROMOTED_DTM) = (select TO_DATE(max(PROMOTED_DTM)) from IA_LIVE_Business WHERE BUSINESS_ID in ("+Division_business_id+"))";

		   getdata=Database_query_Manager.get_IA_LIVE_Business(query1,connection.get("IAconconnection"));

			Division=getdata.get("PRIMARY_NAME");

			Browser.start();

			Browser.loadURL(URL,Log.giAutomationWaitTO);

			OTP_Login_Page.EnterAccountText(AccountNumber);

			if(Common_Class.V4prop.get("ZipCode").toString().contains("yes")) 
			{

				OTP_Login_Page.EnterAccountinfoText(ZipCode);

			} else if(Common_Class.V4prop.get("Division").toString().contains("yes"))

			{
				OTP_Login_Page.EnterAccountinfoText(Division_business_id);
			}
			else if(Common_Class.V4prop.get("Accountinfo").toString().contains("yes"))
			{
				OTP_Login_Page.EnterAccountinfoText(Accountinfo1);
			}

			if(OTP_Login_Page.isAccountonf2present()){
				OTP_Login_Page.EnterAccountinfo2Text(Accountinfo2);
			}

			if(OTP_Login_Page.isdivisionpresent())
			{
				OTP_Login_Page.selectdivision(Division);
			}
			OTP_Login_Page.clickbutton();

		} finally {

		}
	}*/
	public static void otplogin(String Division_business_id,int rowcount,Map<String,Connection>connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
     	URL=Common_Class.V4prop.getProperty("OTP_Fullhost").toString()+Common_Class.V4prop.getProperty("Business_id");
     	Browser.start();
		Browser.loadURL(URL,Log.giAutomationWaitTO);
     	onetimepaylogin(Division_business_id, rowcount, connection);
	}
	
	public static void onetimepaylogin(String Division_business_id,int rowcount,Map<String,Connection>connection) throws SQLException {
		
		String query="select * from RTDS_MAM_"+Common_Class.V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+Division_business_id+" and ROWNUM <="+rowcount+"";

		if(accountIndex.get(Division_business_id) == null)
		{
			billerRecords=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));
			accountIndex.put(billerRecords.get(0).get("DIVISION_BUSINESS_ID"), 0);
			getdata = billerRecords.get(0);
		}
		else
		{
			Integer recIndex = accountIndex.get(Division_business_id);
			recIndex = recIndex + 1;
			if(recIndex >= billerRecords.size())
			{
				recIndex = 0;
			}
			getdata = billerRecords.get(recIndex);
			accountIndex.put(Division_business_id, recIndex);
		}

		AccountNumber=getdata.get("ACCOUNT_NUMBER");

		Accountinfo1=getdata.get("ACCOUNT_INFO_01");

		Accountinfo2=getdata.get("ACCOUNT_INFO_02");

		ZipCode=getdata.get("BILLING_POSTAL_CODE");

		String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and TO_DATE(PROMOTED_DTM) = (select TO_DATE(max(PROMOTED_DTM)) from IA_LIVE_Business WHERE BUSINESS_ID in ("+Division_business_id+"))";

		getdata=Database_query_Manager.get_IA_LIVE_Business(query1,connection.get("IAconconnection"));

		Division=getdata.get("PRIMARY_NAME");

		OTP_Login_Page.EnterAccountText(AccountNumber);

		if(Common_Class.V4prop.get("ZipCode").toString().contains("yes")) 
		{

			OTP_Login_Page.EnterAccountinfoText(ZipCode);

		} else if(Common_Class.V4prop.get("Division").toString().contains("yes"))

		{
			OTP_Login_Page.EnterAccountinfoText(Division_business_id);
		}
		else if(Common_Class.V4prop.get("Accountinfo").toString().contains("yes"))
		{
			OTP_Login_Page.EnterAccountinfoText(Accountinfo1);
		}

		if(OTP_Login_Page.isAccountonf2present()){
			
			OTP_Login_Page.EnterAccountinfo2Text(Accountinfo2);
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

	/** This Method executes the Login functionality of OTP fullhost for Non MAM accounts
	 * @param Division_business_id
	 * @param Account_num
	 * @param accountinfo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
/*	public static void getNonMamaccount(String Division_business_id, String Account_num, Map<String, String>accountinfo, Map<String,Connection> connection) throws ClassNotFoundException, SQLException 
	{
		try {
			
			Browser.start();

			URL=Common_Class.V4prop.getProperty("OTP_Fullhost").toString()+Common_Class.V4prop.getProperty("Business_id");

			String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and ROWNUM =1 order by ACTIVE_STATUS_DTM desc";

			getdata=Database_query_Manager.get_IA_LIVE_Business(query1,connection.get("IAconconnection"));

			String Division=getdata.get("PRIMARY_NAME");

			Browser.loadURL(URL,Log.giAutomationShortTO);

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
			OTP_Login_Page.clickbutton();

		}catch(Exception e) {

		}
	}
	
	*/
	public static void getNonMamaccount(String Division_business_id,String Account_num,Map<String, String>accountinfo,Map<String,Connection>connection) throws ClassNotFoundException, SQLException 
	{
		    Browser.start();
			URL=Common_Class.V4prop.getProperty("OTP_Fullhost").toString()+Common_Class.V4prop.getProperty("Business_id");
			Browser.loadURL(URL,Log.giAutomationShortTO);
			nonmamdata(Division_business_id, Account_num, accountinfo, connection);
	}
	
	
	public static void nonmamdata(String Division_business_id,String Account_num,Map<String, String>accountinfo,Map<String,Connection>connection) throws SQLException {
		String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and ROWNUM =1 order by ACTIVE_STATUS_DTM desc";
		
		getdata=Database_query_Manager.get_IA_LIVE_Business(query1,connection.get("IAconconnection"));

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


	/**This method sets the path for testdata and property file
	 * 
	 */
	public static  void set_test_data_path()
	{
		String FilePath=""+Platform.getUserHome() + Platform.getFileSeparator()+"//automation.properties";

		String Testdata=""+ Platform.getCurrentProjectPath().replace("\\","//")+"V4//Smoke//otp//testdata//";

		FileIO.updatePropertyFile(FilePath, "gsAutomationAutoSupportDocs", Testdata);
	}


	/** This method is generic where payments are made for ACH,Credit and Debit card. 
	 * @param MAMTYPE
	 * @param size
	 * @param type
	 * @param sheetname
	 * @param testCases
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void ExecutePayment(String MAMTYPE, int size, CommonPayment payment,  String sheetname, String testCases,Map<String,Connection> connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
		try 
		{  
			HashMap<String, String> map = null;
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

					accountinfo=Common_Class.getaccinfo(connection);

					accountNumbers=Common_Class.gen_num_acc_num(ID,connection);
				}

				for(int i=0;i<=getach.length-1;i++) 
				{
					Log.startTestCase("Execute "+MAMTYPE+" Testcase for Making a payment for "+splittpye[0]+" with "+getach[i].trim()+"  ");	

					Map<String,String> Bankdetails = Excel.getXlsRowDataAsMap("OTP_testdata.xls", ""+sheetname+"", getach[i]);
					
					try 
					{

						if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types"))
						{

							getNonMamaccount(ID,accountNumbers.get(i),accountinfo,connection);

						} else 
						{
							otplogin(ID,getach.length,connection);
						}

						payment.makePayment(Bankdetails,getach[i]);

						if(testCases.equalsIgnoreCase("CONFIRMATION"))
						{
							testConfirmation(map,connection);
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

	/**This method get the confirmation number  of the payments and compares the expected results with the actual
	 * @param map
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void testConfirmation(HashMap<String, String> map,Map<String,Connection> connection) throws ClassNotFoundException, SQLException
	{
		String getconfirmation=Otp_CreditCardPaymentPage_ConfirmationNumber.Get_Conformation_Number();

		if(getconfirmation!=null)
		{
		    String confirmation="select * from cp_payment where CONFIRMATION_NUMBER ="+getconfirmation+"";
			
			map=Database_query_Manager.get_cp_payment(confirmation,connection.get("D2connection"));

			if(confirmation!=null)
			{
				Common_Class.altVerify(map.get("CONFIRMATION_NUMBER"), getconfirmation, true);

				String Updatequery="update cp_payment set payment_status_id = 8 where confirmation_number ="+map.get("CONFIRMATION_NUMBER")+"";

				Database_query_Manager.updateDB(Updatequery,connection.get("D2connection"));
			}
		}
	}

}
