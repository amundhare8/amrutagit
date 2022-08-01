package EPiServer_CMS;

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
import actions.common;
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : VeVerify validation messages for mandatory fields on GlobalLink Config page for Notification tab
* Test Id       : 1010311
* Summary   	: This test case verifies the validation messages for mandatory fields on GlobalLink Config page for Notification tab
***********************************************************************************************/
public class EPI_1010311 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010311");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010311:Verify validation messages on GlobalLink Config page for Notification tab");
				dataSet.put("TL_internal_testCase_ID", "1010311");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Notification tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Notification");
				
				//Inside Notification tab
				common.action().Inside_NotificationTab_Functionality(EPiServer_Common_Properties_Cred.SMTP_Host,EPiServer_Common_Properties_Cred.SMTP_Port,EPiServer_Common_Properties_Cred.Login,EPiServer_Common_Properties_Cred.Password,EPiServer_Common_Properties_Cred.Recipients);
				assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_msg,  25);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
				//sent test emails	Check the email	
				
				//Notification_Save_Notification_button
				Verify.action().verifyElementPresent(locators.exts().Notification_SendTestEmails_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Notification_SendTestEmails_button).click();
				Thread.sleep(8000);

				assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Test_emails_sent_msg,  25);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
								
				//Inside Notification tab with Inavlid data
				common.action().Inside_NotificationTab_Functionality(EPiServer_Common_Properties_Cred.SMTP_Host,"58171",EPiServer_Common_Properties_Cred.Login,EPiServer_Common_Properties_Cred.Password,EPiServer_Common_Properties_Cred.Recipients);
									
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
			assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_Error_msg,  35);
			if(assertion == false){
				report("f"," assertion is failed while verifying Notification Messages");
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
