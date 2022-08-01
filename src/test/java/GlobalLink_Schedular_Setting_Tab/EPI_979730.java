package GlobalLink_Schedular_Setting_Tab;

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
* Test case     : Verify un-select checkbox �Active� is getting save on GlobalLink Scheduler page for settings tab
* 
* Summary 		: This test case verifies Verify save option
*
*******************************************************************************************************************************************************************/

public class EPI_979730 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979730");
		dataSet.put("TL_test_case_description","EPI_979730: Verify un-select checkbox �Active� is getting save on GlobalLink Scheduler page for settings tab.");
		dataSet.put("TL_internal_testCase_ID", "979730");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//go to GL Schedular
				common.action().Go_to_GlobalLink_Admin_GLSchedular("Admin","Admin");
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
					
				}
				Thread.sleep(2000);
				 
				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_Button,10);
				 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Save_Button).click();
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
			
			if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected() )
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
				
			}
			Thread.sleep(2000);
			 
			 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_Button,10);
			 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Save_Button).click();
			 Thread.sleep(5000);
			 
			 
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public void assertion() throws Exception{
			try{
				assertion= BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval).isEnabled();
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Job interval is Enabled");
							
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
