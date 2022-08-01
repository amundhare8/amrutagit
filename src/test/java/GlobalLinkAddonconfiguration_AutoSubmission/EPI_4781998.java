package GlobalLinkAddonconfiguration_AutoSubmission;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
* Test case     : Verify "Blocks" option for "Include referenced content" field on Auto Submission Tab.
* 

* Summary 		: This test case is to verify Blocks" option for "Include referenced content" field on Auto Submission Tab
*
*******************************************************************************************************************************************************************/


public class EPI_4781998 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4781998");
		dataSet.put("TL_test_case_description","EPI_4781998 : Verify \"Blocks\" option for \"Include referenced content\" field on Auto Submission Tab.");
		dataSet.put("TL_internal_testCase_ID", "4781998");
				
			
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
			
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_ReferenceDepth).sendKeys("2");
				Thread.sleep(2000);
				//AutoSubmission_Pages
				
				
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
				
				//Block_togglepane
				Verify.action().verifyElementPresent(locators.exts().CMS_Edit_asset_togglepane, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_asset_togglepane).click();
				Thread.sleep(2000);
				
				//common.action().toggle_assects_pane_tree_icon(true);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_assetspane_toggle_close1).click();
				Thread.sleep(2000);
				
				Thread.sleep(4000);
				System.out.println("Hello");
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_Block("Alloy Plan")).click();
				Thread.sleep(5000);
				
				//Block_Page
				WebElement ele= BrowserFactory.SystemEngine().findElement(locators.exts().Block_Page);
				Actions act=new Actions(BrowserFactory.driver);
				act.doubleClick(ele).build().perform();			
				Thread.sleep(5000);
				
				
	
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementNotPresent(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem).click();
				Thread.sleep(3000);
				
				//CMS_MAinbody_OK
				Verify.action().verifyElementNotPresent(locators.exts().CMS_MAinbody_OK,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MAinbody_OK).click();
				Thread.sleep(3000);
				
				
				common.action().Go_To_DashBorad_Button();
					
				
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
				}
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_ContentType("Block"),5);
				if(assertion == false){
					report("f"," assertion is failed while verifying verifying Auto submission Status");							
		    	}
				
				////Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
				
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
							
				//Notification Bell 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
							
				WebElement element= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.driver;
			    executor.executeScript("arguments[0].click();", element);
				Thread.sleep(3000);
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);	    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
				
				
				assertion=common.action().verify_submission_Status(globalink_Jobname, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status");
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
		//	assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_ContentType,5);
			if(assertion == false){
				report("f"," assertion is failed while verifying verifying Auto submission Status");							
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
