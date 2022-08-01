package GL_Translation_Job_Content;

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
import actions.UnzipUtility;
import actions.Verify;
import actions.common;
import locators.locators;

/*******************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify the details of submission in Logs.
* Summary 		: This test case verifies the details of submission in Logs
* Preconditions : Create a new GlobalLink Translation Job
*
*********************************************************************************************************************************************************************************/


public class EPI_2405333 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_2405333";

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2405333");
		          //  Test case description here
				dataSet.put("TL_test_case_description","2405333:Verify the details of submission in Logs.");
				dataSet.put("TL_internal_testCase_ID", "2405333");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Other Setting tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting__Log_Lavel_selectOption("DEBUG")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				
				// go to CMS edit mode
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				//create submission
				//common.action().create_basic_submission(SubName);
				common.action().create_basic_submission("Alloy Plan",SubName, true, false, false, false, false, true, "2", false, false, false, true, true, "None");
				Thread.sleep(10000);
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
								
				//GO TO GlobalLink Other Setting tab==>> Verify Logs
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting__Log_Lavel_selectOption("DEBUG")).click();
				Thread.sleep(3000);
								
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(5000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_AdapterSettings_Log,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_AdapterSettings_Log).click();
				Thread.sleep(20000);
				
				
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
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{	
			   String dateformatter=UnzipUtility.dateconvertformatter();
		        String zipFilePath = BrowserFactory.SystemEngine().properties_downloadSubdir+dateformatter;
		        String destDirectory  =BrowserFactory.SystemEngine().properties_downloadTargetDir;
		        
			     UnzipUtility unzipper = new UnzipUtility();
		        String filepath=unzipper.unzip(zipFilePath,destDirectory);
			 
			   assertion= unzipper.read_Data("DEBUG", filepath);
			   
			   if(assertion == false){
				report("f"," assertion is failed while verifying Logs");
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
