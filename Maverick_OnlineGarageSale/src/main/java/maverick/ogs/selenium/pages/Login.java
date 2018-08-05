package maverick.ogs.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.Utils;

public class Login {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By rememberMe = By.cssSelector("input[type='checkbox']");
	private By submit = By.cssSelector("button[type='submit']");

	// Register component
	private By accessRegisterForm = By.xpath("/html/body/app-root/div/app-login/div/div[3]");
	private By collapseRegisterForm = By.xpath("/html/body/app-root/div/app-login/div/div[1]");
	private By registerUsername = By.xpath("//*[@id=\'usernameReg\']");
	private By registerPassword = By.xpath("//*[@id=\'passwordReg\']");
	private By registerEmail = By.xpath("//*[@id=\'emailReg\']");
	private By registerButton = By.xpath("/html/body/app-root/div/app-login/div/div[3]/div[2]/form/div[4]/button");
	
	public Login(WebDriver driver) {
		this.driver = driver;
		explicitWait = new WebDriverWait(driver, 5);
	}
	
	public void inputUsername(String username){
		Utils.emulateUserKeyStroke(driver, username, this.username);
		try {
			Thread.sleep(1900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getUsername(){
		return driver.findElement(this.username).getText();
	}
	public void inputPassword(String password){
		Utils.emulateUserKeyStroke(driver, password, this.password);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickRememberMe() {
		driver.findElement(rememberMe).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void submitLogic(){
		driver.findElement(submit).click();
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void registerAction() {
		driver.findElement(accessRegisterForm).click();
		try {
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void collapseRegisterButton() {
		driver.findElement(collapseRegisterForm).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void registerUsernameInput(String input) {
		Utils.emulateUserKeyStroke(driver, input, this.registerUsername);

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void registerPasswordInput(String input) {
		Utils.emulateUserKeyStroke(driver, input, this.registerPassword);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void registerEmailInput(String input) {
		Utils.emulateUserKeyStroke(driver, input, this.registerEmail);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickRegisterButton() {
		driver.findElement(registerButton);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void loginToOGS(String username, String password, String newUsername, String newPassword, String email){
		inputUsername(username);
		inputPassword(password);
		clickRememberMe();
		registerAction();
		registerUsernameInput(newUsername);
		registerPasswordInput(newPassword);
		registerEmailInput(email);
		collapseRegisterButton();
		submitLogic();
		
	}
}
