package EPiServer_Commerce;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

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
import locators.locators;

/***********************************************************************************************
* Author        : Amundhare
*
* Test case     : Verify Submission listing on Dashboard
* Summary   	: This test case verifies submission listing and drill down feature on Dashboard landing page.
***********************************************************************************************/
public class EPI_1480488 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();


	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1480488");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_1480488: Verify Submission listing on Dashboard");
				dataSet.put("TL_internal_testCase_ID", "1480488");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				General.action().login();
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine();
				//Notification
				BrowserFactory.driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
							
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
			
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
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{
			//date
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Date, 10);
			String globalink_Date=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Date).getText();
		    System.out.println("Globalink Date  is========>>"+globalink_Date);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying Date");
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
