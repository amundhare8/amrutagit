package GL_Translation_Job_Language;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : If only one Target language configured in PD then it should be selected by default on Translation Job
* 
* Preconditions : Configure PD project and languages in GlobalLink Config
* 
*Summary        : This test case verifies the validations of Source and target languages fetched from configured PD

***********************************************************************************************/
public class EPI_4862501 {


	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_4862501";
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4862501");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_4862501: If only one Target language configured in PD then it should be selected by default on Translation Job");
				dataSet.put("TL_internal_testCase_ID", "4862501");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				//GlobalLink Settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
				Thread.sleep(1000);
				
				
				//Inside_GL_Setting_Tab_Functionality
				common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username_Com,EPiServer_Common_Properties_Cred.Pass_Com,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Meet")).click();
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
				
				//select Project
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
				Thread.sleep(1000);
				
				//CMS_new_TargetJobLanguage
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_TargetJobLanguage,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying Target Language is Checked");
				}
				
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(true, false, false, false, false);
				
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, "None");
			
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
				Thread.sleep(7000);
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
				Thread.sleep(5000);
				
				common.action().verify_RunSchedulerHistroy1();
			    Thread.sleep(5000);

				
				//Run schedular
			    BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(15000);

				Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();

				Verify.action().WaitUntilElementPresent(locators.exts().WarningMsg_Scheduler_JobCompleted, 90);	
				Thread.sleep(2000);
				
				common.action().verify_RunSchedulerHistroy1();
			    Thread.sleep(1000);

				assertion=common.action().verify_submission(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
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
			
		
					
		public void assertion() throws Exception{
		try{
			if(assertion == false){
				report("f"," assertion is failed while verifying language added");
			}
			else{
				report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);			}	
				}catch (Throwable e) {
					report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				
				}
		}
		
		@AfterMethod
		public void tearDown() throws Exception{
			// Click on global link config
		Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
		Thread.sleep(5000);
		
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
		Thread.sleep(3000);

		Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
		BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
		Thread.sleep(1000);
		
		//Inside_GL_Setting_Tab_Functionality
		common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username,EPiServer_Common_Properties_Cred.Pass,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
		assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
			
		BrowserFactory.quitBrowser();
		}

			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
}
