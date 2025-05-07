package FinalProjectAlmosaferWebSite.FinalProjectAlmosaferWebSite;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	String TheWebSiteUrl = "https://www.almosafer.com/en";
	WebDriver Driver = new ChromeDriver();
	String ExpectedCurrency = "SAR";
	String ExpectedNumber = "+966554400000";
	String ExpectedVale = "false";

	LocalDate date = LocalDate.now();
	int ExpectedDate = date.plusDays(1).getDayOfMonth();
	String TomorrowAsFormattedValue = String.format("%02d", ExpectedDate);

	int ExpectedReturnDate = date.plusDays(2).getDayOfMonth();
	String DayAfterTomorrowAsFormattedValue = String.format("%02d", ExpectedReturnDate);

	String[] Thewebsites = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };
	Random rand = new Random();
	int RandomIndex = rand.nextInt(Thewebsites.length);

	String[] englishCities = { "dubai", "jeddah", "riyadh" };
	int randomEnglishCity = rand.nextInt(englishCities.length);

	String[] arbicCities = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(arbicCities.length);

	String[] values = { "A", "B" };
	int randomValue = rand.nextInt(values.length);

	public void Setup() {
		Driver.get(TheWebSiteUrl);

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Driver.manage().window().maximize();

		WebElement SettingButtonEn = Driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		// WebElement SettingButtonAr =
		// driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary;"));
		SettingButtonEn.click();
	}

}