package maverick.ogs.junit;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maverick.ogs.selenium.pages.Profile;

public class OnlineGarageSaleProfilePageTest {
	private static WebDriver driver;
	private final String url = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/#/profile";
	Profile profile;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void testProfilePage() {
		profile = new Profile(driver);
		profile.testProfile("Today is my birthday. Not!", "Jones", "Story Rd.", "", "", "2L", "Pallet Town", "United States", "76013");
	}
}
