package EPiServer_Commerce;

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
import locators.locators;

/**===========================================================================================
 * @author       : Amrata M.
 * Test case     : Verify validation messages on GlobalLink Config page for Wizard settings tab
 * Test Id       : 1010334
 * Summary   	 : This test case verifies the validations of Wizard settings tab
 *
 ===========================================================================================*/

public class EPI_1010334 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_1010334");
		          //  Test case description here
				dataSet.put("TL_test_case_description","1010334: Verify validation messages on GlobalLink Config page for Wizard settings tab");
				dataSet.put("TL_internal_testCase_ID", "1010334");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().CMS_Select_tab("Admin"),  15);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_Select_tab("Admin")).click();
				Thread.sleep(7000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_menu_iFrame));
				Thread.sleep(3000);
				
				Verify.action().verifyElementPresent(locators.exts().Admin_Select_tab("Config"),  25);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_Select_tab("Config")).click();
				Thread.sleep(2000);
								
				Verify.action().verifyElementPresent(locators.exts().Admin_ConfigTab_GlobalLink_config,  10);
				BrowserFactory.SystemEngine().findElement(locators.exts().Admin_ConfigTab_GlobalLink_config).click();
				Thread.sleep(5000);
				
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().defaultContent();
				Thread.sleep(2000);
				BrowserFactory.SystemEngine();
				BrowserFactory.driver.switchTo().frame(BrowserFactory.SystemEngine().findElement(locators.exts().CMS_amdnin_containt_iFrame));
				Thread.sleep(3000);
				
                 //GlobalLink Wizard Settings Tab				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_Settings_Tab("Wizard"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_Settings_Tab("Wizard")).click();;
				Thread.sleep(3000);
				
				
				//Inside tab
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Default_Source_Locale_SelectOptions_text,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_Source_Locale_SelectOptions("English (en)")).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardTab_Due_date,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).clear();
				Thread.sleep(1000);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Due_date).sendKeys("");
				Thread.sleep(2000);
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Block).click();
				}
				Thread.sleep(2000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Pages).click();
				}
				Thread.sleep(2000);
				
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_referenced_content_Media).click();
				}
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Reference_depth).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Reference_depth).sendKeys("2");
				Thread.sleep(2000);
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Unchanged_Content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Unchanged_Content).click();
				}
				Thread.sleep(2000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_source_content).click();
				}
				Thread.sleep(2000);
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_expired_target_content).click();
				}
				Thread.sleep(2000);
				
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Post_Translation_Action_selectOption("Auto Publish")).click();
				Thread.sleep(3000);
				
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Duplicate_Request).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Include_Duplicate_Request).click();
				}
				Thread.sleep(3000);
				
				if ( !BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Exclude_showing_CMS_content).isSelected() )
				{
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Exclude_showing_CMS_content).click();
				}
				Thread.sleep(3000);
				
				//select
				String[] listItems1= {"[] CustomizedSearchAdvancedSettings","[Default] PageListBlock","[Specialized] ContainerPage"};
				General.selectMulti(listItems1,locators.exts().GlobalLink_WizardSetting_Existing_Content_Type);
				Thread.sleep(5000);
							
				//>
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_ContentType_Single_Forword).click();
				Thread.sleep(3000);
				
				//select-All
				String[] listItems2= {"[] CustomizedSearchAdvancedSettings","[Default] PageListBlock","[Specialized] ContainerPage"};
				General.deSelectMulti(listItems2,locators.exts().GlobalLink_WizardSetting_Existing_Content_Type);
				Thread.sleep(5000);
							
				//<
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_ContentType_Single_Backword).click();
				Thread.sleep(3000);
				
				//--All Select
				
				String[] listItems3= {"[] GenericMedia","[] CustomizedSearchBlock","[] CustomizedSearchAdvancedSettings","[] CustomizedSearchSettings","[] ImageFile","[] LocaleBlock","[] ReferencedContent",
						"[] SysContentAssetFolder","[] SysContentFolder","[] SysRecycleBin","[] SysRoot","[] TranslationProject","[] TranslationRoot","[] VideoFile","[Default] ButtonBlock","[Default] ContactBlock",
						"[Default] NewsPage","[Default] PageListBlock","[Default] SiteLogotypeBlock","[Default] StandardPage","[Default] TeaserBlock","[Information] EditorialBlock","[News] ArticlePage","[Products] ProductPage",
						"[Specialized] ContactPage","[Specialized] ContainerPage","[Specialized] FindSearchPage","[Specialized] JumbotronBlock","[Specialized] LandingPage","[Specialized] StartPage"};
				General.selectMulti(listItems3,locators.exts().GlobalLink_WizardSetting_Existing_Content_Type);
				Thread.sleep(5000);
			
				//>>
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_ContentType_Single_DoubleForword).click();
				Thread.sleep(3000);
				
				
				//deselect All
				String[] listItems4= {"[] GenericMedia","[] CustomizedSearchBlock","[] CustomizedSearchAdvancedSettings","[] CustomizedSearchSettings","[] ImageFile","[] LocaleBlock","[] ReferencedContent",
						"[] SysContentAssetFolder","[] SysContentFolder","[] SysRecycleBin","[] SysRoot","[] TranslationProject","[] TranslationRoot","[] VideoFile","[Default] ButtonBlock","[Default] ContactBlock",
						"[Default] NewsPage","[Default] PageListBlock","[Default] SiteLogotypeBlock","[Default] StandardPage","[Default] TeaserBlock","[Information] EditorialBlock","[News] ArticlePage","[Products] ProductPage",
						"[Specialized] ContactPage","[Specialized] ContainerPage","[Specialized] FindSearchPage","[Specialized] JumbotronBlock","[Specialized] LandingPage","[Specialized] StartPage"};
				General.selectMulti(listItems4,locators.exts().GlobalLink_WizardSetting_Existing_Content_Type);
				Thread.sleep(5000);
			
				//<<
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_ContentType_Single_DoubleBackword).click();
				Thread.sleep(3000);
			
				//click save button
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardSetting_Save_Wizard_Settings).click();
				Thread.sleep(3000);
				
		
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
			assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_WizardSetting_Changes_saved,  15);
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
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
	
			
}
