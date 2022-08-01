package EPiServer_Scripts.Dashboard;

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

/******************************************************************************************************************************************************************
* Author        :   Amrata M.
*
* Test case     :	Verify Naviation to Dashboard from episerver notifications

* Summary 		:   This test case verifies the Navigation from EPiServer Notifications
* 
*******************************************************************************************************************************************************************/

public class EPI_979468 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979468";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979468");
		dataSet.put("TL_test_case_description","EPI_979468: Verify Naviation to Dashboard from episerver notifications");
		dataSet.put("TL_internal_testCase_ID", "979468");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission			
				common.action().create_basic_submission("Alloy Meet",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(10000);
				
				//CMS
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin).click();
				Thread.sleep(5000);

				//EDIT
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin_Edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin_Edit).click();
				Thread.sleep(7000);
				
				
				//notification Bell
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
				WebElement element= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.driver;
			    executor.executeScript("arguments[0].click();", element);
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(3000);

				
				//GlobalLink_Dashboard
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(7000);
				
				//Run Schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
								
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
							
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
				WebElement element1= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor1 = (JavascriptExecutor) BrowserFactory.driver;
			    executor1.executeScript("arguments[0].click();", element1);
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(3000);

				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(7000);
				
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
				
				//Target Language
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Target_language, 10);
				String globalink_Target=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Target_language).getText();
			    System.out.println("Globalink Target Language is========>>"+globalink_Target);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Target Language");
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
				assertion=common.action().verify_submission_Status(SubName, "Published");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
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
