package EpiServer_GlobalLink_Addon_Configuration;

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
* Author        :   Amrata M.
*
* Test case     :	Show Adaptor Version Number in GL Configuration Settings

* Summary 		: 	This tc is to verify that the Adapter version should be displayed in the GlobalLink Config
* 
*******************************************************************************************************************************************************************/

public class EPI_3409746 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_3409746");
		dataSet.put("TL_test_case_description","EPI_3409746: Show Adaptor Version Number in GL Configuration Settings");
		dataSet.put("TL_internal_testCase_ID", "3409746");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Settings
				common.action().Go_to_Globalink_config();
					
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}
				
				//Locale mapping
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}
				
				//Other Setting Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}		
				
				

				//Field configuration
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Field configuration"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Field configuration")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				
				

				//Database Cleanup Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Database Cleanup"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Database Cleanup")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				
				

				//Notification Setting Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				

				//Wizard Setting Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				
				//Scheduler Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Scheduler")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				
				//Export/Import Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
		    	}	
				
				//Dashboard configuration
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Dashboard configuration"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Dashboard configuration")).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Addon_Configuration(EPiServer_Common_Properties_Cred.GlobalLinkAdaptor_Version), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");					
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
			if(assertion == false){
				report("f"," assertion is failed while verifying Adaptor Version Number in GL Configuration Settings");						
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
