package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;

public class ClientConsole_admin_userDelete_page {


	public static StaticText Delete_visible_Text(){
		return new StaticText(" //*[@class='body-page-header' and contains(text(),'Delete User')]");}


	public static String  get_Delete_VisText(){
		String DText =Delete_visible_Text().getText();
		return DText;}


	public static Button btnDeleteUser(){
		return new Button("//*[@value='Delete User']");}
	 public static void click_btnDeleteUser(){
		 btnDeleteUser().click();}
	 

	 public static StaticText reconformation_delete_msg(){
			return new StaticText(" //*[contains(text(),'Are you sure you want to delete user mark0001?')]");}


		public static String  get_reconformation_delete_ms(){
			String string =reconformation_delete_msg().getText();
			return string;}



      














}
