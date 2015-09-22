package V4.Smoke.client_console.applibs;

import core.libs.Platform;
import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.TextField;

public class Client_ConsoleLogin_Page {
	

	
	
	//  public static String ccClientConsoleproperties =Platform.getCurrentProjectPath() + "V4\\Smoke\\client_console" +Platform.getFileSeparator() + "clientConsole.properties";
	
	 // public static String cilentconsoleUrl="https://collectpay-qa.princetonecom.com//clientconsole//loadLogin.do?id=504477";

	  /**
	  * Declaration for the cilent console main page for capturing the LoginVisible text
	  * @return Returns web UI object of specified type and definition 
	  */
	
	
	 public static TextField Text(){
		  return new TextField("//p[@class='body-page-header' and contains(text(),'Log In')]");}
	  
	
	public static String  get_LoginVisibleText(){
		String LoginText =Text().getText();
		return LoginText;
	 }
	
	

	/**
	 * Declaration for the cilent console main page for capturing the Welcome text text
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static TextField WelcomeText(){
		 return new TextField("//*[contains(text(),'Welcome to Client Console.')]");}
	/**
	 * Goes to entire html page and captures the welcome  text
	 * and stores the string in the string type variable
	 * @author ENTURU ARCHANA
	 */
	
	public static String  get_WelcomeVisibleText(){
		String WelcText =Text().getText();
		return  WelcText;}
	
	/**
	 * Declaration for clientConsole Login page Username  text field 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	
	public static TextField UserNameTextFeild(){
		 return new TextField("name=login");}
		 /**
			 * clientConsole Login page Password  text field 
			 * @return Returns web UI object of specified type and definition
			 */    
	public static TextField PasswordTextFeild(){
		 return new TextField("name=password");
		}
	/**
	 * clientConsole Login page Submit button
	 * @return Returns web UI object of specified type and definition
	 */ 
	public static Button SubmitButton(){
		 return new Button("name=Submit");
		 }
	/**
	 * Enters a USERNAME string in Username textfield
	 * @param sUser_Name - User_Name enters the username text into userName  text field
	 * @author ENTURU ARCHANA
	 */
    public static void clientconsoleUserName(String sUser_Name){
	   UserNameTextFeild().setText( sUser_Name);
	  
     }
    /**
	 * Enters a Password string in password textfield
	 * @param sPassword - sPassword enters the Password text into Password text field
	 * @author ENTURU ARCHANA
	 */

     public static void clientconsolePassword(String sPassword){
	    PasswordTextFeild().setText(sPassword);
      }
  
     /**
	 *clicks on the submit button:clientconsole page
	 * @param clicks() - clicks on submit button
	 * @author ENTURU ARCHANA
	 
	 */
     public static void clientconsole_login(String username,String password){
    	 UserNameTextFeild().setText( username);
    	 PasswordTextFeild().setText(password);
    	 SubmitButton().click();
     }
     public static Link PaymentEntry_link(){
		return new Link("//*[contains(text(),'  PAYMENT ENTRY  ')]");
    	 // return new Link("//*[contains(text(),'Payment Entry')]");
		 }
     public static void click_paymentEntry_link(){
 	    PaymentEntry_link().click();}
    
     
     public static void Submit(){
	    SubmitButton().click();
     }
    
   }