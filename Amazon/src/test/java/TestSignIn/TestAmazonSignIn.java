package TestSignIn;

import Methods.CommonMethods;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestAmazonSignIn extends CommonMethods {

    @Test
    public void SignIn(){
        clickByCss("#nav-link-accountList");

        driver.findElement(By.cssSelector("#ap_email")).sendKeys(AmazonUserName);
        driver.findElement(By.cssSelector("#ap_password")).sendKeys(AmazonPassword);
        driver.findElement(By.cssSelector("#signInSubmit")).click();
    }
}
