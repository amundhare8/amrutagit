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
* Test case     : Verify functionality of 'userAgent' field in GlobalLink Config section
* Test Id       : C979483
* Summary   	: This Test case is to verify functionality of newly added UserAgent field in adaptor config section
***********************************************************************************************/
public class EPI_979483 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979483");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979483:Verify functionality of 'userAgent' field in GlobalLink Config section");
				dataSet.put("TL_internal_testCase_ID", "979483");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				common.action().Go_to_Globalink_config();
				

				
				//GlobalLink Settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID,  15);
				if(!BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).getText().isEmpty())
				{
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).clear();
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
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID_verify_placeholder(EPiServer_Common_Properties_Cred.UID),  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying Placeholder text");
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
