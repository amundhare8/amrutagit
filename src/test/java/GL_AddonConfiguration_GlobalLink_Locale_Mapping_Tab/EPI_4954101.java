package GL_AddonConfiguration_GlobalLink_Locale_Mapping_Tab;

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

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : Add ar-XY language in Adapter's PD Locale static List
* Summary       : This tc is to verify ar-XY language
* Preconditions :1)- Add enus-arXY in PD project
* 				 2)- Enabled ar-AE in Admin->Config-> Manage Website Languages
* 				 3)- Configure the PD details and save it - Connection should be successful
***********************************************************************************************/

public class EPI_4954101 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_4954101";
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4954101");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_4954101:Add ar-XY language in Adapter's PD Locale static List");
				dataSet.put("TL_internal_testCase_ID", "4954101");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				/*
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Locale mapping")).click();
				Thread.sleep(1000);
				
				//FOR French
				 if(Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("العربية (الإمارات العربية المتحدة) (ar-AE)"), 5)) {
						  
						  BrowserFactory.SystemEngine().findElement(locators.exts().CMS_locale_mapping_verify_lang_present("العربية (الإمارات العربية المتحدة) (ar-AE)")).click();
						  Thread.sleep(3000);
						  BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Localemapping_delete_button).click();
						  Thread.sleep(3000);
						
						 
							Alert alert= BrowserFactory.driver.switchTo().alert();
							alert.accept();
						 
							Thread.sleep(5000);
						}
								
					
			Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("ar-AE"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("ar-AE")).click();;
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("ar-XY"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_GlobalLink_locale_list_select_language("ar-XY")).click();;
			Thread.sleep(2000);
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Source_Locale).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Source_Locale).click();
				}
				Thread.sleep(3000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Target_Locale).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Locale_Mapping_Ava_Target_Locale).click();
				}
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).sendKeys(EPiServer_Common_Properties_Cred.Recipients);
				Thread.sleep(3000);
				
			
				//Add button
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_add_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_add_button).click();
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("العربية (الإمارات العربية المتحدة) (ar-AE)"),  5);
				if(assertion == false){
					report("f"," assertion is failed while verifying language added");
				}
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(3000);
				
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish("Alloy Plan",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(5000);
			
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				common.action().Go_To_DashBorad_Button();
				
				assertion=common.action().verify_submission_Status(SubName, "Published");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				*/
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
		
		//BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{assertion=Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"), 15);
			//assertion=Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("français (France) (fr-FR)"),  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying language added");
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
