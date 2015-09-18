package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;


public class ClientConsole_admin_CreateTeam_conf_page {


	public static Button btnNewTeam(){
		return new Button("//*[@ value='New Team']");}
	public static void click_btnNewTeam()
	{
			btnNewTeam().click();
			
	}

	public static StaticText cteteam_SuccessMSg(){
		return new StaticText(" //*[@class='body-page-subheader' and contains(text(),'Team priyaTest9 succesfully created.')]");}


	public static String  get_createteam_VisText()
	{
		String string =cteteam_SuccessMSg().getText();
		return string;
   }












}
