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
* Test case     : Verify "Enable Automated Submission Creation" option Checked.
* 

* Summary 		: This test case is to verify the Due Date Save Error for Auto Submission
*
*******************************************************************************************************************************************************************/


public class EPI_4781994 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4781994");
		dataSet.put("TL_test_case_description","EPI_4781994 : Verify Enable Automated Submission Creation option Checked.");
		dataSet.put("TL_internal_testCase_ID", "4781994");
				
			
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
				//AutoSubmission_Save
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Auto submission is saved");
							
		    	}
		    	
		    	// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Track")).click();
				Thread.sleep(5000);
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
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
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem,5);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Auto Submit Current Item option under GLTranslation Jobs gadget");							
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
			
			public void Test_Msg(Boolean Submission_Creation,String SourceLang,String TargetLang,String Prefix,String PostTranslation) throws Exception{
				
				if (Submission_Creation==true)
					
				{
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				Thread.sleep(2000);
				}
				if (Submission_Creation==false)
					
				{
				if (BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
			
				}
				
			
			
			//AutoSubmission_GLprojClick
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_GLprojClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_GLprojClick).click();
			Thread.sleep(2000);
			
			//AutoSubmission_GLprojClick
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_GLprojClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_GLprojClick).click();
			Thread.sleep(2000);
			
			
			//Source Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_SourceLangClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_SourceLangClick).click();
			Thread.sleep(2000);
			
			//Source  Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_SourceLang(SourceLang), 25);//English (en)
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_SourceLang(SourceLang)).click();
			Thread.sleep(2000);
			
			//Target Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_TargetLangClick, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_TargetLangClick).click();
			Thread.sleep(2000);
			
			//Target Lang click
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_TargetLang(TargetLang), 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_TargetLang(TargetLang)).click();
			Thread.sleep(2000);
			
			//date
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_DueDate, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).clear();
	          while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).getAttribute("value").equals(""))
	                     {
	        	  BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).sendKeys(Keys.BACK_SPACE);
	                     }
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_DueDate).sendKeys("+5d");
			Thread.sleep(2000);
			
			//Prefix
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Prefix, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).clear();				
			while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).getAttribute("value").equals(""))
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Keys.BACK_SPACE);
			}
		
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Prefix);//Auto_
			Thread.sleep(2000);
			
			
			//ReferenceDepth
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_ReferenceDepth, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).clear();
			
			while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).getAttribute("value").equals(""))
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys(Keys.BACK_SPACE);
			}
		
			
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys("1");
			Thread.sleep(2000);
			
			//AutoSubmission_PostTranslationAction
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationAction, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationAction).click();
			Thread.sleep(2000);
			
			//AutoSubmission_PostTranslationAction
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationActionSelect(PostTranslation), 25);//Create EPiServer Project For Approval
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationActionSelect(PostTranslation)).click();
			Thread.sleep(2000);
			
			//AutoSubmission_Save
			Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
			Thread.sleep(5000);
			}
			
			
			
}
