package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Edge Test Case 1: Valid Credentials
        System.out.println("Running Test Case: Valid Credentials");
        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        String expectedMessage = "Logged In Successfully";
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".post-title"));
        if (welcomeMessage.getText().equals(expectedMessage)) {
            System.out.println("Login test with valid credentials passed!");
        } else {
            System.out.println("Login test with valid credentials failed.");
        }

        // Edge Test Case 2: Invalid Credentials
        System.out.println("Running Test Case: Invalid Credentials");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        usernameField = driver.findElement(By.cssSelector("#username"));
        passwordField = driver.findElement(By.cssSelector("#password"));

        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPass");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#error"));
        if (errorMessage.getText().contains("Your username is invalid!")) {
            System.out.println("Login test with invalid credentials passed!");
        } else {
            System.out.println("Login test with invalid credentials failed.");
        }

        // Edge Test Case 3: Empty Fields
        System.out.println("Running Test Case: Empty Fields");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        usernameField = driver.findElement(By.cssSelector("#username"));
        passwordField = driver.findElement(By.cssSelector("#password"));

        usernameField.clear();
        passwordField.clear();
        loginButton.click();

        errorMessage = driver.findElement(By.cssSelector("#error"));
        if (errorMessage.getText().contains("Username must be present")) {
            System.out.println("Login test with empty fields passed!");
        } else {
            System.out.println("Login test with empty fields failed.");
        }

        driver.quit();
    }
}
