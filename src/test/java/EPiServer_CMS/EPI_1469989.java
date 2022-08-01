package EPiServer_CMS;

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
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar
* Test Id       : 1469989
* Test case     : Verify job Archival on Dashboard from Published jobs filter section
* Summary   	: This test case verifies that job Archival on Dashboard from Published jobs filter section
* Precondition  : Few submissions with published status should be present
***********************************************************************************************/
public class EPI_1469989 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1469989");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1469989:Verify job Archival on Dashboard from Published jobs filter section");
				dataSet.put("TL_internal_testCase_ID", "1469989");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(5000);
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
				Thread.sleep(5000);
					
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				
				//click on Publish Job
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs).click();
				Thread.sleep(3000);

				//click on checkbox
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_ArchiveCheckbox, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_ArchiveCheckbox).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Archive_selected_jobs_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Archive_selected_jobs_button).click();
				Thread.sleep(8000);
				
	
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
					Thread.sleep(2000);
					}
					
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs).click();
					Thread.sleep(3000);
					assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
					if(assertion == false){
						report("f"," assertion is failed while verifying  status");
					}

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_ArchiveJobs, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_ArchiveJobs).click();
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
		
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{	
			
			if(assertion == false){
				report("f"," assertion is failed while verifying  status");
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
