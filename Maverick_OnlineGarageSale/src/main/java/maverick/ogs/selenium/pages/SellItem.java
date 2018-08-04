package maverick.ogs.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import maverick.ogs.selenium.Utils;

public class SellItem {
	private WebDriver driver;
	private By nameOfItem = By.xpath("//*[@id=\"eventDate\"]");
	private By category = By.xpath("//*[@id=\"asdf\"]");
	private By price = By.xpath("//*[@id=\"price\"]");
	private By description = By.xpath("//*[@id=\"description\"]");
	private By uploadPicture = By.xpath("//*[@id=\"upload\"]");
	
	public SellItem(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputNameOfItem(String nameOfItem) {
		Utils.emulateUserKeyStroke(driver, nameOfItem, this.nameOfItem);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputCategory(String category) {
		Utils.emulateUserKeyStroke(driver, category , this.category);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputPrice(Integer price) {
		Utils.clearField(this.price, driver);
		Utils.emulateUserKeyStroke(driver, price.toString(), this.price);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputDescription(String description) {
		Utils.emulateUserKeyStroke(driver, description, this.description);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadPicture(String filePath) {
		driver.findElement(this.uploadPicture).sendKeys(filePath);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testSellItemPage(String name, String category, Integer price, String description, String picture) {
		inputNameOfItem(name);
		inputCategory(category);
		inputPrice(price);
		inputDescription(description);
		uploadPicture(picture);
	}
}
