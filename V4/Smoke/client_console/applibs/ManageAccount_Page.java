package V4.Smoke.client_console.applibs;

import core.webwidgets.Button;
import core.webwidgets.Link;
import core.webwidgets.TextField;

public class ManageAccount_Page {

    /**
	 * manage account   link  object declaration
	 * @return manage account  link  object
	 *author:ARCHANA ENTURU
	 */
	public static  Link Manage_AccountLink() {
		return new Link("//a[contains(text(),'MANAGE TRANSACTIONS')]");}
	/**
	 *clicks on manage account link
	 * 
	 *author:ARCHANA ENTURU
	 */
  public static void click_Manage_AccountLink(){
	  Manage_AccountLink().click();
  }
  /**
   *  manage account visible text object declaration
   * @return captures the manage account visibletext   TextField object
   *author:ARCHANA ENTURU
   */
  public static  TextField Text() {
		return new TextField("//p[@class='body-page-header' and contains(text(),'Manage Accounts')]");}
  /**
   * captures  manage account visible text 
   * @return string of captured visible text from the UI
   *author:ARCHANA ENTURU
   */
  
  public static String Get_Text(){
	  String  String =Text().getText();
	  return String;
  }
  
  /**
	 * Email Address textfield  object declaration
	 * @return Email Address textfield object
	 *author:ARCHANA ENTURU
	 */
  
  
  public static  TextField EmailTF() {
		return new TextField("name=emailAddress");}


/**
 * (Email address SEARCH) radioButton object declaration
 * @return (email address SEARCH) radioButton object
 *author:ARCHANA ENTURU
 */
  
  
  public static Button EmailTF_Search(){
	  return new Button("//input[@type='Submit' and @ name='ManageAccountByEmailAddress' and @ value='Search']");
  }
  
  /**
   *clicks on email address search  button
   * 
   *author:ARCHANA ENTURU
   */
  
  public static void click_EmailTF_Search(){
	 EmailTF_Search().click();
  }
  /**
   *Enter the Email address on the email address textfield
   * @param:sEmail string text to enter into email address  textfield
   *author:ARCHANA ENTURU
   */
  
  public static void enter_Email(String sEmail){
	  EmailTF().setText(sEmail);
   }
   
    /**
	 *LoginId  TextField   object declaration
	 * @return LoginId  TextField   object
	 *author:ARCHANA ENTURU
	 */
    public static  TextField LoginId() {
		return new TextField("name=loginId");}

    /**
     *Enter theLoginId on the  LoginId textfield
     * @param:sLoginId string text to enter into LoginId  textfield
     *author:ARCHANA ENTURU
     */
    public static void enter_LoginId(String sLoginId){
  	  LoginId().setText(sLoginId);}
   

    /**
	 * LoginID SEARCH Button object declaration
	 * @return LoginID SEARCH  Button object
	 *author:ARCHANA ENTURU
	 */
    public static Button LoginSearch(){
    	return new Button("//input[@ type='Submit' and @ name='ManageAccountByLoginId' and @value='Search']");
    }

    /**
     *clicks on LoginId_search  Radiobutton
     * 
     *author:ARCHANA ENTURU
     */
    
    
    public static void Click_LoginId_search(){
    	  LoginSearch().click();}
    

    /**
	 * DivisionSearch  textfeild object declaration
	 * @return DivisionSearch  Button object
	 *author:ARCHANA ENTURU
	 */
    
    public static Button DivisionSearch(){
    	return new  Button("//input[@name='ManageAccountByBillingAccountNumber' and  @value='Search']");
    
    }

    /**
     *Enter the division searach text on the division  textfield
     * @param:sDV string text to enter into DivisionSearch  textfield
     *author:ARCHANA ENTURU
     */
    public static void click_DivisionSearch(String sDV){
    	  DivisionSearch().setText(sDV);}


















}
