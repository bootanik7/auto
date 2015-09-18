package V4.Smoke.enrollment.applibs;


import java.util.Map;

import V4.Smoke.otp.applibs.Common_Class;
import core.webwidgets.*;




public class Erm_PayYourBillNow_EPI_Page 
{

	/**
	 * WebWidget object for "PayYourBillNow_Object_Calendar" WebWidget with locator of "//*[@src='/enrollment/506050/images/calendar.gif']"
	 * @return web UI WebWidget object for the "PayYourBillNow_Object_Calendar" WebWidget with locator of "//*[@src='/enrollment/506050/images/calendar.gif']"
	 */
	public static WebWidget PayYourBillNow_Object_Calendar()
	{
		return new WebWidget("//*[@src='/enrollment/506050/images/calendar.gif']"," ");

	}
	/**
	 * TextField object for "PayYourBillow_TextBox_payment_info1" TextField with locator of ("name=payment.remitFields[0].value")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_payment_info1" TextField with locator of ("name=payment.remitFields[0].value")
	 */


	/**
	 * TextField object for "PayYourBillNow_TextBox_PmtReqDate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 * @return web UI TextField object for the "PayYourBillNow_TextBox_PmtReqDate" TextField with locator of "//*[@name='payment.requestedPaymentDate']"
	 */
	public static TextField PayYourBillNow_TextBox_PmtReqDate() {
		return new TextField("//*[@name='payment.requestedPaymentDate']");
	}
	public static void PmtReqDate(String s3)
	{
		PayYourBillNow_TextBox_PmtReqDate().setText(s3);
	}



	public static TextField PayYourBillNow_payment_info1()
	{
		return new TextField("name=payment.remitFields[0].value"); 
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_payment_info3" TextField with locator of ("name=payment.remitFields[2].value")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_payment_info3" TextField with locator of ("name=payment.remitFields[2].value")
	 */
	public static TextField PayYourBillNow_payment_info3()
	{
		return new TextField("name=payment.remitFields[2].value");
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_NameOnBank_Ac" TextField with locator of ("name=bankAccount.accountHolderName")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_NameOnBank_Ac"" TextField with locator of ("name=bankAccount.accountHolderName")
	 */
	public static TextField PayYourBillNow_NameOnBank_Ac()
	{
		return new TextField("name=bankAccount.accountHolderName");
	} 
	public static void Enter_NameOnBank_Ac(String s)
	{
		PayYourBillNow_NameOnBank_Ac().setText(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_Routing_No" TextField with locator of ("name=bankAccount.routingNumber")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Routing_No" TextField with locator of ("name=bankAccount.routingNumber")
	 */
	public static TextField PayYourBillNow_Routing_No()
	{
		return new TextField("name=bankAccount.routingNumber");

	}
	public static void Enter_Routing_No(String s)
	{
		PayYourBillNow_Routing_No().setText(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_Bank_Ac_No" TextField with locator of ("name=bankAccount.bankAccountNumber")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Bank_Ac_No" TextField with locator of ("name=bankAccount.bankAccountNumber")
	 */
	public static TextField PayYourBillNow_Bank_Ac_No()
	{
		return new TextField("name=bankAccount.bankAccountNumber");
	}
	public static void Enter_Bank_Ac_No(String s)
	{
		PayYourBillNow_Bank_Ac_No().setText(s);
	}

	/**
	 * ListBox object for "PayYourBillNow_DropDown_State" ListBox with locator of "name=bankAccount.accountState"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_State" ListBox with locator of "name=bankAccount.accountState"
	 */
	public static ListBox PayYourBillNow_DropDown_State() 
	{
		return new ListBox("name=bankAccount.accountState");
	}
	public static void click_on_State(String s)
	{
		PayYourBillNow_DropDown_State().selectItem(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_zip" TextField with locator of ("name=bankAccount.accountPostalCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_zip" TextField with locator of ("name=bankAccount.accountPostalCode")
	 */

	public static TextField PayYourBillNow_zip()
	{
		return new TextField("name=bankAccount.accountPostalCode");
	} 
	public static void Enter_zip(String s)
	{
		PayYourBillNow_zip().setText(s);
	}

	/**
	 * Ern_PayYourBillNow_page Continue button
	 * @return Returns web UI object of specified type and definition
	 */ 

	public static Button PayYourBillNow_Button_Continue()
	{
		return new Button("name=SubmitPaymentbtn");     
	}                           

	public static void click_on_Continue() 
	{
		PayYourBillNow_Button_Continue().click();
	}
	/**
	 * Link object for "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 * @return web UI Link object for the "Login_Link_ForgotPassword" Link with locator of "link=Forgot Password"
	 */
	public static Link PayYourBillNow_Link_Cancel() 
	{
		return new Link("name=Cancel");
	}
	public static void click_on_Cancel()
	{
		PayYourBillNow_Link_Cancel().click();  

	}
	/**
	 * RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 * @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 */
	public static RadioButton PayYourBillNow_Radio_PC() 
	{
		return new RadioButton("//*[@value='PERSONAL CHECKING']");
	}
	public static void click_Pc()
	{
		PayYourBillNow_Radio_PC().click();
	}

	/**
	 * RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 * @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 */
	public static RadioButton PayYourBillNow_Radio_BC() {
		return new RadioButton("//*[@value='BUSINESS CHECKING']");
	}
	public static void click_Bc()
	{
		PayYourBillNow_Radio_BC().click();
	}

	/**
	 * RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 * @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 */
	public static RadioButton PayYourBillNow_Radio_Amp_Others()
	{
		return new RadioButton("//*[@value='OTHER_AMOUNT']");
	}
	public static void click_on_OthersAmout()
	{
		PayYourBillNow_Radio_Amp_Others().click();
	}

	/**
	 * RadioButton object for "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 * @return web UI RadioButton object for the "PayYourBillNow_Radio_PC" RadioButton with locator of "//*[@value='PERSONAL CHECKING']"
	 */
	public static RadioButton PayYourBillNow_Radio_Pc()
	{
		return new RadioButton("//*[@value='PERSONAL SAVINGS']");
	
	}
	public static void click_Ps()
	{
		PayYourBillNow_Radio_Pc().click();
	}
	public static RadioButton PayYourBillNow_Radio_Bs() 
	{
		return new RadioButton("//*[@value='BUSINESS SAVINGS']");
	}
	public static void click_Bs()
	{
		PayYourBillNow_Radio_BC().click();
	}

	

	/**
	 * TextField object for "PayYourBillow_TextBox_zip" TextField with locator of ("name=bankAccount.accountPostalCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_zip" TextField with locator of ("name=bankAccount.accountPostalCode")
	 */

	public static TextField PayYourBillNow_Amount_to_be_paid()
	{
		return new TextField("name=payment.remitAmount");
	} 
	public static void PayYourBillNow_Enter_Amount(String s2)
	{
		PayYourBillNow_Amount_to_be_paid().setText(s2);
	}



	/** Object Class Type Not found object for "PayYourBillNow_CheckBox_termandcondt" Object Class Type Not found with locator of "//*[@name='termsAndConditionsFlag']"
	 * @return web UI Object Class Type Not found object for the "PayYourBillNow_CheckBox_termandcondt" Object Class Type Not found with locator of "//*[@name='termsAndConditionsFlag']"
	 */ 
	public static CheckBox Erm_Invoice1()
	{
			 return new CheckBox("//*[@value='Inv1']");
			 }
	   public static void click_Erm_Invoice1()
	{
		   Erm_Invoice1().check();
	 }
	   public static Boolean isInvoicePresent1()
	{
		  return  Erm_Invoice1().isVisible();
	   }
	
	public static Button nacha_yes_btn()
	{
		return new Button("//*[contains(text(),'Yes')]");
	}
	public static void btnYes()
	{
		nacha_yes_btn().click();
	}

	public static void Enter_payment_details(Map<String,String>Ed,String ACH_types) 
	{
		if(Erm_PayYourBillNow_EPI_Page.isInvoicePresent1())
		{
			Erm_PayYourBillNow_EPI_Page.click_Erm_Invoice1();  
		}
		else
		{
			Erm_PayYourBillNow_EPI_Page.click_on_OthersAmout();
			Erm_PayYourBillNow_EPI_Page.PayYourBillNow_Enter_Amount(Ed.get("Amount"));
		}
		Erm_PayYourBillNow_EPI_Page.PmtReqDate(Common_Class.getsystemdate());
		Erm_PayYourBillNow_EPI_Page.Enter_NameOnBank_Ac(Ed.get("NameOnBank_Ac"));
		Erm_PayYourBillNow_EPI_Page.Enter_Routing_No(Ed.get("Routing_No"));
		Erm_PayYourBillNow_EPI_Page.Enter_Bank_Ac_No(Ed.get("Bank_Ac_No"));
		Erm_PayYourBillNow_EPI_Page.click_on_State(Ed.get("State"));
		Erm_PayYourBillNow_EPI_Page.Enter_zip(Ed.get("zip"));

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
		Erm_PayYourBillNow_EPI_Page.click_on_Continue();
	}

}
