package GlobalLink_Schedular_History_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
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
* Test case     : Verify submission history for count of completed target retrieved on GlobalLink Scheduler page for History tab.
* 
* Summary 		: This test verifies the submission history for count of completed target retrieved on GlobalLink Scheduler page for History tab

*
*******************************************************************************************************************************************************************/

public class EPI_979735 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979735";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979735");
		dataSet.put("TL_test_case_description","EPI_979735: Verify submission history for count of completed target retrieved on GlobalLink Scheduler page for History tab.");
		dataSet.put("TL_internal_testCase_ID", "979735");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				//Submit for Translation
				common.action().create_basic_submission_SubmitforTranslation("Alloy Plan",SubName);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(6000);

		    	BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
				Thread.sleep(4000);
				
				
				System.out.println("Submission :"+SubName+" is created.....");
		    	
				//Run schedular
				
							
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin).click();
				Thread.sleep(5000);

				
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin_admin,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin_admin).click();
				Thread.sleep(5000);
				

				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Admin"),  25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Admin")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Gl_Dashboardadmin_admin_Glschedular,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboardadmin_admin_Glschedular).click();
				Thread.sleep(7000);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();
				Thread.sleep(5000);
				
				Thread.sleep(30000);
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().schedular_msg, 15);
				assertion=Verify.action().verifyElementPresent(locators.exts().schedular_msg,  15);
				
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
					
				}
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
				Thread.sleep(3000);
				

				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Admin_Schedular_history_status, 10);
				String history_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Admin_Schedular_history_status).getText();
			    System.out.println(" Status is========>>"+history_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
					
				}
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
					//Go to dashboard Button
				common.action().Go_To_DashBorad_Button();
				
				
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
				//GL status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status1);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}
				
				}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
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
		
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
			
			
}
