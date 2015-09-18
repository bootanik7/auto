package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;

public class payment_Confirmation_page {
	
	 /**
		 * to captures the visible text textfield  object declaration
		 * @return visible text  textfeild  object
		 *author:ARCHANA ENTURU
		 */
		
	
	public static TextField CP_VisibleText() {
		return new TextField("//*[@class='body-page-header' and contains(text(),'Payment Confirmation')]");}
	 /**
	 * captures the visible frm the UI
	 * @returns string 
	 *author:ARCHANA ENTURU
	 */
	
	
	public static String Get_CPText(){
		  String  CP_Text =CP_VisibleText().getText();
		  return  CP_Text;}
	/**
	  * print  Button object declaration
	  * @return print  Button object
	  *author:ARCHANA ENTURU
	  */
    
	public static Button PrintButton(){
		return new Button("//input[@value='Print']");
	}
	/**
	  *  Enter_AnotherPayment  Button object declaration
	  * @return  Enter_AnotherPayment  Button object
	  *author:ARCHANA ENTURU
	  */
    
	public static Button Enter_AnotherPayment(){
		return new Button("//input[@value='Enter Another Payment']");
	}

	 /**
	  *clicks on print  Button
	  * 
	  *author:ARCHANA ENTURU
	  */
	public static void clickPrint(){
		PrintButton().click();	
	}

	 /**
	  *clicks on  enter another payment name  Button
	  * 
	  *author:ARCHANA ENTURU
	  */
	public static void click_AnotherPayment(){
		 Enter_AnotherPayment().click();}
	
		 public static  StaticText ConF_Number(){
				return new StaticText("id=confirmationNumberId");}
		 public static String Get_conf_num(){
			 return ConF_Number().getText();
		 }
	
	
	

}
