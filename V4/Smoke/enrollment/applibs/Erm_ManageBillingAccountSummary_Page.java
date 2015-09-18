package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;

public class Erm_ManageBillingAccountSummary_Page 
{
	/**
	 * Link object for "ManageBillingAccount_Link_Here" Link with locator of "link=Here"
	 * @return web UI Link object for the "ManageBillingAccount_Link_Here" Link with locator of "link=Here"
	 */
	public static Link ManageBillingAccount_Link_Here()
	{
		return new Link("link=Here");
	}
	public static void click_Here()
	{
		ManageBillingAccount_Link_Here().click();
	}
	public static boolean is_present()
	{
		return ManageBillingAccount_Link_Here().isVisible();
	}
	/**
	 * Link object for "ManageBillingAccount_Deletethisaccount" Object Class Type Not found with locator of "link=Delete This Account"
	 * @return web UI Object link object for the "ManageBillingAccount_Deletethisaccount_afteradding" Object Class Type Not found with locator of "link=Delete This Account"
	 */
	public static Link ManageBillingAccount_Link_Deletethisaccount() {
		return new Link("link=Delete This Account");
	}
	public static void click_Delete()
	{
		ManageBillingAccount_Link_Deletethisaccount().click();
	}
	/**
	 * TextField object for "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name='billingAccount.accountNickname"
	 * @return web UI TextField object for the "ManageBillingAccount_NickName" Object Class Type Not found with locator of "name=billingAccount.accountNickname"
	 */
	public static TextField ManageBillingAccount_NickName()
	{
		return new TextField("name=billingAccount.accountNickname");
	}
	public static void Enter_NickName(String s)
	{
		ManageBillingAccount_NickName().setText(s);
	}
	public static boolean Nickname_isPresent()
	{
		return ManageBillingAccount_NickName().isVisible();
	}

/**
* Object Class Type Not found object for "ManageBillingAccount_CheckBox_paperbill_1" Object Class Type Not found with locator of "@name=$fieldName_cb"
* @return web UI Object Class Type Not found object for the "ManageBillingAccount_CheckBox_paperbill_1" Object Class Type Not found with locator of "name=$fieldName_cb"
*/
public static CheckBox ManageBillingAccount_CheckBox_paperbill_1()
{
	return new CheckBox("name=$fieldName_cb");
}
public static void click_CheckBox()
{
	ManageBillingAccount_CheckBox_paperbill_1().check();
}




}
