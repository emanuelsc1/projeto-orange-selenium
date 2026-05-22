package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SearchSystemUsersPage;
import utils.ConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

public class SearchSystemUsersSteps {

    private WebDriver driver;
    private final SearchSystemUsersPage searchSystemUsersPage;

    public SearchSystemUsersSteps() {
        this.driver = Hooks.getDriver();
        this.searchSystemUsersPage = new SearchSystemUsersPage(driver);
    }

    @Given("o usuário acessa o menu Admin")
    public void oUsuárioAcessaOMenuAdmin() {
        searchSystemUsersPage.acessarMenuAdmin();
        searchSystemUsersPage.vaidarAcessoTelaAdmin();
    }

    @When("usuário realiza uma consulta por Username")
    public void usuárioRealizaUmaConsultaPorUsername() {
        searchSystemUsersPage.informaUsername(ConfigProperties.USER);
        searchSystemUsersPage.clicaBotaoSearch();
    }

    @Then("o sistema deve atualizar a tabela filtrando pelo Username")
    public void oSistemaDeveAtualziarATabelaFiltrandoPeloUsername() {
        String valorTabela = searchSystemUsersPage.obterUsernameTabela();
        assertEquals(ConfigProperties.USER, valorTabela);
    }
//
//    @When("usuário realiza uma consulta por User Role")
//    public void usuárioRealizaUmaConsultaPorUserRole() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve atualziar a tabela filtrando pelo User Role")
//    public void oSistemaDeveAtualziarATabelaFiltrandoPeloUserRole() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("usuário realiza uma consulta por Employee Name")
//    public void usuárioRealizaUmaConsultaPorEmployeeName() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve atualziar a tabela filtrando pelo Employee Name")
//    public void oSistemaDeveAtualziarATabelaFiltrandoPeloEmployeeName() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("usuário realiza uma consulta por Employee Name não cadastrado")
//    public void usuárioRealizaUmaConsultaPorEmployeeNameNãoCadastrado() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve apresentar a mensagem {string} abaixo do campo")
//    public void oSistemaDeveApresentarAMensagemAbaixoDoCampo(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("usuário realiza uma consulta por Status")
//    public void usuárioRealizaUmaConsultaPorStatus() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve atualziar a tabela filtrando pelo Status")
//    public void oSistemaDeveAtualziarATabelaFiltrandoPeloStatus() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("usuário realiza uma consulta por parâmetros de forma a não trazer resultado")
//    public void usuárioRealizaUmaConsultaPorParâmetrosDeFormaANãoTrazerResultado() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve trazer a tabela vazia")
//    public void oSistemaDeveTrazerATabelaVazia() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("deve apresentar a mensagem {string}")
//    public void deveApresentarAMensagem(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("realiza uma consulta")
//    public void realizaUmaConsulta() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("usuário clica no botão {string}")
//    public void usuárioClicaNoBotão(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("o sistema deve limpar os campos de busca")
//    public void oSistemaDeveLimparOsCamposDeBusca() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("deve atualziar a tabela com todos os resultados")
//    public void deveAtualziarATabelaComTodosOsResultados() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
