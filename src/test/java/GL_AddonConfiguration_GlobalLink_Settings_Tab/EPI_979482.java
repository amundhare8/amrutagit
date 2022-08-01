package GL_AddonConfiguration_GlobalLink_Settings_Tab;

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
* Author        : Amrata M.
*
* Test case     : Verify functionality of Number of child levels to display on dashboard on GlobalLink Config page for 'GlobalLink Settings' tab
* Test Id       : 3409742
* Summary   	: This test case is to test whether Adapter supports HTTPS Submission Director URL
***********************************************************************************************/
public class EPI_979482 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName="auto_submission_979482";
	int SelectNum;
	int RefNum;
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979482");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979482:Verify functionality of Number of child levels to display on dashboard on GlobalLink Config page for 'GlobalLink Settings' tab");
				dataSet.put("TL_internal_testCase_ID", "979482");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
							
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_addon_config_text, 5);
				if(assertion == false){
					report("f"," assertion is failed");
				}

				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab).click();
				Thread.sleep(1000);
				
				
				//Inside_GL_Setting_Tab_Functionality
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Maxnumber_of_filespersubmission,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).sendKeys("10");
				Thread.sleep(2000);
				
				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				
				//Create Submission
				common.action().create_basic_submission_MaxFiles(SubName,true, true, true, true, false, true, "10", true, true, true, true, true, "None");
				Thread.sleep(2000);
				//////
				List<WebElement> Select_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_selected_content);
				System.out.println("------------------------>"+Select_Content.size());
				 SelectNum=Select_Content.size()-1;
				Thread.sleep(2000);		
				
				
				
				List<WebElement> Refrenced_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_referenced_content);
				System.out.println("------------------------>"+Refrenced_Content.size());
				RefNum=Refrenced_Content.size();
				Thread.sleep(2000);
				
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(10000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(15000);

				System.out.println("Submission :" + SubName + " is created.....");
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(40000);
				
				Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();
				Thread.sleep(30000);
				
				Verify.action().WaitUntilElementPresent(locators.exts().WarningMsg_Scheduler_JobCompleted, 90);
				Thread.sleep(25000);
				
				common.action().verify_RunSchedulerHistroy_New();
			    Thread.sleep(5000);
			    
				assertion=common.action().verify_submission(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}		
				
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs).click();
				Thread.sleep(3000);
				
				//GlobalLink_Dashboard_MaxJob_Name
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_MaxJob_Name, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_MaxJob_Name).click();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				List<WebElement> rows = BrowserFactory.driver.findElements(By.xpath("//div[contains(@class,'table-language')]//table//tbody//tr"));
				System.out.println(rows.size());
				
				if(rows.size()==10)
				{
					assertion=true;
				}
				else
				{
					assertion=false;				
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
			
		public void assertion() throws Exception{
			try{	
				
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
		@AfterMethod
		public void tearDown() throws Exception{
		
		BrowserFactory.quitBrowser();
		}
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
}
