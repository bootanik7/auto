package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;


public class Erm_ModifyYourAutoPay_CNF_Page1
{/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText ModifyYourAutoPay_CNF1_Text()
	{
		 return new StaticText("//*[contains(text(),'Your automatic payment schedule has been canceled')]");
	}
	public static String get_SetUpAutoPay_CNF1_text()
	{
		String S=ModifyYourAutoPay_CNF1_Text().getText();
		return S;
	}
	/**
	 * Link object for " ModifyYourAutoPay_Link_click_here" Link with locator of "link=click  here"
	 * @return web UI Link object for the " ModifyYourAutoPay_Link_click_here" Link with locator of "link=click  here"
	 */
	public static Link  ModifyYourAutoPay_Link_click_here() {
		return new Link("link=click  here");
	}
}
