package V4.Smoke.client_console.applibs;

import core.webwidgets.Link;

public class Mang_Acc_Enrolled_Customer_Page {
	/**
	 * link   object declaration
	 * @return link  object
	 *author:ARCHANA ENTURU
	 */

	public static Link AutoDebitOption(){
		return new Link("//a[@href='https://collectpay-qa.princetonecom.com/clientconsole/manageaccount/loadPaymentSchedule.do?billingAccountId=4836497&token=65002368346456a1592b']");
	}
	/**
	 * clicks on the enrolled link
	 * 
	 *author:ARCHANA ENTURU
	 */

	
	public static void click_OptnAutoDebit(){
		AutoDebitOption().click();
	}
	
	
}
