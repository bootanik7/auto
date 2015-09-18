package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;

public class Mangement_ViewTranscation_Page {
	 /**
		 * to captures the visible text textfield  object declaration
		 * @return visible text  textfeild  object
		 *author:ARCHANA ENTURU
		 */
public static TextField VisibleText_View_TranPage(){
	return new TextField("//p[@class='body-page-header' and contains(text(),'View Transaction ')]");
}

/**
 * captures the visible text form the UI
 * @returns string 
 *author:ARCHANA ENTURU
 */
public static String get_Text_View_TranPage(){
	String Text=VisibleText_View_TranPage().getText();
    return Text;
}
/**
 * goBack  Button object declaration
 * @return goBack  Button object
 *author:ARCHANA ENTURU
 */
public static Button Btngobck() {
	return new Button("//*[@value='Go Back']");}
/**
 * modify transcation  Button object declaration
 * @return  modify transcation  Button object
 *author:ARCHANA ENTURU
 */

public static Button BtnModTrans() {
	return new Button("//*[@name='loadModifyPayment']");}
/**
 *cancelTranscation  Button object declaration
 * @return cancelTranscation  Button object
 *author:ARCHANA ENTURU
 */

public static Button BtnCanTrans() {
	return new Button("//*[@name='loadCancelPayment']");}


/**
 *clicks on GoBack button
 * 
 *author:ARCHANA ENTURU
 */
public static void Click_Btngobck(){
	Btngobck().click();
	
}

/**
 *clicks on modify transcation  button
 * 
 *author:ARCHANA ENTURU
 */

public static void Click_BtnModTrans(){
	BtnModTrans().click();
	
}

/**
 *clicks on cancelTranscation  button
 * 
 *author:ARCHANA ENTURU
 */
public static void Click_BtnCanTrans(){
	BtnCanTrans().click();
	
}

public static StaticText Canceltran_conftext() {
	return new StaticText("//*[contains(text(),'The following transaction has been successfully cancelled:')]");}


public static String get_CancelText(){
	String s=Canceltran_conftext().getText();
	return s;
}

}
