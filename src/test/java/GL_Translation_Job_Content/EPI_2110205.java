package GL_Translation_Job_Content;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
* Test case     : Verify the round trip of Page with references and check whether roundtrip works fine when referenced content is moved to Trash
* 
* Summary 		: Verify the round trip of Page with references and check whether roundtrip works fine when referenced content is moved to Trash
* 
* Precondition  : Create a Page and add another page as a reference to it
* 
************************************************************************************************************************************************/


public class EPI_2110205 {
	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName = "Epi_2110205";
	String RefPageName="Epi_RefPg_2110205";
	String SubName = "EpiServer_Sub_2110205";
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2110205");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_2110205 : Verify the round trip of Page with references and check whether roundtrip works fine when referenced content is moved to Trash");
				dataSet.put("TL_internal_testCase_ID", "2110205");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//Setting Content Type[Ref page]
				 common.action().Create_StanderedPage("Admin", "Content Type", "[Default] Standard Page","Long string (>255)", "LongstringContents", "RefTESTS");
				
				//EDIT
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
				BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().add_pagetype("New Page"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype("New Page")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype("Standard Page"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype("Standard Page")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_name,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).click();
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(Keys.CONTROL,Keys.chord("A"),Keys.BACK_SPACE);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(RefPageName);
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_AllProperties,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_AllProperties).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("Long String Title,");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("Long String Keywords");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys("This is Long String Page Descrition.");
				Thread.sleep(2000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);
				
				//teaser text
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
				Thread.sleep(2000);				
					
				
				//long string
				Verify.action().verifyElementPresent(locators.exts().CMS_Content_Refpage,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys(Keys.CONTROL+"a");
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys(Keys.DELETE);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys("This is Testing DEMO. ");
				Thread.sleep(2000);
				
				
				//publish
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
				Thread.sleep(2000);
				
				//submission
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(RefPageName)).click();
				Thread.sleep(5000);
				
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
				Thread.sleep(3000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
				Thread.sleep(4000);


				//sub name
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(RefPageName);
				Thread.sleep(1000);
				
				//select language
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
				Thread.sleep(3000);

				BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
				Thread.sleep(2000);
				
				//tools				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();
				Thread.sleep(2000);

				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				
				BrowserFactory.driver.switchTo().defaultContent();
				
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
				Thread.sleep(4000);
				
				
				System.out.println("Submission :"+SubName+" is created.....");
				
				//Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
				
				
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_GlobalLink, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink).click();
				Thread.sleep(5000);
				
				//Click on Dashborad 
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
				Thread.sleep(2000);
				
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
				//edit
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab("Edit"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab("Edit")).click();;
				Thread.sleep(3000);
				
					//ignore
				
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();;
				Thread.sleep(3000);
						
				
				Verify.action().verifyElementPresent(locators.exts().Select_page(RefPageName),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(RefPageName)).click();
				Thread.sleep(5000);
				Thread.sleep(2000);
				
				//de-de
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
				Thread.sleep(2000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(4000);
			
				assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_LongString, 5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Test");
							
		    	}
		    	
		    	//en
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
				Thread.sleep(3000);
				
				
		    		///main Page
		    	//Setting Content Type[Actual page]
				 common.action().Create_StanderedPage("Admin", "Content Type", "[Default] Standard Page","Long string (>255)", "LongstringContentsMain","MainContent");
			
				//EDIT
					Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
					Thread.sleep(7000);
					
					//common.action().toggle_navigation_tree_icon(true);
					//Thread.sleep(4000);
					
					
					Verify.action().verifyElementPresent(locators.exts().CMS_Edit_Start,5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Edit_Start).click();
					Thread.sleep(3000);
					
					Verify.action().verifyElementPresent(locators.exts().page_AddButton,5);
					BrowserFactory.SystemEngine().findElement(locators.exts().page_AddButton).click();
					Thread.sleep(3000);
					
					Verify.action().verifyElementPresent(locators.exts().add_pagetype("New Page"),  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().add_pagetype("New Page")).click();
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().select_suggested_pagetype("Standard Page"),  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().select_suggested_pagetype("Standard Page")).click();
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_name,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).click();
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(Keys.CONTROL,Keys.chord("A"),Keys.BACK_SPACE);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_name).sendKeys(PageName);
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newpage_Ok,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newpage_Ok).click();
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_GL_translation_AllProperties,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_AllProperties).click();
					Thread.sleep(2000);

					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_title,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("Long String Title,");
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("Long String Keywords");
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys("This is Long String Page Descrition.");
					Thread.sleep(2000);
					
					//content
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
					Thread.sleep(2000);
					
					//teaser text
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
					Thread.sleep(2000);
					
					//RefTEST
					Verify.action().verifyElementPresent(locators.exts().CMS_Content_Refpage,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys(Keys.CONTROL+"a");
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys(Keys.DELETE);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_Refpage).sendKeys("This is Testing DEMO. ");
					Thread.sleep(2000);
					
					
					//CMS_longstringContentsMain
					Verify.action().verifyElementPresent(locators.exts().CMS_Content_longstringContentsMain,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_longstringContentsMain).sendKeys(Keys.CONTROL+"a");
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_longstringContentsMain).sendKeys(Keys.DELETE);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Content_longstringContentsMain).sendKeys("This is Testing DEMO Main. ");
					Thread.sleep(2000);
					
					//teaser Body
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
					Thread.sleep(7000);
							
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.DELETE);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys("This is content teaser Main Body");
					Thread.sleep(2000);
					
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");					
					
					
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo().defaultContent();
					Thread.sleep(3000);
					
					
					//CMS_MainBody_InsertEditLink
					Verify.action().verifyElementPresent(locators.exts().CMS_MainBody_InsertEditLink,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MainBody_InsertEditLink).click();
					Thread.sleep(3000);
					
					//CMS_MainBody_Linktitle
					Verify.action().verifyElementPresent(locators.exts().CMS_MainBody_Linktitle,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MainBody_Linktitle).sendKeys("Test1");
					Thread.sleep(2000);
					
					
					//Main Body page button
					Verify.action().verifyElementPresent(locators.exts().CMS_MainBody_PageButton,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MainBody_PageButton).click();
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_MainBody_pageSelect(RefPageName),  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MainBody_pageSelect(RefPageName)).click();
					Thread.sleep(5000);
					
					//selectpg_OK
					Verify.action().verifyElementPresent(locators.exts().CMS_MAinbody_Selectpg_OK,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MAinbody_Selectpg_OK).click();
					Thread.sleep(2000);
					
					//Main_OK
					Verify.action().verifyElementPresent(locators.exts().CMS_MAinbody_OK,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_MAinbody_OK).click();
					Thread.sleep(2000);
					
					//publish

					Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
					Thread.sleep(2000);
					
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
					Thread.sleep(2000);
					
					//edit
					Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
					Thread.sleep(4000);
			
					//select page
					BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(RefPageName)).click();
					Thread.sleep(3000);
					
					
					Verify.action().verifyElementPresent(locators.exts().Gl_Globalink_Translation_PageName_WithoptionsDropdown(RefPageName),  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Globalink_Translation_PageName_WithoptionsDropdown(RefPageName)).click();
					Thread.sleep(2000);
					
					
					//GL_Pagename_MoveToTrash
					Verify.action().verifyElementPresent(locators.exts().GL_Pagename_MoveToTrash,  5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GL_Pagename_MoveToTrash).click();
					Thread.sleep(2000);
					
					
					//MoveToTrash button
					Verify.action().verifyElementPresent(locators.exts().GL_MoveToTrash, 10);
					 BrowserFactory.SystemEngine().findElement(locators.exts().GL_MoveToTrash).click();
					 Thread.sleep(6000);
					
					 
					    Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_Page_gear_button_settings, 15);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_Page_gear_button_settings).click();
						Thread.sleep(4000);
						
						//view trash
						Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_settings_trash, 15);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_settings_trash).click();
						Thread.sleep(4000);
						
						//empty trash
						Verify.action().verifyElementPresent(locators.exts().CMS_edit_Move_to_Trash_EmptyTrash, 15);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Move_to_Trash_EmptyTrash).click();
						Thread.sleep(4000);
					
						
						Verify.action().verifyElementPresent(locators.exts().CMS_edit_Move_to_Trash_EmptyTrash_Yes, 15);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Move_to_Trash_EmptyTrash_Yes).click();
						Thread.sleep(5000);
						
						
						//submission
						BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
						Thread.sleep(5000);
						
						
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow).click();
						Thread.sleep(3000);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GL_translation_jobs_arrow_create_job).click();
						Thread.sleep(4000);


						//sub name
						
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).clear();
						Thread.sleep(1000);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_submission_name_input).sendKeys(SubName);;
						Thread.sleep(1000);
						
						//select language
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_languages_tab).click();
						Thread.sleep(3000);

						
						BrowserFactory.SystemEngine().findElement(locators.exts().select_Language("Deutsch (Deutschland) (de-DE)")).click();
						Thread.sleep(2000);
						//tools				
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow).click();;
						Thread.sleep(2000);

						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_tools_arrow_submit_for_translation).click();;
						Thread.sleep(7000);
						
						BrowserFactory.SystemEngine();
						BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job_window_iframe));
						Thread.sleep(3000);

						Verify.action().verifyElementPresent(locators.exts().CMS_new_job_Submit_for_translation_refresh, 10);				
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_for_translation_refresh).click();
						Thread.sleep(7000);
						
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Submit_job).submit();
						Thread.sleep(3000);
						
						BrowserFactory.SystemEngine();
						BrowserFactory.driver.switchTo().defaultContent();
						
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button).click();;
						Thread.sleep(4000);
						
						
						System.out.println("Submission :"+SubName+" is created.....");
						
						//Run schedular
						common.action().run_schedular();
						common.action().verify_RunSchedulerHistroy1();
						
						
						//go to Dashboard button
						common.action().Go_To_DashBorad_Button();
						
						//Status
						assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
						String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
					    System.out.println("Globalink Status is========>>"+globalink_Status1);
					    
						if(assertion == false){
							report("f"," assertion is failed while verifying  Status");
						}
						//edit
						Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS, 5);
						BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS).click();
						Thread.sleep(1000);
						
						Verify.action().verifyElementPresent(locators.exts().GL_Global_CMS_Select_tab("Edit"),  5);
						BrowserFactory.SystemEngine().findElement(locators.exts().GL_Global_CMS_Select_tab("Edit")).click();;
						Thread.sleep(3000);
						
						Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  5);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();;
						Thread.sleep(3000);
								
							
						
						Verify.action().verifyElementPresent(locators.exts().Select_page(PageName),  5);
						BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(PageName)).click();
						Thread.sleep(5000);
						
						
						//de-de
						Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_de_de, 15);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_de_de).click();
						Thread.sleep(2000);
						
						//content
						Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
						BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
						Thread.sleep(2000);
						
						 JavascriptExecutor js1 = (JavascriptExecutor) BrowserFactory.driver; 
					    js1.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // It will scroll down until the end of the page .
					    Thread.sleep(2000);
					    
					    BrowserFactory.SystemEngine();
						BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody_Iframe));
						Thread.sleep(7000);
						
						assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
				    	if(assertion == false){
							report("f"," assertion is failed while verifying  Page Description");
									
				    	}

						
						BrowserFactory.SystemEngine();
						BrowserFactory.driver.switchTo().defaultContent();
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
		
		  //en 
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
		    BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click(); Thread.sleep(2000);
		 
			try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{

			if(assertion == false){
				report("f"," assertion is failed while verifying Reference Page");
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
