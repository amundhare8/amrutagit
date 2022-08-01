package EPiServer_Scripts.Dashboard;


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
* Author        : Amrata M.
*
* Test case     : Verify drill down on submission name to reveal job details
* Preconditions : This test case verifies the functionality of drill down on submission name to reveal job details
***********************************************************************************************/


public class EPI_979473 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod		
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979473");

		// Write you Test case description here
				dataSet
				.put("TL_test_case_description","EPI_979473:Verify sorting feature on Dashboard columns");
				dataSet.put("TL_internal_testCase_ID", "979473");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);

				
				
				//go to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row).click();
				Thread.sleep(5000);
				
				
				
				//Verify Content Name
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Content, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Content).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Content, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Content).click();
				Thread.sleep(3000);
				
				
				//Verify Content Type
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Content_type, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Content_type).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Content_type, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Content_type).click();
				Thread.sleep(3000);
				
				
				//Verify Target Language
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Target_Language, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Target_Language).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Target_Language, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Target_Language).click();
				Thread.sleep(3000);
				
				
				//Verify Status
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Status, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Status).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Status, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Status).click();
				Thread.sleep(3000);
				
				//Verify Translated
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated).click();
				Thread.sleep(3000);
				
				
				//Verify Translated
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Translated).click();
				Thread.sleep(3000);
				
				//Verify Published
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Published, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Published).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_table_row_Header_Published, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_table_row_Header_Published).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Back_Button, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Back_Button).click();
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
		
			BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{	
			if(assertion == false){
				report("f"," assertion is failed while verifying paging");
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
