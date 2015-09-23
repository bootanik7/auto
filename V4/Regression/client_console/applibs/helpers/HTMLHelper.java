
package V4.Regression.client_console.applibs.helpers;

import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import core.libs.Database;
import core.libs.Log;
import org.testng.SkipException;

import V4.Regression.client_console.applibs.V4_CC_Payment;
import V4.Smoke.client_console.applibs.ClientConsole_ACHPayementEntry_Page;
import V4.Smoke.client_console.applibs.Client_ConsoleLogin_Page;
import V4.Smoke.otp.applibs.Common_Class;
import V4.Smoke.otp.applibs.Database_Connection;
import V4.Smoke.otp.applibs.Database_query_Manager;
import core.libs.Browser;
import core.libs.Excel;
import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.webwidgets.Link;
import core.webwidgets.StaticText;

/**
 * @author tatyana
 *
 */
public class HTMLHelper {

	@SuppressWarnings("unused")
	public static String getPtextByClassName(String className) {
		StaticText pText = new StaticText("//p[@class='" + className + "']");
		if (pText != null) {
			return pText.exists() ? pText.getText() : null;
		} else {
			Log.logScriptInfo("Message error is not presented on the Page ");
			return null;
		}
	}
	

	
}
