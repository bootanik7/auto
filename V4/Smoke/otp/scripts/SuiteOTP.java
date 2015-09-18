package V4.Smoke.otp.scripts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;




/**
 * This Suite executes all of the scripts in the OTP application project
 * <p>
 * 
 * @author Parvat Patil
 */
public class SuiteOTP {
	
	
	
	/**
	 * The SUITE setUp() function initializes the automation for the execution of a SUITE of scripts
	 * <p>
	 * @throws throws an Exception if a failure occurs during setup process 
	 */
	@BeforeClass
	public static void setUp() throws Exception {
	
		Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();	//script name is auto-generated via this code so DO NOT modify this item
		Log.gsScriptDescription = "OTP Smoke Test Suite";
		Log.gsScriptAuthor = "Parvat Patil";
		Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	
		
		//initialize for Suite run
		Log.initializeSuiteStats();
		
		
		
	}
		
	
	/**
	 * This SUITE script executes all of the OTP Smoke test scripts in the lcScripts list
	 */
	@Test
	public void testGoogleRegressionSuite(){
		
	
		
		//script lists
		Class<?>[] lcScripts = {
				
				Login_OTP_script.class,
				ACH_Payment.class,
				Otp_CreditCardPayement.class,
				otp_DebitCardPayment.class
			
		};
		
		
		
		//execute scripts in list above
		for(Class<?> cScript : lcScripts)
			{
 			try{
 			org.junit.runner.JUnitCore.runClasses(cScript);
 			}
 			catch(Exception e){
 				Log.errorHandler("Error occurred during execution of script: " + cScript.toString(),e);
 			}
 		}
			
 		
		
	}
	
	
	
	
	/**
	 * This function terminates the SUITE, calculates the SUITE metrics and reports SUITE results
	 * <P>
	 * @throws an Exception if an error occurs during the termination portion of the script
	 */
	@AfterClass
	public static void tearDown() throws Exception {
				
			//Gather SUITE metrics and terminate automation 
			Log.logSuiteStats();
			
	}

}







