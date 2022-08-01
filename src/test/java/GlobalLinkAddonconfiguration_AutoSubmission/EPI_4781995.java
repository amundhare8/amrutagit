package GlobalLinkAddonconfiguration_AutoSubmission;

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

/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify "Enable Automated Submission Creation" option un-Checked.
* 

* Summary 		: This test case is to verify the Due Date Save Error for Auto Submission
*
*******************************************************************************************************************************************************************/


public class EPI_4781995 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4781995");
		dataSet.put("TL_test_case_description","EPI_4781995 : Verify Enable Automated Submission Creation option un-Checked.");
		dataSet.put("TL_internal_testCase_ID", "4781995");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission")).click();
				Thread.sleep(1000);
				
			
				if (BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				//AutoSubmission_Save
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Auto submission is saved");
					}
		    	
		    	// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Track")).click();
				Thread.sleep(5000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
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
			assertion=Verify.action().verifyElementNotPresent(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem,5);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Auto Submit Current Item option under GLTranslation Jobs gadget");							
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
