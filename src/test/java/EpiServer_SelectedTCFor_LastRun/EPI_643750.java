
package EpiServer_SelectedTCFor_LastRun;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.PD4_main_Locators;
import locators.locators;

/**********************************************************************************************************************************************
* Author        : Amrata M.
* 
** Test case    : Verify validations for 'Due date' on Language tab
*
* Summary   	: Verify display of due date from saved configuration
				  use calendar date picker to select user defined due date
* Precondition  : Go to GlobalLink Config>> Wizard Setting>> Due date
					set due date as +5d or any other date				  
***********************************************************************************************************************************************/
public class EPI_643750 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_643750";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_643750");
		dataSet.put("TL_test_case_description","EPI_643750: Verify validations for 'Due date' on Language tab");
		dataSet.put("TL_internal_testCase_ID", "643750");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				//
				common.action().Inside_WizardSettingTab("Wizard settings","EPiServer","+5d");
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
				Thread.sleep(5000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);
				
				//Enter Submission Name
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_submission_name_input,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
				Thread.sleep(1000);
				
			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				//Displaying current date in the desired format
				System.out.println("Current Date: "+sdf.format(cal.getTime()));
				   
				//Number of Days to add
			    cal.add(Calendar.DAY_OF_MONTH, 5);  
				//Date after adding the days to the current date
				String newDate = sdf.format(cal.getTime());  
				//Displaying the new Date after addition of Days to current date
				System.out.println("Date after Addition: "+newDate);
	 
				//lang tab
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
				Thread.sleep(3000);	
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(2000);
				
				
				String ValuePrintDate = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_DatePrint).getAttribute("value");
				System.out.println("PRINT VALUE OF DATE--------->"+ValuePrintDate);
				Thread.sleep(2000);		
				
				
				assertion=ValuePrintDate.contains(newDate);
				if(assertion == false){
					report("f"," assertion is failed while verifying The Due Date.");
				}
				
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
				

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(50000);

				System.out.println("Submission :" + SubName + " is created.....");

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(50000);
						
				
				//run schedular
				common.action().run_schedular();
			    common.action().verify_RunSchedulerHistroy1();
			
				
				//After schedular run go to dashboard press dashboard Button
				common.action().Go_To_DashBorad_Button();
				
				
				//GlobalLink_Dashboard_Submission_ID
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_Sub_ID = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
				System.out.println("Globalink Submission ID is========>>" + globalink_Sub_ID);


				//open pd url
				common.action().Open_New_Instance_URL(EPiServer_Common_Properties_Cred.GlobalLink_url);
				
				
				//pd login
				common.action().PDlogIn(EPiServer_Common_Properties_Cred.Username, EPiServer_Common_Properties_Cred.Pass);
			
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_select, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_select).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_SubId, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_SubId).sendKeys(globalink_Sub_ID);
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_search, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_search).click();;
				Thread.sleep(1000);
				
				//Due_date
				assertion = Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Due_date, 10);
				String Due_date = BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Due_date).getText();
				System.out.println("PD  Due date is========>>" + Due_date);
				if (assertion == false) {
					report("f", " assertion is failed while verifying  Due date");
				}
				
				Thread.sleep(2000);
				
				//logout
			common.action().PDlogOut();
				
				}catch(Throwable e){
				report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				}
			}

		@Test
		public void execute() throws Exception{
			
			testcase(dataSet);
			assertion();
		}
			
		@AfterMethod
		public void tearDown() throws Exception{
		try {
		//	BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void assertion() throws Exception{
			try{
				
		    	if(assertion == false){
					report("f"," assertion is failed while verifying The Due Date ");
							
		    	}
				else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}	
					}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
			}
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
			
			
}
