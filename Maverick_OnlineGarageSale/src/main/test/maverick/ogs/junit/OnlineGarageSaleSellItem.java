package maverick.ogs.junit;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import maverick.ogs.selenium.pages.Login;
import maverick.ogs.selenium.pages.SellItem;

public class OnlineGarageSaleSellItem {
	private static WebDriver driver;
	private final String url = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/";
	private final String url2 = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/AngularOGS/#/item-submit";	
	private SellItem sellItem;
	private Login login;
	private WebDriverWait explicitWait;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void testProfilePage() {
		File file = new File("C:\\Jenkins Notes.PNG");
		login = new Login(driver);
		login.inputUsername("bobbert");
		login.inputPassword("bobbert");
		login.submitLogic();
		driver.get(url2);
		sellItem = new SellItem(driver);
		sellItem.testSellItemPage("Cool new stuff", "All", 1, "And it would be like an awesome description.", "C:\\Jenkins Notes.PNG");
		
	}
}
