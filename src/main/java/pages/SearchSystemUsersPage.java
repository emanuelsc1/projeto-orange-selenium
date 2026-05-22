package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchSystemUsersPage {

    public WebDriver driver;
    private WebDriverWait wait;

    public SearchSystemUsersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By menuAdmin = By.xpath(
            "//span[text()='Admin']");

    private By tituloAdmin = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");

    private By inputUsername = By.xpath(
            "//label[text()='Username']/following::input[1]");

    private By botaoSearch = By.xpath(
            "//button[@type='submit' and normalize-space()='Search']");

    private By colunaUsername = By.xpath("//div[@role='row'][1]/div[@role='cell'][2]//div");

    public void acessarMenuAdmin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuAdmin));
        driver.findElement(menuAdmin).click();
    }

    public void vaidarAcessoTelaAdmin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloAdmin));
    }

    public void informaUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void clicaBotaoSearch() {
        driver.findElement(botaoSearch).click();
    }

    public String obterUsernameTabela() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(colunaUsername));
        return driver.findElement(colunaUsername).getText();
    }


}
