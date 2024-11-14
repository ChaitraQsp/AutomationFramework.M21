package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to Selenium
 * @author Chaitra M
 *
 */
public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait 
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for the particular web element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, String value) 
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param index
	 */
	public void handleDropDown(String text, WebElement element) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse overing action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 *  This method will perform double click action
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 *  This method will perform double click action
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will perform click and hold action
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will handle Frame by Frame index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle Frame by Frame id or Name
	 * @param driver
	 * @param id or name
	 */
	public void handleFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * This method will handle Frame by Frame Web element
	 * @param driver
	 * @param web element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will scroll to particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will perform scrollUp action
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	/**
	 * This method will perform scrolldown action
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will capture the screenshot and return the path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //extent reports
		
		
	}
	
	
	

}
