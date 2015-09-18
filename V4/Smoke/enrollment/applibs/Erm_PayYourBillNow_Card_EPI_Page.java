package V4.Smoke.enrollment.applibs;


import java.util.Map;

import V4.Smoke.otp.applibs.Common_Class;
import core.webwidgets.ListBox;
import core.webwidgets.TextField;

public class Erm_PayYourBillNow_Card_EPI_Page 
{


	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCardType() 
	{
		return new ListBox("name=creditCardAccount.creditCardType");
	}
	public static void select_CreditCardType(String s)
	{
		PayYourBillNow_DropDown_CreditCardType().selectItem(s);
	}
	/**
	 * TextField object for "PayYourBillow_TextBox_CreditCard_No" TextField with locator of ("name=creditCardAccount.creditCardNumber")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CreditCard_No" TextField with locator of ("name=creditCardAccount.creditCardNumbere")
	 */
	public static TextField PayYourBillNow_CreditCard_No()
	{
		return new TextField("name=creditCardAccount.creditCardNumber");
	}

	/**
	 * TextField object for "PayYourBillow_TextBox_Nameof_CreditCard_No" TextField with locator of ("name=creditCardAccount.accountHolderName")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Nameof_CreditCard_No" TextField with locator of ("name=creditCardAccount.accountHolderName")
	 */
	public static TextField PayYourBillNow_NameOnCreditCard()
	{
		return new TextField("name=creditCardAccount.accountHolderName");
	}
	public static void Enter_NameOnCreditCard(String s)
	{
		PayYourBillNow_NameOnCreditCard().setText(s);
	}

	/**
	 * TextField object for "PayYourBillow_TextBox_CardCvvo" TextField with locator of ("name=creditCardAccount.securityCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CardCvv" TextField with locator of ("name=creditCardAccount.securityCode")
	 */
	public static TextField PayYourBillNow_CardCvv()
	{
		return new TextField("name=creditCardAccount.securityCode");
	}
	public static void Enter_CardCvv(String s)
	{
		PayYourBillNow_CardCvv().setText(s);
	}

	/**
	 * TextField object for "PayYourBillow_TextBox_CustAdd1" TextField with locator of ("name=creditCardAccount.accountAddress1")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CustAdd1" TextField with locator of ("name=creditCardAccount.accountAddress1")
	 */
	public static TextField PayYourBillNow_CustAdd1()
	{
		return new TextField("name=creditCardAccount.accountAddress1");
	}
	public static void Enter_CustAdd1(String s)
	{
		PayYourBillNow_CustAdd1().setText(s);
	}


	/**
	 * TextField object for "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=creditCardAccount.accountAddress2")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=creditCardAccount.accountAddress2")
	 */
	public static TextField PayYourBillNow_CustAdd2()
	{
		return new TextField("name=creditCardAccount.accountAddress2");
	}
	public static void Enter_CustAdd2(String s)
	{
		PayYourBillNow_CustAdd2().setText(s);
	}

	/**
	 * TextField object for "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=creditCardAccount.accountCity")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_CustAdd2" TextField with locator of ("name=creditCardAccount.accountCity")
	 */
	public static TextField PayYourBillNow_City()
	{
		return new TextField("name=creditCardAccount.accountCity");
	}
	public static void Enter_City(String s)
	{
		PayYourBillNow_City().setText(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardType" ListBox with locator of "name=creditCardAccount.creditCardType"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCardExp_Month() 
	{
		return new ListBox("name=creditCardAccount.expirationMonth");
	}
	public static void select_CreditCardExp_Month(String s)
	{
		PayYourBillNow_DropDown_CreditCardExp_Month().selectItem(s);
	}

	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardExp_Year" ListBox with locator of "name=creditCardAccount.expirationYear"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardExp_Year" ListBox with locator of "name=creditCardAccount.expirationYear"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCardExp_Year() 
	{
		return new ListBox("name=creditCardAccount.expirationYear");
	}
	public static void select_CreditCardExp_Year(String s)
	{
		PayYourBillNow_DropDown_CreditCardExp_Year().selectItem(s);
	}

	/**
	 * TextField object for "PayYourBillow_TextBox_Zipcode" TextField with locator of ("name=creditCardAccount.accountPostalCode")
	 * @return web UI TextField object for the "PayYourBillow_TextBox_Zipcode" TextField with locator of ("name=creditCardAccount.accountPostalCode")
	 */
	public static TextField PayYourBillNow_Zipcode()
	{
		return new TextField("name=creditCardAccount.accountPostalCode");
	}
	public static void Enter_Zipcode(String s)
	{
		PayYourBillNow_Zipcode().setText(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCardState" ListBox with locator of "name=creditCardAccount.accountState"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCardState() 
	{
		return new ListBox("name=creditCardAccount.accountState");
	}
	public static void select_CreditCardState(String s)
	{
		PayYourBillNow_DropDown_CreditCardState().selectItem(s);
	}
	/**
	 * ListBox object for "PayYourBillNow_DropDown_CreditCard_Country" ListBox with locator of "name=creditCardAccount.accountCountryCode"
	 * @return web UI ListBox object for the "PayYourBillNow_DropDown_CreditCard_Country" ListBox with locator of "name=creditCardAccount.accountCountryCode"
	 */
	public static ListBox PayYourBillNow_DropDown_CreditCard_Country() 
	{
		return new ListBox("name=creditCardAccount.accountCountryCode");
	}
	public static void select_CreditCard_Country(String s)
	{
		PayYourBillNow_DropDown_CreditCard_Country().selectItem(s);
	}


	public static void Enter_CC_payment_details(Map<String,String>Ed,String CC_Types) 
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

		Erm_PayYourBillNow_Card_EPI_Page.select_CreditCardType(Ed.get("CARD_TYPE"));

		Erm_PayYourBillNow_Card_EPI_Page.Enter_NameOnCreditCard(Ed.get("ACCOUNT_HOLDER_NAME"));
		if(Ed.get("CARD").equals("Credit")){
			{
				if(CC_Types!="AMEX")
				{
					Erm_PayYourBillNow_Card_EPI_Page.Enter_CardCvv(Ed.get("CVV"));
				}else 
				{
					Erm_PayYourBillNow_Card_EPI_Page.Enter_CardCvv(Ed.get("CVV"));
				}
			}
		}


		// Erm_PayYourBillNow_Card_EPI_Page.Enter_CustAdd1("add1");
		// Erm_PayYourBillNow_Card_EPI_Page.Enter_CustAdd2("add2");

		Erm_PayYourBillNow_Card_EPI_Page.select_CreditCardExp_Month(Ed.get("EXP_MONTH"));

		Erm_PayYourBillNow_Card_EPI_Page.select_CreditCardExp_Year(Ed.get("EXP_YEAR"));

		//Erm_PayYourBillNow_Card_EPI_Page.Enter_City("Bangalore");
		Erm_PayYourBillNow_Card_EPI_Page.Enter_Zipcode(Ed.get("ACCOUNT_POSTAL_CODE"));

		Erm_PayYourBillNow_Card_EPI_Page.select_CreditCardState(Ed.get("State"));

		Erm_PayYourBillNow_Card_EPI_Page.select_CreditCard_Country(Ed.get("COUNTRY"));

		Erm_PayYourBillNow_EPI_Page.click_on_Continue();



	}





}
