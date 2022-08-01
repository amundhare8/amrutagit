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

/*******************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify that on click on any content name (job), user is able to navigate it to translated page
* Summary   	: This test case verifies that on click on any content name (job), user is able to navigate it to translated page.
					Verify this feature for following CMS entities:
					- Pages
					- Blocks
					- Products
					- Product variations
* Preconditions : GlobalLink adapter should be installed
					
**********************************************************************************************************************************/

public class EPI_1740671 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1740671";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1740671");
		dataSet.put("TL_test_case_description","EPI_1740671: Verify that on click on any content name (job), user is able to navigate it to translated page");
		dataSet.put("TL_internal_testCase_ID", "1740671");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
	
				//Create Submission			
				common.action().create_basic_submission("Alloy Track",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "None");
				Thread.sleep(10000);

				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(2,1);
				
			////After schedular run go to dashboard press dashboard Button
				common.action().Go_To_DashBorad_Button();
							
				//status
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
				String globalink_Status=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_Status);
				
				if(globalink_Status.equals("Created") || globalink_Status.equals("Sent"))
				{
				
					
					//Run schedular
					common.action().run_schedular();				
					Thread.sleep(3000);
					
					common.action().verify_RunSchedulerHistroy(2,1);
					
				////After schedular run go to dashboard press dashboard Button
					common.action().Go_To_DashBorad_Button();
									
					//status
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
					String globalink_Status1=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
				    System.out.println("Globalink Status is========>>"+globalink_Status1);
				}
				
				
				//dashborad
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_Job_Name).click();
				Thread.sleep(5000);
				
				
				//References
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_References, 10);
				String globalink_References=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_References).getText();
			    System.out.println("Globalink References is========>>"+globalink_References);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  References");
				}
				//Content Type
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_Contenttype, 10);
				String globalink_ContentType=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_Contenttype).getText();
			    System.out.println("Globalink Content Type is========>>"+globalink_ContentType);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Content Name");
				}
				//Target Language
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_targetlang, 10);
				String globalink_TargetLanguage=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_targetlang).getText();
			    System.out.println("Globalink Target Language is========>>"+globalink_TargetLanguage);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Target Language");
				}
				
				//Status
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_status, 10);
				String globalink_status=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_status).getText();
			    System.out.println("Globalink Status is========>>"+globalink_status);
			    
			    
				
				//Translated
				assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_translated, 10);
				String globalink_Translated=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_translated).getText();
			    System.out.println("Globalink Translation is========>>"+globalink_Translated);
			    
				if(assertion == false){
					report("f"," assertion is failed while verifying  Translation");
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
			//Content Name
			assertion=Verify.action().verifyElementPresent(locators.exts().GL_Dashboard_Submission_Contentname, 10);
			String globalink_ContentName=BrowserFactory.SystemEngine().findElement(locators.exts().GL_Dashboard_Submission_Contentname).getText();
		    System.out.println("Globalink Content Name is========>>"+globalink_ContentName);
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying  Content Name");
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
