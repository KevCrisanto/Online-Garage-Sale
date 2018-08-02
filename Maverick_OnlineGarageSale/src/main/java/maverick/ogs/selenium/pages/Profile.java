package maverick.ogs.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.Utils;

public class Profile {
	private WebDriver driver;
	private static final String url = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/#/profile";
	private By firstName = By.xpath("//*[@id=\"fname\"]");
	private By lastName = By.xpath("//*[@id=\"lname\"]");
	private By editClickable = By.xpath("/html/body/app-root/div/app-profile/div[2]/div/div/div/div/div[1]/div/div[1]/div/div[2]/fa-icon");
	private By addressClickable = By.xpath("/html/body/app-root/div/app-profile/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/fa-icon");
	private By addressLine1 = By.xpath("//*[@id=\"add1\"]");
	private By addressLine2 = By.xpath("//*[@id=\"add2\"]");
	private By poBox = By.xpath("//*[@id=\"poBox\"]");
	private By aptNum = By.xpath("//*[@id=\"apt\"]");
	private By city = By.xpath("//*[@id=\"city\"]");
	private By country = By.xpath("//*[@id=\"country\"]");
	private By zipcode = By.xpath("(//*[@id=\"apt\"])[2]");
	
	
	public Profile(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}
	
	public void inputFirstName(String firstName) {
		Utils.clearField(this.firstName, driver);
		Utils.emulateUserKeyStroke(driver, firstName, this.firstName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputLastName(String lastName) {
		Utils.clearField(this.lastName, driver);
		Utils.emulateUserKeyStroke(driver, lastName, this.lastName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEditIcon() {
		driver.findElement(editClickable).click();
	}
	
	public void clickAddressIcon() {
		driver.findElement(addressClickable).click();
	}
	
	public void inputAddressLine1(String input) {
		Utils.clearField(this.addressLine1, driver);
		Utils.emulateUserKeyStroke(driver, input, this.addressLine1);
		
	}
	
	public void inputAddressLine2(String input) {
		Utils.clearField(this.addressLine2, driver);
		Utils.emulateUserKeyStroke(driver, input, this.addressLine2);
	}
	
	public void inputPoBox(String input) {
		Utils.clearField(this.poBox, driver);
		Utils.emulateUserKeyStroke(driver, input, this.poBox);
	}
	
	public void inputAptNum(String input) {
		Utils.clearField(this.aptNum, driver);
		Utils.emulateUserKeyStroke(driver, input, this.aptNum);
	}
	
	public void inputCity(String input) {
		Utils.clearField(this.city, driver);
		Utils.emulateUserKeyStroke(driver, input, this.city);
	}
	
	public void inputCountry(String input) {
		Utils.clearField(this.country, driver);
		Utils.emulateUserKeyStroke(driver, input, this.country);
	}
	
	public void inputZipCode(String input) {
		Utils.clearField(this.zipcode, driver);
		Utils.emulateUserKeyStroke(driver, input, this.zipcode);
	}
	
	public void testProfile(String firstName, String lastName, String address1, String address2, String poBox, String aptNum, String city, String country, String zipcode) {
		clickEditIcon();
		inputFirstName(firstName);
		inputLastName(lastName);
		clickEditIcon();
		clickAddressIcon();
		inputAddressLine1(address1);
		inputAddressLine2(address2);
		inputAptNum(aptNum);
		inputPoBox(poBox);
		inputCity(city);
		inputCountry(country);
		inputZipCode(zipcode);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
