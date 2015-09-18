package V4.Smoke.client_console.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.ClientConsole_Homepage;
import V4.Smoke.client_console.applibs.ClientConsole_payment_entry_page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.client_console.applibs.Management_Transcation_SearchPage;
import V4.Smoke.client_console.applibs.Management_transcation_page;
import V4.Smoke.client_console.applibs.Mangement_ViewTranscation_Page;
import V4.Smoke.client_console.applibs.clientConsole_logout_page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.SeleniumCore;

/**
 * @author enturua
 *
 */
public class Common_Class_clientConsole 
{
	public static String conformationPage,Accountinfo1,Division,ZipCode;
	static Map<String, String>getdata;
	static List< Map<String, String>> billerRecords;
	static Map<String, Integer> accountIndex = new HashMap<String, Integer>();
	static String URL;
	static String getconfirmation;

	/**
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	public static void client_console_login(Map<String,Connection>getconn) throws InterruptedException, SQLException
	{
		try{
		Browser.start();
		URL= Common_Class.V4prop.getProperty("clientConsolURL")+Common_Class.V4prop.getProperty("Business_id");
		Browser.loadURL(URL,Log.giAutomationShortTO);
		String business_id="'"+Common_Class.V4prop.getProperty("Business_id")+"'";
		String Update="update sp_identity set PASSWORD_EXPIRY_DT='31-DEC-2020' where business_id="+business_id+" and product_id='1178' and user_id in(select USER_ID from sp_user where business_id ="+business_id+" and product_id=1178 and USER_STATUS_ID=1)and rownum=1";
		Database_query_Manager.updateDB(Update,getconn.get("D2connection"));
		String query="select Login,Password From sp_identity_en where business_id="+business_id+"and product_id=1178 and user_id in(select USER_ID from sp_user where business_id ="+business_id+" and product_id=1178 and USER_STATUS_ID=1)";
		getdata=Database_query_Manager.getenrollcedentials(query, getconn.get("D2connection"));
		Client_ConsoleLogin_Page.clientconsole_login(getdata.get("LOGIN"),getdata.get("PASSWORD"));
		
		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during logging to system.",e);
		}
		}

	public static void commonLink(){
		
		ClientConsole_Homepage.click_Home_page();
	}
	
	public static void common_logout(){

		clientConsole_logout_page.CC_logout();
	}


	public static  void set_test_data_path()
	{
		String FilePath=""+Platform.getUserHome() + Platform.getFileSeparator()+"//automation.properties";

		String Testdata=""+ Platform.getCurrentProjectPath().replace("\\","//")+"//V4//Smoke//client_console//testdata//";

		FileIO.updatePropertyFile(FilePath, "gsAutomationAutoSupportDocs", Testdata);
	}

	public static Map<String, String> getaccinfo(Map<String,Connection>connection) throws ClassNotFoundException, SQLException { {

		String query="select * from RTDS_MAM_"+Common_Class.V4prop.getProperty("Business_id")+" where  ROWNUM = 1";
		billerRecords=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));
		if(billerRecords!=null)		{

			getdata=billerRecords.get(0);

			Accountinfo1=getdata.get("ACCOUNT_INFO_01");

			ZipCode=getdata.get("BILLING_POSTAL_CODE");
		}
	}
	return getdata;
	}

	public static  void ExecutePayment(String MAMTYPE, int size, CommonPayment_clientconsole payment, String sheetname, String testCases,Map<String,Connection>connection) throws ClassNotFoundException, SQLException, InterruptedException
	{
		try{

			String Type;
			List< Map<String, String>> billerRecords = null;
			Map<String, String> accounts = null;
			List<String> accountNumbers = null;
			Boolean cancelModiCase = Boolean.FALSE;
			HashMap<String, String> map = null;
			String[]ACH_types= Common_Class.V4prop.get(MAMTYPE).toString().trim().split(",");//get the MAMtype
			for(int P=0;P<=ACH_types.length-1;P++)// iterate the business ids to get business id
			{

				String[] splittpye=ACH_types[P].split("-");

				if(splittpye.length==1)
				{ 
					if(MAMTYPE.matches("MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_ACH_Types")){
						Type=Common_Class.V4prop.getProperty("ACH_APP_Level").toString().trim();

					} else {
						Type=Common_Class.V4prop.getProperty("CC_APP_Level").toString().trim();
					}

				}

				else {
					Type=splittpye[1];

				}

				String[] getach=Common_Class.V4prop.get(Type).toString().trim().split(",");

				String ID=splittpye[0];

				if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types"))
				{
					accountNumbers=Common_Class.gen_num_acc_num(ID,connection);
				}
				else {

					billerRecords=Common_Class.getmamdetails(ID, getach.length,connection);

				}

				for(int i=0;i<=getach.length-1;i++) 
				{
					Log.startTestCase("Execute "+MAMTYPE+" Testcase for Making a payment for "+splittpye[0]+" with "+getach[i].trim()+"  ");	
					Map<String,String> Bankdetails=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls", ""+sheetname+"",getach[i]);
					String division_name=Common_Class.getdivisionname(ID, connection);
					try 
					{
						if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types")){	

							accounts.put("division_name", division_name);// why similar lines in if else statement ???
							accounts.put("ACCOUNT_NUMBER",accountNumbers.get(i));
							getconfirmation=payment.makePayment(Bankdetails,getach[i],accounts);
						}
						else {
							accounts=billerRecords.get(i);
							accounts.put("division_name", division_name); // why similar lines in if else statement ???
							getconfirmation=payment.makePayment(Bankdetails,getach[i],accounts);
						}

						if(testCases.equalsIgnoreCase("CONFIRMATION"))
						{
							 String confirmation="select * from cp_payment where CONFIRMATION_NUMBER ="+getconfirmation+"";
							 map= Database_query_Manager.get_cp_payment(confirmation, connection.get("D2connection"));
							 //testConfirmation(map.get("CONFIRMATION_NUMBER"),connection,getconfirmation);
							 String Updatequery="update cp_payment set payment_status_id = 8 where confirmation_number ="+confirmation+"";
			    	         Database_query_Manager.updateDB(Updatequery,connection.get("D2connection"));
			    	         Common_Class.altVerify(map.get("CONFIRMATION_NUMBER"),getconfirmation, true);
						}
						else
						{
							cancelModiCase = Boolean.TRUE;
							break;

						}
						if(size<=getach.length)
						{
							Common_Class_clientConsole.commonLink();
						}
					}catch(Exception e) 
					{
						Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);

						Common_Class_clientConsole.commonLink();
					}

				} 
				if(cancelModiCase)
				{
					break;
				}

			}

		}
		catch(Exception e)
		{

			Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);

		}


	}

	
	public static String testConfirmation(String confirmation,Map<String,Connection>connection,String getconfirmation) throws ClassNotFoundException, SQLException
	{
		
       if(getconfirmation!=null)
		{
			if(confirmation!=null)
			{
				Common_Class.altVerify(confirmation,getconfirmation, true);
	         	}
		}
		return getconfirmation;
	}

	
	
	public static void Paymnet_Entry(Map<String,String>accountdetails){
		Client_ConsoleLogin_Page.click_paymentEntry_link();


		ClientConsole_payment_entry_page.set_Account_Num(accountdetails.get("ACCOUNT_NUMBER"));

		if(ClientConsole_payment_entry_page.isDivisionPresent()){

			ClientConsole_payment_entry_page.set_CC_Division_Id(accountdetails.get("division_name"));	
			
		}

	     ClientConsole_payment_entry_page.click_Search();
	}

	public static  void ModifyPayment(Map<String,String> sd,String Type,String getconfirmation){

		try{

			ClientConsole_ACHPayementEntry_Page.Modify_Common_Fun(sd, Type, getconfirmation);
			ClientConsole_ACHPayementEntry_Page.Common_payments_Entry_Details(sd, Type);
			ClientConsole_ACHPayementEntry_Page.Payment_AccountName(sd.get("Account_name"));
			ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESS(sd.get("address1"));
			//enters the address into the text field 
			ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESSLN2(sd.get("address2"));
			//enters the address into the text field 
			ClientConsole_ACHPayementEntry_Page.ADDRESS_city(sd.get("city"));
			//enters the address into the text field 
			ClientConsole_ACHPayementEntry_Page.ADDRESS_State(sd.get("State"));
			//enters the address into the text field 
			ClientConsole_ACHPayementEntry_Page.ADDRESS_Zip(sd.get("Postal Code"));

			ClientConsole_ACHPayementEntry_Page.click_ManageTransaction_Button_ModifyPmt();
						
			ClientConsole_ACHPayementEntry_Page.btnYes();
			Common_Class_clientConsole.commonLink();
		
		
			
		}
		catch(Exception e)
		{
			Log.errorHandler("Error occurred during Modify payments ACH payment.",e);
			Common_Class_clientConsole.commonLink();
		}
	}

	public static  void  Search_Paymnet_ConfNum(String Type,String getConfirmation) {
		try {


			Management_transcation_page.click_HomePage_Link_MngTran();
			System.out.println(SeleniumCore.driver.getTitle());
			Management_transcation_page.Enter_Conf_Num(getConfirmation);
		    Management_transcation_page.clickSearch();
			Management_Transcation_SearchPage.Click_PendingRadioButton();
			Management_Transcation_SearchPage.Click_ViewTran();
			System.out.println(SeleniumCore.driver.getTitle());
		    String  Payment_confNum=ClientConsole_login.confirmation_number();
		    String getconfirmation =Payment_confNum.replaceAll("\\D","");
			Mangement_ViewTranscation_Page.Click_Btngobck();
			Common_Class_clientConsole.commonLink();
		}
		catch (Exception e) {
			Log.errorHandler("erroe occured during card payment  :" +e );
			Common_Class_clientConsole.commonLink();
		}

	}
	
	public static void Verify_Cancel_ACHPayment_MAM(String Type,String getConfirmation) throws ClassNotFoundException, SQLException, InterruptedException{
		Management_transcation_page.click_HomePage_Link_MngTran();
		System.out.println(SeleniumCore.driver.getTitle());
		Management_transcation_page.Enter_Conf_Num(getConfirmation);
		Management_transcation_page.clickSearch();
		Management_Transcation_SearchPage.Click_PendingRadioButton();
		Management_Transcation_SearchPage.Click_ViewTran();
	    Mangement_ViewTranscation_Page.Click_BtnCanTrans();
		Management_transcation_page.clickCancel();
		System.out.print(SeleniumCore.driver.getTitle());
		Common_Class_clientConsole.commonLink();
	}
	
	
	
	
	
	}















