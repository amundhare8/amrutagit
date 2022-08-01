package GL_AddonConfiguration_GlobalLink_Settings_Tab;

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

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify Project director Submission can be set as default on 'GlobalLink Settings' tab
* Preconditions : Configured Pd user should have multiple Submissions.
* Summary       : This test case verifies that the default Submission can be configured.
***********************************************************************************************/

public class EPI_979479 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979479";
	String ProjectName= "EPiServer";
	String globalink_Jobname="";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979479");
		dataSet.put("TL_test_case_description","EPI_979479: Verify Project director Submission can be set as default on 'GlobalLink Settings' tab");
		dataSet.put("TL_internal_testCase_ID", "979479");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings")).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Default_project_SelectOptions("EPiServer"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_project_SelectOptions("EPiServer")).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(6000);
				//Verify changes are saved
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
				Thread.sleep(3000);
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("About us")).click();
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
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_GL_Project_select(ProjectName),  5);
		    if(assertion == false){
			   report("f"," assertion is failed while verifying The default project (EPiServer) should be present in the project field.");
		     }else{
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
