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

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : To verify the Default translation wizard checkboxes.
* Preconditions : This test case verifies the default translation wizard checkboxes in GlobalLink dashboard
***********************************************************************************************/

public class EPI_979576 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979576";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979576");
		dataSet.put("TL_test_case_description","EPI_979576: To verify the Default translation wizard checkboxes.");
		dataSet.put("TL_internal_testCase_ID", "979576");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings")).click();
				Thread.sleep(1000);
			
				
				common.action().Inside_Wizard_Setting_Tab("EPiServer", "English (en)",false, true, true, true, "2", true, true, true,"Auto Publish", true,true);
				
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
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
				Thread.sleep(6000);

				System.out.println("HI");
				assertion=Verify.action().verifyElementNotPresent(locators.exts().Gl_Submit_for_translation_Include_child_Items_checkbox_checked, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Include child Items not checked");
							
		    	}
		    	
		    	BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
				Thread.sleep(4000);
				
				
				System.out.println("Submission :"+SubName+" is created.....");
		    				
				
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin).click();
				Thread.sleep(5000);

				
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin_admin,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin_admin).click();
				Thread.sleep(5000);
				

				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Admin"),  25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Admin")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboardadmin_admin_Glschedular,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboardadmin_admin_Glschedular).click();
				Thread.sleep(7000);
			
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();
				Thread.sleep(5000);
				
				Thread.sleep(30000);
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().schedular_msg, 15);
				assertion=Verify.action().verifyElementPresent(locators.exts().schedular_msg,  15);
				
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
					
				}
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(3000);
				

				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Admin_Schedular_history_status, 10);
				String history_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Admin_Schedular_history_status).getText();
			    System.out.println(" Status is========>>"+history_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
					
				}
								
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				//Go to DashBoard
				
				common.action().Go_To_DashBorad_Button();
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
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
			//GL status
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
		    System.out.println("Globalink Status is========>>"+globalink_Status1);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Status");
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
