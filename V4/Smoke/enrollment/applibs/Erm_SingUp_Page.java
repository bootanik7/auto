package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.*;

public class Erm_SingUp_Page 
{
	
	   /** TextField object for "SingUp_TextBox_Acntnum" TextField with locator of ("name=billingAccountNumber")
	    * @return web UI TextField object for the "SingUp_TextBox_Acntnum" TextField with locator of ("name=billingAccountNumber")
	    */
	   public static TextField SingUp_TextBox_Acntnum()
	   {
		return new TextField("name=billingAccountNumber");
	    }
	   public static void Enter_Account_Num(String s)
		{
		   SingUp_TextBox_Acntnum().setText(s);
		}
	   
	   /**
	    * TextField object for "SingUp_TextBox_UserName" TextField with locator of ("name=consumerProfile.username")
	    * @return web UI TextField object for the "SingUp_TextBox_UserName" TextField with locator of ("name=consumerProfile.username")
	    */
	   public static TextField SingUp_TextBox_UserName()
	   {
		return new TextField("name=consumerProfile.username");
	    }
	   public static void Enter_UserName(String s)
		{
		   SingUp_TextBox_UserName().setText(s);
		}
	    /**
	    * TextField object for "SingUp_TextBox_Retype_UserName" TextField with locator of ("name=confirmUserName")
	    * @return web UI TextField object for the "SingUp_TextBox_Retype_UserName" TextField with locator of ("name=confirmUserName")
	    */
	   public static TextField SingUp_TextBox_Retype_UserName()
	   {
		return new TextField("name=confirmUserName");
	    }
	   public static void Enter_Retype_UserName(String s)
		{
		   SingUp_TextBox_Retype_UserName().setText(s);
		}
	   /**
	    * TextField object for "SingUp_TextBox_Password" TextField with locator of ("name=consumerProfile.password")
	    * @return web UI TextField object for the "SingUp_TextBox_Password" TextField with locator of ("name=consumerProfile.password")
	    */
	   public static TextField SingUp_TextBox_Password()
	   {
		return new TextField("name=consumerProfile.password");
	    }
	   public static void Enter_Password(String s)
		{
		   SingUp_TextBox_Password().setText(s);
		}
	  /**
	    * TextField object for "SingUp_TextBox_ConPassword" TextField with locator of ("name=confirmPassword")
	    * @return web UI TextField object for the "SingUp_TextBox_ConPassword" TextField with locator of ("name=confirmPassword")
	    */
	   public static TextField SingUp_TextBox_ConPassword()
	   {
		return new TextField("name=confirmPassword");
	    }
	   public static void Enter_ConPassword(String s)
		{
		   SingUp_TextBox_ConPassword().setText(s);
		}
	   
	   public static Button GotoAcctPagebtn()
	   {
		return new Button("name=confirmPassword");
	    }
	    public static void clickGotoAcctPagebtn()
	    {
	    	GotoAcctPagebtn().click();
	    }
	   
	   public static void Enter_SingUp_details(Map<String,String> Ed)
	   {
	   Erm_ManagePersonal_IP_BSU_Page.Enter_CustomerName(Ed.get("CustomerName"));
	   Erm_SingUp_Page.Enter_Account_Num(Ed.get("ACCOUNT_NUMBER"));
	   if(Erm_Login_Page.Login_TextBox_SecurityKey_Ac_Info1().isVisible()){
	   Erm_Login_Page.Enter_Security_Num1(Ed.get("ACCOUNT_INFO_01"));
	   }else if(Erm_Login_Page.Login_TextBox_SecurityKey_Ac_Info2().isVisible()){
		   Erm_Login_Page.Enter_Security_Num2(Ed.get("ACCOUNT_INFO_02"));
	   }
	   //else if(Erm_Login_Page.Login_DropDown_Division().isVisible()) {
	   Erm_Login_Page.select_Division(Ed.get("PRIMARY_NAME"));
	 //  }
	   Erm_ManagePersonal_IP_Email_Page.Enter_NewEmailId(Ed.get("NewEmailId"));
	   
	   if(Erm_ManagePersonal_IP_Email_Page.ManagePersonalInfo_TextBox_ConfirmEmail().isVisible()){
		   Erm_ManagePersonal_IP_Email_Page.Enter_ConfirmEmailId(Ed.get("ConfirmEmailId"));
 
	   }
	   Erm_SingUp_Page.Enter_UserName(Ed.get("UserName"));
	   if(Erm_SingUp_Page.SingUp_TextBox_Retype_UserName().isVisible()){
	   Erm_SingUp_Page.Enter_Retype_UserName(Ed.get("Retype_UserName"));
	   }
	   Erm_SingUp_Page.Enter_Password(Ed.get("Password"));
	   Erm_SingUp_Page.Enter_ConPassword(Ed.get("ConPassword"));
	   if(Erm_ManagePersonal_IP_BSU_Page.BillerSignUp_TextBox_Add1().isVisible()){
	   Erm_ManagePersonal_IP_BSU_Page.Enter_Add1(Ed.get("Add1"));
	   Erm_ManagePersonal_IP_BSU_Page.Enter_Add2(Ed.get("Add2"));
	   Erm_ManagePersonal_IP_BSU_Page.Enter_City(Ed.get("City"));
	   Erm_ManagePersonal_IP_BSU_Page.Enter_Zip(Ed.get("Zip"));
	   Erm_ManagePersonal_IP_BSU_Page.Enter_ContactNo(Ed.get("ContactNo"));
	   Erm_ManagePersonal_IP_BSU_Page.select_State(Ed.get("State"));
	   }
	   if(Erm_PayYourBillNow_RPI_Page.PayYourBillNow_CheckBox_termandcondt().isVisible()){
	   Erm_PayYourBillNow_RPI_Page.click_on_termandcondt();
	   }
	   Erm_ManagePersonal_IP_BSU_Page.click_on_Submit();
	   //Erm_SingUp_Page.clickGotoAcctPagebtn();
	   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

}
