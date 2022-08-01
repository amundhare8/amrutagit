package EpiServer_Notifications;

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
* Author        : Amrata M.
*
* Test case     : Verify EPiServer notification for imported job
* 
* Summary 		: This test case verifies the functionality of EPiServer notification for imported job
* 
*******************************************************************************************************************************************************************/

public class EPI_979451 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979451-T";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979451");
		dataSet.put("TL_test_case_description","EPI_979451: Verify EPiServer notification for imported job");
		dataSet.put("TL_internal_testCase_ID", "979451");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				
				//Create Submission			
				common.action().create_basic_submission("Alloy Plan",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "None");
				Thread.sleep(10000);
				
				//dashboard cms-edit
				common.action().Go_To_DashBorad_CmsEdit("Edit");
				Thread.sleep(20000);
				 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(20000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(15000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(10000);
				
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Edit_Notification_msg, 5);
				String gl_MsgStatus=BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Notification_msg).getText();
			    System.out.println("Globalink Job status is========>>"+gl_MsgStatus);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying Sent");
				}
				
				
				//click
				WebElement element= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.driver;
			    executor.executeScript("arguments[0].click();", element);
				Thread.sleep(3000);
				
				//dashboard Button
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
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
				
				//Target Language
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Target_language, 10);
				String globalink_Target=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Target_language).getText();
			    System.out.println("Globalink Target Language is========>>"+globalink_Target);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Target Language");
				}
				
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
				
			
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
							
				//Notification Bell 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
							
				WebElement element1= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor1 = (JavascriptExecutor) BrowserFactory.driver;
			    executor1.executeScript("arguments[0].click();", element1);
				Thread.sleep(3000);
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status1);
			    
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
			assertion=common.action().verify_submission_Status(SubName, "Imported");		
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
