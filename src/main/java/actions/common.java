package actions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.PD4_main_Locators;
import locators.locators;

public class common {
	Boolean assertion = true;
	private static common add_objects;

	/**
	 * Method used to self-instantiate the class. Will make sure one object, and one
	 * object only is created in memory for this class. The purpose is to be able to
	 * call this object dynamically from any JAVA class that includes this as an
	 * import.
	 * 
	 * 
	 * @return Returns the object instantiated from the class.
	 */
	public static synchronized common action() {
		try {
			if (add_objects.equals(null)) {
				add_objects = new common();
			}
		} catch (Exception NOSYSTEM) {
			add_objects = new common();
		}
		return add_objects;
	}

	public static String GetCurrentDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
		return (dateFormat.format(cal.getTime()));

	}

	public static String GetCurrentDateFormat(String Format) throws Exception {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(Format, Locale.getDefault());
		return (dateFormat.format(cal.getTime()));

	}
	
	// ***************************PD
	// METHODS*********************************************//

	/**
	 * Login to the Project Director web-site.
	 * 
	 * 
	 * @param user    user name to login as in Project Director .
	 * 
	 * @param passw   password to use when login into Project Director.
	 * @param locator
	 * 
	 * @throws Exception used by isPresent, in case element is not present.
	 */
	public void PDlogIn(String user, String passw) throws Exception {
		System.out.println("In Method-  pd4_logIn() \n");
		// isPresent(PD4_main_Locators.exts().inputLoginUsername);
		
	////forgetpassLink
	    BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().LoginLink).click();
		Thread.sleep(50000);
					
		Verify.action().verifyElementPresent(PD4_main_Locators.exts().inputLoginUsername, 80);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().inputLoginUsername).sendKeys(user);
		Thread.sleep(1000);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().inputLoginPassword).sendKeys(passw);
		Thread.sleep(1000);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().loginButton).click();
		Thread.sleep(6000);

		// Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton,
		// 10);
		// System.out.println("\nLogin by -> "+user+"\n");
		// Thread.sleep(1000);

		// completed
		Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Completed2, 5);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Completed2).click();
		Thread.sleep(2000);

		// completed
		Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Completed, 5);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Completed).click();
		Thread.sleep(2000);

	}

	/**
	 * Logout of the Project Director web-site.
	 * 
	 * 
	 * @throws Exception used by isPresent, in case element is not present.
	 */
	public void PDlogOut() throws Exception {
		System.out.println("In Method-  pd4_logOut()-- \n");
		Thread.sleep(1000);
		Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton, 60);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton).click();
		Thread.sleep(1000);
		Verify.action().verifyElementPresent(PD4_main_Locators.exts().logoutButton, 10);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().logoutButton).click();
		Thread.sleep(1000);
		BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().logOut_yesButton).click();
		Thread.sleep(3000);
		System.out.println("Logged Out...");
	}

	/**
	 * Filter_Submission
	 * 
	 * @author Proteek
	 * 
	 * @param URL Enter URL of PD and CRXDE
	 * @throws Exception used by isPresent, in case element is not present.
	 */
	public void Open_New_Instance_URL(String URL) throws Exception {

		System.out.println("******INSIDE METHOD Open_PD_Instance_URL() ************");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		Thread.sleep(4000);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

		BrowserFactory.SystemEngine();
		ArrayList<String> tabs = new ArrayList<String>(BrowserFactory.driver.getWindowHandles());
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.get(URL);
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		System.out.println("**** EOM Open_PD_Instance_URL() **********");

	}

	// **********************************************************************************//

	/**
	 * Filter_Submission
	 * 
	 * @author Amrata
	 * 
	 * @param Set Format Set the date format
	 * 
	 */

	public String GetDataPlusFormat(Integer Days, String Format) throws Exception

	{
		SimpleDateFormat sdf = new SimpleDateFormat(Format);
		Calendar cal = Calendar.getInstance();
		// Displaying current date in the desired format
		System.out.println("Current Date: " + sdf.format(cal.getTime()));

		// Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH, Days);
		// Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		// Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}
	public String GetTodaysDate(String Format) throws Exception

	{
		 Calendar cal = Calendar.getInstance();
         SimpleDateFormat format1 = new SimpleDateFormat(Format);
         String formatted = format1.format(cal.getTime());
         System.out.println(formatted);
		return formatted;
	}
	public String GetNofromURL() throws Exception

	{
		String url=BrowserFactory.driver.getCurrentUrl();
      char[] chars = url.toCharArray();
      StringBuilder sb = new StringBuilder();
      for(char c : chars){
         if(Character.isDigit(c)){
            sb.append(c);
         }
      }
      System.out.println(sb);
      
      String newString = sb.substring(14);
      System.out.println(newString);
      System.out.println("No is"+newString);
		String ss3=Integer.toString(2);
		System.out.println("Int No is"+ss3);
		//String ss2
		int i=Integer.parseInt(newString)+1;  
		System.out.println("Increment No is"+i);
		String s1="("+ newString +"_"+i+")";
	//	String s1="("+ newString +"_ "+")";
		System.out.println("Final No is"+s1);
		
   return s1;
	}
      
	public void Create_StanderedPage(String cmsTab,String admintab,String contentType_name,String CommonSettingTypeopt,String commontypename,String common_Fieldname)
	{
		try {
		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab),15);//cmsTab
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab)).click();//cmsTab
		Thread.sleep(7000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);
		
		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(admintab),  25);//admintab[Content Type]
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(admintab)).click();//admintab[Content Type]
		Thread.sleep(2000);
		
		//[default std pg]
		Verify.action().verifyElementPresent(locators.exts().CMS_Admincontenttype_stdpage(contentType_name),  25);//[Default] Standard Page
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admincontenttype_stdpage(contentType_name)).click();
		Thread.sleep(4000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);
		
		//add property
		Verify.action().verifyElementPresent(locators.exts().contenttype_Stdpage_AddProperty,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().contenttype_Stdpage_AddProperty).click();
		Thread.sleep(2000);
		
		//_SettingType
		Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_SettingType,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_SettingType).click();
		Thread.sleep(2000);
		
		BrowserFactory.SystemEngine();
		((JavascriptExecutor) BrowserFactory.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		
		
		Verify.action().verifyElementPresent(locators.exts().CMS_Admin_CommonSetting_Type_selectOption(CommonSettingTypeopt),  5);//CommonSettingTypeopt[XHTML string (>255)]
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admin_CommonSetting_Type_selectOption(CommonSettingTypeopt)).click();//CommonSettingTypeopt[XHTML string (>255)]
		Thread.sleep(2000);
		
		//Type
		Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_Type,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_Type).sendKeys(commontypename);//commontypename[XHTMALContent]
		Thread.sleep(2000);
		
		//chk
		Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_valueperLang,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_valueperLang).click();
		Thread.sleep(2000);
		
		//Field name
		Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_Fieldname,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_Fieldname).sendKeys(common_Fieldname);//common_Fieldname[XHTMALTESTS]
		Thread.sleep(2000);
		
		//
		Verify.action().verifyElementPresent(locators.exts().CMS_Admin_CommonSetting_Type_selectTabOption("Content"),  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admin_CommonSetting_Type_selectTabOption("Content")).click();
		Thread.sleep(2000);
					
		
		//save
		Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_Save,  10);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_Save).click();
		Thread.sleep(2000);
		
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Go_to_Globalink_config() {

		try {
			Thread.sleep(5000);
			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer,30);
			WebElement element2 =BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer);
			((JavascriptExecutor)BrowserFactory.driver).executeScript("arguments[0].click();", element2);
			Thread.sleep(5000);
			

			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
			Thread.sleep(5000);

			// Click on global link config
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Go_to_Globalink_dashboard() {

		try {
			Thread.sleep(5000);
			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
			Thread.sleep(5000);

			// Click on global link config
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Go_to_Globalink_dashboard_Button() {

		try {
			Thread.sleep(5000);
			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
			Thread.sleep(5000);

			// Click on global link config
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo()
					.frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void go_to_CMS_from_Globallink(String TabName) {

		try {
			Thread.sleep(5000);
			if (Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10)) {

				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_CMS, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_CMS).click();
				Thread.sleep(5000);

			} else {

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab(TabName), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab(TabName)).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(3000);

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Close_ActiveTab
	 * 
	 * @author Proteek
	 * 
	 * @param originalHandle switch back to original Handle window
	 * @throws Exception used by isPresent, in case element is not present.
	 */

	public void Close_ActiveTab(String originalHandle) throws Exception {

		System.out.println("\nIn vendor.java -  switchToPopupWindow()\n");
		System.out.println("originalHandle--->" + originalHandle);

		BrowserFactory.SystemEngine();
		for (String handle : BrowserFactory.driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				System.out.println("handle--->" + handle);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().window(handle);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.close();

			}
		}
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().window(originalHandle);
		System.out.println("\nEOM - Close_ActiveTab().\n");
		;

	}

	public String GetDataPlus(Integer Days) throws Exception

	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		// Displaying current date in the desired format
		System.out.println("Current Date: " + sdf.format(cal.getTime()));

		// Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH, Days);
		// Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		// Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}

	public void toggle_navigation_tree_icon(boolean state) throws Exception {

		try {
			Thread.sleep(3000);
			if (state == true) {
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_toggle_open).click();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_toggle_pin_button).click();
				Thread.sleep(2000);

			} else if (state == false) {
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_toggle_close).click();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toggle_assects_pane_tree_icon(boolean state) throws Exception {

		try {
			Thread.sleep(3000);
			if (state == true) {
				//BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_assetspane_toggle_close).click();
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_assetspane_toggle_close1).click();
				Thread.sleep(2000);
				//BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_assetspane_pin_button).click();
				//Thread.sleep(2000);

			} else if (state == false) {
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_assetspane_toggle_open).click();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create_page(String pagename) throws Exception {

		try {
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_plus_icon).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_plus_icon_newpage).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_name_input).clear();
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_name_input)
					.sendKeys("Test-page");
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Standard_page_).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void create_basic_submission_SubmitforTranslation(String Page_name,String SubName) throws Exception {

		try {
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Page_name)).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
			
			common.action().Config_ReferencedContentTypesChecks(true,true, true, true, true);

			// select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			Thread.sleep(7000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void create_basic_submission(String Page_Name,String SubName,boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media,
			boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,
			boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction) throws Exception {

		try {
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Page_Name)).click();
			Thread.sleep(5000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
							
			
			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(IncludeChild_Items,IncludeReferenced_Content, Pages, Blocks, Media);
						
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(ReferencedDepth, ReferencedDepthValue, IncludeExpired_Source, IncludeExpired_Target, IncludeUnchanged_Content, IncludeDuplicate_Request, PostTranslationAction, TrasnlationAction);
			
			
			//select language
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
			Thread.sleep(3000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation1).click();
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
			Thread.sleep(10000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);
			

			System.out.println("Submission :" + SubName + " is created.....");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void create_basic_submission_Block(String Page_Name,String SubName,boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media,
			boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,
			boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction) throws Exception {

		try {
			

			BrowserFactory.SystemEngine().findElement(locators.exts().Select_Block(Page_Name)).click();
			Thread.sleep(5000);
			
			//Block_Page
			WebElement ele= BrowserFactory.SystemEngine().findElement(locators.exts().Block_Page);
			Actions act=new Actions(BrowserFactory.driver);
			act.doubleClick(ele).build().perform();			
			Thread.sleep(5000);
			
			Gl_Trasnlations_GetJob(1,"Create job from current item");
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
							
			
			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(IncludeChild_Items,IncludeReferenced_Content, Pages, Blocks, Media);
						
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(ReferencedDepth, ReferencedDepthValue, IncludeExpired_Source, IncludeExpired_Target, IncludeUnchanged_Content, IncludeDuplicate_Request, PostTranslationAction, TrasnlationAction);
			
			
			//select language
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
			Thread.sleep(3000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation1).click();
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
			Thread.sleep(10000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);
			

			System.out.println("Submission :" + SubName + " is created.....");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void Config_ReferencedContentTypesChecks(boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media) throws Exception {

		try {
	
			// select Configuration Tab
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_configuration_tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(2000);
			
			if (IncludeChild_Items==true) {
				
				if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("include the child items"), 5)){
					BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include the child items")).click();
					System.out.println("INSIDE CHECKED======>");
				}	
			}
				if (IncludeChild_Items==false){
					if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("include the child items"), 5)){
						BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include the child items")).click();
						System.out.println("INSIDE UNCHECK==============>");
					}					
				}
				
				if (IncludeReferenced_Content==true) {
					
					if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("include the items referenced"), 5)){
						BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include the items referenced")).click();
						System.out.println("INSIDE CHECKED");
					}	
				}
					if (IncludeReferenced_Content==false){
						if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("include the items referenced"), 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include the items referenced")).click();
							System.out.println("INSIDE UNCHECK");
						}					
						
					}
					
					//Referenced Content Types > Pages,Blocks & Media
					if (Pages==true) {
						if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Pages"), 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Pages")).click();
						}	
					}
						if (Pages==false){
							if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Pages"), 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Pages")).click();
							}					
						}
						
						
						if (Blocks==true) {
							
							if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Blocks"), 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Blocks")).click();
							}	
						}
							if (Blocks==false){
								if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Blocks"), 5)){
									BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Blocks")).click();
								}					
							}
							
							if (Media==true) {
								
								if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Media"), 5)){
									BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Media")).click();
								}	
							}
								if (Media==false){
									if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_RCTypes__checbox_checked("Media"), 5)){
										BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_RCTypes_checkbox("Media")).click();
									}					
								}


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	public void Config_ReferencedContentTypesChecks_WithDepthAndActions(boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction) throws Exception {

		try {
		
			if (ReferencedDepth==true) {
				
				Verify.action().verifyElementPresent(locators.exts().RefDepth_Input, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().RefDepth_Input).click();
					BrowserFactory.SystemEngine().findElement(locators.exts().RefDepth_Input).clear();
					Thread.sleep(1000);
					BrowserFactory.SystemEngine().findElement(locators.exts().RefDepth_Input).sendKeys(ReferencedDepthValue);
					System.out.println("Entered Reference Depth Value------>"+ReferencedDepthValue);
			
			}
				/*
				if (IncludeExpired_Source==true) {
					
					if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("include content that has been marked as expired"), 5)){
						BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include content that has been marked as expired")).click();
						System.out.println("INSIDE CHECKED");
					}	
				}
					if (IncludeExpired_Source==false){
						if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("include content that has been marked as expired"), 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include content that has been marked as expired")).click();
							System.out.println("INSIDE UNCHECK");
						}					
						
					}
					
					//Referenced Depth
					if (IncludeExpired_Target==true) {
						if(Verify.action().verifyElementNotPresent(locators.exts().IncludeExpiredTarget_CheckBoxChecked, 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().IncludeExpiredTarget_Checkbox).click();
						}	
					}
						if (IncludeExpired_Target==false){
							if(Verify.action().verifyElementPresent(locators.exts().IncludeExpiredTarget_CheckBoxChecked, 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().IncludeExpiredTarget_Checkbox).click();
							}					
						}
						
						BrowserFactory.SystemEngine();
						((JavascriptExecutor)BrowserFactory.driver).executeScript(
								"arguments[0].scrollIntoView();",BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("included in an active translation job")));
						Thread.sleep(2000);
						
						if (IncludeUnchanged_Content==true) {
							
							if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("include content that has not been updated since the last translation job"), 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include content that has not been updated since the last translation job")).click();
							}	
						}
							if (IncludeUnchanged_Content==false){
								if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("include content that has not been updated since the last translation job"), 5)){
									BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("include content that has not been updated since the last translation job")).click();
								}					
							}
							
							if (IncludeDuplicate_Request==true) {
								
								if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("included in an active translation job"), 5)){
									BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("included in an active translation job")).click();
								}	
							}
								if (IncludeDuplicate_Request==false){
									if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("included in an active translation job"), 5)){
										BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("included in an active translation job")).click();
									}					
								}
								
								if (PostTranslationAction==true){
									Verify.action().verifyElementPresent(locators.exts().PostAction_dropdown, 5);
									BrowserFactory.SystemEngine().findElement(locators.exts().PostAction_dropdown).click();				
									Thread.sleep(3000);		
									Verify.action().verifyElementPresent(locators.exts().Select_PostTransAction(TrasnlationAction), 5);
									BrowserFactory.SystemEngine().findElement(locators.exts().Select_PostTransAction(TrasnlationAction)).click();
																	
								}		
								
*/
			if (IncludeExpired_Source==true) {
				
				if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that has been marked as expired in source branch to be selected in wizarrd, otherwise it will be automatically deselected."), 5)){
					BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that has been marked as expired in source branch to be selected in wizarrd, otherwise it will be automatically deselected.")).click();
					System.out.println("INSIDE CHECKED");
				}	
			}
				if (IncludeExpired_Source==false){
					if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that has been marked as expired in source branch to be selected in wizarrd, otherwise it will be automatically deselected."), 5)){
						BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that has been marked as expired in source branch to be selected in wizarrd, otherwise it will be automatically deselected.")).click();
						System.out.println("INSIDE UNCHECK");
					}					
					
				}
				
				//Referenced Depth
				if (IncludeExpired_Target==true) {
					if(Verify.action().verifyElementNotPresent(locators.exts().IncludeExpiredTarget_CheckBoxChecked, 5)){
						BrowserFactory.SystemEngine().findElement(locators.exts().IncludeExpiredTarget_Checkbox).click();
					}	
				}
					if (IncludeExpired_Target==false){
						if(Verify.action().verifyElementPresent(locators.exts().IncludeExpiredTarget_CheckBoxChecked, 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().IncludeExpiredTarget_Checkbox).click();
						}					
					}
					
					BrowserFactory.SystemEngine();
					((JavascriptExecutor)BrowserFactory.driver).executeScript(
							"arguments[0].scrollIntoView();",BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that has been marked as expired in target branch to be selected in wizard, otherwise it will be automatically deselected.")));
					Thread.sleep(2000);
					
					if (IncludeUnchanged_Content==true) {
						
						if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that has not been updated since the last translation job to be selected in wizard, otherwise it will be automatically deselected."), 5)){
							BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that has not been updated since the last translation job to be selected in wizard, otherwise it will be automatically deselected.")).click();
						}	
					}
						if (IncludeUnchanged_Content==false){
							if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that has not been updated since the last translation job to be selected in wizard, otherwise it will be automatically deselected."), 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that has not been updated since the last translation job to be selected in wizard, otherwise it will be automatically deselected.")).click();
							}					
						}
						
						if (IncludeDuplicate_Request==true) {
							
							if(Verify.action().verifyElementNotPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that is included in an active translation job to be selected in wizard, otherwise it will be automatically deselected."), 5)){
								BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that is included in an active translation job to be selected in wizard, otherwise it will be automatically deselected.")).click();
							}	
						}
							if (IncludeDuplicate_Request==false){
								if(Verify.action().verifyElementPresent(locators.exts().createJob_Configuration_checbox_checked("Select this box if you want content that is included in an active translation job to be selected in wizard, otherwise it will be automatically deselected."), 5)){
									BrowserFactory.SystemEngine().findElement(locators.exts().createJob_Configuration_checkbox("Select this box if you want content that is included in an active translation job to be selected in wizard, otherwise it will be automatically deselected.")).click();
								}					
							}
							
							if (PostTranslationAction==true){
								Verify.action().verifyElementPresent(locators.exts().PostAction_dropdown, 5);
								BrowserFactory.SystemEngine().findElement(locators.exts().PostAction_dropdown).click();				
								Thread.sleep(3000);		
								Verify.action().verifyElementPresent(locators.exts().Select_PostTransAction(TrasnlationAction), 5);
								BrowserFactory.SystemEngine().findElement(locators.exts().Select_PostTransAction(TrasnlationAction)).click();
																
							}		
							
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
//DashBorad--CMS-EDIT Tab
	public void Go_To_DashBorad_CmsEdit(String CMS_Select_tab)
	{
		
		
		try {
			//CMS
			Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
			Thread.sleep(1000);
			
			//Edit
			Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab(CMS_Select_tab), 5);//Edit
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab(CMS_Select_tab)).click();//Edit
			Thread.sleep(3000);
			
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

		
		
	}
	
	//After schedular run go to dashboard press dashboard Button
		public void Go_To_DashBorad_Button()
		{
			try {
				//Dashboard
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
				Thread.sleep(5000);

				// Click on Dashborad
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
				Thread.sleep(2000);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			

			
			
		}
		
	public void create_basic_submission_AutoPublish(String Page_Name,String SubName,boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media,
			boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,
			boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction) throws Exception {

		try {
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Page_Name)).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);

			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(IncludeChild_Items,IncludeReferenced_Content, Pages, Blocks, Media);
			
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(ReferencedDepth, ReferencedDepthValue, IncludeExpired_Source, IncludeExpired_Target, IncludeUnchanged_Content, IncludeDuplicate_Request, PostTranslationAction, TrasnlationAction);
			// select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
			Thread.sleep(10000);
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);

			System.out.println("Submission :" + SubName + " is created.....");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void create_basic_submission_MaxFiles(String SubName,boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media,
			boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,
			boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction) throws Exception {

		try {
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);

			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(IncludeChild_Items,IncludeReferenced_Content, Pages, Blocks, Media);
			
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(ReferencedDepth, ReferencedDepthValue, IncludeExpired_Source, IncludeExpired_Target, IncludeUnchanged_Content, IncludeDuplicate_Request, PostTranslationAction, TrasnlationAction);
			// select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void create_basic_submission_AutoPublish_TwoLang(String SubName) throws Exception {

		try {
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);

			// Configuration

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_configuration_tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);

			BrowserFactory.SystemEngine();
			((JavascriptExecutor) BrowserFactory.driver)
					.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);

			Verify.action().verifyElementPresent(locators.exts().Gl_Post_Translation_Action_Select, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Post_Translation_Action_Select).click();
			Thread.sleep(5000);

			Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Post_Translation_Action_select_AutoPublish, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Submit_for_translation_Post_Translation_Action_select_AutoPublish).click();
			Thread.sleep(5000);

			// select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			//De-de
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);
			
			//FR-fr
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Frfr).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
			Thread.sleep(10000);
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);

			System.out.println("Submission :" + SubName + " is created.....");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run_schedular() throws Exception {

		Thread.sleep(30000);
		// Run schedular
		Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin).click();
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin_admin, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin_admin).click();
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
		Thread.sleep(5000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Admin"), 25);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Admin")).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().Gl_Dashboardadmin_admin_Glschedular, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboardadmin_admin_Glschedular).click();
		Thread.sleep(3000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
		Thread.sleep(15000);

		Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();

		Verify.action().WaitUntilElementPresent(locators.exts().WarningMsg_Scheduler_JobCompleted, 90);
		
		
	}
	
	
	public void verify_RunSchedulerHistroy(int DocumentCount,int SubmissionCount) throws Exception {
			
			if(Verify.action().verifyElementPresent(locators.exts().WarningMsg_Schedular_JobStartedWithout_Problems, 10)){
				
				System.out.println("INSIDE The job has completed. Please refresh the page to see the status---------->");
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(8000);
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount), 5);
				
				String PrintValue_HistoryScheduler_RowOne = BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount)).getText();
				System.out.println("GL Scheduler Latest History Value From First Row---------->"+PrintValue_HistoryScheduler_RowOne);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				

			}
		}
		
	public void verify_RunSchedulerHistroy1() throws Exception {
		
		if(Verify.action().verifyElementPresent(locators.exts().WarningMsg_Schedular_JobStartedWithout_Problems, 10)){
			
			System.out.println("INSIDE The job has completed. Please refresh the page to see the status---------->");
			
			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
			Thread.sleep(8000);
			
		//	Verify.action().verifyElementPresent(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount), 5);
			
		//	String PrintValue_HistoryScheduler_RowOne = BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount)).getText();
		//	System.out.println("GL Scheduler Latest History Value From First Row---------->"+PrintValue_HistoryScheduler_RowOne);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);
			

		}
	}

public void verify_RunSchedulerHistroy_New() throws Exception {
		
		if(Verify.action().verifyElementPresent(locators.exts().WarningMsg_Schedular_JobStartedWithout_Problems, 10)){
			
			System.out.println("INSIDE The job has completed. Please refresh the page to see the status---------->");
			
			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
			Thread.sleep(15000);
			
			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
			Thread.sleep(15000);
			
			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
			Thread.sleep(15000);
		//	Verify.action().verifyElementPresent(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount), 5);
			
		//	String PrintValue_HistoryScheduler_RowOne = BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_HistoryMsg_FirstRow(DocumentCount,SubmissionCount)).getText();
		//	System.out.println("GL Scheduler Latest History Value From First Row---------->"+PrintValue_HistoryScheduler_RowOne);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(10000);
			

		}
	}
	public Boolean verify_submission(String SubName, String Status) throws Exception {

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.navigate().refresh();
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
		Thread.sleep(5000);

		// Click on global link config
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
		Thread.sleep(2000);

		Boolean flag = Verify.action()
				.verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 5);
		Thread.sleep(2000);

		if (flag == false) {
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(3000);
		}

		flag = Verify.action().verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 10);
		return flag;

	}
	public void create_basic_submission1(String PageName,String SubName) throws Exception {

		try {
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
			Thread.sleep(5000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);


			//sub name
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);;
			Thread.sleep(1000);
			
			//select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
			Thread.sleep(3000);

			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();;
			Thread.sleep(2000);
			
			//tools				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
			Thread.sleep(4000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);
			
			System.out.println("Submission :"+SubName+" is created.....");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void create_basic_submission_New(String SubName) throws Exception {

		try {
			
			
			Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
			Thread.sleep(3000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);


			//sub name
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);;
			Thread.sleep(1000);
			
			//select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
			Thread.sleep(3000);

			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();;
			Thread.sleep(2000);
			
			//tools				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
			Thread.sleep(4000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(15000);
			
			System.out.println("Submission :"+SubName+" is created.....");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Boolean verify_submission_Status(String SubName, String Status) throws Exception {

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.navigate().refresh();
		Thread.sleep(3000);

		// Click on global link config
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
		Thread.sleep(2000);

		Boolean flag = Verify.action().verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 5);
		Thread.sleep(2000);

		if (flag == false) {
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(3000);
		}

		flag = Verify.action()
				.verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 10);
		return flag;

	}
	
	
		
	
	/*
	public Boolean verify_TextName(String PageName, String Status) throws Exception {

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.navigate().refresh();
		Thread.sleep(3000);

		// Click on global link config
		//click on search
		BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
		Thread.sleep(5000);

		Boolean flag = Verify.action().verifyElementPresent(locators.exts().Edit_Gl_Status_published, 5);
		Thread.sleep(2000);

		if (flag == false) {
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.navigate().refresh();
			Thread.sleep(3000);
		}

		flag = Verify.action().verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(PageName, Status), 10);
		return flag;

	}
	*/
	
	
	public void select_content_type(boolean clearall, boolean addcontent, String contentname) throws Exception {

		try {

			if (clearall) {
				// clear all non translatable content
				Thread.sleep(3000);
				Verify.action().verifyElementPresent(locators.exts().content_select_leftAll_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().content_select_leftAll_button).click();
				Thread.sleep(2000);

			}

			if (addcontent) {
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_select_content(contentname),
						5);
				BrowserFactory.SystemEngine()
						.findElement(locators.exts().GlobalLink_WizardTab_select_content(contentname)).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().content_select_right_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().content_select_right_button).click();
				Thread.sleep(2000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Gl_Trasnlations_DeleteJob(int job_no) throws Exception {
		Thread.sleep(2000);

		for (int i = 1; i <= job_no; i++) {
			String JobName = BrowserFactory.SystemEngine()
					.findElement(locators.exts().Gl_Globalink_Translation_JobName("")).getText();
			String JobName_trim = JobName.trim();
			System.out.println("Deleting Job Name ---------->" + JobName_trim);

			if (Verify.action().verifyElementPresent(locators.exts().Gl_Globalink_Translation_JobName(JobName_trim),
					5)) {

				BrowserFactory.SystemEngine()
						.findElement(locators.exts().Gl_Globalink_Translation_JobName(JobName_trim)).click();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine()
						.findElement(locators.exts().Gl_Globalink_Translation_JobName_WithoptionsDropdown(JobName_trim))
						.click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(
						locators.exts().Gl_Globalink_Translation_JobName_SelectOptions("Move to Trash"), 5);
				BrowserFactory.SystemEngine()
						.findElement(locators.exts().Gl_Globalink_Translation_JobName_SelectOptions("Move to Trash"))
						.click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(
						locators.exts().Gl_Globalink_Translation_ReverifyJobName(JobName_trim), 5);
				/*
				 * Verify.action().verifyElementPresent(locators.exts().
				 * GL_Global_JobDelete_MoveToTrashButton,5);
				 * BrowserFactory.SystemEngine().findElement(locators.exts().
				 * GL_Global_JobDelete_MoveToTrashButton).click(); Thread.sleep(6000);
				 */
			}
		}

	}
	public void Gl_Trasnlations_GetJob(int job_no,String Action) throws Exception {
		Thread.sleep(2000);

		for (int i = 1; i <= job_no; i++) {
			String JobName = BrowserFactory.SystemEngine()
					.findElement(locators.exts().Gl_Globalink_Translation_JobName("")).getText();
			String JobName_trim = JobName.trim();
			System.out.println("Deleting Job Name ---------->" + JobName_trim);

			if (Verify.action().verifyElementPresent(locators.exts().Gl_Globalink_Translation_JobName(JobName_trim),5)) {

				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Globalink_Translation_JobName(JobName_trim)).click();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine()
						.findElement(locators.exts().Gl_Globalink_Translation_JobName_WithoptionsDropdown(JobName_trim)).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(
						locators.exts().Gl_Globalink_Translation_JobName_SelectOptions(Action), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Globalink_Translation_JobName_SelectOptions(Action)).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().Gl_Globalink_Translation_ReverifyJobName(JobName_trim), 5);
				
			}
		}

	}
	/**
	 * @author Proteek. create_NewPage
	 * @param SelectPage
	 * @param PageType
	 * @param PageName
	 * @param select_suggestpagetype
	 * @throws Exception
	 */
	public void create_NewPage(String PageType, String PageName, String select_suggestpagetype)
			throws Exception {

		//BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(SelectPage)).click();
		//Thread.sleep(3000);
		
		Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().page_AddButton, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().add_pagetype(PageType), 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype(PageType)).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_name_input, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_name_input).click();
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_name_input).sendKeys(Keys.CONTROL,
				Keys.chord("A"), Keys.BACK_SPACE);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_name_input).sendKeys(PageName);
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype(select_suggestpagetype), 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype(select_suggestpagetype))
				.click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
		Thread.sleep(3000);
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
		Thread.sleep(3000);

	}
	
	public void create_NewPageSubmitJob(String PageType,String Stdpg, String PageName, String title,String Keyword,String Desc,String PostAction)//"New Page","Standard Page",PageName,"Alloy - collaboration,","Alloy Plan, Alloy Meet, Alloy Track, distance collaboration,","Alloy solves the two most pressing problems in long distance collaboration"
			throws Exception {
	// go to CMS edit mode
			//common.action().go_to_CMS_from_Globallink("Edit");
			//Thread.sleep(3000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().add_pagetype(PageType),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype(PageType)).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype(Stdpg),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype(Stdpg)).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_name,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).click();
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(Keys.CONTROL,Keys.chord("A"),Keys.BACK_SPACE);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(PageName);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_AllProperties,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_AllProperties).click();
			Thread.sleep(2000);
							
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys(title);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys(Keyword);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys(Desc);
			Thread.sleep(2000);
			
			//content
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
			Thread.sleep(2000);
			
			 JavascriptExecutor js1 = (JavascriptExecutor) BrowserFactory.driver; 
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
			Thread.sleep(2000);
			    
			//teaser text
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
			Thread.sleep(2000);
					
			
			//teaser Body
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
			Thread.sleep(7000);
					
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.DELETE);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys("This is content teaser Main Body");
			
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);
				
				
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			//
			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(true,false, false, false, false);
						
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, PostAction);
			
			//select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
			Thread.sleep(3000);

			//source Lang
			BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_SourcelangSelect).click();
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_Sourcelang).click();
			Thread.sleep(2000);
			
			//Target lang
			Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
			Thread.sleep(3000);
			
			//tools				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
			Thread.sleep(4000);
			
	}
	
	public void create_NewPage_SA_SubmitJob(String PageType,String Stdpg, String PageName,String SATEST, String title,String Keyword,String Desc,String PostAction)//"New Page","Standard Page",PageName,"Alloy - collaboration,","Alloy Plan, Alloy Meet, Alloy Track, distance collaboration,","Alloy solves the two most pressing problems in long distance collaboration"
			throws Exception {
	// go to CMS edit mode
			//common.action().go_to_CMS_from_Globallink("Edit");
			//Thread.sleep(3000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().add_pagetype(PageType),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype(PageType)).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype(Stdpg),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype(Stdpg)).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_name,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).click();
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(Keys.CONTROL,Keys.chord("A"),Keys.BACK_SPACE);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(PageName);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_AllProperties,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_AllProperties).click();
			Thread.sleep(2000);
			
			//SA			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_SA_Change,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_Change).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText).clear();
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText).sendKeys(SATEST);
			Thread.sleep(2000);
			
			//
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys(title);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys(Keyword);
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys(Desc);
			Thread.sleep(2000);
			
			//content
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
			Thread.sleep(2000);
			
			 JavascriptExecutor js1 = (JavascriptExecutor) BrowserFactory.driver; 
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
			Thread.sleep(2000);
			    
			//teaser text
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
			Thread.sleep(2000);
					
			
			//teaser Body
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
			Thread.sleep(7000);
					
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.DELETE);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys("This is content teaser Main Body");
			
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);
				
				
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			//
			// Configuration			
			common.action().Config_ReferencedContentTypesChecks(true,false, false, false, false);
						
			common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, PostAction);
			
			//select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
			Thread.sleep(3000);

			//source Lang
			BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_SourcelangSelect).click();
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_Sourcelang).click();
			Thread.sleep(2000);
			
			//Target lang
			Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
			Thread.sleep(3000);
			
			//tools				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
			Thread.sleep(7000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
			Thread.sleep(4000);
			
	}
	
	public void ModifingFields_NewPage(String SATEST,String title,String Keyword,String Desc,String PostAction) throws Throwable
	{
		
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_SEO,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_SEO).click();
		Thread.sleep(2000);
		
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys(title);
		Thread.sleep(2000);
		
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys(Keyword);
		Thread.sleep(2000);
		
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys(Desc);
		Thread.sleep(2000);
		
		//SA			
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_SA_Change,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_Change).click();
		Thread.sleep(2000);
		
			      
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText,5);
		//BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_SA_ChangeText).sendKeys(SATEST);
		Thread.sleep(2000);
	
		
		//content
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
		Thread.sleep(2000);
		
		 JavascriptExecutor js1 = (JavascriptExecutor) BrowserFactory.driver; 
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
		Thread.sleep(2000);
		    
		//teaser text
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text-Modified.");
		Thread.sleep(2000);
				
		
		//teaser Body
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
		Thread.sleep(7000);
				
		Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.DELETE);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys("This is content teaser Main Body-Modified.");
		
		Thread.sleep(2000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);
			
			
		
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
		Thread.sleep(3000);
		
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
		Thread.sleep(4000);

		//
		// Configuration			
		common.action().Config_ReferencedContentTypesChecks(true,false, false, false, false);
					
		common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, PostAction);
		
		//select language
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
		Thread.sleep(3000);

		//source Lang
		BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_SourcelangSelect).click();
		Thread.sleep(2000);
		
		BrowserFactory.SystemEngine().findElement(locators.exts().Langtab_Sourcelang).click();
		Thread.sleep(2000);
		
		//Target lang
		Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
		Thread.sleep(3000);
		
		//tools				
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
		Thread.sleep(2000);

		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
		Thread.sleep(7000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
		Thread.sleep(3000);

		
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
		Thread.sleep(3000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
		Thread.sleep(4000);
		
	}
	public void create_NewPageSelect(String Edit,String PageName)
			throws Exception {
	//edit
	Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
	BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
	Thread.sleep(1000);				
	
	Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab(Edit),  5);
	BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab(Edit)).click();
	Thread.sleep(3000);				
	
	BrowserFactory.SystemEngine();
	BrowserFactory.driver.navigate().refresh();
	Thread.sleep(8000);
	
	
	Verify.action().verifyElementPresent(locators.exts().Select_page(PageName),  5);
	BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
	Thread.sleep(2000);
	
	BrowserFactory.SystemEngine();
	Actions actions = new Actions(BrowserFactory.driver);
	WebElement elementLocator = BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName));
	actions.doubleClick(elementLocator).perform();
	Thread.sleep(2000);
	
	BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
	Thread.sleep(2000);
	
	}
	public void Go_to_GlobalLink_Admin_Configtabs(String cmsTab_name, String adminTab_name) throws Exception {

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
		Thread.sleep(2000);
		
	}

	public void Go_to_GlobalLink_Admin(String cmsTab_name, String adminTab_name, String glTab_name) throws Exception {

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
		Thread.sleep(5000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab(glTab_name), 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab(glTab_name))
				.click();
		
		Thread.sleep(3000);

	}

	public void Go_to_GlobalLink_Admin_GLSchedular(String cmsTab_name, String adminTab_name) throws Exception {

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().Gl_Dashboardadmin_admin_Glschedular, 10);
		BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboardadmin_admin_Glschedular).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

	}
	//GO TO Conteny_Type
	public void Go_to_GlobalLink_Admin_Content(String cmsTab_name, String adminTab_name, String contentType_name) throws Exception {

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);//Admin
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);//Content Type
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
		Thread.sleep(2000);
		Verify.action().verifyElementPresent(locators.exts().CMS_Admincontenttype_stdpage(contentType_name),  25);//[Default] Standard Page
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admincontenttype_stdpage(contentType_name)).click();
		Thread.sleep(4000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		
	
	}

	
	public void SetAccessRights_Administration_SelectCheckbox(boolean Read, boolean Create, boolean Change,
			boolean Delete, boolean Publish, boolean Administer) throws Exception {
		// Switch to Default
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Move to SAR iframe fot checkbox
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().SAR_select_Globalink_translation, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().SAR_select_Globalink_translation).click();
		Thread.sleep(3000);

		if (Read) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_read_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_read_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Create) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_create_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_create_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Change) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_change_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_change_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Delete) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_delete_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_delete_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Publish) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_publish_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_publish_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Administer) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine()
					.findElement(locators.exts().SAR_administrator_administer_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_administer_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

	}

	public void SetAccessRights_Administration_DeSelectCheckbox(boolean Read, boolean Create, boolean Change,
			boolean Delete, boolean Publish, boolean Administer) throws Exception {
		// Switch to Default
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Move to SAR iframe fot checkbox
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().SAR_select_Globalink_translation, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().SAR_select_Globalink_translation).click();
		Thread.sleep(3000);

		if (Read) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_read_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_read_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Create) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_create_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_create_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Change) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_change_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_change_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Delete) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_delete_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_delete_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Publish) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_publish_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_publish_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Administer) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_administer_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_administrator_administer_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

	}

	public void SetAccessRights_Everyone_Administration_SelectCheckbox(boolean Read, boolean Create, boolean Change,
			boolean Delete, boolean Publish, boolean Administer) throws Exception {
		// Switch to Default
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Move to SAR iframe fot checkbox
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().SAR_select_Globalink_translation, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().SAR_select_Globalink_translation).click();
		Thread.sleep(3000);

		if (Read) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_read_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_read_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Create) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_create_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_create_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Change) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_change_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_change_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Delete) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_delete_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_delete_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Publish) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_publish_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_publish_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Administer) {
			Thread.sleep(1000);
			if (!BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_administer_setting_checkbox).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_administer_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

	}

	public void SetAccessRights_Everyone_Administration_DeSelectCheckbox(boolean Read, boolean Create, boolean Change,
			boolean Delete, boolean Publish, boolean Administer) throws Exception {
		// Switch to Default
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Move to SAR iframe fot checkbox
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().SAR_select_Globalink_translation, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().SAR_select_Globalink_translation).click();
		Thread.sleep(3000);

		if (Read) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_read_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_read_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Create) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_create_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_create_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Change) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_change_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_change_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Delete) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_delete_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_delete_setting_checkbox).click();
			}
			Thread.sleep(1000);
		}

		if (Publish) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_publish_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_publish_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

		if (Administer) {
			Thread.sleep(1000);
			if (BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_administer_setting_checkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().SAR_everyone_administer_setting_checkbox)
						.click();
			}
			Thread.sleep(1000);
		}

	}

	public void Go_to_GlobalLink_Admin_AdminConfig(String cmsTab_name, String adminTab_name, String optionname)
			throws Exception {

		Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
		Thread.sleep(7000);

		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo()
				.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);
		BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
		Thread.sleep(2000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Admin_TabOptions(optionname), 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Admin_TabOptions(optionname)).click();
		
		Thread.sleep(3000);

	}
	
	public void Inside_FieldConfigTab(boolean MetaTitle,boolean MetaKeywords,boolean TeaserText,boolean MetaDescription,boolean MainBody) throws InterruptedException
	{
		try {
			
		
		if (MetaTitle==true)
			
		{
		if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaTitle).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaTitle).click();
		}
		Thread.sleep(2000);
		}
		if (MetaTitle==false)
			
		{
		if (BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaTitle).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaTitle).click();
		}
		
		}
		//

		if (MetaKeywords==true)
			
		{
		if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaKeywords).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaKeywords).click();
		}
		Thread.sleep(2000);
		}
		if (MetaKeywords==false)
			
		{
		if (BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaKeywords).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaKeywords).click();
		}
		
		}
		//
		if (TeaserText==true)
			
		{
		if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_TeaserText).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_TeaserText).click();
		}
		Thread.sleep(2000);
		}
		if (TeaserText==false)
			
		{
		if (BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_TeaserText).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_TeaserText).click();
		}
		
		}
		//
		if (MetaDescription==true)
			
		{
		if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaDescription).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaDescription).click();
		}
		Thread.sleep(2000);
		}
		if (MetaDescription==false)
			
		{
		if (BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaDescription).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MetaDescription).click();
		}
		
		}
		
		//
		if (MainBody==true)
			
		{
		if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MainBody).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MainBody).click();
		}
		Thread.sleep(2000);
		}
		if (MainBody==false)
			
		{
		if (BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MainBody).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Field_ConfigTab_MainBody).click();
		}
		
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Inside Notification tab
	public void Inside_NotificationTab_Functionality(String SMTP_Host,String SMTP_Port,String Login,String Password,String Recipients)
	{
		try {
		//SMTP_Host
		Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Host,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).sendKeys(SMTP_Host);
		Thread.sleep(1000);

		//SMTP Port
		
		Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Port,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).sendKeys(SMTP_Port);
		Thread.sleep(1000);

		//Login
		Verify.action().verifyElementPresent(locators.exts().Notification_Login,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).sendKeys(Login);
		Thread.sleep(1000);

		//Password
		Verify.action().verifyElementPresent(locators.exts().Notification_Password,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).sendKeys(Password);
		Thread.sleep(1000);

		//Use SSL
		//Verify.action().verifyElementPresent(locators.exts().Notification_Use_SSL_checkbox,  5);
		//BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
		//Thread.sleep(1000);
		if (!BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
		}
		Thread.sleep(2000);
		

		//Recipients
		Verify.action().verifyElementPresent(locators.exts().Notification_Recipients,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).sendKeys(Recipients);
		Thread.sleep(1000);

		//Send mail for errors
		//Verify.action().verifyElementPresent(locators.exts().Notification_Sendmailforerrors_checkbox,  5);
		//BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).click();
		//Thread.sleep(1000);
		if (!BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).click();
		}
		Thread.sleep(2000);

		//Send mail for scheduler job results
		//Verify.action().verifyElementPresent(locators.exts().Notification_Send_mail_for_scheduler_job_results,  5);
		//BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).click();
		//Thread.sleep(1000);
		if (!BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).click();
		}
		Thread.sleep(2000);
	
		//Notification_Save_Notification_button
		Verify.action().verifyElementPresent(locators.exts().Notification_Save_Notification_button,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Save_Notification_button).click();
		Thread.sleep(8000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Inside Export/Import tab
		public void Inside_ExportImportTab_Functionality(String Property_Exclude,String Copy_Properties,String Name_Url,String translatable_fields,String Source_Content,String Importing,String Xhtml_Fail,String Simpleadd)
		{
			try {
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes).sendKeys(Property_Exclude);//GlobalLink
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Copy_properties_from_SelectOptions(Copy_Properties)).click();//Source
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Copy_Name_in_URLselectOption(Name_Url)).click();//From source
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_translatable_fields_selectOption(translatable_fields)).click();//Create copy from source
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_source_content_selectOption(Source_Content)).click();//Cancel it
				Thread.sleep(3000);
				
			
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Default_status_selectOption(Importing)).click();//Primary Draft
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_xhtml_import_fails_selectOption(Xhtml_Fail)).click();//Skip
				Thread.sleep(3000);
				
				//
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_SimpleAddress_selectOption(Simpleadd)).click();//Skip
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Save_Import_Export_Settings).click();
				Thread.sleep(2000);
				
								
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Inside GL_Setting tab
		public void Inside_GL_Setting_Tab_Functionality(String GlobalLink_url,String Username,String Pass,String Submission_Name_Prefix,String Classifier,String Max_number_of_files_per_submission,String Translation_retrieval_batch_size,String UID)
		{
			try {
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys(GlobalLink_url);
		Thread.sleep(1000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys(Username);
		Thread.sleep(1000);
	
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys(Pass);
		Thread.sleep(1000);
	
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_SubmissionNamePrefix,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).sendKeys(Submission_Name_Prefix);
		Thread.sleep(1000);
		
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Classifier,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).sendKeys(Classifier);
		Thread.sleep(1000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Maxnumber_of_filespersubmission,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).sendKeys(Max_number_of_files_per_submission);
		Thread.sleep(1000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Translation_retrieval_batch_size,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).sendKeys(Translation_retrieval_batch_size);
		Thread.sleep(1000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).clear();
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).sendKeys(UID);
		Thread.sleep(1000);

		if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox_checked,  5)){
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox).click();
		Thread.sleep(2000);
		} 
		//Test settings
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
		Thread.sleep(5000);
		
		
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
		
		//Inside PD
		public void Inside_PD(String Submission_ID)
		{
			try
			{
			Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_select, 5);
			BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_select).click();
			Thread.sleep(1000);
			
			Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_SubId, 5);
			BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_SubId).sendKeys(Submission_ID);
			Thread.sleep(1000);
			
			Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_search, 5);
			BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_search).click();;
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		
		//Inside Manage Website Language
		public void Inside_Other_Setting_Tab(String username,String SubmitJob,String Completed_Targets,String Log_Level)
		{
			try
			{
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_Scheduler_User,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Scheduler_User).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Scheduler_User).sendKeys(username);//GlobalLinkuser
				Thread.sleep(3000);
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect(SubmitJob),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect(SubmitJob)).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Retrived_Completed_selectOption(Completed_Targets)).click();//Documents
				Thread.sleep(3000);
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Setting_Submission).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Setting_Submission).click();
				}
				Thread.sleep(3000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Allow_Cancellations).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Allow_Cancellations).click();
				}
				Thread.sleep(3000);
			
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting__Log_Lavel_selectOption(Log_Level)).click();//DEBUG
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Archives_Submissions).click();
				Thread.sleep(3000);
				
									
				String s=common.GetCurrentDateFormat("MM/dd/yyyy");
				
				System.out.println("Todays Date "+ s);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Archives_Submissions_date_input).sendKeys(s);
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//Inside Manage Website Language
			public void Inside_Manage_Website_Language(String cmsTab_name,String adminTab_name)
			{
				try
				{
					Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab(cmsTab_name), 15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab(cmsTab_name)).click();
					Thread.sleep(7000);

					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo()
							.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
					Thread.sleep(3000);

					Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab(adminTab_name), 25);
					BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab(adminTab_name)).click();
					Thread.sleep(2000);
					
					  //manage Website lang
					Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_ManageWebsite_Lang,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_ManageWebsite_Lang).click();
					Thread.sleep(2000);
					
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo().defaultContent();
					Thread.sleep(2000);
					
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().ManageWebsitelang_iframe));
					Thread.sleep(3000);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			public void Inside_Wizard_Setting_Tab(String Def_project,String Source_Locale,boolean Include_child_nodes, boolean referenced_content_Block,Boolean referenced_content_Pages,boolean referenced_content_Media,String depth,boolean Include_Unchanged_Content,boolean Include_expired_source_content,boolean Include_expired_target_content,String Translation_Action,boolean Include_Duplicate_Request,boolean CMS_content ) throws Exception
			{
				try
				{
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_project_SelectOptions(Def_project)).click();
				Thread.sleep(3000);
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Default_Source_Locale_SelectOptions_text,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_Source_Locale_SelectOptions(Source_Locale)).click();
				Thread.sleep(2000);
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys("+5d");
				Thread.sleep(2000);
				
				//GlobalLink_WizardSetting_Include_child_nodes
				
				if (Include_child_nodes==true)
					
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).click();
				}
				Thread.sleep(2000);
				}
				if (Include_child_nodes==false)
					
				{
				if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).click();
				}
			
				}
				
				
				
					if (referenced_content_Block==true)
				
					{
					if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).isSelected() )
					{
						BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).click();
					}
					Thread.sleep(2000);
					}
					if (referenced_content_Block==false)
						
					{
					if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).isSelected() )
					{
						BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).click();
					}
				
					}
				//
					//
					if (referenced_content_Pages==true)
						
					{
						if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).isSelected() )
						{
							BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).click();
						}
						Thread.sleep(2000);
					
					}
					if (referenced_content_Pages==false)
						
					{
						if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).isSelected() )
						{
							BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).click();
						}
						Thread.sleep(2000);
					
					}
				
					if (referenced_content_Media==true)
						
					{
				
						if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).isSelected() )
						{
							BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).click();
						}
						Thread.sleep(2000);
				
					}
					if (referenced_content_Media==false)
						
					{
				
						if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).isSelected() )
						{
							BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).click();
						}
						Thread.sleep(2000);
				
					}
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Reference_depth).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Reference_depth).sendKeys(depth);
				Thread.sleep(2000);
				
				if (Include_Unchanged_Content==true)
					
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Unchanged_Content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Unchanged_Content).click();
				}
				Thread.sleep(2000);
				}
				
				if (Include_expired_source_content==true)
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).click();
				}
				Thread.sleep(2000);
				}

				if (Include_expired_source_content==false)
				{
				if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).click();
				}
				Thread.sleep(2000);
				}
				
				
				if (Include_expired_target_content==true)
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).click();
				}
				Thread.sleep(2000);
				
				}
				if (Include_expired_target_content==false)
				{
				if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).click();
				}
				Thread.sleep(2000);
				
				}
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Post_Translation_Action_selectOption(Translation_Action)).click();
				Thread.sleep(3000);
				
				if (Include_Duplicate_Request==true)
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Duplicate_Request).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Duplicate_Request).click();
				}
				Thread.sleep(2000);
				}
				
				if (CMS_content==true)
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Exclude_showing_CMS_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Exclude_showing_CMS_content).click();
				}
				Thread.sleep(2000);
				}
				//
				
				
				
				//select
				
				String[] listItems1= {"[Specialized] ContainerPage"};
				General.selectMulti(listItems1,locators.exts().GlobalLink_WizardSetting_Existing_Content_Type);
				Thread.sleep(3000);

				//click save button
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(2000);
				
				  Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
						
				
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			
         public void Inside_AutoSubmission_Tab(Boolean Submission_Creation,String SourceLang,String TargetLang,String Prefix,String PostTranslation) throws Exception{
				
				if (Submission_Creation==true)
					
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				Thread.sleep(2000);
				}
				if (Submission_Creation==false)
					
				{
				if (BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
			
				}
				
			
			
			//AutoSubmission_GLprojClick
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_GLprojClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_GLprojClick).click();
			Thread.sleep(2000);
			
			//AutoSubmission_GLprojClick
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_GLprojClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_GLprojClick).click();
			Thread.sleep(2000);
			
			
			//Source Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_SourceLangClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_SourceLangClick).click();
			Thread.sleep(2000);
			
			//Source  Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_SourceLang(SourceLang), 25);//English (en)
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_SourceLang(SourceLang)).click();
			Thread.sleep(2000);
			
			//Target Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_TargetLangClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_TargetLangClick).click();
			Thread.sleep(2000);
			
			//Target Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_TargetLang(TargetLang), 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_TargetLang(TargetLang)).click();
			Thread.sleep(2000);
			
			//date
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_DueDate, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).clear();
	          while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).getAttribute("value").equals(""))
	                     {
	        	  BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).sendKeys(Keys.BACK_SPACE);
	                     }
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).sendKeys("+5d");
			Thread.sleep(2000);
			
			//Prefix
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Prefix, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).clear();				
			while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).getAttribute("value").equals(""))
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Keys.BACK_SPACE);
			}
		
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Prefix);//Auto_
			Thread.sleep(2000);
			
			
			//ReferenceDepth
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_ReferenceDepth, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).clear();
			
			while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).getAttribute("value").equals(""))
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys(Keys.BACK_SPACE);
			}
		
			
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys("1");
			Thread.sleep(2000);
			
			//AutoSubmission_PostTranslationAction
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationAction, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationAction).click();
			Thread.sleep(2000);
			
			//AutoSubmission_PostTranslationAction
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationActionSelect(PostTranslation), 25);//Create EPiServer Project For Approval
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationActionSelect(PostTranslation)).click();
			Thread.sleep(2000);
			
			//AutoSubmission_Save
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
			Thread.sleep(5000);
			}
         
         public void GO_TO_EDIT_AutoSubmission(String TabName,String Page) throws Exception
         {
        	// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink(TabName);
				Thread.sleep(3000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Page)).click();
				Thread.sleep(5000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementNotPresent(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem).click();
				Thread.sleep(3000);
				
				//OK
				Verify.action().verifyElementNotPresent(locators.exts().CMS_MAinbody_OK,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MAinbody_OK).click();
				Thread.sleep(3000);
         }
         
         public void Go_to_GlobalLink_GCCServer(String PSSurl, String PssUser, String PSSPssPassword,String PSStxtPssConnector) throws Exception {

        	//Inside Tab
				Verify.action().verifyElementPresent(locators.exts().Gccserver_PSSurl, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSurl).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSurl).sendKeys(PSSurl);
				Thread.sleep(2000);
				
			/*	Verify.action().verifyElementPresent(locators.exts().Gccserver_PssUser, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PssUser).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PssUser).sendKeys(PssUser);
				Thread.sleep(2000);*/
				
				Verify.action().verifyElementPresent(locators.exts().Gccserver_PSSPssPassword, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSPssPassword).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSPssPassword).sendKeys(PSSPssPassword);
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Gccserver_PSStxtPssConnector, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSStxtPssConnector).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSStxtPssConnector).sendKeys(PSStxtPssConnector);
				Thread.sleep(2000);
				
				if(!(BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSCleanup).isSelected()))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSCleanup).click();
					Thread.sleep(1000);
				}
				
				if(!(BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSGccLogging).isSelected()))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSGccLogging).click();
					Thread.sleep(1000);
				}
				
				if(!(BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSPreviewReview).isSelected()))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_PSSPreviewReview).click();
					Thread.sleep(1000);
				}
				
				
				Verify.action().verifyElementPresent(locators.exts().Gccserver_Save, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gccserver_Save).click();
				Thread.sleep(2000);

     	}
         public void Submission_Submit_forTranslation(String Pagename,String Subname,boolean IncludeChild_Items,boolean IncludeReferenced_Content,boolean Pages,boolean Blocks,boolean Media,boolean ReferencedDepth,String ReferencedDepthValue,boolean IncludeExpired_Source,boolean IncludeExpired_Target,boolean IncludeUnchanged_Content,boolean IncludeDuplicate_Request,boolean PostTranslationAction,String TrasnlationAction)throws Exception
         {
        	// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(3000);
				//CMS_Edit_Start
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Pagename)).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);

				// sub name
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(Subname);
				Thread.sleep(1000);
								
				
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(IncludeChild_Items,IncludeReferenced_Content, Pages, Blocks, Media);//false,true, true, true, false
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(ReferencedDepth, ReferencedDepthValue, IncludeExpired_Source, IncludeExpired_Target, IncludeUnchanged_Content, IncludeDuplicate_Request, PostTranslationAction, TrasnlationAction);//true, "2", false, false, true, true, true, "None"
				
				assertion=Verify.action().verifyElementPresent(locators.exts().RefDepth_Input, 5);
				
				//select language
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(3000);

				// tools
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation1).click();
				Thread.sleep(7000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
         }
         //Add_GLtranslationJob_Gadget
         public void Add_GLtranslationJob_Gadget() throws Exception
         {
        	
       //add gadget
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_add_gadgets,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_add_gadgets).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget).click();
			Thread.sleep(5000);
         }
         //Move to Trash
         public void GL_GlobalJob_MovetoTrash() throws Exception
         {
         BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_JobDelete_MoveToTrashButton).click();
			Thread.sleep(4000);
			
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_settings, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_settings).click();
			Thread.sleep(4000);
			
		
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_settings_trash, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_settings_trash).click();
			Thread.sleep(4000);
         }
         
         //inside Wizard setting tab
         public void Inside_WizardSettingTab(String Tabname,String Projname,String Date) throws Exception
         {
            Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab(Tabname), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab(Tabname)).click();
			Thread.sleep(1000);
			
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Default_project_SelectOptions(Projname),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_project_SelectOptions(Projname)).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys(Keys.CONTROL + "a");
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys(Keys.DELETE);
			Thread.sleep(5000);
			
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys(Date);
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
			Thread.sleep(6000);
			//Verify changes are saved
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
			Thread.sleep(3000);
}
         //Select Page to Content Tab
         public void Selectpage_ContentTab(String Pagename,String SubName) throws Exception
         {
            BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(Pagename)).click();
			Thread.sleep(5000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// sub name
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
			
			//Content TAb
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_content_tab).click();
			Thread.sleep(3000);
}
         //Language Tab to Submit for Translation
         public void LangTab_SubmitforTranslation() throws Exception
         {
            BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
         }
         
       //Language Tab to Submit for Translation
         public void Inside_FieldConfigTab(String keyList,String value) throws Exception
         {
            BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_Field_configuration_tab_list).sendKeys(keyList);//"Stan"
			Thread.sleep(3000);
			

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_Field_configuration_tab_list_option(value)).click();
			Thread.sleep(10000);
         }
			
}
