package V4.Smoke.enrollment.applibs;

import core.webwidgets.Link;

public class Erm_ManagePersonal_IP_Page 
{


	/**
	 * Link object for "ManagePersonalInfo_Link_Name_Address_Phone" Link with locator of "link=Name,Address,Phone"
	 * @return web UI Link object for the "ManagePersonalInfo_Link_Opt_In_Instructions" Link with locator of "Name,Address,Phone"
	 */
	public static Link ManagePersonalInfo_Link_Name_Address_Phone() {
		return new Link("link=Name,Address,Phone");
	}
	public static void click_on_Name_Add_Pho()
	{
		ManagePersonalInfo_Link_Name_Address_Phone().click();
	}
	/**
	 * Link object for "ManagePersonalInfo_Link_Email_Address" Link with locator of "Email Address"
	 * @return web UI Link object for the "ManagePersonalInfo_Link_Email Address" Link with locator of "link=Email Address"
	 */
	public static Link ManagePersonalInfo_Link_Email_Address() {
		return new Link("link=Email Address");
	}
	public static void click_on_EmailAddress()
	{
		ManagePersonalInfo_Link_Email_Address().click();
	}
	/**
	 * Link object for "ManagePersonalInfo_Link_Opt_In_Instructions" Link with locator of "link=Opt In Instructions"
	 * @return web UI Link object for the "ManagePersonalInfo_Link_Opt_In_Instructions" Link with locator of "link=Opt In Instructions"
	 */
	public static Link ManagePersonalInfo_Link_TEXT_Communication() {
		return new Link("link=TEXT Communication");
	}

	public static void click_on_TextComm()
	{
		ManagePersonalInfo_Link_TEXT_Communication().click();
	}





















}
