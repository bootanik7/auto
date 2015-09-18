package D2.Regression.client_console.scripts;

import core.libs.Log;
import core.libs.report.AutomationReport;

public class Baseclass  {
	public static  AutomationReport report2=null;
	
	public static  void terminate() {
		report2 = new AutomationReport(Log.gsAutomationAutoResultPath + Log.gsScriptName + "_" + Log.gsScriptUID);
		report2.finishScript();
	}

}
