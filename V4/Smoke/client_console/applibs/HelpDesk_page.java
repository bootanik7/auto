package V4.Smoke.client_console.applibs;

import java.util.Map;

import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class HelpDesk_page {

	
	public static Link HomePage_Link_HelpDesktab() {
		return new Link("link=HELP DESK");
	}
	
	public static void click_HomePage_Link_HelpDesktab(){
		HomePage_Link_HelpDesktab().click();
	}
	public static TextField UserName(){
		return new TextField("//*[@name='firstName']");
	}
	public static void enter_UserName(String sText){
		UserName().setText(sText);
	}
	
	public static TextField LastName(){
		return new TextField("//*[@name='lastName']");}
	
		public static void enter_LastName(String sText){
			LastName().setText(sText);}
	
	public static TextField LoginId(){
		return new TextField("//input[@name='login' ]");}
	
	public static void enter_LoginId(String sText){
		LoginId().setText(sText);}

	public static Button btn_Go_Name(){
		return new Button("//*[@value='Go' and  @name='ModifyUsers']");}
	
	
	public static void click_Go_Name(){
		btn_Go_Name().click();}
	
	
	public static Button btn_Go_LoginId(){
		return new Button("//input[@ name='ModifyUser' and @value='Go']");}

	public static void click_Go_LoginId(){
		btn_Go_LoginId().click();}
	
	
	
	
	public static Button btn_View(){
		return new Button("//*[@value='View']");}
	public static void click_View(){
		btn_View().click();}

	public static Button btn_Download_list(){
		return new Button("//*[@ value='Download User List']");}
	public static void click_DL(){
		btn_Download_list().click();}
	
	public static ListBox Role(){
		return new ListBox("//*[@ name='role']");}
	
	public static void enter_Role(String sText){
		Role().selectItem(sText);}
	
	public static ListBox Select_by_team(){
		return new ListBox("//*[@name='team']");}
	
	public static void enter_Team(String sText){
		Select_by_team().selectItem(sText);}


	public static Button HelpDesk_Button_Cancel() {
		return new Button("//*[@value='Cancel']");
	}

	public static void click_HelpDesk_Button_Cancel(){
		HelpDesk_Button_Cancel().click() ;
	}

 public static void Search_User_HelpDesk_FUn(Map<String, String> sd){
	 HelpDesk_page.enter_Role(sd.get("Role"));

		HelpDesk_page.enter_Team(sd.get("Team"));

		HelpDesk_page.click_View();

 }
}

