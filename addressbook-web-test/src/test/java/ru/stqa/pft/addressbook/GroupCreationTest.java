package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class GroupCreationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        // login
        Login();
    }

    private void Login() {
        submitGroup("user");
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.id("LoginForm")).submit();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://localhost/addressbook/");
        Login();
        gotoGpoupPage("groups");
        submitGroup("new");
        fillGroupForm();
        submitGroup("submit");
        gotoGpoupPage("group page");
        gotoGpoupPage("Logout");
    }

    private void submitGroup(String submit) {
        driver.findElement(By.name(submit)).click();
    }

    private void fillGroupForm() {
        submitGroup("group_name");
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys("babasnyt098");
        submitGroup("group_header");
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys("234r5");
        submitGroup("group_footer");
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys("fqwerf");
    }

    private void gotoGpoupPage(String groups) {
        driver.findElement(By.linkText(groups)).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
