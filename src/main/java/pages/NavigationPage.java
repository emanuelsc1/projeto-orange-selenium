package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By tituloDashboard = By.xpath("//h6[normalize-space()='Dashboard']");
    private final By tituloModulo = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void validarPaginaInicial() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloDashboard));
    }

    public void clicarNoMenu(String menu) {
        By menuLateral = By.xpath("//span[normalize-space()='" + menu + "']");
        wait.until(ExpectedConditions.elementToBeClickable(menuLateral)).click();
    }

    public String obterTituloModulo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tituloModulo)).getText();
    }

    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }
}

