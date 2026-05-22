package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//div[contains(@class,'oxd-alert--error')]//p[contains(@class,'oxd-alert-content-text')]");

    public void acessarAplicacao() {
        driver.get(ConfigProperties.BASE_URL);
    }

    public void preencherUsuario(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }

    public void preencherSenha(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clicarLogin() {
        driver.findElement(loginButton).click();
    }

    public String obterMensagemErro() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ).getText();

    }
}