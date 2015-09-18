package V4.Smoke.client_console.applibs;

import core.webwidgets.Link;

public class clientConsole_logout_page {

	public static Link ChangeUserPassword_Link_LogOut() {
		return new Link("//*[@name='Image3']");}

   public static void CC_logout(){
	   ChangeUserPassword_Link_LogOut().click();
   }

}
