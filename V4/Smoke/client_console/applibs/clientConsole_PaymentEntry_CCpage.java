package V4.Smoke.client_console.applibs;

import java.util.Map;

import V4.Smoke.client_console.scripts.ClientConsole_login;
import core.webwidgets.Button;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;


public class clientConsole_PaymentEntry_CCpage {

	static String getconfirmation;



	public static ListBox CCType(){
		return new ListBox("//*[@name='creditCardAccount.creditCardType']");
	}
	/**
	 * enter the credit name into the creditcard type feild
	 * @param:ccnam enter the creditcard type in to textfield
	 * author:archana enturu
	 */
	public static  void select_ccType(String ccname){
		CCType().selectItem(ccname);
	}









	/**
	 * Text field   to enter the credit card exp date int the exp text field
	 *author:archana enturu
	 */


	public static TextField Name_On_card() {
		return new TextField("//*[@name='creditCardAccount.accountHolderName']");
	}


	public static  void Enter_Name_On_card(String cardname){
		Name_On_card().setText(cardname);}



	public static Boolean is_card_type_listBox_present(){
		return CCType().isVisible();}







	public static ListBox DDcreditcrdexpmnth() {
		return new ListBox("//*[@name='creditCardAccount.expirationMonth']");
	}

	/**
	 * Text field   to enter the credit card exp date int the exp text field
	 * author:archana enturu
	 */

	public static  void Enter_crdexpMnth(String expMnth){
		DDcreditcrdexpmnth().selectItem(expMnth);}



	public static Boolean iscreditCard_ExpMonth_Present(){
		return DDcreditcrdexpmnth().isVisible();}





	public static TextField clientconsole_creditcard_City(){
		return new TextField("//*[@name='creditCardAccount.accountCity']");}


	/**
	 * textfeild for entering bank account address state in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField clientconsole_creditcard_State(){
		return new TextField("name=creditCardAccount.accountState");}

	/**
	 * textfeild for entering bank account address zip in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField clientconsole_creditcard_Zip(){
		return new TextField(" //*[@name='creditCardAccount.accountPostalCode']");}
	/**
	 * Text field   to enter the credit card exp year into the exp year text field
	 * author:archana enturu
	 */

	public static ListBox DDcreditcrdexpYear() {
		return new  ListBox ("//*[@name='creditCardAccount.expirationYear']");
	}







	/**
	 * Enter the credit card exp date (year) into the text field
	 * @param:expYear enter the expdate string into the field
	 * author:archana enturu
	 */


	public static  void Enter_crdexpYear(String expYear){
		DDcreditcrdexpYear().selectItem(expYear);}




	public static Boolean iscreditCardExpPresent(){
		return DDcreditcrdexpYear().isVisible();
	}
	/**
	 * Text field   to enter the credit cardCvv into cvv textfield
	 * author:archana enturu
	 */

	public static TextField DDcreditcrdCVV() {
		return new TextField("//*[@name='creditCardAccount.securityCode']");
	}

	/**enters the cvv number into the cvv textfield
	 * @param:cvv string to enter cvv number into field
	 * author:archana enturu
	 */

	public static  void Enter_crdCVV(String CVV){
		DDcreditcrdCVV().setText(CVV);}





	public static Boolean isCard_CVV_present(){
		return DDcreditcrdCVV().isVisible();}








	/**button to click on process pay
	 * 
	 * author:archana enturu
	 */

	public static Button Process_Pay() {
		return new Button("id=submitButtonId");
	}

	/**clicks on rthe button process pay
	 *
	 * author:archana enturu
	 */
	public static  void click_ProcessPay(){
		Process_Pay().click();}

	public static void enter_creditcardPayment_city(String city){

		clientconsole_creditcard_City() .setText(city);}

	/**
	 * Enters  state string  into state    textfeild
	 * @param city - enters state into  state  text field
	 * @author Enturu ARCHANA
	 */


	public static void enter_creditcardPayment_State(String state){

		clientconsole_creditcard_State().setText(state);}

	/**
	 * Enters  Zip string  into zip    textfeild
	 * @param city - enters zip into zip  text field
	 * @author Enturu ARCHANA
	 */

	public static void enter_creditcardPayment_Zip(String Zip){

		clientconsole_creditcard_Zip().setText(Zip);}





	public static TextField PaymentEntryDCPymt_TextBox_Add1() {
		return new TextField("//*[@name='debitCardAccount.accountAddress1']");
	}


	public static void Enter_PaymentEntryDCPymt_TextBox_Add1(String sText){
		PaymentEntryDCPymt_TextBox_Add1().setText(sText);
	}

public static Boolean is_PaymentEntryDCPymt_TextBox_Add1_Present(){
	return PaymentEntryDCPymt_TextBox_Add1().isVisible();
}


	public static TextField PaymentEntryDCPymt_TextBox_Add2() {
		return new TextField("//*[@name='debitCardAccount.accountAddress2']");
	}

	public static void Enter_PaymentEntryDCPymt_TextBox_Add2(String sText){
		PaymentEntryDCPymt_TextBox_Add2().setText(sText);}

	public static boolean is_PaymentEntryDCPymt_TextBox_Add2_Present(){
		return PaymentEntryDCPymt_TextBox_Add2().isVisible();
	}


	public static TextField PaymentEntryDCPymt_TextBox_City() {
		return new TextField("//*[@name='debitCardAccount.accountCity']");
	}

	public static void Enter_PaymentEntryDCPymt_TextBox_City(String sText){
		PaymentEntryDCPymt_TextBox_City().setText(sText);}



	public static TextField PaymentEntryDCPymt_TextBox_State() {
		return new TextField("//*[@name='debitCardAccount.accountState']");
	}


	public static void Enter_PaymentEntryDCPymt_TextBox_State(String sText){
		PaymentEntryDCPymt_TextBox_State().setText(sText);}



	public static TextField PaymentEntryDCPymt_TextBox_Zip() {
		return new TextField("//*[@name='debitCardAccount.accountPostalCode']");
	}


	public static void Enter_PaymentEntryDCPymt_TextBox_Zip(String sText){
		PaymentEntryDCPymt_TextBox_Zip().setText(sText);}


	public static TextField PaymentEntryDCPymt_TextBox_NameOnCard() {
		return new TextField("//*[@name='debitCardAccount.accountHolderName']");
	}



	public static void Enter_PaymentEntryDCPymt_TextBox_NameOnCard(String sText){
		PaymentEntryDCPymt_TextBox_NameOnCard().setText(sText);}


	public static Button PaymentDCPymtConfirmation_Button_Yes() {
		return new Button("//*[contains(text(),'Yes')]");

	}
	public static void click_PaymentDCPymtConfirmation_Button_Yes(){
		PaymentDCPymtConfirmation_Button_Yes().click();}

public static Boolean is_debit_nacha_conf_Present(){
	return PaymentDCPymtConfirmation_Button_Yes().isVisible();
}


	public static void ClientConsole_CC_PaymnetDetails(Map<String,String> sd,String CC_Type) throws InterruptedException{

		ClientConsole_ACHPayementEntry_Page.Common_payments_Entry_Details(sd, CC_Type);
		ClientConsole_ACHPayementEntry_Page.click_card_New();
		ClientConsole_ACHPayementEntry_Page.Enter_CardNUM(sd.get("CARD_NUMBER"));
		ClientConsole_ACHPayementEntry_Page.Click_ValidateNewCard();

		if(sd.get("CARD").equals("Credit")){
			clientConsole_PaymentEntry_CCpage.select_ccType(sd.get("CARD_TYPE"));
			clientConsole_PaymentEntry_CCpage.Enter_crdexpMnth(sd.get("Expry_Month"));
			clientConsole_PaymentEntry_CCpage.Enter_crdexpYear(sd.get("Expry_Year"));
			clientConsole_PaymentEntry_CCpage.Enter_crdCVV(sd.get("Card_CVV"));
			clientConsole_PaymentEntry_CCpage.Enter_Name_On_card(sd.get("ACCOUNT_HOLDER_NAME"));
			clientConsole_PaymentEntry_CCpage.enter_creditcardPayment_city(sd.get("City"));
			clientConsole_PaymentEntry_CCpage.enter_creditcardPayment_State(sd.get("State"));
			clientConsole_PaymentEntry_CCpage.enter_creditcardPayment_Zip(sd.get("zip"));
			clientConsole_PaymentEntry_CCpage.click_ProcessPay();	
			if(clientConsole_PaymentEntry_CCpage.is_debit_nacha_conf_Present()){
				clientConsole_PaymentEntry_CCpage.click_PaymentDCPymtConfirmation_Button_Yes();
			}
			String Payment_confNum = ClientConsole_login.confirmation_number();
			 getconfirmation = Payment_confNum.replaceAll("\\D", "");
		}
		else{
			//clientConsole_PaymentEntry_CCpage.select_ccType(sd.get("CARD_TYPE"));
		   if(clientConsole_PaymentEntry_CCpage.isCard_CVV_present()){
			clientConsole_PaymentEntry_CCpage.Enter_crdCVV(sd.get("Card_CVV"));
		}
		 
			clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_NameOnCard(sd.get("ACCOUNT_HOLDER_NAME"));
			
			
			if(clientConsole_PaymentEntry_CCpage.is_PaymentEntryDCPymt_TextBox_Add1_Present()){
				clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_Add1(sd.get("add1"));
			}
			if(clientConsole_PaymentEntry_CCpage.is_PaymentEntryDCPymt_TextBox_Add2_Present()){
			clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_Add2(sd.get("add2"));
			}
			clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_City(sd.get("City"));
			clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_State(sd.get("State"));
			clientConsole_PaymentEntry_CCpage.Enter_PaymentEntryDCPymt_TextBox_Zip(sd.get("ACCOUNT_POSTAL_CODE"));
			clientConsole_PaymentEntry_CCpage.click_ProcessPay();
			if(clientConsole_PaymentEntry_CCpage.is_debit_nacha_conf_Present()){
				clientConsole_PaymentEntry_CCpage.click_PaymentDCPymtConfirmation_Button_Yes();
			}
			
			String Payment_confNum = ClientConsole_login.confirmation_number();
			getconfirmation = Payment_confNum.replaceAll("\\D", "");
			
		}


	}
}







