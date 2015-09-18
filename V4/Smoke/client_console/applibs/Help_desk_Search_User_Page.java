package V4.Smoke.client_console.applibs;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.libs.SeleniumCore;
import core.webwidgets.Button;
import core.webwidgets.TextField;

public class Help_desk_Search_User_Page {
	 
	
	

	
	public static Button ViewUser(){
		  return new Button("//*[@type='Submit' and @value='View User']");}

    
	/*public static String confirmation_number() {
		String text = null;

		//SeleniumCore.driver.get("https://docs.atlassian.com/aui/5.2/docs/tables.html");
		List<WebElement> list= SeleniumCore.driver.findElements(By.tagName("tr"));
		for(WebElement test:list){
			if(test.getText().contains("Confirmation Number:")){
				System.out.println("print the value....."+test.getText());
				text=test.getText();

			}

		}

		return text;

	}
*/



}
