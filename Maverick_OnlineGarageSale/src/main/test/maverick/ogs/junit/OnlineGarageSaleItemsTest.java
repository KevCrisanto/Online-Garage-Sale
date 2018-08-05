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
import maverick.ogs.selenium.pages.SaleItems;

public class OnlineGarageSaleItemsTest {
	private static WebDriver driver;
	private final String localhostURL = "http://localhost:8085";
	private final String ec2URL = "http://18.219.13.188:8085";
	private String url = "/Maverick_OnlineGarageSale/AngularOGS/";
	private String url2 = "/Maverick_OnlineGarageSale/AngularOGS/#/item-list";
	Login login;
	SaleItems saleItems;
	public static final String FILE_NAME = "src/main/resources/testConfigs.properties";
	private static Properties testConfigs = null;
	private Boolean isLocalConnection = false;
	
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
			this.url2 = localhostURL + url2;
		} else {
			this.url = ec2URL + url;
			this.url2 = ec2URL + url2;
		}
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void testSaleItems() {
		login = new Login(driver);
		login.inputUsername("bobbert");
		login.inputPassword("bobbert");
		login.submitLogic();
		driver.get(url2);
		saleItems = new SaleItems(driver);
		saleItems.navigateItems();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
