package V4.Smoke.client_console.applibs;


import java.util.Map;

import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.Link;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class ClientConsole_Admin_Page {

	public static Link HomePage_Link_Admin() {
		return new Link("//*[contains(text(),'ADMINISTRATION')]");
	}
	public static void click_Admin_Link(){
		HomePage_Link_Admin().click();
	}

	public static TextField Admin_VText(){
		return new TextField("//p[@class='body-page-header' and contains(text(),'Administration')]");}


	public static String  get_Adm_VisibleText(){
		String AText =Admin_VText().getText();
		return AText;}


	public static Button btn_View(){
		return new Button("//*[@name='SearchUsers']");}

	public static void click_ON_View(){
		btn_View().click();}



	public static TextField filter_ByTeam(){
		return new TextField("//*[@name='team']");}

	public static void set_filter_ByTeam(String s){
		filter_ByTeam().setText(s);}

	
	public static TextField ENter_New_Role_name(){
		return new TextField("//*[@name='newRoleName']");}

	public static void set_ENter_New_Role_name(String s){
		 ENter_New_Role_name().setText(s);}
	
	public static Button Create_user_Go(){
		return new Button("//*[@name='CreateUser']");}

	public static void click_Create_user_Go(){
		Create_user_Go().click();}
	public static Button Create_user_Create(){
		return new Button("//*[@value='Create']");}

	public static void click_Create_user_Create(){
		Create_user_Create().click();}

	public static ListBox Search_RoleName(){
		return new ListBox("//*[@name='roleName']");}

	public static void enter_RoleName(String RM){
		Search_RoleName().selectItem(RM);}

	public static Button Modify_Role_Go(){
		return new Button("//*[name='ModifyRole']");}

	public static void click_Modify_Role_Go(){
		Modify_Role_Go().click();}

	public static Button Search_Roles(){
		return new Button("//*[@name='SearchRoles' and @ value='View']");}

	public static void click_Search_Roles(){
		Search_Roles().click();}

	public static Button create_Role_Go(){
		return new Button("//*[@name='CreateRole']");}

	public static void click_CRG(){
		create_Role_Go().click();}

	public static ListBox AD_Team(){
		return new  ListBox("//*[@name='teamName']");}
	
	public static void set_TeamName(String sText){
		AD_Team().selectItem(sText);
	}

    public static Button AD_Team_GO(){
		return new Button("//*[@name='ModifyTeam' and  @value='Go']");}
	public static void click_AD_Team_GO(){
		AD_Team_GO().click();}

	public static Button AD_Search_View(){
		return new Button("//*[@name='SearchTeams' and  @value='View']");}
	public static void click_AD_Search_View(){
		AD_Search_View().click();}

	public static Button AD_Down_TList(){
		return new Button("//*[@name='DownloadTeams' and  @value='Download Team List	']");}
	public static void click_Down_TList(){
		AD_Down_TList().click();}

	public static Button create_Team(){
		return new Button("//*[@name='CreateTeam']");}

	public static void click_BtnTeam(){
		create_Team().click();}

     
	
	
	public static void Search_Team_Fun(Map<String,String> sd){
    	
    	 ClientConsole_Admin_Page.Select_Team_name(sd.get("TEAM"));
			ClientConsole_Admin_Page.click_AD_Team_GO();
     }

    public static void Search_User_Fun(Map<String,String> sd){
    	HelpDesk_page.enter_LoginId(sd.get("Login_Id"));
		 HelpDesk_page.click_Go_LoginId();
    }
    public static void Search_User_HelpDesk(Map<String,String> sd){
    	HelpDesk_page.enter_Role(sd.get("role"));
		 HelpDesk_page. click_View();
    }

    public static CheckBox Role_checkBox(){
		return new CheckBox("//*[@name='roles']");}

	public static void click_Role_checkBox(){
		Role_checkBox().click();}

    
    
    


    public static TextField User_Login_Id(){
		return new TextField("//*[@name='newLogin']");}

	public static void enter_New_userID(String s){
		User_Login_Id().setText(s);}


	 public static TextField User_Name(){
			return new TextField("//*[@name='firstName']");}

		public static void enter_User_New_Name(String s){
			User_Name().setText(s);}


		public static TextField Last_Name(){
			return new TextField("//*[@name='lastName']");}

		public static void enter_new_last_name(String s){
			Last_Name().setText(s);}
		
		public static TextField New_Email(){
			return new TextField("//*[@name='emailAddress']");}

		public static void enter_New_Email(String s){
			New_Email().setText(s);}
		
		public static ListBox Team_Name(){
			return new ListBox("//*[@name='teamName']");}

		public static void Select_Team_name(String s){
			Team_Name().selectItem(s);}

		public static TextField NEW_Team_Name(){
			return new TextField("//*[@name='newTeamName']");}

		public static void enter_NEW_Team_Name(String s){
			NEW_Team_Name().setText(s);}

		public static Button Save_Create_team(){
			return new Button("//*[@value='Save']");}

		public static void click_Save_Create_team(){
			Save_Create_team().click();}


		public static CheckBox COLLECTPAY_DEMO_DIV(){
			return new CheckBox("//*[@name='divisionAccess']");}
		public static void click_COLLECTPAY_DEMO_DIV(){
			COLLECTPAY_DEMO_DIV().click();}

		public static Button Delete_Role(){
			return new Button("//*[@value='Delete Role']");}

		public static void click_Delete_Role(){
			Delete_Role().click();}
		
		public static Button Delete_Team(){
			return new Button("//*[@value='Delete Team']");}

		public static void click_Delete_Team(){
			Delete_Team().click();}
		
		
		public static Button Delete_User(){
			return new Button("//*[@value='Delete']");}

		public static void click_Delete_User(){
			Delete_User().click();}
		public static Button Delete_User_Button2(){
			return new Button("//*[@value='Delete']");}

		public static void click_Delete_User_BUtton2(){
			Delete_User_Button2().click();}



}



