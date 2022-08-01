package GL_Translation_Job_Content;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
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

/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify if page is imported with auto-published setting ON mark it as primary version.
* 
* Summary 		: This test verifies if page is imported with auto-published setting ON then adapter should mark that imported page as primary version.

*
*******************************************************************************************************************************************************************/


public class EPI_1467529 {

	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	
	String SubName = "EpiServer_Sub_1467529";
	String ProjectName= "EPiServer";
	String actualTooltip="";
	
	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1467529");
		dataSet.put("TL_test_case_description","EPI_1467529: Verify if page is imported with auto-published setting ON mark it as primary version");
		dataSet.put("TL_internal_testCase_ID", "1467529");
				
			
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{	
				General.action().login();
				Thread.sleep(2000);
				//create submission
				common.action().create_basic_submission("Alloy Meet",SubName, true, false, false, false, false, true, "2", false, false, true, true, true, "None");
				Thread.sleep(10000);
				
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				
				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_top_aap_bar, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_top_aap_bar).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Dashboard_mdc_drawer_content_CMS, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_mdc_drawer_content_CMS).click();
				Thread.sleep(5000);
		
					//ignore
				if(Verify.action().verifyElementPresent(locators.exts().GLGlobal_Ignore, 15))
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GLGlobal_Ignore).click();
					Thread.sleep(1000);
				}
				
						
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab_edit,  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab_edit).click();
				Thread.sleep(7000);
				
				 WebElement primary_Draft = BrowserFactory.SystemEngine().findElement(locators.exts().Edit_Gl_Primary_version_draft);				           
			     actualTooltip = primary_Draft.getAttribute("title");	
			        
			        //Assert the tooltip's value is as expected 		
			        System.out.println("Actual Title of Tool Tip"+ actualTooltip);
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
			assertion=Verify.action().verifyTextNotPresent(actualTooltip, 10);
	    	if(assertion == false){
				report("f"," assertion is failed while verifying Primary Draft Version");
						
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
