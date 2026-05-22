package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.ConfigProperties;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Before("@login")
    public void realizarLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarAplicacao();
        loginPage.preencherUsuario(ConfigProperties.USER);
        loginPage.preencherSenha(ConfigProperties.PASSWORD);
        loginPage.clicarLogin();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver  getDriver() {
        return driver;
    }
}