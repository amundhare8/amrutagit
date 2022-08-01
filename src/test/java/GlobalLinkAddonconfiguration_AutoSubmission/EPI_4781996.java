package GlobalLinkAddonconfiguration_AutoSubmission;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Keys;
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
* Test case     : Verify "GL Project" field and it's values on Auto Submission Tab.
* 

* Summary 		: This test case Verify "GL Project" field and it's values on Auto Submission Tab
*
*******************************************************************************************************************************************************************/


public class EPI_4781996 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4781996");
		dataSet.put("TL_test_case_description","EPI_4781996 :Verify \"GL Project\" field and it's values on Auto Submission Tab.");
		dataSet.put("TL_internal_testCase_ID", "4781996");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Auto Submission Tab
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission")).click();
				Thread.sleep(1000);
				
			
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				
				assertion= Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Prefix, 25);
				if(assertion == false){
					report("f"," assertion is failed while verifying Auto Submission Prefix");							
		    	}
				
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).clear();				
				while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).getAttribute("value").equals(""))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Keys.BACK_SPACE);
				}
			
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys("Auto_");
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);				
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
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
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Auto submission is saved");
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
