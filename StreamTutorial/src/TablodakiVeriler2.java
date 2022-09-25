import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablodakiVeriler2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> fruitVegNames = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> fruitVegPrice;

		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			fruitVegPrice = rows.stream().filter(s -> s.getText().contains("Mango")).map(s -> getFruitVegPrice(s))
					.collect(Collectors.toList());
			fruitVegPrice.forEach(s -> System.out.println("Seçilen ürünün fiyatı: " + s));

			if (fruitVegPrice.size() < 1) {// yani listede ürün yoksa koşulu
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (fruitVegPrice.size() < 1);

	}

	private static String getFruitVegPrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
