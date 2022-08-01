package GL_Translation_Job_Content;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify the confirmation message for deleting translation job.
* Preconditions : This test case verifies the confirmation message for deleting translation job
* 
***********************************************************************************************/

public class EPI_1740674 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1740674");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_1740674: Verify the confirmation message for deleting translation job");
				dataSet.put("TL_internal_testCase_ID", "1740674");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			General.action().login();
			Thread.sleep(2000);
			
			//Edit
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);
		
			common.action().Gl_Trasnlations_DeleteJob(1);	
			
           assertion=Verify.action().verifyElementPresent(locators.exts().GL_Global_JobDelete_MoveToTrashButton, 10);
	
			if(assertion == false){
				report("f"," assertion is failed while verifying Trash");
			}
			/*
            BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_JobDelete_MoveToTrashButton).click();
			Thread.sleep(4000);
			
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_settings, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_settings).click();
			Thread.sleep(4000);
			
		
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_settings_trash, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_settings_trash).click();
			Thread.sleep(4000);
			*/
			//Moving towords Trash Page
			common.action().GL_GlobalJob_MovetoTrash();
			
			}catch(Throwable e){
			report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
			}
		}

	@org.testng.annotations.Test
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
		if(assertion == false){
			report("f"," assertion is failed while verifying Trash");
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
