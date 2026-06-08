package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterfaceElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements {

        @FindBy(xpath = laptop_xpath)
        private static WebElement laptop;

        @FindBy(xpath = sonyVaio_xpath)
        private static WebElement sonyVaio;

        @FindBy(xpath = addToCart_xpath)
        private static WebElement addToCart;

        public SearchPage() {
                PageFactory.initElements(driver, this);
        }


        public static void searchAndAddToCart() throws InterruptedException {

            clickOnElement(laptop);
            Thread.sleep(2000);
            clickOnElement(sonyVaio);
            Thread.sleep(2000);
            clickOnElement(addToCart);
            Thread.sleep(2000);

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Message: " + alertText);
            alert.accept();
        }
}
