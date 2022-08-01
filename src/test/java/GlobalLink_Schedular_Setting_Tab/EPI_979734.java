package GlobalLink_Schedular_Setting_Tab;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
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
 * Test case : Verify Job Scheduler runs at specified intervals entered on GlobalLink Scheduler page for settings tab.
 * 
 * Summary : This test case verifies if the scheduler runs at specifies saved interval.
 *
 *******************************************************************************************************************************************************************/


public class EPI_979734 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception {
		BrowserFactory.SystemEngine().startApplication("EPI_979734");
		dataSet.put("TL_test_case_description","EPI_979734: Verify Job Scheduler runs at specified intervals entered on GlobalLink Scheduler page for settings tab.");
		dataSet.put("TL_internal_testCase_ID", "979734");

	}

	public void testcase(LinkedHashMap<String, String> dataSet) throws Exception {
		try {
			General.action().login();
			Thread.sleep(2000);

			//go to GL Schedular
			common.action().Go_to_GlobalLink_Admin_GLSchedular("Admin","Admin");

			Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
			Thread.sleep(3000);

			if (!BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected()) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
			}
			Thread.sleep(2000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval, 15);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval).clear();
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval).sendKeys("1");
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval_select_Time("6"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval_select_Time("6")).click();
			
			Thread.sleep(2000);

			String parentHandle = BrowserFactory.SystemEngine().driver.getWindowHandle(); // get the current window handle

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_NextSchedular_Date_Button, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_NextSchedular_Date_Button)
					.click();
			Thread.sleep(7000);

			for (String winHandle : BrowserFactory.SystemEngine().driver.getWindowHandles()) {
				BrowserFactory.SystemEngine().driver.switchTo().window(winHandle);

			}

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

			// get current date time with Date()
			Date date = new Date();

			// Now format the date
			String date1 = dateFormat.format(date);

			System.out.println("Todays Date is " + date1);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval_select_TimeInterval("11:00"), 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval_select_TimeInterval("11:00")).click();
			Thread.sleep(2000);

			((JavascriptExecutor) BrowserFactory.SystemEngine().driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_NextSchedular_Date_OK_Button, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_NextSchedular_Date_OK_Button)
					.click();

			BrowserFactory.SystemEngine().driver.switchTo().window(parentHandle); // switch back to the original window
			Thread.sleep(3000);

			BrowserFactory.SystemEngine().driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_Button, 10);
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Save_Button).click();
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

		} catch (Throwable e) {
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
		Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"), 15);
		BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
		Thread.sleep(3000);
		
		try {if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected() )
		{
			BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
			
		}
		Thread.sleep(2000);

			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void assertion() throws Exception {
		try {
			//Status
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_history_Message, 10);
			String history_msg=BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_history_Message).getText();
		   
		    
			if(assertion == false){
				report("f"," assertion is failed while verifying message");
				
			} else {
				report("p", "All assertion are passed");
			}
		} catch (Throwable e) {
			report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"
					+ Verify.action().getErrorBuffer(e));

		}
	}

	public void report(String result, String notes) throws Exception {
		TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),
				EPiServer_TestRail_Common_Properties.idTestPlan, EPiServer_TestRail_Common_Properties.idBuild, result,
				EPiServer_TestRail_Common_Properties.assignedTo, notes);
		if (result == "f")
			assertTrue(false);
	}
}
