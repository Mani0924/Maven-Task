package com.base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;

public abstract class Base_Class {

    // Global Variables

    public static WebDriver driver;
    public static Actions actions;
    public static Robot robot;

    // Browser Launch Methods

    protected static WebDriver launchBrowser(String browserName) {

        try {

            if (browserName.equalsIgnoreCase("chrome")) {

                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("edge")) {

                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {

                driver = new FirefoxDriver();

            }

            actions = new Actions(driver);

            driver.manage().window().maximize();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING BROWSER LAUNCH");

        }

        return driver;

    }


    // URL Launch

    protected static void launchUrl(String url) {

        try {

            driver.get(url);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING URL LAUNCH");

        }

    }

    // Basic WebElement Methods

    protected static void passInput(WebElement element, String value) {

        try {

            element.sendKeys(value);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SENDKEYS");

        }

    }

    protected static void clickOnElement(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING CLICK");

        }

    }

    // Window Handling

    protected static void windowsHandling(int index) {

        try {

            List<String> allWindows = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(allWindows.get(index));

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING WINDOW HANDLING");

        }
    }

    // Dropdown Select

    protected static void selectOptions(WebElement element, String type, String value) {

        try {

            Select select = new Select(element);

            if (type.equalsIgnoreCase("text")) {

                select.selectByVisibleText(value);

            } else if (type.equalsIgnoreCase("value")) {

                select.selectByValue(value);

            } else if (type.equalsIgnoreCase("index")) {

                select.selectByIndex(Integer.parseInt(value));

            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SELECT OPTION");

        }
    }

    protected static void deselectOptions(WebElement element, String type, String value) {

        try {

            Select select = new Select(element);

            if (type.equalsIgnoreCase("text")) {

                select.deselectByVisibleText(value);

            } else if (type.equalsIgnoreCase("value")) {

                select.deselectByValue(value);

            } else if (type.equalsIgnoreCase("index")) {

                select.deselectByIndex(Integer.parseInt(value));

            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING DESELECT OPTION");

        }
    }

    // Browser Close Methods

    protected static void closeBrowser() {

        try {

            driver.close();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING CLOSE");

        }

    }

    protected static void quitBrowser() {

        try {

            driver.quit();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING QUIT");

        }
    }

    // Navigation Methods

    protected static void navigateTo(String url) throws InterruptedException {

        try {

            driver.navigate().to(url);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING NAVIGATION");

        }

        Thread.sleep(5000);

    }

    protected static void navigateBack() throws InterruptedException {

        try {

            driver.navigate().back();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING NAVIGATE BACK");

        }

        Thread.sleep(5000);

    }

    protected static void navigateForward() throws InterruptedException {

        try {

            driver.navigate().forward();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING NAVIGATE FORWARD");

        }

        Thread.sleep(5000);

    }

    protected static void navigateRefresh() throws InterruptedException {

        try {

            driver.navigate().refresh();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING PAGE REFRESH");

        }

        Thread.sleep(5000);

    }

    // Alert Methods

    protected static void simpleAlert() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(2000);
            driver.switchTo().alert().accept();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SIMPLE ALERT");

        }

    }

    protected static void confirmAlert() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING CONFIRM ALERT");

        }
    }

    protected static void promptAlert(String text) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            Thread.sleep(4000);
            alert.accept();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING PROMPT ALERT");

        }
    }

    // Generic Alert Methods

    protected static void acceptAlert() {

        try {

            driver.switchTo().alert().accept();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING ALERT ACCEPT");

        }
    }


    protected static void dismissAlert() {

        try {

            driver.switchTo().alert().dismiss();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING ALERT DISMISS");

        }
    }

    protected static void sendAlertText(String value) {

        try {

            driver.switchTo().alert().sendKeys(value);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING ALERT INPUT");

        }

    }

    // Actions Class Methods

    protected static void click(WebElement element) {

        try {

            actions.click(element).perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING ACTION CLICK");

        }

    }


    protected static void doubleClick(WebElement element) {

        try {

            actions.doubleClick(element).perform();

            driver.switchTo().alert().accept();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING DOUBLE CLICK");

        }

    }

    protected static void rightClick(WebElement element) {

        try {

            actions.contextClick(element).perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING RIGHT CLICK");

        }

    }

    protected static void dragAndDrop(WebElement source, WebElement target) {

        try {

            actions.dragAndDrop(source, target).perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING DRAG AND DROP");

        }

    }

    protected static void clickAndHold(WebElement source, WebElement target) {

        try {

            actions.clickAndHold(source).release(target).perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING CLICK AND HOLD");

        }

    }

    protected static void moveToElement(WebElement element) {

        try {

            actions.moveToElement(element).perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING MOVE TO ELEMENT");

        }

    }

    protected static void release() {

        try {

            actions.release().perform();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING RELEASE");

        }

    }

    // Robot Class Methods

    protected static void pressEnter() {

        try {

            robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING PRESS ENTER");

        }
    }


    // Frame Methods

    protected static void switchToFrame(String type, String value) {

        try {

            if (type.equalsIgnoreCase("index")) {

                driver.switchTo().frame(Integer.parseInt(value));

            } else if (type.equalsIgnoreCase("idOrName")) {

                driver.switchTo().frame(value);

            } else if (type.equalsIgnoreCase("webelement")) {

                WebElement frameElement = driver.findElement(By.xpath(value));

                driver.switchTo().frame(frameElement);

            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING FRAME SWITCH");

        }
    }

    protected static void switchToDefaultContent() {

        try {

            driver.switchTo().defaultContent();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING DEFAULT CONTENT");
        }
    }


    // Dropdown Utility Methods


    protected static void isMultiple(WebElement element) {

        try {

            Select select = new Select(element);

            boolean multiple = select.isMultiple();

            System.out.println("Is dropdown supports multiple selection : " + multiple);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING IS MULTIPLE");
        }
    }

    protected static void getAllOptions(WebElement element) {

        try {

            Select select = new Select(element);

            List<WebElement> allOptions = select.getOptions();

            for (WebElement option : allOptions) {

                System.out.println(option.getText());
            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING GET ALL OPTIONS");
        }
    }

    protected static void getFirstSelectedOption(WebElement element) {

        try {

            Select select = new Select(element);

            WebElement firstSelectedOption = select.getFirstSelectedOption();

            System.out.println("First Selected Option : " + firstSelectedOption.getText());

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING FIRST SELECTED OPTION");
        }
    }

    protected static void getAllSelectedOptions(WebElement element) {

        try {

            Select select = new Select(element);

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            for (WebElement option : selectedOptions) {

                System.out.println(option.getText());
            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING ALL SELECTED OPTIONS");
        }
    }

    protected static void deselectAllOptions(WebElement element) {

        try {

            Select select = new Select(element);

            select.deselectAll();

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING DESELECT ALL");
        }
    }


    // Element Status Methods


    protected static void isSelected(WebElement element) {

        try {

            boolean selected = element.isSelected();

            System.out.println("Is Element Selected : " + selected);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING IS SELECTED");
        }
    }

    protected static void selectCheckBox(WebElement checkBox) {

        try {

            if (!checkBox.isSelected()) {
                checkBox.click();
            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING CHECKBOX HANDLING");
        }
    }

    protected static void isEnabled(WebElement element) {

        try {

            boolean enabled = element.isEnabled();

            System.out.println("Is Element Enabled : " + enabled);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING IS ENABLED");
        }
    }

    protected static void isDisplayed(WebElement element) {

        try {

            boolean displayed = element.isDisplayed();

            System.out.println("Is Element Displayed : " + displayed);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING IS DISPLAYED");
        }
    }


    // Browser Information Methods


    protected static void getTitle() {

        try {

            String title = driver.getTitle();

            System.out.println("Page Title : " + title);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING GET TITLE");
        }
    }

    protected static void getCurrentUrl() {

        try {

            String url = driver.getCurrentUrl();

            System.out.println("Current URL : " + url);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING GET CURRENT URL");
        }
    }

    protected static void getText(WebElement element) {

        try {

            String text = element.getText();

            System.out.println("Element Text : " + text);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING GET TEXT");
        }
    }


    // Screenshot Method

    protected static void takeScreenShot() {

        try {

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("C:\\Users\\NithiMani\\Desktop\\Greens Technology\\MavenProject\\src\\Screenshots" + System.currentTimeMillis() + ".png"));

//            TakesScreenshot ts = (TakesScreenshot) driver;
//
//            File source = ts.getScreenshotAs(OutputType.FILE);
//
//            File destination = new File("C:\\Users\\NithiMani\\Desktop\\Greens Technology\\MavenProject\\src\\Screenshots" + System.currentTimeMillis() + ".png");
//
//            FileHandler.copy(source, destination);
//
//            System.out.println("Screenshot Taken Successfully");

        } catch (Exception e) {

            e.printStackTrace(); // IMPORTANT

            Assert.fail("ERROR : OCCURRED DURING SCREENSHOT");
        }
    }


    // Wait Methods

    protected static void implicitWait(int seconds) {

        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING IMPLICIT WAIT");
        }
    }

    protected static void explicitWait(By locator, int seconds) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING EXPLICIT WAIT");
        }
    }

    protected static void fluentWait(By locator, int timeoutSeconds, int pollingSeconds) {

        try {

            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingSeconds))
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING FLUENT WAIT");
        }
    }


    // Radio Button Method

    protected static void selectRadioButton(WebElement radioButton) {

        try {

            if (!radioButton.isSelected()) {

                radioButton.click();
            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING RADIO BUTTON");
        }
    }

    // JavaScript Executor Methods

    protected static void scrollDown() {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0,500)");

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SCROLL DOWN");
        }
    }

    protected static void scrollUp() {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0,-500)");

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SCROLL UP");
        }
    }

    protected static void scrollIntoView(WebElement element) {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView();", element);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING SCROLL INTO VIEW");
        }
    }

    protected static void jsClick(WebElement element) {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", element);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING JS CLICK");
        }
    }

    protected static void jsPassValue(WebElement element, String value) {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].value='" + value + "';", element);

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURRED DURING JS SENDKEYS");
        }
    }

}
