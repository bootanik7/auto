package V4.Smoke.enrollment.applibs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.libs.SeleniumCore;
import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.ListBox;

public class Erm_AccountSummary_Page
{ 
	/**
	 * Link object for "AccountSummary_Link_AcntSumry" Link with locator of "link=Account Summary"
	 * @return web UI Link object for the "AccountSummary_Link_AcntSumry" Link with locator of "link=Account Summary"
	 */
	public static Link AccountSummary_Link_AcntSumry()
	{
		return new Link("link=Account Summary");
	}
	public static void clilk_on_AcntSumry()
	{
		AccountSummary_Link_AcntSumry().click();
	}

	/**
	 * Link object for "AccountSummary_Link_SetupAutoPay" Link with locator of "link=Set Up Auto Pay"
	 * @return web UI Link object for the "AccountSummary_Link_SetupAutoPay" Link with locator of "link=Set Up Auto Pay"
	 */
	public static Link AccountSummary_Link_SetupAutoPay() {
		return new Link("link=Set Up Auto Pay");
	}
	public static void click_on_SetupAutoPay()
	{
		AccountSummary_Link_SetupAutoPay().click();
	}


	/**
	 * Link object for "AccountSummary_Link_MdfyAutoPay" Link with locator of "link=Modify Your Auto Pay"
	 * @return web UI Link object for the "AccountSummary_Link_MdfyAutoPay" Link with locator of "link=Modify Your Auto Pay"
	 */
	public static Link AccountSummary_Link_MdfyAutoPay() {
		return new Link("link=Modify Your Auto Pay");
	}

	/**
	 * Link object for "AccountSummary_Link_MngPersonalInfo" Link with locator of "link=Manage Personal Information & Preferences"
	 * @return web UI Link object for the "AccountSummary_Link_MngPersonalInfo" Link with locator of "link=Manage Personal Information & Preferences"
	 */
	public static Link AccountSummary_Link_MngPersonalInfo() 
	{
		return new Link("link=Manage Personal Information & Preferences");
	}
	public static void click_on_MngPersonalInfo()
	{
		AccountSummary_Link_MngPersonalInfo().click();
	}


	/**
	 * Link object for "AccountSummary_Link_MngBilingAcnt" Link with locator of "link=Manage Billing Accounts"
	 * @return web UI Link object for the "AccountSummary_Link_MngBilingAcnt" Link with locator of "link=Manage Billing Accounts"
	 */
	public static Link AccountSummary_Link_MngBilingAcnt() 
	{
		return new Link("link=Manage Billing Accounts");
	}
	public static void click_on_MngBilingAcnt()
	{
		AccountSummary_Link_MngBilingAcnt().click();
	}


	/**
	 * Link object for "AccountSummary_Link_MngPmtAcnt" Link with locator of "link=Manage Payment Methods"
	 * @return web UI Link object for the "AccountSummary_Link_MngPmtAcnt" Link with locator of "link=Manage Payment Methods"
	 */
	public static Link AccountSummary_Link_MngPmtAcnt()  
	{
		return new Link("link=Manage Payment Methods");
	}
	public static void click_on_MngPmtAcnt()
	{
		AccountSummary_Link_MngPmtAcnt().click();
	}


	/**
	 * Link object for "AccountSummary_Link_Logout" Link with locator of "link=Log Out"
	 * @return web UI Link object for the "AccountSummary_Link_Logout" Link with locator of "link=Log Out"
	 */
	public static Link AccountSummary_Link_Logout() 
	{
		return new Link("link=Log Out");
	}
	public static void click_on_logout()
	{
		AccountSummary_Link_Logout().click();
	}


	/**
	 * Link object for "AccountSummary_Link_ViewPmtHistry" Link with locator of "link=View Payment History"
	 * @return web UI Link object for the "AccountSummary_Link_ViewPmtHistry" Link with locator of "link=View Payment History"
	 */
	public static Link AccountSummary_Link_ViewPmtHistry() 
	{
		return new Link("link=View Payment History");
	}


	/**
	 * Link object for "AccountSummary_Link_ViewBill" Link with locator of "link=View Bill"
	 * @return web UI Link object for the "AccountSummary_Link_ViewBill" Link with locator of "link=View Bill"
	 */
	public static Link AccountSummary_Link_ViewBill()
	{
		return new Link("link=View Bill");
	}


	/**
	 * Link object for "AccountSummary_Link_VieweBillHistry" Link with locator of "link=View eBill History"
	 * @return web UI Link object for the "AccountSummary_Link_VieweBillHistry" Link with locator of "link=View eBill History"
	 */
	public static Link AccountSummary_Link_VieweBillHistry() 
	{
		return new Link("link=View eBill History");
	}

	/**
	 * ListBox object for "AccountSummary_DropDown_FndingAcnt" ListBox with locator of "id=fundingAccountId0"
	 * @return web UI ListBox object for the "AccountSummary_DropDown_FndingAcnt" ListBox with locator of "id=fundingAccountId0"
	 */
	public static ListBox AccountSummary_DropDown_FndingAcnt()
	{
		return new ListBox("name=fundingAccountId");
	}

	public static void wait_drop_down(){
		AccountSummary_DropDown_FndingAcnt().waitForVisibility(10);
	}
	public static void click_AccountSummary_FndingAcnt(String s1)
	{
		List<String>getvalues=collectlistitems();
		for(int i=0;i<getvalues.size();i++){
			if(getvalues.get(i).contains(s1)) {
				AccountSummary_DropDown_FndingAcnt().selectItem(getvalues.get(i));
			}
		}

	}

	public static Boolean isDivisionPresent()
	{
		return  AccountSummary_DropDown_FndingAcnt().isVisible();
	}
    public static void clickondropdown(String s1){
		AccountSummary_DropDown_FndingAcnt().selectItem(s1				);

    }

	public static List<String> collectlistitems() 
	{
		List<String>getvalues=new ArrayList<String>();
		WebElement select = SeleniumCore.driver.findElement(By.name("fundingAccountId"));
		List<WebElement>list = select.findElements(By.tagName("option"));
		System.out.println("it is in"+list);
		for(WebElement getlist:list)
		{
			getvalues.add(getlist.getText());
		}

		return getvalues;

	}
	/**
	 * Button object for "AccountSummary_Button_PayMyBill" Button with locator of "id=submitBtnId0"
	 * @return web UI Button object for the "AccountSummary_Button_PayMyBill" Button with locator of "id=submitBtnId0"
	 */
	public static Button AccountSummary_Button_PayMyBill()
	{
		return new Button("id=submitBtnId0");
	}

	public static Button AccountSummary_Button_onetime_pay()
	{
		return new Button("id=submitBtnId");
	}
	
	public static Button goToAcctpage()
	{
		return new Button("name=submit");
	}
    public static void clickgoToAcctpage(){
    	goToAcctpage().click();
    }

	public static void click_on_payMyBill() 
	{
		AccountSummary_Button_PayMyBill().click();
	}

	public static void click_on_onetimepay() 
	{
		AccountSummary_Button_onetime_pay().click();
	} 
	public static void proceed_paymybill(String Payment_type) 
	{
		//Erm_AccountSummary_Page.click_AccountSummary_FndingAcnt(s1);
		Erm_AccountSummary_Page.click_AccountSummary_FndingAcnt(Payment_type);
		if(AccountSummary_Button_PayMyBill().isVisible()){
		Erm_AccountSummary_Page.click_on_payMyBill();
		}else {
			Erm_AccountSummary_Page.click_on_onetimepay();
		}
	}


















}
