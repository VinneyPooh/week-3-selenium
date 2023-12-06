package desktops;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    //1.1 Mouse hover on Desktops Tab.and click
    //1.2 Click on “Show All Desktops”
    //1.3 Select Sort By position "Name: Z to A"
    //1.4 Verify the Product will arrange in Descending order.
    public void verifyProductArrangeInAlphaBaticalOrder() {
        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/a")).click();//desktop
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();//show all desktop
        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        String actualText = driver.findElement(By.xpath("//div[@class='form-group input-group input-group-sm']/select/option[9]")).getText();
        String expectedText = "Model (Z - A)";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    //2.10 Click on link “shopping cart” display into success message
    //2.12 Verify the Product name "HP LP3065"
    //2.13 Verify the Delivery Date "2022-11-30"
    //2.14 Verify the Model "Product21"

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        //2.2 Click on “Show All Desktops”
        //2.3 Select Sort By position "Name: A to Z"

        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();
        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        //2.4 Select product “HP LP3065”
        //2.5 Verify the Text "HP LP3065"
        driver.findElement(By.xpath("//div[@class='row']/div[3]/div/div[1]/a")).click();
        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        String expectedText = "HP LP3065";
        Assert.assertEquals(expectedText, actualText);
        //2.6 Select Delivery Date "2022-11-30"
        //2.7 Enter Qty "1” using Select class.
        //2.8 Click on “Add to Cart” button
        WebElement ddate = driver.findElement(By.id("input-option225"));
        ddate.sendKeys("2024-01-01");
        WebElement quantity = driver.findElement(By.id("input-quantity"));
        quantity.sendKeys("1");
        driver.findElement(By.id("button-cart")).click();
        //2.11 Verify the text "Shopping Cart"
        driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a")).click();
        String actualText1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText1 = "Shopping Cart";
        //2.15 Verify the Totat "£74.73"
        driver.findElement(By.xpath("//div[@class='table-responsive']/table/thead/tr/td[6]")).getText();
        String actualText2 = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]")).getText();
        String expectedText2 = "$1,342.00";
        Assert.assertEquals(actualText2, expectedText2);
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
