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
* Test case     : Verify Project Director details are getting saved on 'GlobalLink Settings' tab with confirmation message
* Test Id       : 4454
* Summary   	: This test case will cover the scenario when valid information is given to all the parameters below it will verify that these changes can be saved.
* 				  GlobalLink URL
* 				  User Id
* 				  Password
* 				  Submission Name Prefix
* 				  Classifier (File format)
* 				  Max Targets Count
***********************************************************************************************/
public class EPI_4454 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4454");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_4454:Verify Project Director details are getting saved on 'GlobalLink Settings' tab with confirmation message");
				dataSet.put("TL_internal_testCase_ID", "4454");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				

				//GlobalLink Settings
				common.action().Go_to_Globalink_config();
												
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
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_Saved_msg,  35);
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
