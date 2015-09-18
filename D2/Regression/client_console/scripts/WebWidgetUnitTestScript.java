package D2.Regression.client_console.scripts;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import D2.Regression.client_console.applibs.WebUIObjects;
import core.libs.Browser;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.Strings;

/**
 * Standard ACI Selenium Test Script Template file.
 * <p>
 * Place your description of what the test script tests here.
 *
 */
public class WebWidgetUnitTestScript {

	/**
	 * Initializes the automation for testing.
	 *
	 * @throws Exception if an error occurs during the setup portion of the script
	 *
	 */
	@BeforeClass
	public static void setUp() throws Exception {

		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName(); //script name is auto-generated via this code so DO NOT modify this item
		Log.gsScriptDescription = "Add test description here"; //update test description
		Log.gsScriptAuthor = "Tony Venditti"; //update script author
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".", Platform.getFileSeparator())); //script test area uses the project path info and is auto-generated via this code so DO NOT modify this item

		Log.initialize(); //Reads in Automation.properties values, Logs script header information, initializes script metrics and starts Selenium server
		
		Log.logBanner("Load Web Object Test Page");
		Browser.start(); // start browser
		Browser.loadURL("file:///" + Log.gsAutomationAutoSupportDocs + "WebUIObjects.htm",Log.giAutomationPause2TO);
		
		
	}

	/**
	 * Verify TextField Objects
	 * <p>
	 */
	@Test
	public void testTextFieldObjects() {

		try { //good practice to wrap your test case in a try/catch block

			
			Log.startTestCase("Verify TextField Objects");
			
			WebUIObjects.tfFirstName().setText("Tony");
			WebUIObjects.tfLastName().setText("Venditti");
			
			WebUIObjects.tfUserName().setText("Fred");
			WebUIObjects.tfPassword().setText("password1");
			
			Log.altVerify("Mickey",WebUIObjects.tfFirstName2().getText(),true);
			Log.altVerify("Mouse",WebUIObjects.tfLastName2().getText(), true);
			
			Log.altVerify("username", WebUIObjects.tfUserName().getAttribute("name").toString(),true);
			Log.logScriptInfo("Test getTextIgnoreError of TextField that doesn't have a valid locator: " + WebUIObjects.tfNegativeObject().getTextIgnoreError());
			Log.altVerify(true, WebUIObjects.tfFirstName().isEditable(),"Is Editable");
			Log.altVerify("Fred", WebUIObjects.tfUserName().getValue(),true);
			
			D2.Regression.client_console.applibs.WebUIObjects.tfUserName().typeKeys("Hank");
			Log.altVerify("username", WebUIObjects.tfUserName().getHiddenFieldAttribute("name"),true);
			Log.altVerify("Hank",WebUIObjects.tfUserName().getText(), true);
			
			
			
			WebUIObjects.tfBrowsers().hover();
			WebUIObjects.tfBrowsers().doubleClick();
			WebUIObjects.tfBrowsers().setText("Chrome");
			Log.altVerify("Chrome", WebUIObjects.tfBrowsers().getText(), true);
			
			WebUIObjects.tfBrowsers().hover();
			WebUIObjects.tfBrowsers().doubleClick();
			WebUIObjects.tfBrowsers().setText("Firefox");
			Log.altVerify("Firefox", WebUIObjects.tfBrowsers().getText(), true);
			
			
			WebUIObjects.tfQuantity().hover();
			WebUIObjects.tfQuantity().doubleClick();
			WebUIObjects.tfQuantity().setText("5");
			Log.altVerify("5", WebUIObjects.tfQuantity().getText(), true);
			
			
			WebUIObjects.tfTextArea().clearText();
			String sText = "Selenium automates browsers. That's it! What you do with that power is entirely up to you. Primarily, it is for automating web applications for testing purposes, but is certainly not limited to just that. Boring web-based administration tasks can (and should!) also be automated as well."
					+ "Selenium has the support of some of the largest browser vendors who have taken (or are taking) steps to make Selenium a native part of their browser. It is also the core technology in countless other browser automation tools, APIs and frameworks."; 
			WebUIObjects.tfTextArea().setText(sText);
			Log.altVerify(sText,WebUIObjects.tfTextArea().getText(), true);
			
			
			
			
			

			}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in TextField Widget Unit Test.", e);
		}
	}
	
	
	
	
	/**
	 * Verify Radio button objects
	 * <p>
	 */
	@Test
	public void testRadioButtonObjects() {

		try { //good practice to wrap your test case in a try/catch block

			
			Log.startTestCase("Verify Radio button Objects");
			
			WebUIObjects.rbMale().click();
			Log.altVerify(true,WebUIObjects.rbMale().isSelected(),"Male radio option is selected");
			Log.altVerify(true,WebUIObjects.rbMale().ischecked(),"Male radio option is checked");
			
			WebUIObjects.rbFemale().select();
			Log.altVerify(false,WebUIObjects.rbMale().ischecked(),"Male radio option is NOT checked");
			Log.altVerify(false,WebUIObjects.rbMale().isSelected(),"Male radio option is NOT selected");
			
			
			Log.altVerify("male",WebUIObjects.rbMale().getValue(), true);
			Log.altVerify("female",WebUIObjects.rbFemale().getValue(),true);
			
			
			

			}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in Radio Button Widget Unit Test.", e);
		}
	}

	
	/**
	 * Verify CheckBox objects
	 * <p>
	 */
	@Test
	public void testCheckBoxObjects() {

		try { //good practice to wrap your test case in a try/catch block

			
			Log.startTestCase("Verify CheckBox Objects");
			
			WebUIObjects.chkCar().check();
			Log.altVerify(true,WebUIObjects.chkCar().ischecked(),"Car Check Box is checked");
			
			WebUIObjects.chkBike().click();
			Log.altVerify(true,WebUIObjects.chkBike().ischecked(),"Bike checkbox is checked");
			
			WebUIObjects.chkCar().uncheck();
			Log.altVerify(false,WebUIObjects.chkCar().ischecked(),"Car Checkbox is NOT checked");
			
			Log.altVerify("Car",WebUIObjects.chkCar().getValue(),true);
			Log.altVerify("Bike",WebUIObjects.chkBike().getValue(),true);
			
			}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in CheckBox Widget Unit Test.", e);
		}
	}
	
	
	/**
	 * Verify Button objects
	 * <p>
	 */
	@Test
	public void testButtonObjects() {

		try { //good practice to wrap your test case in a try/catch block

			
			Log.startTestCase("Verify Button Objects");
			
			WebUIObjects.btnHelp().click();
			if (Browser.getAlert().contains("Try some TicTacs!")){
				Log.logScriptInfo(Strings.sDQ + Browser.getAlert() + Strings.sDQ + " Message Box was displayed. Clicked OK to clear the message box.");
				Browser.handleMessageBox("You need a TicTac","OK");
				
			}
			
			WebUIObjects.btnClickMe().click();
			if (Browser.getAlert().contains("Hello World!"))
				Log.logScriptInfo(Strings.sDQ + Browser.getAlert() + Strings.sDQ + " Message Box was displayed. Clicked OK to clear the message box.");
				Browser.handleMessageBox("Hello World!","OK");
			}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in CheckBox Widget Unit Test.", e);
		}
	}
	
	
	
	/**
	 * Verify Link objects
	 * <p>
	 */
	@Test
	public void testLinkObjects() {

		try { //good practice to wrap your test case in a try/catch block

			
			Log.startTestCase("Verify Link Objects");
			
			if (WebUIObjects.lnkVisitourHTMLtutorial().exists(Log.giAutomationShortTO)){
				WebUIObjects.lnkVisitourHTMLtutorial().click();
				Browser.validateTextExists("HTML Tutorial",5);
				Browser.goBack();
			}
			
			if (WebUIObjects.lnkGoogleSearch().isVisible()){
				WebUIObjects.lnkGoogleSearch().focus();
				WebUIObjects.lnkGoogleSearch().click();
				Browser.validateLinkExists("About",5);
				Browser.goBack();
			}
			
			if (WebUIObjects.lnkHTMLImages().isEnabled()){
				WebUIObjects.lnkHTMLImages().hover();
				Log.altVerify("HTML Images", WebUIObjects.lnkHTMLImages().getTextIgnoreError(), false);
				WebUIObjects.lnkHTMLImages().click();
				Browser.goBack();
			}
			
			if (!WebUIObjects.lnkHTMLImages().isDisabled()){
				WebUIObjects.lnkVisitW3Schools().doubleClick();
				Browser.goBack();
			}
			
		}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in CheckBox Widget Unit Test.", e);
		}
	}
	
	
	/**
	 * Verify Link objects
	 * <p>
	 */
	@Test
	public void testListBoxObjects() {

		try { //good practice to wrap your test case in a try/catch block
			List<String> lsVerifyCars = new ArrayList<String>();
			
			Log.startTestCase("Verify ListBox Objects");
			
			WebUIObjects.lstCars().selectByLabel("Saab");
			Log.altVerify("Saab",WebUIObjects.lstCars().getSelectedItemText(),true);
			Log.altVerify("saab",WebUIObjects.lstCars().getSelectedValue(),true);
			Log.altVerify(4,WebUIObjects.lstCars().getListItemCount(),WebUIObjects.lstCars().sIdentifier + " " + WebUIObjects.lstCars().sClassName + " contains 4 items");
			lsVerifyCars.add("Volvo");
			lsVerifyCars.add("Saab");
			//lsVerifyCars.add("Ford");
			lsVerifyCars.add("Fiat");
			lsVerifyCars.add("Audi");
			
			
			if (lsVerifyCars.equals(WebUIObjects.lstCars().getListValues())){
				Log.logScriptInfo("Verified list items: " + WebUIObjects.lstCars().getListValues());
			}
			else{
				Log.errorHandler("List content failed comparison");
			}
			
			
			for (int x = 0; x < lsVerifyCars.size(); x++){
				boolean bFound = false;
				//Log.logScriptInfo(lsVerifyCars.get(x));
			
				for (int z = 1; z <= WebUIObjects.lstCars().getListItemCount(); z++){
					if (lsVerifyCars.get(x).equalsIgnoreCase(WebUIObjects.lstCars().get(z))){
						Log.logScriptInfo("Verified list item: " + WebUIObjects.lstCars().get(z));
						bFound = true;
						break;
					}
				}
			
				if (!bFound)
					Log.errorHandler("Could not find: " + Strings.sDQ + lsVerifyCars.get(x) + Strings.sDQ + " in " + WebUIObjects.lstCars().sIdentifier + " " + WebUIObjects.lstCars().sClassName);
			}
			
			WebUIObjects.lstCars().selectByPartialLabel("Vol");
			Log.altVerify("Volvo", WebUIObjects.lstCars().getSelectedItemText(), false);
			Log.altVerify("volvo", WebUIObjects.lstCars().getSelectedValue(),true);
			
			WebUIObjects.lstCars().select("saab");
			Log.altVerify("Saab",WebUIObjects.lstCars().getSelectedItemText(),true);
			Log.altVerify("saab",WebUIObjects.lstCars().getSelectedValue(),true);
			
			
					
		}
		catch (Exception e) { //catch all error handler
			Log.errorHandler("Error occurred in ListBox Widget Unit Test.", e);
		}
	}
	
	
	
	
	

	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 *
	 */
	@AfterClass
	public static void tearDown() throws Exception  {

		//Gather metrics, report results and terminate automation 
		Log.terminate();
	}

}
