package GL_Translation_Job_Content;

import static org.testng.Assert.assertTrue;

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
import locators.locators;

/******************************************************************************************************************************************************************
 * Author : Amrata M.
 *
 * Test case : Verify if Draft and Published Content are showing up to Translation.
 * 
 * Summary : This test case verifies if Draft and Published Content are showing up to Translation.
 * 
 *******************************************************************************************************************************************************************/

public class EPI_1473651 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_1473651";
	String PageName = "Epi_1473651";

	@BeforeMethod
	public void setUp() throws Exception {
		BrowserFactory.SystemEngine().startApplication("EPI_1473651");
		dataSet.put("TL_test_case_description","EPI_1473651: Verify if Draft and Published Content are showing up to Translation..");
		dataSet.put("TL_internal_testCase_ID", "1473651");

	}

	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception {
		try {
			General.action().login();
			Thread.sleep(2000);

			// go to CMS edit mode
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);

			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);

			//version			
			Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
			BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().add_pagetype("New Page"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype("New Page")).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype("Standard Page"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype("Standard Page")).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_name, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).click();
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(Keys.CONTROL, Keys.chord("A"), Keys.BACK_SPACE);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(PageName);
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_jobs_AllProperties, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_AllProperties).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("Alloy - collaboration,");
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("Alloy Plan, Alloy Meet, Alloy Track, distance collaboration,");
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys(
							"Alloy solves the two most pressing problems in long distance collaboration – better communication and better project management ");
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);

			// select language
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);

			// tools
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);
			
			assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_Status("Draft"), 10);
			if(assertion == false){
				report("f"," assertion is failed while verifying Status");
			}
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
			Thread.sleep(4000);

			// Run schedular
			common.action().run_schedular();
			common.action().verify_RunSchedulerHistroy1();

			//Go to Dashboard Button
			common.action().Go_To_DashBorad_Button();
			// Status
			assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			System.out.println("Globalink Status is========>>" + globalink_Status);

			if (assertion == false) {
				report("f", " assertion is failed while verifying  Status");
			}

			// edit
			Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
			Thread.sleep(1000);

			Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab("Edit"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab("Edit")).click();
			Thread.sleep(3000);

			//ignore
			
			if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
				Thread.sleep(1000);
			}

			//select pg
			Verify.action().verifyElementPresent(locators.exts().Select_page(PageName), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);
			
		} catch (Throwable e) {
			report("f", "Execution level error was encountered.\n\nError log:\n\n" + Verify.action().getErrorBuffer(e));
		}
	}

	@Test
	public void execute() throws Exception {

		testcase(dataSet);
		assertion();

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
				assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_Status("Published"), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Status");
				}
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
				
				else{
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
