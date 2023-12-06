package laptopsandnotebooks;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LaptopAndNotebooksTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    //1.2 Click on “Show All Laptops & Notebooks”
    //1.3 Select Sort By "Price (High > Low)"
    //1.4 Verify the Product price will arrange in High to Low order.
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4);
        String actualText = driver.findElement(By.xpath("//div[@class='form-group input-group input-group-sm']/select/option[5]")).getText();
        String expectedText = "Price (High > Low)";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
    //2.2 Click on “Show All Laptops & Notebooks”
    //2.3 Select Sort By "Price (High > Low)"
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4);
        //2.4 Select Product “MacBook”
        //2.5 Verify the text “MacBook”
        driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div/a")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='col-sm-4']/h1")).getText();
        String expectedText = "MacBook";
        Assert.assertEquals(actualText, expectedText);
        //2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualText1 = driver.findElement(By.xpath("//div[@id='product-product']/div[1]")).getText();
        String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualText1, expectedText1);
        //2.8 Click on link “shopping cart” display into success message
        //2.9 Verify the text "Shopping Cart"
        driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]")).click();
        //2.10 Verify the Product name "MacBook"
        String actualText3 = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]/a")).getText();
        String expectedText3 = "MacBook";
        Assert.assertEquals(actualText3, expectedText3);
        //2.11 Change Quantity "2"
        //2.12 Click on “Update” Tab
        WebElement num = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]/div/input"));
        num.clear();
        num.sendKeys("2");
        driver.findElement(By.xpath("//td[@class='text-left']/div/span/button[1]")).click();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualText4 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]")).getText();
        String expectedText4 = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualText4, expectedText4);
        //2.14 Verify the Total £737.45
        String actualText5 = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]")).getText();
        String expectedText5 = "$1,204.00";
        Assert.assertEquals(actualText5, expectedText5);
        //2.15 Click on “Checkout” button
        driver.findElement(By.xpath("//div[@class='buttons clearfix']/div[2]/a")).click();
        //2.16 Verify the text “Checkout”
        String actualText6= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expextedText6 = "Checkout";
        Assert.assertEquals(expextedText6,actualText6);
        Thread.sleep(1000);
        //2.17 Verify the Text “New Customer”
        String actualText7= driver.findElement(By.xpath("//div[@class='row']/div[1]/h2")).getText();
        String expextedText7 = "New Customer";
        Assert.assertEquals(expextedText7,actualText7);
        //2.18 Click on “Guest Checkout” radio button
        //2.19 Click on “Continue” tab
        driver.findElement(By.xpath("//div[@class='row']/div[1]/div[2]/label")).click();
        driver.findElement(By.xpath("//div[@class='row']/div[1]/input")).click();
        //2.20 Fill the mandatory fields
        Thread.sleep(2000);
        WebElement firstName =driver.findElement(By.name("firstname"));
        firstName.sendKeys("zara");
        WebElement lastName =driver.findElement(By.name("lastname"));
        lastName.sendKeys("soni");
       WebElement email =driver.findElement(By.id("input-payment-email"));
        email.sendKeys("soni.zarana@gmai.com");
        WebElement telephone =driver.findElement(By.name("telephone"));
        telephone.sendKeys("447472767113");
        WebElement address1 =driver.findElement(By.name("address_1"));
        address1.sendKeys("Harrow");
        WebElement city =driver.findElement(By.name("city"));
        city.sendKeys("London");
        WebElement postcode =driver.findElement(By.name("postcode"));
        postcode.sendKeys("ha20hl");
        WebElement dropDown1 =driver.findElement(By.id("input-payment-country"));
        Select select1 = new Select(dropDown1);
        select1.equals("United Kingdom");
       WebElement dropdow2 =driver.findElement(By.id("input-payment-zone"));
       Select select2 = new Select(dropdow2);
       select2.selectByValue("3553");
        //2.21 Click on “Continue”Button
       driver.findElement(By.id("button-guest")).click();
       //2.22 Add Comments About your order into text area
        Thread.sleep(1000);
        WebElement comment =driver.findElement(By.name("comment"));
        comment.sendKeys("homework homework homework...");
        //2.23 Check the Terms & Conditions check box
        driver.findElement(By.name("agree")).click();
        //2.24 Click on “Continue” button
        driver.findElement(By.id("button-payment-method")).click();
        //2.25 Verify the message “Warning: Payment method required!”
        String actualText8= driver.findElement(By.xpath("//div[@class='panel-group']/div[3]/div[2]/div/div[1]")).getText();
        //System.out.println(actualText8);
        String expectedText8 = "Warning: No Payment options are available. Please contact us for assistance!";
        Assert.assertEquals(expectedText8,actualText8);

    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
