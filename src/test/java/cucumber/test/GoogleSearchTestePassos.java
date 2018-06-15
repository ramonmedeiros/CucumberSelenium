package cucumber.test;

import java.util.List;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;

public class GoogleSearchTestePassos {

	public static WebDriver driver;

	@Given("^acessado o site do Google$")
	public void acessado_o_site_do_Google() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://google.com");
	}

	@When("^realizar uma busca usando palavra-chave$")
	public void realizar_uma_busca_usando_palavra_chave(DataTable searchContent) throws Throwable {
		List<List<String>> data = searchContent.raw();
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(data.get(0).get(0));

		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();
	}

	@Then("^retorna resultados da pesquisa$")
	public void retorna_resultados_da_pesquisa() throws Throwable {

		driver.quit();
	}

	@When("^realizar uma busca usando \"([^\"]*)\"$")
	public void realizar_uma_busca_usando(String wordSearchContent) throws Throwable {

		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(wordSearchContent);

		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();

	}

	@Then("^retorna calculadora Google$")
	public void retorna_calculadora_Google() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("cwfleb")));

		driver.quit();
	}

}
