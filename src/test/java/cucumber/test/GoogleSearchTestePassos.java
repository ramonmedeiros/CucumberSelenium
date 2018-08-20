package cucumber.test;

import java.util.List;

import cucumber.pages.SearchPage;
import cucumber.pages.SearchCalculator;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.test.GoogleSearchTeste;

import org.openqa.selenium.chrome.ChromeDriver;;

public class GoogleSearchTestePassos {

	private static ChromeDriver driver = GoogleSearchTeste.getBrowser();
	private SearchPage page; 
	private SearchCalculator pagecalc;

	@Given("^acessado o site do Google$")
	public void acessado_o_site_do_Google() throws Throwable {
		page = new SearchPage(driver);
		page.openPage();
	}

	@When("^realizar uma busca usando palavra-chave$")
	public void realizar_uma_busca_usando_palavra_chave(DataTable searchContent) throws Throwable {

		List<List<String>> data = searchContent.raw();
		page.searchOnGoogle(data.get(0).get(0));
	}

	@Then("^retorna resultados da pesquisa$")
	public void retorna_resultados_da_pesquisa() throws Throwable {

	}

	@When("^realizar uma busca usando \"([^\"]*)\"$")
	public void realizar_uma_busca_usando(String wordSearchContent) throws Throwable {
		page.searchOnGoogle(wordSearchContent);
	}

	@Then("^retorna calculadora Google$")
	public void retorna_calculadora_Google() throws Throwable {
		pagecalc = new SearchCalculator(driver);
		pagecalc.returnCalculator();
	}

}
