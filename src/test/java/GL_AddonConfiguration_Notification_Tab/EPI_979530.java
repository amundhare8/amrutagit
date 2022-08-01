package GL_AddonConfiguration_Notification_Tab;

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
* Test case     : Verify entered value for field �Password� is getting saved on GlobalLink Config page for Notification tab
* Summary   	: This test case verifies the validation for the field 'Password" in Notification tab
***********************************************************************************************/
public class EPI_979530 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979530");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979530:Verify entered value for field �Password� is getting saved on GlobalLink Config page for Notification tab");
				dataSet.put("TL_internal_testCase_ID", "979530");
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
		
				//Inside Notification tab
				common.action().Inside_NotificationTab_Functionality(EPiServer_Common_Properties_Cred.SMTP_Host,EPiServer_Common_Properties_Cred.SMTP_Port,EPiServer_Common_Properties_Cred.Login,EPiServer_Common_Properties_Cred.Password,EPiServer_Common_Properties_Cred.Recipients);
		
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
			assertion=Verify.action().verifyElementPresent(locators.exts().Notification_Changessaved_msg,  15);
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
