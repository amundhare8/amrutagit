package GL_AddonConfiguration_GlobalLink_Locale_Mapping_Tab;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
* Author        : Amrata M.
*
* Test case     : Verify add New locale on GlobalLink Config page for 'Local mapping' tab
* 
* Summary       : This tc is to verify that the locales should display only associated languages with the configured PD


 * Preconditions : Create a fresh site and configure PD - PD connection should be successful.
***********************************************************************************************/

public class EPI_3409748 {

	
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_3409748");
		// Write you Test case description here
				dataSet.put("TL_test_case_description","EPI_3409748:Verify whether adapter shown available locales which are associated with the PD user");
				dataSet.put("TL_internal_testCase_ID", "3409748");
	}	 
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink locale mapping
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Locale mapping");
				
				//FOR French
				 if(Verify.action().verifyElementPresent(locators.exts().CMS_locale_mapping_verify_lang_present("English (en)"), 5)) {
						  
						  BrowserFactory.SystemEngine().findElement(locators.exts().CMS_locale_mapping_verify_lang_present("English (en)")).click();
						  Thread.sleep(3000);
						  BrowserFactory.SystemEngine().findElement(locators.exts().Dashboard_configuration_Localemapping_delete_button).click();
						  Thread.sleep(3000);
						
						 
							Alert alert= BrowserFactory.driver.switchTo().alert();
							alert.accept();
						 
							Thread.sleep(5000);
						}
								
					
			Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("en"),  5);
			BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("en")).click();
			Thread.sleep(2000);
			
			assertion=Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_EpiLoacaleSource_list_select_language("en"),  5);
			if(assertion == false){
				report("f"," assertion is failed while verifying EPiServer locale Lang.");
			}
			
			
			Select options = new Select(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_WizardTab_Default_GL_Locale_SelectOptions_text));
	        
	        // Get all options from category dropdown
	        List<WebElement> lists = options.getOptions();
	        
	        //Creating a List to store all dropdown values
	        List OriginalList = new ArrayList();
	        
	        //Using for-each loop fetch all options one by one and get their values
	        for(WebElement ele : lists) {
	            
	            OriginalList.add(ele.getText());
	        }
	        
	        System.out.println("Options in dropdown: " +OriginalList);
	        
	        
	        String[] exp = {"Arabic(Modern Standard) (ar-XY)","Arabic(Qatar) (ar-QA)","Danish(Denmark) (da-DK)","English(United States) (en-US)","French(France) (fr-FR)", "German(Germany) (de-DE)", "Italian(Italy) (it-IT)", "Hindi (hi)","Japanese(Japan) (ja-JP)","Kazakh(Kazakhstan) (kk-KZ)","Portuguese(Portugal) (pt-PT)","Spanish(Spain) (es-ES)"};
            List<String> expList = new ArrayList<String>();
            
            for(int i=0;i<exp.length;i++){
                expList.add(exp[i]);
            }
				
            System.out.println("Exp list is "+expList);
            
            Collections.sort(expList);
          
            if(expList.size()==OriginalList.size()){
                for(int i=0;i<expList.size();i++){
                    //comparing each item in order
                   if(expList.get(i).equals(OriginalList.get(i))){
                        System.out.println("Matched");
                    }else{
                        System.out.println("Not matched");
                    }
                   assertion=expList.get(i).equals(OriginalList.get(i));
                   if(assertion == false){
       				report("f"," assertion is failed while verifying language Verified");
       			}
                }
            }else{
                System.out.println("Drop down values are not same in number");
            }
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).clear();
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Reviewers_Email).sendKeys(EPiServer_Common_Properties_Cred.Recipients);
				Thread.sleep(3000);
				
			
				//Add button
				Verify.action().verifyElementPresent(locators.exts().CMS_admin_localeMapping_add_button,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().CMS_admin_localeMapping_add_button).click();
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
		
		BrowserFactory.quitBrowser();
		}
					
		public void assertion() throws Exception{
		try{
			if(assertion == false){
				report("f"," assertion is failed while verifying language Verified");
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
