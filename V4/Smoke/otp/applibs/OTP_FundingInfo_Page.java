package V4.Smoke.otp.applibs;

import core.webwidgets.Button;
import core.webwidgets.RadioButton;
import core.webwidgets.StaticText;

/**
 * Example UI WebWidget Library used for Unit Testing WebWidget methods and Selenium Core framework.
 * <P>
 * To Be used with WebUIObjects.htm file stored in the testdata folder
 */
public class OTP_FundingInfo_Page {


	/**
	 * Object Class Type RadioButton object for "RBSelectBank " Object RadioButton with locator of " //*[@value='BANK,' and @name='fundingInfo']"
	 * @return web UI Object RadioButton found for the "RBSelectBank " Object Class Type RadioButton with locator of " //*[@value='BANK,' and @name='fundingInfo']"
	 */
	public static RadioButton RBSelectBank () {
		return new RadioButton(" //*[@value='BANK,' and @name='fundingInfo']");
	}


	/**
	 * Object Class Type RadioButton object for "RBSelectCard" Object RadioButton with locator of "//*[@value='Card Push' and @name='fundingInfo']"
	 * @return web UI Object Class RadioButton found for the "RBSelectCard" Object Class Type RadioButton with locator of "//*[@value='Card Push' and @name='fundingInfo']"
	 */
	public static RadioButton RBSelectCard() {
		return new RadioButton("//*[@value='Card Push' and @name='fundingInfo']");
	}

	/**
	 * Object Class Type Button object for submit Object button with locator of ""name=Submitbtn""
	 * @return web UI Object Class Button found for the "submit" Object Class Type button with locator of "name=Submitbtn"
	 */

	public static Button submit(){

		return new Button("name=Submitbtn");
	}

	/**
	 * Object Class Type Button object for submit Object button with locator of ""value=Cancel"
	 * @return web UI Object Class Button found for the "submit" Object Class Type button with locator of "value=Cancel"
	 */

	public static Button cancel(){

		return new Button("value=Cancel");
	}

	/**
	 * Object Class Type Button for "Lviewpmnthistry" Object Class Type Button found with locator of "link=View Payment History"
	 * @return web UI Object Class Type Button object for the "Lviewpmnthistry" Object Class Type Button with locator of "link=View Payment History"
	 */
	public static Button Lviewpmnthistry() {
		return new Button("link=View Payment History");
	}


	/**
	 * Object Class Type StaticText for "AccountInfoText" Object Class Type StaticText found with locator of "//span[@id='accountholdertier']"
	 * @return web UI Object Class Type StaticText object for the "//span[@id='accountholdertier']" Object Class Type StaticText with locator of "//span[@id='accountholdertier']"
	 */

	public static StaticText AccountInfoText(){

		return new StaticText("//span[@id='accountholdertier']");
	}


	public static void clickbutton() {
		submit().click();   }

	public static void clickbuttonCancel() {
		cancel().click();	}

	public static boolean isclickRadioButtonBankpresent() {
		return RBSelectBank().isVisible(); }

	public static void clickRadioButtonBank() {
		RBSelectBank().click(); }

	public static boolean isclickRadioButtonCardpresent() {
		return RBSelectCard().isVisible();  }


	public static void clickRadioButtonCard() {
		RBSelectCard().click();  }

	public static void clickbuttonPaymentHistory() {
		Lviewpmnthistry().click();   }

	public static String accNumVisibleText(){
		return AccountInfoText().getText();
	}

	public static void selectcardpayment(){
		
		if(OTP_FundingInfo_Page.isclickRadioButtonCardpresent()){

			clickRadioButtonCard();	
			Otp_payment_info_page. click_on_submit();
		}
	}

	public static void selectBankPayment(){

		if(OTP_FundingInfo_Page.isclickRadioButtonBankpresent()){

			clickRadioButtonBank();

			Otp_payment_info_page.click_on_submit();
		}
	}

}
