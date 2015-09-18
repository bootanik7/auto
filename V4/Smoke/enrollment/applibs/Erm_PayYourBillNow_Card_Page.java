package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.Button;
import core.webwidgets.TextField;

public class Erm_PayYourBillNow_Card_Page 
{   
	 /**
     * TextField object for "PayYourBillow_TextBox_Card_CardNo" TextField with locator of ("name=cardNumber")
     * @return web UI TextField object for the ""PayYourBillow_TextBox_Card_CardNo" TextField with locator of ("name=cardNumber")
     */
    public static TextField PayYourBillNow_Card_CardNo()
    {
    	return new TextField("name=cardNumber");
    	
    }
	public static void Enter_Card_Num(String s)
	{
		PayYourBillNow_Card_CardNo().setText(s);
	}
	/**
 	 * Ern_PayYourBillNow_page Continue button
 	 * @return Returns web UI object of specified type and definition
 	 */ 
 	
 	public static Button PayYourBillNow_Card_Continue()
 	{
 		return new Button("name=Submitbtn");     
 	}
 	public static void click_on_Continue() 
	{
		PayYourBillNow_Card_Continue().click();
	}
 	
    public static void Provide_CardNum(Map<String,String> Ed)
    {
    	 Erm_PayYourBillNow_Card_Page.Enter_Card_Num(Ed.get("CARD_NUMBER"));
		 Erm_PayYourBillNow_Card_Page.click_on_Continue();
    	
    }




}
