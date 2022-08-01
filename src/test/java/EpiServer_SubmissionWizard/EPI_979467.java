package EpiServer_SubmissionWizard;

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

/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify updates in translation job due to changes done on submission wizard
* 
* Summary 		: This test case verifies the updates in translation job due to changes done on submission wizard
*******************************************************************************************************************************************************************/

public class EPI_979467 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979467";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979467");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_979467:  Verify updates in translation job due to changes done on submission wizard");
				dataSet.put("TL_internal_testCase_ID", "979467");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			
			
			General.action().login();
			Thread.sleep(2000);
			
			// go to CMS edit mode
			//Edit
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(7000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);
						
			//Select Page up to content Tab
			common.action().Selectpage_ContentTab("Alloy Meet", SubName);		
			//Configuration
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);
			
			if ( !BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Configuration_Include_reffered_content).isSelected() )
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Configuration_Include_reffered_content).click();
			}
			Thread.sleep(2000);
			
			//Language Tab to Submit for translation
			common.action().LangTab_SubmitforTranslation();
			
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
			//GL 
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_source, 10);
			String globalink_source=BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_source).getText();
		    System.out.println("Globalink Job Name ========>>"+globalink_source);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Source language");
			}
			
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_target, 10);
			String globalink_target=BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_target).getText();
		    System.out.println("Globalink Job Name ========>>"+globalink_target);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Target language");
			}
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_GLProject, 10);
			String globalink_project=BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_GLProject).getText();
		    System.out.println("Globalink Job Name ========>>"+globalink_project);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  GL Project");
			}
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_Duedate, 10);
			String globalink_date=BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation_Duedate).getText();
		    System.out.println("Globalink Job Name ========>>"+globalink_date);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Date");
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
