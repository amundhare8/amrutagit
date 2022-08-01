package GL_Translation_Job_Language;

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

/**********************************************************************************************************************************************
* Author        : Amrata M.
* 
** Test case    : Verify validations for 'Due date' on Language tab.
*
*
* Summary   	: Verify display of due date from saved configuration
				  use calendar date picker to select user defined due date.
				  
* Precondition  : Go to GlobalLink Config>> Wizard Setting>> Due date

				  set due date as +5d or any other date
				  
***********************************************************************************************************************************************/
public class EPI_643750{
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_643750";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_643750");
		dataSet.put("TL_test_case_description","EPI_643750 : Verify validations for 'Due date' on Language tab.");
		dataSet.put("TL_internal_testCase_ID", "643750");
				
			
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
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys("+5d");
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(5000);
				//Verify changes are saved
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
				Thread.sleep(3000);
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Track")).click();
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
							
				String newDate=common.action().GetDataPlusFormat(5,"yyyy-MM-dd");
				System.out.println("New Date Is"+ newDate);
				
								
				//select Project
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
				Thread.sleep(3000);	
				
				String ValuePrintDate = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_DatePrint).getAttribute("value");
				System.out.println("PRINT VALUE OF DATE--------->"+ValuePrintDate);
				Thread.sleep(2000);		
				
				
				assertion=ValuePrintDate.contains(newDate);
				if(assertion == false){
					report("f"," assertion is failed while verifying The default project (EPiServer) should be present in the project field.");
				}	
				
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(true, false, false, false, false);
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "2", false, false, true, true, true, "None");
				
				//select language
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(3000);

				// tools
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation1).click();
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

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(10000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(15000);
				

				System.out.println("Submission :" + SubName + " is created.....");
				
				//Run Schedular
			    common.action().run_schedular();
			    
			    // Verify schedular Msg
			    common.action().verify_RunSchedulerHistroy1();		    
			    
			    //go to Dashboard
			    common.action().Go_To_DashBorad_Button();
				
						
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
		@AfterMethod
		public void tearDown() throws Exception{
		try {
			BrowserFactory.quitBrowser();
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
