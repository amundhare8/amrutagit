package GL_AddonConfiguration_DatabaseCleanupTab;

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
* Test case     : Verify validations for �Password provided by Translations.com� text field on GlobalLink Config page for Database Cleanup tab.
* 
* Summary 		: This test case verifies clean DB functionality.
*
*******************************************************************************************************************************************************************/



public class EPI_979519 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_979519";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979519");
		dataSet.put("TL_test_case_description","EPI_979519: Verify validations for �Password provided by Translations.com� text field on GlobalLink Config page for Database Cleanup tab.");
		dataSet.put("TL_internal_testCase_ID", "979519");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Database Cleanup");
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_allsubmissions_active_history).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_allsubmissions_active_history).click();
				}
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Globalink_DB_password_input,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).sendKeys(EPiServer_Common_Properties_Cred.DBcleanup_password);
				Thread.sleep(1000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Globallink_DB_clean_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globallink_DB_clean_button).click();
				Thread.sleep(1000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().alert().accept();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Globallink_DB_all_active_submissions_keep_history,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying All active submissions only (keep history)");
				}
				
				//
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_all_active_submissions_only).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_all_active_submissions_only).click();
				}
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Globalink_DB_password_input,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).sendKeys("CLEAN_pdpassword");
				Thread.sleep(1000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Globallink_DB_clean_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globallink_DB_clean_button).click();
				Thread.sleep(1000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().alert().accept();
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
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().Globallink_DB_password_incorrect,  15);
			if(assertion == false){
				report("f"," assertion is failed while verifying Incorrect password");
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
