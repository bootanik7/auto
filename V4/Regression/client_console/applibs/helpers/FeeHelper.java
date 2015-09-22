
package V4.Regression.client_console.applibs.helpers;


import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.Properties;

import core.libs.Database;
import core.libs.Log;
import org.testng.SkipException;

import V4.Regression.client_console.applibs.V4_CC_Payment;
import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
/**
 * @author tatyana
 *
 */
public class  FeeHelper {
	

	public static List< Map<String, String>> GetFeeValuesByBusinessID(String BusinessID, String DivisionID, String ProductID, Connection connection ){
		
		/*
		 * Fee can be set for three level : Business level , Division level and Product level
		 * Each level can overriden by upper level
		 * Business level > Division level > Product level
		 * If we set on fee value of $1 for ach payment for Client Console (Product Level)
		 * And then we set on fee value of $10 on Business level (just for business_id)
		 * We will got fee value of $10
		 * */
		
		// Check the highest level  of the remit_fee.type rule
		//List< Map<String, String>> feeRules = RuleHelper.GetRuleValueByRuleName(BusinessID, "remit_fee.types", connection); 
		
		
		
		
		
		
		boolean flag= false;
		List< Map<String, String>> fees = null;
		try {	
			String query = "";
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,connection);
			//rules = new ArrayList<>();
		/*	while(rs.next()){
				flag=true;
				Map<String, String> ruleRecord = new HashMap<String, String>();
				feeRecord.put("ruleNameID", rs.getString("rule_name_id"));
				ruleRecord.put("ruleName", rs.getString("rule_name"));
				ruleRecord.put("ruleValue", rs.getString("rule_value"));
				ruleRecord.put("multyValueOrder", rs.getString("MULTI_VALUE_ORDER"));
				ruleRecord.put("businessID", rs.getString("business_id"));
				ruleRecord.put("activeFrom", rs.getString("active_from_dtm"));
				ruleRecord.put("activeTo", rs.getString("active_to_dtm"));
				rules.add(ruleRecord);
			}*/

		}catch (SQLException e){

		}
		if(!flag){
			return null;

		}else {

			return fees;
		}
		
			
		
	}
	/*
	public static List< Map<String, String>> getHighestFeeRuleValues (List< Map<String, String>> fees){
		List< Map<String, String>> fees = null;
	}
*/

}