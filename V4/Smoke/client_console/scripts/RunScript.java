package V4.Smoke.client_console.scripts;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import core.libs.Log;

public class RunScript {
	
	@BeforeClass
	public static void setUp() throws Exception {
	
		Log.initializeSuiteStats();
	
		
		
	}
	
	

	
	

	
	/**
	 * This SUITE script executes all of the Google test scripts in the lcScripts list
	 */
	@Test
	public void testClientconsoleSuite(){
		
		
		
Class<?>[] lcScripts = {
				
				
				ClientConsole_ACH_Payment.class,
				CilentConsole_CreditCard_payment.class,
			    ClientConsole_Add_Role.class,
				ClientConsole_Add_Team_Admin.class,
				CilentConsole_Add_User_Admin.class,
				ClientConsole_Verify_SearchUser_helpdesk.class,
				ClientConsole_Logout.class
				
				
				
				//ExampleScript.class
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




