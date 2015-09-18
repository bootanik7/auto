package D2.Regression.client_console.scripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import core.libs.FileIO;
import core.libs.Log;
import core.libs.Platform;
import core.libs.Timers;
//import core.libs.Log;



/**
 * @script: TemplateScript - Standard ACI Selenium Test Script Template file
 * @description: Place your description of what the test script tests here.
 * @author: Script Authors name goes here   
 */
public class CoreLibsUnitTest {
	
	
	@BeforeClass
	/**
	 * @function: setUp() 
	 * @description: This function initializes the automation for testing
	 * @author: Script Authors name goes here  
	 */
	public static void setUp() throws Exception {
		//Standard script information section
				Log.gsScriptName = Thread.currentThread().getStackTrace()[1].getClassName();
				Log.gsScriptDescription = "Test and verify Google About page";
				Log.gsScriptAuthor = "Tony Venditti";
				Log.gsScriptTestArea = FileIO.getParentPath(Platform.getCurrentProjectPath() + Log.gsScriptName.replace(".",Platform.getFileSeparator())); 	//script test area uses the project path info and is auto-generated via this code so do not modify this item 	
				
				Log.initialize(); //Standard script initialization routine			
	}
	
	
	@Test
	/**
	* Testcase: My first test script<p>
	* @author Tony Venditti
	*/
	public void test_Google_Script1()
	{

		//System.out.println(Excel.getCSVCellContent("C:\\users\\vendittit\\downloads\\GoogleToCSV - Sheet1.csv", 15,4));
		
//		String[][] ls = Excel.getCSVTableData("C:\\users\\vendittit\\downloads\\GoogleToCSV - Sheet1.csv");
//		
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]+ "," + ls[0][3] + "," + ls[0][4]+ "," + ls[0][5] + "," + ls[0][6]+ "," + ls[0][7]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]+ "," + ls[1][3] + "," + ls[1][4]+ "," + ls[1][5] + "," + ls[1][6]+ "," + ls[1][7]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]+ "," + ls[2][3] + "," + ls[2][4]+ "," + ls[2][5] + "," + ls[2][6]+ "," + ls[2][7]);
//		System.out.println(ls[3][0]+ "," + ls[3][1] + "," + ls[3][2]+ "," + ls[3][3] + "," + ls[3][4]+ "," + ls[3][5] + "," + ls[3][6]+ "," + ls[3][7]);
//		System.out.println(ls[4][0]+ "," + ls[4][1] + "," + ls[4][2]+ "," + ls[4][3] + "," + ls[4][4]+ "," + ls[4][5] + "," + ls[4][6]+ "," + ls[4][7]);
//		System.out.println(ls[5][0]+ "," + ls[5][1] + "," + ls[5][2]+ "," + ls[5][3] + "," + ls[5][4]+ "," + ls[5][5] + "," + ls[5][6]+ "," + ls[5][7]);
//		
//		System.out.println(ls[6][0]+ "," + ls[6][1] + "," + ls[6][2]+ "," + ls[6][3] + "," + ls[6][4]+ "," + ls[6][5] + "," + ls[6][6]+ "," + ls[6][7]);
//		System.out.println(ls[7][0]+ "," + ls[7][1] + "," + ls[7][2]+ "," + ls[7][3] + "," + ls[7][4]+ "," + ls[7][5] + "," + ls[7][6]+ "," + ls[7][7]);
//		System.out.println(ls[8][0]+ "," + ls[8][1] + "," + ls[8][2]+ "," + ls[8][3] + "," + ls[8][4]+ "," + ls[8][5] + "," + ls[8][6]+ "," + ls[8][7]);
//		System.out.println(ls[9][0]+ "," + ls[9][1] + "," + ls[9][2]+ "," + ls[9][3] + "," + ls[9][4]+ "," + ls[9][5] + "," + ls[9][6]+ "," + ls[9][7]);
//		System.out.println(ls[10][0]+ "," + ls[10][1] + "," + ls[10][2]+ "," + ls[10][3] + "," + ls[10][4]+ "," + ls[10][5] + "," + ls[10][6]+ "," + ls[10][7]);
//		System.out.println(ls[11][0]+ "," + ls[11][1] + "," + ls[11][2]+ "," + ls[11][3] + "," + ls[11][4]+ "," + ls[11][5] + "," + ls[11][6]+ "," + ls[11][7]);
		
		
		//Platform.maximizeWin("AutoIt Help");
		
//		String[] ls = Excel.getCSVRowData("C:\\users\\vendittit\\downloads\\GoogleToCSV - Sheet1.csv", 15);
//		
//		for (int x = 0; x< ls.length; x++){
//		System.out.println(ls[x]);
//		}
		
//		String[] ls = Excel.getCSVColumnData("C:\\users\\vendittit\\downloads\\GoogleToCSV - Sheet1.csv", 2);
//		
//		for (int x = 0; x< ls.length; x++){
//		System.out.println(ls[x]);
//		}
		
		
		//System.out.println(Excel.getXlsRowCount("C:\\users\\vendittit\\downloads\\GoogleToCSV - Sheet1.csv", "Sheet1"));
//		String[][] ls = Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.csv", "Notifications",true);
		//String[][] ls = Excel.getTableArray("C:\\Users\\vendittit\\Downloads\\Notifications.xlsx", "Notifications");
		
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]);
		
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]+ "," + ls[0][3] + "," + ls[0][4]+ "," + ls[0][5] );
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]+ "," + ls[1][3] + "," + ls[1][4]+ "," + ls[1][5] );
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]+ "," + ls[2][3] + "," + ls[2][4]+ "," + ls[2][5] );
//		System.out.println(ls[3][0]+ "," + ls[3][1] + "," + ls[3][2]+ "," + ls[3][3] + "," + ls[3][4]+ "," + ls[3][5] );
//		System.out.println(ls[4][0]+ "," + ls[4][1] + "," + ls[4][2]+ "," + ls[4][3] + "," + ls[4][4]+ "," + ls[4][5] );
//		System.out.println(ls[5][0]+ "," + ls[5][1] + "," + ls[5][2]+ "," + ls[5][3] + "," + ls[5][4]+ "," + ls[5][5] );
//		System.out.println(ls[6][0]+ "," + ls[6][1] + "," + ls[6][2]+ "," + ls[6][3] + "," + ls[6][4]+ "," + ls[6][5] );
//		System.out.println(ls[7][0]+ "," + ls[7][1] + "," + ls[7][2]+ "," + ls[7][3] + "," + ls[7][4]+ "," + ls[7][5] );
//		System.out.println(ls[8][0]+ "," + ls[8][1] + "," + ls[8][2]+ "," + ls[8][3] + "," + ls[8][4]+ "," + ls[8][5] );
//		System.out.println(ls[9][0]+ "," + ls[9][1] + "," + ls[9][2]+ "," + ls[9][3] + "," + ls[9][4]+ "," + ls[9][5] );
//		
		
		//System.out.println(Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "SearchList"));
		
		
		//rows
//		Log.logBanner("getXlsRowCount");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//				
//		Log.logBanner("getXlsRowData");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "0"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "2"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "220000000001"));
		
//		Log.logBanner("getXlsRowDataAsList");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		System.out.println(Excel.getXlsContentAsListOfMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.xls", "Notifications"));
		
//		Log.logBanner("getXlsRowDataAsMap");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		
//		Log.logBanner("getXlsRowContentAsMap");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowContentAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", 2));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowContentAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", 2));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowContentAsMap("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", 2));
//		
//		
//		//get cell and get Table
//		
//		Log.logBanner("getTableArray");
//		String[][] ls=null;
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		ls = Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.csv", "Notifications");
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]);
//
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		ls = Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.xlsx", "Notifications");
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]);
//
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		ls = Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.xls", "Notifications");
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]);
//		
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		ls = Excel.getTableArray("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications");
//		System.out.println(ls[0][0]+ "," + ls[0][1] + "," + ls[0][2]);
//		System.out.println(ls[1][0]+ "," + ls[1][1] + "," + ls[1][2]);
//		System.out.println(ls[2][0]+ "," + ls[2][1] + "," + ls[2][2]);
//		
//		
//		
//		
//		
//		Log.logBanner("getCellContentAsString");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getCellContentAsString("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", 3,4));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getCellContentAsString("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications",2,2));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getCellContentAsString("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications",2,2));
//	
//		
//		
//		
//		//Columns
//		Log.logBanner("getXlsColumnCount");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnCount("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications"));
//	
//		
//		
//		Log.logBanner("getXlsColumnData");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.xls", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Expected Results"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnData("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Expected Results"));
//
//		Log.logBanner("getXlsColumnDataAsList");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Expected Results"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataAsList("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Expected Results"));
//
//		Log.logBanner("getXlsColumnDataReadEmpty");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications.xls", "Notifications", "3"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Step Name"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsColumnDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "Step Name"));
//
//		
//		Log.logBanner("getXlsRowDataReadEmpty");
//		Log.gsAutomationTestDataSpreadsheetSuffix=".csv";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "6"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xlsx";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "6"));
//		Log.gsAutomationTestDataSpreadsheetSuffix=".xls";
//		System.out.println(Log.gsAutomationTestDataSpreadsheetSuffix);
//		System.out.println(Excel.getXlsRowDataReadEmpty("C:\\Selenium_Automation\\trunk\\automation\\google\\testdata\\Notifications", "Notifications", "6"));
//	
//		
		
		
		
		//System.out.println(DateTime.getFormattedDateTime(FileIO.getLastModifiedTime("c:\\movetest\\Test123.txt"),"MM:dd:yyyy hh:mm:ss"));
		//System.out.println(FileIO.getLastModifiedTime("c:\\movetest\\Test123.txt"));
		//FileIO.deleteFile("c:\\movetest\\sub1\\sub2\\sub3\\");
		
		//FileIO.appendStringToFile("c:\\movetest\\Test123.txt","Tony is best");
		
//		if (FileIO.fileExists("c:\\mytest.txt", 30))
//			System.out.println("found: ");
//		else
//			System.out.println("not found: ");
//		
		
		long l = Timers.startTimer();
		
		Platform.sleep(12);
		
		System.out.println(Timers.getElapsedTime(l));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Split string and String array  example
	 */
	String splitString(String s)
	{
	
	String[] o = s.split(" ");
	
	for(int x = 0; x< o.length; x++)
		System.out.println(o[x]);
	
	//System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3]);
	return o[0] + " " + o[1] + " " + o[2] + " " + o[3];
	}
	
	
	/**
	 * String Tokenizer example
	 */
	String tokenizer(String s)
	{
	String o = "";	
	
	StringTokenizer t = new StringTokenizer(s);
	
	while(t.hasMoreTokens()){
	   o = o + " " + t.nextToken(" ");
	   //System.out.println(t.nextToken(" "));
	}  
	
	return o; 
	}
	
	
	//command line example
	class CommandLineExec {
	public void main(String args[])
	{
		if (args.length >= 1){
		System.out.println(args[0]);
		}
	}
	
	}
	
	
	public void printFilesInFolder(String sFolder) {
	        File file = new File(sFolder);
	        String[] fileList = file.list();
	        for(String name:fileList){
	            System.out.println(name);
	        }
	    }
	
	
	public void printDateInfo(){
		Date d = new Date();
        System.out.println("Todays Date is: "+d);
        
     
        
	}
	
	//file read example
	public static void getFileContents(String filename) {

		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}	
	
	
	//nested for loop example
	public void sumInts(int[] i, int z)
	{

		int[] n = i;

		for (int x=0; x < i.length; x++){

		for (int c = 0; c < n.length; c++)
		    {
		    if (i[x] + n[c] == z)
		    	System.out.println(String.valueOf(i[x]) + " + " + String.valueOf(n[c]) + " = " + String.valueOf(z));
		    }     
		} 
	}
	
	
	
	//HashMap example
	public void printMap(){
		HashMap<String, String> hm = new HashMap<String, String>();
       //add key-value pair to hashmap
       hm.put("first", "FIRST INSERTED");
       hm.put("second", "SECOND INSERTED");
       hm.put("third","THIRD INSERTED");
       //System.out.println(hm);
       Set<String> keys = hm.keySet();
       for(String key: keys){
           System.out.println(key);
       }
       
   }
	
	
	
	
	//List example
	List<String> listExample(String[] args)
	{
	List<String> lst = new ArrayList<String>();
	
	for (int x =0; x < args.length; x++)
	{
		lst.add(args[x]);
	}
	
	lst.remove(args[1]);
	
	return lst;
	}
	
	
	
	//Set example
	
	//arrays
	
	
	
	
	
	
	
	
	  
	
	
	
	
	
	

	@AfterClass
	/**
	 * @function: tearDown() 
	 * @description: This function ends the test, calculates and logs the test results and terminates the automation
	 * @author: Script Authors name goes here  
	 */
	public static void tearDown() throws Exception {		
	
	}

}







