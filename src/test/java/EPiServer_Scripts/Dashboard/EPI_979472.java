package EPiServer_Scripts.Dashboard;


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
* Test case     : Verify sorting feature on Dashboard columns
* Summary   	: This test case verifies sorting feature on Dashboard columns
* Preconditions : More than one Submissions should be present on the dashboard.
* 				  Submissions with Waiting to send, Sent, imported submissions
***********************************************************************************************/
public class EPI_979472 {
//INCOMPLETE need subs as precondition
	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod		
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979472");
		// Write you Test case description here
				dataSet
				.put("TL_test_case_description","EPI_979472:Verify sorting feature on Dashboard columns");
				dataSet.put("TL_internal_testCase_ID", "979472");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				
				//go to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_MyJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_MyJobs).click();
				Thread.sleep(3000);
				


						
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
				report("f"," assertion is failed while verifying paging");
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
