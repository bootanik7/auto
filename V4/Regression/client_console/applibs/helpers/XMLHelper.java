
package V4.Regression.client_console.applibs.helpers;

import V4.Smoke.client_console.scripts.ClientConsole_ACH_Payment;
import V4.Smoke.client_console.scripts.CommonPayment_clientconsole;
import V4.Smoke.client_console.scripts.Common_Class_clientConsole;
import V4.Smoke.client_console.scripts.Test_login;

import java.io.File;
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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import core.libs.Database;
import core.libs.Log;
import org.testng.SkipException;
import org.w3c.dom.Document;

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
import core.libs.XML;
import core.webwidgets.Link;
import core.webwidgets.StaticText;
import org.w3c.dom.NodeList;



import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 * @author tatyana
 *
 */
public class XMLHelper {

	public static Element getElementByAttributeName(String xmlPath, String expression) {

		File fXmlFile = new File(xmlPath);

		Element element = null;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Log.logScriptInfo("Read XML file");
			Document doc = dBuilder.parse(fXmlFile);
			XPath xPath = XPathFactory.newInstance().newXPath();

			NodeList elementList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			switch (elementList.getLength()) {
			case 0:
				Log.errorHandler("No element with xPath =" + expression + " was found in XML:" + xmlPath);
				break;
			case 1:
				element = (Element) elementList.item(0);
				break; 
			default:
				Log.errorHandler(
						"There is duplicated elements with  xPath =" + expression + " was found in XML:" + xmlPath);
				break;

			}

		} catch (Exception e) {
			Log.errorHandler("Error occurred during parsing XML file ", e);
		}

		return element;
	}

	public static String  getPaymentEntryRuleNameFromXML(String xmlPath, String fieldName,  String checkType ){
		String expression = "//field[@property='" + fieldName + "']/msg[@name='" + checkType + "']";
		String ruleName = null;
		NamedNodeMap attrs;
		Node note = null;
		Element element = null;
		try {
			element = XMLHelper.getElementByAttributeName(xmlPath, expression);
			if (element != null) {
		
				ruleName = element.getAttributes().getNamedItem("key").getNodeValue();
				
			}
		} catch (Exception e) {
			Log.errorHandler("Error occurred during getting ruleName from the XML file ", e);
		}
		return ruleName;
	}
	
}
