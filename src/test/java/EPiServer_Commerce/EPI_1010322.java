package EPiServer_Commerce;

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
* Test case     : Verify Add 'GlobalLink Translation Jobs' gadget
* Test Id       : C1010322
* Summary   	: This test case verifies whether User is able to add Gadgets manually after installation of adapter
* Precondition  : GlobalLink Adapter should be installed successfully
***********************************************************************************************/
public class EPI_1010322 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010322");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010322:Verify Add 'GlobalLink Translation Jobs' gadget");
				dataSet.put("TL_internal_testCase_ID", "1010322");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				common.action().toggle_navigation_tree_icon(true);
				
				//add gadget
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_add_gadgets,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying gadget add");
				}
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_rearrange_gadgets,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying gadget rearrange");
				}
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_add_gadgets).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget).click();
				Thread.sleep(5000);
	
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
		try{//Verify gadget added
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_GlobalLink_translation_jobs_gadget,  15);	
			if(assertion == false){
				report("f"," assertion is failed while verifying gadget added");
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
