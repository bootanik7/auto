package V4.Smoke.client_console.applibs;

import java.util.Map;

import V4.Smoke.otp.applibs.Common_Class;
import core.libs.SeleniumCore;
import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.ListBox;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;
import core.webwidgets.WebWidget;

public class ClientConsole_ACHPayementEntry_Page {

	/**
	 * Declaration for the cilent console main page for capturing the PayementEnteryPage visible  text
	 * @return Returns web UI object of specified type and definition 
	 */



	/**
	 * textfeild for entering the payment date in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static CheckBox CC_Email(){
		return new CheckBox("//*[@name='emailAddressFlag']");
	} 
	public static void click_CC_email(){
		CC_Email().click();

	}
	public static Boolean isEmailCheck_Present(){
		return  CC_Email().isVisible();}


	public static CheckBox CC_Invoice(){
		return new CheckBox("//*[@id='checkAll0']");
	} 
	public static void click_CC_Invoice(){
		CC_Invoice().click(); }
	public static Boolean isInvoicePresent(){
		return  CC_Invoice().isVisible();
	}




	public static CheckBox CC_Invoice1(){
		return new CheckBox("//*[@id='checkAll1']");
	}
	public static void click_CC_Invoice1(){
		CC_Invoice1().click(); }
	public static Boolean isInvoicePresent1(){
		return  CC_Invoice1().isVisible();
	}

	public static TextField Payment_Date1(){
		return new TextField("id=paymentsRequestedPaymentDateId1");
	}


	public static void Payment_DATE1(String Date){

		Payment_Date1().setText(Date);

	}


	public static CheckBox CC_Invoice2(){
		return new CheckBox("//*[@id='checkAll2']");
	}
	public static void click_CC_Invoice2(){
		CC_Invoice2().click(); }
	public static Boolean isInvoicePresent2(){
		return  CC_Invoice2().isVisible();
	}

	public static TextField Payment_Date2(){
		return new TextField("id=paymentsRequestedPaymentDateId2");
	}

	public static void Payment_DATE2(String Date){

		Payment_Date2().setText(Date);

	}



	public static CheckBox CC_Invoice3(){
		return new CheckBox("//*[@id='checkAll3']");
	}
	public static void click_CC_Invoice3(){
		CC_Invoice3().click(); }
	public static Boolean isInvoicePresent3(){
		return  CC_Invoice3().isVisible();
	}


	public static TextField Payment_Date3(){
		return new TextField("id=paymentsRequestedPaymentDateId3");
	}   


	public static void Payment_DATE3(String Date){

		Payment_Date3().setText(Date);

	}

	public static CheckBox CC_Invoice4(){
		return new CheckBox("//*[@id='checkAll4']");
	}
	public static void click_CC_Invoice4(){
		CC_Invoice4().click(); }
	public static Boolean isInvoicePresent4(){
		return  CC_Invoice4().isVisible();
	}

	public static TextField Payment_Date4(){
		return new TextField("id=paymentsRequestedPaymentDateId4");
	}
	public static void Payment_DATE4(String Date){

		Payment_Date4().setText(Date);

	}


	public static CheckBox CC_Invoice5(){
		return new CheckBox("//*[@id='checkAll5']");
	}
	public static void click_CC_Invoice5(){
		CC_Invoice5().click(); }
	public static Boolean isInvoicePresent5(){
		return  CC_Invoice5().isVisible();
	}

	public static TextField Payment_Date5(){
		return new TextField("id=paymentsRequestedPaymentDateId5");
	} 


	public static void Payment_DATE5(String Date){

		Payment_Date5().setText(Date);

	}

	public static boolean ispaymentdatepresent() {

		return  Payment_Date().isVisible();
	}


	public static TextField Payment_Date(){
		return new TextField("id=paymentsRequestedPaymentDateId0");
	}



	/**
	 * Button object for "PaymentEntry_Button_SeriesPymt" Button with locator of "//*[@value='Series of Payments']"
	 * @return web UI Button object for the "PaymentEntry_Button_SeriesPymt" Button with locator of "//*[@value='Series of Payments']"
	 */
	public static Button PaymentEntry_Button_SeriesPymt() {
		return new Button("//*[@value='Series of Payments']");
	}

	public static void click_PaymentEntry_Button_SeriesPymt(){
		PaymentEntry_Button_SeriesPymt().click();	
	}




	/**
	 * textfeild for entering the payment amount in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_Amount(){
		return new TextField("//*[@id='paymentsRemitAmountId0']");}

	/**
	 * textfeild for entering the payment fee in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_Fee(){
		return new TextField("[@id=paymentsRemitFeeId0");
	}
	/**
	 * textfeild for entering the payment total amount in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_Total(){
		return new TextField("id=payments0remitTotalAmountId");
	}
	/**
	 * textfeild for entering the exsting account info  in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Existing_PaymentInfo(){
		return new TextField("id=fundingAccountSelected");
	}
	/**
	 * textfeild for entering the type of account in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static TextField RoutingNumber(){
		return new TextField("name=bankAccount.routingNumber");}

	public static void Enter_Routing_Num(String sText){
		RoutingNumber().setText(sText);
	}


	public static ListBox Paymentaccount_Type(){
		return new ListBox("//*[@name='bankAccount.bankAccountType']");}
	/**
	 * textfeild for entering string of name on  funding in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static TextField Payment_Name_on_Fundin(){
		return new TextField("name=bankAccount.accountHolderName");}

	/**
	 * textfeild for entering bank account address in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static TextField TextBox_EmailAdd() {
		return new TextField("name=emailAddress");}

	public static void Enter_EmailId(String sText){
		TextBox_EmailAdd().setText(sText);
	}

	public static void clear_emailTextField(){
		TextBox_EmailAdd().clearText();
	}
	public static TextField Payment_BankAccountAdd(){
		return new TextField("name=bankAccount.accountAddress1");}

	/**
	 * textfeild for entering bank account address in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_bankAccAdd2(){
		return new TextField("name=bankAccount.accountAddress2");}

	/**
	 * textfeild for entering bank account city in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */


	public static TextField Payment_City(){
		return new TextField("name=bankAccount.accountCity");}
	/**
	 * textfeild for entering bank account address state in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_State(){
		return new TextField("name=bankAccount.accountState");}

	/**
	 * textfeild for entering bank account address zip in  PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField Payment_Zip(){
		return new TextField("name=bankAccount.accountPostalCode");}
	/**
	 *button to click on submit button in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static Button ProcessPayment_Button(){
		return new Button("id=submitBankButtonId");}
	/**
	 *button to click on Cancel button in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static Button Payment_Cancel(){
		return new Button("id=cancelBankButtonId");}

	/**
	 *button to click on deletefunding button   in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static Button Payment_DeleteFundingButton(){
		return new Button("//*[@value='Delete Funding']");}


	/**
	 *button to click on newBankAcoount button in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static Button PaymentEntryExistingFund_Button_NewBankAcct() {
		return new Button("//*[@value='New Bank Account']");}

	/**
	 *button to click on new card button  in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static void click_new_account(){
		PaymentEntryExistingFund_Button_NewBankAcct().click();}

	public static Button card_NewCard(){
		return new Button("//*[@value='New Card']");}

	public static void click_card_New(){
		card_NewCard().click();}


	public static TextField card_New_Number(){
		return new TextField("name=cardNumber");}

	/**
	 *enter the card number into the cardnum textfeild
	 * @parm cardNum :enter the card num itno the cardnum textfield 
	 * Enturu ARCHANA

	 */
	public static void Enter_CardNUM(String cardNum){
		card_New_Number().setText(cardNum);
	}

	/**
	 *button to validate the new card   in PayementEntry_Page 
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */

	public static Button ValidateNewCard(){
		return new Button(" //*[@value='Validate Card']");}

	/**
	 *clicks on the button validate the new card
	 *
	 * Enturu ARCHANA

	 */

	public static void Click_ValidateNewCard(){
		ValidateNewCard().click();
	}

	public static TextField New_account(){
		return new TextField("id=bankAccountNumber");}
	public static void enter_new_account_num(String sText ){
		New_account().setText(sText);
	}


	public static StaticText Process_Payment_ConfMsg(){
		return new StaticText("id=nachaAuthlanguageDialog");}

	/**
	 * Enters  payment date string in payement date  text field 
	 * @param Date - enter user date of payment into the payement date field
	 * @author Enturu ARCHANA
	 */


	public static void Payment_DATE(String Date){

		Payment_Date().setText(Date);

	}

	/**
	 * Enters  payment amount string in payement amount text field 
	 * @param amount  - enter amount of payment  into the payement amount field
	 * @author Enturu ARCHANA
	 */
	public static void enter_Payment_Amt(String amount){

		Payment_Amount().setText(amount);}



	public static boolean is_Payment_amt_txt_isVisiable(){
		return  Payment_Amount().isVisible();
	}
	/**
	 * Enters  fee  string in payement fee  text field 
	 * @param fee  - enter amount of payment  into the Entry_fee field
	 * @author Enturu ARCHANA
	 */


	public static void Payment_Entry_fee(String fee){

		Payment_Fee().setText(fee);}




	/**
	 * Enters total amount  string in total amount   text field 
	 * @param total   - enter total amount of payment  into the payement total amount field
	 * @author Enturu ARCHANA
	 */

	public static void Payment_Entry_Total(String total){

		Payment_Total().setText(total);}

	/**
	 * Enters accountnumber into accountnumber textfeild
	 * @paramAccountNum   - enter account number  into accountnumber text field
	 * @author Enturu ARCHANA
	 */
	public static void Payment_SelectAccount(String AccountNum){

		Existing_PaymentInfo().setText(AccountNum);}

	/**
	 * Enters type of Account  into accountType  textfeild
	 * @param AccountType  - enter account Type into selectAccounttype text field
	 * @author Enturu ARCHANA
	 */
	public static void Payment_enterAccountType(String AccountType){

		Paymentaccount_Type().selectItem(AccountType);}


	/**
	 * Enters name of the account  into accountname  textfeild
	 * @param AccountName - enter account name  into accountname  text field
	 * @author Enturu ARCHANA
	 */

	public static void Payment_AccountName(String AccountName){

		Payment_Name_on_Fundin().setText(AccountName);}

	/**
	 * Enters address of the account  into accountAddress   textfeild
	 * @param address - enter address  Type into enter account address  text field
	 * @author Enturu ARCHANA
	 */



	public static void Payment_Account_ADDRESS(String address){

		Payment_BankAccountAdd().setText(address);}

	/**
	 * Enters account address in the  textfeild
	 * @param addressL - enter address string  into address line text field
	 * @author Enturu ARCHANA
	 */


	public static void Payment_Account_ADDRESSLN2(String addressL){
		Payment_bankAccAdd2().setText(addressL);}

	/**
	 * Enters  city string  into City    textfeild
	 * @param city - enter city  into  city   text field
	 * @author Enturu ARCHANA
	 */


	public static void ADDRESS_city(String city){

		Payment_City().setText(city);}

	/**
	 * Enters  state string  into state    textfeild
	 * @param city - enters state into  state  text field
	 * @author Enturu ARCHANA
	 */


	public static void ADDRESS_State(String state){

		Payment_State().setText(state);}

	/**
	 * Enters  Zip string  into zip    textfeild
	 * @param city - enters zip into zip  text field
	 * @author Enturu ARCHANA
	 */

	public static void ADDRESS_Zip(String Zip){

		Payment_Zip().setText(Zip);}
	/**
	 * clicks on the button process payments
	 *
	 * @author Enturu ARCHANA
	 */



	public static void click_Process_Payments(){

		ProcessPayment_Button().click();}
	/**
	 * clicks on cancel button: cilent console paymentEntery page
	 * 
	 * @author Enturu ARCHANA
	 */


	public static void cancel(){

		Payment_Cancel().click();}




	public static Button ManageTransaction_Button_ModifyPmt() {
		return new Button("//*[@value='Modify Payment']");
	}


	public static void click_ManageTransaction_Button_ModifyPmt(){

		ManageTransaction_Button_ModifyPmt() .click();}

	/**
	 *captures the nacha conformation msg from the UI
	 * 
	 * @author Enturu ARCHANA
	 */

	public static String  get_NachaconfMsg(){

		String conF_Nacha=Process_Payment_ConfMsg().getText();
		return conF_Nacha;
	}
	public static Button nacha_yes_btn(){
		return new Button("//*[contains(text(),'Yes')]");}
	public static void btnYes(){

		nacha_yes_btn().click();}

	public static Button nacha_NO_btn(){
		return new Button("//*[contains(text(),'No')]");}
	public static void btnNO(){

		nacha_NO_btn().click();}


	public static Button PaymentEntryBankPymt_Button_ProcessPmt() {
		return new Button("//*[@name='ProcessPayments']");
	}

	public static void click_PaymentEntryBankPymt_Button_ProcessPmt(){

		PaymentEntryBankPymt_Button_ProcessPmt().click();}   





	public static void Common_payments_Entry_Details(Map<String,String> sd,String types){


		ClientConsole_ACHPayementEntry_Page.clear_emailTextField();
		if(ClientConsole_ACHPayementEntry_Page.isEmailCheck_Present()){

			ClientConsole_ACHPayementEntry_Page.click_CC_email();
		}

		if(ClientConsole_ACHPayementEntry_Page.isInvoicePresent())
		{
			ClientConsole_ACHPayementEntry_Page.click_CC_Invoice();
		}
		else {
			if(ClientConsole_ACHPayementEntry_Page.Payment_Amount().isEditable()){
			ClientConsole_ACHPayementEntry_Page.enter_Payment_Amt(sd.get("Amount Due"));
			}
		}
		/*
     		if(ClientConsole_ACHPayementEntry_Page.isSelectFee_Visible()){
     			if()
    			ClientConsole_ACHPayementEntry_Page.Select_Fee(sd.get("Fee"));
    		}
    		
		 */
		if(ClientConsole_ACHPayementEntry_Page.isFee_Waive_Reason_Visible()){
			ClientConsole_ACHPayementEntry_Page.Select_Fee_Waive_Reason(sd.get("Fee Waive Reason"));
		}
		
		String date= Common_Class.getsystemdate();
		ClientConsole_ACHPayementEntry_Page.Payment_DATE(date);


	}


	public static void ACH_Payment_Entry_details(Map<String,String> sd,String ACH_types) throws InterruptedException
	{

		Common_payments_Entry_Details(sd, ACH_types);

		Thread.sleep(2000);

		ClientConsole_ACHPayementEntry_Page.click_new_account();

		if(ACH_types.contains("Business Savings"))
		{

			ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Business Savings");

		}
		else if(ACH_types.contains("Business Checking")) 
		{

			ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Business Checking");

		}
		else if(ACH_types.contains("Personal Savings"))
		{

			ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Personal Savings");

		}
		else if(ACH_types.contains("Personal Checking")) 
		{

			ClientConsole_ACHPayementEntry_Page.Payment_enterAccountType("Personal Checking");
		}

		ClientConsole_ACHPayementEntry_Page.Enter_Routing_Num(sd.get("Routing Number"));
		ClientConsole_ACHPayementEntry_Page.enter_new_account_num(sd.get("Bank Account Number"));

		ClientConsole_ACHPayementEntry_Page.Payment_AccountName(sd.get("Account_name"));
		ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESS(sd.get("address1"));
		ClientConsole_ACHPayementEntry_Page.Payment_Account_ADDRESSLN2(sd.get("address2"));
		ClientConsole_ACHPayementEntry_Page.ADDRESS_city(sd.get("city"));
		ClientConsole_ACHPayementEntry_Page.ADDRESS_State(sd.get("State"));
		ClientConsole_ACHPayementEntry_Page.ADDRESS_Zip(sd.get("Postal Code"));
		ClientConsole_ACHPayementEntry_Page.click_Process_Payments();
		Thread.sleep(2000);
		String Nach_conf=ClientConsole_ACHPayementEntry_Page.get_NachaconfMsg();
		ClientConsole_ACHPayementEntry_Page.btnYes();
	}


	public static ListBox Fee() {
		return new ListBox("//*[@id='paymentsRemitFeeId0']");

	}
	public static void Select_Fee(String sItem){
		Fee().selectItem(sItem);}

	public static Boolean isSelectFee_Visible(){
		return  Fee().isVisible();}


	public static ListBox Fee_Waive_Reason(){
		return new  ListBox("//*[@id='paymentsFeeWaiverReasonId0']");

	}
	public static void Select_Fee_Waive_Reason(String sItem){
		Fee_Waive_Reason().selectItem(sItem);}


	public static Boolean isFee_Waive_Reason_Visible(){
		return  Fee_Waive_Reason().isVisible();}


	public static void Modify_Common_Fun(Map<String,String> sd,String Type,String getconfirmation) throws InterruptedException{
		Management_transcation_page.click_HomePage_Link_MngTran();
		System.out.println(SeleniumCore.driver.getTitle());
		Management_transcation_page.Enter_Conf_Num(getconfirmation);
		Management_transcation_page.clickSearch();
		System.out.println(SeleniumCore.driver.getTitle());
		Thread.sleep(2000);
		Management_Transcation_SearchPage.Click_PendingRadioButton();
		Management_Transcation_SearchPage.Click_ViewTran();
		System.out.println(SeleniumCore.driver.getTitle());
		ClientConsole_payment_entry_page.click_ModfyTran();
	}
	
	/*public static String GetPageErrorMessage(){
		SeleniumCore.getBrowser().getElement(byLocator, timeOut)
		WebWidget message = new WebWidget("","P","body-validation-error") ; 
		String text = message.getText();
		
		
		//p[@class='body-validation-error']
	}*/

}






