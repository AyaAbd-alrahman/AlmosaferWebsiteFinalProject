package FinalProjectAlmosaferWebSite.FinalProjectAlmosaferWebSite;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest
	public void mySetup() {
		Setup();
	}

	@Test(priority = 1)
	public void CheckWebSiteLanguage(String ExpectedLanguage) {
		String ActualLanguage = Driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2)
	public void CheckCurrency() {
		String ActualCurrency = Driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckNumber() {

		String ActualNumber = Driver.findElement(By.linkText("+966554400000")).getText();
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4)
	public void CheckQutafLogo() {

		WebElement footer = Driver.findElement(By.tagName("footer"));
		boolean ActualimageIsDisplayed = footer.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
		Assert.assertEquals(ActualimageIsDisplayed, true);
	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelected() {
		WebElement HotelTab = Driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValue, ExpectedVale);
	}

	@Test(priority = 6)
	public void FlightDepatureDate() {

		List<WebElement> Dates = Driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = Dates.get(0).getText();
		Assert.assertEquals(ActualDepatureDate, TomorrowAsFormattedValue);
	}

	@Test(priority = 7)
	public void ReturnDepatureDate() {
		List<WebElement> Dates = Driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = Dates.get(1).getText();
		Assert.assertEquals(ActualReturnDate, DayAfterTomorrowAsFormattedValue);
	}

	@Test(priority = 8)
	public void ChangeTheWebSiteLanguage() {
	
		Driver.get(Thewebsites[RandomIndex]);

		if (Driver.getCurrentUrl().contains("en")) {
			CheckWebSiteLanguage("en");
		} else {
			CheckWebSiteLanguage("ar");
		}
	}

	@Test(priority = 9)
	public void RandomlySelectCities() {
		WebElement HotelTab = Driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement SearchInputField = Driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input "));

		if (Driver.getCurrentUrl().contains("en")) {
			SearchInputField.sendKeys(englishCities[randomEnglishCity]);

		} else {
			SearchInputField.sendKeys(arbicCities[randomArabicCity]);

		}

		WebElement SelectVistorNumber = Driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select mySelector = new Select(SelectVistorNumber);

		mySelector.selectByValue(values[randomValue]);

		Driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}

	@Test(priority = 10)
	public void CheckTheResultsIsretrived() throws InterruptedException {
		Thread.sleep(10000);

		String Results = Driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();

		if (Driver.getCurrentUrl().contains("en")) {
			Assert.assertEquals(Results.contains("found"), true);

		} else {
			Assert.assertEquals(Results.contains("مكان إقامة"), true);

		}

	}

	@AfterTest
	public void myAfterTest() {
	}
}
