package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class Erm_ManagePaymentMethod_Add_A_CC 
{
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 */
	public static ListBox ManagePaymentMethod_CreditCardType() 
	{
		return new ListBox("name=fundingAccount.fundingAccountSubType");
	}
	public static void select_CreditCardType(String s)
	{
		ManagePaymentMethod_CreditCardType().selectItem(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_CardCvvo" TextField with locator of ("name=creditCardAccount.securityCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CardCvv" TextField with locator of ("name=creditCardAccount.securityCode")
	 */
	public static TextField ManagePaymentMethod_CardCvv()
	{
		return new TextField("name=fundingAccount.securityCode");
	}
	public static void Enter_CardCvv(String s)
	{
		ManagePaymentMethod_CardCvv().setText(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 */
	public static ListBox ManagePaymentMethod_DropDown_CreditCardExp_Month() 
	{
		return new ListBox("name=fundingAccount.expirationMonth");
	}
	public static void select_CreditCardExp_Month(String s)
	{
		ManagePaymentMethod_DropDown_CreditCardExp_Month().selectItem(s);
	}

	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardExp_Year" ListBox with locator of "name=creditCardAccount.expirationYear"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardExp_Year" ListBox with locator of "name=creditCardAccount.expirationYear"
	 */
	public static ListBox ManagePaymentMethod_DropDown_CreditCardExp_Year() 
	{
		return new ListBox("name=fundingAccount.expirationYear");
	}
	public static void select_CreditCardExp_Year(String s)
	{
		ManagePaymentMethod_DropDown_CreditCardExp_Year().selectItem(s);
	}
	
	public static void Enter_Card_details(Map<String,String> Ed)
	{
    Erm_ManagePaymentMethod_Add_A_CC.select_CreditCardType(Ed.get("CARD_TYPE"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_NameOnBank_Ac(Ed.get("NameOnBank_Ac"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Ac_Nick_Name(Ed.get("NickName"));
	Erm_ManagePaymentMethod_Add_A_CC.select_CreditCardExp_Month(Ed.get("EXP_MONTH"));
	Erm_ManagePaymentMethod_Add_A_CC.select_CreditCardExp_Year(Ed.get("EXP_YEAR"));
	Erm_ManagePaymentMethod_Add_A_CC.Enter_CardCvv(Ed.get("CVV"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_CAdd1(Ed.get("Add1"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_CAdd2(Ed.get("Add2"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_City(Ed.get("City"));
	Erm_ManagePaymentMethod_Add_A_BankAc.click_on_State(Ed.get("State"));
	Erm_ManagePaymentMethod_Add_A_BankAc.Enter_zip(Ed.get("zip"));
	Erm_ManagePaymentMethod_Add_A_BankAc.click_on_Country(Ed.get("COUNTRY"));
	Erm_PayYourBillNow_Card_Page.click_on_Continue();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
