package EPiServer_Commerce;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar 
*
* Test case     : Verify validation messages on GlobalLink Config page for Locale mapping tab
* Test Id       : 1010328
* Summary   	: This test case verifies the validations messages on GLobalLink Config page for Locale Mapping tab
***********************************************************************************************/
public class EPI_1010328 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010328");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010328:Verify validation messages on GlobalLink Config page for Locale mapping tab");
				dataSet.put("TL_internal_testCase_ID", "1010328");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Config"),  25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Config")).click();
				Thread.sleep(2000);
								
				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				

			//GlobalLink locale mapping
				
				//Dashboard configuration
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping")).click();;
				Thread.sleep(3000);

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
						
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("ab"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("ab")).click();;
				Thread.sleep(2000);


				//Add button
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_add_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_add_button).click();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_Verifylanguage("5", "svenska (sv)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}

				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_Verifylanguage("5", "Abkhazian (ab)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}

				Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_selectlanguage("5"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_locale_mapping_selectlanguage("5")).click();
				Thread.sleep(3000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Localemapping_delete_button).click();
				Thread.sleep(3000);

				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
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
			assertion=Verify.action().verifyElementNotPresent(locators.exts().CMS_locale_mapping_Verifylanguage("5", "svenska (sv)"),  5);	
			if(assertion == false){
				report("f"," assertion is failed while verifying GlobalLinkAdaptor_Version");
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
