package V4.Smoke.otp.applibs;


import core.webwidgets.Button;
import core.webwidgets.ListBox;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

/**
 * ACH Payment Info UI library
 * <p>
 * This class contains definitions for all Google Main page UI objects like Search button
 * and search text field, etc. as well as methods to drive Google UI i.e. googleSearch() method
 * 
 * @author Parvat Patil
 */
public class OTP_Login_Page {





	/**
	 * Declaration for the Google main page Search button
	 * @return Returns web UI object of specified type and definition 
	 */
	public static Button btnGoogleSearch() { 
		return new  Button("name=btnG");

	}

	/**
	 * Google main page Search text field 
	 * @return Returns web UI object of specified type and definition
	 */
	public static TextField Accountnumbertext() { 
		return new TextField("name=billingAccount");

	}

	public static TextField Accountinfo1text() { 
		return new TextField("name=loginFields[0]");

	}

	public static TextField Accountinfo2text() { 
		return new TextField("name=loginFields[1]");

	}


	public static ListBox Divisionname(){

		return new ListBox("name=divisionBusinessId");
	}



	public static Button submit(){

		return new Button("name=Submitbtn");
	}


	public static RadioButton Bank(){


		return new RadioButton("//*[@value='BANK,' and @name='fundingInfo']");


	}

	public static void clickRadio(){
		Bank().click();

	}
	
	
	public static void EnterAccountText(String sSearchText){
		Accountnumbertext().setText(sSearchText);

	}

	public static void EnterAccountinfoText(String sSearchText){
		Accountinfo1text().setText(sSearchText);

	}

	public static boolean isAccountonf2present() {
		return Accountinfo2text().isVisible();
	}


	public static void EnterAccountinfo2Text(String sSearchText) {
		Accountinfo2text().setText(sSearchText);
	}


	public static void selectdivision(String sItem){
		Divisionname().selectItem(sItem);
	}

	public static boolean isdivisionpresent() {
		return Divisionname().isVisible();
	}

	public static void clickbutton() {
		submit().click();
	}

}
