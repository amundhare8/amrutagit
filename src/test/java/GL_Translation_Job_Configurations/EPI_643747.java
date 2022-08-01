package GL_Translation_Job_Configurations;

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

/***************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify 'Create EPiServer Project For Approval' option for post translation action on configuration tab.
* 
* Summary       : This test case verifies the functionality of 'Create EPiServer Project For Approval' option for post translation action on configuration tab.
* 
***************************************************************************************************************************************************************/

public class EPI_643747 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_643747";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_643747");
		dataSet.put("TL_test_case_description","EPI_643747: Verify 'Create EPiServer Project For Approval' option for post translation action on configuration tab.");
		dataSet.put("TL_internal_testCase_ID", "643747");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission			
				common.action().create_basic_submission("Alloy Plan",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "Create EPiServer Project For Approval");
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
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status1);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Status");
				}
			
				
				assertion=common.action().verify_submission_Status(SubName, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				
				//dashboard cms-edit
				common.action().Go_To_DashBorad_CmsEdit("Edit");
				Thread.sleep(3000);
				
				
				//click on search
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page("Alloy Plan")).click();
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
			assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_Status("Ready to Publish"), 10);
			if(assertion == false){
				report("f"," assertion is failed while verifying Status");
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
