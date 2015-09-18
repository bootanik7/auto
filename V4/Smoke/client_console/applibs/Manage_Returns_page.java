package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

public class Manage_Returns_page {
 

    
	public static Link HomePage_Link_MngReturnTab() {
		return new Link("link=MANAGE RETURNS");
	}
	
	public static void click_HomePage_Link_MngReturnTab(){
		HomePage_Link_MngReturnTab().click();
	}
	
	
	
	
	/**
	 * ViewSummary  Button object declaration
	 * @return ViewSummary  Button object
	 *author:ARCHANA ENTURU
	 */

	
	public static Button ViewSummary(){
	return new Button("//input[@type='Submit' and @value='View Summary' ]");}

/**
 *clicks on view summary button
 * 
 *author:ARCHANA ENTURU
 */

public  static void Click_ViewSummary(){
	ViewSummary().click();
}

/**
 * ViewDetail  Button object declaration
 * @return ViewDetail  Button object
 *author:ARCHANA ENTURU
 */
public static Button ViewDetail(){
	return new Button("//input[@type='Submit' and @value='View Detail' ]");}

/**
 *clicks on view summary button
 * 
 *author:ARCHANA ENTURU
 */

public  static void Click_ViewDetail(){
	ViewDetail().click();}

/**
 *  DownloadSummary  Button object declaration
 * @return  DownloadSummary Button object
 *author:ARCHANA ENTURU
 */
public static Button DownloadSummary(){
	return new Button("//input[@value='Download Summary']");}


/**
 *clicks on view DownloadSummary
 * 
 *author:ARCHANA ENTURU
 */






public  static void Click_DownloadSummary(){
	 DownloadSummary().click();}


/**
 * DownloadDetail  Button object declaration
 * @return DownloadDetail  Button object
 *author:ARCHANA ENTURU
 */
public static Button DownloadDetail(){
	return new Button("//input[@value='Download Detail']");}


/**
 *clicks on DownloadDetail button
 * 
 *author:ARCHANA ENTURU
 */








public  static void Click_DownloadDetail(){
	DownloadDetail().click();}


/**
 *  DownloadRemit Button object declaration
 * @return  DownloadRemit Button object
 *author:ARCHANA ENTURU
 */

public static Button DownloadRemit(){
	return new Button("//input[@name='DownloadRemit']");}



/**
 *clicks on DownloadRemit button
 * 
 *author:ARCHANA ENTURU
 */











public  static void Click_DownloadRemit(){
	DownloadRemit().click();}


/**
 * date from  TextField object declaration
 * @return date from  TextFieldobject
 *author:ARCHANA ENTURU
 */
public static TextField DR_From(){
	return new TextField("//input[@name='fromDate']");}

/**
 * date to TextField object declaration
 * @return date to  TextField object
 *author:ARCHANA ENTURU
 */
public static TextField DR_TO(){
	return new TextField("//input[@name='toDate']");}

/**
 *  Search_By TextField object declaration
 * @return  Search_By  TextField object
 *author:ARCHANA ENTURU
 */
public static TextField Search_By(){
	return new TextField("//*[@name='searchBy']");}

/**
 *  Enter date  into the DATE FROM textfield
 * @Param:  sDateFrom string text to enter into date from textfield.
 *author:ARCHANA ENTURU
 */



public  static void Enter_DR_From(String sDateFrom){
	DR_From().setText(sDateFrom);}

/**
 *   Enter TOdate into the DATE_TO textfield
 * @Param:  sDateTO string text to enter into (to_date ) textfield.
 *author:ARCHANA ENTURU
 */

public  static void Enter_DR_To(String sDateTO){
	DR_TO().setText(sDateTO);}
/**
 *  Enter search type of date  into : search textfield
 * @Param:  sText string text to enter into Search textfield.
 *author:ARCHANA ENTURU
 */

public  static void Enter_SearchText(String sText){
	Search_By().setText(sText);}


/**
 * All radioButton object declaration
 * @return All radioButton object
 *author:ARCHANA ENTURU
 */
public static RadioButton All(){
	return new RadioButton(" //input[@name='creditDebitIndicator' and @value='']");}


/**
 *clicks on All button
 * 
 *author:ARCHANA ENTURU
 */







public static void Click_All(){
	All().click();
}


/**
 * DebitCard RadioButton object declaration
 * @return DebitCard  Button object
 *author:ARCHANA ENTURU
 */
public static RadioButton DebitCard(){
	return new RadioButton("//input[@name='creditDebitIndicator' and @value='D']");}


/**
 *clicks on DebitCard button
 * 
 *author:ARCHANA ENTURU
 */







public static void Click_DebitCard(){
	DebitCard().click();}

/**
 * Credit_Card  Button object declaration
 * @return Credit_Card  Button object
 *author:ARCHANA ENTURU
 */
public static RadioButton Credit_Card(){
	return new RadioButton("//input[@name='creditDebitIndicator' and @value='C']");}



/**
 *clicks on Credit_Card button
 * 
 *author:ARCHANA ENTURU
 */







public static void Click_Credit_Card(){
	Credit_Card().click();}


/**
 *  Status TextField object declaration
 * @return Status  TextField object
 *author:ARCHANA ENTURU
 */
public static TextField Status(){
	return new TextField("//*[@name='displayPaymentStatus']");}



public static void enter_Status(String sText){
	Status().setText(sText);}


/**
 *  return code  TextField object declaration
 * @return return code  TextField object
 *author:ARCHANA ENTURU
 */
public static TextField Rcode(){
	return new TextField(" name=nachaReturnCode");}
public static void enter_Rcode(String sText){
	Rcode().setText(sText);}


/**
 *  resolve status TextField object declaration
 * @return resolve status TextField object
 *author:ARCHANA ENTURU
 */
public static TextField RStatus(){
	return new TextField("name=resolvedStatus");}

/**
 *  Enter status  into : status textfield
 * @Param:  sText string text to enter into status textfield.
 *author:ARCHANA ENTURU
 */


public static void enter_RStatus(String sText){
	RStatus().setText(sText);}

/**
 *  Funding TextField object declaration
 * @return  Funding TextField object
 *author:ARCHANA ENTURU
 */
public static TextField Funding(){
	return new TextField("//*[@name='displayFundingAccountType']");}


/**
 *  Enter funding type : Funding textfield
 * @Param:  sText string text to enter into Funding textfield.
 *author:ARCHANA ENTURU
 */


public static void enter_Funding(String sText){
	Funding().setText(sText);}

/**
 *  LoginId TextField object declaration
 * @return LoginId  TextField object
 *author:ARCHANA ENTURU
 */

public static TextField LoginId(){
	return new TextField("//*[@name='login']");}


/**
 *  Enter LoginId : LoginId textfield
 * @Param:  sText string text to enter into LoginId textfield.
 *author:ARCHANA ENTURU
 */

public static void enter_LoginId(String sText){
	LoginId().setText(sText);}

/**
 *  Team TextField object declaration
 * @return  Team  TextField object
 *author:ARCHANA ENTURU
 */
public static TextField Team(){
	return new TextField("//*[@name='login']");}


/**
 *  Enter Team : Team textfield
 * @Param:  sText string text to enter into Team textfield.
 *author:ARCHANA ENTURU
 */

public static void enter_Team(String sText){
	Team().setText(sText);}










}



















