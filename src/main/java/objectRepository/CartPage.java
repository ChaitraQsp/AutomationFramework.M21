package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//declaration
	@FindBy(id = "checkout")
	private WebElement checkOutBtn;
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemName;
	
	//initialization
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}
	
	public WebElement getItemName() {
		return itemName;
	}

	//business library
	/**
	 * this method will capture product name and return to caller
	 * @return
	 */
	public String captureProductNameInCart()
	{
		return itemName.getText();
	}
	
	
	

}
