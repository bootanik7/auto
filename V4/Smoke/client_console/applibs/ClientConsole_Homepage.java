package V4.Smoke.client_console.applibs;

import core.webwidgets.Link;
import core.webwidgets.StaticText;



public class ClientConsole_Homepage {
	
	
	 /**
	  * Declaration for the cilent console main page for capturing the homePage Visible  text
	  * @return Returns web UI object of specified type and definition 
	  */
	
	public static StaticText CcText(){
		 return new StaticText("//*[contains(text(),'Welcome, Automation Trial')]");
		 }
	 
	  /**
	  * Goes to entire html page and captures the visible text
	  * and stores the string in the string type variable
	  * @author ENTURU ARCHANA
	  */
	
	
	
	public static String get_CcText(){
		String string=CcText().getText();
		return string;

	}
	
	/**
	 * clientConsole HomePage LINk
	 * @return Returns web UI object of specified type and definition
	 *@author ENTURU ARCHANA
	 **/
	
	public static Link Payment_Entry_Link(){
		 return new Link("//a[contains(text(),'Payment Entry')]");
		 }
	/**
	 * Go's to the ClientConsole_PaymentLink and clicks on the link
	 * 
	 * @author ENTURU ARCHANA
	 */
	public static void ClientConsole_PaymentLink(){
		Payment_Entry_Link().click();
		 }

	public static Link Home_page(){
		 return new Link("//*[@name='Image1']");
		 }
	/**
	 * Go's to the ClientConsole_PaymentLink and clicks on the link
	 * 
	 * @author ENTURU ARCHANA
	 */
	public static void click_Home_page(){
		Home_page().click();
		 }
}






































