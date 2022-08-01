package GL_AddonConfiguration_GlobalLink_Locale_Mapping_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Alert;
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
* Author        : Amrata M.
*
* Test case     : Verify delete existing locale on GlobalLink Config page from 'Local mapping' tab
* Preconditions : This test case verifies deleting existing locale on GlobalLink Config page from "Local Mapping"tab
***********************************************************************************************/
public class EPI_979487 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979487");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979487:Verify delete existing locale on GlobalLink Config page from 'Local mapping' tab");
				dataSet.put("TL_internal_testCase_ID", "979487");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink locale mapping
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Locale mapping");
				
				//FOR French
				 if(Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("français (France) (fr-FR)"), 5)) {
						  
						  BrowserFactory.SystemEngine().findElement(locators.exts().CMS_locale_mapping_verify_lang_present("français (France) (fr-FR)")).click();
						  Thread.sleep(3000);
						  BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Localemapping_delete_button).click();
						  Thread.sleep(3000);
						
						 
							Alert alert= BrowserFactory.driver.switchTo().alert();
							alert.accept();
						 
							Thread.sleep(5000);
				}
		
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("fr-FR"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("fr-FR")).click();;
				Thread.sleep(2000);
						
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("fr-FR"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("fr-FR")).click();;
				Thread.sleep(2000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Source_Locale).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Source_Locale).click();
				}
				Thread.sleep(3000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Target_Locale).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Target_Locale).click();
				}
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).sendKeys(EPiServer_Common_Properties_Cred.Recipients);
				Thread.sleep(3000);
				
			
				//Add button
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_add_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_add_button).click();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).clear();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("français (France) (fr-FR)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}
				
		
				}catch(Throwable e){
				report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				}
			}

		@Test
		public void execute() throws Exception{
			testcase(dataSet);
			assertion();
		
		}
		public void assertion() throws Exception{
			
			try{	
				
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}
		
					}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
			}
		
			
			
		@AfterMethod
		public void tearDown() throws Exception{
		
		BrowserFactory.quitBrowser();
		}
					

			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
			
			
}
