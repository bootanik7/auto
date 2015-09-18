package V4.Smoke.client_console.applibs;

import core.webwidgets.Link;
import core.webwidgets.TextField;

public class Reject_Report_Summary_Page {
	/**
	 * to captures the visible text textfield  object declaration
	 * @return visible text  textfeild  object
	 *author:ARCHANA ENTURU
	 */
	public static TextField RR_VisibleText(){
		return new TextField("//*[@class='body-page-header' and contains(text(),'Reject Report Summary')]");
	}
	/**
	 * captures the visible text form the UI
	 * @returns string 
	 *author:ARCHANA ENTURU
	 */
	public static String get_RR_VisibleText(){
		String s=RR_VisibleText().getText();
		return s;
	}
	
	/**
	 *reject reports link object declaration
	 * @returnreject reports link object
	 *author:ARCHANA ENTURU
	 */
	public static Link RR_Reports_LINk(){
		return new Link("//a[@href='https://collectpay-qa.princetonecom.com/clientconsole/managerejects/loadSessionDetailPaymentRejectReport.do?reportDate=2015-08-03&id=504477&token=ccb34d4b6a38e163b265']");
		
	}

    /**
    *clicks on specifyed rejected report link
   * 
   *author:ARCHANA ENTURU
    */
	
	
	public static void click_RR_Link(){
		RR_Reports_LINk().click();}
	
	
	
	
}
