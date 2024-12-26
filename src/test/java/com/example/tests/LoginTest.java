package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/login");

        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        usernameField.sendKeys("practice");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();

        String expectedMessage = "You logged into a secure area!";
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".alert-success"));
        if (welcomeMessage.getText().equals(expectedMessage)) {
            System.out.println("Login test passed!");
        } else {
            System.out.println("Login test failed.");
        }

        driver.quit();
    }
}
