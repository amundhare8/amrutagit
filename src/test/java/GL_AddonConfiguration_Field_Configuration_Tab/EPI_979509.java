package GL_AddonConfiguration_Field_Configuration_Tab;

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

/***********************************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify Synchronize functionality for all available ‘Content Types’ with all supported fields un-checked as ‘Translatable’ on GlobalLink Config page for field configuration tab
* 
* Summary   	: This test case verifies the field configuration functionality..
* 
**************************************************************************************************************************************************************************************************/
public class EPI_979509 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_979509_t";

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979509");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979509:Verify Synchronize functionality for all available ‘Content Types’ with all supported fields un-checked as ‘Translatable’ on GlobalLink Config page for field configuration tab");
				
				dataSet.put("TL_internal_testCase_ID", "979509");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				
				//GlobalLink Field Config Tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Field");
				
				//Inside Field Config Tab
				common.action().Inside_FieldConfigTab("Stan", "22");
				
				//Inside Field Config Tab
				common.action().Inside_FieldConfigTab(true, true, true, true, false);
				
				//Clk sync button
				BrowserFactory.SystemEngine().findElement(locators.exts().Field_Configuration_Synchronise_Button).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				//Create Page Method
				common.action().create_NewPageSubmitJob("New Page","Standard Page",PageName,"Alloy - collaboration,","Alloy Plan, Alloy Meet, Alloy Track, distance collaboration,","Alloy solves the two most pressing problems in long distance collaboration","None");
		  
				//Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
			
				//go to dashborad Button
				common.action().Go_To_DashBorad_Button();
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
					
				//Edit and new page Create
				common.action().create_NewPageSelect("Edit", PageName);
				
				//
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(5000);
				
				//CMS_edit_submission_SEO
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_SEO, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_SEO).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title_de, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Title");
							
		    	}
		    	
		    	assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Keyword");
							
		    	}
		    	assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Page Description");
							
		    	}		    	
		    	//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);				
				
				 JavascriptExecutor js2 = (JavascriptExecutor) BrowserFactory.driver; 
				 js2.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
				 Thread.sleep(2000);
				    
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
		
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
			Thread.sleep(2000);
			
			
			try {
		BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{
				
	    	//teaser Body
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
			Thread.sleep(7000);
	    	assertion=Verify.action().verifyTextPresent("This is content teaser Main Body", 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Main Body");
						
	    	}
	    	BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);
				
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText, 10);			
	    	if(assertion == false){
				report("f"," assertion is failed while verifying TeaserText");
						
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
