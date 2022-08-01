package EPiServer_Projects;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
* Author        : Proteek
*
* Test case     : Verify initiating translation from Episerver project
* 

* Summary 		: This test case verifies the initiation translation from EPiServer Project

*
*******************************************************************************************************************************************************************/


public class EPI_979445 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979445";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979445");
		dataSet.put("TL_test_case_description","EPI_979445: Verify initiating translation from Episerver project");
		dataSet.put("TL_internal_testCase_ID", "979445");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(2000);
				//
				//More Options
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions_NewProject, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions_NewProject).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions_NewProject_Name, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions_NewProject_Name).sendKeys("Epi_NewProject_A2");;
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions_NewProject_NameOk, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions_NewProject_NameOk).click();
				Thread.sleep(2000);
				
			
				Actions actions = new Actions(BrowserFactory.driver);
				WebElement elementLocator =BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Search"));
				actions.doubleClick(elementLocator).perform();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);
				
				
				
				// select language
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(5000);

				//More Options
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions).click();
				Thread.sleep(2000);
				
				//Translate Proj
				Verify.action().verifyElementPresent(locators.exts().Edit_Project_Moreoptions_TranslateProject, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Project_Moreoptions_TranslateProject).click();
				Thread.sleep(4000);
				
				// select language
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
				Thread.sleep(2000);

				// tools
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation1, 10);
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

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(10000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(15000);
				

				System.out.println("Submission :" + SubName + " is created.....");

				//Run Schedular
			    common.action().run_schedular();
			    
			    // Verify schedular Msg
			    common.action().verify_RunSchedulerHistroy(1,1);		    
			    
			    //go to Dashboard
			common.action().Go_To_DashBorad_Button();
				
				
				
				}catch(Throwable e){
				report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				}
			}

		//@Test
		public void execute() throws Exception{
			
			testcase(dataSet);
			assertion();
			
		}
			
		//@AfterMethod
		public void tearDown() throws Exception{
		try {
			//BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void assertion() throws Exception{
		try{
			assertion=common.action().verify_submission_Status(SubName, "Published");		
			Thread.sleep(2000);
			System.out.println("Flag=="+assertion);
			if(assertion == false){
				report("f"," assertion is failed while verifying submission");
			}else{
				report("b",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
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
