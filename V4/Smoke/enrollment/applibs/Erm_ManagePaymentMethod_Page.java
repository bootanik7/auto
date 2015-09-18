package V4.Smoke.enrollment.applibs;


import java.util.Map;

import core.webwidgets.*;


public class Erm_ManagePaymentMethod_Page {
	/**
	 * Link object for "ManagePaymentMethods_Link_DeleteFunding" Link with locator of "link=Delete Funding"
	 * @return web UI Link object for the "ManagePaymentMethods_Link_DeleteFunding" Link with locator of "link=Delete Funding"
	 */
	public static Link ManagePaymentMethods_Link_DeleteFunding()
	{
		return new Link("link=Delete Funding");
	}
	
	public static void click_on_Delete()
	{
		ManagePaymentMethods_Link_DeleteFunding().click();
	}

	public static boolean isDeletelink()
	{
		return  ManagePaymentMethods_Link_DeleteFunding().isVisible();

	}

	/**
	 * TextField object for " ManagePaymentMethods_TextBox_CustAdd1" TextField with locator of ("name=fundingAccount.accountAddress1")
	 * @return web UI TextField object for the " ManagePaymentMethods_TextBox_CustAdd1" TextField with locator of ("name=fundingAccount.accountAddress1")
	 */
	public static TextField ManagePaymentMethods_CustAdd1()
	{
		return new TextField("name=fundingAccount.accountAddress1");
	}
	public static void Enter_CustAdd1(String s)
	{
		ManagePaymentMethods_CustAdd1().setText(s);
	}

	/**
	 * TextField object for " ManagePaymentMethods_TextBox_CustAdd2" TextField with locator of ("name=fundingAccount.accountAddress2")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=fundingAccount.accountAddress2")
	 */
	public static TextField ManagePaymentMethods_CustAdd2()
	{
		return new TextField("name=fundingAccount.accountAddress2");
	}
	public static void Enter_CustAdd2(String s)
	{
		ManagePaymentMethods_CustAdd2().setText(s);
	}

	/**
	 * TextField object for " ManagePaymentMethods_TextBox_CustAdd2" TextField with locator of ("name=fundingAccount.accountCity")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=fundingAccount.accountCity")
	 */
	public static TextField ManagePaymentMethods_City()
	{
		return new TextField("name=fundingAccount.accountCity");
	}
	public static void Enter_City(String s)
	{
		ManagePaymentMethods_City().setText(s);;
	}
	/**
	 * ListBox object for " ManagePaymentMethods_DropDown_CreditCardState" ListBox with locator of ("name=fundingAccount.accountState")
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of ("name=fundingAccount.accountState")
	 */
	public static ListBox  ManagePaymentMethods_DropDown_CreditCardState() 
	{
		return new ListBox("name=fundingAccount.accountState");
	}
	public static void Enter_CreditCardState(String s)
	{
		ManagePaymentMethods_DropDown_CreditCardState().selectItem(s);
	}

	/**
	 * TextField object for " ManagePaymentMethods_TextBox_Zipcode" TextField with locator of ("name=fundingAccount.accountPostalCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Zipcode" TextField with locator of ("name=fundingAccount.accountPostalCode")
	 */
	public static TextField  ManagePaymentMethods_Zipcode()
	{
		return new TextField("name=fundingAccount.accountPostalCode");
	}
	public static void EnterZipcode(String s)
	{
		ManagePaymentMethods_Zipcode().setText(s);;
	}

	/**
	 * ListBox object for " ManagePaymentMethods_DropDown_Country" ListBox with locator of ("name=fundingAccount.accountCountryCode")
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_Country" ListBox with locator of ("name=fundingAccount.accountCountryCode")
	 */
	public static ListBox  ManagePaymentMethods_DropDown_Country() 
	{
		return new ListBox("name=fundingAccount.accountCountryCode");
	}
	public static void Enter_Country(String s)
	{
		ManagePaymentMethods_DropDown_Country() .selectItem(s);
	}
	/**
	 * Link object for "ManagePaymentMethods_Link_Addbankacc" Link with locator of "link=Add A Bank Account"
	 * @return web UI Link object for the "ManagePaymentMethods_Link_Addbankacc" Link with locator of "link=Add A Bank Account"
	 */
	public static Link ManagePaymentMethods_Link_AddBankAc()
	{
		return new Link("link=Add A Bank Account");
	}
	public static void click_on_AddBackAcc()
	{
		ManagePaymentMethods_Link_AddBankAc().click();
	}


	/**
	 * Link object for "ManagePaymentMethods_Link_AddCard" Link with locator of "link=Add A Card"
	 * @return web UI Link object for the "ManagePaymentMethods_Link_AddCard" Link with locator of "link=Add A Card"
	 */
	public static Link ManagePaymentMethods_Link_AddCard() {
		return new Link("link=Add A Card");
	}
	public static void click_on_AddCard()
	{
		ManagePaymentMethods_Link_AddCard().click();
	}

	public static Button ManagePaymentMethods_Button_Update()
	{
		return new Button(".//*[@value='Update']");
	}
	public static void click_on_Update()
	{
		ManagePaymentMethods_Button_Update().click();
	}

	public static StaticText ManagePaymentMethods_CNF1_Text()
	{
		return new StaticText("//*[contains(text(),'Funding account has been modified successfully')]");
	}
	public static String get_CNF1_text()
	{
		String S=ManagePaymentMethods_CNF1_Text().getText();
		return S;
	}


	public static void Modify_NickName(Map<String,String> Ed)
	{

		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Ac_Nick_Name(Ed.get("NickName"));
		Erm_ManagePaymentMethod_Page.Enter_City(Ed.get("City"));
		Erm_ManagePaymentMethod_Page.Enter_CustAdd1(Ed.get("Add1"));
		Erm_ManagePaymentMethod_Page.Enter_CustAdd2(Ed.get("Add2"));
		Erm_ManagePaymentMethod_Page.EnterZipcode(Ed.get("Zip"));
		Erm_ManagePaymentMethod_Page.Enter_Country(Ed.get("COUNTRY"));
		Erm_ManagePaymentMethod_Page.Enter_CreditCardState(Ed.get("State"));
		Erm_ManagePaymentMethod_Page.click_on_Update();
	}


	public static StaticText CNF_Text()
	{
		return new StaticText("//*[contains(text(),'Funding account has been enrolled successfully')]");
	}
	public static String Add_Bank_CNF_text()
	{
		String S=CNF_Text().getText();
		return S;
	}



}
