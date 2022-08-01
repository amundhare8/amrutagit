package EpiServer_SetAccessRights;


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
/******************************************************************************************************
* Author        : Proteek
*
* Test case     : Verify the functionality of Read Access for GlobalLink Translations
* Summary		: This test case verifies the functionality of Read Access for GlobalLink Translations
* Preconditions : GlobalLink Translations adapter should be installed

*******************************************************************************************************/
public class EPI_1077195 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1077195");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1077195:Verify the functionality of Read Access for GlobalLink Translations");
				dataSet.put("TL_internal_testCase_ID", "1077195");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				common.action().Go_to_GlobalLink_Admin_AdminConfig("Admin", "Admin", "Set Access Rights");
				Thread.sleep(10000);
				common.action().SetAccessRights_Administration_SelectCheckbox(true, true, true, true, true, true);
				
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
			BrowserFactory.SystemEngine();
			String error=BrowserFactory.driver.switchTo().alert().getText();
			System.out.println("Error msg:"+error);
			assertion=error.contentEquals("Please check items you would like to delete");
			if(assertion == false){
				report("f","assertion is failed while verify System should show alert message as language not selected.");
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
