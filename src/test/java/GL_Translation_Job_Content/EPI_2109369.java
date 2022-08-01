package GL_Translation_Job_Content;
import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
/******************************************************************************************************************************************************************
 * Author : Amrata M.
 *
 * Test case 	: 		Verify whether custom content type XHTML String is supported for translation
 * 
 * Summary 		: 		This test case verifies whether custom content type XHTML String is supported for translation
 * 
 * Precondition :		Create a Standard Page and put different types of content in XHTML Field (Content like Link, text, image, XHTML String Custom Content type etc)
 *
 *******************************************************************************************************************************************************************/

public class EPI_2109369 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String PageName ="Epi_2109369-XHTMLTesting";// "Epi_2109369-XHTMLTesting";
	String SubName = "EpiServer_Sub_2109369";


	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2109369");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_2109369:Verify whether custom content type XHTML String is supported for translation");
				dataSet.put("TL_internal_testCase_ID", "2109369");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				
				
				
				//Go to Content Type
				common.action().Go_to_GlobalLink_Admin_Content("Admin","Content Type","[Default] Standard Page");
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				
				//add property
				Verify.action().verifyElementPresent(locators.exts().contenttype_Stdpage_AddProperty,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().contenttype_Stdpage_AddProperty).click();
				Thread.sleep(2000);
				
				//_SettingType
				Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_SettingType,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_SettingType).click();
				Thread.sleep(2000);
				
				((JavascriptExecutor) BrowserFactory.SystemEngine().driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(5000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Admin_CommonSetting_Type_selectOption("XHTML string (>255)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admin_CommonSetting_Type_selectOption("XHTML string (>255)")).click();
				Thread.sleep(2000);
				
				//Type
				Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_Type,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_Type).sendKeys("XHTMALContent");
				Thread.sleep(2000);
				
				//chk
				Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_valueperLang,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_valueperLang).click();
				Thread.sleep(2000);
				
				//Field name
				Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_common_Fieldname,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_common_Fieldname).sendKeys("XHTMALTESTS");
				Thread.sleep(2000);
				
				//
				Verify.action().verifyElementPresent(locators.exts().CMS_Admin_CommonSetting_Type_selectTabOption("Content"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Admin_CommonSetting_Type_selectTabOption("Content")).click();
				Thread.sleep(2000);
							
				
				//save
				Verify.action().verifyElementPresent(locators.exts().CMS_amdnin_containt_Save,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_Save).click();
				Thread.sleep(2000);
				
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				
				
				//EDIT
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				common.action().toggle_navigation_tree_icon(true);
				Thread.sleep(4000);
				
				//BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
				//Thread.sleep(3000);
				
				
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
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_title).sendKeys("XHTML Title,");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_Keywords).sendKeys("XHTML Keywords");
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_page_description,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_page_description).sendKeys("This is XHTML Page Descrition.");
				Thread.sleep(2000);
				
				//content
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_NewSubmission_ContentTab,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_NewSubmission_ContentTab).click();
				Thread.sleep(2000);
				
				//Xhtml Text
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_XhtmlMainbody_Iframe));
				Thread.sleep(7000);
						
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.CONTROL+"a");
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys(Keys.DELETE);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_Mainbody).sendKeys("This is content XHTML  Main Body");
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				WebElement element =BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText);
				JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.driver;
				js.executeScript("arguments[0].scrollIntoView();", element); 
				Thread.sleep(2000);
			
				//teaser text
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_TeaserText,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Alloy_Content_TeaserText).sendKeys("This is content teaser text");
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
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				//publish
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_arrow, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_arrow).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_newpage_Publish_button, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_newpage_Publish_button).click();
				Thread.sleep(2000);
				
				//Create Submission
				common.action().create_basic_submission1(PageName, SubName);
				
				//Run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy1();
				
				//GO TO DashBoard Button
				common.action().Go_To_DashBorad_Button();
		
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
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();;
				Thread.sleep(3000);
						
					
				
				Verify.action().verifyElementPresent(locators.exts().Select_page(PageName), 5);//"Epi_2109369-XHTMLTesting"
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
			
			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);
		
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_submission_Newjob_en, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_submission_Newjob_en).click();
			Thread.sleep(2000);
			
			
			try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
					
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_edit_Alloy_Content_Mainbody, 5);
	       	if(assertion == false){
				report("f"," assertion is failed while verifying XHTML Page Description");
						
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
