package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteEmpolyeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DeleteEmpolyeePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By menuPim = By.xpath("//span[text()='PIM']");

    public void acessarPim() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuPim));
        driver.findElement(menuPim).click();
    }
}