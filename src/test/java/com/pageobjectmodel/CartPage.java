package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.CartPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Base_Class implements CartPageInterfaceElements {

    @FindBy(xpath = cartlink_xpath)
    private static WebElement cartLink;

    @FindBy(xpath = placeorder_xpath)
    private static WebElement placeOrderButton;

    @FindBy(id = name_id)
    private static WebElement nameInput;

    @FindBy(id = country_id)
    private static WebElement countryInput;

    @FindBy (id = city_id)
    private static WebElement cityInput;

    @FindBy(id = card_id)
    private static WebElement cardInput;

    @FindBy(id = month_id)
    private static WebElement monthInput;

    @FindBy(id = year_id)
    private static WebElement yearInput;

    @FindBy(xpath = purchaseButton_xpath)
    private static WebElement purchaseButton;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
    private static WebElement purchasePopup;

    public CartPage() {

        PageFactory.initElements(driver, this);
    }

    public static void navigateToCart() throws InterruptedException {
        clickOnElement(cartLink);
        Thread.sleep(2000);
        takeScreenShot();
        clickOnElement(placeOrderButton);
        Thread.sleep(2000);
        passInput(nameInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("name"));
        passInput(countryInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("country"));
        passInput(cityInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("city"));
        passInput(cardInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("card"));
        passInput(monthInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("month"));
        passInput(yearInput, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("year"));
        Thread.sleep(2000);
        clickOnElement(purchaseButton);
        Thread.sleep(2000);
        takeScreenShot();

        System.out.println("Purchase Confirmation Details:");
        String popupText = purchasePopup.getText();
        System.out.println(popupText);


    }


}


