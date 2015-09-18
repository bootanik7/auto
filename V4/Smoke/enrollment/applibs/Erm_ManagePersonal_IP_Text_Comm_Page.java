package V4.Smoke.enrollment.applibs;

import core.mobilewidgets.Button;
import core.webwidgets.Link;

public class Erm_ManagePersonal_IP_Text_Comm_Page 
{
	/**
	* Link object for "ManagePersonalInfo_Link_Opt_In_Instructions" Link with locator of "link=Opt In Instructions"
	* @return web UI Link object for the "ManagePersonalInfo_Link_Opt_In_Instructions" Link with locator of "link=Opt In Instructions"
	*/
	public static Link ManagePersonalInfo_Link_Opt_In_Instructions() {
		return new Link("link=Opt In Instructions");
	}
	/**
	* Link object for "ManagePersonalInfo_Link_Privacy_Policy" Link with locator of "link=Privacy Policy"
	* @return web UI Link object for the "ManagePersonalInfo_Link_Privacy_Policy" Link with locator of "link=Privacy Policy"
	*/
	public static Link ManagePersonalInfo_Link_Privacy_Policy() {
		return new Link("link=Privacy Policy");
	}
	/**
	* Link object for "ManagePersonalInfo_Link_HELP_Instructions" Link with locator of "link=HELP Instructions"
	* @return web UI Link object for the "ManagePersonalInfo_Link_HELP_Instructions" Link with locator of "link=HELP Instructions"
	*/
	public static Link ManagePersonalInfo_Link_HELP_Instructions() {
		return new Link("link=HELP Instructions");
	}
	/**
	* Link object for "ManagePersonalInfo_Link_Contactus" Link with locator of "link=Contact Us"
	* @return web UI Link object for the "ManagePersonalInfo_Link_Contactus" Link with locator of "link=Contact Us"
	*/
	public static Link ManagePersonalInfo_Link_Contactus() {
		return new Link("link=Contact Us");
	}
	/**
	* Link object for "ManagePersonalInfo_Link_Supported_Carriers" Link with locator of "link=Supported Carriers"
	* @return web UI Link object for the "ManagePersonalInfo_Link_Supported_Carriers" Link with locator of "link=Supported Carriers"
	*/
	public static Link ManagePersonalInfo_Link_Supported_Carriers() {
		return new Link("link=Supported Carriers");
	}
	/**
	* Link object for "ManagePersonalInfo_Link_Terms_Conditions" Link with locator of "link=Terms & Conditions"
	* @return web UI Link object for the "ManagePersonalInfo_Link_Terms_Conditions" Link with locator of "link=Terms & Conditions"
	*/
	public static Link ManagePersonalInfo_Link_Terms_Conditions() {
		return new Link("link=Terms & Conditions");
	}
	 /**
 	 * Ern_PayYourBillNow_page Continue button
 	 * @return Returns web UI object of specified type and definition
 	 */ 
 	
 	public static Button ManagePersonalInfo_Button_Save_MB_No()
 	{
 		return new Button("//*[@value='Save Mobile Phone Number']");     
 	}
 	public static void click_on_Save_MB_No() 
	{
 		ManagePersonalInfo_Button_Save_MB_No().click();
	}
 	 /**
 	 * Ern_managepersoInfonal_page Return button
 	 * @return Returns web UI object of specified type and definition
 	 */ 
 	
 	public static Button ManagePersonalInfo_Button_Return()
 	{
 		return new Button("//*[@value='Return']");     
 	}
 	public static void click_on_Return() 
	{
 		ManagePersonalInfo_Button_Return().click();
	}
	
	
	
	
	
	
	
	
}
