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
import locators.locators;

/**===========================================================================================
 * @author       : Amrata M.
 * Test case     : Verify validation messages on GlobalLink Config for Export/Import
 * Test Id       : 1010336
 * Summary   	 : This test case verifies the validations messages on GLobalLink Config page for Export/Import tab
 *
 ===========================================================================================*/

public class EPI_1010336 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010336");
		          //  Test case description here
				dataSet.put("TL_test_case_description","1010336: Verify validation messages on GlobalLink Config for Export/Import");
				dataSet.put("TL_internal_testCase_ID", "1010336");
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
				
                 //GlobalLink Export/Import Tab
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_Settings_Tab("Export/Import"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_Settings_Tab("Export/Import")).click();;
				Thread.sleep(3000);
				
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Property_Import_Excludes).sendKeys("GlobalLink");
				Thread.sleep(3000);
				
							
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Copy_properties_from_SelectOptions("Source")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Copy_Name_in_URLselectOption("From source")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_translatable_fields_selectOption("Create copy from source")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_source_content_selectOption("Cancel it")).click();
				Thread.sleep(3000);
				
			
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Default_status_selectOption("Primary Draft")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_xhtml_import_fails_selectOption("Skip")).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_ExpportTab_Save_Import_Export_Settings).click();
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
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_ExpportTab_Save_changees,  15);
			if(assertion == false){
				report("f"," assertion is failed while verifying message");
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
