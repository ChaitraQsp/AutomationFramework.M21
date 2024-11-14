package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class AddProductToCartUsingDDTAndGU {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Create Object of Utility Classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		// Read commonData Data From Property file
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		// Read Test Data from Excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		// Step 2: Load the URL
		driver.get(URL);

		// Step 3: Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		// Step 4: Click on Sauce Labs BagPack - product
		Thread.sleep(1000);
		System.out.println(PRODUCTNAME);
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();
		String ProductTitle = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).getText();

		// Step 5: Add the product to Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Step 6: Navigate to Cart and Validate for the product
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		String ProductTitleInCart = driver.findElement(By.className("inventory_item_name")).getText();

		if (ProductTitleInCart.equalsIgnoreCase(ProductTitle)) {
			System.out.println("Product Added and Verifed in Cart successfully");
			System.out.println(ProductTitleInCart);
		} else {
			System.out.println("Product not verified in Cart");
		}

		// Step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();

		System.out.println("Logout successful");

	}

}
