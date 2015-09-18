package D2.Regression.client_console.scripts;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import core.libs.Excel;
import core.libs.Log;
import core.libs.Platform;


/**
 * @TestSuite: TemplateSuite - Standard ACI Selenium SUITE script Template file
 * @Description: A SUITE script executes all of the test scripts in the lcScripts list below
 * @Author: Tony Venditti
 */
public class GoogleSuiteCounter  {
	
	
	@BeforeClass
	/**
	 * @Function: setUp() 
	 * @Description: SUITE - This function initializes the automation for testing of a SUITE of scripts 
	 */
	public void setUp() throws Exception {
	
		Log.gsScriptName = this.getClass().getName().toString();
		Log.gsScriptDescription = "Description for your Test Suite goes here";
		Log.gsScriptAuthor = "Tony Venditti";
		Log.gsScriptTestArea = Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".","\\"); 	
		
		//initialize for Suite run
		Log.initializeSuiteStats();
		
		
		
	}
	
	

	
	

	@Test
	/**
	 * @Suite: testMyRegressionSuite() 
	 * @Description: This SUITE script executes all of the test scripts in the lcScripts list defined below
	 * A SUITE script is a special script that contains a collection of other, usually related, scripts to execute.
	 */
	public void testMyRegressionSuite(){
		
		int NoOfScriptsExecuted=0;
		
		//script list - lsScripts contains a list of other scripts to execute within this SUITE file 
		Class<?>[]  lcScripts = {
				
				//List all script class names that you want to include in this SUITE in the list below 
				D2.Regression.client_console.scripts.GoogleAbout.class,	//Example 1st script name with ".class" extension to run in suite
				//google.scripts.GoogleSearch.class		//Example 2nd script name with ".class" extension to run in suite
		};
		
		
		
		//SUITE execution code - runs scripts in list above
		for (int x =0;x< lcScripts.length;x++){
 			try{
 			org.junit.runner.JUnitCore.runClasses(lcScripts[x]);
 			NoOfScriptsExecuted = x;
 			}
 			catch(Exception e){
 				Log.errorHandler("Error occurred during execution of script: " + lcScripts[x].toString(),e);
 			}
 		}
		
		
		
		//Track automation ROI 
		String sTESTDATA_FILENAME = "AUTOMATION_COUNTER";
		String sTESTDATA_COUNTER_SHEETNAME = "counter";
		String sSUITENAME = "GoogleSuiteCounter";
		List<String> hmCounter;
		hmCounter = Excel.getXlsRowDataAsList(sTESTDATA_FILENAME, sTESTDATA_COUNTER_SHEETNAME, sSUITENAME);
		Log.autoROICounter(sTESTDATA_FILENAME , sTESTDATA_COUNTER_SHEETNAME, NoOfScriptsExecuted, hmCounter, sSUITENAME);  //call the counter program

					
	}
	
	
	
	@AfterClass
	/**
	 * @Function: tearDown() 
	 * @Description: SUITE - This function terminates the SUITE, claculates the SUITE metrics and reports SUITE results
	 */
	public void tearDown() throws Exception {
		
		
			//Gather SUITE metrics and terminate automation 
			Log.logSuiteStats();
			
	}

}







