package GL_AddonConfiguration_Notification_Tab;

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
/***********************************************************************************************
* Author        : Mayureshwar
* Test case     : Verify un-select checkbox �Use SSL� is getting save on GlobalLink Config page for Notification tab
* Summary   	: This test case verifies the validation for the field 'Use SSL" checkbox in Notification tab
***********************************************************************************************/
public class EPI_979532 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979532");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979532:Verify un-select checkbox �Use SSL� is getting save on GlobalLink Config page for Notification tab");
				dataSet.put("TL_internal_testCase_ID", "979532");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				common.action().Go_to_Globalink_config();
				
				//Notification Tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification"),  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification")).click();;
				Thread.sleep(3000);
		
				//SMTP_Host
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Host,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).sendKeys(EPiServer_Common_Properties_Cred.SMTP_Host);
				Thread.sleep(1000);

				//SMTP Port
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Port,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).sendKeys(EPiServer_Common_Properties_Cred.SMTP_Port);
				Thread.sleep(1000);

				//Login
				Verify.action().verifyElementPresent(locators.exts().Notification_Login,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).sendKeys(EPiServer_Common_Properties_Cred.Login);
				Thread.sleep(1000);

				//Password
				Verify.action().verifyElementPresent(locators.exts().Notification_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).sendKeys(EPiServer_Common_Properties_Cred.Password);
				Thread.sleep(1000);

				//Recipients
				Verify.action().verifyElementPresent(locators.exts().Notification_Recipients,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).sendKeys(EPiServer_Common_Properties_Cred.Recipients);
				Thread.sleep(1000);

				//Send mail for errors
				Verify.action().verifyElementPresent(locators.exts().Notification_Sendmailforerrors_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).click();
				Thread.sleep(1000);

				//Send mail for scheduler job results
				Verify.action().verifyElementPresent(locators.exts().Notification_Send_mail_for_scheduler_job_results,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).click();
				Thread.sleep(1000);
				
				//Use SSL
				Verify.action().verifyElementPresent(locators.exts().Notification_Use_SSL_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
				Thread.sleep(1000);

					
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_Save_Notification_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Save_Notification_button).click();
				Thread.sleep(8000);
				
				//Notification_Save_Notification_button
				//Verify.action().verifyElementPresent(locators.exts().Notification_SendTestEmails_button,  5);
				//BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SendTestEmails_button).click();
				//Thread.sleep(8000);
				
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SendTestEmails_button))); 
				((JavascriptExecutor)BrowserFactory.driver).executeScript("arguments[0].click();", element);
				Thread.sleep(8000);

				assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Test_emails_sent_msg,  15);
				if(assertion==true)
				{
					Thread.sleep(8000);
					Verify.action().verifyElementPresent(locators.exts().Notification_Use_SSL_checkbox,  15);
					BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
					Thread.sleep(1000);

				}
				
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_SendTestEmails_button,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SendTestEmails_button).click();
				Thread.sleep(8000);

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
			assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_Error_msg,  15);
			if(assertion == false){
				report("f"," assertion is failed while verifying Notification Changes saved msg");
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
