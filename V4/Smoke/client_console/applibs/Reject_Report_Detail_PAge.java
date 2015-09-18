package V4.Smoke.client_console.applibs;

import core.webwidgets.TextField;

public class Reject_Report_Detail_PAge {
	 /**
	 * to captures the visible text textfield  object declaration
	 * @return visible text  textfeild  object
	 *author:ARCHANA ENTURU
	 */
	
	public static TextField RR_page_VIsibleText() {
		return new TextField("//*[ @class='body-page-header' and contains(text(),'Reject Report Detail')]");}
	/**
	 * captures the visible text form the UI
	 * @returns string 
	 *author:ARCHANA ENTURU
	 */
	 
	public static String Get_MngText(){
		return   RR_page_VIsibleText().getText();
		  
		  }
}
