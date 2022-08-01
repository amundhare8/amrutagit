package EPiServer_Scripts.Dashboard;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify Search functionality on job listing page on Dashboard
* Summary   	: This test case verifies the Search functionality on job listing page on Dashboard


************************************************************************************************************************************************/
public class EPI_979474 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979474";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979474");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_979474: Verify Search functionality on job listing page on Dashboard");
				dataSet.put("TL_internal_testCase_ID", "979474");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			
			General.action().login();
			Thread.sleep(2000);
			
			//Create Submission			
			common.action().create_basic_submission("Search",SubName, true, false, false, false, false, true, "2", false, false, false, true, true, "None");
			Thread.sleep(10000);
			
			//Run schedular
			common.action().run_schedular();				
			Thread.sleep(3000);
			
			common.action().verify_RunSchedulerHistroy(1,1);
			
			
			//go to DashBoard Button
			common.action().Go_To_DashBorad_Button();
			
			//Inside Dashboard --ID
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Submission_ID, 10);
			String globalink_PD=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Submission_ID).getText();
		    System.out.println("Globalink Submission ID is========>>"+globalink_PD);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Submission ID");
			}
			
			//Job name
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
			String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
		    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Jobname");
			}
			

			Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).click();
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword).sendKeys(globalink_Jobname);
			Thread.sleep(2000);
			
			
			Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Serach_keyword_Button, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Serach_keyword_Button).click();
			Thread.sleep(2000);
			
				
			}catch(Throwable e){
			report("f", "Execution level error was encountered.\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
			}
		}

	@org.testng.annotations.Test
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
				
	/**
	 * @throws Exception
	 */
	public void assertion() throws Exception{
		try{
			
			if(assertion == false){
				report("f","  assertion is failed while verifying  Submission ID");
			}	
			else{
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
