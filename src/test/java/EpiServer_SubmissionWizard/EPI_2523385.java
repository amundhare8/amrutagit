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
* Test case     : Verify whether count of Referenced Content information on Content Review is shown in brackets
* Summary   	: This test case verifies the count of Referenced Content information on Content Review is shown in brackets

************************************************************************************************************************************************/

public class EPI_2523385 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_2523385";
	int SelectNum;
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2523385");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_2523385:  Verify whether count of Referenced Content information on Content Review is shown in brackets");
				dataSet.put("TL_internal_testCase_ID", "2523385");
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
			
			//Select Page up to content Tab
			common.action().Selectpage_ContentTab("About us", SubName);				
							
			//Configuration
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_configuration_tab).click();
			Thread.sleep(1000);
			
			//Language Tab to Submit for translation
			common.action().LangTab_SubmitforTranslation();
			
			List<WebElement> Select_Content = BrowserFactory.SystemEngine().findElements(locators.exts().gettreevalues_selected_content);
			System.out.println("------------------------>"+Select_Content.size());
			 SelectNum=Select_Content.size()-1;
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
		assertion = Verify.action().verifyElementPresent(locators.exts().Submit_Translation_Contentpreview_Selectedcontent(SelectNum), 10);	
		if(assertion == false){
			report("f"," assertion is failed Verify count of Referenced Content information on Content Review is shown in brackets");
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
