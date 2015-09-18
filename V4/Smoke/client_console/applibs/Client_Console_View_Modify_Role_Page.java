package V4.Smoke.client_console.applibs;

import java.util.Map;


import core.webwidgets.Button;

public class Client_Console_View_Modify_Role_Page {

	public static Button ManageTransaction_Button_ModifyRole() {
		return new Button("//*[@name='ModifyRole']");
	}
public static void click_ManageTransaction_Button_ModifyRole(){
	ManageTransaction_Button_ModifyRole().click();
}

public static void Search_ROle_Fun(Map<String,String> sd){
	ClientConsole_Admin_Page.enter_RoleName(sd.get("role"));
    Client_Console_View_Modify_Role_Page.click_ManageTransaction_Button_ModifyRole();
}
}
