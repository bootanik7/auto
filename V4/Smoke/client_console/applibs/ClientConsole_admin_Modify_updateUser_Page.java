package V4.Smoke.client_console.applibs;

import core.webwidgets.StaticText;

public class ClientConsole_admin_Modify_updateUser_Page {



	public static StaticText Update_visible_Text(){
		return new StaticText(" //*[@class='body-page-header' and contains(text(),'Update User')]");}


	public static String  get_updateMsg_VisText(){
		String uText =Update_visible_Text().getText();
		return uText;}


	public static StaticText Update_confMsg(){
		return new StaticText(" //*[contains(text(),'Password has been reset for mark0001.')]");}


	public static String  get_Update_confMsg(){
		String UpdateConfMsg =Update_confMsg().getText();
		return UpdateConfMsg;}























}
