package GL_AddonConfiguration_PreviewURL;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.PD4_main_Locators;
import locators.locators;

/**********************************************************************************************************************************************
* Author        : Amrata M.
* 
** Test case    : Verify if public Preview_url is getting included in XML while sending page to PD
*
* Summary   	: This test case is used to verify the Preview_URL is getting included in XML
* Precondition :  Create one GlobalLink Translation job
Send it to PD and complete the submission

Enter the below PSS details and click on Save
preview server :-
PSS URL - https://connect-dev.translations.com/api/v1
PSS User name -> gnilawar
PSS Password -> password1!
PSS Connector ID -> 414b8b777c67ed0a7257d178bbfbcafd



***********************************************************************************************************************************************/
public class EPI_1182605{
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1182605";
	String ProjectName= "EPiServer";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1182605");
		dataSet.put("TL_test_case_description","EPI_1182605: Verify if public Preview_url is getting included in XML while sending page to PD");
		dataSet.put("TL_internal_testCase_ID", "1182605");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
	
				//GlobalLink Field Config Tab
				//GlobalLink Auto Submission Tab
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("GCC Server"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("GCC Server")).click();
				Thread.sleep(1000);
				
							
				//Inside Tab
				common.action().Go_to_GlobalLink_GCCServer(EPiServer_Common_Properties_Cred.PSS_URL,EPiServer_Common_Properties_Cred.PSS_Username,EPiServer_Common_Properties_Cred.PSS_Password,EPiServer_Common_Properties_Cred.PSS_ConnectorID);
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().Gccserver_Msg,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
					}
				
				// go to CMS edit mode
				common.action().go_to_CMS_from_Globallink("Edit");
				Thread.sleep(4000);
				
				//create Submission--None
				common.action().create_basic_submission("Alloy Meet",SubName, true, false, false, false, false, true, "5", false, false, true, true, true, "None");
				Thread.sleep(6000);
				
				//run schedular
				common.action().run_schedular();
				common.action().verify_RunSchedulerHistroy(1,1);
				
				//Edit
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit, 15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(5000);
							
			
				
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
				//Notification Bell 
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Notification_Bell, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Notification_Bell).click();
				Thread.sleep(5000);
				
						
				WebElement element1= BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_GlobalLink);
			    BrowserFactory.SystemEngine();
				JavascriptExecutor executor1 = (JavascriptExecutor) BrowserFactory.driver;
			    executor1.executeScript("arguments[0].click();", element1);
				Thread.sleep(3000);
				
				// Click on Dashborad
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_MainDashboard, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_MainDashboard).click();
				Thread.sleep(2000);
					
				//GlobalLink_Dashboard_Submission_ID
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_Sub_ID = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
				System.out.println("Globalink Submission ID is========>>" + globalink_Sub_ID);
				
				assertion=common.action().verify_submission_Status(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission Status");
				}
				
				//PD
				//open pd url
				Thread.sleep(5000);
				common.action().Open_New_Instance_URL(EPiServer_Common_Properties_Cred.GlobalLink_url);
				Thread.sleep(5000);
				
				//pd login
				common.action().PDlogIn(EPiServer_Common_Properties_Cred.Username, EPiServer_Common_Properties_Cred.Pass);
				Thread.sleep(1000);
				
				//admin_accountButton_Completed2
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Completed2, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Completed2).click();
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_Completedtextbox, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_Completedtextbox).sendKeys(globalink_Sub_ID);
				Thread.sleep(2000);


				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_filter_search2, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_filter_search2).click();
				Thread.sleep(2000);
				
				//admin_RowSelect
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_RowSelect(globalink_Sub_ID), 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_RowSelect(globalink_Sub_ID)).click();
				Thread.sleep(2000);
				
				//manage//Admin_manage_Button
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().Admin_manage_Button, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().Admin_manage_Button).click();
				Thread.sleep(2000);
				
				//Admin_manage_DownloadSource_Button
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().Admin_manage_DownloadSource_Button, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().Admin_manage_DownloadSource_Button).click();
				Thread.sleep(6000);
				
				//Admin_manage_DownloadSource_Button_here
				Verify.action().verifyElementPresent(PD4_main_Locators.exts().Admin_manage_DownloadSource_Button, 80);
				BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().Admin_manage_DownloadSource_Button).click();
				Thread.sleep(6000);
				
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
		//assertion=Verify.action().verifyElementPresent(locators.exts().CMS_new_GL_Project_select("English (en)"),  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying The default project (EPiServer) should be present in the project field.");
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
