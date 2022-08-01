package EpiServer_SubmissionWizard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify whether count is shown for both Selected Content and Referenced Content sections before Submitting the Job
* Summary   	: This test case verifies the count is shown for both Selected Content and Referenced Content sections before Submitting the Job

************************************************************************************************************************************************/

public class EPI_2498906 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_2498906";
	int SelectNum;
	int RefNum;
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2498906");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_2498906:  Verify whether count is shown for both Selected Content and Referenced Content sections before Submitting the Job");
				dataSet.put("TL_internal_testCase_ID", "2498906");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			
			
			General.action().login();
			Thread.sleep(2000);
			
			common.action().Go_to_GlobalLink_Admin("Admin","Config","Wizard settings");
			
						
			if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).isSelected() )
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_child_nodes).click();
			}
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
			Thread.sleep(4000);
			
			//Verify changes are saved
			Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
			Thread.sleep(2000);
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			
			// go to CMS edit mode
			//Edit
			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
			Thread.sleep(5000);
			
			common.action().toggle_navigation_tree_icon(true);
			Thread.sleep(4000);
			
			BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
			Thread.sleep(5000);

			//Get the Number from URL
			String NofromURL=common.action().GetNofromURL();
			
			System.out.println("The No is :"+ NofromURL);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
			Thread.sleep(3000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
			Thread.sleep(4000);
			
			//Enter Submission Name
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_submission_name_input,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);
			Thread.sleep(1000);
			
			
			//Content TAb
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_content_tab).click();
			Thread.sleep(3000);
			
			assertion= Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Content_page("Alloy Plan ",NofromURL), 10);	
			if(assertion == false){
				report("f"," assertion is failed while verifying Selected Page Number");
				
			}
			
							
			//Configuration
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);
			
			/*			
			//select language
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_Dede,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_Dede).click();
			Thread.sleep(2000);
				
			
			//tools
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
			Thread.sleep(2000);
				
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_tools_arrow_submit_for_translation,  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
			Thread.sleep(9000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
			Thread.sleep(3000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
			Thread.sleep(7000);
*/
			//Language Tab to Submit for translation
			common.action().LangTab_SubmitforTranslation();
			
			List<WebElement> Select_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_selected_content);
			System.out.println("------------------------>"+Select_Content.size());
			 SelectNum=Select_Content.size()-1;
			Thread.sleep(2000);		
			
			
			
			List<WebElement> Refrenced_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_referenced_content);
			System.out.println("------------------------>"+Refrenced_Content.size());
			RefNum=Refrenced_Content.size();
			Thread.sleep(2000);
			
			
			}catch(Throwable e){
			report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
			}
		}

	@org.testng.annotations.Test
	public void execute() throws Exception{
		
		testcase(dataSet);
	   assertion();
		
	}
		
	@AfterMethod
	public void tearDown() throws Exception{
	try {
	 // BrowserFactory.quitBrowser();
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
		assertion = Verify.action().verifyElementPresent(locators.exts().Submit_Translation_Contentpreview_Selectedcontent(SelectNum), 10);	
		if(assertion == false){
			report("f"," assertion is failed Verify count of Referenced Content information on Content Review is shown in brackets");
		}	
		
		assertion = Verify.action().verifyElementPresent(locators.exts().Submit_Translation_Contentpreview_Referrencedcontent(RefNum), 10);	
		if(assertion == false){
			report("f"," assertion is failed Verify count of Referenced Content information on Referrenced content Review is shown in brackets");
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
