package  V4.Regression.client_console.applibs;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.SkipException;

import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.otp.applibs.Common_Class;
import core.libs.Excel;
import core.libs.Log;





/**
 * The WebWidget class is a wrapper class to allow centralized
 * control of common web UI objects such as buttons, text fields, listboxes, etc and methods specific to those types of objects. 
 */
public class V4_CC_Payment {

	

	public String ACH_types = null;
	public List<String> accountNumbersList = null;
	public String businessID = null;
	public List< Map<String, String>> billerRecords = null;
	public Map<String, String> accounts = new HashMap<>();
	public Map<String,String> Bankdetails = null;
	
	
	/*
	 * MAMTYPE - MAM_ACH_Types, NON_MAM_ACH_Types
	 * "MAM_ACH_Types =  [business_id_1-ACH_H ,business_id_2-ACH_A]"
	 * ACH_types =  business_id_1-ACH_H
	 * splittpye = [business_id_1, ACH_H] \ ACH_APP_Level = ACH_H
	 * Type = ACH_H 
	 * "ACH_H=Personal Savings,Business Checking"
	 * getach = [Personal Savings,Business Checking]
	 */
	
	
	public V4_CC_Payment(String MAMTYPE, int size, String sheetname, String testCases, Map<String,Connection>connection) throws ClassNotFoundException, SQLException, InterruptedException  {
				
		
		
		if(Common_Class.V4prop.get(MAMTYPE).toString().trim().contains("NA")) 
		{
			throw new SkipException("No Mam Details Present");
		}
		
		try{
			
					String Type;
					String division_name = null;
				
					String[]ACH_types= Common_Class.V4prop.get(MAMTYPE).toString().trim().split(",");//get the MAMtype
					for(int P=0;P<=ACH_types.length-1;P++)// iterate the business ids to get business id
					{

						String[] splitType=ACH_types[P].split("-");
											
						if(splitType.length==1)
						{ 
							if(MAMTYPE.matches("MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_ACH_Types")){
								Type=Common_Class.V4prop.getProperty("ACH_APP_Level").toString().trim();

							} else {
								Type=Common_Class.V4prop.getProperty("CC_APP_Level").toString().trim();
							}

						}
						else {
							Type=splitType[1];

						}

						
						
						String[] getach=Common_Class.V4prop.get(Type).toString().trim().split(",");
						Log.logScriptInfo("Get business_id: "+ splitType[0]);
						this.businessID = splitType[0]; 
						
						
						if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types"))
						{
							Log.logScriptInfo("Get account numbers for NON MAM payment");
							this.accountNumbersList = Common_Class.gen_num_acc_num(this.businessID,connection);
						}
						else {
							Log.logScriptInfo("Get mam details for MAM payment ");
							this.billerRecords=Common_Class.getmamdetails(this.businessID, getach.length,connection);
							
					

						}

						
						for(int i=0;i<=getach.length-1;i++) 
						{
							
							this.ACH_types = getach[i];
							try 
							{
								
								this.Bankdetails=Excel.getXlsRowDataAsMap("ClientConsole_testdata.xls", ""+sheetname+"",getach[i]);
																						
								if(MAMTYPE.matches("NON_MAM_ACH_Types")||MAMTYPE.matches("NON_MAM_CC_Types")){
									String account_number = this.accountNumbersList.get(i);
									Log.logScriptInfo("Get ACCOUNT_NUMBER for NON MAM payment:"+ account_number);
									this.accounts.put("ACCOUNT_NUMBER" , account_number);
								}
								else {
									Log.logScriptInfo("Get ACCOUNTS for  MAM payment");
									this.accounts=billerRecords.get(i);
								}
								
								division_name = Common_Class.getdivisionname(this.businessID, connection);
								Log.logScriptInfo("Get division name :"+ division_name);
								this.accounts.put("division_name", division_name);

							
								if(size<=getach.length)
								{
									break;
								}
							}
							catch(Exception e) 
							{
								Log.errorHandler("Error occurred during Making MAM ACH Payment.",e);

								
							}
							
							

						} 
					

					}

		}catch(Exception e)
		{
			Log.errorHandler("Error occurred during loading data for  " + MAMTYPE +" Payment.",e);
		}
	}

	
}