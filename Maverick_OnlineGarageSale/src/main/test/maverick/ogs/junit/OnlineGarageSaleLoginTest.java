package maverick.ogs.junit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maverick.ogs.selenium.pages.Login;

public class OnlineGarageSaleLoginTest {
	public static WebDriver driver;
	public final String url = "http://fluffy.services:8080/#/login";
	public Login login;
	
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
		login.loginToOGS("username", "password");
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
