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
* Test case     : Verify last updated date column in dashboard
* 
* Summary 		: This tc is to verify that Last modified date is column is added for all the tabs under Dashboard.
* 
* Precondition :  More than one Submissions should be present on the dashboard.

				  Jobs with different status(Sent, Imported, ImportError/exportError, Cancelled, Archived, Published) should be present on the Dashboard.

*******************************************************************************************************************************************************************/


public class EPI_3409741 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_3409741";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_3409741");
		dataSet.put("TL_test_case_description","EPI_3409741: Verify last updated date column in dashboard");
		dataSet.put("TL_internal_testCase_ID", "3409741");
				
			
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
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String mod_Date4=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Modified Date is========>>"+mod_Date4);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Modified Date");
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
				//Modified Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String mod_Date=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Modified Date is========>>"+mod_Date);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Modified Date");
				}
				//Active Jobs
				/*
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_ActiveJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_ActiveJobs).click();
				Thread.sleep(3000);
				//Modified Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String mod_Date2=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Modified Date is========>>"+mod_Date2);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Modified Date");
				}
				*/
				//Completed Jobs
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_CompletedJobs).click();
				Thread.sleep(3000);
				//Modified Date
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Modified, 10);
				String mod_Date5=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Modified).getText();
			    System.out.println("Globalink Modified Date is========>>"+mod_Date5);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Modified Date");
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
				report("f"," assertion is failed while verifying  Modified Date");
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
