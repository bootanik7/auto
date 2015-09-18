package D2.Regression.client_console.applibs;

/**
 * This class instantiates and organizes Google Preferences data to be used with
 * the googleSetPreferences(GooglePrefDataType gpdt) method
 * @author Tony Venditti
 */
public class GooglePrefDataType {
		
	String sInterfaceLanguage;  	//ex. "English"
	String[] lsSearchLanguages;		//ex. {"Arab","Italian","Spanish"}
	String sLocation;				//ex. "498 Old Connecticut Path Framingham, MA 01701"
	String sFiltering;				//ex. "Use strict filtering", "Use moderate filtering", "Do not filter"
	String sGoogleInstant;			//ex. "Use Google Instant", "Do not use Google Instant"
	boolean bResultsWindow;			//ex. true: will check option to "Open search results in a new browser window." false: unchecks this option
	
	public GooglePrefDataType(String sInterfaceLanguage, String[] lsSearchLanguages, String sLocation, String sFiltering, String sGoogleInstant, boolean bResultsWindow){
		this.sInterfaceLanguage = sInterfaceLanguage;
		this.lsSearchLanguages = lsSearchLanguages;
		this.sLocation = sLocation;
		this.sFiltering = sFiltering;
		this.sGoogleInstant = sGoogleInstant;
		this.bResultsWindow = bResultsWindow;	
	}
	
	
}
