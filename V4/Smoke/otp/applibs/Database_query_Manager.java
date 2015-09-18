/**
 * 
 */
package V4.Smoke.otp.applibs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import core.libs.Database;
import core.libs.Log;

/**
 * @author patilpa
 *
 */
public class Database_query_Manager {

	static private  String driver;
	static private  String username;
	static private  String Password;
	public static Properties p2;

	public static Connection connect_DatabaseD2QA(Properties p1) throws  SQLException, ClassNotFoundException {
		
		driver=p1.getProperty("Db_Driver");
		username=p1.getProperty("Db_username");
		Password=p1.getProperty("Db_password");

		String url = "jdbc:oracle:thin:@D2qa:1621:D2qa";
		System.out.println("connection established");
		return Database_Connection.connectToDatabase(driver, url, username, Password);

	}

	public static Connection connect_DatabaseIAQA(Properties p1) throws  SQLException, ClassNotFoundException {
		
		driver=p1.getProperty("Db_Driver");
		username=p1.getProperty("Db_username");
		Password=p1.getProperty("Db_password");

		String url = "jdbc:oracle:thin:@IAQA:1621:IAQA";
		System.out.println("connection established");
		return Database_Connection.connectToDatabase(driver, url, username, Password);

	}

	public static Connection connect_DatabaseRTDSQA(Properties p1) throws  SQLException, ClassNotFoundException {
		driver=p1.getProperty("Db_Driver");
		username=p1.getProperty("Db_username");
		Password=p1.getProperty("Db_password");

		String url = "jdbc:oracle:thin:@RTDSQA:1621:RTDSQA";
		System.out.println("connection established");
		return Database_Connection.connectToDatabase(driver, url, username, Password);

	}

	public static void connect_DatabasePEQA(Properties p1) throws  SQLException, ClassNotFoundException {
		
		driver=p1.getProperty("Db_Driver");
		username=p1.getProperty("Db_username");
		Password=p1.getProperty("Db_password");

		String url = "jdbc:oracle:thin:@PEQA:1621:PEQA";
		Database.connectToDatabase(driver, url, username, Password);
		System.out.println("connection established");
	}




	public static  List< Map<String, String>> getRTDSinfo(String query,Connection getconn) throws SQLException {

		boolean flag= false;
		List< Map<String, String>> billers = null;
		try {	
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			billers = new ArrayList<>();
			while(rs.next()){
				flag=true;
				Map<String, String> billerRecord = new HashMap<String, String>();
				billerRecord.put("BILLING_ACCOUNT_HOLDER_NAME", rs.getString("BILLING_ACCOUNT_HOLDER_NAME"));
				billerRecord.put("ACCOUNT_NUMBER", rs.getString("ACCOUNT_NUMBER"));
				billerRecord.put("DIVISION_BUSINESS_ID", rs.getString("DIVISION_BUSINESS_ID"));
				billerRecord.put("AMOUNT_DUE", rs.getString("AMOUNT_DUE"));
				billerRecord.put("BILLING_ACCOUNT_HOLDER_NAME", rs.getString("BILLING_ACCOUNT_HOLDER_NAME"));
				billerRecord.put("BILLING_CITY", rs.getString("BILLING_CITY"));
				billerRecord.put("BILLING_STATE_PROV", rs.getString("BILLING_STATE_PROV"));
				billerRecord.put("BILLING_POSTAL_CODE", rs.getString("BILLING_POSTAL_CODE"));
				billerRecord.put("ACCOUNT_INFO_01", rs.getString("ACCOUNT_INFO_01"));
				billerRecord.put("ACCOUNT_INFO_02", rs.getString("ACCOUNT_INFO_02"));
				billers.add(billerRecord);
			}

		}catch (SQLException e){

		}
		if(!flag){
			return null;

		}else {

			return billers;
		}
	}


	public static  HashMap<String, String>get_IA_LIVE_Business(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {

			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("BUSINESS_CODE", rs.getString("BUSINESS_CODE"));
				map.put("PRIMARY_NAME", rs.getString("PRIMARY_NAME"));
				map.put("ACTIVE_STATUS", rs.getString("PRIMARY_NAME"));

			}

		}catch(SQLException e){

		}

		if(!flag){
			return null;

		}else {
			return map;
		}

	}


	public static  HashMap<String, String>get_cp_payment(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("PAYMENT_ID", rs.getString("PAYMENT_ID"));
				map.put("CONFIRMATION_NUMBER", rs.getString("CONFIRMATION_NUMBER"));
				map.put("FUNDING_ACCOUNT_ID", rs.getString("FUNDING_ACCOUNT_ID"));
				map.put("PRODUCT_ID", rs.getString("PRODUCT_ID"));
				map.put("PAYMENT_STATUS_ID", rs.getString("PAYMENT_STATUS_ID"));
				map.put("RESELLER_BUSINESS_ID", rs.getString("RESELLER_BUSINESS_ID"));
				map.put("DIVISION_BUSINESS_ID", rs.getString("DIVISION_BUSINESS_ID"));
				map.put("CREDIT_DEBIT_IND", rs.getString("CREDIT_DEBIT_IND"));
				map.put("PAYMENT_TYPE", rs.getString("PAYMENT_TYPE"));
				map.put("PAYMENT_AMOUNT", rs.getString("PAYMENT_AMOUNT"));

			}
		}catch(SQLException e){

		}
		if(!flag){
			return null;

		}else {
			return map;
		}

	}

	public static  HashMap<String, String>get_ACH_details(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("ROUTING_NUMBER", rs.getString("ROUTING_NUMBER"));
				map.put("BANK_ACCOUNT_NUMBER", rs.getString("BANK_ACCOUNT_NUMBER"));
				//map.put("ACTIVE_STATUS", rs.getString("PRIMARY_NAME"));

			}
		}catch(SQLException e){

		}
		if(!flag){
			return null;

		}else {
			return map;
		}

	}

	public static  HashMap<String, String>getvalidationid(String query,Connection conn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,conn);
			while(rs.next()){
				flag=true;
				map.put("VALIDATION_RULE_SET_ID", rs.getString("VALIDATION_RULE_SET_ID"));

			}
		}catch(SQLException e){
			Log.errorHandler("Error occurred validation id",e);

		}
		if(!flag){
			return null;

		}else {
			return map;
		}

	}

	public static  HashMap<String, String>getminmaxacc(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("MIN", rs.getString("MIN"));
				map.put("MAX", rs.getString("MAX"));

			}
		}catch(SQLException e){

		}
		if(!flag){
			return null;

		}else {
			return map;
		}



	}
	public static  HashMap<String, String>getaccmask(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("ACCOUNT_NUMBER_MASK", rs.getString("ACCOUNT_NUMBER_MASK"));

			}
		}catch(SQLException e){

		}
		if(!flag){
			return null;

		}else {
			return map;
		}
	}

	public static  HashMap<String, String>get_credit_card_details(String query,Connection getconn) throws SQLException {
		boolean flag= false;
		HashMap<String, String> map = new HashMap<String,String>();
		try {

			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("CREDIT_CARD_NUMBER", rs.getString("CREDIT_CARD_NUMBER"));
				map.put("ACCOUNT_HOLDER_NAME", rs.getString("ACCOUNT_HOLDER_NAME"));
				map.put("ACCOUNT_ADDRESS_1", rs.getString("ACCOUNT_ADDRESS_1"));
				map.put("ACCOUNT_ADDRESS_2", rs.getString("ACCOUNT_ADDRESS_2"));
				map.put("ACCOUNT_CITY", rs.getString("ACCOUNT_CITY"));
				map.put("ACCOUNT_STATE_PROV", rs.getString("ACCOUNT_STATE_PROV"));
				map.put("ACCOUNT_POSTAL_CODE", rs.getString("ACCOUNT_POSTAL_CODE"));
				map.put("CREDIT_CARD_TYPE", rs.getString("CREDIT_CARD_TYPE"));
			}
		}catch(SQLException e){

		}
		if(!flag){
			return null;

		}else {
			return map;

		}

	}
	public static  HashMap<String, String>updateDB(String query,Connection getconn) throws SQLException {
		boolean flag=false;
		HashMap<String, String> map = new HashMap<String,String>();
		try{
			Database_Connection.executeDatabaseUpdate(query,getconn);
		}catch(Exception e){
			System.out.println("failed");
		}
		return map;


	}

	public static  HashMap<String, String>getprofileid(String query,Connection getconn) throws SQLException {
		boolean flag=false;
		HashMap<String, String> map = new HashMap<String,String>();
		try{
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("CONSUMER_PROFILE_ID", rs.getString("CONSUMER_PROFILE_ID"));

			}
		}catch(Exception e){

		}
		return map;

	}
	public static  HashMap<String, String>getenrolssodetails(String query,Connection getconn) throws SQLException {
		boolean flag=false;
		HashMap<String, String> map = new HashMap<String,String>();
		try{
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				System.out.println("the value is===="+rs.getString("BUSINESS_ID"));
				map.put("BUSINESS_ID",  rs.getString("BUSINESS_ID"));
				map.put("LOGIN", rs.getString("LOGIN"));
				map.put("PASSWORD", rs.getString("PASSWORD"));
				map.put("CONSUMER_PROFILE_ID", rs.getString("CONSUMER_PROFILE_ID"));
			}
		}catch(Exception e){

		}
		return map;
	}

	public static  HashMap<String, String>getenrollcedentials(String query,Connection getconn) throws SQLException {
		HashMap<String, String> map = new HashMap<String,String>();
		boolean flag=false;
		try{
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("LOGIN", rs.getString("LOGIN"));
				map.put("PASSWORD", rs.getString("PASSWORD"));
				map.put("PASSWORD_EXPIRY_DT", rs.getString("PASSWORD_EXPIRY_DT"));
			}
		}catch(Exception e){

		}
		return map;

	}
	public static  List<String>getprofileids(String query,Connection getconn) throws SQLException {
		boolean flag=false;
		List<String>profileids= new ArrayList<String>();
		try{
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				String id=rs.getString("CONSUMER_PROFILE_ID");
				profileids.add(id);
			}
		}catch(Exception e){

		}
		return profileids;

	}
	public static HashMap<String,String> funding_account(String query,Connection getconn) throws SQLException {
		boolean flag=false;
		HashMap<String,String>map= new HashMap<String,String>();
		try{
			ResultSet rs = Database_Connection.executeDatabaseQuery(query,getconn);
			while(rs.next()){
				flag=true;
				map.put("FUNDING_ACCOUNT_ID", rs.getString("FUNDING_ACCOUNT_ID"));
				map.put("Bank_fund_id", rs.getString("FUNDING_ACCOUNT_ID"));
				map.put("Credit_fun_id", rs.getString("FUNDING_ACCOUNT_ID"));
				map.put("Debit_fun_id", rs.getString("FUNDING_ACCOUNT_ID"));
			}
		}catch(Exception e){

		}
		return map;

	}

	
}
