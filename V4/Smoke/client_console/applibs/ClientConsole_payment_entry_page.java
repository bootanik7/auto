package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class ClientConsole_payment_entry_page {
	
	
	public static TextField VisiblePEText(){
		 return new TextField("//p[@class='body-page-header' and contains(text(),'Payment Entry')]");
	}
	
	/**
	  * Goes to entire html page and captures the visible text
	  * and stores the string in the string type variable and returns the visible text string
	  * @author ENTURU ARCHANA
	  */
	
	
	
	public static String Get_VisiblePEText(){
		return  VisiblePEText().getText();
		
	}
	/**
	 * textfeild for entering the account number in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_AccountNum(){
		 return new TextField("//*[@id='billingAccountNumber']");
	}
	
	
	public static void set_Account_Num(String sText){
		Payment_AccountNum().setText(sText);
	}
	/**
	 * Enter's the accountnumber in accountNum textfield and goes to next feild
	 * @ sAccount_num enters the account number text in account number feild
	 * Enturu ARCHANA
	 */

   public static void PayementEntryPage(String sAccount_num){
	 
	 Payment_AccountNum().setText(sAccount_num);
       }
	public static ListBox division(){
		return new ListBox("//*[@name='divisionBusinessId']");
	}

	public static void set_CC_Division_Id(String item){
		division().selectItem(item);
	}
	
	public static Boolean isDivisionPresent(){
		return division().isVisible();
	}
	public static Button pay_search(){
		return new Button("//*[@ value='Search']");
	}

	public static void click_Search(){
		pay_search().click();}

	public static Button ModfyTran() {
		return new Button("//*[@value='Modify Transaction']");
		
	}
	public static void click_ModfyTran(){
		ModfyTran().click();}
    


	











}

	

