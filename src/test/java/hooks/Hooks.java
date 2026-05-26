package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigProperties;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;
    private static final int TIMEOUT_SEGUNDOS = 10;
    private static WebDriverWait wait;

    @Before(order = 1)
    public void inicializarDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SEGUNDOS));
        driver.manage().window().maximize();
    }


    @Before(value = "@login", order = 2)
    public void realizarLogin() {
        if (driver == null) {
            inicializarDriver();
        }
        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarAplicacao();
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
        loginPage.clicarLogin();
        loginPage.aguardarDashboardCarregado();
    }

    @After
    public void encerrarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver  getDriver() {
        return driver;
    }
}