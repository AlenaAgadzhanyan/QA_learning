package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class TextInput {
    public static void main(String[] args) {
        // Указываем путь к EdgeDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        // Создаем экземпляр EdgeDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Открываем сайт
            driver.get("http://uitestingplayground.com/textinput");

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            String input_text = "Alena";
            WebElement input = driver.findElement(By.xpath("//input[@id='newButtonName']"));
            input.sendKeys(input_text);

            WebElement button = driver.findElement((By.id("updatingButton")));
            button.click();

            if (input_text.equals(button.getText())) {
                System.out.println("Кнопка поменяла название");
            };

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт.");
        }
    }
}
