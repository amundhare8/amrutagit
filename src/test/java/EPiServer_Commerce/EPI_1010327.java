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


/**===========================================================================================
 * @author       : Amrata M.
 * Test case     : Verify validation messages for mandatory fields on GlobalLink Config page for GlobalLink Settings tab
 * Test Id       : C1010327
 * Summary   	 : This test case verifies the input for username, password, URL and classifier in PD
 *
 ===========================================================================================*/


public class EPI_1010327 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod		
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010327");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010327:Verify Project Director details are getting saved on 'GlobalLink Settings' tab with confirmation message");
				dataSet.put("TL_internal_testCase_ID", "1010327");
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
				

			//GlobalLink Settings
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("GlobalLink_url"));
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Username"));
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Pass"));
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_SubmissionNamePrefix,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Submission_Name_Prefix"));
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Classifier,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Classifier"));
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Maxnumber_of_filespersubmission,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Max_number_of_files_per_submission"));
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Translation_retrieval_batch_size,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Translation_retrieval_batch_size"));
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("UID"));
				Thread.sleep(1000);

				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox_checked,  5)){
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox).click();
				Thread.sleep(2000);
				}

				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
				
				//rechecking with In-correct url and all fields  are correct
				
//GlobalLink Settings
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_URL,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_URL).sendKeys("http://techqa12.translations.com/PD");
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Username,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Username).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Username"));
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Password,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Password).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Pass"));
				Thread.sleep(1000);
			
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_SubmissionNamePrefix,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_SubmissionNamePrefix).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Submission_Name_Prefix"));
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Classifier,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Classifier).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Classifier"));
				Thread.sleep(1000);
		
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Maxnumber_of_filespersubmission,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Maxnumber_of_filespersubmission).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Max_number_of_files_per_submission"));
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Translation_retrieval_batch_size,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Translation_retrieval_batch_size).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("Translation_retrieval_batch_size"));
				Thread.sleep(1000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_UID,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_UID).sendKeys(BrowserFactory.SystemEngine().properties.getProperty("UID"));
				Thread.sleep(1000);

				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox_checked,  5)){
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Use_UID_for_retrieval_checkbox).click();
				Thread.sleep(2000);
				}

				//Test settings
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Save_and_Test_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Save_and_Test_button).click();
				Thread.sleep(5000);
				
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
			assertion=Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Changes_Saved_msg,  25);
			if(assertion == false){
				report("f"," assertion is failed while verifying GlobalLinkAdaptor_Version");
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
