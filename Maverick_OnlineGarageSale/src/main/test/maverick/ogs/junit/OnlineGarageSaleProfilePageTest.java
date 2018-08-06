package maverick.ogs.junit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maverick.ogs.selenium.pages.Login;
import maverick.ogs.selenium.pages.Profile;

public class OnlineGarageSaleProfilePageTest {
	private static WebDriver driver;
	private String url = "/Maverick_OnlineGarageSale/AngularOGS/";
	Profile profile;
	private final String localhostURL = "http://localhost:4200";
	private final String ec2URL = "http://18.219.13.188:8085";
	public static final String FILE_NAME = "src/main/resources/testConfigs.properties";
	private static Properties testConfigs = null;
	private Boolean isLocalConnection = false;
	private static String OS = System.getProperty("os.name").toLowerCase();

	
	@Before
	public void setup() {
		try {
			testConfigs = new Properties();
			testConfigs.load(new FileInputStream(FILE_NAME));
			this.isLocalConnection = Boolean.valueOf(testConfigs.getProperty("isLocalConnection"));
			
		} catch (FileNotFoundException fnfe) {
			this.isLocalConnection = false;
		} catch (IOException ioe) {
			this.isLocalConnection = false;
		}
		
		if (this.isLocalConnection) {
			this.url = localhostURL + url;
		} else {
			this.url = ec2URL + url;
		}
		if (OS.indexOf("win") >= 0) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void testProfilePage() {
		Login login = new Login(driver);
		login.inputUsername("bobbert");
		login.inputPassword("bobbert");
		login.submitLogic();
		driver.get("http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/#/profile");
		profile = new Profile(driver);
		profile.testProfile("Today is my birthday. Not!", "Jones", "Story Rd.", "", "", "2L", "Pallet Town", "United States", "76013");
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
