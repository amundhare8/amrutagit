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
* Author        : Amrata M.
*
* Test case     : Verify whether Values under StringLists are exported (MetaKeywords)
* 
* Summary 		: This test case verifies whether Values under StringLists are exported (MetaKeywords)

*******************************************************************************************************************************************************************/



public class EPI_1473652 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_1473652";

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1473652");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1473652:Verify whether Values under StringLists are exported (MetaKeywords)");
				dataSet.put("TL_internal_testCase_ID", "1473652");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//Go to Content Type
				common.action().Go_to_GlobalLink_Admin_Content("Admin","Content Type","[Default] Standard Page");
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().Standered_page_Localized_iframe));
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Standeredpage_Localized, 10);
				String localized=BrowserFactory.SystemEngine().findElement(locators.exts().Standeredpage_Localized).getText();
			    System.out.println("Localized value  is ========>>"+localized);
			    if(assertion == false){
					report("f"," assertion is failed while verifying  Localized value");
				}
			    
			    BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
				Thread.sleep(3000);
	
				Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().add_pagetype("New Page"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype("New Page")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype("Standard Page"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype("Standard Page")).click();
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
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("Alloy - collaboration,");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("Alloy Plan, Alloy Meet, Alloy Track, distance collaboration,");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys("Alloy solves the two most pressing problems in long distance collaboration – better communication and better project management ");
				Thread.sleep(2000);
								
				//publish
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);
								
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
				Thread.sleep(2000);
				
				//sub_create
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);

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
				
				//Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
			
				//Go to DashBoard
				common.action().Go_To_DashBorad_Button();
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
				//edit
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab("Edit"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab("Edit")).click();;
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Select_page(PageName),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
				Thread.sleep(2000);
			
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(2000);
				
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
		
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
			Thread.sleep(2000);
						
			try {
		BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{
					
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title_de, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Title");
						
	    	}
	    	
	    	assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Keyword");
						
	    	}
	    	assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Page Description");
						
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

