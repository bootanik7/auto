package V4.Smoke.otp.applibs;

import java.util.Map;

import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class Otp_CreditCardPayementPage {


	/**
	 * Declaration for the verifying the user account details on the  Otp paymentinfoPage
	 * @return Returns web UI object of specified type and definition 
	 * Enturu ARCHANA
	 */
	public static TextField visibleText(){

		return new TextField("//span[@id='accountholdertier']");
	}

	/**
	 * listBox for selecting the type of card from the drop down in credit card Paymentpage:
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static ListBox Credit_Card_TypeType() {
		return new ListBox(".//*[@name='creditCardAccount.creditCardType']");
	}
	/**
	 * TextField  for writing the credit card name 
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static TextField Credit_Card_Name() {
		return new TextField("//input[@id='creditcard_name']");
	}
	/**
	 * TextField  for writing the card_Zip
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static TextField Credit_Card_Zip(){
		return new TextField("//input[@id='zipcode']");
	}

	/**
	 * TextField  for writing the credit card number
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static TextField  Credit_Card_Num() {
		return new TextField("//*[@id='cardnumber']");

	}
	/**
	 * ListBox  for selecting  the credit ExpirationDate
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static ListBox Credit_Car_ExpirationDate_Mon() {
		return new ListBox("//*[@id='expirationmonth']");

	}
	/**
	 *TextField  for writing  the credit cvv number
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static ListBox Credit_Car_ExpirationDate_Year() {
		return new ListBox("//*[@title='expirationyear']");
	}
	public static TextField  Credit_Card_SecurityValue() {
		return new TextField("//input[@id='cvv']");

	}

	/**
	 *Button for clicking on continue in credit card payment page
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static Button Btncontinue() {
		return new Button("//*[@value='Continue']");
	}

	/**
	 *TextField  for writing  the Payment amount
	 * @return Returns web UI object of specified type and definition 
	 */
	public static TextField Payment_Amount() {
		return new TextField("//*[@name='payment.remitAmount']");
	}


	/**
	 *checkBox for disabling the disaggring to enter the email id
	 * @return Returns web UI object of specified type and definition 
	 * author:Enturu ARCHANA
	 */
	public static CheckBox CBemailflag() {
		return new CheckBox("//*[@name='emailAddressFlag']");
	}

	public static void EnterCreditdCardType(String credit_name){

		Credit_Card_TypeType().selectItem(credit_name);
	}

	public static void EnterPaymentAmount(String Amount){
		Payment_Amount().setText(Amount);

	} 

	public static void EnterCreditCardName(String enter_name){
		Credit_Card_Name().setText(enter_name);	   
	}
	public static void EnterCreditCardZip(String Zip){
		Credit_Card_Zip().setText(Zip);	 
	}
	
	public static boolean isCvvpresent(){
		return Credit_Card_SecurityValue().isVisible();	
	}
	public static void EnterCreditCardCvv(String Card_Cvv){
		Credit_Card_SecurityValue().setText(Card_Cvv);	
	}
	public static void EnterCreditCardExpDate_Mon(String Card_ExpDate_Mon){
		Credit_Car_ExpirationDate_Mon().selectItem(Card_ExpDate_Mon);	 

	}
	
	public static void EnterCreditcardnum(String sText) {
		Credit_Card_Num().setText(sText);
	}
	public static void EnterCreditCardExpDateDay_Year(String Card_ExpDateYear){
		Credit_Car_ExpirationDate_Year().selectItem(Card_ExpDateYear);	
	}

	public static void CheckOnEmail(){
		CBemailflag() .click();
	}
	public static void Click_Continue(){
		Btncontinue().click();
	}

	
	public static void Entercard_details(Map<String,String>sd, String CC_Types) throws InterruptedException{
		
		if(otp_CreditCardEntryPAge.isCreditcardnumebrtextpresent())
		{
            
		 otp_CreditCardEntryPAge.Entercardnumber(sd.get("CARD_NUMBER"));

		} else 
		{

			Otp_CreditCardPayementPage.EnterCreditcardnum(sd.get("CARD_NUMBER"));
		}

		Thread.sleep(2000);

		if(Otp_payment_info_page.isCheckInvoicePresent())
		{

			Otp_payment_info_page.checkinvoice();

		} else 
		{

			Otp_CreditCardPayementPage.EnterPaymentAmount(sd.get("Amount Due"));
		}

		Otp_CreditCardPayementPage.EnterCreditdCardType(sd.get("CARD_TYPE"));

		Otp_CreditCardPayementPage.EnterCreditCardName(sd.get("ACCOUNT_HOLDER_NAME"));

		Otp_CreditCardPayementPage.EnterCreditCardZip(sd.get("ACCOUNT_POSTAL_CODE"));

		Otp_CreditCardPayementPage. EnterCreditCardExpDate_Mon("12");

		Otp_CreditCardPayementPage.EnterCreditCardExpDateDay_Year(sd.get("Expiry year"));

		if(sd.get("CARD").equals("Credit")){
			{
				if(CC_Types!="AMEX")
				{
					Otp_CreditCardPayementPage.EnterCreditCardCvv(sd.get("cvv"));
				}else 
				{
					Otp_CreditCardPayementPage.EnterCreditCardCvv(sd.get("cvv"));
				}
			}
		}
		String date= Common_Class.getsystemdate();

		Otp_payment_info_page.select_request_date(date);

		Otp_payment_info_page.Enter_email_address(sd.get("Email Address"));

		Otp_payment_info_page.Confirm_email_address(sd.get("Email Address"));

		Otp_payment_info_page.buttonContinue();
	}
}


