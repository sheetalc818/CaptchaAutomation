package com.bridgelabz.irctc.test;

import com.bridgelabz.irctc.base.BaseClass;
import com.bridgelabz.irctc.pages.Login;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

//https://medium.com/quantrium-tech/installing-and-using-tesseract-4-on-windows-10-4f7930313f82

public class LoginTest extends BaseClass {

    @BeforeTest
    public void init() {
        setUp();
    }

    @Test
    public void NewUser_Registration() throws InterruptedException, IOException, TesseractException {
        Login login = new Login(driver);
        login.captchAutomation();
    }
}
