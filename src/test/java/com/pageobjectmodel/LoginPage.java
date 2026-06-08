package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

    @FindBy(linkText = linkText_login)
    private static WebElement loginlink;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(css = password_css)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    @FindBy(id = title_id)
    private static WebElement title;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }



    public static void validLogin() throws InterruptedException {

        clickOnElement(loginlink);
        Thread.sleep(2000);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
        Thread.sleep(2000);
        clickOnElement(signin);
        Thread.sleep(4000);
        // retrieve/print the title text (getText in Base_Class is void and handles output)
        getText(title);

    }


}
