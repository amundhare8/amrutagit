package EpiServer_SubmissionWizard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************************************
* Author        :   Amrata M.
*
* Test case     :	Verify unchecking some references from 'referenced content' section and submit job for translation

* Summary 		: 	This test case verifies the functionality of unchecking references having some references from 'referenced content' section and submit job for translation
* 
* 
*******************************************************************************************************************************************************************/
public class EPI_979465 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979465";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979465");
		          //  Test case description here
		dataSet.put("TL_test_case_description","EPI_979465:  Verify unchecking some references from 'referenced content' section and submit job for translation");
		dataSet.put("TL_internal_testCase_ID", "979465");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			
			
			General.action().login();
			Thread.sleep(2000);
			
			// go to CMS edit mode
			//Edit
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);
			
			/*
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
			*///Select Page up to content Tab
			common.action().Selectpage_ContentTab("Alloy Plan", SubName);
			
				
			//Configuration
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);
			
			common.action().Config_ReferencedContentTypesChecks(true,true, true, true, true);
			//select language
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
			Thread.sleep(3000);

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
			
			assertion = Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);
			if (assertion == false) {
				report("f", " assertion is failed while verifying  Refresh Button");
			}
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(5000);

			//Content_Preview_selectedContent
			
			
			Verify.action().verifyElementPresent(locators.exts().Content_Preview_selectedReferenced("Customer testimonial wide teaser (Alloy Plan)"), 5);	
			BrowserFactory.SystemEngine().findElement(locators.exts().Content_Preview_selectedReferenced("Customer testimonial wide teaser (Alloy Plan)")).click();
			Thread.sleep(2000);
			

			Verify.action().verifyElementPresent(locators.exts().Content_Preview_selectedReferenced("Contact us (Alloy Plan)"), 5);	
			BrowserFactory.SystemEngine().findElement(locators.exts().Content_Preview_selectedReferenced("Contact us (Alloy Plan)")).click();
			Thread.sleep(8000);
			
			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
			Thread.sleep(3000);
			
			BrowserFactory.SystemEngine();
			
			BrowserFactory.driver.switchTo().defaultContent();			
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
			Thread.sleep(4000);
			
			
			System.out.println("Submission :"+SubName+" is created.....");
			
			//Run schedular
			common.action().run_schedular();
			common.action().verify_RunSchedulerHistroy1();
			//Go to Dashboard Button
			common.action().Go_To_DashBorad_Button();	
			
			//Status
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
		    System.out.println("Globalink Status is========>>"+globalink_Status);		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Status");
			}
					
			//Job name
		    Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).click();
			
		   	
			}catch(Throwable e){
			report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
			}
		}

	@org.testng.annotations.Test
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
			assertion=Verify.action().verifyElementTextNotPresent(locators.exts().GL_Dashboard_Submission_Contentname, "Contact us",10);			  							
			if(assertion == false){
				report("f"," assertion is failed while verifying Reference page Name");
			}
			
			assertion=Verify.action().verifyElementTextNotPresent(locators.exts().GL_Dashboard_Submission_Contentname, "Customer testimonial wide teaser",10);
			if(assertion == false){
				report("f"," assertion is failed while verifying Reference page Name");
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
