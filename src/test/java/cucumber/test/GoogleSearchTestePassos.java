package cucumber.test;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.test.GoogleSearchTeste;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;

public class GoogleSearchTestePassos {

	public static ChromeDriver driver = GoogleSearchTeste.getBrowser();

	@Given("^acessado o site do Google$")
	public void acessado_o_site_do_Google() throws Throwable {
		driver.get("http://google.com");
	}

	@When("^realizar uma busca usando palavra-chave$")
	public void realizar_uma_busca_usando_palavra_chave(DataTable searchContent) throws Throwable {

		// reads input on Feature file and send it in search bar
		List<List<String>> data = searchContent.raw();
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(data.get(0).get(0));

		// send escape to close suggestion modal
		searchText.sendKeys(Keys.ESCAPE);

		// wait search button to be clicked
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("btnK"))));
		element.click();
	}

	@Then("^retorna resultados da pesquisa$")
	public void retorna_resultados_da_pesquisa() throws Throwable {

	}

	@When("^realizar uma busca usando \"([^\"]*)\"$")
	public void realizar_uma_busca_usando(String wordSearchContent) throws Throwable {

		// reads input on Feature file and send it in search bar
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(wordSearchContent);

		// send escape to close suggestion modal
		searchText.sendKeys(Keys.ESCAPE);

		// wait search button to be clicked
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("btnK"))));
		element.click();
	}

	@Then("^retorna calculadora Google$")
	public void retorna_calculadora_Google() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("cwfleb")));
		element.click();
	}

}
