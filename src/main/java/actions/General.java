package actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.gs4tr.qa.utility.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import locators.Magentolocators;
import locators.locators;


public class General {

	private static General general;

	/**
	 * Method used to self-instantiate the class. Will make sure one object, and
	 * one object only is created in memory for this class. The purpose is to be
	 * able to call this object dynamically from any JAVA class that includes
	 * this as an import.
	 * 
	 * @return Returns the object instantiated from the class.
	 */
	public static synchronized General action() {
		try {
			if (general.equals(null)) {
				general = new General();
			}
		} catch (Exception NOSYSTEM) {
			general = new General();
		}
		return general;
	}

	
	
	/**
	 * Opens the web-site in the browser from the URL address specified in the
	 * tdc_test.properties file.
	 * 
	 * 
	 */
	public void openURL() {
		String passURL = BrowserFactory.SystemEngine().properties.getProperty("url");
		System.out.println(passURL);
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.get(passURL);
	}

	
	/**
	 * Method used to add to the current date a specified amount of days
	 * 
	 * @param Days
	 *            number of days to add to current date
	 * 
	 * @throws Exception
	 *             used by Thread.sleep, which requires an exception handler.
	 */
	public static String GetDatePlus(Integer Days) throws Exception 
	
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, Days);
		DateFormat dateFormat = new SimpleDateFormat(". dd, yyyy HH:mm", Locale.getDefault());
		DateFormat dateFormat2 = new SimpleDateFormat("MMMM");
		String monthParsed = dateFormat2.format(cal.getTime());
		return (monthParsed.substring(0, 3) + dateFormat.format(cal.getTime()));
	}
	
	public void mouseOver(String locator) throws Exception{
		Thread.sleep(500);
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		act.moveToElement(BrowserFactory.SystemEngine().findElement(locator));
		act.build().perform();
		Thread.sleep(2000);
		
	}
	
	public void doubleClick(String locator) throws Exception{
		Thread.sleep(500);
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		act.doubleClick(BrowserFactory.SystemEngine().findElement(locator));
		act.build().perform();
		Thread.sleep(2000);
		
	}
	
	public void rightClick(String locator) throws Exception{
		Thread.sleep(500);
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		act.contextClick(BrowserFactory.SystemEngine().findElement(locator));
		act.build().perform();
		Thread.sleep(2000);
		
	}
	
	/**
	 * This method use to scroll down in a page. First user has to click in scrollable area then only this will work.
	 * @param no - pass no of steps to go down
	 * @throws Exception
	 */
	public void scrollDown(int no) throws Exception{
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		for(int i=1;i<=no;i++)
		{
			act.sendKeys(Keys.PAGE_DOWN);
			act.build().perform();
			Thread.sleep(500);
		}	
	}
	
	/**
	 * This method use to scroll up in a page. First user has to click in scrollable area then only this will work.
	 * @param no - pass no of steps to go down
	 * @throws Exception
	 */
	public void scrollUp(int no) throws Exception{
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		for(int i=1;i<=no;i++)
		{
			act.sendKeys(Keys.PAGE_UP);
			act.build().perform();
			Thread.sleep(500);
		}	
	}
	
	
	/**
	 * 
	 *  This method use to scroll down in a page. First user has to click in one first row then only this will work.
	 * 
	 * @author Mayureshwar
	 * 
	 * @param locator
	 * @param no - number to scroll down
	 * @throws Exception
	 */
	public void scrollDown_X(String locator,int no) throws Exception{
		
		BrowserFactory.SystemEngine();
		((JavascriptExecutor)BrowserFactory.driver).executeScript(
				"arguments[0].scrollIntoView();",BrowserFactory.SystemEngine().findElement(locator));
		Thread.sleep(2000);
		
		BrowserFactory.SystemEngine().findElement(locator).click();
		Thread.sleep(2000);
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		for(int i=1;i<=no;i++)
		{
			act.sendKeys(Keys.PAGE_DOWN);
			act.build().perform();
			Thread.sleep(2000);
		}	
		Thread.sleep(2000);
	}
	
	
	
	/**
	 * This method is used to click on split button(Eg: Buttons having arrows for drop-down)
	 * 
	 * @author Mayureshwar
	 * @param xOffset
	 * @throws Exception
	 */
	public void splitButtonClick(WebElement locator,int xOffset) throws Exception{
		Thread.sleep(500);
		BrowserFactory.SystemEngine();
		Actions act=new Actions(BrowserFactory.driver);
		act.moveToElement(locator, xOffset, 0);
		act.click().build().perform();
		Thread.sleep(2000);
		
	}
	
	public Integer getXpathCount(String locator) throws Exception{
		int count;
		BrowserFactory.SystemEngine();
		count=BrowserFactory.driver.findElements(By.xpath(locator)).size();
		return count;
		
	}

	/*	
		
		Login to application
		
	*/	
	//EPISERVER LOGIN
	public void login() {
		try {
			Thread.sleep(3000);
			Verify.action().verifyElementPresent(locators.exts().Login_email, 5);
			BrowserFactory.SystemEngine().findElement(locators.exts().Login_email).sendKeys(EPiServer_Common_Properties_Cred.username);
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().Login_password).sendKeys(EPiServer_Common_Properties_Cred.psw);
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(locators.exts().Login_button).click();
			Thread.sleep(3000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	//MAGENTOLOGIN
	public void Maglogin() {
		try {
			Thread.sleep(3000);
			Verify.action().verifyElementPresent(Magentolocators.exts().Login_Username1, 5);
			BrowserFactory.SystemEngine().findElement(Magentolocators.exts().Login_Username1).sendKeys(EPiServer_Common_Properties_Cred.username);
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(Magentolocators.exts().Login_password1).sendKeys(EPiServer_Common_Properties_Cred.psw);
			Thread.sleep(1000);
			BrowserFactory.SystemEngine().findElement(Magentolocators.exts().Login_button1).click();
			Thread.sleep(3000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	//Select
	/**
	 * This method is used to to select the mulitple value
	 * 
	 * @author Amarata M
	 * @param listItems - list of select tag element
	 * @throws Exception
	 */
	public static void selectMulti(String[] listItems,String Tagname)
	{
	    Select select = new Select(BrowserFactory.SystemEngine().findElement(Tagname));//GlobalLink_WizardSetting_Existing_Content_Type

	    if (listItems.length > 1 && !select.isMultiple())
	    {
	       System.out.println("The SELECT is not a multiple select but the list provided is larger than 1.");
	        return;
	    }

	    for (String listItem : listItems)
	    {
	        try
	        {
	            select.selectByVisibleText(listItem);
	           
	        }
	        catch (Exception e)
	        {
	        	System.out.println(listItem + " was not an available option");
	            e.printStackTrace();
	            return;
	        }
	    }
	}


	///
	public static void selectMultiLocal(String[] listItems,String Tagname)
	{
	    Select select = new Select(BrowserFactory.SystemEngine().findElement(Tagname));

	    if (listItems.length > 1 && !select.isMultiple())
	    {
	       System.out.println("The SELECT is not a  select but the list provided is larger than 1.");
	        return;
	    }

	    for (String listItem : listItems)
	    {
	        try
	        {
	            select.selectByVisibleText(listItem);
	           
	        }
	        catch (Exception e)
	        {
	        	System.out.println(listItem + " was not an available option");
	            e.printStackTrace();
	            return;
	        }
	    }
	}
	//DeSelect
	/**
	 * This method is used to to select the mulitple value
	 * 
	 * @author Amarata M
	 * @param listItems - list of select tag element
	 * @throws Exception
	 */
	public static void deSelectMulti(String[] listItems,String Tagname)
	{
	    Select select = new Select(BrowserFactory.SystemEngine().findElement(Tagname));//locators.exts().GlobalLink_WizardSetting_Existing_Content_Type)

	    if (listItems.length > 1 && !select.isMultiple())
	    {
	       System.out.println("The SELECT is not a multiple select but the list provided is larger than 1.");
	        return;
	    }

	    for (String listItem : listItems)
	    {
	        try
	        {
	            select.deselectByVisibleText(listItem);
	           
	        }
	        catch (Exception e)
	        {
	        	System.out.println(listItem + " was not an available option");
	            e.printStackTrace();
	            return;
	        }
	    }
	}
	
	
	/**
	 * @author Proteek
	 * 
	 * This method is to switch to Pop-window
	 * 
	 * @param windowIndex
	 * @throws Exception
	 */
	public void switchToPopupWindow(int windowIndex) throws Exception{
		System.out.println("In switchToPopupWindow()");
		BrowserFactory.SystemEngine();
		int noOfWindows=BrowserFactory.driver.getWindowHandles().toArray().length;
		System.out.println("No of Windows - "+noOfWindows);
		for(int i=0;i<noOfWindows;i++)
		{
			BrowserFactory.SystemEngine();
			System.out.println("Printing window handles - "+BrowserFactory.driver.getWindowHandles().toArray()[i]);
		}
		
		BrowserFactory.SystemEngine();
		BrowserFactory.SystemEngine();
		BrowserFactory.driver.switchTo().window(BrowserFactory.driver.getWindowHandles().toArray()[windowIndex].toString());
		Thread.sleep(2000);
		  System.out.println("EOM - switchToPopupWindow().");
	}
	
		
	
}
