package maverick.ogs.junit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maverick.ogs.selenium.pages.Login;
import maverick.ogs.selenium.pages.Profile;

public class OnlineGarageSaleLoginTest {
	public static WebDriver driver;
	public final String url = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/";
	public Login login;
	public static Profile profile;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void loginTest() {
		login = new Login(driver);
		login.loginToOGS("bobbert", "bobbert", "someNewUser", "password", "somePerson@email.com");
		profile = new Profile(driver);
		profile.testProfile("Today is my birthday. Not!", "Jones", "Story Rd.", "", "", "2L", "Pallet Town", "United States", "76013");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
