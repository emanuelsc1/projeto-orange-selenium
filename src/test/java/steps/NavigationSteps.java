package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.NavigationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationSteps {

    private WebDriver driver;
    private NavigationPage navigationPage;

    private NavigationPage getNavigationPage() {
        if (driver == null) {
            driver = Hooks.getDriver();
        }
        if (navigationPage == null) {
            navigationPage = new NavigationPage(driver);
        }
        return navigationPage;
    }

    @Given("que estou na pagina inicial")
    public void estouNaPaginaInicial() {
        getNavigationPage().validarPaginaInicial();
    }

    @When("clico no botao {string}")
    @And("clico no menu {string}")
    public void clicoNoMenu(String nomeMenu) {
        getNavigationPage().clicarNoMenu(nomeMenu);
    }

    @Then("devo estar na pagina {string}")
    public void devoEstarNaPagina(String paginaEsperada) {
        String tituloAtual = getNavigationPage().obterTituloModulo();
        assertTrue(
                tituloAtual.contains(paginaEsperada),
                String.format("Pagina esperada '%s', mas titulo atual foi '%s'", paginaEsperada, tituloAtual)
        );
    }

    @And("a url da pagina deve conter {string}")
    public void urlDaPaginaDeveConter(String rotaEsperada) {
        String urlAtual = getNavigationPage().obterUrlAtual();
        assertTrue(
                urlAtual.contains(rotaEsperada),
                String.format("URL atual '%s' nao contem '%s'", urlAtual, rotaEsperada)
        );
    }
}

