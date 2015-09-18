package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;

public class Erm_ManagePersonal_IP_Email_CNF_Page 
{
	/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText CNF_Text()
	{
		 return new StaticText("//*[contains(text(),'Thank you. Your personal information has been updated')]");
	}
	public static String get_Erm_Welcome_text()
	{
		String S=CNF_Text().getText();
		return S;
	}
	
}
