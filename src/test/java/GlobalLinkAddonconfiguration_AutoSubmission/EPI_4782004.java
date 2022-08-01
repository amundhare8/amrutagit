package GlobalLinkAddonconfiguration_AutoSubmission;

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
* Test case     : Verify "Create EPiServer Project for Approval" option from "Post Translation Action" field on Auto Submission Tab
* 

* Summary 		: This test case is to Verify "Create EPiServer Project for Approval" option from "Post Translation Action" field on Auto Submission Tab

********************************************************************************************************************************************************************/


public class EPI_4782004 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	public String OriginalpageName="Alloy Meet";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_4782004");
		dataSet.put("TL_test_case_description","EPI_4782004 : Verify \"Create EPiServer Project for Approval\" option from \"Post Translation Action\" field on Auto Submission Tab");
		dataSet.put("TL_internal_testCase_ID", "4782004");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				common.action().Go_to_Globalink_config();
				
				//Auto Submission
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Auto Submission")).click();
				Thread.sleep(1000);
				
			
				if (!BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Creation).click();
				}
				
				//AutoSubmission_PostTranslationAction
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationAction, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationAction).click();
				Thread.sleep(2000);
				
				//AutoSubmission_PostTranslationAction
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_PostTranslationActionSelect("Create EPiServer Project For Approval"), 25);
				if(assertion == false){
					report("f"," assertion is failed while verifying Post Translation Action is saved");
							
		    	}
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_PostTranslationActionSelect("Create EPiServer Project For Approval")).click();
				Thread.sleep(2000);

				//AutoSubmission_Save
				Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Save, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().AutoSubmission_Save).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().AutoSubmission_Msg,5);
		    	if(assertion == false){
					report("f"," assertion is failed while verifying Auto submission is saved");
							
		    	}
		    	//AutoSubmit the pg		    	
		    	common.action().GO_TO_EDIT_AutoSubmission("Edit",OriginalpageName);
				//Dashboard
				common.action().Go_To_DashBorad_Button();
				
				//Run Schedular
			    common.action().run_schedular();
			    
			    // Verify schedular Msg
			    common.action().verify_RunSchedulerHistroy1();
				
			    //go to Dashboard
				common.action().Go_To_DashBorad_Button();
				
				//Job name
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				String globalink_Jobname=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			    System.out.println("Globalink Job Name is========>>"+globalink_Jobname);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Jobname");
				}Thread.sleep(2000);
				
				assertion=common.action().verify_submission_Status(globalink_Jobname, "Imported");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				
				//dashboard cms-edit
				common.action().Go_To_DashBorad_CmsEdit("Edit");
				Thread.sleep(3000);
				
				
				//click on search
				BrowserFactory.SystemEngine().findElement(locators.exts().Select_page(OriginalpageName)).click();
				Thread.sleep(5000);
				
				assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_Status("Ready to Publish"), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Status");
				}
				
				
				//EditProject_click
				Verify.action().verifyElementPresent(locators.exts().EditProject_click, 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().EditProject_click).click();
				Thread.sleep(3000);
				
				assertion=	Verify.action().verifyElementPresent(locators.exts().Edit_Gl_ProjectStatus(globalink_Jobname), 10);
				if(assertion == false){
					report("f"," assertion is failed while verifying Project");
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
		try{	assertion=Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);			
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
