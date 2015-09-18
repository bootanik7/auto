package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.*;

public class Erm_MBAccountSummury_Adding_Page 
{
	/**
	 * TextField object for "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name='billingAccount.accountNickname"
	 * @return web UI TextField object for the "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name=billingAccount.accountNickname"
	 */
	public static TextField ManageBillingAccount_Account_Num()
	{
		return new TextField("name=billingAccount.billingAccountNumber");
	}
	public static void Enter_Account_Num(String s)
	{
		ManageBillingAccount_Account_Num().setText(s);
	}
	public static boolean Ac_isPresent()
	{
		return ManageBillingAccount_Account_Num().isVisible();
	}
	
	/**
	 * TextField object for "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name='billingAccount.accountNickname"
	 * @return web UI TextField object for the "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name=billingAccount.accountNickname"
	 */
	/**public static TextField ManageBillingAccount_SecurityKey_Ac_Info()
	{
		return new TextField("name=loginFields[0]");
	}
	public static void Enter_Security_Num(String s)
	{
		ManageBillingAccount_SecurityKey_Ac_Info().setText(s);
	}**/
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 */
	public static ListBox ManageBillingAccount_DropDown_Divison() 
	{
		return new ListBox("name=billingAccount.divisionBusinessId");
	}
	public static void select_Division(String s)
	{
		ManageBillingAccount_DropDown_Divison().selectItem(s);
	}
	public static boolean div_isPresent()
	{
		return ManageBillingAccount_DropDown_Divison().isVisible();
	}
	/**
	* Object Class Type Not found object for "ManageBillingAccount_CheckBox_paperbill_1" Object Class Type Not found with locator of "@name=$fieldName_cb"
	* @return web UI Object Class Type Not found object for the "ManageBillingAccount_CheckBox_paperbill_1" Object Class Type Not found with locator of "name=$fieldName_cb"
	*/
	public static CheckBox ManageBillingAccount_CheckBox_paperbill()
	{
		return new CheckBox("name=billingAccount.paperBill");
	}
	public static void click_CheckBox()
	{
		ManageBillingAccount_CheckBox_paperbill().check();
	}
	
	public static void Enter_Billing_Ac_details(Map<String,String> Ed)
	{
	if(Ac_isPresent())
	{
	Erm_MBAccountSummury_Adding_Page.Enter_Account_Num(Ed.get("ACCOUNT_NUMBER"));
	}
	if(Erm_Login_Page.Info1_isPrasent())
	{
	Erm_Login_Page.Enter_Security_Num1(Ed.get("ACCOUNT_INFO_01"));
	}
	if(Erm_Login_Page.Info2_isPrasent())
	{
	Erm_Login_Page.Enter_Security_Num2(Ed.get("ACCOUNT_INFO_02"));
	}
	if(Erm_MBAccountSummury_Adding_Page.div_isPresent())
	{
	Erm_MBAccountSummury_Adding_Page.select_Division(Ed.get("PRIMARY_NAME"));
	}
	if(Erm_ManageBillingAccountSummary_Page.Nickname_isPresent())
	{
	Erm_ManageBillingAccountSummary_Page.Enter_NickName(Ed.get("ACCOUNT_NICKNAME"));
	}
	//Erm_MBAccountSummury_Adding_Page.click_CheckBox();
	Erm_PayYourBillNow_Card_Page.click_on_Continue();
	
	}
}
