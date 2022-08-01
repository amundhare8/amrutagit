package EpiServer_SubmissionWizard;

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
import locators.locators;//

/******************************************************************************************************************************************************************
* Author        :   Amrata M.
*
* Test case     :	Verify post translation action drop down on submission wizard

* Summary 		: 	This test case verifies the post translation action drop down on submission wizard
* 
*******************************************************************************************************************************************************************/
public class EPI_979444 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979444";
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979444");
		dataSet.put("TL_test_case_description","EPI_979444: Verify post translation action drop down on submission wizard");
		dataSet.put("TL_internal_testCase_ID", "979444");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
			
				//create Submission--None
				common.action().create_basic_submission("Alloy Meet",SubName, true, false, false, false, false, true, "5", false, false, true, true, true, "None");
				Thread.sleep(6000);
				
				//run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy(1,1);
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(5000);
							
			
				
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
				//Notification Bell 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
						
				WebElement element1= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor1 = (JavascriptExecutor) BrowserFactory.driver;
			    executor1.executeScript("arguments[0].click();", element1);
				Thread.sleep(3000);
				
				// Click on Dashborad
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
				Thread.sleep(2000);
						
				assertion=common.action().verify_submission_Status(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status");
				}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//dashboard cms-edit
				common.action().Go_To_DashBorad_CmsEdit("Edit");
				Thread.sleep(15000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_toggle_pin_button).click();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(1000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(2000);
								
				
				//create Submission--AutoPublish
				common.action().create_basic_submission("Alloy Track",SubName, true, false, false, false, false, true, "5", false, false, true, true, true, "Auto Publish");
				Thread.sleep(8000);
				
				//run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy(2,1);
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
							
				//ignore
				
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
				//Notification Bell 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
							
				WebElement element2= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor2 = (JavascriptExecutor) BrowserFactory.driver;
			    executor2.executeScript("arguments[0].click();", element2);
				Thread.sleep(3000);
				
				// Click on Dashborad
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
				Thread.sleep(2000);
						
				assertion=common.action().verify_submission_Status(SubName, "Published");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status");
				}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//dashboard cms-edit
					common.action().Go_To_DashBorad_CmsEdit("Edit");
					Thread.sleep(15000);
								
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_toggle_pin_button).click();
					Thread.sleep(2000);
								
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.navigate().refresh();
					Thread.sleep(1000);
								
								
					Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
					Thread.sleep(2000);
												
								
					//create Submission--Create EPiServer Project For Approval
					common.action().create_basic_submission("Alloy Plan",SubName, true, false, false, false, false, false, "5", false, false, true, true, true, "Create EPiServer Project For Approval");
					Thread.sleep(8000);
					
					
					//run schedular
					common.action().run_schedular();
					common.action().verify_RunSchedulerHistroy(1,1);
								
					//Edit
					Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
					Thread.sleep(7000);
											
					//ignore
								
					if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
					{
						BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
						Thread.sleep(1000);
					}
					//Notification Bell 
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
					Thread.sleep(5000);
								
											
					WebElement element3= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
					BrowserFactory.SystemEngine();
					JavascriptExecutor executor3 = (JavascriptExecutor) BrowserFactory.driver;
					executor3.executeScript("arguments[0].click();", element3);
					Thread.sleep(3000);
								
					// Click on Dashborad
					Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
					Thread.sleep(2000);
										
					assertion=common.action().verify_submission_Status(SubName, "Imported");		
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
		
	    	if(assertion == false){
	    		report("f"," assertion is failed while verifying submission Status");
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
