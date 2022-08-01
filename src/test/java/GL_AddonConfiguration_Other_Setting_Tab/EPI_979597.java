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
* Test case     : Verify ‘Dump DB to log’ on GlobalLink Config page for 'Other settings' tab
* 
* Summary   	: This test case verifies all logs can be dump to db and can be visible on downloading adaptor logs.

**************************************************************************************************************************************************************************************************/
public class EPI_979597 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
		
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979597");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979597 : Verify ‘Dump DB to log’ on GlobalLink Config page for 'Other settings' tab");
				
				dataSet.put("TL_internal_testCase_ID", "979597");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Other Setting tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
					
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately")).click();
				Thread.sleep(2000);
				
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().OthersettingTab_DBDump,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().OthersettingTab_DBDump).click();
				Thread.sleep(5000);
				
				assertion=	Verify.action().verifyElementPresent(locators.exts().OthersettingTab_DBDump_message, 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying DB Dump message");
				}
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_AdapterSettings_Log,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_AdapterSettings_Log).click();
				Thread.sleep(2000);
				
				
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
			assertion=	Verify.action().verifyElementPresent(locators.exts().OthersettingTab_DBDump_message, 10);
			if(assertion == false){
				report("f"," assertion is failed while verifying DB Dump message");
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
