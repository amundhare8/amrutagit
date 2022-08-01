package GL_Translation_Job_Content;

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

/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify whether adapter is displaying Select All option for Referenced Content Selector.
* 
* Summary 		: This test case verifies whether adapter is displaying Select All option for Referenced Content Selector

*
*******************************************************************************************************************************************************************/


public class EPI_2089153 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_2089153";
	String SubName = "EpiServer_Sub_2089153";

	@BeforeMethod
	public void setUp() throws Exception{
		
		BrowserFactory.SystemEngine().startApplication("EPI_2089153");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_2089153: Verify whether adapter is displaying Select All option for Referenced Content Selector");
				dataSet.put("TL_internal_testCase_ID", "2089153");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
			
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
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
				
				//Configuration
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
				Thread.sleep(1000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Configuration_Include_reffered_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Configuration_Include_reffered_content).click();
				}
				Thread.sleep(2000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_pages).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_pages).click();
				}
				Thread.sleep(2000);
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_Block).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_Block).click();
				}
				Thread.sleep(2000);
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_Media).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Referenced_Content_Types_Media).click();
				}
				Thread.sleep(2000);
				
				//select language
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_Dede,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(2000);
		
				//tools
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
				Thread.sleep(9000);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);
				
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

       
    
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
			try{
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_job_LoadMore, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Load Items option is displayed on the Preview area");
							
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
