package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.*;

public class Erm_ManagePersonal_IP_Email_Page 
{
	/**
	 * TextField object for "ManagePersonalInfo_TextBox_CurrentEmail" TextField with locator of "name=currentEmailAddress"
	 * @return web UI TextField object for the "ManagePersonalInfo_TextBox_CurrentEmail" TextField with locator of "name=currentEmailAddress"
	 */
	public static TextField ManagePersonalInfo_TextBox_CurrentEmail() {
		return new TextField("name=currentEmailAddress");
	}


	/**
	 * TextField object for "ManagePersonalInfo_TextBox_NewEmail" TextField with locator of "name=consumerProfile.primaryEmailAddress"
	 * @return web UI TextField object for the "ManagePersonalInfo_TextBox_NewEmail" TextField with locator of "name=consumerProfile.primaryEmailAddress"
	 */
	public static TextField ManagePersonalInfo_TextBox_NewEmail() {
		return new TextField("name=consumerProfile.primaryEmailAddress");
	}
	public static void Enter_NewEmailId(String s)
	{
		ManagePersonalInfo_TextBox_NewEmail().setText(s);;
	}


	/**
	 * TextField object for "ManagePersonalInfo_TextBox_ConfirmEmail" TextField with locator of "name=confirmPrimaryEmailAddress"
	 * @return web UI TextField object for the "ManagePersonalInfo_TextBox_ConfirmEmail" TextField with locator of "name=confirmPrimaryEmailAddress"
	 */
	public static TextField ManagePersonalInfo_TextBox_ConfirmEmail()
	{
		return new TextField("name=confirmPrimaryEmailAddress");
	}
	public static void Enter_ConfirmEmailId(String s)
	{
		ManagePersonalInfo_TextBox_ConfirmEmail().setText(s);
	}
	/**
	 * Declaration for the Enrollment main page for capturing the Welcome text 
	 * @return Returns web UI object of specified type and definition 
	 */
	
	public static StaticText Email_CNF_Text()
	{
		 return new StaticText("//*[contains(text(),'Thank you. Your personal information has been updated')]");
	}
	public static String get_Email_CNF_text()
	{
		String S=Email_CNF_Text().getText();
		return S;
	}

public static void modify_email(Map<String,String> Ed) throws InterruptedException

{
	Erm_ManagePersonal_IP_Email_Page.Enter_NewEmailId(Ed.get("NewEmailId"));
	Thread.sleep(3000);
	Erm_ManagePersonal_IP_Email_Page.Enter_ConfirmEmailId(Ed.get("ConfirmEmailId"));
	Erm_Login_Page.Submit();
}
	
	

}
