package GL_Translation_Job_Configurations;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
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
* Test case     : Verify 'Include child Items' Configuration option on translation job page.
* 
* Summary   	: This test case verifies 'Include child Items' Configuration option on translation job page.
* 
* Preconditions : Create few pages and child pages under Navigation pane.
* 
* 
***********************************************************************************************/
public class EPI_643737 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_643737";
	String ProjectName= "EPiServer";
	int SelectNum;
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_643737");
		dataSet.put("TL_test_case_description","EPI_643737:  Verify 'Include child Items' Configuration option on translation job page.");
		dataSet.put("TL_internal_testCase_ID", "643737");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission			
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);

				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Track")).click();
				Thread.sleep(5000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);

				// sub name
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
				Thread.sleep(1000);
				
				//Content TAb
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_content_tab).click();
				Thread.sleep(3000);

			//	assertion= Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Content_page("Alloy Track"), 10);	
				if(assertion == false){
					report("f"," assertion is failed while verifying Selected Page");
					
				}
										
				// Configuration			
				common.action().Config_ReferencedContentTypesChecks(true,false, false, false, false);
							
				common.action().Config_ReferencedContentTypesChecks_WithDepthAndActions(true, "20", false, false, true, true, true, "None");
				
				
				//select language
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(3000);

				// tools
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
				Thread.sleep(7000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				
				
				List<WebElement> Select_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_selected_content);
				System.out.println("------------------------>"+Select_Content.size());
				 SelectNum=Select_Content.size()-1;
				Thread.sleep(2000);		
				
				
				assertion = Verify.action().verifyElementPresent(locators.exts().Submit_Translation_Contentpreview_Selectedcontent(SelectNum), 10);	
				if(assertion == false){
					report("f"," assertion is failed Verify count of Referenced Content information on Content Review is shown in brackets");
				}	
				
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Gl_Submit_for_translation_Include_child_Items_checkbox_checked, 10);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Include child Items is checked");
		    	}//
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();
				Thread.sleep(15000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.navigate().refresh();
				Thread.sleep(10000);
				

				System.out.println("Submission :" + SubName + " is created.....");
				
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(2,1);
				
				
				  //go to Dashboard
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
