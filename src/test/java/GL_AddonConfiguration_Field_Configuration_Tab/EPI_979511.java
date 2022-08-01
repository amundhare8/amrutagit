package GL_AddonConfiguration_Field_Configuration_Tab;

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
* Author        : Amundhare
*
* Test case     : Verify 'Content Types' drop down displays all values in alphabetical order
* Summary   	: This test case verifies the alphabetical order if Content types
***********************************************************************************************/
public class EPI_979511 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979511");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979511: Verify 'Content Types' drop down displays all values in alphabetical order");
				dataSet.put("TL_internal_testCase_ID", "979511");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
								
				//GlobalLink Field Config Tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Field");								
				//Inside Field Config Tab
				common.action().Inside_FieldConfigTab("Ima", "29");
				BrowserFactory.SystemEngine().findElement(locators.exts().Field_Configuration_Synchronise_Button).click();
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
				
				Verify.action().verifyElementPresent(locators.exts().Field_Configuration_Synchronise_table_imagefile,  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying Synchronise");
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
