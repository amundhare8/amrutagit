package GL_AddonConfiguration_Scheduler;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
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
* Test case     : Verify Scheduler with "Retrieve Completed Targets " option checked on Scheduler Tab
* 
* 
***********************************************************************************************/
public class EPI_4782015 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_4782015";
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4782015");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_4782015:Verify Scheduler with \"Retrieve Completed Targets \" option checked on Scheduler Tab");
				dataSet.put("TL_internal_testCase_ID", "4782015");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);			
				
				
				// go to CMS edit mode
			//	common.action().go_to_CMS_from_Globallink("Edit");
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish("Alloy Track",SubName, true, false, false, false, false, false, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(5000);
				
				// Click on global link config
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
				Thread.sleep(1000);
				
				//Scheduler
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler")).click();;
				Thread.sleep(3000);
		
				
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Retrieve_completed_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Retrieve_completed_targets_checkbox).click();
				Thread.sleep(1000);

				//Start_scheduler
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Start_schedulerbutton,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Start_schedulerbutton).click();
				Thread.sleep(8000);
		
				assertion=Verify.action().verifyElementPresent(locators.exts().Scheduler_JobStarted_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying Job Started.");
				}
			
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				// Click on global link config
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(3000);
				
				// Click on global link config
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, "Published"), 5);		
				Thread.sleep(2000);
				
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
			
		@AfterMethod
		public void tearDown() throws Exception{
		
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{
			
			if(assertion == false){
				report("f"," assertion is failed while verifying submission");
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
