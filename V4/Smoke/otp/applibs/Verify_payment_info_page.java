package V4.Smoke.otp.applibs;

import core.webwidgets.Button;
import core.webwidgets.CheckBox;

public class Verify_payment_info_page {

	/**
	 * Object Class CheckBox for "termsAndConditions" Object Class Type CheckBox with locator of ("//*[@name='termsAndConditions']")
	 * @return web UI Object CheckBox for the "termsAndConditions" Object Class Type Not found with locator of ("//*[@name='termsAndConditions']")
	 */
	public static CheckBox CBtermsAndConditions() {
		return new CheckBox("//*[@name='termsAndConditions']");
	}


	/**
	 * Object Class Type Button for "Btnconfirm" Object Class Type Button with locator of "//*[@value='Confirm']"
	 * @return web UI Object Class Type Button for the "Btnconfirm" Object Class Type Button locator of "//*[@value='Confirm']"
	 */
	public static Button Btnconfirm() {
		return new Button("//*[@value='Confirm']");
	}

	/**
	 * Object Class Type Button for "Modify" Object Class Type Button with locator of "name=Modify"
	 * @return web UI Object Class Type Button for the "Btnconfirm" Object Class Type Button locator of "name=Modify"
	 */

	public static Button Modify() {
		return new Button("name=Modify");
	}
	/**
	 *waits for the button to appear on the screen
	 * author:Enturu ARCHANA
	 * @throws InterruptedException 
	 */	


	public static void wait_ConfirmButton() throws InterruptedException{
		Btnconfirm().waitForVisibility(5);
	}
	public static Button nacha_yes_btn(){
		return new Button("//*[contains(text(),'Yes')]");}

	public static boolean isyesbuttonpresent() {
		return nacha_yes_btn().isVisible();
	}

	public static void btnYes(){

		nacha_yes_btn().click();}

	public static Button nacha_NO_btn(){
		return new Button("//*[contains(text(),'No')]");}
	public static void btnNO(){

		nacha_NO_btn().click();}

	public static boolean isTermsConditionspresent() {
		return CBtermsAndConditions().isVisible();
	}

	public static void TermsConditions() {
		CBtermsAndConditions().check();
	}
	public static boolean isButtonConfirm() {
		return Btnconfirm().isVisible();

	}

	public static void ButtonConfirm() {
		Btnconfirm().click();
	}

	public static void continueverifyinfopage() throws InterruptedException{
		Verify_payment_info_page.wait_ConfirmButton();

		if(Verify_payment_info_page.isTermsConditionspresent()) 
		{

			Verify_payment_info_page.TermsConditions();

			Verify_payment_info_page.ButtonConfirm();
		}
		else if (Verify_payment_info_page.isButtonConfirm()){

			Verify_payment_info_page.ButtonConfirm();
		}

		if(Verify_payment_info_page.isyesbuttonpresent()) 
		{
			Verify_payment_info_page.btnYes();
		}
	}



}
