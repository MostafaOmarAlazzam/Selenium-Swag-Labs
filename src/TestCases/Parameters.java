package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	static WebDriver driver = new ChromeDriver();
	static String WebSite = "https://www.saucedemo.com/";
	static String UserName = "standard_user";
	static String Password = "secret_sauce";

	static void login() {
		driver.get(WebSite);
		WebElement UserNameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
		UserNameInput.sendKeys(UserName);
		WebElement PasswordInput = driver.findElement(By.xpath("//input[@id='password']"));
		PasswordInput.sendKeys(Password);
		WebElement ButtonInput = driver.findElement(By.xpath("(//input[@id='login-button'])[1]"));
		ButtonInput.click();
	}

	public void SpecificName(String... items) {
		List<WebElement> Add_All = driver.findElements(By.className("btn"));
		List<WebElement> ContentText = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < Add_All.size(); i++) {
			String ItemName = ContentText.get(i).getText();
			if (IsContain(ItemName, items) == true)
				Add_All.get(i).click();
		}
	}

	public boolean IsContain(String ItemName2, String... items2) {
		for (String ItemName3 : items2)
			if (ItemName2.contains(ItemName3))
				return true;
		return false;
	}

	public void logOut() throws InterruptedException {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		driver.navigate().refresh();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}


}
