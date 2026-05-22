package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

import pages.LoginPage;
import utils.ConfigProperties;

public class LoginSteps {

    private WebDriver driver;
    private final LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("que o usuário está na tela de login")
    public void acessarAplicacao() {
        loginPage.acessarAplicacao();
    }

    @When("ele informa usuário válido e senha válida")
    public void loginValido() {
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
    }

    @When("ele informa usuário válido e senha inválida")
    public void loginInvalido() {
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha("senhaErrada");
    }

    @And("clica no botão de login")
    public void clicarBotaoLogin() {
        loginPage.clicarLogin();
    }

    @Then("deve acessar o dashboard")
    public void validarLoginSucesso() {
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Then("deve ver mensagem de erro")
    public void validarErroLogin() {
        String erro = loginPage.obterMensagemErro();
        assertEquals("Invalid credentials", erro);
    }
}