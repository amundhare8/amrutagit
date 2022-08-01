package GL_AddonConfiguration_Import_Export_Tab;

import static org.testng.Assert.assertTrue;
import java.util.LinkedHashMap;
import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
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
* Test case     : Verify status for imported submissions when ‘Primary Draft’ value configured for field ‘Default status on importing’ on GlobalLink Config page
* 
* Summary 		: This test case verifies the status for imported submissions when ‘Primary Draft’ value configured for field ‘Default status on importing’ on GlobalLink Config page.

* Preconditions : Auto Publish feature should be unchecked while sending the page for translation

Primary Draft: The primary draft is the draft presented in edit view, when accessing the content. Multiple drafts may exist, by default the latest saved edited version is the primary draft.
Use the Set as Primary Draft option in the version list to make another draft the primary one.
*******************************************************************************************************************************************************************/


public class EPI_979507 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979507";
	String PageName = "Epi_979507";
	String ProjectName= "EPiServer";
	String actualTooltip="";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979507");
		dataSet.put("TL_test_case_description","EPI_979507: Verify status for imported submissions when ‘Primary Draft’ value configured for field ‘Default status on importing’ on GlobalLink Config page");
		dataSet.put("TL_internal_testCase_ID", "979507");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//Move to GL Config				
				common.action().Go_to_Globalink_config();
				
				//GlobalLink Export/Import
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import")).click();
				Thread.sleep(1000);
				
				//Inside GlobalLink Export/Import
				common.action().Inside_ExportImportTab_Functionality("GlobalLink", "Source", "From source", "Create copy from source", "Cancel it", "Primary Draft", "Skip","Dont copy");
							
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_ExpportTab_Save_changees,  15);
				if(assertion == false){
					report("f"," validation messages on GlobalLink Config for Export/Import");
				}
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
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
				
				//Move to Edit and Page
				common.action().create_NewPageSelect("Edit", PageName);				
				//DE-de
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(2000);				
				//teaser Body
				BrowserFactory.SystemEngine();
				
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
				Thread.sleep(5000);
		    	assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Main Body");
							
		    	}
		    	BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(4000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);				
				//teaser Main  Body
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
				Thread.sleep(5000);						
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);			
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(" - This is Main Body Target .");				
				Thread.sleep(2000);					
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				//en-EN
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
				Thread.sleep(2000);	
				
				////
				//publish Arrow
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);				
				//publish  Button		
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
				Thread.sleep(2000);				
				//sub_create
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);				
				//CMS_new_job_languages_tab
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(1000);				
				//Target lang
				Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(3000);
				
				
				//tools				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
				Thread.sleep(7000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(4000);
				
				//Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
			
				//go to dashborad Button
				common.action().Go_To_DashBorad_Button();
		
				
				//edit
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
				Thread.sleep(1000);				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab("Edit"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab("Edit")).click();
				Thread.sleep(3000);				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(8000);
				
				
					//ignore
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
						
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				 WebElement primary_Draft = BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Gl_Primary_version_draft);				           
			     actualTooltip = primary_Draft.getAttribute("title");	
			        
			     //Assert the tooltip's value is as expected 		
			      System.out.println("Actual Title of Tool Tip"+ actualTooltip);
			        
			        
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
			assertion=Verify.action().verifyTextNotPresent(actualTooltip, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Primary Draft Version");
						
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
