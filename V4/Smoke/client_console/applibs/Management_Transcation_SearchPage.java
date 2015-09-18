package V4.Smoke.client_console.applibs;


import core.webwidgets.RadioButton;

import core.webwidgets.TextField;

public class Management_Transcation_SearchPage {
	/**
	 * to captures the visible text textfield  object declaration
	 * @return visible text  textfield  object
	 *author:ARCHANA ENTURU
	 */

	public static TextField Visible_Text_TSPage(){
		return new TextField("//p[@class='body-page-header' and contains(text(),'Transaction Search')]");
	}
	
	/**
	 * captures the visible text  from the UI
	 * @returns string :Visible_TSText
	 *author:ARCHANA ENTURU
	 */
	
	
	public static String Get_TranSearch_Text(){
		String Visible_TSText=Visible_Text_TSPage().getText();
		return Visible_TSText;
	}
	
	 /**
	  * PendingRadio  Button object declaration
	  * @return PendingRadio  Button object
	  *author:ARCHANA ENTURU
	  */
	
	public static RadioButton Pending_Radio(){
		return new  RadioButton("//*[@name='paymentInfo']");}
	/**
	  *clicks on  PendingRadiobutton Radio Button
	  * 
	  *author:ARCHANA ENTURU
	  */
	
	public static void Click_PendingRadioButton(){
		Pending_Radio().click();
	}	
	/**
	  *  ViewTranscation  Button object declaration
	  * @return ViewTranscation   Button object
	  *author:ARCHANA ENTURU
	  */
	public static RadioButton ViewTran() {
		return new RadioButton  ("//*[@value='View Transaction']");
	}
	/**
	  *clicks on view transcation button
	  * 
	  *author:ARCHANA ENTURU
	  */
		public static void Click_ViewTran(){
			ViewTran().click();}
}




















