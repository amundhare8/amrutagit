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
* Test case     : Verify version of GlobalLink Adaptor
* Test Id       : C1010305
* Summary   	: This test case verifies the version of GlobalLink Adaptor when installed on:
* 				- CMS Only instance
* 				- CMS + Commerce instance (Quicksilver)
* Precondition  : GLEPI adaptor should be installed on CMS / Commerce instance.
***********************************************************************************************/
public class EPI_1010305 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010305");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010305:Verify version of GlobalLink Adaptor");
				dataSet.put("TL_internal_testCase_ID", "1010305");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
					
				General.action().login();
				Thread.sleep(2000);
				
			
				common.action().Go_to_GlobalLink_Admin_Configtabs("Admin", "Config");
				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_plug_in_manager,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_plug_in_manager).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
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
			assertion=Verify.action().verifyElementPresent(locators.exts().verify_plugIn_version("GlobalLink Adaptor",EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 30);
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
