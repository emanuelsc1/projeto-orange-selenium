package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.ConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        loginPage.acessarAplicacao();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deveRealizarLoginValido() {
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
        loginPage.clicarLogin();

        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void deveExibirErroLoginInvalido() {
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha("senhaErrada");
        loginPage.clicarLogin();

        String erro = loginPage.obterMensagemErro();

        System.out.println("Erro exibido: " + erro);

        assertEquals("Invalid credentials", erro);
    }
}
