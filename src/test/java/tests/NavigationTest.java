package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NavigationPage;
import utils.ConfigProperties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest {

    private WebDriver driver;
    private NavigationPage navigationPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        navigationPage = new NavigationPage(driver);

        loginPage.acessarAplicacao();
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
        loginPage.clicarLogin();
        navigationPage.validarPaginaInicial();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deveNavegarParaPerformance() {
        navigationPage.clicarNoMenu("Performance");

        assertTrue(navigationPage.obterTituloModulo().contains("Performance"));
        assertTrue(navigationPage.obterUrlAtual().contains("/performance/"));
    }

    @Test
    public void deveNavegarParaAdmin() {
        navigationPage.clicarNoMenu("Admin");

        assertTrue(navigationPage.obterTituloModulo().contains("Admin"));
        assertTrue(navigationPage.obterUrlAtual().contains("/admin/"));
    }
}

