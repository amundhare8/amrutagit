package GL_Translation_Job_Language;

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
import locators.PD4_main_Locators;
import locators.locators;

/***********************************************************************************************
* Author        : Amrata M.
*
* Test case     : Validate GlobalLink Translation projects assigned to PD user
* Preconditions : Multiple projects with same PD user should be configured for the user in PD.
* Summary 		: This test case verifies if the submitter in Episerver can choose different Projects in PD for a submission.

				:  Verify correct PD project is displayed in the PD project column on Episerver dashboard.
***********************************************************************************************/
public class EPI_979454 {
	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_979454";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979454");
		
		dataSet.put("TL_test_case_description","EPI_979454: Validate GlobalLink Translation projects assigned to PD user");
		dataSet.put("TL_internal_testCase_ID", "979454");
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission
				common.action().create_basic_submission("Search",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "None");
				Thread.sleep(5000);
				
				//Run Schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
				
				// Go to DashBoard Button
				common.action().Go_To_DashBorad_Button();
				
				//GlobalLink_Dashboard_Submission_ID
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
				String globalink_Sub_ID = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
				System.out.println("Globalink Submission ID is========>>" + globalink_Sub_ID);


				// Status
				assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1 = BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
				System.out.println("Globalink Status is========>>" + globalink_Status1);

				if (assertion == false) {
					report("f", " assertion is failed while verifying  Status");
				}
				
				//open pd url
				common.action().Open_New_Instance_URL(EPiServer_Common_Properties_Cred.GlobalLink_url);
				
				//pd login
				common.action().PDlogIn(EPiServer_Common_Properties_Cred.Username, EPiServer_Common_Properties_Cred.Pass);

				//Inside PD
				common.action().Inside_PD(globalink_Sub_ID);
				
				//Due_date
				assertion = Verify.action().verifyElementPresent(PD4_main_Locators.exts().admin_accountButton_Project, 10);
				String project = BrowserFactory.SystemEngine().findElement(PD4_main_Locators.exts().admin_accountButton_Project).getText();
				System.out.println("PD  Project is========>>" + project);
				if (assertion == false) {
					report("f", " assertion is failed while verifying PD Project");
				}
				else{
				report("p", EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}
				Thread.sleep(2000);
				
				//logout
				common.action().PDlogOut();
	
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
					report("f"," assertion is failed while verifying PD Project");
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
