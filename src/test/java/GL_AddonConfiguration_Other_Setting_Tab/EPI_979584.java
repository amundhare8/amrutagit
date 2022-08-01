package GL_AddonConfiguration_Other_Setting_Tab;

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

/***********************************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify functionality of value for 'Scheduler User' field on GlobalLink Config page for 'Other Settings' tab
* 
* Summary   	: This test case verifies that the scheduler user in the configuration is picked (if one is configured)

**************************************************************************************************************************************************************************************************/
public class EPI_979584 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "Epi_979584";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979584");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979584: Verify functionality of value for 'Scheduler User' field on GlobalLink Config page for 'Other Settings' tab");
				
				dataSet.put("TL_internal_testCase_ID", "979584");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Other Setting tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
							
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_Scheduler_User,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Scheduler_User).clear();
				Thread.sleep(1000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Scheduler_User).sendKeys("GlobalLinkuser");
				Thread.sleep(3000);
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately")).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_saved,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
			
				//create submission
				common.action().create_basic_submission("Alloy Meet",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "None");
				Thread.sleep(10000);
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_content_CMS, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_content_CMS).click();
				Thread.sleep(5000);
		
					//ignore
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
						
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				Verify.action().verifyElementPresent(locators.exts().Select_page("Alloy Meet"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Meet")).click();
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
		
		
			
			try {
		BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{
				
	    	
			assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_version_name("GlobalLinkuser"), 10);
			if(assertion == false){
				report("f"," assertion is failed while verifying Scheduler User");
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
