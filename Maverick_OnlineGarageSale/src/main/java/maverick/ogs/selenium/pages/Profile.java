package maverick.ogs.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import maverick.ogs.selenium.Utils;

public class Profile {
	private WebDriver driver;
	private static final String url = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/#/profile";
	private By firstName = By.xpath("//*[@id=\"fname\"]");
	private By lastName = By.xpath("//*[@id=\"lname\"]");
	private By editClickable = By.xpath("/html/body/app-root/div/app-profile/div[2]/div/div/div/div/div[1]/div/div[1]/div/div[2]/fa-icon");
	
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
	public void testProfile(String firstName, String lastName) {
		clickEditIcon();
		inputFirstName(firstName);
		inputLastName(lastName);
	}
}
