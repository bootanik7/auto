package V4.Smoke.otp.applibs;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Log;
import core.libs.Platform;
import core.libs.report.AutomationReport;

public class Common_Class {
	public static  AutomationReport report2=null;
	public static String  V4Propfile=Platform.getCurrentProjectPath() + "V4" +Platform.getFileSeparator() + "V4.properties";
	public static String  V4DBpropfile=Platform.getCurrentProjectPath() + "V4" +Platform.getFileSeparator() + "Database.properties";
	public static Properties V4prop;
	public static Properties V4DBprop;

	/** This method gets the 4 Account number from the MAM table and returns the MAP
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Map<String, String> getaccinfo(Map<String,Connection>connection) throws ClassNotFoundException, SQLException {
		List< Map<String, String>> billerRecords =null;
		Map<String, String>getdata = null;
		String query="select * from RTDS_MAM_"+V4prop.getProperty("Business_id")+" where  ROWNUM = 1";
		billerRecords=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));

		if(billerRecords!=null)	{

			getdata=billerRecords.get(0);
		}
		return getdata;

	}

	/** This method generates the system date and returns the date
	 * @return
	 */
	public static String getsystemdate() 
	{
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); //HH:mm:ss.SS

		String strDate = sdf.format(cal.getTime());

		return strDate;
	}

	/** This method collects the business division ids in to an arraylist and returns the list
	 * @return
	 */
	public static List<String> collectdivision_ids() 
	{
		List<String> getdivids=new ArrayList<String>();
		if(!V4prop.get("MAM_ACH_Types").toString().trim().contains("NA")) {

			String[] str=V4prop.get("MAM_ACH_Types").toString().trim().split(",");
			for(int P=0;P<=str.length-1;P++)// iterate the business ids to get business id
			{

				String[] splittpye=str[P].split("-");
				getdivids.add(splittpye[0]);
			}

		}
		return getdivids;

	}

	/** This method executes the reporting functions
	 * 
	 */
	public static void terminate() 
	{
		report2 = new AutomationReport(Log.gsAutomationAutoResultPath + Log.gsScriptName + "_" + Log.gsScriptUID);

		report2.finishScript();

		Log.autoCleanup(true);

		Log.copyResultsToSilkCentral();

	}

	/**This Method verifies the expected result with the actual result with the contains method
	 * @param sExpected
	 * @param sActual
	 * @param bExactMatch
	 * @return
	 */
	public static boolean altVerify(String sExpected, String sActual, boolean bExactMatch)
	{
		if (bExactMatch == true)
		{
			if (sActual.toUpperCase().contains(sExpected.toUpperCase()))
			{
				Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
				return true;
			}
			else
			{
				Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
				return false;
			}
		}
		else
		{
			if (sActual.toUpperCase().indexOf(sExpected.toUpperCase()) != -1)
			{
				Log.logScriptInfo("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"", Log.giAutomationLogType);
				return true;
			}
			else
			{
				Log.errorHandler("Verify Expected: \"" + sExpected + "\" Actual: \"" + sActual + "\"");
				return false;
			}
		}

	}


	/** This method Randomly generates the account number for Non MAM accounts
	 * @param Divsion_business_id
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> gen_num_acc_num(String Divsion_business_id,Map<String,Connection> connection) throws SQLException {
		Map<String,String> account= new HashMap<String,String>();			

		String query="select * from rtds_validation_rule_set where biller_business_id = "+Divsion_business_id+" and ORIGINATOR_PRODUCT_ID =1158";
		account=Database_query_Manager.getvalidationid(query,connection.get("RTDSconconconnection"));

		String getminmax="select  min(MAX_ACCOUNT_NUM_LENGTH) as min,max(MAX_ACCOUNT_NUM_LENGTH) as max from rtds_account_num_pattern where validation_rule_set_id  in ("+account.get("VALIDATION_RULE_SET_ID")+") and ACCOUNT_NUMBER_MASK not like '%null%'order by validation_rule_set_id desc";
		account=Database_query_Manager.getminmaxacc(getminmax,connection.get("RTDSconconconnection"));

		int min=Integer.parseInt(account.get("MIN"));
		int max=Integer.parseInt(account.get("MAX"));
		String getaccountmask= "select * from rtds_account_num_pattern where validation_rule_set_id  in ("+account.get("VALIDATION_RULE_SET_ID")+") and ACCOUNT_NUMBER_MASK not like '%null%' and RowNum =1";
		account=Database_query_Manager.getaccmask(getaccountmask,connection.get("RTDSconconconnection"));


		min=min+1;

		max=max-1;
		String accountMask = account.get("ACCOUNT_NUMBER_MASK");

		Integer[] values={min-1,min,max-1,max};

		List<String>list = new ArrayList<String>();

		StringBuilder str = new StringBuilder();

		Random random = new Random();
		for(int k=0;k<values.length;k++) {
			str.delete(0, values[k]);
			for(int i = 0; i<=values[k]-1; i++) {
				str.append(random.nextInt(10));
			}
			list.add(maskAccount(str.toString(), accountMask));

		}
		return (ArrayList<String>) list;
	}

	/** This Method provide the masks for the account number and returs the string
	 * @param rawAccount
	 * @param accountmask
	 * @return
	 */
	public static String maskAccount(String rawAccount, String accountmask){

		StringBuilder account = new StringBuilder();

		if(StringUtils.isEmpty(accountmask) || StringUtils.isEmpty(rawAccount))
		{
			return rawAccount;
		}

		int accountSize = rawAccount.length();
		int maskSize = accountmask.length();

		char[] accountArray = rawAccount.toCharArray();
		char[] maskArray = accountmask.toCharArray();

		for(int i=0; i<accountSize; i++){
			String accountChar = String.valueOf(accountArray[i]);
			if(i < maskSize)
			{
				char maskChar = maskArray[i];
				if(maskChar == '#')
				{
					account.append(accountChar);
				}
				else if (maskChar == '@')
				{
					Random r = new Random();
					char c = (char)(r.nextInt(26) + 'a');
					account.append(String.valueOf(c));
				}
				else if (maskChar == '*')
				{
					String symbols = "abcd0123456789ABCDEFGHIJKLM157951NOPQRSTUVWXYZefghijkl123458";
					Random r = new Random();
					account.append( symbols.charAt(r.nextInt(symbols.length())));
				}
				else
				{
					account.append(maskChar);
				}
			}
			else
			{
				account.append(accountChar);
			}
		}

		return account.toString();

	}
	/** This Method connects the database
	 * @param databasename
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Map<String,Connection> connectDB() throws  SQLException, ClassNotFoundException 
	{
		Map<String,Connection>getconnection= new HashMap<String,Connection>();
		Connection D2con=Database_query_Manager.connect_DatabaseD2QA(Common_Class.V4DBprop);
		Connection IAcon=Database_query_Manager.connect_DatabaseIAQA(Common_Class.V4DBprop);
		Connection RTDScon=Database_query_Manager.connect_DatabaseRTDSQA(Common_Class.V4DBprop);
		getconnection.put("D2connection", D2con);
		getconnection.put("IAconconnection", IAcon);
		getconnection.put("RTDSconconconnection", RTDScon);
		return getconnection;
	}

	/**This Methods returns the MAM account numbers
	 * @return
	 * @throws SQLException 
	 */
	public static List<String>getMAMaccountnumbers(String Division_business_id,int rowcount,Map<String,Connection>connection) throws SQLException {
		List< Map<String, String>> getbillers = null; 
		List<String>collectaccnumbers=new ArrayList<String>();
		try {
			String query="select * from RTDS_MAM_"+V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+Division_business_id+" and ROWNUM <="+rowcount+"";
			getbillers=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));
			for(Map<String,String>getdata:getbillers){
				collectaccnumbers.add(getdata.get("ACCOUNT_NUMBER"));
			}

		}catch(Exception e) {
			Log.errorHandler("Not retrived the account numbers for MAM");
		}
		return collectaccnumbers;
	}

	/**This method returns the mamdetails from RTDS MAM
	 * @param Division_business_id
	 * @param rowcount
	 * @param connection
	 * @return
	 */
	public static List< Map<String, String>>getmamdetails(String Division_business_id,int rowcount,Map<String,Connection>connection){
		List< Map<String, String>> getbillers = null;
		try {
			String query="select * from RTDS_MAM_"+V4prop.getProperty("Business_id")+" where DIVISION_BUSINESS_ID ="+Division_business_id+" and ROWNUM <="+rowcount+"";
			getbillers=Database_query_Manager.getRTDSinfo(query,connection.get("RTDSconconconnection"));

		}catch(Exception e){

		}

		return getbillers;
	}

	/**This Method returns the division name from the RTDS MAM
	 * @param Division_business_id
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public static String getdivisionname(String Division_business_id,Map<String,Connection>connection) throws SQLException {

		Map<String,String>map=null;

		String query1="select * from IA_LIVE_Business where  BUSINESS_ID in ( "+Division_business_id+") and TO_DATE(PROMOTED_DTM) = (select TO_DATE(max(PROMOTED_DTM)) from IA_LIVE_Business WHERE BUSINESS_ID in ("+Division_business_id+"))";

		map=Database_query_Manager.get_IA_LIVE_Business(query1,connection.get("IAconconnection"));

		return map.get("PRIMARY_NAME");

	}


	/**This method returns the ACH Types
	 * @return
	 */
	public static String[] getACHTypes() {
		String[] Types=null;
		if(!V4prop.get("ACH_APP_Level").equals("NA")) {
			String ACH_Type=V4prop.get("ACH_APP_Level").toString().trim();
			Types =V4prop.get(ACH_Type).toString().split(",");

		}
		return Types;

	}

	/**This Methods closes the database connections
	 * @return
	 * @throws SQLException 
	 */
	public static void closedbconnection(Map<String,Connection>connection) throws SQLException {
		connection.get("D2connection").close();
		connection.get("IAconconnection").close();
		connection.get("RTDSconconconnection").close();

	}

	/** This Method load the properties
	 * 
	 */
	public static void loadDBproperties() 
	{
		V4prop=Log.loadFromFile(V4Propfile);
		V4DBprop=Log.loadFromFile(V4DBpropfile);
	}


}
