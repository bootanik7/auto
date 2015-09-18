package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;

public class Erm_ModifyYourAutoPay_CNF_Page
{
	/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText  ModifyYourAutoPay_CNF_Text()
	{
		 return new StaticText("//*[contains(text(),'Your automatic payments have been successfully updated')]");
	}
	public static String get_SetUpAutoPay_CNF_text()
	{
		String S=ModifyYourAutoPay_CNF_Text().getText();
		return S;
	}

}
