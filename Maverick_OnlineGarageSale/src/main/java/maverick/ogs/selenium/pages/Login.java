package maverick.ogs.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By rememberMe = By.cssSelector("input[type='checkbox']");
	private By submit = By.cssSelector("button[type='submit']");

	
	public Login(WebDriver driver) {
		this.driver = driver;
		explicitWait = new WebDriverWait(driver, 5);
	}
	
	public void inputUsername(String username){
		driver.findElement(this.username).sendKeys(username);
	}
	public String getUsername(){
		return driver.findElement(this.username).getText();
	}
	public void inputPassword(String password){
		driver.findElement(this.password).sendKeys(password);
	}
	public void clickRememberMe() {
		driver.findElement(rememberMe).click();
	}
	public void submitLogic(){
		driver.findElement(submit).click();
	}
	public void loginToOGS(String username, String password){
		inputUsername(username);
		
		inputPassword(password);
		submitLogic();
	}
}
