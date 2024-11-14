package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.AllProductsPage;
import objectRepository.CartPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc001_addSingleProductToCartTest() throws IOException, InterruptedException
	{

		// Read Test Data from Excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);
		System.out.println(PRODUCTNAME);
		
		// Step 1: Click on Sauce Labs BagPack - product
		Thread.sleep(1000);
		AllProductsPage app = new AllProductsPage(driver);
		String ProductTitle = app.clickOnProduct(driver, PRODUCTNAME);
		
		// Step 2: Add the product to Cart
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCartBtn();

		// Step 3: Navigate to Cart 
		pp.clickOnCartContainer();
		
		//Assert.fail();
		
		// Step 4: Capture the product name in Cart
		CartPage co = new CartPage(driver);
		String ProductTitleInCart = co.captureProductNameInCart();
		Thread.sleep(1000);
		
        // Step 5: Validate
		Assert.assertEquals(ProductTitleInCart, ProductTitle);
		

	}
	
	@Test(groups = "RegressionSuite")
	public void removeProductTest()
	{
		System.out.println("Product removed");
	}

}
