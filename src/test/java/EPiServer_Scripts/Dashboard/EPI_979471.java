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

/***************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify default landing contents of Dashboard
* Preconditions : This test case verifies the default landing contents of Dashboard
***********************************************************************************************/
public class EPI_979471 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979471";
	
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979471");
		          //  Test case description here
				dataSet.put("TL_test_case_description","EPI_979471: Verify default landing contents of Dashboard");
				dataSet.put("TL_internal_testCase_ID", "979471");
	}	
	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
		try{
			
			General.action().login();
			Thread.sleep(2000);
			
			//Create Submission
			//Create Submission			
			common.action().create_basic_submission("Alloy Track",SubName, true, false, false, false, false, true, "2", false, false, false, true, true, "None");
			Thread.sleep(10000);
			
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
			
			//Target Language
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Target_language, 10);
			String globalink_Target=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Target_language).getText();
		    System.out.println("Globalink Target Language is========>>"+globalink_Target);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Target Language");
			}
			
			
			//Status
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
		    System.out.println("Globalink Status is========>>"+globalink_Status);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Status");
			}
			
			//Creator
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Creator, 10);
			String Creator=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Creator).getText();
		    System.out.println("Globalink Status is========>>"+Creator);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying Creator");
			}
			//Created Date
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Date, 10);
			String Created_Date=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Date).getText();
		    System.out.println("Globalink Status is========>>"+Created_Date);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Created Date");
			}
			
				
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
		//GL status
		assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
		String globalink_Status3=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
	    System.out.println("Globalink Status is========>>"+globalink_Status3);
	    
		if(assertion == false){
			report("f"," assertion is failed while verifying  Status");
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
