package V4.Smoke.enrollment.applibs;

import core.webwidgets.StaticText;

public class Erm_SetUpAutoPay_CNF_Page 
{

	/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText SetUpAutoPay_CNF_Text()
	{
		 return new StaticText("//*[contains(text(),'Your automatic payments have been successfully scheduled')]");
	}
	public static String get_SetUpAutoPay_CNF_text()
	{
		String S=SetUpAutoPay_CNF_Text().getText();
		return S;
	}
	
}
