package V4.Smoke.client_console.applibs;

import core.webwidgets.Link;
import core.webwidgets.TextField;

public class RejectionReport_Page {

	public static TextField FundingType(){
		return new TextField("name=displayFundingAccountType");
	}
	
	
	public static TextField Bnk_CardNUm(){
		return new TextField("//*[@name='fundingAccountNumber']");
	}

	
	public static TextField Biller_AccountNum(){
		return new TextField("//*[@name='billerAccountNumber']");}
	
	
	public static Link HomePage_Link_MngRejectTab() {
		return new Link("link=MANAGE REJECTS");
	    }
	
	
	public static void click_HomePage_Link_MngRejectTab(){
		
		HomePage_Link_MngRejectTab().click();	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
