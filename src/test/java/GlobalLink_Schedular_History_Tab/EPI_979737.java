package GlobalLink_Schedular_History_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;

/******************************************************************************************************************************************************************
 * Author : Amrata M.
 *
 * Test case : Verify submission history for count of Cancelled targets on
 * GlobalLink Scheduler page for History tab.
 * 
 *******************************************************************************************************************************************************************/

public class EPI_979737 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	String SubName = "EpiServer_Sub_979737";
	String ProjectName = "EPiServer";

	@BeforeMethod
	public void setUp() throws Exception {
		BrowserFactory.SystemEngine().startApplication("EPI_979737");
		dataSet.put("TL_test_case_description",
				"EPI_979737: Verify submission history for count of targets sent for translations on GlobalLink Scheduler page for History tab.");
		dataSet.put("TL_internal_testCase_ID", "979737");

	}

	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception {
		try {
			General.action().login();
			Thread.sleep(2000);

			
			//Create Submission
			common.action().create_basic_submission_AutoPublish("Search",SubName, true, false, false, false, false, false, "2", false, false, false, true, true, "Auto Publish");
			Thread.sleep(5000);

			// Job name
			assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Job_Name, 10);
			String globalink_Jobname = BrowserFactory.SystemEngine()
					.findElement(locators.exts().GlobalLink_Dashboard_Job_Name).getText();
			System.out.println("Globalink Job Name is========>>" + globalink_Jobname);

			if (assertion == false) {
				report("f", " assertion is failed while verifying  Jobname");
			}

			// GL status
			assertion = Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_Status, 10);
			String globalink_Status1 = BrowserFactory.SystemEngine()
					.findElement(locators.exts().GlobalLink_Dashboard_Status).getText();
			System.out.println("Globalink Status is========>>" + globalink_Status1);

			if (!BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_cancel_chkbox)
					.isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_cancel_chkbox).click();
			}
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_cancelJobs, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_cancelJobs).click();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine();
			Alert alt1 = BrowserFactory.driver.switchTo().alert();
			alt1.accept();
			Thread.sleep(3000);

			System.out.println("Cancel sucessfully");

			BrowserFactory.SystemEngine();
			Alert alt = BrowserFactory.driver.switchTo().alert();
			alt.accept();
			Thread.sleep(3000);

			// Run schedular

			Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin).click();
			Thread.sleep(5000);

			Verify.action().verifyElementPresent(locators.exts().Gl_Dashboard_admin_admin, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboard_admin_admin).click();
			Thread.sleep(5000);

			Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo()
					.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Admin"), 25);
			BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Admin")).click();
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().Gl_Dashboardadmin_admin_Glschedular, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Gl_Dashboardadmin_admin_Glschedular).click();
			Thread.sleep(7000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo().defaultContent();
			Thread.sleep(2000);

			BrowserFactory.SystemEngine();
			BrowserFactory.driver.switchTo()
					.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().Schedular_start_manually, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().Schedular_start_manually).click();
			Thread.sleep(5000);

			Thread.sleep(30000);
			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().schedular_msg, 15);
			assertion = Verify.action().verifyElementPresent(locators.exts().schedular_msg, 15);

			if (assertion == false) {
				report("f", " assertion is failed while verifying message");

			}

			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("History"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("History")).click();
			Thread.sleep(3000);

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

	@AfterMethod
	public void tearDown() throws Exception {
		try {
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void assertion() throws Exception {
		try {

			// Status
			assertion = Verify.action().verifyElementPresent(locators.exts().GL_Admin_Schedular_history_status, 10);
			
			if (assertion == false) {
				report("f",
						" assertion is failed while verifying 'history for count of Cancelled targets on GlobalLink Scheduler page for History tab.");

			} else {
				report("p", "All assertion are passed");
			}
		} catch (Throwable e) {
			report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));

		}

	}

	public void report(String result, String notes) throws Exception {
		TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan, EPiServer_TestRail_Common_Properties.idBuild, result,EPiServer_TestRail_Common_Properties.assignedTo, notes);
		if (result == "f")
			assertTrue(false);
	}

}
