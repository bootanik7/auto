package V4.Smoke.client_console.applibs;
import core.webwidgets.Button;
import core.webwidgets.StaticText;
import core.webwidgets.TextField;

public class ClientCon_Admin_Verify_Modify_User_page {

	
	public static TextField Adm_md_email(){
		return new TextField("//*[@name='emailAddress']");}

	public static String get_MD_Email(){
		String EmailAdm = Adm_md_email().getText();
	return EmailAdm;}
//////////////////////////// object declaration available in admin mange page
	public static String get_Teamname(){
		String Teamname = ClientConsole_Admin_Page.AD_Team().getText();
	return Teamname;}

	public static Button Adm_ResetPassword(){
		return new Button("//*[@name='ResetPassword']");}
    public static  void click_ResetPasword(){
    	Adm_md_email().click();
    }
    public static StaticText Password_reset_confMsg(){
		return new StaticText(" //*[contains(text(),'Password has been reset for mark0001.')]");}


	public static String  get_confirmation_text(){
		String psConfMsg =Password_reset_confMsg().getText();
		return psConfMsg;}
  


	public static Button Admin_continue(){
		return new Button("//*[@value='Continue']");}
	 public static void click_admin_btnConf(){
		 Admin_continue().click();}
	 
	 
	 
		/* public static RadioButton Search_User(){
			 return new RadioButton("//*[@value='testuser930' and @name='login'  ]");
		 }
	 
		 public static void Select_User_To_Search(){
			 Search_User().click();
		 }*/
		   
	 
	 }

