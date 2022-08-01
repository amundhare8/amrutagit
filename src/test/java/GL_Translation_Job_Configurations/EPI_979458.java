package GL_Translation_Job_Configurations;

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
 * Author 	  : Amrata M.
 *
 * Test case  : Verify 'Include Unchanged Content' Configuration option on translation job page.
 * 
 * Summary    : This test case verifies the functionality of 'Include Unchanged Content' Configuration option on translation job page.

 Precondition : Send a page for submission and retrieve back from PD. Do some changes in Page and publish it.
 *
 * 
 *******************************************************************************************************************************************************************/
public class EPI_979458 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979458";
	String RefPageName="Epi_RefPg_979458";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979458");
		dataSet.put("TL_test_case_description","EPI_979458: Verify 'Include Unchanged Content' Configuration option on translation job page.");
		dataSet.put("TL_internal_testCase_ID", "979458");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				
				General.action().login();
				Thread.sleep(2000);
				
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
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(RefPageName);
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_AllProperties,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_AllProperties).click();
				Thread.sleep(2000);
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("Long String Title,");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("Long String Keywords");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys("This is Long String Page Descrition.");
				Thread.sleep(2000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);
				
				//teaser text
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
				Thread.sleep(2000);				
							
				//publish
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
				Thread.sleep(2000);
				
				//submission
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(RefPageName)).click();
				Thread.sleep(5000);
				
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);


				//sub name				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(RefPageName);
				Thread.sleep(1000);
				
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(false,false, false, false, false);							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, "None");
				
				
				//select language
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(2000);
				
				//tools				
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
				
				assertion=Verify.action().verifyElementNotPresent(locators.exts().ContentPreview_Select_Content, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying  child Page not checked");
							
		    	}
		    	
		    	Verify.action().verifyElementPresent(locators.exts().advanced_settings_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().advanced_settings_tab).click();
				Thread.sleep(2000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Submit_Translation_IncludeExpired("Select Unchanged Content")).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Submit_Translation_IncludeExpired("Select Unchanged Content")).click();
				}
				Thread.sleep(2000);
				
			
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().ContentPreview_Select_Content, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying child page checked");
							
		    	}
				
				assertion= Verify.action().verifyElementPresent(locators.exts().Submit_Translation_Contentpreview("Search"), 10);	
				if(assertion == false){
					report("f"," assertion is failed while verifying Selected Page");
					
				}
				
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
				
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				
				//go to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				
				
				//Inside Dashboard --ID
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_PD=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
			    System.out.println("Globalink Submission ID is========>>"+globalink_PD);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Submission ID");
				}
				
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
				}
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status1);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
								
				
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
			assertion=common.action().verify_submission_Status(SubName, "Imported");		
			Thread.sleep(2000);
			System.out.println("Flag=="+assertion);
			if(assertion == false){
				report("f"," assertion is failed while verifying submission");
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
