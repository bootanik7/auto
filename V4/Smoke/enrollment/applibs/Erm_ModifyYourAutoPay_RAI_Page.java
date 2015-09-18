package V4.Smoke.enrollment.applibs;

import core.mobilewidgets.Button;
import core.webwidgets.Link;

public class Erm_ModifyYourAutoPay_RAI_Page
{
	/**
	* Button object for "ModifyAutoPay_Button_CancelPmt" Button with locator of "name=cancelPaymentSchedule"
	* @return web UI Button object for the "ModifyAutoPay_Button_CancelPmt" Button with locator of "name=cancelPaymentSchedule"
	*/
	public static Button ModifyAutoPay_Button_CancelPmt() {
		return new Button("name=cancelPaymentSchedule");
	}
	/**
	 * Link object for "ModifyAutoPay_Link_Back" Link with locator of "name=Back"
	 * @return web UI Link object for the "ModifyAutoPay_Link_Back" Link with locator of "name=Back"
	 */
	public static Link  ModifyAutoPay_Link_Back()
	{
		return new Link("name=Back");
	}


}
