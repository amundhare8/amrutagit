package GL_AddonConfiguration_DatabaseCleanupTab;

import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class EPI_979518 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_979518";
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979518");
		dataSet.put("TL_test_case_description","EPI_979518: Verify cleaning up �All submissions created before� using calendar date picker on GlobalLink Config page for Database Cleanup tab");
		dataSet.put("TL_internal_testCase_ID", "979518");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission
				common.action().create_basic_submission("Alloy Track",SubName, true, false, false, false, false, true, "2", false, false, false, true, true, "None");
				Thread.sleep(5000);
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy1();
				
			
			
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Database Cleanup");
				 Thread.sleep(3000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_All_submissions_created_before).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_DB_All_submissions_created_before).click();
				}
				
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().Globallink_DB_Date_Button_Before,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globallink_DB_Date_Button_Before).click();
				Thread.sleep(1000);
				
				 DateTimeFormatter format =DateTimeFormatter.ofPattern("MM/dd/yyyy");
                 LocalDateTime now = LocalDateTime.now();
				  String Beforedate=now.format(format).toString();
				 
	               
				Verify.action().verifyElementPresent(locators.exts().Globallink_DB_Date_Button_before_button_cal1,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globallink_DB_Date_Button_before_button_cal1).sendKeys(Beforedate);
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().Globalink_DB_password_input,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globalink_DB_password_input).sendKeys(EPiServer_Common_Properties_Cred.DBcleanup_password);
				Thread.sleep(1000);
				
				Verify.action().verifyElementPresent(locators.exts().Globallink_DB_clean_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().Globallink_DB_clean_button).click();
				Thread.sleep(1000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().alert().accept();
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
				
		assertion=Verify.action().verifyElementPresent(locators.exts().Globallink_DB_all_active_submissions_keep_history,  15);
		if(assertion == false){
			report("f"," assertion is failed while verifying All submissions before date deleted)");
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
