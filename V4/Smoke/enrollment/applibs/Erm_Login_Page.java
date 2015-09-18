package V4.Smoke.enrollment.applibs;


//import com.sun.xml.internal.fastinfoset.sax.Properties;

import java.util.Map;



import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.ListBox;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;

public class Erm_Login_Page 
{    
	
	    
	
	/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText welcomeText()
	{
		 return new StaticText("//*[contains(text(),'Welcome to the Biller Payment Service')]");
	}
	public static String get_Erm_Welcome_text()
	{
		String S=welcomeText().getText();
		return S;
	}
	/**
	 * Declaration for Enrollment  Login page username  text field 
	 * @return Returns web UI object of specified type and definition 
	 * Nagabhushana
	 */
	
	public static TextField userNameTextFeild()
	{
		return new TextField("name=login");
	}
	
	 /**
	 *Enrollment Login page Password  text field 
	 * @return Returns web UI object of specified type and definition
	 */    
	
	public static TextField passwordTextFeild()
	{
		return new TextField("id=password");
	} 
	
	/**
	 * Enrollment Login page Submit button
	 * @return Returns web UI object of specified type and definition
	 */ 
	
	public static Button SubmitButton()
	{
		return new Button("id=submitButton");
	}
	/**
	 * Enters a USERNAME string in Username textfield
	 * @param sUser_Name - User_Name enters the username text into userName  text field
	 * @author Nagbushana 
	 */
	 public static void erm_UserName(String sUser_Name)
	 {
		userNameTextFeild().setText(sUser_Name);
	 }
	  /**
		 * Enters a Password string in password textfield
		 * @param sPassword - sPassword enters the Password text into Password text field
		 * @author Nagabhushana 
		 */
	 public static void erm_Password(String sPassword)
	 {
		 passwordTextFeild().setText(sPassword);
	 }
	   /**
		 *clicks on the submit button:Enrollment page
		 * @param clicks() - clicks on submit button
		 * @author Nagabhushana Rao
		 */
	 public static void Submit()
     {
	 SubmitButton().click();
	 }
	 
	 /**
	 * Link object for "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 * @return web UI Link object for the "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 */
	 public static Link Login_Link_ForgotPassword() 
	 {
	 	return new Link("linkText=Forgot Password");
	 }

   /**
    * TextField object for "Login_TextBox_Acntnum" TextField with locator of ("id=billingAccount")
    * @return web UI TextField object for the "Login_TextBox_Acntnum" TextField with locator of ("id=billingAccount")
    */
   public static TextField Login_TextBox_Acntnum()
   {
	return new TextField("id=billingAccount");
    }
   public static void Enter_Account_Num(String s)
	{
	   Login_TextBox_Acntnum().setText(s);
	}
   public static boolean Ac_isPresent()
   {
	   return Login_TextBox_Acntnum().isVisible();
   }
   /**
   * TextField object for "Login_TextBox_SecureKey1" TextField with locator of "id=loginFields0"
   * @return web UI TextField object for the "Login_TextBox_SecureKey1" TextField with locator of "id=loginFields0"
   */
   public static TextField Login_TextBox_SecurityKey_Ac_Info1()
   {
   	return new TextField("name=loginFields[0]");
   }
   public static void Enter_Security_Num1(String s)
	{
	   Login_TextBox_SecurityKey_Ac_Info1().setText(s);
	}
   public static boolean Info1_isPrasent()
   {
	   return Login_TextBox_SecurityKey_Ac_Info1().isVisible();
   }
   
   /**
    * TextField object for "Login_TextBox_SecureKey1" TextField with locator of "id=loginFields0"
    * @return web UI TextField object for the "Login_TextBox_SecureKey1" TextField with locator of "id=loginFields0"
    */
    public static TextField Login_TextBox_SecurityKey_Ac_Info2()
    {
    	return new TextField("name=loginFields[1]");
    }
    public static void Enter_Security_Num2(String s)
 	{
 	   Login_TextBox_SecurityKey_Ac_Info2().setText(s);
 	}
    public static boolean Info2_isPrasent()
    {
 	   return Login_TextBox_SecurityKey_Ac_Info2().isVisible();
    }
    
     
   /**
   * ListBox object for "Login_DropDown_Division" ListBox with locator of "id=divisionBusinessId"
   * @return web UI ListBox object for the "Login_DropDown_Division" ListBox with locator of "id=divisionBusinessId"
   */
   public static ListBox Login_DropDown_Division() 
   {
   	return new ListBox("name=divisionBusinessId");
   }
   public static void select_Division(String s)
	{
	   Login_DropDown_Division().selectItem(s);
	}
   public static boolean Division_isPresent()
   {
	   return Login_DropDown_Division().isVisible();
   }
   


   /**
   * Button object for "Login_Button_Continue" Button with locator of "id="continueButton"
   * @return web UI Button object for the "Login_Button_Continue" Button with locator of "id="continueButton"
   */
   public static Button Login_Button_Continue() 
   {
   	return new Button("id=continueButton");
   } 
   public static void click_on_contine()
   {
	   Login_Button_Continue().click();
   }
   
   public static boolean iscontinepresent()
   {
	  return Login_Button_Continue().isVisible();
   }
   /**
   * Link object for "Login_Link_SignUp" Link with locator of "link=Sign Up Now!"
   * @return web UI Link object for the "Login_Link_SignUp" Link with locator of "link=Sign Up Now!"
   */
   public static Link Login_Link_SignUp()
   {
   	return new Link("link=Sign Up Now!");
   }
   public static void Click_signUp(){
	   Login_Link_SignUp().click();
   }
/*
public static void ccClientConsoleproperties()
{
//read in the values for the following google application properties from the google.properties file
		 		Properties p = Log.loadFromFile(enrollmentProperties);
		 		EnrollmentUrl =p.getProperty("EnrollmentURL");
}
*/
public static void Login(String s1,String s2)	
{
	Erm_Login_Page.erm_UserName(s1);
	Erm_Login_Page.erm_Password(s2);
	Erm_Login_Page.Submit();
}
public static void OneTimeLogin_Details(Map<String,String> Ed)
{  
	Erm_Login_Page.Enter_Account_Num(Ed.get("Account_Num"));
    Erm_Login_Page.Enter_Security_Num1(Ed.get("Security_Num1"));
    Erm_Login_Page.Enter_Security_Num2(Ed.get("Security_Num2"));
    Erm_Login_Page.select_Division(Ed.get("Division"));
    Erm_Login_Page.click_on_contine();

	
}

	 
	 
	 
}
