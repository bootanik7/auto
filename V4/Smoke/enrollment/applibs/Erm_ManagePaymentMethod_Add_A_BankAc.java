package V4.Smoke.enrollment.applibs;

import java.util.Map;

import core.webwidgets.ListBox;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

public class Erm_ManagePaymentMethod_Add_A_BankAc
{
	/*
	* Object Class Type Not found object for "ManagePaymentMethods_field_User_Name" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountHolderName']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_User_Name" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountHolderName']"
	*/
	public static TextField managePaymentMethods_TextField_NameOnBank_Ac()
	{
		return new TextField("name=fundingAccount.accountHolderName");
	}
	public static void Enter_NameOnBank_Ac(String s)
    {
		managePaymentMethods_TextField_NameOnBank_Ac().setText(s);
    }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_NIck_Name" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountNickname']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_NIck_Name" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountNickname']"
	*/
	public static TextField managePaymentMethods_TextField_Ac_Nick_Name() 
	{
		return new TextField("name=fundingAccount.accountNickname");
	}
	public static void Enter_Ac_Nick_Name(String s)
    {
		managePaymentMethods_TextField_Ac_Nick_Name().setText(s);
    }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_Routing_Number" Object Class Type Not found with locator of "//*[@name='fundingAccount.routingNumber']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_Routing_Number" Object Class Type Not found with locator of "//*[@name='fundingAccount.routingNumber']"
	*/
	public static TextField managePaymentMethods_TextField_Routing_Num() 
	{
		return new TextField("name=fundingAccount.routingNumber");
	}
	public static void Enter_Routing_No(String s)
    {
		managePaymentMethods_TextField_Routing_Num().setText(s);
    }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_BnkAcnt_Number" Object Class Type Not found with locator of "//*[@name='fundingAccount.bankAccountNumber']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_BnkAcnt_Number" Object Class Type Not found with locator of "//*[@name='fundingAccount.bankAccountNumber']"
	*/
	public static TextField managePaymentMethods_TextField_Bank_Ac_No()
	{
		return new TextField("name=fundingAccount.bankAccountNumber");
	}
	public static void Enter_Bank_Ac_No(String s)
    {
		managePaymentMethods_TextField_Bank_Ac_No().setText(s);
    }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_CA1" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountAddress1']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_CA1" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountAddress1']"
	*/
	public static TextField managePaymentMethods_TextField_CAdd1()
	{
		return new TextField("name=fundingAccount.accountAddress1");
	}                        
	public static void Enter_CAdd1(String s)
	{
	managePaymentMethods_TextField_CAdd1().setText(s);	
	}


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_CA2" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountAddress2']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_CA2" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountAddress2']"
	*/
	public static TextField ManagePaymentMethods_TextField_CAdd2()
	{
		return new TextField("name=fundingAccount.accountAddress2");
	}
	public static void Enter_CAdd2(String s)
	{
		ManagePaymentMethods_TextField_CAdd2().setText(s);	
	}


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_state" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountState']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_state" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountState']"
	*/
	public static ListBox ManagePaymentMethods_DropDown_state()
	{
		return new ListBox("name=fundingAccount.accountState");
	}
	 public static void click_on_State(String s)
     {
		 ManagePaymentMethods_DropDown_state().selectItem(s);
     }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_city" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountCity']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_city" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountCity']"
	*/
	public static TextField managePaymentMethods_TextField_city()
	{
		return new TextField("name=fundingAccount.accountCity");
	}
        public static void Enter_City(String s)
        {
        	managePaymentMethods_TextField_city().setText(s);
        }

	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_ZIP" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountPostalCode']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_ZIP" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountPostalCode']"
	*/
	public static TextField managePaymentMethods_TextField_Zip()
	{
		return new TextField("name=fundingAccount.accountPostalCode");
	}
	 public static void Enter_zip(String s)
     {
		 managePaymentMethods_TextField_Zip().setText(s);
     }


	/**
	* Object Class Type Not found object for "ManagePaymentMethods_field_Country" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountCountryCode']"
	* @return web UI Object Class Type Not found object for the "ManagePaymentMethods_field_Country" Object Class Type Not found with locator of "//*[@name='fundingAccount.accountCountryCode']"
	*/
	public static ListBox ManagePaymentMethods_DropDown_Country() {
		return new ListBox("name=fundingAccount.accountCountryCode");
	}
	public static void click_on_Country(String s)
    {
		 ManagePaymentMethods_DropDown_Country().selectItem(s);
    }
	
	public static boolean is_Country()
    {
		 return ManagePaymentMethods_DropDown_Country().isVisible();
    }

	
	/**
		* RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
		* @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
		*/
	public static RadioButton ManagePaymentMethods_Radio_PS() 
	{
		return new RadioButton("//*[@value='PERSONAL SAVINGS']");
	}
	public static void click_Ps()
	{
		ManagePaymentMethods_Radio_PS().click();
	}
      
		/**
		* RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
		* @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
		*/
		public static RadioButton ManagePaymentMethods_Radio_BS() {
			return new RadioButton("//*[@value='BUSINESS CHECKING']");
		}
		public static void click_Bs()
	 	{
			ManagePaymentMethods_Radio_BS().click();
	 	}
		
		public static void  Add_a_BankAc_details(Map<String,String> Ed,String ACH_types)
		{
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_NameOnBank_Ac(Ed.get("NameOnBank_Ac"));
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Ac_Nick_Name(Ed.get("NickName"));
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Routing_No(Ed.get("Routing_No"));
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_Bank_Ac_No(Ed.get("Bank_Ac_No"));
	    Erm_ManagePaymentMethod_Add_A_BankAc.Enter_CAdd1(Ed.get("Add1"));
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_CAdd2(Ed.get("Add2"));
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_City(Ed.get("City"));
		
		if(ACH_types.contains("Business Savings"))
		{

			Erm_PayYourBillNow_EPI_Page.click_Bs();

		}
		else if(ACH_types.contains("Business Checking")) 
		{

			Erm_PayYourBillNow_EPI_Page.click_Bc();

		}
		else if(ACH_types.contains("Personal Savings"))
		{

			Erm_PayYourBillNow_EPI_Page.click_Ps();

		}
		else if(ACH_types.contains("Personal Checking")) 
		{

			Erm_PayYourBillNow_EPI_Page.click_Pc();
		}
		
		//Erm_ManagePaymentMethod_Add_A_BankAc.click_Bs();
		
		Erm_ManagePaymentMethod_Add_A_BankAc.Enter_zip(Ed.get("zip"));
		Erm_ManagePaymentMethod_Add_A_BankAc.click_on_State(Ed.get("State"));
		if(Erm_ManagePaymentMethod_Add_A_BankAc.is_Country()){
		Erm_ManagePaymentMethod_Add_A_BankAc.click_on_Country(Ed.get("COUNTRY"));
		}
		Erm_PayYourBillNow_Card_Page.click_on_Continue();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
