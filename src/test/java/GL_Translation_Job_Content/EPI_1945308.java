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
* Author        :   Amrata M.
*
* Test case     :	Verify whether adaptor allows sending empty source field to clear existing filled target field

* Summary 		: This test case verifies whether adaptor allows sending empty source field to clear existing filled target field
* 
*******************************************************************************************************************************************************************/


public class EPI_1945308 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_1945308";
	String SubName = "EpiServer_Sub_1945308";

	@BeforeMethod
	public void setUp() throws Exception{
		
		BrowserFactory.SystemEngine().startApplication("EPI_1945308");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_1945308: Verify whether adaptor allows sending empty source field to clear existing filled target field");
				dataSet.put("TL_internal_testCase_ID", "1945308");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);			
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_jobs_Alloy_AllProperties, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_Alloy_AllProperties).click();
				Thread.sleep(2000);
							
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);
			
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys(Keys.CONTROL+"a");
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys(Keys.DELETE);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is Dummy Teaser Text");
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_Changes, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_Changes).click();
				Thread.sleep(2000);
								
				//Create Submission
				common.action().create_basic_submission_New(SubName);
				
				//Run Schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
				
				//edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(5000);
				
				//alloy plan
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
				Thread.sleep(5000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);
				
				//de=de
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(2000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
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
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyTextNotPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Teaser Text");
			}
	    	
	    	assertion=Verify.action().verifyTextNotPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Main body");
						
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

