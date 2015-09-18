package V4.Smoke.enrollment.applibs;

import java.util.Map;

import V4.Smoke.otp.applibs.Common_Class;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class Erm_PayYourBillNow_Debit_Card_EPI_Page
{

	
	
	/**
	 * TextField object for "PayYourBillow_TextBox_Nameof_CreditCard_No" TextField with locator of ("name=creditCardAccount.accountHolderName")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Nameof_CreditCard_No" TextField with locator of ("name=creditCardAccount.accountHolderName")
	 */
	public static TextField PayYourBillNow_NameOnDebitCard()
	{
		return new TextField("name=debitCardAccount.accountHolderName");
	}
	public static void Enter_NameOnDebitCard(String s)
	{
		 PayYourBillNow_NameOnDebitCard().setText(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_Zipcode" TextField with locator of ("name=creditCardAccount.accountPostalCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Zipcode" TextField with locator of ("name=creditCardAccount.accountPostalCode")
	 */
	public static TextField PayYourBillNow_Debit_Zipcode()
	{
		return new TextField("name=debitCardAccount.accountPostalCode");
	}
	public static void Enter_Zipcode(String s)
	{
		PayYourBillNow_Debit_Zipcode().setText(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 */
	public static ListBox PayYourBillNow_DropDown_DebitCardState() 
	{
		return new ListBox("name=debitCardAccount.accountState");
	}
	public static void select_DebitCardState(String s)
	{
		PayYourBillNow_DropDown_DebitCardState().selectItem(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCard_Country" ListBox with locator of "name=creditCardAccount.accountCountryCode"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCard_Country" ListBox with locator of "name=creditCardAccount.accountCountryCode"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCard_Country() 
	{
		return new ListBox("name=debitCardAccount.accountCountryCode");
	}
	public static void select_DebitCard_Country(String s)
	{
		PayYourBillNow_DropDown_CreditCard_Country().selectItem(s);
	}
    
	
	public static void Enter_DC_payment_details(Map<String,String> Ed)
	{
		
	if(Erm_PayYourBillNow_EPI_Page.isInvoicePresent1())
	 {
		 Erm_PayYourBillNow_EPI_Page.click_Erm_Invoice1();
	 }
	 else
	 {
		Erm_PayYourBillNow_EPI_Page.click_on_OthersAmout();
	    Erm_PayYourBillNow_EPI_Page.PayYourBillNow_Enter_Amount(Ed.get("Amount"));	 
	 }
    Erm_PayYourBillNow_EPI_Page.PmtReqDate(Common_Class.getsystemdate());
	 Erm_PayYourBillNow_Debit_Card_EPI_Page.Enter_NameOnDebitCard(Ed.get("ACCOUNT_HOLDER_NAME"));
	 Erm_PayYourBillNow_Debit_Card_EPI_Page.Enter_Zipcode(Ed.get("ACCOUNT_POSTAL_CODE"));
	 Erm_PayYourBillNow_Debit_Card_EPI_Page.select_DebitCardState(Ed.get("State"));
	 Erm_PayYourBillNow_Debit_Card_EPI_Page.select_DebitCard_Country(Ed.get("COUNTRY"));
	 Erm_PayYourBillNow_EPI_Page.click_on_Continue();
	
	
	}
	
	
}
