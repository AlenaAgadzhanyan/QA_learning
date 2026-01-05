package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicID {
    public static void main(String[] args) {
        // Указываем путь к EdgeDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        // Создаем экземпляр EdgeDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Открываем сайт
            driver.get("http://uitestingplayground.com/dynamicid");

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-primary')]"));
            button.click();

            System.out.println("Кнопка нажата.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт.");
        }
    }
}