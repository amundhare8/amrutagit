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
 * @author       : amundhare
 * Test case     : Verify validation messages on GlobalLink Config page for Verify version of GlobalLink Adaptor
 * Test Id       : 1010326
 * Summary   	 : Verify version of GlobalLink Adaptor
 *
 ===========================================================================================*/


public class EPI_1010326 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010326");
		          //  Test case description here
				dataSet.put("TL_test_case_description","1010326: Verify version of GlobalLink Adaptor");
				dataSet.put("TL_internal_testCase_ID", "1010326");
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
								
				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_plug_in_manager,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_plug_in_manager).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				
                 //GlobalLink Wizard Settings Tab
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_Settings_Tab("Plug-ins"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_Settings_Tab("Plug-ins")).click();;
				Thread.sleep(3000);
				
				//Inside tab////table[@class="epi-default"]/tbody/tr[3]/td[3]
			
				String globalink_Version=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Config_Plugin_Manager).getText();
			    System.out.println("Globalink Version is========>>"+globalink_Version);
			    				
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
		try{  assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Config_Plugin_Manager,  15);	
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
