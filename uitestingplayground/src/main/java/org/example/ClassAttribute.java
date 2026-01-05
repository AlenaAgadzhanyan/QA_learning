package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClassAttribute {
    public static void main(String[] args) {
        // Указываем путь к EdgeDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        // Создаем экземпляр EdgeDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Открываем сайт
            driver.get("http://uitestingplayground.com/classattr");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            WebElement button = driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]"));
            button.click();

            System.out.println("Кнопка нажата.");

            // Ждем появления alert
            wait.until(ExpectedConditions.alertIsPresent());

            // Переключаемся на alert
            org.openqa.selenium.Alert alert = driver.switchTo().alert();

            // Нажимаем OK
            alert.accept();
            System.out.println("Alert принят (OK)");

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт.");
        }
    }
}
