package GL_AddonConfiguration_WizardSettingTab;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.utility.BrowserFactory;
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


/******************************************************************************************************************************************************************
* Author        : Amrata M.
*
* Test case     : Verify 'Existing content Types' sorting order
* 
* Preconditions : Go to 'GlobalLink Add-on configuration' 'Wizard settings'
* Summary       : This tc is to verify the sorting of Existing Content types under Wizard settings
*
*******************************************************************************************************************************************************************/

public class EPI_4025585 {

    	Boolean assertion = true;
		LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
		
		String SubName = "EpiServer_Sub_4025585";
		String ProjectName= "EPiServer";
		String globalink_Jobname="";
		
		@BeforeMethod
		public void setUp() throws Exception{
			BrowserFactory.SystemEngine().startApplication("EPI_4025585");
			dataSet.put("TL_test_case_description","EPI_4025585: Verify 'Existing content Types' sorting order");
			dataSet.put("TL_internal_testCase_ID", "4025585");
					
				
		}	
			@SuppressWarnings("unchecked")
			public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
				try{	

					General.action().login();
					Thread.sleep(2000);
					
					common.action().Go_to_Globalink_config();
			
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings"), 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Wizard settings")).click();
					Thread.sleep(1000);
					
					Select options = new Select(BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Wizard_ContenttypeSelect));
			        
			        // Get all options from category dropdown
			        List<WebElement> lists = options.getOptions();
			        
			        //Creating a List to store all dropdown values
			        List<String> OriginalList = new ArrayList();
			        
			        //Using for-each loop fetch all options one by one and get their values
			        for(WebElement ele : lists) {
			            
			            OriginalList.add(ele.getText());
			        }
			        
			        System.out.println("Options in dropdown: " +OriginalList);
			        
			        //Creating temp List - same copy of Original for comparing purpose
			        List<String> templist = new ArrayList<String>(OriginalList);
			        
			        System.out.println("Temp List: " + templist);
			        
			        //Sorting the Original List 
			        Collections.sort(OriginalList);
			        System.out.println("Sorted List:" + OriginalList );
			        
			        
			        // In IF Condition we will compare both List
			        if(OriginalList.equals(templist)) {
			            
			            System.out.println("List is Sorted");
			            
			        }else {
			            
			            System.out.println("List is unsorted");
			        }
					
					
					
			        assertion=OriginalList.equals(templist);		
					Thread.sleep(2000);
					System.out.println("Flag=="+assertion);
					if(assertion == false){
						report("f"," assertion is failed while verifying List is unsorted.");
					}
					
					//
				//	FIELD CONFIG TTAB
			
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Field"), 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Settings_Tab("Field")).click();
					Thread.sleep(1000);
					
					//GlobalLink_GlobalLink_Fieldselect
					Verify.action().verifyElementPresent(locators.exts().GlobalLink_GlobalLink_Fieldselect, 5);
					BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_GlobalLink_Fieldselect).click();
					Thread.sleep(1000);
					
					
					ArrayList<String> obtainedList = new ArrayList<String>(); 
					List<WebElement> elementList=  BrowserFactory.SystemEngine().findElements(locators.exts().GlobalLink_GlobalLink_Fields);
					for(WebElement we:elementList){
					   obtainedList.add(we.getText());
					}
					ArrayList<String> sortedList = new ArrayList<String>();   
					for(String s:obtainedList){
					sortedList.add(s);
					}
					Collections.sort(sortedList);
					
					if(sortedList.equals(obtainedList)) {
				            
				            System.out.println("List is Sorted");
				            
				        }else {
				            
				            System.out.println("List is unsorted");
				        }
			        assertion=sortedList.equals(obtainedList);		
					Thread.sleep(2000);
					System.out.println("Flag=="+assertion);
					if(assertion == false){
						report("f"," assertion is failed while verifying List is unsorted.");
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
					report("f"," assertion is failed while verifying List is unsorted.");
							
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
