package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String COOKIE_BUTTON = "//button[2]";
    //public static final String OPEN_REGISTRATION_BUTTON = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String OPEN_REGISTRATION_BUTTON = " //*[text() = 'Utwórz nowe konto']";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String MAIL = "reg_email__";
    public static final String MAIL_CONFIRM = "reg_email_confirmation__";
    public static final String PASSWORD = "reg_passwd__";
    public static final String GENDER = "//label[text() = 'Mê¿czyzna']";
    public static final String SUBMIT = "websubmit";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath(COOKIE_BUTTON)).click();
        driver.findElement(By.xpath(OPEN_REGISTRATION_BUTTON)).click();

        TimeUnit.SECONDS.sleep(1);

        driver.findElement(By.name(FIRSTNAME)).sendKeys("Adam");
        driver.findElement(By.name(LASTNAME)).sendKeys("Nowaak");
        driver.findElement(By.name(MAIL)).sendKeys("adam_nowaak878@gmail.com");
        driver.findElement(By.name(MAIL_CONFIRM)).sendKeys("adam_nowaak878@gmail.com");
        driver.findElement(By.name(PASSWORD)).sendKeys("72y7Uwfo!");

        WebElement selectBirthDay = driver.findElement(By.xpath("//select[@name = 'birthday_day']"));
        Select selectDay = new Select(selectBirthDay);
        selectDay.selectByValue("10");
        WebElement selectBirthMonth = driver.findElement(By.xpath("//select[@name = 'birthday_month']"));
        Select selectMonth = new Select(selectBirthMonth);
        selectMonth.selectByValue("4");
        WebElement selectBirthYear = driver.findElement(By.xpath("//select[@name = 'birthday_year']"));
        Select selectYear = new Select(selectBirthYear);
        selectYear.selectByValue("1990");

        driver.findElement(By.xpath(GENDER)).click();
        driver.findElement(By.name(SUBMIT)).click();
    }
}
