package EpiServer_SelectedTCFor_LastRun;

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
import locators.PD4_main_Locators;
import locators.locators;

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify whether adapter allowed to handle due dates so they don't get swapped with wrong format (day and month)
* Summary   	: This test case verifies whether adapter allowed to handle due dates so they don't get swapped with wrong format (day and month)

************************************************************************************************************************************************/
public class EPI_2089152 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String ValuePrintDate="";
	String newDate="";
	
	String SubName = "EpiServer_Sub_2089152";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2089152");
		
		dataSet.put("TL_test_case_description","EPI_2089152:Verify whether adapter allowed to handle due dates so they don't get swapped with wrong format (day and month)");
		dataSet.put("TL_internal_testCase_ID", "2089152");	
			
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
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys("+2d");
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(4000);
				//Verify changes are saved
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
				Thread.sleep(3000);
				
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Track")).click();
				Thread.sleep(5000);
				
				//Get the Number from URL
				//String NofromURL=common.action().GetNofromURL();
	
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
				
				//Content TAb
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_content_tab).click();
				Thread.sleep(3000);
				
			//	assertion= Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Content_page("Alloy Track ",NofromURL), 10);	
				if(assertion == false){
					report("f"," assertion is failed while verifying Selected Page Number");
					
				}
				
				common.action().GetDataPlusFormat(2, "MM/DD/YYYY");
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(true,true, false, false, false);
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "5", true, true, true, true, true, "None");
				
				//select language
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_Dede,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(2000);
				
				 ValuePrintDate = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_DatePrint).getAttribute("value");
				System.out.println("PRINT VALUE OF DATE--------->"+ValuePrintDate);
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
				

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(4000);
				
				
				System.out.println("Submission :"+SubName+" is created.....");
				// Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
				
				////After schedular run go to dashboard press dashboard Button
				common.action().Go_To_DashBorad_Button();
				
				//GlobalLink_Dashboard_Submission_ID
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_Sub_ID = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
				System.out.println("Globalink Submission ID is========>>" + globalink_Sub_ID);


				// Status
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1 = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
				System.out.println("Globalink Status is========>>" + globalink_Status1);

				if (assertion == false) {
					report("f", " assertion is failed while verifying  Status");
				}
				
				//open pd url
				common.action().Open_New_Instance_URL(EPiServer_Common_Properties_Cred.GlobalLink_url);
				
				//pd login
				common.action().PDlogIn(EPiServer_Common_Properties_Cred.Username, EPiServer_Common_Properties_Cred.Pass);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_select, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_select).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_SubId, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_SubId).sendKeys(globalink_Sub_ID);
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_search, 5);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_search).click();;
				Thread.sleep(1000);
				
				//Due_date
				assertion = Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Due_date, 10);
				String Due_date = BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Due_date).getText();
				System.out.println("PD  Due date is========>>" + Due_date);
				if (assertion == false) {
					report("f", " assertion is failed while verifying  Due date");
				}
				
				Thread.sleep(2000);
				
				//logout
			common.action().PDlogOut();
				
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
					report("f","assertion is failed while verifying  Due Date.");
				}else{
					report("b",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}	
					}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
			}
			
			
		@AfterMethod
		public void tearDown() throws Exception{
		try {
			//BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
			
			
}
