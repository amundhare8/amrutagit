package EPiServer_Projects;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************************************
 * Author : Amrata M.
 *
 * Test case : Verify EPiServer Projects created post translation
 * 
 * Summary : This test case verifies EPiServer Projects created post translation
 *
 * 
 *******************************************************************************************************************************************************************/

public class EPI_643751 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_643751";
	String ProjectName = "EPiServer";
	String Cmsproject = "";
	String notificationproj = "";

	@BeforeMethod
	public void setUp() throws Exception {
		BrowserFactory.SystemEngine().startApplication("EPI_643751");
		dataSet.put("TL_test_case_description", "EPI_643751: Verify EPiServer Projects created post translation");
		dataSet.put("TL_internal_testCase_ID", "643751");

	}

	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception {
		try {
			//login
			General.action().login();
			Thread.sleep(2000);

			// go to CMS edit mode

			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);

			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
			Thread.sleep(5000);

			//Get the Number from URL
		//	String NofromURL=common.action().GetNofromURL();
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job)
					.click();
			Thread.sleep(4000);

			// Enter Submission Name
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_submission_name_input, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
			
			//Content TAb
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_content_tab).click();
			Thread.sleep(3000);
			
			/*
			 * assertion= Verify.action().verifyElementPresent(locators.exts().
			 * CMS_new_job_Content_page("Alloy Plan ",NofromURL), 10); if(assertion ==
			 * false){
			 * report("f"," assertion is failed while verifying Selected Page Number");
			 * 
			 * }
			 */
			// Configuration
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_configuration_tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);

			BrowserFactory.SystemEngine();
			((JavascriptExecutor) BrowserFactory.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);

					
			Verify.action().verifyElementPresent(locators.exts().PostAction_dropdown, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().PostAction_dropdown).click();				
			Thread.sleep(3000);		
			Verify.action().verifyElementPresent(locators.exts().Select_PostTransAction("Create EPiServer Project For Approval"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().Select_PostTransAction("Create EPiServer Project For Approval")).click();
			
			
			// select lang
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			
			Thread.sleep(1000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_Dede, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			Thread.sleep(9000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().advanced_settings_tab, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().advanced_settings_tab).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Post_Translation_Action_selectOption("Create EPiServer Project For Approval"),15);
			assertion = Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Post_Translation_Action_selectOption("Create EPiServer Project For Approval"),15);

			if (assertion == false) {
				report("f", " assertion is failed while verifying message");

			}
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
			

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_Close_button).click();
			Thread.sleep(4000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);
			
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
			Thread.sleep(5000);
			
			
			Verify.action().verifyElementPresent(locators.exts().Notification_Translation_Job, 15);
			notificationproj = BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Translation_Job).getText();
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
			
			if(Verify.action().verifyElementPresent(locators.exts().WarningMsg_Schedular_JobStartedWithout_Problems, 10)){
				
				System.out.println("INSIDE The job has completed. Please refresh the page to see the status---------->");
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(8000);
				
					
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				//go to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				
				assertion=common.action().verify_submission_Status(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				
				//dashboard cms-edit
				common.action().Go_To_DashBorad_CmsEdit("Edit");
				Thread.sleep(3000);
				
				
				
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_CMS_Project_Drop).click();
			Thread.sleep(5000);

			

			
			}
			

		} catch (Throwable e) {
			report("f", "Execution level error was encountered.\n\nError log:\n\n" + Verify.action().getErrorBuffer(e));
		}
	}

	@Test
	public void execute() throws Exception {

		testcase(dataSet);
		assertion();

	}

	public boolean checkWordExistence(String word, String sentence) {
		if (sentence.contains(word)) {

			return true;
		}
		return false;
	}

	@AfterMethod
	public void tearDown() throws Exception {
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void assertion() throws Exception{
			try{
				assertion=Verify.action().verifyElementPresent(locators.exts().Cms_Select_Project(SubName), 15);
				//Cmsproject = BrowserFactory.SystemEngine().findElement(locators.exts().Cms_Select_Project(SubName)).getText();
				
					if(assertion == false){
						report("f"," assertion is failed while verifying The Select project .");
					}else{
						report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
					}	
			}
				catch (Throwable e) {
				report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
										
				}
		}

	public void report(String result, String notes) throws Exception {
		TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),
				EPiServer_TestRail_Common_Properties.idTestPlan, EPiServer_TestRail_Common_Properties.idBuild, result,
				EPiServer_TestRail_Common_Properties.assignedTo, notes);
		if (result == "f")
			assertTrue(false);
	}

}
