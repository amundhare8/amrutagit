package EpiServer_SubmissionWizard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify the display of Tree contents is expanded or not while sending GlobalLink Translation Job
* Summary   	: This test case verifies the display of Tree contents is expanded or not while sending GlobalLink Translation Job

************************************************************************************************************************************************/


public class EPI_1188836 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1188836";
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1188836");
		dataSet.put("TL_test_case_description","EPI_1188836 : Verify the display of Tree contents is expanded or not while sending GlobalLink Translation Job");
		dataSet.put("TL_internal_testCase_ID", "1188836");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
/*
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("About us")).click();
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
*/				//Select Page up to content Tab
				common.action().Selectpage_ContentTab("About us", SubName);	
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(true,true, true, false, false);
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(false, "5", true, true, true, true, true, "None");
				/*
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
				BrowserFactory.driver.switchTo().frame(
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				*/
				//Language Tab to Submit for translation
				common.action().LangTab_SubmitforTranslation();
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_child_Items_checkbox_checked, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Include child Items is checked");
		    	}//
				
		    	assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_Referenced_Content, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Include Referenced Content is checked");
		    	}
				Verify.action().verifyElementPresent(locators.exts().advanced_settings_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().advanced_settings_tab).click();
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
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_expired_source_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include expired source content Items checked");
						
	    	}
						
	    	assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_unchanged_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include unchanged content Items checked");
				}
	    	
	    	assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_Duplicate_Request_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include Duplicate Request content Items checked");
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
