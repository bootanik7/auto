
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
public class  RuleHelper {
	

	public static  HashMap<String, String> GetRuleValueExactlyByRuleName(String BusinessID, String RuleName, Connection connection ){
		
		
				
		String query="select v.rule_name_id, n.rule_name, v.rule_value,v.MULTI_VALUE_ORDER,"+ 
		"v.business_id, v.active_from_dtm, v.active_to_dtm "+
		"from ia_live_rule_value v, ia_rule_name n "+
		"where v.rule_name_id =n.rule_name_id "+
		"and v.active_to_dtm is null " + 
		"and n.rule_name = '"+RuleName +"' "+
		"and  v.business_id = "+ BusinessID + 
		" order by v.active_to_dtm desc";
			
		
		boolean flag= false;
		 HashMap<String, String> rules = new HashMap<String,String>();;
		try {	
			
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,connection);
	
			while(rs.next()){
				flag=true;
		
				rules.put("ruleNameID", rs.getString("rule_name_id"));
				rules.put("ruleName", rs.getString("rule_name"));
				rules.put("ruleValue", rs.getString("rule_value"));
				rules.put("multyValueOrder", rs.getString("MULTI_VALUE_ORDER"));
				rules.put("businessID", rs.getString("business_id"));
				rules.put("activeFrom", rs.getString("active_from_dtm"));
				rules.put("activeTo", rs.getString("active_to_dtm"));
			
			}

		}catch (SQLException e){

		}
		if(!flag){
			return null;

		}else {

			return rules;
		}
		
	}
	
	
	
public static List< Map<String, String>> GetRuleValuesLikeRuleName(String BusinessID, String RuleName, Connection connection ){
		
		
		 
		
		String query="select v.rule_name_id, n.rule_name, v.rule_value,v.MULTI_VALUE_ORDER,"+ 
		"v.business_id, v.active_from_dtm, v.active_to_dtm "+
		"from ia_live_rule_value v, ia_rule_name n "+
		"where v.rule_name_id =n.rule_name_id "+
		"and v.active_to_dtm is null " +
		"and n.rule_name like '%"+ RuleName +"%' " +
		"and  rv.business_id = "+BusinessID +
		" order by v.active_to_dtm desc";
		
	
		
		boolean flag= false;
		List< Map<String, String>> rules = null;
		try {	
			
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,connection);
			rules = new ArrayList<>();
			while(rs.next()){
				flag=true;
				Map<String, String> ruleRecord = new HashMap<String, String>();
				ruleRecord.put("ruleNameID", rs.getString("rule_name_id"));
				ruleRecord.put("ruleName", rs.getString("rule_name"));
				ruleRecord.put("ruleValue", rs.getString("rule_value"));
				ruleRecord.put("multyValueOrder", rs.getString("MULTI_VALUE_ORDER"));
				ruleRecord.put("businessID", rs.getString("business_id"));
				ruleRecord.put("activeFrom", rs.getString("active_from_dtm"));
				ruleRecord.put("activeTo", rs.getString("active_to_dtm"));
				rules.add(ruleRecord);
			}

		}catch (SQLException e){

		}
		if(!flag){
			return null;

		}else {

			return rules;
		}
		
	}



		
	}
