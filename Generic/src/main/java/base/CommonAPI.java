package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    @Parameters({"useCloudEnv","url","browserName"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, String url, @Optional("firefox") String browserName) {

        getLocalDriver(browserName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String browserName){

        if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","../Generic/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "../Generic/drivers/ChromeDriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }


}
