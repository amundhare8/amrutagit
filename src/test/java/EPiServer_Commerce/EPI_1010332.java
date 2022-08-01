package EPiServer_Commerce;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : VeVerify validation messages for mandatory fields on GlobalLink Config page for Notification tab
* Test Id       : 1010332
* Summary   	: This test case verifies the validation messages for mandatory fields on GlobalLink Config page for Notification tab
***********************************************************************************************/
public class EPI_1010332 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010332");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010332:Verify validation messages on GlobalLink Config page for field configuration tab");
				dataSet.put("TL_internal_testCase_ID", "1010332");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Config"),  25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Config")).click();
				Thread.sleep(2000);
								
				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				

				
				//Dashboard configuration
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Notification")).click();;
				Thread.sleep(3000);

				//SMTP_Host
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Host,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("SMTP_Host"));
				Thread.sleep(1000);

				//SMTP Port
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Port,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("SMTP_Port"));
				Thread.sleep(1000);

				//Login
				Verify.action().verifyElementPresent(locators.exts().Notification_Login,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Login"));
				Thread.sleep(1000);

				//Password
				Verify.action().verifyElementPresent(locators.exts().Notification_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Password"));
				Thread.sleep(1000);

				//Use SSL
				Verify.action().verifyElementPresent(locators.exts().Notification_Use_SSL_checkbox,  5);
				if(!BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).isSelected()) 
				{
					
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
				Thread.sleep(1000);
				}
				//Recipients
				Verify.action().verifyElementPresent(locators.exts().Notification_Recipients,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Recipients"));
				Thread.sleep(1000);

				//Send mail for errors
				Verify.action().verifyElementPresent(locators.exts().Notification_Sendmailforerrors_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).click();
				Thread.sleep(1000);

				//Send mail for scheduler job results
				Verify.action().verifyElementPresent(locators.exts().Notification_Send_mail_for_scheduler_job_results,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).click();
				Thread.sleep(1000);
					
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_Save_Notification_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Save_Notification_button).click();
				Thread.sleep(8000);

				assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
		//sent test emails		
				
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_SendTestEmails_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SendTestEmails_button).click();
				Thread.sleep(8000);

				assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Test_emails_sent_msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
			
				//incorrect details
				//SMTP_Host
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Host,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Host).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("SMTP_Host"));
				Thread.sleep(1000);

				//SMTP Port
				Verify.action().verifyElementPresent(locators.exts().Notification_SMTP_Port,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SMTP_Port).sendKeys("5871");
				Thread.sleep(1000);
 
				//Login
				Verify.action().verifyElementPresent(locators.exts().Notification_Login,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Login).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Login"));
				Thread.sleep(1000);

				//Password
				Verify.action().verifyElementPresent(locators.exts().Notification_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Password).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Password"));
				Thread.sleep(1000);

				//Use SSL
				if(!BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).isSelected()) 
				{
					
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Use_SSL_checkbox).click();
				Thread.sleep(1000);
				}

				//Recipients
				Verify.action().verifyElementPresent(locators.exts().Notification_Recipients,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Recipients).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Recipients"));
				Thread.sleep(1000);

				//Send mail for errors
				Verify.action().verifyElementPresent(locators.exts().Notification_Sendmailforerrors_checkbox,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Sendmailforerrors_checkbox).click();
				Thread.sleep(1000);

				//Send mail for scheduler job results
				Verify.action().verifyElementPresent(locators.exts().Notification_Send_mail_for_scheduler_job_results,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Send_mail_for_scheduler_job_results).click();
				Thread.sleep(1000);
					
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_Save_Notification_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_Save_Notification_button).click();
				Thread.sleep(8000);

		//sent test emails		
				
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_SendTestEmails_button,  5);
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
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
					
		
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_Error_msg,  35);
			if(assertion == false){
				report("f"," assertion is failed while  verifying message");
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
