package GL_AddonConfiguration_GlobalLink_Locale_Mapping_Tab;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;
/*******************************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify Source Locale on Create new Submission pop up
* Summery       :This test case is to verify that the languages added under locale mapping are shown under "Default Source Locale" dropdown list and can be set as default while creating new Submission.
*
* Preconditions : On Locale mapping page locale should be already added for e.g. - English(en),Francais( France).
*******************************************************************************************************************************************************************************/
public class EPI_979488 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979488";
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979488");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979488:Verify Source Locale on Create new Submission pop up");
				dataSet.put("TL_internal_testCase_ID", "979488");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings")).click();
				Thread.sleep(1000);
				
				Select options = new Select(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_Source_Locale_SelectOptions_text));
		        
		        // Get all options from category dropdown
		        List<WebElement> lists = options.getOptions();
		        
		        //Creating a List to store all dropdown values
		        List OriginalList = new ArrayList();
		        
		        //Using for-each loop fetch all options one by one and get their values
		        for(WebElement ele : lists) {
		            
		            OriginalList.add(ele.getText());
		        }
		        
		        System.out.println("Options in dropdown: " +OriginalList);
		        
		        //Creating temp List - same copy of Original for comparing purpose
		        List templist = new ArrayList(OriginalList);
		        Collections.sort(OriginalList);
		        System.out.println("Temp List: " + templist);
		        
		      //click save button
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  5);
				Thread.sleep(5000);
		     // go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
		        common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("About us")).click();
				Thread.sleep(5000);
	
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
				
				//select Project
				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_languages_tab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();;
				Thread.sleep(1000);
				
				//CMS_new_Job__langTab_Source
				Verify.action().verifyElementPresent(locators.exts().CMS_new_Job__langTab_Source,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_Job__langTab_Source).click();
				Thread.sleep(1000);
				
               WebElement options1 =BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_Job__langTab_Source);
		        
               String[] exp = {"English (en)", "italiano (Italia) (it-IT)", "français (France) (fr-FR)", "Deutsch (Deutschland) (de-DE)"};
               List<String> expList = new ArrayList<String>();
               
               for(int i=0;i<exp.length;i++){
                   expList.add(exp[i]);
               }
				
               System.out.println("Exp list is "+expList);
               
               Collections.sort(expList);
             
               if(expList.size()==OriginalList.size()){
                   for(int i=0;i<expList.size();i++){
                       //comparing each item in order
                       if(expList.get(i).equals(OriginalList.get(i))){
                           System.out.println("Matched");
                       }else{
                           System.out.println("Not matched");
                       }
                   }
               }else{
                   System.out.println("Drop down values are not same in number");
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
				report("f","assertion is failed while verify System should show alert message as language not selected.");
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
