package GL_AddonConfiguration_Scheduler;

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
* Author        : Mayureshwar
*
* Test case     : Verify validation messages on GlobalLink Config page for Scheduler tab
* Summary   	: This test case verifies the functionality of Job Pagination
***********************************************************************************************/
public class EPI_1010314 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010314");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010314:Verify validation messages on GlobalLink Config page for Scheduler tab");
				dataSet.put("TL_internal_testCase_ID", "1010314");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				common.action().Go_to_Globalink_config();
				
				//Scheduler
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler")).click();;
				Thread.sleep(3000);
		
				
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Send_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Send_targets_checkbox).click();
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().Scheduler_Retrieve_completed_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Retrieve_completed_targets_checkbox).click();
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().Scheduler_Cancel_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Cancel_targets_checkbox).click();
				Thread.sleep(1000);

				//Test settings
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Start_schedulerbutton,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Start_schedulerbutton).click();
				Thread.sleep(5000);
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Scheduler_JobStarted_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying Job Started.");
				}
				
				//uncheck
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Send_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Send_targets_checkbox).click();
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().Scheduler_Retrieve_completed_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Retrieve_completed_targets_checkbox).click();
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().Scheduler_Cancel_targets_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Cancel_targets_checkbox).click();
				Thread.sleep(1000);

				//Test settings
				Verify.action().verifyElementPresent(locators.exts().Scheduler_Start_schedulerbutton,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Scheduler_Start_schedulerbutton).click();
				Thread.sleep(5000);
	
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
			assertion=Verify.action().verifyElementPresent(locators.exts().Scheduler_Error_msg,  15);
			if(assertion == false){
				report("f"," assertion is failed while verifying error msg");
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
