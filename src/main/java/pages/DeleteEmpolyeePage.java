package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DeleteEmpolyeePage extends AddEmployeePage {

    public DeleteEmpolyeePage(WebDriver driver) {
            super(driver);

    }

    private By tabela = By.xpath(
            "//div[contains(@class, 'oxd-table orangehrm-employee-list')]");
    private By botaoDelete = By.xpath(
            ".//button[.//i[contains(@class,'bi-trash')]]");
    private By modal = By.xpath(
            "//div[contains(@class,'oxd-dialog-sheet')]");
    private By confirmarDelete = By.xpath(
            "//button[normalize-space()='Yes, Delete']");
    private  By mensagem = By.xpath(
            "//div[contains(@class,'toast') or contains(text(),'Success')]");


    public void validaTabelaExibida() {
        try{
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(tabela));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletaFuncionario() {

        List<WebElement> botoesDelete = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(botaoDelete)
        );
        Random random = new Random();
        WebElement deleteAleatorio = botoesDelete.get(random.nextInt(botoesDelete.size()));
        deleteAleatorio.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        driver.findElement(confirmarDelete).click();

    }

    public String confirmaFuncionarioDeletado() {

        WebElement elemento = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mensagem)
        );
        return elemento.getText();

    }
}