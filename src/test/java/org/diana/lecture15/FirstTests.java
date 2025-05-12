package org.diana.lecture15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FirstTests {

    @Test
    public void registerTest() throws InterruptedException {

        //REGISTER PAGE URL
        String REGISTER_PAGE_URL = "http://training.skillo-bg.com:4300/users/register";

        //ELEMENT SELECTORS
        String USERNAME_INPUT_FIELD_XPATH = "//input[contains(@name, \"username\")]";
        String EMAIL_INPUT_FIELD_XPATH = "//input[contains(@type, \"email\")]";
        String BIRTH_DATE_INPUT_XPATH = "//input[contains(@formcontrolname, \"birthDate\")]";
        String PASSOWORD_INPUT_FIELD_CSS = "#defaultRegisterFormPassword";
        String CONFIRM_PASS_INPUT_CSS = "#defaultRegisterPhonePassword";
        String INFO_INPUT_XPATH = "//textarea";
        String SIGN_IN_BUTTON_CSS = "#sign-in-button";
        //When logged in
        String NEW_POST_BUTTON_CSS = "#nav-link-new-post";

        WebDriver driver = new ChromeDriver();
        driver.get(REGISTER_PAGE_URL);

        Thread.sleep(3000);

        //USERNAME
        WebElement usernameInput = driver.findElement(By.xpath(USERNAME_INPUT_FIELD_XPATH));
        usernameInput.click();
        Thread.sleep(1000);

        usernameInput.clear();
        Thread.sleep(1000);

        //Get current date time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedDateTime = now.format(formatter);
        //Random username with current date time
        String username = "DemoUser" + formattedDateTime;

        usernameInput.sendKeys(username);
        Thread.sleep(1000);

        //EMAIL
        WebElement emailInput = driver.findElement(By.xpath(EMAIL_INPUT_FIELD_XPATH));

        emailInput.click();
        Thread.sleep(1000);

        emailInput.clear();
        Thread.sleep(1000);

        //Random email with current time
        String email = "demo" + formattedDateTime + "@gmail.com";

        emailInput.sendKeys(email);
        Thread.sleep(1000);

        //BIRTH DATE
        WebElement birthdayInput = driver.findElement(By.xpath(BIRTH_DATE_INPUT_XPATH));

        birthdayInput.click();
        Thread.sleep(1000);

        birthdayInput.clear();
        Thread.sleep(1000);

        birthdayInput.sendKeys("04242002");
        Thread.sleep(1000);

        //PASSWORD
        WebElement passInput = driver.findElement(By.cssSelector(PASSOWORD_INPUT_FIELD_CSS));

        passInput.click();
        Thread.sleep(1000);

        passInput.clear();
        Thread.sleep(1000);

        String pass = "Demo123456";
        passInput.sendKeys(pass);
        Thread.sleep(1000);

        //CONFIRM PASSWORD
        WebElement confirmPassInput = driver.findElement(By.cssSelector(CONFIRM_PASS_INPUT_CSS));

        confirmPassInput.click();
        Thread.sleep(1000);

        confirmPassInput.clear();
        Thread.sleep(1000);

        confirmPassInput.sendKeys(pass);
        Thread.sleep(1000);

        //PUBLIC INFO
        WebElement infoInput = driver.findElement(By.xpath(INFO_INPUT_XPATH));

        infoInput.click();
        Thread.sleep(1000);

        infoInput.clear();
        Thread.sleep(1000);

        infoInput.sendKeys("Hello!");
        Thread.sleep(1000);

        //CLICK SIGN IN BUTTON
        WebElement signInButton = driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS));

        signInButton.click();
        Thread.sleep(1000);

        //ASSERT - CHECK IF NEW POST BUTTON APPEARS
        WebElement newPost = driver.findElement(By.cssSelector(NEW_POST_BUTTON_CSS));

        Assert.assertTrue(newPost.isDisplayed(), "User is not registered");

        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
        //Login link
        String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

        //ELEMENT SELECTORS
        String USERNAME_INPUT_CSS = "#defaultLoginFormUsername";
        String PASS_INPUT_CSS = "#defaultLoginFormPassword";
        String SIGN_IN_BTN_CSS = "#sign-in-button";
        //When logged in
        String PROFILE_BTN_CSS = "#nav-link-profile";

        //Credentials
        String username = "didkaTest";
        String pass = "12345678D";

        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
        Thread.sleep(3000);

        WebElement usernameInput = driver.findElement(By.cssSelector(USERNAME_INPUT_CSS));
        usernameInput.click();
        Thread.sleep(1000);

        usernameInput.clear();
        Thread.sleep(1000);

        usernameInput.sendKeys(username);
        Thread.sleep(1000);

        WebElement passInput = driver.findElement(By.cssSelector(PASS_INPUT_CSS));
        passInput.click();
        Thread.sleep(1000);

        passInput.clear();
        Thread.sleep(1000);

        passInput.sendKeys(pass);
        Thread.sleep(1000);

        WebElement signInButton = driver.findElement(By.cssSelector(SIGN_IN_BTN_CSS));
        signInButton.click();
        Thread.sleep(1000);

        WebElement profileButton = driver.findElement(By.cssSelector(PROFILE_BTN_CSS));
        Assert.assertTrue(profileButton.isDisplayed(), "User is not logged in");
        Thread.sleep(1000);

        driver.quit();
    }
}
