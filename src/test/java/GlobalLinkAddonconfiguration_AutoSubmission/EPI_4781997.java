package GlobalLinkAddonconfiguration_AutoSubmission;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
* Test case     : Verify "Submission Name Prefix" option on Auto Submission Tab.
* 

* Summary 		: This test case Verify "GL Project" field and it's values on Auto Submission Tab
*
*******************************************************************************************************************************************************************/


public class EPI_4781997 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4781997");
		dataSet.put("TL_test_case_description","EPI_4781997 : Verify \"Submission Name Prefix\" option on Auto Submission Tab.");
		dataSet.put("TL_internal_testCase_ID", "4781997");
				
			
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
				
				//Prefix
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Prefix, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).clear();				
				while(!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).getAttribute("value").equals(""))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys(Keys.BACK_SPACE);
				}
			
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Prefix).sendKeys("Auto_");
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
		    	common.action().GO_TO_EDIT_AutoSubmission("Edit", "Alloy Meet");
		    	
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				//Notification_Bell
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
							
				assertion=Verify.action().verifyElementPresent(locators.exts().Edit_Notification_msg, 5);
				String gl_MsgStatus=BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Notification_msg).getText();
			    System.out.println("Globalink Submission ID is========>>"+gl_MsgStatus);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying Sent");
				}
				
				//click
				WebElement element= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.driver;
			    executor.executeScript("arguments[0].click();", element);
				Thread.sleep(3000);
				
				
				//Inside Dashboard --ID
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_PD=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
			    System.out.println("Globalink Submission ID is========>>"+globalink_PD);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Submission ID");
				}
				
				
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
				}
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
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
