package org.gs4tr.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {
	public static   WebDriver driver;
	private static BrowserFactory testSystem;
	
	public static Properties prop;
	public Properties properties = new Properties();
	public String properties_browser;
	public String properties_workflowDir;
	public String properties_sourceDir;
	public String properties_downloadSubdir;
	public String properties_tmpDir;
	public String properties_downloadTargetDir;
	
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	private final String SUBMISSION_FILES_PATH = "data" + File.separator + "submission_files";
	
	
	public static synchronized BrowserFactory SystemEngine() {
		try {
			if (testSystem.equals(null)) {
				testSystem = new BrowserFactory();
			}
		} catch (Exception NOSYSTEM) {
			testSystem = new BrowserFactory();
		}
		return testSystem;
	}
	
	
	public BrowserFactory(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
					+ "/config/config.properties");
			prop.load(ip);
			
			properties_sourceDir = (new File(this.SUBMISSION_FILES_PATH).getAbsolutePath() + "\\");			
			properties_downloadSubdir = BrowserFactory.prop.getProperty("downloadSubDir");
			properties_downloadTargetDir=BrowserFactory.prop.getProperty("downloadTargetDir");
			properties_tmpDir = (new File("tmp").getAbsolutePath() + "\\");
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver startApplication(String FileName)
	{
		properties_browser= prop.getProperty("browserName");
		
		try {
			if(properties_browser.equalsIgnoreCase("chrome"))
			{
				/*
				 * ChromeOptions options = new ChromeOptions();
				 * options.addArguments("disable-infobars");
				 * System.setProperty("webdriver.chrome.driver", "./Drivers/ChromeDriver.exe");
				 * driver=new ChromeDriver(options);
				 * driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
				 */			
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
					prefs.put("download.prompt_for_download", false);
                    prefs.put("credentials_enable_service", false);
                    prefs.put("password_manager_enabled", false);

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("chrome.switches","--disable-extensions");
                    options.addArguments("--disable-notifications");
                    options.addArguments("disable-infobars");
                    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    options.setExperimentalOption("useAutomationExtension", Boolean.valueOf(false));
                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("--test-type");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
			}
			else if(properties_browser.equalsIgnoreCase("firefox"))
			{
				FirefoxOptions fOptions = new FirefoxOptions();

				fOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/srt,text/csv,application/csv,application/zip,text/zip");
				fOptions.addPreference("browser.helperApps.neverAsk.openFile", "text/srt,text/csv,application/csv,application/zip,text/zip");				
				fOptions.addPreference("browser.download.folderList", 1);
				fOptions.addPreference("browser.helperApps.alwaysAsk.force", true);
				fOptions.addPreference("browser.download.manager.showWhenStarting", false);
				fOptions.addPreference("browser.safebrowsing.downloads.remote.block_potentially_unwanted", false);
				fOptions.addPreference("browser.safebrowsing.downloads.remote.block_uncommon", false);
				fOptions.addPreference("browser.safebrowsing.downloads.remote.block_dangerous", false);
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				
			}
			else if(properties_browser.equalsIgnoreCase("IE"))
			{
				WebDriverManager.iedriver().arch32().setup();
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				ieCapabilities.setCapability("ignoreProtectedModeSettings",1);
				ieCapabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings",true);
				ieCapabilities.setCapability("nativeEvents",true);
				ieCapabilities.setCapability("browserFocus",true);
				ieCapabilities.setCapability("ignoreZoomSetting", true);
				ieCapabilities.setCapability("requireWindowFocus","true");
				ieCapabilities.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
				ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver = new InternetExplorerDriver(ieCapabilities);
				  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 				
				
			}
			else if(properties_browser.equalsIgnoreCase("Edge"))
			{
				  WebDriverManager.edgedriver().setup();
				DesiredCapabilities capabilities = DesiredCapabilities.edge();
				driver=new EdgeDriver(capabilities);
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			}
			else
			{
				System.out.println("We do not support this browser yet");
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			writeToLog("Init|");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;	
	}
	
	public static void quitBrowser()
	{
		driver.quit();
	}
	/**
	 *  Finds an element using driver object
	 *  
	 * @param locator
	 * @return WebElement
	 */
	public  WebElement findElement(String locator)
	{
		return driver.findElement(By.xpath(locator));
	}
	
	public  List<WebElement> findElements(String locator)
	{
		return driver.findElements(By.xpath(locator));
	}
	
	public WebElement findElementByName(String locator)
	{
		return driver.findElement(By.name(locator));
	}

	
	public static void writeToLog(String message)
	{
	BrowserFactory.SystemEngine();
	((JavascriptExecutor)BrowserFactory.driver).executeScript("type=\""+message+"\"");
	}
	
	public void writeVerifyToLog(String command,String element,String expectedValue,String result)
	{
	BrowserFactory.SystemEngine();
	((JavascriptExecutor)BrowserFactory.driver).executeScript("type=\""+"Verify|"+command+"|"+element+"|"+expectedValue+"|"+result+"|\"");
	}

	
	public boolean verifyElementPresent(String tagName, int second)
			throws Exception {
		boolean result = false;
		try{
			WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
			if(tagName.indexOf("/")!=0)
			{
				System.out.println("//");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(tagName)));
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tagName)));
			}
			result=true;
		}
		catch(Exception e)
		{
			System.err.print(e);
			//throw new Exception(e);
		}
		return result;
	}
	/**There is no way we can check a text is present on a page. we can check text of element.
	 * 
	 * Verifies text is present in the current page loaded in the browser. Used
	 * to confirm the presence of an element without breaking the test and
	 * returning a boolean.
	 * 
	 * @param text
	 *            text of element to verify if present.
	 * 
	 * @param second
	 *            value in seconds to wait for an element.
	 * 
	 * @return boolean condition of element's existence.
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */
	public boolean verifyTextPresent(String text, int second) throws Exception {
		  for (int _second = 0;; _second++) {
		   if (_second >= second)
		   {    
		    return false;
		   }
		   try {
BrowserFactory.SystemEngine();
			//		    if (BrowserFactory.SystemEngine().selenium1.getBodyText().contains(text))
			if (BrowserFactory.driver.findElement(By.tagName("body")).getText().contains(text))
		     return true;
		   } catch (Exception e) {
		   }
		   Thread.sleep(1000);
		  }
		 }

	/**There is no way we can check a text is present on a page. we can check text of element.
	 * 
	 * Verifies text is not present in the current page loaded in the browser.
	 * Used to confirm the absence of an element without breaking the test and
	 * returning a boolean.
	 * 
	 * @param text
	 *            text of element to verify if present.
	 * 
	 * @param second
	 *            value in seconds to wait for an element.
	 * 
	 * @return boolean condition of element's existence.
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */
	
	
	public boolean verifyTextNotPresent(String text, int second)
			   throws Exception {
			  for (int _second = 0;; _second++) {
			   if (_second >= second)
			   {
				   return false;
			   }
			   try {
				BrowserFactory.SystemEngine();
				if (!BrowserFactory.driver.findElement(By.tagName("body")).getText().contains(text))
			     return true;
			   } catch (Exception e) {
			   }
			   Thread.sleep(1000);
			  }
			 }
	/** try using web driver wait
	 * Verifies an element is not present in the current page loaded in the
	 * browser. Used to confirm the presence of an element without breaking the
	 * test and returning a boolean.
	 * 
	 * @param tagName
	 *            name of element to verify if present.
	 * 
	 * @param second
	 *            value in seconds to wait for an element.
	 * 
	 * @return boolean condition of element's existence.
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */
	public boolean verifyElementNotPresent(String tagName, int second)
			throws Exception {
		boolean result = true;
		try
		{
			BrowserFactory.SystemEngine();
			WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
			if(tagName.indexOf("/")!=0)
			{
				System.out.println("//");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(tagName)));
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tagName)));
			}
			result=false;
		}
		catch(Exception e)
		{
			System.err.print(e);
			
			//throw new Exception(e);
		}
		BrowserFactory.SystemEngine().writeVerifyToLog("verifyElementNotPresent",tagName,"true",result+"");
		return result;
	}
 
	
}
