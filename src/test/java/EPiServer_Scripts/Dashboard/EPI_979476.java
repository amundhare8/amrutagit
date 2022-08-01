package EPiServer_Scripts.Dashboard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.By;
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
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : Verify Pagination on Dashboard 
* Summary   	: This test case verifies the functionality of Job Pagination
* Preconditions : Set the Job Paging to 5 in Dashboard Configuration tab in GlobalLink Config
				  Submissions should be displayed on Dashboard
***********************************************************************************************/
public class EPI_979476 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979476");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979476:Verify Pagination on Dashboard");
				dataSet.put("TL_internal_testCase_ID", "979476");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				common.action().Go_to_Globalink_config();
				
				//Dashboard configuration
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Dashboard configuration"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Dashboard configuration")).click();;
				Thread.sleep(3000);
		
				Verify.action().verifyElementPresent(locators.exts().Dashboard_configuration_Job_paging,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Job_paging).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Job_paging).sendKeys("8");
				Thread.sleep(3000);
		
				//Test settings
				Verify.action().verifyElementPresent(locators.exts().Dashboard_configuration_Save_Configuration_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Save_Configuration_button).click();
				Thread.sleep(5000);
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_configuration_Changes_Saved_msg,  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying Job paging is saved.");
				}
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();

				//Click on Dashboard
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(5000);

				BrowserFactory.SystemEngine();
				List<WebElement> rows = BrowserFactory.driver.findElements(By.xpath("//table[@class='epi-default']//tbody//tr"));
				System.out.println(rows.size());
				
				if(rows.size()==8)
				{
					assertion=true;
				}
				else
				{
					assertion=false;				
				}
				
				if(assertion == false){
					report("f"," assertion is failed while verifying paging");
				}else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
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
		
			BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{	
			if(assertion == false){
				report("f"," assertion is failed while verifying paging");
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
