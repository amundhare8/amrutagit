package GL_AddonConfiguration_Other_Setting_Tab;

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

/***********************************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify 'Submit Jobs' functionality from Other settings tab
* 
* Summary   	: This test case is to verify Submit Jobs feature - can Send a job immediately or wait for scheduler to process the Submission.
					Verify this functionality with:
					- Manual Trigger of Scheduler
					- Scheduled Trigger of Scheduler

**************************************************************************************************************************************************************************************************/
public class EPI_4039890 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_4039890";
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4039890");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_4039890: Verify 'Submit Jobs' functionality from Other settings tab");
				
				dataSet.put("TL_internal_testCase_ID", "4039890");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other")).click();
				Thread.sleep(1000);	
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("As per Scheduled time"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("As per Scheduled time")).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
				assertion=	Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_msg, 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Other Setting tab Message");
				}
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);				
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish("Alloy Plan",SubName, true, false, false, false, false, false, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(5000);
			
				assertion=common.action().verify_submission_Status(SubName, "Created");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status.");
				}
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
				
				common.action().Go_To_DashBorad_Button();
				
				assertion=common.action().verify_submission_Status(SubName, "Sent");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status.");
				}
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
				
				common.action().Go_To_DashBorad_Button();
				
				assertion=common.action().verify_submission_Status(SubName, "Published");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status.");
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
				// Click on global link config
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
				Thread.sleep(2000);

								
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other")).click();
				Thread.sleep(1000);	
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately")).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
		BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{			
			if(assertion == false){
				report("f"," assertion is failed while verifying submission Status.");
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
