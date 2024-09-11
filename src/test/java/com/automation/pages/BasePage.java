package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofSeconds;

public class BasePage {

    static AppiumDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ofSeconds(30));
    }

    public boolean isPresentWithoutWait(WebElement element) {
        try {
           setImplicitWait(0);
           element.isDisplayed();
            System.out.println("true");
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("false");
            return false;
        }finally {
            setImplicitWait(60);
        }
    }
    public void setImplicitWait(long timeInSeconds)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }
    public boolean isPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }
    public void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(tap));
    }

    public boolean isClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }

    public boolean isElementVisible(WebElement element) {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception i){
            return false;
        }

    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(new Pause(finger,Duration.ofSeconds(1)));
        scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(scroll));
    }

    public void zoom(WebElement element , int zoom) {


        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        int x =element.getLocation().getX()+ width/2;
        int y = element.getLocation().getY()+height/2;
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");


        Sequence zoomInFinger1 = new Sequence(finger1, 1);
        Sequence zoomInFinger2 = new Sequence(finger2, 1);


        zoomInFinger1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x,y));
        zoomInFinger1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        zoomInFinger1.addAction(new Pause(finger1, Duration.ofMillis(100)));
        zoomInFinger1.addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), x+zoom, y+zoom));
        zoomInFinger1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        zoomInFinger2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        zoomInFinger2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        zoomInFinger2.addAction(new Pause(finger2, Duration.ofMillis(100)));
        zoomInFinger2.addAction(finger2.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), x-zoom, y-zoom));
        zoomInFinger2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Arrays.asList(zoomInFinger1, zoomInFinger2));
    }

    private static final String[] DOMAINS = {"example.com", "test.com", "sample.org", "demo.net"};

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static final Random RANDOM = new Random();

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        String username = generateRandomString(7 + RANDOM.nextInt(6));

        String domain = DOMAINS[RANDOM.nextInt(DOMAINS.length)];

        return username + "@" + domain;
    }
}


