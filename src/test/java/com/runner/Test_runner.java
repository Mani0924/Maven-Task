package com.runner;

import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.utility.ReadExcelData.getParticularData;

public class Test_runner {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");

        String youtubeData = ReadExcelData.getYoutubeData(1, 0);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(youtubeData);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Search']")).click();


//        String userName = ReadExcelData.getParticularData(1, 0);
//        driver.findElement(By.name("email")).sendKeys(userName);
//
//        String password = getParticularData(3, 1);
//        driver.findElement(By.name("pass")).sendKeys(password);


    }

}
