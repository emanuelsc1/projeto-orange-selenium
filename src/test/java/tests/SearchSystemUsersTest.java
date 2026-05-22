package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SearchSystemUsersPage;
import utils.ConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

public class SearchSystemUsersTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private SearchSystemUsersPage searchPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        searchPage = new SearchSystemUsersPage(driver);

        loginPage.acessarAplicacao();
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
        loginPage.clicarLogin();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deveBuscarUsuarioPorUsername() {

        searchPage.acessarMenuAdmin();
        searchPage.vaidarAcessoTelaAdmin();

        searchPage.informaUsername(ConfigProperties.USER);
        searchPage.clicaBotaoSearch();

        String resultado = searchPage.obterUsernameTabela();

        System.out.println("Resultado da busca: " + resultado);

        assertEquals(ConfigProperties.USER, resultado);
    }
}