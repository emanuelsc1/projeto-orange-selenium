package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AddEmployeePage;

import static org.junit.jupiter.api.Assertions.*;

public class AddEmployeeSteps {

    private WebDriver driver;
    private final AddEmployeePage addEmployeePage;

    public AddEmployeeSteps() {
        this.driver = Hooks.getDriver();
        this.addEmployeePage = new AddEmployeePage(driver);
    }

    @Given("que o usuário acessa o menu PIM")
    public void queOUsuárioAcessaOMenuPIM() {
        addEmployeePage.acessarPim();
        addEmployeePage.vaidarAcessoTelaPim();
    }

    @And("clicar no botão adicionar")
    public void clicarNoBotão() {
        addEmployeePage.clicarAdd();
    }

    @And("preencho o nome do funcionario")
    public void preenchoONomeDoFuncionario() {
        addEmployeePage.preencherNome();
    }

    @And("clica para salvar")
    public void clicaParaSalvar() {
        addEmployeePage.salvar();
    }

    @Then("o funcionario deve ser cadastrado com sucesso")
    public void oFuncionarioDeveSerCadastradoComSucesso() {

        String[] dadosTela = addEmployeePage.funcionarioCadastrado();

        String nomeTela = dadosTela[0];
        String sobrenomeTela = dadosTela[1];

        String nomeEsperado = addEmployeePage.getNomeRandom();
        String sobrenomeEsperado = addEmployeePage.getSobrenomeRandom();

        assertEquals(nomeEsperado, nomeTela);
        assertEquals(sobrenomeEsperado, sobrenomeTela);

    }
}
