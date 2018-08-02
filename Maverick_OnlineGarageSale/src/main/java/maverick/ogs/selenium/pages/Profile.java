package maverick.ogs.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.Utils;

public class Profile {
	private WebDriver driver;
	private By firstName = By.xpath("//*[@id=\"staticfname\"]");
	private By lastName = By.xpath("//*[@id=\"staticlname\"]");
	
	public Profile(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputFirstName(String firstName) {
		Utils.emulateUserKeyStroke(driver, firstName, this.firstName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputLastName(String lastName) {
		Utils.emulateUserKeyStroke(driver, lastName, this.lastName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testProfile(String firstName, String lastName) {
		inputFirstName(firstName);
		inputLastName(lastName);
	}
}
