package SampleTest;

import Methods.CommonMethods;
import org.testng.annotations.Test;

public class ClickDifferentOnButtons extends CommonMethods {

    @Test
    public void clickOnYourAmazon(){
        clickByXpath(".//*[@id='nav-your-amazon']");
    }

    @Test
    public void clickOnTodaysDeals(){
        clickByXpath(".//*[@id='nav-xshop']/a[2]");
    }

//    @Test
//    public void anothermethod
}
