package maverick.ogs.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.Utils;

public class Navbar {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private By shoppingCartHome = By.cssSelector("a[href=\'#\']");
	private By home = By.cssSelector("a[href=\'#/item-list\']");
	private By project = By.cssSelector("a[class=\'nav-link text-light text-uppercase font-weight-bold px-3 dropdown-toggle\']");
	private By profile = By.cssSelector("a[href=\'#/profile\'");
	private By search = By.cssSelector("input[placeholder=\'Search\']");
	
	public Navbar(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
	}
	
	public void selectShoppingCart() {
		driver.findElement(shoppingCartHome).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectHome() {
		driver.findElement(home).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public void projectDropDown() {
		driver.findElement(project).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectProfile() {
		driver.findElement(profile).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sendKeysToSearch(String input) {
		Utils.emulateUserKeyStroke(driver, input, search);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testNavBar() {
		selectShoppingCart();
		selectHome();
		for (int i = 0; i < 8; i++) {
			projectDropDown();
		}
		selectProfile();
		sendKeysToSearch("Online Garage Sale <3");
		

	}
}
