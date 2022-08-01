package GL_AddonConfiguration_Other_Setting_Tab;

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

/**=================================================================================================================================================================================
 * @author       : Amrata M.
 * Test case     : Verify functionality of 'Archive submissions' with date filter on GLobalLink config for 'Other settings' tab
 * Test Id       : 979598
 * Summary   	 : This test case is to verify Archive submissions with and without providing date
 *
 =================================================================================================================================================================================*/

public class EPI_979598 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
	String SubName = "EpiServer_Sub_979598";
	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979598");
		          //  Test case description here
				dataSet.put("TL_test_case_description","979598 : Verify functionality of 'Archive submissions' with date filter on GLobalLink config for 'Other settings' tab");
				dataSet.put("TL_internal_testCase_ID", "979598");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//Create Submission
				common.action().create_basic_submission_AutoPublish("Alloy Plan",SubName, true, false, false, false, false, false, "2", false, false, true, true, true, "Auto Publish");
				Thread.sleep(5000);
			
				//Run schedular
				common.action().run_schedular();				
				Thread.sleep(3000);
				
				common.action().verify_RunSchedulerHistroy(1,1);
				
				common.action().Go_To_DashBorad_Button();
				
				assertion=common.action().verify_submission_Status(SubName, "Published");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				
				//dashboard cms-Admin
				common.action().Go_To_DashBorad_CmsEdit("Admin");
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo()
						.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Config"), 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Config")).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
				Thread.sleep(5000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo()
						.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other")).click();
				
				Thread.sleep(3000);
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately")).click();
				Thread.sleep(2000);
				
				//Inside tab
				String s=common.action().GetDataPlusFormat(2,"MM/dd/yyyy");
				
				System.out.println("Todays Date "+ s);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Archives_Submissions_date_input).sendKeys(s);
				Thread.sleep(2000);
				//
				Verify.action().verifyElementPresent(locators.exts().OtherSetting_Archive, 15);
				 WebElement Archive_tooltip = BrowserFactory.SystemEngine().findElement(locators.exts().OtherSetting_Archive);				           
			     String actualTooltip = Archive_tooltip.getAttribute("title");	
			     System.out.println("Tooltip is "+actualTooltip);
			     
				BrowserFactory.SystemEngine().findElement(locators.exts().OtherSetting_Archive).click();
				Thread.sleep(5000);
							
				assertion= Verify.action().verifyElementPresent(locators.exts().Othersetting_Archive_message, 15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				//go to dashboard
				common.action().Go_To_DashBorad_Button();
				
				//click on tree icon
				if(Verify.action().verifyElementNotPresent(locators.exts().GlobalLink_Dashboard_tree_icon_opened, 5)) {
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_icon).click();
				Thread.sleep(2000);
				}
				
				
				//click on Publish Job
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Dashboard_tree_ArchiveJobs, 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Dashboard_tree_ArchiveJobs).click();
				Thread.sleep(3000);
				
				assertion=common.action().verify_submission_Status(SubName, "Archived");		
				Thread.sleep(2000);
				System.out.println("Flag=="+assertion);
				if(assertion == false){
					report("f"," assertion is failed while verifying submission");
				}
				
				//
				//dashboard cms-Admin
				common.action().Go_To_DashBorad_CmsEdit("Admin");
				Thread.sleep(3000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo()
						.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Config"), 25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Config")).click();
				Thread.sleep(2000);

				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config, 10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
				Thread.sleep(5000);

				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo()
						.frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);

				Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other"), 5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Other")).click();
				Thread.sleep(3000);
				
				String s1=common.action().GetDataPlusFormat(-1,"MM/dd/yyyy");
				
				System.out.println("Todays Date "+ s1);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Archives_Submissions_date_input).sendKeys(s1);//1 day before
				Thread.sleep(2000);
				//
				Verify.action().verifyElementPresent(locators.exts().OtherSetting_Archive, 15);
				 WebElement Archive_tooltip1 = BrowserFactory.SystemEngine().findElement(locators.exts().OtherSetting_Archive);				           
			    // String actualTooltip1 = Archive_tooltip.getAttribute("title");	
			    // System.out.println("Tooltip is "+actualTooltip1);
			     
				BrowserFactory.SystemEngine().findElement(locators.exts().OtherSetting_Archive).click();
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
					
		/**
		 * @throws Exception
		 */
		public void assertion() throws Exception{
		try{	
			assertion= Verify.action().verifyElementPresent(locators.exts().Othersetting_Archive_message, 15);
			if(assertion == false){
				report("f"," assertion is failed while verifying message");
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
