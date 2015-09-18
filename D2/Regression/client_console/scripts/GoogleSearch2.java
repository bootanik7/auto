package D2.Regression.client_console.scripts;



import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import D2.Regression.client_console.applibs.GoogleMainPage;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.report.AutomationReport;



/**
 * The GoogleSearch script executes several searches and verifies expected search results 
 * <P>
 */
public class GoogleSearch2{
	
	public static AutomationReport report2=null;
	@BeforeClass
	/**
	 * Initializes the automation for testing.
	 * <P>
	 * @throws throws an Exception if an error occurs during the setup portion of the script
	 */
	public static void setUp() throws Exception {
	
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();  //this.getClass().getName().toString();
		Log.gsScriptDescription = "Test and verify Google Searches";
		Log.gsScriptAuthor = "Tony Venditti";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
		
		Log.initialize();
		
		//GoogleMainPage.loadGoogleProperties(); //loads google global properties from google.properties file
		
		Log.logBanner("Setup for GoogleSearch2 Testcases");
		//Browser.start();
		
	}
		
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * @param i the row to execute
	 * <p>
	 * 
	 */
	@Test
	public void testGoogleSearch(){
		
		
		Browser.loadURL(GoogleMainPage.gsGoogleURL,Log.giAutomationShortTO);
		
		for (int i = 1; i < Excel.getXlsRowCount("search_data.csv", "searchdata");i++){
		
		//read row data from spreadsheet
		Map<String,String> sd = Excel.getXlsRowDataAsMap("search_data.csv", "searchdata", Integer.toString(i));
		
		//Execute Testcase
		Log.startTestCase("Test Google Search: - " + sd.get("Search") +  " - Result: - " + sd.get("Result"));
		GoogleMainPage.googleSearch(sd.get("Search"));
		
		//verify Search Results
		GoogleMainPage.verifyResultLink(sd.get("Result"));
		
		}
		
		
	}
	
	
	
	
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Tony venditti  
	 */
	public static void tearDown() throws Exception {
		
		//report2.finishScript(); 
		//Gather metrics, report results and terminate automation 
		Log.terminate();
		
	}

}







