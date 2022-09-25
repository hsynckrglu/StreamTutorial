import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TablodakiVerilerOtomasyonu {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Banana");
		List<WebElement> FruitVegNames = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> vegNames = FruitVegNames.stream().filter(veg -> veg.getText().contains("Banana"))
				.collect(Collectors.toList());
		
		Assert.assertEquals(FruitVegNames.size(), vegNames.size());
	}

}
