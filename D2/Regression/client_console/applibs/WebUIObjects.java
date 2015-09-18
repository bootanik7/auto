package D2.Regression.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.Link;
import core.webwidgets.ListBox;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

/**
 * Example UI WebWidget Library used for Unit Testing WebWidget methods and Selenium Core framework.
 * <P>
 * To Be used with WebUIObjects.htm file stored in the testdata folder
 */
public class WebUIObjects {

	
	/**
	 * Returns FirstName TextField object
	 * @return FirstName TextField object
	 */
	public static TextField tfFirstName() {
		return new TextField("//input[@name='firstname']");
	}

	/**
	 * Returns LastName TextField object
	 * @return LasttName TextField object
	 */
	public static TextField tfLastName() {
		return new TextField("//input[contains(@name,'lastname')]");
	}
	
	/**
	 * Returns UserName TextField object
	 * @return UserName TextField object
	 */
	public static TextField tfUserName() {
		return new TextField("//input[@name='username']");
	}
	
	/**
	 * Returns Password TextField object
	 * @return Password TextField object
	 */
	public static TextField tfPassword() {
		return new TextField("//input[@type='password']");
	}
	
	
	/**
	 * Returns FirstName TextField object
	 * @return FirstName TextField object
	 */
	public static TextField tfFirstName2() {
		return new TextField("xpath=(//input[@name='firstname'])[2]");
	}
	
	/**
	 * Returns LastName TextField object
	 * @return LasttName TextField object
	 */
	public static TextField tfLastName2() {
		return new TextField("xpath=(//input[@name='lastname'])[2]");
	}
	
	/**
	 * Object that does not have a valid locator to conduct negative locator tests
	 * @return null
	 */
	public static TextField tfNegativeObject() {
		return new TextField("xpath=(//input[@name='notlikely'])");
	}
	
	
	/**
	 * Browser type TextField object declaration
	 * @return  Browser type Textfield object
	 */
	public static TextField tfBrowsers() {
		return new TextField("//input[@list='browsers']");
	}
	
	
	/**
	 * Quantity TextField object declaration
	 * @return  Quantity TextField object
	 */
	public static TextField tfQuantity() {
		return new TextField("//input[@name='quantity']");
	}
	
	
		
	
	
	
	
	
	/**
	 * Returns TextArea object
	 * @return 
	 */
	public static TextField tfTextArea() {
		return new TextField("//textarea[@name='message']");
	}
	
	
	//Radio buttons
	
	/**
	 * Returns Male Radio object
	 * @return radiobutton object for Male radio button 
	 */
	public static RadioButton rbMale() {
		return new RadioButton("//input[@value='male']");
	}
	
	
	/**
	 * Returns Female Radio object
	 * @return radiobutton object for Male radio button 
	 */
	public static RadioButton rbFemale() {
		return new RadioButton("//input[@value='female']");
	}
	
	//CheckBox
	
	/**
	 * Returns Bike CheckBox object
	 * @return CheckBox object for Bike checkbox 
	 */
	public static CheckBox chkBike() {
		return new CheckBox("//input[@value='Bike']");
	}
	
	/**
	 * Returns Bike CheckBox object
	 * @return CheckBox object for Bike checkbox 
	 */
	public static CheckBox chkCar() {
		return new CheckBox("//input[@value='Car']");
	}
	
	//Buttons
	
	
	/**
	 * Help Button object declaration
	 * @return Help Button object
	 */
	public static Button btnHelp() {
		return new Button("//input[@value='Help']");
	}
	
	/**
	 * ClickMe Button object declaration
	 * @return ClickMe Button object
	 */
	public static Button btnClickMe() {
		return new Button("//button[contains(.,'Click Me!')]");
	}
	
	
	
	
	//Auto-generated objects
	



	/**
	 * Link object for "VisitourHTMLtutorial" Link with locator of "link=Visit our HTML tutorial"
	 * @return Returns web UI Link object for the "VisitourHTMLtutorial" Link with locator of "link=Visit our HTML tutorial"
	 */
	public static Link lnkVisitourHTMLtutorial() {
	// Actual Page Source code:   <a href="http://www.w3schools.com/html/">Visit our HTML tutorial</a>
	// Property used for naming the object:   Caption or text at end of line item: "Visit our HTML tutorial"
	return new Link("link=Visit our HTML tutorial");
	}


	/**
	 * Link object for "GoogleSearch" Link with locator of "link=Google Search"
	 * @return Returns web UI Link object for the "GoogleSearch" Link with locator of "link=Google Search"
	 */
	public static Link lnkGoogleSearch() {
	// Actual Page Source code:   <a href="http://www.google.com">Google Search</a>
	// Property used for naming the object:   Caption or text at end of line item: "Google Search"
	return new Link("link=Google Search");
	}


	/**
	 * Link object for "HTMLImages" Link with locator of "link=HTML Images"
	 * @return Returns web UI Link object for the "HTMLImages" Link with locator of "link=HTML Images"
	 */
	public static Link lnkHTMLImages() {
		// Actual Page Source code:   <a href="c:\\B24_updated files.jpg">HTML Images</a>
		// Property used for naming the object:   Caption or text at end of line item: "HTML Images"
		return new Link("link=HTML Images");
	}


	/**
	 * Link object for "VisitW3Schools" Link with locator of "link=Visit W3Schools!"
	 * @return Returns web UI Link object for the "VisitW3Schools" Link with locator of "link=Visit W3Schools!"
	 */
	public static Link lnkVisitW3Schools() {
		// Actual Page Source code:   <a href="http://www.w3schools.com/" target="_blank">Visit W3Schools!</a>
		// Property used for naming the object:   Caption or text at end of line item: "Visit W3Schools!"
		return new Link("link=Visit W3Schools!");
	}



	/**
	 * Link object for "VisittheUsefulTipsSection" Link with locator of "link=Visit the Useful Tips Section"
	 * @return Returns web UI Link object for the "VisittheUsefulTipsSection" Link with locator of "link=Visit the Useful Tips Section"
	 */
	public static Link lnkVisittheUsefulTipsSection() {
		// Actual Page Source code:   <a href="#tips">Visit the Useful Tips Section</a>
		// Property used for naming the object:   Caption or text at end of line item: "Visit the Useful Tips Section"
		return new Link("link=Visit the Useful Tips Section");
		
		
	}

	//ListBox objects
	
	/**
	 * Cars ListBox object declaration
	 * @return  Cars ListBox object
	 */
	public static ListBox lstCars() {
		return new ListBox("//select[@name='cars']");
	}
	
	
	
	
	
	
	
	
	
	/**
	 * // TODO: place application specific method description here
	 * This is an example application specific method that enters a search string in ACI search text field
	 * and clicks Search button
	 * <P>
	 * 
	 * @param sSearchText search text to enter into ACI search text field
	 */
//	public static void searchACI(String sSearchText) {
//		txtSearchACI().setText(sSearchText); //enter search text into google search textfield
//		Platform.sleep(Log.giAutomationShortTO); //wait 5 seconds for search to display results
//		btnSearchACI().click(); //click search button
//
//	}

}
