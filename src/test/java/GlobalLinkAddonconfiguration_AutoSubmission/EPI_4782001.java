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
* Test case     : Verify "Reference depth" field on Auto Submission Tab.
* 

* Summary 		: This test case is to Verify "Reference depth" field on Auto Submission Tab

* Precondition  :  From Auto Submission tab -> Check blocks and pages from 'Include referenced content'
*
*******************************************************************************************************************************************************************/


public class EPI_4782001 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	public String OriginalpageName="Alloy Track";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4782001");
		dataSet.put("TL_test_case_description","EPI_4782001 : Verify \"Reference depth\" field on Auto Submission Tab.");
		dataSet.put("TL_internal_testCase_ID", "4782001");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission")).click();
				Thread.sleep(1000);
				
			
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				

				//AutoSubmission_Blocks
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Blocks, 5);
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Blocks).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Blocks).click();
				}
				
				//AutoSubmission_Pages
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Pages, 5);
				if (BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Pages).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Pages).click();
				}
				

				//ReferenceDepth
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_ReferenceDepth, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).clear();
				
				while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).getAttribute("value").equals(""))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys(Keys.BACK_SPACE);
				}
			
				
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys("0");
				Thread.sleep(2000);
			
				
				//AutoSubmission_Save
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Auto submission is saved");
							
		    	}
		    	//AutoSubmit the pg		    	
		    	common.action().GO_TO_EDIT_AutoSubmission("Edit",OriginalpageName);
				//Dashboard
				common.action().Go_To_DashBorad_Button();
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_ContentType("Page"),5);
				if(assertion == false){
					report("f"," assertion is failed while verifying verifying Auto submission Status");							
		    	}
				
		    	//
				// Click on global link config
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Globallink_config, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Globallink_config).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
				Thread.sleep(1000);
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission")).click();
				Thread.sleep(1000);
				
			
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				

				//AutoSubmission_Blocks
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Blocks, 5);
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Blocks).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Blocks).click();
				}
				
				//AutoSubmission_Pages
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Pages, 5);
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Pages).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Pages).click();
				}
				

				//ReferenceDepth
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_ReferenceDepth, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).clear();
				
				while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).getAttribute("value").equals(""))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys(Keys.BACK_SPACE);
				}
			
				
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys("2");
				Thread.sleep(2000);
			
				
				//AutoSubmission_Save
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Auto submission is saved");
							
		    	}
		    	//AutoSubmit the pg		    	
		    	common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);				
				
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(OriginalpageName)).click();
				Thread.sleep(5000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementNotPresent(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem).click();
				Thread.sleep(3000);
				
				//OK
				Verify.action().verifyElementNotPresent(locators.exts().CMS_MAinbody_OK,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MAinbody_OK).click();
				Thread.sleep(3000);
				//Dashboard
				common.action().Go_To_DashBorad_Button();
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_ContentType("Page"),5);
				if(assertion == false){
					report("f"," assertion is failed while verifying verifying Auto submission Status");							
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
	    		report("f"," assertion is failed while verifying  Target Language");						
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
