package D2.Regression.client_console.applibs;


import core.libs.Browser;
import core.libs.Log;
import core.libs.Platform;
import core.webwidgets.Button;
import core.webwidgets.CheckBox;
import core.webwidgets.ListBox;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;


/**
 * Object and Method library for the Google Preferences page UI 
 * @author Tony Venditti
 */
public class GooglePreferencesPage {
	
	/**
	 * Returns UI object for Google Preferences page Interface Language popup listbox 
	 */
	public static ListBox popInterfaceLanguage(){
		return new ListBox("hl");
	}
	
	/**
	 * Returns UI object for Google Preferences page No Filtering radio option button 
	 */
	public static RadioButton rbNoFiltering(){
		return new RadioButton("nof");
	}
	
	/**
	 * Returns UI object for Google Preferences page Moderate Filtering radio option button 
	 */
	public static RadioButton rbModerateFiltering(){
		return new RadioButton("modf");
	}
	
	
	/**
	 * Returns UI object for Returns UI object for Google Preferences page "Strict Filtering" radio option button 
	 */
	public static RadioButton rbStrictFiltering(){
		return new RadioButton("stf");
	}
	
	
	/**
	 * Returns UI object for Google Preferences page Location textfield 
	 */
	public static TextField txtLocation(){
		return new TextField("luul");
	}
	
	
	
	/**
	 * Returns UI object for Google Preferences page Use Google Instant radio option button 
	 */
	public static RadioButton rbUseGoogleInstant(){
		return new RadioButton("suggon");
	}
	
	
	/**
	 * Returns UI object for Google Preferences page Do Not Use Google Instant radio option button 
	 */
	public static RadioButton rbDoNotUseGoogleInstant() { 
		return  new RadioButton ("css=#suggmid");		//("suggmid","GooglePreferencesPage.rdlDoNotUseGoogleInstant", "RadioButton");
	}
	
	
	/**
	 * Returns UI object for Google Preferences page Results Window Checkbox 
	 */
	public static CheckBox chkResultsWindow() { 
		return new CheckBox("nwc"); 
	}
	
	
	
	
	/**
	 * Returns UI object for Google Preferences page Save Preferences PushButton 
	 */
	public static Button btnSavePreferences() { 
		//return new Button("//input[@name='submit2' and @value='Save Preferences ']");
		return new Button("submit2");
	}
	
	
	/**
	 * Sets specified Google Preferences
	 * @param GooglePrefDataType() - custom data type (class) which is made up of the following parameters:  
	 * @param String sInterfaceLanguage - Interface Lanaguage to select
	 * @param String[] sSearchLanguage - List of Search Languages 
	 * @param String sLocation - Address of current location
	 * @param String sFiltering - Filtering option to select
	 * @param String sGoogleInstant - GoogleInstant option to select
	 * @param boolean bResultWindow - Result Window checkbox
	 */
	public static void googleSetPreferences(GooglePrefDataType gpdt){
		
		
		//go to Google Preferences page
		GoogleMainPage.loadPreferencesPage();
		btnSavePreferences().waitForExistence(Log.giAutomationMedTO);
		
		
		//Interface Langauage
		if (!gpdt.sInterfaceLanguage.equals("") || !gpdt.sInterfaceLanguage.equals(null))
			popInterfaceLanguage().select(gpdt.sInterfaceLanguage);
		
		//Search Languages
		if (gpdt.lsSearchLanguages.length >= 1) {
			for (int x = 0; x < gpdt.lsSearchLanguages.length; x++)
			{
				//temp
			}
		}
		
		//Location
		if (!gpdt.sLocation.equals("") || !gpdt.sLocation.equals(null))
				txtLocation().setText(gpdt.sLocation);	
			
		//Filtering	
		if (!gpdt.sFiltering.equals("") || !gpdt.sFiltering.equals(null)){
			
			if (gpdt.sFiltering.equalsIgnoreCase("Do not filter"))
				rbNoFiltering().click();
			else if (gpdt.sFiltering.equalsIgnoreCase("Use moderate filtering"))
				rbModerateFiltering().click();
			else if (gpdt.sFiltering.equalsIgnoreCase("Use strict filtering"))
				rbStrictFiltering().click();
			else
				Log.errorHandler("Error occurred selecting: " + gpdt.sFiltering + " Google Preferences Filtering option");
		}
		
		//Google Instant is on Firefox Browser (its called AutoComplete in Internet Explorer)
		if (Platform.isFirefox())
		{	
			if (!gpdt.sGoogleInstant.equals("") || !gpdt.sGoogleInstant.equals(null)){
			
			if (gpdt.sGoogleInstant.equalsIgnoreCase("Use Google Instant"))
				rbUseGoogleInstant().click();
			else if (gpdt.sGoogleInstant.equalsIgnoreCase("Do not use Google Instant"))
				rbDoNotUseGoogleInstant().click();
			else
				Log.errorHandler("Error occurred selecting: " + gpdt.sGoogleInstant + " Google Preferences Google Instant Search option");
			}
		}
		
		//Results Window
		if (gpdt.bResultsWindow == true)
			chkResultsWindow().check();
		else
			chkResultsWindow().uncheck();
	
		
		//Save Preferences
		btnSavePreferences().click();
		
		
		//handle message box
		Platform.sleep(Log.giAutomationShortTO);
		Browser.handleMessageBox("Your preferences have been saved","OK");
		
		
		
	}
	
	
	
	
	
}
