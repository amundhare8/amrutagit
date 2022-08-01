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
import actions.common;
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : Verify Move to Trash option is disabled for GlobalLink Translation Jobs Gadget
* Test Id       : C2109702
* Summary   	: This test case verifies that Move to Trash option is disabled for GlobalLink Translation Gadget
***********************************************************************************************/
public class EPI_2109702 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName="auto_submission_2109702";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2109702");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_2109702:Verify Move to Trash option is disabled for GlobalLink Translation Jobs Gadget");
				dataSet.put("TL_internal_testCase_ID", "2109702");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
							
				General.action().login();
				Thread.sleep(2000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
					
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				
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
		
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{
			assertion=BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_move_to_trash).isEnabled();
			if(assertion == false){
				report("f"," assertion is failed while verifying submission");
			}else{
				report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
			}	
				}catch (Throwable e) {
					report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				
				}
		}
		
		
			public void report(String result, String notes) throws Exception
			{
			try {
				TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
				if(result == "f")
					assertTrue(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}	
}
