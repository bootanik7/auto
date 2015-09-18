package V4.Smoke.enrollment.applibs;

import core.webwidgets.*;;


public class Erm_PayYourBillNow_CNF_Page 
{
	  /**
	 	 * Erm_PayYourBillNow_page Return_To_AccountSummary button
	 	 * @return Returns web UI object of specified type and definition
	 	 */ 
	 	
	 	public static Button PayYourBillNow_Return_To_AccountSummary()
	 	{
	 		return new Button("name=Submitbtn");    
	 	}
	 	public static void click_on_Button() 
		{
			PayYourBillNow_Return_To_AccountSummary().click();
		}
	 	 /**
	 	 * Erm_PayYourBillNow_page Return_To_AccountSummary button
	 	 * @return Returns web UI object of specified type and definition
	 	 */ 
	 	
	 	public static Button PayYourBillNow_Enroll_This_Funding()
	 	{
	 		return new Button("name=SubmitAddFunding");    
	 	}
	 	public static void click_on_Funding() 
		{
			PayYourBillNow_Enroll_This_Funding().click();
		}
	
	
	 	/**
		 * Declaration for the Enrollment main page for capturing the Welcome text 
		 * @return Returns web UI object of specified type and definition 
		 */
		
		public static StaticText ACH_CNF_Text()
		{
			 return new StaticText("//*[contains(text(),'Your payment has been successfully scheduled')]");
		}
		public static String get_Erm_CNF_text()
		{
			String S=ACH_CNF_Text().getText();
			return S;
		}
	
	
	
	
	
	
	
	
	
}
