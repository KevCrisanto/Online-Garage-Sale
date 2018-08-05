package maverick.ogs.selenium.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// /html/body/app-root/div/app-items-list/div[1]/app-item/div/div/div[2]/div[1]/h2/a
// /html/body/app-root/div/app-items-list/div[2]/app-item/div/div/div[2]/div[1]/h2/a
// /html/body/app-root/div/app-items-list/div[3]/app-item/div/div/div[2]/div[1]/h2/a
// /html/body/app-root/div/app-items-list/div[1]/app-item/div/div/div[2]/div[1]/h2/a
public class SaleItems {
	private WebDriver driver;
	private By items = By.xpath("//html/body/app-root/div/app-items-list/div");
	private final String localhostURL = "http://localhost:8085";
	private final String ec2URL = "http://18.219.13.188:8085";
	private String urlItemList = "/Maverick_OnlineGarageSale/AngularOGS/#/item-list";
	public static final String FILE_NAME = "src/main/resources/testConfigs.properties";
	private static Properties testConfigs = null;
	private Boolean isLocalConnection = false;
	private List<WebElement> itemLinks;
	
	public SaleItems(WebDriver driver) {
		this.driver = driver;
		this.itemLinks = driver.findElements(items);
	}
	
	public void navigateItems() {
		System.out.println("Found " + itemLinks.size() + " item(s) for sale.");
		
		for (WebElement element : itemLinks) {
			System.out.println(element.getText());
		}
		for (int i = 1; i < itemLinks.size() + 1; i++ ) {
			driver.findElement(By.xpath("//app-items-list/div[" + i + "]/app-item/div/div/div[2]/div[1]/h2/a")).click();
			try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[@id=\"nav\"]/ul[1]/li[1]/a")).click();
		}
	}
}
