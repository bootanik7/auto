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



/**
 * The GoogleSearch script executes several searches and verifies expected search results 
 * <P>
 */
public class GoogleSearch{
	
	
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
		
		Log.logBanner("Setup for GoogleSearch Testcases");
		Browser.start();
		System.out.println("url is===="+GoogleMainPage.gsGoogleURL);
		
		//String path= Platform.getCurrentProjectPath();
		System.out.println("path is ====="+GoogleMainPage.gsGooglePropertiesFile);
		
		GoogleMainPage.loadGoogleProperties();
		//load Google page and wait for search button to appear
		Browser.loadURL(GoogleMainPage.gsGoogleURL,Log.giAutomationShortTO);
	
	}
	
		
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * @param i the row to execute
	 * <p>
	 * 
	 */
	public void testGoogleSearch(int i){
		
		try{
		Browser.loadURL(GoogleMainPage.gsGoogleURL,Log.giAutomationShortTO);
		
		Map<String,String> sd = Excel.getXlsRowDataAsMap("search_data.csv", "searchdata", Integer.toString(i));
		
		//Execute Testcase
		Log.startTestCase("Test Google Search: - " + sd.get("Search") +  " - Result: - " + sd.get("Result"));
		GoogleMainPage.googleSearch(sd.get("Search"));
		
		//verify Search Results
		GoogleMainPage.verifyResultLink(sd.get("Result"));
		
		}
		catch(Exception e){
			Log.errorHandler("Error occurred during Test Google Search Testcase.",e);
		}
		
	}
	
	
	
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * <p>
	 * 
	 */
	@Test
	public void testGoogleSearch1(){
		testGoogleSearch(1);	
		
	}
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * <p>
	 * 
	 */
	@Test
	public void testGoogleSearch2(){
		testGoogleSearch(2);
	}
	
	
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * <p>
	 * 
	 */
	
	
	/*@Test
	public void testGoogleSearch3(){
		testGoogleSearch(3);
	}
	*/
	
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * <p>
	 * 
	 */
	/*@Test
	public void testGoogleSearch4(){
		testGoogleSearch(4);
	}*/
	
	/**
	 * These testcases execute a series of Google searches and verify expected results
	 * <p>
	 * 
	 */
	/*@Test
	public void testGoogleSearch5(){
		testGoogleSearch(5);
	}
	*/
	
	
	
	
	
	
	
	
	@AfterClass
	/**
	 * This function ends the test, calculates and logs the test results and terminates the automation
	 * <p>
	 * 
	 * @author Tony venditti  
	 */
	public static void tearDown() throws Exception {
		//Log.report.finishScript();
		
		//Automation a1 = new AutomationReport(reportFileName)
		//Baseclass.terminate();
		//Log.autoCleanup(true);
  	   // Log.copyResultsToSilkCentral( );
  	    
		//Gather metrics, report results and terminate automation 
		Log.terminate();
		
	}

}







