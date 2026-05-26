package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilString;

import java.time.Duration;

public class AddEmployeePage {

    public WebDriver driver;
    public WebDriverWait wait;

    private String nomeRandom;
    private String sobrenomeRandom;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected By menuPim = By.xpath("//span[normalize-space()='PIM']");
    protected By tituloPim = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");
    private By btnAdd = By.xpath("//button[normalize-space()='Add']");
    private By btnSave = By.xpath("//button[normalize-space()='Save']");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By personalDetails = By.xpath(
            "//h6[contains(@class,'orangehrm-main-title') " +
                    "and normalize-space()='Personal Details']");
    private By firstNameDetails = By.name("firstName");
    private By lastNameDetails = By.name("lastName");


    public void acessarPim() {
        wait.until(ExpectedConditions.elementToBeClickable(menuPim)).click();
    }

    public void vaidarAcessoTelaPim() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloPim));
    }

    public void clicarAdd() {
        driver.findElement(btnAdd).click();
    }

    public void preencherNome() {

        try {

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(firstName));
            nomeRandom = UtilString.gerarTextoAleatorio(6);
            sobrenomeRandom = UtilString.gerarTextoAleatorio(8);
            driver.findElement(firstName).sendKeys(nomeRandom);
            driver.findElement(lastName).sendKeys(sobrenomeRandom);

        } catch (InterruptedException e) {

            throw new RuntimeException("Falha ao preencher nome do funcionário", e);

        }

    }

    public void salvar() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
    }

    public String[] funcionarioCadastrado() {
        WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(personalDetails));

        String nomeDetail = waitLong.until(d -> obterValorCampo(firstNameDetails));
        String sobrenomeDetail = waitLong.until(d -> obterValorCampo(lastNameDetails));

        return new String[]{nomeDetail, sobrenomeDetail};
    }

    private String obterValorCampo(By locator) {
        WebElement campo = driver.findElement(locator);

        String valor = campo.getDomProperty("value");
        if (valor == null || valor.isBlank()) {
            valor = campo.getAttribute("value");
        }

        return (valor == null || valor.isBlank()) ? null : valor;
    }

    public String getNomeRandom() {
        return nomeRandom;
    }

    public String getSobrenomeRandom() {
        return sobrenomeRandom;
    }


}