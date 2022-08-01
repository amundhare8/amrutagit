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
* Author        : Mayureshwar
*
* Test case     : Project Director HTTPS support on GlobalLink Config page for 'GlobalLink Settings' tab
* Test Id       : C979481
* Summary   	: This test case is to test whether Adapter supports HTTPS Submission Director URL
***********************************************************************************************/
public class EPI_979481 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName="auto_submission_979481_1";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979481");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979481:Project Director HTTPS support on GlobalLink Config page for 'GlobalLink Settings' tab");
				dataSet.put("TL_internal_testCase_ID", "979481");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
							
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_addon_config_text, 5);
				if(assertion == false){
					report("f"," assertion is failed");
				}

				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
				Thread.sleep(1000);
				
				
				//Inside_GL_Setting_Tab_Functionality
				common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username,EPiServer_Common_Properties_Cred.Pass,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish("Alloy Track",SubName, true, false, false, false, false, false, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(5000);
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(2,1);
				//Run Schedular
				//common.action().run_schedular();

				assertion=common.action().verify_submission(SubName, "Published");		
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
		
		BrowserFactory.quitBrowser();
		}
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
}
