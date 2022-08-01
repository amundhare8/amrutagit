package EPiServer_Scripts.Dashboard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import locators.locators;

/******************************************************************************************************************************************************************
* Author        :   Amrata M.
*
* Test case     :	Verify the Search All Jobs functionality on job listing page on Dashboard

* Summary 		: 	This test case verifies the search all jobs functionality on job listing page on dashboard
* 
*******************************************************************************************************************************************************************/

public class EPI_2405332 {
	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_2405332";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2405332");
		dataSet.put("TL_test_case_description","EPI_2405332: Verify the Search All Jobs functionality on job listing page on Dashboard");
		dataSet.put("TL_internal_testCase_ID", "2405332");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
				Thread.sleep(1000);
				
				
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_PublishedJobs).click();
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_PublishedJobplus, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_PublishedJobplus).click();
				Thread.sleep(3000);

			
				//Search
				Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).click();
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).sendKeys(EPiServer_Common_Properties_Cred.Submission_Name_Prefix);//"AutomationTest_EpiServer"
				Thread.sleep(2000);
				
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword_Button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword_Button).click();
				Thread.sleep(2000);
				
				//verify
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
				}
				
				//Error
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_ErrorJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_ErrorJobs).click();
				Thread.sleep(3000);
				
					//Search
					Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).sendKeys(Keys.CONTROL + "a");
					BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).sendKeys(Keys.DELETE);
					BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).sendKeys("AutomationTest_EpiServer_Sub_979449");
					Thread.sleep(2000);
					
					
					
					Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword_Button, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword_Button).click();
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
		try {
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_inallJobs).click();
			Thread.sleep(3000);
			
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void assertion() throws Exception{
			try{//verify
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Search_Message, 10);
				String globalink_msg=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Search_Message).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_msg);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
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
