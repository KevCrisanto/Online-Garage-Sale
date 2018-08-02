package maverick.ogs.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {
	private static int millisecondsToWait = 300;
	
	public static void emulateUserKeyStroke(WebDriver driver, String input, By element) {
		for (Character c : input.toCharArray()) {
			try {
				Thread.sleep(millisecondsToWait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(element).sendKeys(String.valueOf(c));
		}
	}
}
