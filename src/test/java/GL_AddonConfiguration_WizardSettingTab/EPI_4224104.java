package GL_AddonConfiguration_WizardSettingTab;

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

/*******************************************************************************************************************************************************************************
* Author        : Proteek
*
* Test case     : Rename config options to provide more context.
* Summary 		: This test case verifies the functionality of when we unselect checkbox �include child nodes� configured on GlobalLink Config page for Wizard settings tab
* Preconditions : Create a page with child nodes
*
*********************************************************************************************************************************************************************************/


public class EPI_4224104 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_4224104";
	String ProjectName= "EPiServer";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4224104");
		dataSet.put("TL_test_case_description","EPI_4224104: Rename config options to provide more context");
		dataSet.put("TL_internal_testCase_ID", "4224104");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings")).click();
				Thread.sleep(1000);
							
				//Inside Wizard Tab
				common.action().Inside_Wizard_Setting_Tab("EPiServer", "English (en)",false, false, false, false, "2", false, false, false,"Auto Publish", false,false);
				
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				//Create Submission-[Submit For Translation]
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Search")).click();
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
				
				common.action().Config_ReferencedContentTypesChecks(false,true, true, true, true);

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
				Thread.sleep(5000);	  		    
				
						
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
			assertion=Verify.action().verifyElementNotPresent(locators.exts().Gl_Submit_for_translation_Include_expired_target_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include expired Target content Items unchecked");
						
	    	}
	    	
	    	assertion=Verify.action().verifyElementNotPresent(locators.exts().Gl_Submit_for_translation_Include_expired_target_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include expired Target content Items unchecked");
						
	    	}
	    	assertion=Verify.action().verifyElementNotPresent(locators.exts().Gl_Submit_for_translation_Include_unchanged_content_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include unchanged content Items not checked");
						
	    	}
	    	assertion=Verify.action().verifyElementNotPresent(locators.exts().Gl_Submit_for_translation_Select_Duplicate_Request_checkbox_checked, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Include child Items not checked");
						
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
