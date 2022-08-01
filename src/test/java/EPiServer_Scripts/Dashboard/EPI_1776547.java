package EPiServer_Scripts.Dashboard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify the whether canceled jobs are displayed under Cancelled Jobs section
* Summary   	: Canceled Jobs, tab option is available on GlobalLink Dashboard - all canceled jobs are displayed under that tab.

***********************************************************************************************************************************************/
public class EPI_1776547 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1776547";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1776547");
		dataSet.put("TL_test_case_description","EPI_1776547:Verify the whether canceled jobs are displayed under Cancelled Jobs section");
		dataSet.put("TL_internal_testCase_ID", "1776547");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish_TwoLang(SubName);
				Thread.sleep(100000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(3000);
				
				//GlobalLink_Dashboard_cancel_chkbox
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_cancel_chkbox, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_cancel_chkbox).click();
				Thread.sleep(3000);
				
				//Cancel Button
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_cancelJobs, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_cancelJobs).click();
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				// Switching to Alert        
		        Alert alert = BrowserFactory.driver.switchTo().alert();		
		        // Accepting alert		
		        alert.accept();	
					
				  
				//click on tree icon
					if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
					Thread.sleep(2000);
					}
					
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_CancelledJobs, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_CancelledJobs).click();
					Thread.sleep(8000);
					
							
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
			try{//GL status
				assertion=common.action().verify_submission_Status(SubName, "ToCancel");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying Status");
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
			
			public Boolean verify_submissions(String SubName, String Status) throws Exception {

				
				// Click on Dashboard
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(2000);

				Boolean flag = Verify.action()
						.verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 5);
				Thread.sleep(2000);

				if (flag == false) {
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.navigate().refresh();
					Thread.sleep(3000);
				}

				flag = Verify.action()
						.verifyElementPresent(locators.exts().GL_dashboard_verify_submission_status(SubName, Status), 10);
				return flag;

			}
}
