package com.bridgelabz.irctc.pages;

import com.bridgelabz.irctc.base.BaseClass;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Login {
    WebDriver driver;

    @FindBy (xpath = "//a[@aria-label='Click here to Login in application']")
    WebElement clickLoginBtn;

    @FindBy(xpath = "//input[@placeholder='User Name']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[1]/app-captcha[1]/div[1]/div[1]/div[2]/span[1]/img[1]")
    WebElement captchaImg;

    @FindBy (id = "captcha")
    WebElement enterCaptchaBox;

    @FindBy (xpath = "//button[contains(text(),'SIGN IN')]")
    WebElement signInClick;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void captchAutomation() throws InterruptedException, IOException, TesseractException {
        //driver.findElement(By.xpath("//button[text()='OK']")).click();
        clickLoginBtn.click();
        usernameField.sendKeys("Enter username");
        passwordField.sendKeys("Enter password");
        Thread.sleep(3000);

        File src = captchaImg.getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\dell\\Documents\\QADevPrograms\\IRCTC_Captcha\\CaptchaScreenshot\\captcha.png";
        FileHandler.copy(src, new File(path));
        Tesseract img = new Tesseract();
        img.setDatapath("D:\\Tesseract-OCR\\tessdata");
        String str = img.doOCR(new File(path));
        System.out.println(str);

        enterCaptchaBox.sendKeys(str);
        Thread.sleep(3000);
        //signInClick.click();
    }
}
