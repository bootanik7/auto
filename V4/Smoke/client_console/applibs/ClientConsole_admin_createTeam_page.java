package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.StaticText;

public class ClientConsole_admin_createTeam_page {



	public static StaticText createteam_visible_Text()
	{
		return new StaticText(" //*[@class='body-page-header' and contains(text(),'Create a Team')]");

	}


	public static String  get_createteam_VisText()
	{
		String string =createteam_visible_Text().getText();
		return string;

	}

	public static Button btnSave()
	{
		return new Button("//*[@ value='Save']");
	}
	
	
	public static void click_btnSaveTeam()
	{
		btnSave().click();
	}
}
