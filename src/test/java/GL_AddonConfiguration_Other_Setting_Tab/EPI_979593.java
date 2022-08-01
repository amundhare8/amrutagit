package GL_AddonConfiguration_Other_Setting_Tab;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.gs4tr.qa.testrail.framework.TestRailClient;
import org.gs4tr.qa.util.FileUtil;
import org.gs4tr.qa.utility.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.EPiServer_Common_Properties_Cred;
import actions.EPiServer_TestRail_Common_Properties;
import actions.General;
import actions.UnzipUtility;
import actions.Verify;
import actions.common;
import locators.locators;

/**=================================================================================================================================================================================
 * @author       : Amrata M.
 * Test case     : Verify ‘Download adapter logs’ of ‘INFO’ level on GlobalLink Config page for 'Other settings' tab
 * Test Id       : 979593
 * Summary   	 : This test case verifies the functionality to download logs from the UI.
 * Precondition  : Log level has been set to ‘INFO’
 *
 =================================================================================================================================================================================*/

public class EPI_979593 {
	Boolean assertion = true;
	LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();

	@BeforeMethod	
	public void setUp() throws Exception{
		BrowserFactory.SystemEngine().startApplication("EPI_979593");
		          //  Test case description here
				dataSet.put("TL_test_case_description","979593 : Verify ‘Download adapter logs’ of ‘INFO’ level on GlobalLink Config page for 'Other settings' tab");
				dataSet.put("TL_internal_testCase_ID", "979593");
	}	
		public void testcase(LinkedHashMap<String, String> dataSet) throws Exception{
			try{
				
				
				General.action().login();
				Thread.sleep(2000);
				
				//GlobalLink Other Setting tab
				common.action().Go_to_GlobalLink_Admin("Admin","Config","Other");
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJob,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJob).click();
				Thread.sleep(2000);
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately"),  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_SubmitJobSelect("Immediately")).click();
				Thread.sleep(2000);
				
				//Inside tab
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting__Log_Lavel_selectOption("INFO")).click();//INFO
				Thread.sleep(3000);		
				
				//Save Button
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_OtherSetting_Save_Other_Setting).click();
				Thread.sleep(3000);
				
				assertion=Verify.action().verifyElementPresent(locators.exts().GlobalLink_Changes_saved,  15);
				if(assertion == false){
					report("f"," assertion is failed while verifying message");
				}
				
				    
				
				Verify.action().verifyElementPresent(locators.exts().GlobalLink_Other_AdapterSettings_Log,  5);
				BrowserFactory.SystemEngine().findElement(locators.exts().GlobalLink_Other_AdapterSettings_Log).click();
				Thread.sleep(20000);
				////
				
				
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
		String zipFilePath="";
		public void assertion() throws Exception{
		try{	
			    String dateformatter=UnzipUtility.dateconvertformatter();
		         zipFilePath = BrowserFactory.SystemEngine().properties_downloadSubdir+dateformatter;//e:/Test/MyPics.zip//GlobalLinkLogs.(20210326).zip
		        String destDirectory  =BrowserFactory.SystemEngine().properties_downloadTargetDir;
		        
		        
		     //   String destDirectory = "C:/Users/amundhare/Downloads/TESTDIR";
		        //unzip file n read the code
			  UnzipUtility unzipper = new UnzipUtility();
			  String filepath=unzipper.unzip(zipFilePath,destDirectory);
			 
			assertion= unzipper.read_Data("INFO",filepath);
			if(assertion == false){
				report("f"," assertion is failed while verifying Logs");
			}else{
				report("p",EPiServer_Common_Properties_Cred.GL_EpiServer_tc_comment);
			}	
				}catch (Throwable e) {
					report("f", "Execution level error was encountered in assertion() .\n\nError log:\n\n"+ Verify.action().getErrorBuffer(e));
				
				}
		finally {
			 System.out.println("delete path is"+zipFilePath);
			 FileUtil.deleteDir(zipFilePath);
			
			    Thread.sleep(2000);
		}
		
		}
		
		
			public void report(String result, String notes) throws Exception
			{
			TestRailClient.testRailReportByID_production(dataSet.get("TL_internal_testCase_ID"),EPiServer_TestRail_Common_Properties.idTestPlan,EPiServer_TestRail_Common_Properties.idBuild,result,EPiServer_TestRail_Common_Properties.assignedTo,notes);
			if(result == "f")
				assertTrue(false);
			}	
}
