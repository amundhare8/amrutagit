package GL_AddonConfiguration_GlobalLink_Settings_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : Verify Project director details are validated upon saved on 'GlobalLink Settings' tab
* Test Id       : C979478
* Summary   	: This test case verifies the input for username, password, URL and classifier in Pd.
***********************************************************************************************/
public class EPI_979478 {

	 
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979478");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979478:Verify Project director details are validated upon saved on 'GlobalLink Settings' tab");
				dataSet.put("TL_internal_testCase_ID", "979478");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Settings
				common.action().Go_to_Globalink_config();
				
				//Inside_GL_Setting_Tab_Functionality
				common.action().Inside_GL_Setting_Tab_Functionality(EPiServer_Common_Properties_Cred.GlobalLink_url,EPiServer_Common_Properties_Cred.Username,EPiServer_Common_Properties_Cred.Pass,EPiServer_Common_Properties_Cred.Submission_Name_Prefix,EPiServer_Common_Properties_Cred.Classifier,EPiServer_Common_Properties_Cred.Max_number_of_files_per_submission,EPiServer_Common_Properties_Cred.Translation_retrieval_batch_size,EPiServer_Common_Properties_Cred.UID);
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  15);
					if(assertion == false){
						report("f"," assertion is failed while verifying GL config is saved and correct");
					}
				
				
					//GlobalLink Settings incorrect URL
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys("https://qa-connect8.translations.com/PDM/");
				Thread.sleep(2000);
		
		
				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_NOPDconnection_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys(EPiServer_Common_Properties_Cred.GlobalLink_url);
				Thread.sleep(2000);
		
				//incorrect username
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys("Username");
				Thread.sleep(2000);
			
				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_incorrect_login_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}

				//incorect password
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys(EPiServer_Common_Properties_Cred.Username);
				Thread.sleep(2000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys("password");
				Thread.sleep(2000);
			
				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_incorrect_login_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
				}

				// INCORRECT CLASSIFIER
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys(EPiServer_Common_Properties_Cred.Pass);
				Thread.sleep(2000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Classifier,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).sendKeys("epi");
				Thread.sleep(2000);

				//Test settings
				
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button))); 
				((JavascriptExecutor)BrowserFactory.driver).executeScript("arguments[0].click();", element);
				Thread.sleep(5000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_incorrect_login_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying GL config is saved and correct");
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
		
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{
			
			if(assertion == false){
				report("f"," assertion is failed while verifying GL config is saved and correct");
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
