package GL_Translation_Job_Language;

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
import locators.PD4_main_Locators;
import locators.locators;


/******************************************************************************************************************************************************************
 * Author : Amrata M.
 *
 * Test case : Verify 'Instructions' in PD
 * 
 * Summary : This test case verifies the Instruction provided in submission are displayed in PD
 * 
 *******************************************************************************************************************************************************************/
public class EPI_643749 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_643749";
	String ProjectName= "EPiServer";
	@BeforeMethod		
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_643749");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_643749: Verify 'Instructions' in PD");
				dataSet.put("TL_internal_testCase_ID", "643749");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);

				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);

				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Meet")).click();
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
				
				// Configuration		
				common.action().Config_ReferencedContentTypesChecks(true,false, false, false, false);
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, "None");
				
				// select language
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(2000);
				
				//Instruction To be send
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_language_Instruction).sendKeys("This language Instruction need to be test.");
				Thread.sleep(3000);

				
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
				

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(30000);

				System.out.println("Submission :" + SubName + " is created.....");

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(30000);
						
				
				//run schedular
				common.action().run_schedular();
				Thread.sleep(1000);
				
				common.action().verify_RunSchedulerHistroy1();
			
				//got to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				//GlobalLink_Dashboard_Submission_ID
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_Sub_ID = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
				System.out.println("Globalink Submission ID is========>>" + globalink_Sub_ID);

				//open pd url
				common.action().Open_New_Instance_URL(EPiServer_Common_Properties_Cred.GlobalLink_url);
				
				//pd login
				common.action().PDlogIn(EPiServer_Common_Properties_Cred.Username, EPiServer_Common_Properties_Cred.Pass);
				//Inside PD
				common.action().Inside_PD(globalink_Sub_ID);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_Completed_Instruction, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_Completed_Instruction).click();
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
		
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{	
			//PD instruction
			assertion = Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_Completed_Instruction_Details, 10);
			String Instruction = BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_Completed_Instruction_Details).getText();
			System.out.println("PD instruction is========>>" + Instruction);
			if(assertion == false){
				report("f"," assertion is failed while verifying paging");
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
