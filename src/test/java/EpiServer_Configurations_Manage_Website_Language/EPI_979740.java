package EpiServer_Configurations_Manage_Website_Language;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
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

/******************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify Add Site Locale from Manage Website languages
* 
************************************************************************************************************************************************/
public class EPI_979740 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979740");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_979740 : Verify Add Site Locale from Manage Website languages");
				dataSet.put("TL_internal_testCase_ID", "979740");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//Inside Manage Website Language
				common.action().Inside_Manage_Website_Language("Admin","Config");
				
				//ManageWebsite_Lang_AddLang
				Verify.action().verifyElementPresent(locators.exts().ManageWebsite_Lang_AddLang,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().ManageWebsite_Lang_AddLang).click();
				Thread.sleep(2000);
								
				//Add italiano
				WebElement element =BrowserFactory.SystemEngine().findElement(locators.exts().ManageWebsitelang_Italia("italiano (Svizzera)"));
				JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.driver;
				js.executeScript("arguments[0].scrollIntoView();", element); 
				Thread.sleep(2000);
				
				
				Verify.action().verifyElementPresent(locators.exts().ManageWebsitelang_Italia("italiano (Svizzera)"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().ManageWebsitelang_Italia("italiano (Svizzera)")).click();
				Thread.sleep(2000);
								
				//Save
				Verify.action().verifyElementPresent(locators.exts().ManageWebsitelang_save,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().ManageWebsitelang_save).click();
				Thread.sleep(2000);
				
				
				
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
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{
			assertion=Verify.action().verifyElementPresent(locators.exts().ManageWebsitelang_Italia,  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying language added");
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
