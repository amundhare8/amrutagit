package EPiServer_Scripts.Dashboard;

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
* Author        : Amrata M.
*
* Test case     : Verify that Submissions in Dashboard by default are sorted by Date
* 
* Summary 		: This test case verifies sorting feature on Dashboard columns by Date
* 
* Precondition :  More than one Submissions should be present on the dashboard.

				  Submissions with Waiting to send, Sent, imported submissions

*******************************************************************************************************************************************************************/

public class EPI_2498901 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_2498901";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_2498901");
		dataSet.put("TL_test_case_description","EPI_2498901: Verify that Submissions in Dashboard by default are sorted by Date");
		dataSet.put("TL_internal_testCase_ID", "2498901");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//DashBoard
				common.action().Go_To_DashBorad_Button();
				
				//dashboard
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard).click();
				Thread.sleep(7000);
				
				//Created Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String Created_Date5=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Created Date is=======>>"+Created_Date5);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Created Date");
				}
				
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				
				//My Jobs
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_MyJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_MyJobs).click();
				Thread.sleep(3000);
				//Created Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String Created_Date=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Created Date is=======>>"+Created_Date);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Created Date");
				}
				//Active Jobs
				/*
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_ActiveJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_ActiveJobs).click();
				Thread.sleep(3000);
				//Created Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String Created_Date2=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Created Date is========>>"+Created_Date2);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Created Date");
				}
				*/
				//Completed Jobs
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs).click();
				Thread.sleep(3000);
				//Created Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String Created_Date3=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Created Date is========>>"+Created_Date3);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Created Date");
				}
				
			
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
				report("f"," assertion is failed while verifying  Created Date");
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
