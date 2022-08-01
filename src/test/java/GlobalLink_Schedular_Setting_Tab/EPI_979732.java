package GlobalLink_Schedular_Setting_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
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
* Test case     : Verify selected date value for field �Next scheduled date� is getting save on GlobalLink Scheduler page for settings tab.
* 
* Summary 		: This test case verifies the the date value for field �Next scheduled date� is getting save on GlobalLink Scheduler page for settings tab

*
*******************************************************************************************************************************************************************/

public class EPI_979732 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	
	String ProjectName= "EPiServer";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979732");
		dataSet.put("TL_test_case_description","EPI_979732: Verify selected date value for field �Next scheduled date� is getting save on GlobalLink Scheduler page for settings tab.");
		dataSet.put("TL_internal_testCase_ID", "979732");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				
				//go to GL Schedular
				common.action().Go_to_GlobalLink_Admin_GLSchedular("Admin","Admin");
				
				
				
				Verify.action().verifyElementPresent(locators.exts().GL_Schedular_Setting_tab("Settings"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GL_Schedular_Setting_tab("Settings")).click();
				Thread.sleep(3000);
				
			
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
				}
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval).sendKeys("1");
				Thread.sleep(3000);
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval_select_Time("6"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval_select_Time("6")).click();;
				Thread.sleep(2000);
				
				
				BrowserFactory.SystemEngine();
				String parentHandle = BrowserFactory.driver.getWindowHandle(); // get the current window handle
				
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_NextSchedular_Date_Button,10);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_NextSchedular_Date_Button).click();
				Thread.sleep(7000);
				
			
				BrowserFactory.SystemEngine();
				for (String winHandle : BrowserFactory.driver.getWindowHandles()) {
					BrowserFactory.SystemEngine();
					BrowserFactory.driver.switchTo().window(winHandle); 
					
				}

				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Date_select,10);
				 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Date_select).click();
				 Thread.sleep(2000);
				 
				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Jobinterval_select_TimeInterval("11:00"),  5);
				 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Jobinterval_select_TimeInterval("11:00")).click();
				 Thread.sleep(2000);

				 BrowserFactory.SystemEngine();
				((JavascriptExecutor) BrowserFactory.driver)
				 .executeScript("window.scrollTo(0, document.body.scrollHeight)");
				 Thread.sleep(5000);
				 
				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_NextSchedular_Date_OK_Button,10);
				 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_NextSchedular_Date_OK_Button).click();
				 
				 BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().window(parentHandle); // switch back to the original window
				Thread.sleep(3000);
					
				 BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				 Thread.sleep(3000);
				 
				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_Button,10);
				 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Save_Button).click();
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
		
		public void assertion() throws Exception{
			try{
				 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_msg, 15);
					assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_msg,  15);
					if(assertion == false){
							report("f"," assertion is failed while verifying message");
							
						}
						
				else{
					report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
				}	
					}catch (Throwable e) {
						report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
					
					}
			}
		
		@AfterMethod
		public void tearDown() throws Exception{
		try {
			if (BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).isSelected() )
			{
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Active).click();
				
			}
			Thread.sleep(2000);
			 
			 Verify.action().verifyElementPresent(locators.exts().GlobalLink_Schedular_Save_Button,10);
			 BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Schedular_Save_Button).click();
			 Thread.sleep(5000);
			 
			 
			BrowserFactory.quitBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
}
