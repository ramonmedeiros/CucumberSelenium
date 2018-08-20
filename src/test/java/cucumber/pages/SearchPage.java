package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private String url = "http://google.com";
	private String searchBox = "q";
	private String searchButton = "btnK";
	public WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPage() {
		driver.get(url);
	}

	public void searchOnGoogle(String searchString) {
		// reads input on Feature file and send it in search bar
		WebElement searchText = driver.findElement(By.name(searchBox));
		searchText.sendKeys(searchString);

		// send escape to close suggestion modal
		searchText.sendKeys(Keys.ESCAPE);

		// wait search button to be clicked
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(searchButton))));
		element.click();
	}
}