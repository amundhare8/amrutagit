package EPiServer_Commerce;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.Verify;
import actions.common;
import locators.locators;
/***********************************************************************************************
* Author        : Mayureshwar
*
* Test case     : Verify remove 'GlobalLink Translation Jobs' gadget
* Test Id       : C1010323
* Summary   	: This test case verifies whether User able to Remove the GlobalLink Translation Jobs Gadget
* Precondition  : GlobalLink Adapter should be installed successfully
*				  GlobalLink Translation Jobs Gadget should be added
***********************************************************************************************/
public class EPI_1010323 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod		
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010323");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_1010323:Verify remove 'GlobalLink Translation Jobs' gadget");
				dataSet.put("TL_internal_testCase_ID", "1010323");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				common.action().toggle_navigation_tree_icon(true);
				
				//add gadget
				//Verify gadget added
				if(Verify.action().verifyElementNotPresent(locators.exts().CMS_edit_GlobalLink_translation_jobs_gadget,  15))
				{
					//add gadget
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button,  15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button).click();
					Thread.sleep(2000);
					
					Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_add_gadgets,  15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_add_gadgets).click();
					Thread.sleep(3000);

					Verify.action().verifyElementPresent(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget,  15);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget).click();
					Thread.sleep(5000);
					
					//created this approach buz xpath changes after adding new gadget, so creating a new instance of browser helps solving this issue
					try {
						BrowserFactory.quitBrowser();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					BrowserFactory.SystemEngine().startApplication("EPI_1010323");
					General.action().login();
					Thread.sleep(2000);
					
					common.action().toggle_navigation_tree_icon(true);
			
				}
				BrowserFactory.SystemEngine();
				List<WebElement> noOfgadgets = BrowserFactory.driver.findElements(By.xpath(locators.exts().CMS_edit_GlobalLink_translation_jobs_gadget));
				System.out.println(noOfgadgets.size());

				if(Verify.action().verifyElementPresent(locators.exts().CMS_edit_Gadget_gear_button,  15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Gadget_gear_button).click();
				}
				else
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GlobalLink_translation_jobs_gadget).click();
					Thread.sleep(1000);
					BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Gadget_gear_button).click();
					Thread.sleep(1000);

				}
				

				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Gadget_gear_button_remove_gadgets,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Gadget_gear_button_remove_gadgets).click();
				Thread.sleep(3000);
			
				Verify.action().verifyElementPresent(locators.exts().CMS_edit_Gadget_gear_button_remove_gadgets_Yes_button,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Gadget_gear_button_remove_gadgets_Yes_button).click();
				Thread.sleep(3000);
			
				BrowserFactory.SystemEngine();
				List<WebElement> noOfgadgets_after = BrowserFactory.driver.findElements(By.xpath(locators.exts().CMS_edit_GlobalLink_translation_jobs_gadget));
				System.out.println(noOfgadgets_after.size());

				if(noOfgadgets_after.size()==noOfgadgets.size()-1)
				{
					assertion=true;
				}
				else
				{
					assertion=false;				
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
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button).click();
			Thread.sleep(2000);
			
			Verify.action().verifyElementPresent(locators.exts().CMS_edit_Settings_gear_button_add_gadgets,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_Settings_gear_button_add_gadgets).click();
			Thread.sleep(3000);

			Verify.action().verifyElementPresent(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget,  15);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget).click();
			Thread.sleep(5000);

		
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
				report("f"," assertion is failed while verifying GL config is saved and correct");
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
