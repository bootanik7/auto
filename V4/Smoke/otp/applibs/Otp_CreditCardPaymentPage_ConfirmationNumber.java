package V4.Smoke.otp.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;

public class Otp_CreditCardPaymentPage_ConfirmationNumber {

	
	/**
	 * textFeild for capturing the confirmation code from the credit card confirmationpage
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static StaticText conFormation_Number(){
		return new StaticText("//span[@id='confirmation_number']"); 
		}
	/**
	 * Button to exit from the credit card confirmation page
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	 
	public static Button exit(){
		return new Button("//input[@value='Exit']");	
	 }
		
	/**
	 *get the confirmation code from the confirmation page 
	  
	 * author:Enturu ARCHANA
	 */
	public static String Get_Conformation_Number() {
		return conFormation_Number().getText();
		}
	
	/**
	 *clicks on exit 
	  
	 * author:Enturu ARCHANA
	 */
	public static void click_Exit() {
		exit().click();
	}

}
 