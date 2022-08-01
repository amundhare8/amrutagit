package Gl_AddonConfiguration_DBCleanUp_LastRun;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;


/**===========================================================================================
 * @author       : Mayueshwar
 * Test case     : Verify validation messages for mandatory fields on GlobalLink Config page for GlobalLink Settings tab
 * Test Id       : C1010306
 * Summary   	 : This test case verifies the input for username, password, URL and classifier in PD
 *
 ===========================================================================================*/


public class EPI_1010306 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010306");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010306:Verify Project Director details are getting saved on 'GlobalLink Settings' tab with confirmation message");
				dataSet.put("TL_internal_testCase_ID", "1010306");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				
				//GlobalLink Settings
				common.action().Go_to_GlobalLink_Admin("Admin", "Config", "GlobalLink Settings");
				//Inside_GL_Setting_Tab_Functionality
				common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username,EPiServer_Common_Properties_Cred.Pass,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
					
				Thread.sleep(2000);
				//rechecking with In-correct url and all fields  are correct
				
				//GlobalLink Settings
				Thread.sleep(8000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys("http://techqa12.translations.com/PD");
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys(EPiServer_Common_Properties_Cred.Username);
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys(EPiServer_Common_Properties_Cred.Pass);
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_SubmissionNamePrefix,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).sendKeys(EPiServer_Common_Properties_Cred.Submission_Name_Prefix);
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Classifier,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).sendKeys(EPiServer_Common_Properties_Cred.Classifier);
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Maxnumber_of_filespersubmission,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).sendKeys(EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission);
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Translation_retrieval_batch_size,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).sendKeys(EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size);
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).sendKeys(EPiServer_Common_Properties_Cred.UID);
				Thread.sleep(1000);

				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox_checked,  5)){
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox).click();
				Thread.sleep(2000);
				}

				//Test settings
					
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button))); 
				((JavascriptExecutor)BrowserFactory.driver).executeScript("arguments[0].click();", element);
				Thread.sleep(8000);
				
				
				assertion=Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying Message");
				}
				
				//Inside_GL_Setting_Tab_Functionality
				common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username,EPiServer_Common_Properties_Cred.Pass,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
				
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
			
			if(assertion == false){
				report("f"," assertion is failed while verifying Message");
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
}
