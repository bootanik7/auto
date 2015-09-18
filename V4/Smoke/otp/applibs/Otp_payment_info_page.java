package V4.Smoke.otp.applibs;


import java.util.Map;

import core.libs.Platform;
import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.ListBox;
import core.webwidgets.RadioButton;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;

/**
 * Payment Info Main page UI library
 * <p>
 * This class contains definitions for all Payment Main page UI objects like Search button
 * and search text field, etc. as well as methods to drive Payment UI 
 * 
 * @author Parvat Patil
 */
public class Otp_payment_info_page {

	/**
	 * Object Class Type Not found object for "RBBS" Object Class Type Not found with locator of "//*[@value='BUSINESS SAVINGS']"     * @return web UI Object Class Type Not found object for the "RBBS" Object Class Type Not found with locator of "//*[@value='BUSINESS SAVINGS']"
	 * @return web UI Object TextField for the "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 */
	public static RadioButton Personal_Savings() {
		return new RadioButton("//*[@value='PERSONAL SAVINGS'and @name='bankAccount.bankAccountType']");
	}

	/**
	 * Object Class TextField for "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 * @return web UI Object TextField for the "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 */
	public static RadioButton Businescheckings() {
		return new RadioButton("//*[@value='BUSINESS CHECKING' and @name='bankAccount.bankAccountType']");
	}

	/**
	 * Object Class RadioButton found with locator of "//*[@value='BUSINESS SAVINGS']" 
	 * @return web UI Object Class RadioButton object for the "BUSINESS SAVINGS" 
	 */
	public static RadioButton Businessavings() {
		return new RadioButton("//*[@value='BUSINESS SAVINGS'and @name='bankAccount.bankAccountType']");
	}
	/**
	 * Object Class RadioButton found with locator of "//*[@value='PERSONAL CHECKING']" 
	 * @return web UI Object Class RadioButton object for the "PERSONAL CHECKING" 
	 */

	public static RadioButton Personalcheckings() {
		return new RadioButton("//*[@value='PERSONAL CHECKING' and @name='bankAccount.bankAccountType']");
	}



	/**
	 * Object Class TextField for "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 * @return web UI Object TextField for the "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 */

	public static CheckBox Invoice() {
		return new CheckBox("name=checkAll");
	}

	/**
	 * Object Class TextField for "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 * @return web UI Object TextField for the "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 */
	public static CheckBox individualcheck() {

		return new CheckBox("name=checkAll");
	}



	/**
	 * Object Class TextField for "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 * @return web UI Object TextField for the "TBnameonfunding" Object Class Type Not found with locator of "//*[@name='bankAccount.accountHolderName']"
	 */
	public static TextField TBnameonfunding() {
		return new TextField("//*[@name='bankAccount.accountHolderName']");
	}

	/**
	 * Object Class TextField "TBABA" Object Class Type Not found with locator of "//*[@name='bankAccount.routingNumber']"
	 * @return web UI Object Class Type Not found object for the "TBABA" Object Class Type Not found with locator of "//*[@name='bankAccount.routingNumber']"
	 */
	public static TextField TABA() {
		return new TextField("//*[@name='bankAccount.routingNumber']");
	}



	/**
	 * TextField for "TBDDA" Object Class Type Not found with locator of "//*[@name='bankAccount.bankAccountNumber']"
	 * @return web UI Object Class Type Not found object for the "TBDDA" Object Class Type Not found with locator of "//*[@name='bankAccount.bankAccountNumber']"
	 */
	public static TextField TBDDA() {
		return new TextField("//*[@name='bankAccount.bankAccountNumber']");
	}

	/**
	 * ListBox for "ACH_State" Object Class Type Not found with locator of "//*[@name='bankAccount.accountState']"
	 * @return web UI Object Class Type Not found object for the "ACH_State" Object Class Type Not found with locator of "//*[@name='bankAccount.accountState']"
	 */
	public static ListBox ACH_State() {
		return new ListBox("//*[@name='bankAccount.accountState']");
	}
	/**
	 * TextField for "FundinZip" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountPostalCode']"
	 * @return web UI Object Class Type Not found object for the "FundinZip" TextField with locator of "//*[@name='fundingAccount.accountPostalCode']"
	 */
	public static TextField BankZip() {
		return new TextField("//*[@name='bankAccount.accountPostalCode']");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static TextField TBpmtreqdate() {
		return new TextField("//*[@name='payment.requestedPaymentDate']");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static TextField Amount() {
		return new TextField("id=paymentRemitAmountId");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static StaticText fee() {
		return new StaticText("id=feeamount");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static TextField Email() {
		return new TextField ("id=emailAddress");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static TextField Confirmemails() {
		return new TextField("id=confirmEmailAddress");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static Button submit() {
		return new Button("id=submitBtnId");
	}

	/**
	 * TextField for "TBpmtreqdate" Object Class Type Not found with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI Object Class Type Not found object for the "TBpmtreqdate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static Button cancel() {
		return new Button("class=button_sec");
	}


	/**
	 * Object Class CheckBox for "termsAndConditions" Object Class Type CheckBox with locator of ("//*[@name='termsAndConditions']")
	 * @return web UI Object CheckBox for the "termsAndConditions" Object Class Type Not found with locator of ("//*[@name='termsAndConditions']")
	 */
	public static CheckBox CBtermsAndConditions() {
		return new CheckBox("//*[@name='termsAndConditions']");
	}


	/**
	 * Object Class Type Button for "Btnconfirm" Object Class Type Button with locator of "//*[@value='Confirm']"
	 * @return web UI Object Class Type Button for the "Btnconfirm" Object Class Type Button locator of "//*[@value='Confirm']"
	 */
	public static Button Btnconfirm() {
		return new Button("//*[@value='Confirm']");
	}

	/**
	 *checkBox for disabling the disaggring to enter the email id
	 * @return Returns web UI object of specified type and definition 
	 */
	public static CheckBox CBemailflag() {
		return new CheckBox("//*[@name='emailAddressFlag']");
	}

	/**
	 * Object Class Type Not found object for "Btncontinue" Object Class Type Not found with locator of "//*[@value='Continue']"
	 * @return web UI Object Class Type Not found object for the "Btncontinue" Object Class Type Not found with locator of "//*[@value='Continue']"
	 */
	public static Button Btncontinue() {
		return new Button("//*[@value='Continue']");
	}



	public static boolean isCheckInvoicePresent(){
		return Invoice().isVisible();
	}

	public static void checkinvoice() {
		Invoice().check();
	}


	public static void click_personal_savings() {
		Personal_Savings().click();
	}
	public static void click_business_checkings() {
		Businescheckings().click();
	}
	public static void click_business_savings() {
		Businessavings().click();
	}
	public static void click_personal_checkings() {
		Personalcheckings().click();
	}

	public static boolean ispersonal_checking(){

		return Personalcheckings().isVisible();

	}

	public static boolean isBusiness_checking(){

		return Businescheckings().isVisible();

	}

	public static boolean isBusiness_savings(){

		return Businessavings().isVisible();

	}

	public static boolean ispersonal_savings(){

		return Personal_Savings().isVisible();

	}




	public static void Enter_name_funding(String Name_funding) {
		TBnameonfunding().setText(Name_funding);

	}

	public static void Enter_routing_number(String Routing_number) {
		TABA().setText(Routing_number);

	}



	public static void Enter_DDA_Number(String DDA_number) {
		TBDDA().setText(DDA_number);

	}

	public static void Select_Account_state(String ACH_State) {
		ACH_State().selectItem(ACH_State);

	}
	public static void Enter_Bank_Zip(String Bank_Zip) {
		BankZip().setText(Bank_Zip);

	} 

	public static boolean ispaymentdatepresent() {

		return TBpmtreqdate().isVisible();
	}

	public static void select_request_date(String Date) {
		TBpmtreqdate().setText(Date);

	} 

	public static String Getamount() {
		return Amount().getText();

	} 
	public static String GetFee() {
		return fee().getText();
	} 

	public static void Enter_email_address(String Email_Add) {
		Email().setText(Email_Add);
	} 

	public static void Confirm_email_address(String Confirm_email_add) {
		Confirmemails().setText(Confirm_email_add);
	} 


	public static void click_on_submit() {
		submit().click();
	} 
	public static void click_on_cancel() {
		cancel().click();
	} 

	public static void EmailFlag() {
		CBemailflag().check();
	}

	public static void buttonContinue() {
		Btncontinue().click();
	}

	public static void proceedpayment(Map<String,String>sd,String ACH_types) throws InterruptedException{

		if(Otp_payment_info_page.isCheckInvoicePresent())
		{
			Otp_payment_info_page.checkinvoice();
		}
		else {
			Otp_CreditCardPayementPage.EnterPaymentAmount(sd.get("Amount Due"));
		}
		if(ACH_types.contains("Business Savings"))
		{

			Otp_payment_info_page.click_business_savings();

		}
		else if(ACH_types.contains("Business Checking")) 
		{

			Otp_payment_info_page.click_business_checkings();

		}
		else if(ACH_types.contains("Personal Savings"))
		{

			Otp_payment_info_page.click_personal_savings();

		}
		else if(ACH_types.contains("Personal Checking")) 
		{

			Otp_payment_info_page.Personalcheckings();
		}

		Otp_payment_info_page.Enter_name_funding(sd.get("Account_name"));

		Otp_payment_info_page.Select_Account_state(sd.get("State"));

		Otp_payment_info_page.Enter_Bank_Zip(sd.get("Postal Code"));

		Otp_payment_info_page.Enter_routing_number(sd.get("Routing Number"));

		Otp_payment_info_page.Enter_DDA_Number(sd.get("Bank Account Number"));

		String date= Common_Class.getsystemdate();

		if(Otp_payment_info_page.ispaymentdatepresent())
		{
			Otp_payment_info_page.select_request_date(date);
		}
		Otp_payment_info_page.Enter_email_address(sd.get("Email Address"));

		Otp_payment_info_page.Confirm_email_address(sd.get("Email Address"));

		Otp_payment_info_page.buttonContinue();

	}

}
