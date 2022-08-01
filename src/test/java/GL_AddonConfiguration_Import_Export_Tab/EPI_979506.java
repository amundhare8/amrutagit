package GL_AddonConfiguration_Import_Export_Tab;
import static org.testng.Assert.assertTrue;
import java.util.LinkedHashMap;
import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
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

/***********************************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify status for imported submissions when ‘Ready to Publish’ value configured for field ‘Default status on importing’ on GlobalLink Config page
* 
* Summary   	: This test case verified the status of imported pages on various config setting.
* 
* Precondition  : Auto Publish feature should be unchecked while sending the page for translation

***********************************************************************************************************************************************************************************************/
public class EPI_979506 {
	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_979506";
	String actualTooltip="";
	@BeforeMethod
	public void setUp() throws Exception{
		
		BrowserFactory.SystemEngine().startApplication("EPI_979506");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_979506: Verify status for imported submissions when ‘Ready to Publish’ value configured for field ‘Default status on importing’ on GlobalLink Config page.");
				dataSet.put("TL_internal_testCase_ID", "979506");
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
				common.action().Inside_ExportImportTab_Functionality("GlobalLink", "Source", "From source", "Create copy from source", "Cancel it", "Ready to Publish", "Skip","From published target");
							
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
								
				//
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(2000);
				
				//CMS_edit_submission_SEO
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_SEO, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_SEO).click();
				Thread.sleep(2000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Page Description");
							
		    	}                                            
		    	assertion=Verify.action().VerifyCompare_Text("Alloy solves the two most pressing problems in long distance collaboration","Alloy solves the two most pressing problems in long distance collaboration");
			
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Meta Description");							
		    	}		    	
		    	//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);				
				
				 JavascriptExecutor js2 = (JavascriptExecutor) BrowserFactory.driver; 
				 js2.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
				 Thread.sleep(2000);
				    
				 assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText, 10);
			    if(assertion == false){
				report("f"," assertion is failed while verifying TeaserText");								
			    }
			    	
			    Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
				Thread.sleep(2000);	
				
				
				 WebElement primary_Draft = BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Gl_Primary_version_draft);				           
			     actualTooltip = primary_Draft.getAttribute("title");	
			        
			      //Assert the tooltip's value is as expected 		
			      System.out.println("Actual Title of Tool Tip"+ actualTooltip);
			      assertion=Verify.action().verifyTextNotPresent(actualTooltip, 10);
			      if(assertion == false){
					report("f"," assertion is failed while verifying Primary Draft Version");
								
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
			
			////Export/Import Tabs
			common.action().Go_to_Globalink_config();
			
			//GlobalLink Export/Import
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Export/Import")).click();
			Thread.sleep(1000);
			
			//Inside GlobalLink Export/Import
			common.action().Inside_ExportImportTab_Functionality("GlobalLink", "Source", "From source", "Create copy from source", "Cancel it", "Primary Draft", "Skip","From published target");
			
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().Edit_Gl_ReadyPublish, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying 'Ready to Publish' on Dashboard");
						
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
