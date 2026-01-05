package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class ProgressBar {
    public static void main(String[] args) {
        // Указываем путь к EdgeDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        // Создаем экземпляр EdgeDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Открываем сайт
            driver.get("http://uitestingplayground.com/progressbar");

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            WebElement start_button = driver.findElement(By.id("startButton"));
            WebElement stop_button = driver.findElement(By.id("stopButton"));
            WebElement progress_bar = driver.findElement(By.cssSelector(".progress-bar.bg-info"));

            start_button.click();
            while (true){
                if (progress_bar.getText().contains("75%")){
                    stop_button.click();
                    break;
                }
                Thread.sleep(100);
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт.");
        }
    }
}
