package V4.Smoke.client_console.applibs;


import core.webwidgets.Button;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

public class ManageAcc_enrollment_listPage {

    /**
	 * to captures the visible text textfield  object declaration
	 * @return visible text  textfeild  object
	 *author:ARCHANA ENTURU
	 */
	
	 public static TextField MngAcc_VIsibleText() {
		return new TextField("//p[contains(text(),'Manage Accounts')]");}

	 /**
		 * captures the visible frm the UI
		 * @returns string 
		 *author:ARCHANA ENTURU
		 */
	 
	 
	 public static String Get_MngText(){
		  String  SText =MngAcc_VIsibleText().getText();
		  return SText;}

	 /**
	  * ViewProfile  Button object declaration
	  * @return ViewProfile  Button object
	  *author:ARCHANA ENTURU
	  */
	 public static Button ViewProfile() {
			return new Button("//*[@type='submit' and @ value='View Profile']");}
	 
	 /**
	  *clicks on ViewProfile button
	  * 
	  *author:ARCHANA ENTURU
	  */
	 public static void click_ViewProfile(){
	   ViewProfile().click();
   }
	 /**
	  * customerName  Button object declaration
	  * @return customerName  Button object
	  *author:ARCHANA ENTURU
	  */
     
     public static RadioButton customerName() {
			return new RadioButton("//*[@value='129']");}


	 /**
	  *clicks on customer name  radioButton
	  * 
	  *author:ARCHANA ENTURU
	  */
     public static void click_customerNameBtn() {
			customerName().click();}


}




