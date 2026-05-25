package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilString;

import java.time.Duration;

public class AddEmployeePage {

    public WebDriver driver;
    private WebDriverWait wait;

    private String nomeRandom;
    private String sobrenomeRandom;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By menuPim = By.xpath("//span[text()='PIM']");
    private By tituloPim = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuPim));
        driver.findElement(menuPim).click();
    }

    public void vaidarAcessoTelaPim() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloPim));
    }

    public void clicarAdd() {
        driver.findElement(btnAdd).click();
    }

    public void preencherNome() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        nomeRandom = UtilString.gerarTextoAleatorio(6);
        sobrenomeRandom = UtilString.gerarTextoAleatorio(8);

        driver.findElement(firstName).sendKeys(nomeRandom);
        driver.findElement(lastName).sendKeys(sobrenomeRandom);
    }

    public void salvar() {
        driver.findElement(btnSave).click();
    }

    public String[] funcionarioCadastrado() {
        WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails));

        String nomeDetail = driver.findElement(firstNameDetails).getDomAttribute("value");
        String sobrenomeDetail = driver.findElement(lastNameDetails).getDomAttribute("value");

        return new String[]{nomeDetail, sobrenomeDetail};
    }

    public String getNomeRandom() {
        return nomeRandom;
    }

    public String getSobrenomeRandom() {
        return sobrenomeRandom;
    }


}