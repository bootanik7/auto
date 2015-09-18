package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;


public class Erm_PayYourBillNow_RPI_Page 
{ 
	/**
	 * Link object for "PayYourBillNow_Link_Edit" Link with locator of "link=edit"
	 * @return web UI Link object for the "PayYourBillNow_Link_Edit" Link with locator of "link=edit"
	 */
	public static Link PayYourBillNow_Edit() 
	{
		return new Link("link=edit");
	}
	public static void click_on_Edit()
	{
		PayYourBillNow_Edit().click();  
	} 
	/** Object Class Type Not found object for "PayYourBillNow_CheckBox_termandcondt" Object Class Type Not found with locator of "//*[@name='termsAndConditionsFlag']"
		* @return web UI Object Class Type Not found object for the "PayYourBillNow_CheckBox_termandcondt" Object Class Type Not found with locator of "//*[@name='termsAndConditionsFlag']"
		*/ 
		public static CheckBox PayYourBillNow_CheckBox_termandcondt()
		{
		return new CheckBox("name=termsAndConditionsFlag");
		}
		public static void click_on_termandcondt()
		{
			PayYourBillNow_CheckBox_termandcondt().check();
		}
		public static boolean istermsflagpresent() {
			
			return PayYourBillNow_CheckBox_termandcondt().isVisible();
			
		}
 
	
	public static Button PayYourBillNow_Button_Submit()
	{
		return new Button("name=SubmitPaymentbtn");
	}
	public static void click_on_Submit()
	{
		PayYourBillNow_Button_Submit().click();
	}
	/**
	 * Link object for "PayYourBillNow_Link_Modify" Link with locator of "name=Modifybtn"
	 * @return web UI Link object for the "PayYourBillNow_Link_Modify" Link with locator of "name=Modifybtn"
	 */
	public static Link PayYourBillNow_Link_Modify() 
	{
		return new Link("name=Modifybtn");
	}
	public static void click_on_Modify()
	{
		PayYourBillNow_Link_Modify().click();  
	} 

	/**
	 * Link object for "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 * @return web UI Link object for the "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 */
	public static Link PayYourBillNow_Link_Cancel() 
	{
		return new Link("name=Cancel");
	}
	public static void click_on_Cancel()
	{
		PayYourBillNow_Link_Cancel().click();  
	}	 
	
	
	public static void reviewpayemntinfo() {
        if(istermsflagpresent()){
		Erm_PayYourBillNow_RPI_Page.click_on_termandcondt();
		Erm_PayYourBillNow_RPI_Page.click_on_Submit();
        }
	}

}
