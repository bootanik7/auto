package V4.Smoke.client_console.applibs;


import core.webwidgets.Link;


public class Reports_Page {

	 
	public static Link HomePage_Link_ReportTab() {
		return new Link("link=REPORTS");
	}

	public static void click_HomePage_Link_ReportTab(){
		HomePage_Link_ReportTab().click();
	}
	
	

	public static Link Report_Link_TransReport() {
		return new Link("link=Transaction Reports");
	}
	public static Link Report_Link_SettleReport() {
		return new Link("link=Settlement Reports");
	}
	public static Link Report_Link_HourReport() {
		return new Link("link=Hourly Report");
	}
	public static Boolean is_Report_Link_HourReport_present(){
		return Report_Link_HourReport().isVisible();
	}
	public static Link Report_Link_CCActivityReport() {
		return new Link("link=Client Console Activity Reports");
	}
	
	
	
	public static Link Report_Link_EnrReport() {
		return new Link("link=Enrollment Reports");
	}
	
	
	public static Link Report_Link_RejectReport() {
		return new Link("link=Reject Reports");
	}
	
	
	public static Link Report_Link_IVRReport() {
		return new Link("link=IVR Reports");
	}
	
	public static Link Report_Link_NotificationReport() {
		return new Link("link=Notification of change Report");
	}

public static void  click_Report_Link_TransReport(){
	Report_Link_TransReport().click();
}
	
	public static Boolean is_click_Report_Link_TransReport(){
		return Report_Link_TransReport().isVisible();
	}
	
public static void  click_Report_Link_SettleReport(){
	Report_Link_SettleReport().click();
}

public static Boolean is_click_Report_Link_SettleReport_present(){
	return Report_Link_SettleReport().isVisible();
	
}
public static void  click_Report_Link_HourReport(){
	Report_Link_HourReport().click();
}	
	
	
	
public static void  click_Report_Link_CCActivityReport(){
	Report_Link_CCActivityReport().click();
}	
	
public static void  click_Report_Link_EnrReport(){
	Report_Link_EnrReport().click();
}

public static void  click_Report_Link_RejectReport(){
	Report_Link_RejectReport().click();
}

public static void  click_Report_Link_IVRReport(){
	Report_Link_IVRReport().click();
}

public static void  click_Report_Link_NotificationReport(){
	Report_Link_NotificationReport().click();
}

public static Boolean is_click_Report_Link_NotificationReport_present(){
	return Report_Link_NotificationReport().isVisible();
}

public static Boolean is_Report_Link_EnrReport_present(){
	return Report_Link_EnrReport().isVisible();
}

public static Boolean is_Report_Link_RejectReport_present(){
	return Report_Link_RejectReport().isVisible();
}
public static Boolean is_Report_Link_Link_IVRReport_present(){
	return Report_Link_IVRReport().isVisible();
}

public static Boolean is_Report_Link_CCActivityReport_present(){
	return Report_Link_CCActivityReport().isVisible();
}
}
