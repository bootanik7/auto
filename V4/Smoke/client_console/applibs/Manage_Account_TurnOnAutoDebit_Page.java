package V4.Smoke.client_console.applibs;

import core.webwidgets.CheckBox;
import core.webwidgets.RadioButton;
import core.webwidgets.TextField;

public class Manage_Account_TurnOnAutoDebit_Page {
     
	/**
	 * textfield to capturing the visible text
	  * @author ENTURU ARCHANA
	  */
	public static TextField VisibleText(){
	return new TextField("//*[contains(text(),'Turn On Autodebit') and @class='body-page-header']");
   }
	  /**
	  * captures the visible test from UI and stores in a string 
	  * @author ENTURU ARCHANA
	  */
    public static String get_VisibleText(){
	    String sText= VisibleText().getText();
	     return sText;
       }
    
    
   	/**
   	 * textfield to set the frequency of duration 
   	  * @author ENTURU ARCHANA
   	  */
    public static TextField Frequency(){
	   return new TextField(".//*[@id='frequency']");}
    /**
	  * Enter the frequency into the desired textfeild in the UI
	  * @param: FText text to enter into FRequency text field
	  * @author ENTURU ARCHANA
	  */
    
    public static void Enter_FrequencyText(String FText){
	   Frequency().setText(FText);}
    
    /**
	 *  Duration TextField object declaration
	 * @return  Duration TextField object
	 *author:ARCHANA ENTURU
	 */
    
    public static TextField Duration(){
	   return new TextField("//*[@name='durationType']");}
    /**
	 *  Enter_Duration into the duration textfield
	 * @Param:  sText string text to enter into manage account duartion textfield.
	 *author:ARCHANA ENTURU
	 */
    public static void Enter_Duration(String sText){
	   Duration().setText(sText);}
    /**
	 * start date  TextField object declaration
	 * @return start date  TextField object
	 *author:ARCHANA ENTURU
	 */

    
    
    public static TextField StartDate(){
	   return new TextField("//*[@name='startDate']");}
    /**
	 *  enters the start date  into the start date  textfield
	 * @Param:  sText string text to enter into manage account start date  textfield.
	 *Author:ARCHANA ENTURU
	 */
    
    public static void Enter_StartDate(String sText){
	    StartDate().setText(sText);}
    /**
	 * suspend date  TextField object declaration
	 * @return suspend date   TextField object
	 *author:ARCHANA ENTURU
	 */

    
    public static TextField Suspend_Date(){
	    return new TextField("//*[@name='startDate']");}
    /**
   	 *  enters the suspend date   into the suspend date   textfield
   	 * @Param:  sText string text to enter into manage account suspend date   textfield.
   	 *Author:ARCHANA ENTURU
   	 */
       
     
    
    public static void Enter_Suspend_Date(String sText){
	    Suspend_Date().setText(sText);}

    /**
	 *  Date_Due  radioButton object declaration
	 * @return  Date_Due   TextField object
	 *author:ARCHANA ENTURU
	 */
     
    public static RadioButton Date_Due(){
	     return new RadioButton("//*[@value='DUE DATE']");}

    /**
   	 * clicks on Due date radioButton  
   	 * 
   	 *Author:ARCHANA ENTURU
   	 */
    
    public static void Click_Radio_Date_Due(){
	     Date_Due().click();}

    /**
	 *  Fixed_week radioButton object declaration
	 * @return   Fixed_week   radioButton object
	 *author:ARCHANA ENTURU
	 */ 
    
    public static RadioButton  Fixed_week(){
  	     return new RadioButton("//*[@value='DAY OF WEEK']");}

    /**
   	 * clicks on Fixed_week radio button   
   	 * 
   	 *Author:ARCHANA ENTURU
   	 */
   
    
    public static void Click_Fixed_week(){
	       Fixed_week().click();
    }

    /**
   	 *  Fixed_week text box textfeild object declaration
   	 * @return   Fixed_week   textfeild object
   	 *author:ARCHANA ENTURU
   	 */ 
    public static TextField  Fixed_week_Text(){
	     return new TextField("//*[@name='dayOfWeek']");}
   
    
    /**
   	 *  enters the fixed week string   into the    textfield
   	 * @Param:  sText string text to enter into manage account fixed_week    textfield.
   	 *Author:ARCHANA ENTURU
   	 */
       
     
      public static void Enter_Fixed_week(String sText){
	      Fixed_week_Text().setText(sText);
        }

      /**
     	 *  Fixed_date   RadioButton object declaration
     	 * @return   Fixed_week   RadioButton object
     	 *author:ARCHANA ENTURU
     	 */ 
      
      public static RadioButton  Fixed_Date(){
	  return new RadioButton("//*[@value='DAY OF MONTH']");}

      /**
     	 * clicks on Fixed_date  radio button   
     	 * 
     	 *Author:ARCHANA ENTURU
     	 */
      public static void Click_Fixed_Date(){
	    Fixed_Date().click();}

      /**
  	 * debit date  TextField object declaration
  	 * @return   debit date  RadioButton object
  	 *author:ARCHANA ENTURU
  	 */ 
   
      public static TextField Enter_DB_Date(){
	    return new TextField("//*[@name='dayNumber']");}

      /**
     	 *  enters the _Fixed_Date string   into the    textfield
     	 * @Param:  sText string text to enter into Fixed_Date    textfield.
     	 *Author:ARCHANA ENTURU
     	 */
      
      
      
      public static void Enter_Fixed_Date(String sText){
	     Enter_DB_Date().setText(sText);}

      /**
   	 *  DaysBefore_Bill_due  RadioButton object declaration
   	 * @return   DaysBefore_Bill_due   RadioButton object
   	 *author:ARCHANA ENTURU
   	 */ 
      
      public static RadioButton  DaysBefore_Bill_due(){
	      return new RadioButton("//*[@value='DAYS BEFORE DUE DATE']");}

      /**
   	 * clicks on DaysBefore Bill due radio button   
   	 * 
   	 *Author:ARCHANA ENTURU
   	 */
      public static void Click_DaysBefore_Bill_due(){
	      DaysBefore_Bill_due().click();}
      /**
     	 *  DaysBefore_Bill_due  TextField object declaration
     	 * @return   DaysBefore_Bill_due   TextField object
     	 *author:ARCHANA ENTURU
     	 */ 

      public static TextField DB_Date(){
	       return new TextField("//*[@name='daysBeforeDue']");}
      /**
   	 *  enters the  DaysBefore_Bill_due string   into the    textfield
   	 * @Param:  sText string text to enter into  DaysBefore_Bill_due    textfield.
   	 *Author:ARCHANA ENTURU
   	 */
     public static void Enter_DB_Date(String sText){
	DB_Date().setText(sText);}
         /**
    	 *  Upon bill pay  RadioButton object declaration
    	 * @return    Upon bill pay   RadioButton object
    	 *author:ARCHANA ENTURU
    	 */ 
    
     public static RadioButton  Upon_Bill_Recipt(){
	    return new RadioButton("//*[@value='UPON RECEIPT']");}

     /**
  	 * clicks on Upon_Bill_Rcpt radio button   
  	 * 
  	 *Author:ARCHANA ENTURU
  	 */
   
     public static void Click_Upon_Bill_Rcpt(){
	    Upon_Bill_Recipt().click();}

     /**
 	 *  Semi_Month  RadioButton object declaration
 	 * @return   Semi_Month   RadioButton object
 	 *author:ARCHANA ENTURU
 	 */ 
       public static RadioButton Semi_Month(){
	   return new RadioButton("//*[@value='SEMI-MONTHLY DAYS']]");}

       /**
    	 * clicks on Semi_Month radio button   
    	 * 
    	 *Author:ARCHANA ENTURU
    	 */
      public static void Click_Semi_Month(String sText){
	    Semi_Month().click();}
      /**
   	 *  FirstDay TextField  object declaration
   	 * @return   FirstDay   RadioButton object
   	 *author:ARCHANA ENTURU
   	 */ 
       
      public static TextField  FirstDay(){
	    return new TextField(".//*[@id='firstDayNumber']");}
      /**
     	 *  enters the  first day of month  string   into the    textfield
     	 * @Param:  sText string text to enter into  first day of month    textfield.
     	 *Author:ARCHANA ENTURU
     	 */
       
      public static void Enter_firstDay(String sText){
	     FirstDay().setText(sText);}
      /**
     	 *  Second_Day TextField  object declaration
     	 * @return   Second_Day   RadioButton object
     	 *author:ARCHANA ENTURU
     	 */

       public static TextField Second_Day(){
	     return new TextField("//*[@value='SEMI-MONTHLY DAYS']]");}

    
       /**
    	 *  enters the secondDayof month  string   into the    textfield
    	 * @Param:  sText string text to enter into secondDayof month    textfield.
    	 *Author:ARCHANA ENTURU
    	 */
       public static void Enter_secondDay(String sText){
	     Second_Day().setText(sText);}
       /**
    	 *  Amount_Due RadioButton object declaration
    	 * @return  Amount_Due  RadioButton object
    	 *author:ARCHANA ENTURU
    	 */ 

       public static RadioButton Amount_Due(){
	      return new RadioButton("//*[@value='AMOUNT DUE']");}

       /**
   	 *  Min_Amt_Due RadioButton object declaration
   	 * @return Min_Amt_Due  RadioButton object
   	 *author:ARCHANA ENTURU
   	 */ 

       public static RadioButton Min_Amt_Due(){
	      return new RadioButton("//*[@value='MINIMUM AMOUNT DUE']");}
       /**
      	 *  FixedAmount RadioButton object declaration
      	 * @return FixedAmount  RadioButton object
      	 *author:ARCHANA ENTURU
      	 */ 
       
       public static RadioButton FixedAmount(){
	      return new RadioButton("//*[@value='FIXED AMOUNT']");}

       /**
     	 *  Amt_Due_Uptot RadioButton object declaration
     	 * @return Amt_Due_Upto  RadioButton object
     	 *author:ARCHANA ENTURU
     	 */
       
       public static RadioButton Amt_Due_Upto(){
	      return new RadioButton("//*[@value='AMOUNT DUE THRESHOLD']");}
      
       /**
    	 * fixed amount text field  object declaration
    	 * @return fixed amount text field object
    	 *author:ARCHANA ENTURU
    	 */
      
      
       public static TextField TF_fixedAmount(){
	      return new TextField(" //*[@name='paymentAmount']");}

       /**
   	 * amount due text field  object declaration
   	 * @return amount due textfield object
   	 *author:ARCHANA ENTURU
   	 */
       public static TextField TF_amt_Due(){
	      return new TextField("[@name='paymentAmountThreshold']");}

       /**
    	 *  enters the fixed amount  string   into the    textfield
    	 * @Param:  sText string text to enter into fixed amount   textfield.
    	 *Author:ARCHANA ENTURU
    	 */

       
       public static void Enter_TfixedAmount(String sText){
	       TF_fixedAmount().setText(sText);}

       /**
    	 *  enters the toatal amount due  string   into the    textfield
    	 * @Param:  sText string text to enter into  toatalamount due    textfield.
    	 *Author:ARCHANA ENTURU
    	 */
        
         public static void Enter_Tamt_Due(String sText){
	        TF_amt_Due().setText(sText);}
         /**
        	 * enrollment terms and condition checkBox object declaration
        	 * @return enrollment terms and condition  checkBox object
        	 *author:ARCHANA ENTURU
        	 */
     public static CheckBox EnrollTC() {
	    return new CheckBox("//*[@name='termsAndConditionsFlag']");
	
        }
     /**
 	 * clicks on enrollment termss and conditions radio button   
 	 * 
 	 *Author:ARCHANA ENTURU
 	 */
     
     public static void Click_EnrollTC(){
	   EnrollTC().click();
    }









}