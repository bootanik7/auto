package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.TextField;

public class Management_transcation_page {
	/**
	 * to captures the visible text textfield  object declaration
	 * @return visible text  textfield  object
	 *author:ARCHANA ENTURU
	 */
	
	public static Link HomePage_Link_MngTran() {
		return new Link("link=MANAGE TRANSACTIONS");
	}

	public static void click_HomePage_Link_MngTran(){
		HomePage_Link_MngTran().click();
	}
	
	
	
	public static TextField MT_visibleText(){
		return new TextField("//*[@class='body-page-header' and contains(text(),'Transaction Search')]");
	}
	
	
	/**
	 * captures the visible frm the UI
	 * @returns string 
	 *author:ARCHANA ENTURU
	 */
 
	public static String Get_MT_visibleText(){
		  String  mtText =MT_visibleText().getText();
		  return mtText;}

	 /**
	  *ConformationNum  TextField object declaration
	  * @return ConformationNum TextField  object
	  *author:ARCHANA ENTURU
	  */
	
	public static TextField ConformationNum(){
		
	return new TextField("//*[@name='confirmationNumber']");
	
	}
	/**
	 *  Enter conformation  number  into : conformation search textfield
	 * @Param:  confNum string text to enter into conformation textfield.
	 *author:ARCHANA ENTURU
	 */
	
	public static void Enter_Conf_Num(String confNum){
		 ConformationNum().setText(confNum);
	}
	
	/**
	  *Search radiobutton object declaration
	  * @return Search radiobutton  object
	  *author:ARCHANA ENTURU
	  */
	public static Button Search(){
		
		return new Button(" //*[@value='Search']");
	}
	/**
	  *Cancel radiobutton object declaration
	  * @returnCancel radiobutton  object
	  *author:ARCHANA ENTURU
	  */
    public static Button Cancel(){
		
		return new Button("//*[@value='Cancel']"); }
    	
    /**
	  *clicks on Search  radioButton
	  * 
	  *author:ARCHANA ENTURU
	  */
    
    public static void clickSearch(){
    	Search().click();

} /**
	  *clicks on Cancel radioButton
	  * 
	  *author:ARCHANA ENTURU
	  */

    public static void clickCancel(){
 
    	Cancel().click();
}
}