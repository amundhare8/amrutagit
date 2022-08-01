package GlobalLink_Schedular_History_Tab;

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

/******************************************************************************************************************************************************************
 * Author :    Amrata M.
 *
 * Test case : Verify Pagination on GlobalLink Scheduler page for History tab.
 * 
 * Summary 	 : This test case verifies the Pagination on GlobalLink Scheduler page for History tab
 * 
 *******************************************************************************************************************************************************************/


public class EPI_979738 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_979738";
	String ProjectName = "EPiServer";

	@BeforeMethod
	public void setUp() throws Exception {
		BrowserFactory.SystemEngine().startApplication("EPI_979738");
		dataSet.put("TL_test_case_description","EPI_979738: Verify Pagination on GlobalLink Scheduler page for History tab.");
		dataSet.put("TL_internal_testCase_ID", "979738");

	}

	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception {
		try {
			General.action().login();
			Thread.sleep(2000);

			//Create Submission
			common.action().create_basic_submission("Alloy Plan",SubName, true, false, false, false, false, true, "2", false, false, false, true, true, "None");
			Thread.sleep(5000);
			
			//Run schedular
			common.action().run_schedular();				
			Thread.sleep(3000);
			
			common.action().verify_RunSchedulerHistroy1();
			
			//Go to DashBoard
			
			common.action().Go_To_DashBorad_Button();
			
			//Submission ID
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
			String globalink_subid=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
		    System.out.println("Globalink Submission ID is========>>"+globalink_subid);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Submission ID");
			}
			
			
			//Job name
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
			String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
		    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Job Name");
			}
			
			//Target Language
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Target_language, 10);
			String globalink_target_lang=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Target_language).getText();
		    System.out.println("Globalink Target Language is========>>"+globalink_target_lang);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Target Language");
			}
			
			
			
			//GL Created Date
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Date, 10);
			String globalink_date=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Date).getText();
		    System.out.println("Globalink Created Date  is========>>"+globalink_date);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Created Date");
			}
		}

		catch (Throwable e) {
			report("f", "Execution level error was encountered.\n\nError log:\n\n" + Verify.action().getErrorBuffer(e));
		}
	}

	@Test
	public void execute() throws Exception {

		testcase(dataSet);
		assertion();
	}

	public void assertion() throws Exception{
		try{
			//GL status
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
		    System.out.println("Globalink Status is========>>"+globalink_Status1);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Status");
			}else{
				report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
			}
			
			}catch (Throwable e) {
					report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				
				}
		}
	
	@AfterMethod
	public void tearDown() throws Exception {
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void report(String result, String notes) throws Exception {
		TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan, EPiServer_TestRail_Common_Properties.idBuild, result,EPiServer_TestRail_Common_Properties.assignedTo, notes);
		if (result == "f")
			assertTrue(false);
	}

}
