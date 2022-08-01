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
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify If child page is referenced in parent page then it is not listing in referenced content section.
* 
* Summary 		: This test case verifies if child page is referenced in parent page then it is not listing in referenced content section when 'include referenced content' option is selected.

*******************************************************************************************************************************************************************/

public class EPI_1469994 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1469994";
	String ProjectName= "EPiServer";
	String actualTooltip="";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1469994");
		dataSet.put("TL_test_case_description","EPI_1469994: Verify If child page is referenced in parent page then it is not listing in referenced content section.");
		dataSet.put("TL_internal_testCase_ID", "1469994");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//create submission
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
			
				//Create Submission 
				common.action().create_basic_submission_SubmitforTranslation("Alloy Track",SubName);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(7000);
						
				Verify.action().verifyElementPresent(locators.exts().content_settings_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().content_settings_tab).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_submit_Translation_include_child_Item,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_submit_Translation_include_child_Item).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				
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
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_submit_Translation_Select_content_whitepaper, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying All parent,child pages are displayed");				
		      	
		    	}
				else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}	
					}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
			
		
		try
		{
			assertion=Verify.action().verifyElementPresent(locators.exts().GL_submit_Translation_Reference_Contents, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Reference Content");
						
	      	
	    	}else{
				report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
			}
		}
		catch (Throwable e) {
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
