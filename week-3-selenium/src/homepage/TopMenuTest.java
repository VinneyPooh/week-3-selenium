package homepage;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    //string
    public void selectMenu(String menu) {
        //1.2 This method should click on the menu whatever name is passed as parameter.
        WebElement desktop = driver.findElement(By.name(menu));
        desktop.click();
    }

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
//1.1 Mouse hover on “Desktops” Tab and click
//1.2 call selectMenu method and pass the menu = “Show All Desktops”
// 1.3 Verify the text ‘Desktops’
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        String expectedTest = "Desktops";
        Assert.assertEquals(actualText, expectedTest);
    }

    @Test
    // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    // 2.3 Verify the text ‘Laptops & Notebooks’
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        String expectedTest = "Laptops & Notebooks";
        Assert.assertEquals(actualText, expectedTest);
    }
    @Test
   //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    // 3.1 Mouse hover on “Components” Tab and click
    // 3.2 call selectMenu method and pass the menu = “Show All Components”
    // 3.3 Verify the text ‘Components’
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']/div/a")).click();

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        String expectedTest = "Components";
        Assert.assertEquals(actualText, expectedTest);
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
