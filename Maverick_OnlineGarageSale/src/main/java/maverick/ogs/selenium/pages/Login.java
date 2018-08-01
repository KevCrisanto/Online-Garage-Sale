package maverick.ogs.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.Utils;

public class Login {
	
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By rememberMe = By.cssSelector("input[type='checkbox']");
	private By submit = By.cssSelector("input[type='submit']");
	
	public Login(WebDriver driver) {
		this.driver = driver;
		explicitWait = new WebDriverWait(driver, 5);
	}
	
	public void inputUsername(String username){
		Utils.emulateUserKeyStroke(driver, username, this.username);
		
	}
	public String getUsername(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(this.username).getText();
	}
	public void inputPassword(String password){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utils.emulateUserKeyStroke(driver, password, this.password);
	}
	public void clickRememberMe() {
		driver.findElement(rememberMe).click();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void submitLogic(){
		driver.findElement(submit).click();
	}
	public void loginToOGS(String username, String password){
		inputUsername(username);
		inputPassword(password);
		clickRememberMe();
		submitLogic();
	}
}
