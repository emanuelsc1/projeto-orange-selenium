package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DeleteEmpolyeePage;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteEmployeeSteps {

    private WebDriver driver;
    private final DeleteEmpolyeePage deleteEmployeepage;

    public DeleteEmployeeSteps() {
        this.driver = Hooks.getDriver();
        this.deleteEmployeepage = new DeleteEmpolyeePage(driver);
    }

    @Given("que estou logado e na tela de funcionarios")
    public void queEstouLogadoENaTelaDeFuncionarios() {
        deleteEmployeepage.acessarPim();
        deleteEmployeepage.vaidarAcessoTelaPim();
    }

    @When("acesso a tabela com a lista de funcionarios")
    public void acessoATabela() {
        deleteEmployeepage.validaTabelaExibida();
    }

    @And("deleto o funcionario")
    public void deletoOFuncionario() {
        deleteEmployeepage.deletaFuncionario();
    }

    @Then("o funcionario deve ser removido com sucesso")
    public void oFuncionarioDeveSerRemovidoComSucesso() {
        String sucesso = deleteEmployeepage.confirmaFuncionarioDeletado();

        assertTrue(sucesso.contains("Successfully Deleted"),
                "Mensagem esperada não encontrada! Recebido: " + sucesso);

    }
}
