package EPiServer_CMS;

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
* Author        : Mayureshwar
*
* Test case     : Verify validation messages on GlobalLink Config page for Locale mapping tab
* Test Id       : 1010307
* Summary   	: This test case verifies the validations messages on GLobalLink Config page for Locale Mapping tab
***********************************************************************************************/
public class EPI_1010307 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010307");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010307:Verify validation messages on GlobalLink Config page for Locale mapping tab");
				dataSet.put("TL_internal_testCase_ID", "1010307");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink locale mapping
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Locale mapping");
				
				//select source and target lanugae
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list).click();
				Thread.sleep(3000);
						
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("sv"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("sv")).click();;
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list).click();
				Thread.sleep(3000);
						
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("en-US"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("en-US")).click();;
				Thread.sleep(2000);


				//Add button
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_add_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_add_button).click();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("svenska (sv)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}

				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("English(United States) (en-US)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}

				//For DELETE
				
				
				  if(Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("svenska (sv)"), 5)) {
					  
					  BrowserFactory.SystemEngine().findElement(locators.exts().CMS_locale_mapping_verify_lang_present("svenska (sv)")).click();
					  Thread.sleep(3000);
					  BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Localemapping_delete_button).click();
					 Thread.sleep(3000);
					
					 Alert alert= BrowserFactory.driver.switchTo().alert();
					 alert.accept();
					 
					Thread.sleep(5000);
						
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
			assertion=Verify.action().verifyElementNotPresent(locators.exts().CMS_locale_mapping_verify_lang_present("svenska (sv)"),  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying Locale Mapping Language");
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
