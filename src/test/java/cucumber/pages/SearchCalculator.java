package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCalculator {

	public WebDriver driver;

	public SearchCalculator(WebDriver driver) {
		this.driver = driver;
	}

	public void returnCalculator() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("cwfleb")));
		element.click();
	}
}
