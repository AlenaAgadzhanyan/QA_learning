package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicTable {
    public static void main(String[] args) {
        // Указываем путь к EdgeDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        // Создаем экземпляр EdgeDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Открываем сайт
            driver.get("http://uitestingplayground.com/dynamictable");

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            WebElement cpu = driver.findElement(By.xpath("//span[contains(text(), 'Chrome')]/../*[contains(text(), '%')]"));

            WebElement cpu_yellow_line = driver.findElement(By.className("bg-warning"));

            if (cpu_yellow_line.getText().contains(cpu.getText())) {
                System.out.println("Значения совпали");
                System.out.println(cpu.getText());
            }
            else {
                System.out.println("Упс. Значения не совпали");
                System.out.println(cpu.getText());
                System.out.println(cpu_yellow_line.getText());
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
