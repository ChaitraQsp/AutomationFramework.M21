package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//declaration
	@FindBy(id = "add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;
	
	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	
	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}


	//business library
	/**
	 * this method will click on add to cart button
	 */
	public void clickOnAddToCartBtn()
	{
		addToCartBtn.click();
	}
	
	/**
	 * this method will click on shopping cart container button
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}

}
