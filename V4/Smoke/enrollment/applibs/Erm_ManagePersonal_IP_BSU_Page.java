package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;


public class Erm_ManagePersonal_IP_BSU_Page 
{
	/**
	 * TextField object for "BillerSignUp_TextBox_CustomerName" TextField with locator of "name=consumerProfile.consumerName"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_CustomerName" TextField with locator of "name=consumerProfile.consumerName"
	 */
	public static TextField BillerSignUp_TextBox_CustomerName()
	{
		return new TextField("//*[@id='consumerName']");
	}
	public static void Enter_CustomerName(String s)
	{
		BillerSignUp_TextBox_CustomerName().setText(s);
	}
	/**
	 * TextField object for "BillerSignUp_TextBox_Add1" TextField with locator of "name=consumerProfile.profileAddress1"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_Add1" TextField with locator of "name=consumerProfile.profileAddress1"
	 */
	public static TextField BillerSignUp_TextBox_Add1() {
		return new TextField("name=consumerProfile.profileAddress1");
	}
	public static void Enter_Add1(String s)
	{
		BillerSignUp_TextBox_Add1().setText(s);
	}


	/**
	 * TextField object for "BillerSignUp_TextBox_Add2" TextField with locator of "name=consumerProfile.profileAddress2"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_Add2" TextField with locator of "name=consumerProfile.profileAddress2"
	 */
	public static TextField BillerSignUp_TextBox_Add2() {
		return new TextField("name=consumerProfile.profileAddress2");
	}
	public static void Enter_Add2(String s)
	{
		BillerSignUp_TextBox_Add2().setText(s);
	}

	/**
	 * TextField object for "BillerSignUp_TextBox_ContactNo" TextField with locator of "name=consumerProfile.phoneNumber"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_ContactNo" TextField with locator of "name=consumerProfile.phoneNumber"
	 */
	public static TextField BillerSignUp_TextBox_ContactNo() {
		return new TextField("name=consumerProfile.phoneNumber");
	}
	public static void Enter_ContactNo(String s)
	{
		BillerSignUp_TextBox_ContactNo().setText(s);
	}


	/**
	 * TextField object for "BillerSignUp_TextBox_City" TextField with locator of "name=consumerProfile.profileCity"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_City" TextField with locator of "name=consumerProfile.profileCity"
	 */
	public static TextField BillerSignUp_TextBox_City() {
		return new TextField("name=consumerProfile.profileCity");
	}
	public static void Enter_City(String s)
	{
		BillerSignUp_TextBox_City().setText(s);
	}


	/**
	 * ListBox object for "BillerSignUp_DropDown_State" ListBox with locator of "name=consumerProfile.profileState"
	 * @return web UI ListBox object for the "BillerSignUp_DropDown_State" ListBox with locator of "name=consumerProfile.profileState"
	 */
	public static ListBox BillerSignUp_DropDown_State()
	{
		return new ListBox("name=consumerProfile.profileState");
	}
	public static void select_State(String s)
	{
		BillerSignUp_DropDown_State().selectItem(s);
	}


	/**
	 * TextField object for "BillerSignUp_TextBox_Zip" TextField with locator of "name=consumerProfile.profilePostalCode"
	 * @return web UI TextField object for the "BillerSignUp_TextBox_Zip" TextField with locator of "name=consumerProfile.profilePostalCode"
	 */
	public static TextField BillerSignUp_TextBox_Zip() {
		return new TextField("name=consumerProfile.profilePostalCode");
	}
	public static void Enter_Zip(String s)
	{
		BillerSignUp_TextBox_Zip().setText(s);
	}
	/**
	 * Button object for "ManagePersonalInfo_Button_Submit" Button with locator of "name=Submit"
	 * @return web UI Button object for the "ManagePersonalInfo_Button_Submit" Button with locator of "name=Submit"
	 */
	public static Button BillerSignUp_Button_Submit()
	{
		return new Button("name=Submit");
	}
	public static void click_on_Submit()
	{
		BillerSignUp_Button_Submit().click();
	}

	/**
	 * Link object for "ManageprofileInformation_Link_Cancel_Button" Link with locator of "name=Cancelbtn"
	 * @return web UI Link object for the "ManageprofileInformation_Link_Cancel_Button" Link with locator of "name=Cancelbtn"
	 */
	public static Link ManageprofileInformation_Link_Cancel_Button() {
		return new Link("name=Cancelbtn");
	}

/**this is the function we have give 
 * add1
 * add2
 * customer name
 * city
 * zip
 * state
 * concact no
 * **/
   public static void SingUp(String name,String add1,String add2,String city,String zip,String State,String contact)
   {
	   Enter_CustomerName(name);
	   Enter_Add1(add1);
	   Enter_Add2(add2);
	   Enter_City(city);
	   Enter_Zip(zip);
	   Enter_ContactNo(contact);
	   select_State(State);
	   Erm_PayYourBillNow_RPI_Page.click_on_termandcondt();
	   click_on_Submit();
   }














}
