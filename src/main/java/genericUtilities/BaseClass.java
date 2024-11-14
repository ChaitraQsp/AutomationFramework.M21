package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	/*Used for listeners*/
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("------ Database Connection SuccessFul ------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSERNAME*/) throws IOException
	{
		/*For Cross browser execution*/
//		if(BROWSERNAME.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSERNAME.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else 
//		{
//			driver = new ChromeDriver();
//		}
		
		
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("------ Browser Launch SuccessFul ------");
		
		/*Used for Listeners*/
		sdriver = driver;
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------ Login to Application SuccessFul ------");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		AllProductsPage app = new AllProductsPage(driver);
		app.logoutOfApp();
		
		System.out.println("------ Logout of Application SuccessFul ------");
		
	}

	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("------ browser closure SuccessFul ------");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("------ Database closure SuccessFul ------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
