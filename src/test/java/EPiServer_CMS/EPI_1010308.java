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
	
	/**===========================================================================================
	 * @author       : Amrata M.
	 * Test case     : Verify validation messages on GlobalLink Config page for Other settings tab
     * Test Id       : 1010308
     * Summary   	 : This test case verifies the validations of Other settings tab
	 *
	 ===========================================================================================*/

	public class EPI_1010308 {
		
		Boolean assertion = true;
		LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

		@BeforeMethod	
		public void setUp() throws Exception{
			BrowserFactory.SystemEngine().startApplication("EPI_1010308");
			          //  Test case description here
					dataSet.put("TL_test_case_description","1010308:Verify validation messages on GlobalLink Config page for Other settings tab");
					dataSet.put("TL_internal_testCase_ID", "1010308");
		}	
			public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
				try{
					
					
					General.action().login();
					Thread.sleep(2000);
					
					//GlobalLink Other Setting tab
					common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
					//Inside tab
					common.action().Inside_Other_Setting_Tab("GlobalLinkuser","Immediately", "Documents","DEBUG");		
					
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
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_saved,  15);
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
