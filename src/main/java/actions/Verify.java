/*
 * 
 */
package actions;

/*Created by Mayureshwar Kadam
 * 03/03/2020
 */


import java.io.File;

import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify {

	private static Verify general_actions;

	/**
	 * Method used to self-instantiate the class. Will make sure one object, and
	 * one object only is created in memory for this class. The purpose is to be
	 * able to call this object dynamically from any JAVA class that includes
	 * this as an import.
	 * 
	 * @return Returns the object instantiated from the class.
	 */
	public static synchronized Verify action() {
		try {
			if (general_actions.equals(null)) {
				general_actions = new Verify();
			}
		} catch (Exception NOSYSTEM) {
			general_actions = new Verify();
		}
		return general_actions;
	}

	

	/**
	 * Verifies an element is present in the current page loaded in the browser used Web driver Wait
	 * 
	 * 	 * @param tagName
	 *            name of element to verify if present.
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */

	public void isPresent(String tagName) throws Exception{
	int time=30;
		try{
			BrowserFactory.SystemEngine();
			WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,time);
			if(tagName.indexOf("/")!=0)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(tagName)));
			}
			else
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tagName)));
			}
		}
		catch(Exception e)
		{
			System.err.print(e);
			throw new Exception(e);
		}
			
		
	}

	/** Not Required
	 * 
	 * Verifies an element is present in the current page loaded in the browser.
	 * Used to confirm the presence of an element without breaking the test and
	 * returning a boolean.
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
	public boolean ifIsPresent(String tagName, int second) throws Exception {
		boolean result=false;
		try{
			BrowserFactory.SystemEngine();
			WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
			if(tagName.indexOf("/")!=0)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(tagName)));
			}
			else
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tagName)));
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
	
	/**
	 * Verifies an element with specified text is present in the current page
	 * loaded in the browser. Usually used to check the new value after refresh using Webdriver wait
	 * 
	 * @param tagName
	 *            name of element to verify if present.
	 * @param expectedText
	 *            text value expected for an element.
	 * @param second
	 *            the second
	 * @return boolean condition of element's existence.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public Boolean verifyElementTextPresent(String tagName,
			String expectedText, int second) throws Exception{
		boolean result=false;
		try{
			BrowserFactory.SystemEngine();
			WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
			if(tagName.indexOf("/")!=0)
			{
				wait.until(ExpectedConditions.textToBePresentInElement(By.name(tagName), expectedText));
			}
			else
			{
				wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(tagName), expectedText));
			}
			result=true;
			
		}
		catch(Exception e)
		{
			System.out.println("Could not found text: "+expectedText+" with locator: "+tagName);
			//throw new Exception(e);
		}
		return result;
	}
	
	
		/**
		 * 
		 * Changed acc.. since this shld not fail since we do not want the text to be present
		 * Verifies an element with specified text is not present in the current page
		 * loaded in the browser. 
		 * 
		 * @param tagName
		 *            name of element to verify if present.
		 * @param expectedText
		 *            text value expected for an element.
		 * @param second
		 *            the second
		 * @return boolean condition of element's existence.
		 * @throws InterruptedException
		 *             the interrupted exception
		 */
		public Boolean verifyElementTextNotPresent(String tagName,
				String expectedText, int second) throws InterruptedException {
			boolean result=true;
			try
			{
				BrowserFactory.SystemEngine();
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
				if(tagName.indexOf("/")!=0)
				{
					System.out.println("//");
					wait.until(ExpectedConditions.textToBePresentInElement(By.name(tagName), expectedText));
				}
				else
				{
					wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(tagName), expectedText));
				}
				result=false;
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
				//			    if (BrowserFactory.SystemEngine().selenium1.getBodyText().contains(text))
				if (BrowserFactory.driver.findElement(By.tagName("body")).getText().contains(text))

			     return true;
			   } catch (Exception e) {
			   }
			   Thread.sleep(1000);
			  }
			 }

		
		public boolean VerifyCompare_Text(String ActualText, String ExpectedText)
		{
			if(ActualText.equalsIgnoreCase(ExpectedText))
			{ 
				return true; 
				}
			else
			{
			
			return false;
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
						//				    if (!BrowserFactory.SystemEngine().selenium1.getBodyText().contains(text))
						if (!BrowserFactory.driver.findElement(By.tagName("body")).getText().contains(text))
				     return true;
				   } catch (Exception e) {
				   }
				   Thread.sleep(1000);
				  }
				 }

		/**  change this Is present here shld return a boolean try using web driver wait
		 * Verifies an element is present in the current page loaded in the browser.
		 * Used to confirm the presence of an element without breaking the test and
		 * returning a boolean.
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
		
		
		public boolean verifyElementPresent(String tagName, int second)
				throws Exception {
			boolean result = false;
			try{
				System.out.println("-----INSIDE METHOD verifyElementPresent-------");
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
				result=true;
			}
			catch(Exception e)
			{
				System.err.print(e);
				//throw new Exception(e);
			}
			System.out.println("-------EOD verifyElementPresent-------");
			BrowserFactory.SystemEngine().writeVerifyToLog("verifyElementPresent",tagName,"true",result+"");
			return result;
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
				System.out.println("-------INSIDE METHOD verifyElementNotPresent-------");
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
			System.out.println("-------EOD verifyElementNotPresent-------");
			BrowserFactory.SystemEngine().writeVerifyToLog("verifyElementNotPresent",tagName,"true",result+"");
			return result;
		}


	
		/** Verifies an element is visible in the current page loaded in the browser.
		 * Used to confirm the presence of an element without breaking the test and
		 * returning a boolean.
		 * 
		 * @param tagName
		 *            name of element to verify if Visible.
		 * 
		 * @param second
		 *            value in seconds to wait for an element.
		 * 
		 * @return boolean condition of element's existence.
		 * 
		 * @throws Exception
		 *             used by Thread.sleep, which requires an exception handler.
		 */
		public boolean verifyElementIsVisible(String tagName, int second)
				throws Exception {
			boolean result = false;
			try{
				System.out.println("-------INSIDE METHOD verifyElementIsVisible-------");
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
				result=true;
				
				
			}
			catch(Exception e)
			{
				System.err.print(e);
				//throw new Exception(e);
			}
			System.out.println("-------EOD verifyElementIsVisible-------");
			return result;
		}

		/** Verifies an element is not visible in the current page loaded in the
		 * browser. Used to confirm the absence of an element without breaking the
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
		public boolean verifyElementIsNotVisible(String tagName, int second)
				throws Exception {
			boolean result=true;
			try
			{
				System.out.println("-------INSIDE METHOD verifyElementIsNotVisible-------");
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
			System.out.println("-------EOD verifyElementIsNotVisible-------");
			
			return result;
			
		}

		/**
		 * Verifies an element is checked in the current page loaded in the browser.
		 * Used to confirm the presence of an checked element without breaking the
		 * test and returning a boolean.
		 * 
		 * @param tagName
		 *            name of element to verify if Visible.
		 * 
		 * @param second
		 *            value in seconds to wait for an element.
		 * 
		 * @return boolean condition of element's existence.
		 * 
		 * @throws Exception
		 *             used by Thread.sleep, which requires an exception handler.
		 */
		public boolean verifyElementIschecked(String tagName, int second)
				throws Exception {
			boolean result = false;
			try{
				System.out.println("-------INSIDE METHOD verifyElementIschecked-------");
				BrowserFactory.SystemEngine();
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
				if(tagName.indexOf("/")!=0)
				{
					System.out.println("//");
					wait.until(ExpectedConditions.elementToBeSelected(By.name(tagName)));
				}
				else
				{
					wait.until(ExpectedConditions.elementToBeSelected(By.xpath(tagName)));
				}
				result=true;
				
				
			}
			catch(Exception e)
			{
				System.err.print(e);
				//throw new Exception(e);
			}
			System.out.println("-------EOD verifyElementIschecked-------");
			return result;
			
		}

		/** Mayureshwar
		 * Verifies an element is not checked in the current page loaded in the
		 * browser. Used to confirm an element is not checked without breaking the
		 * test and returning a boolean.
		 * 
		 * @param tagName
		 *            name of element to verify if Visible.
		 * 
		 * @param second
		 *            value in seconds to wait for an element.
		 * 
		 * @return boolean condition of element's existence.
		 * 
		 * @throws Exception
		 *             used by Thread.sleep, which requires an exception handler.
		 */
		public boolean verifyElementIsNotchecked(String tagName, int second)
				throws Exception {
			boolean result = true;
			try
			{
				System.out.println("-------INSIDE METHOD verifyElementIsNotchecked-------");
				BrowserFactory.SystemEngine();
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
				if(tagName.indexOf("/")!=0)
				{
					System.out.println("//");
					wait.until(ExpectedConditions.elementToBeSelected(By.name(tagName)));
				}
				else
				{
					wait.until(ExpectedConditions.elementToBeSelected(By.xpath(tagName)));
				}
				result=false;
				
			}
			catch(Exception e)
			{
				System.err.print(e);
				
				//throw new Exception(e);
			}
			System.out.println("-------EOD verifyElementIsNotchecked-------");
			return result;
			
		}

	/**
	 * Verifies file is available by the path specified. Used to confirm the
	 * presence of a file without breaking the test and returning a boolean.
	 * 
	 * @param filePath
	 *            text of filePath to verify if present.
	 * 
	 * @param second
	 *            value in seconds to wait for a result.
	 * 
	 * @return boolean condition of element's existence.
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */
	public boolean verifyFilePresent(String filePath, int second)
			throws Exception {
		File f = new File(filePath);
		for (int _second = 0;; _second++) {
			if (_second >= second)
				return false;
			try {
				if (f.exists())
					return true;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	
/**
 * Whenever there is error occurs in script this method collects the stack strace i.e error message, and writes to testlink
 * @param e
 * @return error
 */
	
	public String getErrorBuffer(Throwable e) {

		StackTraceElement[] errors = e.getStackTrace();
		StringBuffer errorBuffer = new StringBuffer();
		for (int i = 0; i < errors.length; i++) {
			errorBuffer.append(errors[i]);
			errorBuffer.append("\n");
		}
		System.err
				.println("\nExecution level error encountered.\n\nError Log:\n\n"
						+ errorBuffer);
		return errorBuffer.toString();
	}
	
	
	/**
     * Verifies that directory exists and is not empty.
     * 
     * Used to confirm the presence of a file without breaking the test and returning a boolean.
     * 
     * @param filePath text of filePath to verify if present.
     * 
     * @param second value in seconds to wait for a result.
     * 
     * @return boolean condition of element's existence.
     * 
     * @throws Exception used by Thread.sleep, which requires an exception handler.
     */
    public boolean verifyDirectoryIsNotEmpty(String filePath, int second)throws Exception{
    	File f = new File(filePath);
    	
    	for (int _second = 0;; _second++) {
			if (_second >= second) 
				return false;
			try {
				if (f.isDirectory())
					{
					File [] filelist = f.listFiles();
					if (filelist.length>0)
					return true;
					}
				} catch (Exception e) {} 
				Thread.sleep(1000);
			}
    	}
    
   
    	
 
        
    
    
    public boolean WaitUntilElementPresent(String tagName, int second)
			throws Exception {
		boolean result = false;
		try{
			System.out.println("-------INSIDE METHOD WaitUntilElementPresent-------");
			if(Verify.action().verifyElementIsVisible(tagName, second)){
				BrowserFactory.SystemEngine();
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tagName)));
			}
			result=true;
		}
		catch(Exception e)
		{
			System.err.print(e);
			//throw new Exception(e);
		}
		System.out.println("-------EOD WaitUntilElementclick-------");
		BrowserFactory.SystemEngine().writeVerifyToLog("WaitUntilElementPresent",tagName,"true",result+"");
		return result;
	}
    
    public boolean WaitUntilElementclick(String tagName, int second)
			throws Exception {
		boolean result = false;
		try{
			System.out.println("-------INSIDE METHOD WaitUntilElementclick-------");
			if(Verify.action().verifyElementIsVisible(tagName, second)){
				BrowserFactory.SystemEngine();
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver,second);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tagName)));
			}
			result=true;
		}
		catch(Exception e)
		{
			System.err.print(e);
			//throw new Exception(e);
		}
		System.out.println("-------EOD WaitUntilElementclick-------");
		BrowserFactory.SystemEngine().writeVerifyToLog("WaitUntilElementclick",tagName,"true",result+"");
		return result;
	}
    
}
