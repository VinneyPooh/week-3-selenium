package myAccount;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountTest extends BaseTest {
    String baseUrl="https://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

   @Test
    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    //1.1 Clickr on My Account Link.
    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    //1.3 Verify the text “Register Account”.
    public void UserShouldNavigateToRegisterPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a")).click();
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/ul/li[1]/a")).click();
       String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
       String expectedText = "Register Account";
       Assert.assertEquals(expectedText,actualText);
   }
   @Test
    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    //2.1 Clickr on My Account Link.
    //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    //2.3 Verify the text “Returning Customer”.
   public void UserShouldNavigateToLoginPageSuccessfully()  {
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a")).click();
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/ul/li[2]/a")).click();
       String actualText = driver.findElement(By.xpath("//div[@class='row']/div[2]/div/h2")).getText();
       String expectedText = "Returning Customer";
       Assert.assertEquals(expectedText,actualText);
   }
   @Test
    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    public void UserRegisterAccountSuccessfully(){
        //3.1 Clickr on My Account Link.
       //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a")).click();
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/ul/li[1]/a")).click();
       //3.3 Enter First Name
       //3.4 Enter Last Name
       //3.5 Enter Email
       //3.6 Enter Telephone
       //3.7 Enter Password
       //3.8 Enter Password Confirm
       WebElement firstname = driver.findElement(By.id("input-firstname"));
       firstname.sendKeys("Zara");
       WebElement lastname = driver.findElement(By.id("input-lastname"));
       lastname.sendKeys("soni");
       WebElement email = driver.findElement(By.id("input-email"));
       email.sendKeys("soni.zarana3.8@gmail.com");
       WebElement telephone = driver.findElement(By.id("input-telephone"));
       telephone.sendKeys("07478967113");
       WebElement password = driver.findElement(By.id("input-password"));
       password.sendKeys("1234567@12");
       WebElement cpassword = driver.findElement(By.id("input-confirm"));
       cpassword.sendKeys("1234567@12");
       //3.9 Select Subscribe Yes radio button
       //3.10 Click on Privacy Policy check box
       //3.11 Click on Continue button
       WebElement rbutton = driver.findElement(By.name("newsletter"));
       rbutton.click();
       WebElement privacy = driver.findElement(By.name("agree"));
       privacy.click();
       driver.findElement(By.xpath("//div[@class='buttons']/div/input[2]")).click();
       //3.12 Verify the message “Your Account Has Been Created!”
       String actualText =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
       String expectedText="Your Account Has Been Created!";
       Assert.assertEquals(expectedText,actualText);
       //3.13 Click on Continue button
       driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
       //3.14 Clickr on My Account Link.
       driver.findElement(By.xpath("//div[@id='content']/h2")).click();
       //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
       //“Logout”
       driver.findElement(By.xpath("//aside[@id='column-right']/div/a[13]")).click();
       //3.16 Verify the text “Account Logout”
       String actualText1 =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
       String expectedText1="Account Logout";
       Assert.assertEquals(expectedText1,actualText1);
       //3.17 Click on Continue button
       driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
   }
   @Test
    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
      // 4.1 Clickr on My Account Link.
      // 4.2 Call the method “selectMyAccountOptions” method and pass the paramete “Login”
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a")).click();
       driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/ul/li[2]/a")).click();
       //4.3 Enter Email address
       WebElement email = driver.findElement(By.id("input-email"));
       email.sendKeys("soni.zarana3.8@gmail.com");
       //4.5 Enter Password
       WebElement password = driver.findElement(By.id("input-password"));
       password.sendKeys("1234567@12");
       //4.6 Click on Login button
       driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input")).click();
       //4.7 Verify text “My Account”
       String expectedTextMyAccount = "My Account";
       String actualTextMyAccount = driver.findElement(By.xpath("//div[@id='content']/h2[text()='My Account']")).getText();
       Assert.assertEquals(expectedTextMyAccount, actualTextMyAccount);
       //4.8 Click on My Account Link.
       driver.findElement(By.xpath("//a[@title='My Account']")).click();
       //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
       driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
       //4.10 Verify the text “Account Logout”
       String expectedTextLogout = "Account Logout";
       String actualTextLogout = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
       Assert.assertEquals(expectedTextLogout, actualTextLogout);
       driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
   }
   @Test
    public void endTest(){
        closeBrowser();
   }
}
