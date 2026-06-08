package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test_Class extends Base_Class {

    public static void main(String[] args) throws InterruptedException {

        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().searchAndAddToCart();
        PageObjectManager.getPageObjectManager().getCartPage().navigateToCart();
        launchBrowser("chrome");
        // =====================================================
        // Browser Launch & URL Launch
        // =====================================================

        launchBrowser("chrome");

      //  launchUrl("https://www.google.com");

        // =====================================================
        // Get Title & Current URL
        // =====================================================

        //  getTitle();
        //  getCurrentUrl();

        // =====================================================
        // SendKeys & Click
        // =====================================================

//        WebElement searchBox = driver.findElement(By.name("q"));
//        //passInput(searchBox, "Selenium");
//        searchBox.sendKeys("Rose");
//        pressEnter();
//
//        Thread.sleep(2000);

        // =====================================================
        // Navigation
        // =====================================================

//        navigateTo("https://www.amazon.in");
//        navigateBack();
//        navigateForward();
//        navigateRefresh();

        // =====================================================
        // Alert
        // =====================================================

//        launchUrl("https://letcode.in/alert");

//        WebElement simpleAlertBtn = driver.findElement(By.id("accept"));
//        simpleAlertBtn.click();
//        simpleAlert();

//        WebElement confirmAlertBtn = driver.findElement(By.id("confirm"));
//        confirmAlertBtn.click();
//        confirmAlert();

//        WebElement promptAlertBtn = driver.findElement(By.id("prompt"));
//        promptAlertBtn.click();
//        promptAlert("Mani");


        // =====================================================
        // Actions
        // =====================================================

//        launchUrl("https://omayo.blogspot.com/");
//
//        WebElement blogMenu = driver.findElement(By.id("blogsmenu"));
//
//        click(blogMenu);
//
//        moveToElement(blogMenu);

        // =====================================================
        // Right Click
        // =====================================================

//        launchUrl("https://www.amazon.in");
//        Thread.sleep(3000);
//        WebElement electronics = driver.findElement(By.xpath("//a[contains(text(),'Electronics')]"));
//        rightClick(electronics);

        // =====================================================
        // Drag And Drop
        // =====================================================

//        launchUrl("https://the-internet.herokuapp.com/drag_and_drop");
//
//        WebElement colA = driver.findElement(By.id("column-a"));
//
//        WebElement colB = driver.findElement(By.id("column-b"));
//
//        dragAndDrop(colA, colB);

        // =====================================================
        // Frames
        // =====================================================

//        launchUrl("https://letcode.in/frame");
//
//        //switchToFrame("idOrName", "firstFr");
//        driver.switchTo().frame("firstFr");
//
//        switchToDefaultContent();

        // =====================================================
        // Dropdown
        // =====================================================

//        launchUrl("https://letcode.in/dropdowns");
//
//        WebElement fruits = driver.findElement(By.id("fruits"));
//
//        selectOptions(fruits, "index", "1");
//
//        getAllOptions(fruits);
//
//        getFirstSelectedOption(fruits);
//
//        isMultiple(fruits);

        // =====================================================
        // Is Displayed / Enabled / Selected
        // =====================================================

//        launchUrl("https://www.amazon.in");
//
//        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
//
//        isDisplayed(searchBar);
//        isEnabled(searchBar);

        // =====================================================
        // Radio Button
        // =====================================================

//        WebElement radioButton = driver.findElement(By.id("example"));
//
//        selectRadioButton(radioButton);

        // =====================================================
        // Waits
        // =====================================================

//        implicitWait(10);
//
//        explicitWait(By.id("twotabsearchtextbox"), 10);
//
//        fluentWait(By.id("twotabsearchtextbox"), 20, 2);

        // =====================================================
        // JavaScript Executor
        // =====================================================

//        scrollDown();
//
//        scrollUp();
//
//        jsPassValue(driver.findElement(By.name("q")), "Selenium");
//
//        jsClick(driver.findElement(By.name("btnK")));

        // =====================================================
        // Screenshot
        // =====================================================

       // takeScreenShot();

        // =====================================================
        // Close Browser
        // =====================================================

//        closeBrowser();

        // =====================================================
        // Quit Browser
        // =====================================================

//        quitBrowser();


    }
}
























//========================================================================
//launchBrowser("chrome");
//launchUrl("https://www.amazon.in");
//        Thread.sleep(5000);
//getTitle();
//getCurrentUrl();
//
//scrollDown();
//        Thread.sleep(3000);
//scrollUp();
//
//takeScreenShot();
//
//quitBrowser();
//========================================================================
